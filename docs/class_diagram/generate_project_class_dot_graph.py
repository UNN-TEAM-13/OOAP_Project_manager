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

    subgraphs = {'model' : {'nodes': [], 'label': 'model'},
                 'presenter': {'nodes': [], 'label': 'presenter'},
                 'view': {'nodes': [], 'label': 'view'},
                 'dal': {'nodes': [], 'label': 'DAL'}}

    for class_ in classes:
        node = {'name': class_['name'], 'properties': {'label': class_['name'].replace('ru.unn.ooap.projectmanager.', ''), 'shape': 'box', 'color': 'blue'}}
        subgraphs[class_['name'].replace('ru.unn.ooap.projectmanager.', '').split('.')[1]]['nodes'].append(node)
    for interface_ in interfaces:
        node = {'name': interface_['name'], 'properties': {'label': interface_['name'].replace('ru.unn.ooap.projectmanager.', ''), 'shape': 'box', 'color': 'green'}}
        subgraphs[interface_['name'].replace('ru.unn.ooap.projectmanager.', '').split('.')[1]]['nodes'].append(node)

    classnames = [class_['name'] for class_ in classes]
    interfacenames = [interface_['name'] for interface_ in interfaces]

    edges = []
    for class_ in classes:
        for base_class in class_['extends']:
            if base_class in classnames:
                edges.append({'nodes': [class_['name'], base_class], 'properties': {'arrowhead': 'empty'}})
        for base_interface in class_['implements']:
            if base_interface in interfacenames:
                edges.append({'nodes': [class_['name'], base_interface], 'properties': {'arrowhead': 'empty', 'style': 'dashed'}})
        for used in class_['uses']:
            if used in classnames + interfacenames:
                edges.append({'nodes': [class_['name'], used], 'properties': {'arrowhead': 'open'}})
    for interface_ in interfaces:
        for base_interface in interface_['extends']:
            if base_interface in interfacenames:
                edges.append({'nodes': [interface_['name'], base_interface], 'properties': {'arrowhead': 'empty'}})
        for used in interface_['uses']:
            if used in classnames + interfacenames:
                edges.append({'nodes': [interface_['name'], used], 'properties': {'arrowhead': 'open'}})

    lines = []
    lines.append('strict digraph Dependencies {')
    lines.append('overlap = false;')

    for subgraph in subgraphs.keys():
        cluster = subgraphs[subgraph]
        lines.append('subgraph cluster_{} '.format(subgraph) + '{')
        lines.append('label = ' + cluster['label'] + ';')
        for node in cluster['nodes']:
            properties = []
            for property in node['properties']:
                properties.append('{}="{}"'.format(property, node['properties'][property]))
            lines.append('"{}" [{}];'.format(node['name'], ' '.join(properties)))
        lines.append('}')

    for edge in edges:
        properties = []
        for property in edge['properties']:
            properties.append('{}="{}"'.format(property, edge['properties'][property]))
        properties = ' '.join(properties)
        lines.append('"{}" -> "{}" [{}];'.format(edge['nodes'][0], edge['nodes'][1], properties))

    lines.append('}')

    with open('pms_cd.gv', 'w', encoding='utf8') as file:
        for line in lines:
            file.write(line);
            file.write('\n');