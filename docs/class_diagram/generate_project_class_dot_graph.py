import os
import re

def process_java_file(file):
    with open(file, encoding="utf8") as file:
        content = file.read()
        
    java_data = {'package': None, 'imports': [], 'classes': [], 'interfaces': []}
    
    lines = content.split('\n')
    in_class = False
    for line in lines:
        if line.startswith("package "):
            package_statement = line.split(';')[0]
            java_data["package"] = package_statement.replace("package ", '');
        elif line.startswith('import '):
            java_data["imports"].append(line.replace('import ', '').replace(';', ''));
        elif re.fullmatch('^.*class.*{$', line) and not in_class:
            new_class = {'extends': [], 'implements': [], 'uses': [], 'name': None}
            java_data['classes'].append(new_class)
            tokens = line.split()
            new_class['name'] = java_data["package"] + '.' + tokens[tokens.index('class') + 1]
            if 'extends' in tokens:
                base_class_index = tokens.index('extends') + 1
                while not base_class_index is None:
                    if tokens[base_class_index].endswith(','):
                        new_class['extends'].append(tokens[base_class_index][:-1])
                        base_class_index += 1
                    else:
                        new_class['extends'].append(tokens[base_class_index])
                        base_class_index = None
            if 'implements' in tokens:
                base_interface_index = tokens.index('implements') + 1
                while not base_interface_index is None:
                    if tokens[base_interface_index].endswith(','):
                        new_class['implements'].append(tokens[base_interface_index][:-1])
                        base_interface_index += 1
                    else:
                        new_class['implements'].append(tokens[base_interface_index])
                        base_interface_index = None
            for i in range(len(new_class['implements'])):
                if not '.' in new_class['implements'][i]:
                    for imported in java_data['imports']:
                        if imported.split('.')[-1] == new_class['implements'][i]:
                            new_class['implements'][i] = imported
            for i in range(len(new_class['extends'])):
                if not '.' in new_class['extends'][i]:
                    for imported in java_data['imports']:
                        if imported.split('.')[-1] == new_class['extends'][i]:
                            new_class['extends'][i] = imported
            in_class = new_class
        elif re.fullmatch('^.*interface.*{$', line) and not in_class:
            new_class = {'extends': [], 'uses': [], 'name': None}
            java_data['interfaces'].append(new_class)
            tokens = line.split()
            new_class['name'] = java_data["package"] + '.' + tokens[tokens.index('interface') + 1]
            if 'extends' in tokens:
                base_class_index = tokens.index('extends') + 1
                while not base_class_index is None:
                    if tokens[base_class_index].endswith(','):
                        new_class['extends'].append(tokens[base_class_index][:-1])
                        base_class_index += 1
                    else:
                        new_class['extends'].append(tokens[base_class_index])
                        base_class_index = None
            for i in range(len(new_class['extends'])):
                if not '.' in new_class['extends'][i]:
                    for imported in java_data['imports']:
                        if imported.split('.')[-1] == new_class['extends'][i]:
                            new_class['extends'][i] = imported
            in_class = new_class
        elif in_class:
            class_ = in_class
            tokens = line.replace('(', ' ').replace(')', ' ').split()
            for token in tokens:
                if token[:1].isupper():
                    for imported in java_data['imports']:
                        if imported.split('.')[-1] == token:
                            class_['uses'].append(imported)
                            break;
                    else:
                        class_['uses'].append(java_data['package'] + '.' + token)
                        
            # TODO: process classes composition
    return java_data
    

if __name__ == "__main__":    
    project_path = os.path.abspath(os.path.join(os.path.dirname(__file__), '../../code'))
    
    classes = []
    interfaces = []
    
    for dirpath, dirnames, filenames in os.walk(project_path):
        for filename in filenames:
            if filename.endswith('.java'):
                java_data = process_java_file(os.path.join(dirpath, filename))
                interfaces += java_data['interfaces']
                classes += java_data['classes']
    
    classnames = [class_['name'] for class_ in classes]
    interfacenames = [interface_['name'] for interface_ in interfaces]
    
    lines = []
    lines.append('strict digraph dependencies {')
    lines.append('overlap = false;')
    
    classnames = [class_['name'] for class_ in classes]
    interfacenames = [interface_['name'] for interface_ in interfaces]
    
    for class_ in classes:
        lines.append('"{}" [shape=box color=blue label="{}"];'.format(class_['name'], class_['name'].replace('ru.unn.ooap.projectmanager.', '')))
        for base_class in class_['extends']:
            if base_class in classnames:
                lines.append('"{}" -> "{}" [arrowhead=empty];'.format(class_['name'], base_class))
        for base_interface in class_['implements']:
            if base_interface in interfacenames:
                lines.append('"{}" -> "{}" [arrowhead=empty  style=dashed];'.format(class_['name'], base_interface))
        for used in class_['uses']:
            if used in interfacenames:
                lines.append('"{}" -> "{}" [arrowhead=open];'.format(class_['name'], used))
            if used in classnames:
                lines.append('"{}" -> "{}" [arrowhead=open];'.format(class_['name'], used))
    for interface_ in interfaces:
        lines.append('"{}" [shape=box color=green label="{}"];'.format(interface_['name'], interface_['name'].replace('ru.unn.ooap.projectmanager.', '')))
        for base_interface in interface_['extends']:
            if base_interface in interfacenames:
                lines.append('"{}" -> "{}" [arrowhead=empty];'.format(interface_['name'], base_interface))
        for used in interface_['uses']:
            if used in interfacenames:
                lines.append('"{}" -> "{}" [arrowhead=open];'.format(interface_['name'], used))
            if used in classnames:
                lines.append('"{}" -> "{}" [arrowhead=open];'.format(interface_['name'], used))
    lines.append('}')
    
    with open('pms_cd.gv', 'w', encoding='utf8') as file:
        for line in lines:
            file.write(line);
            file.write('\n');