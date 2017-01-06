package ru.unn.ooap.projectmanager.server.model.users.executor;

import ru.unn.ooap.projectmanager.server.model.users.User;

import java.util.List;

public class Executor extends User implements IExecutor {
    public List<ITask> getTasks() {
        /*
        Варианты:
        1. Прямо тут обращаемся к проектам,
           перебираем все таски всех проектов,
           сохраняя в список те, которые заассигнены на this.
        2. Создаём синглтон Tasks, предоставляющий функциональность, похожую на Projects/Users.
           В данном методе вызываем Tasks.get(this), получая таким образом нужные таски.

        С точки зрения Лебедева и использования за всем этим SQL-схемы лучше, наверное, использовать
        второй вариант. С точки зрения
         */
        return null;
    }
}
