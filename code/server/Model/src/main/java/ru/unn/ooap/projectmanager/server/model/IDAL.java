package ru.unn.ooap.projectmanager.server.model;

import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.projects.Projects;
import ru.unn.ooap.projectmanager.server.model.tasks.Tasks;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

public interface IDAL {
    void sync(Project project);
    void sync(Projects projects);
    void sync(Task task);
    void sync(Tasks tasks);
    void sync(User user);
    void sync(Users users);
    void sync(Administrator admin);
    void sync(Manager manager);
    void sync(Executor executor);
}
