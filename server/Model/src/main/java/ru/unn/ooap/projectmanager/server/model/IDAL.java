package ru.unn.ooap.projectmanager.server.model;

import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.projects.Projects;
import ru.unn.ooap.projectmanager.server.model.users.User;

import java.util.List;

public interface IDAL {
    List<Project> getProjects();
    void syncProject(Project project);
    void syncProjects(Projects projects);
    void syncTask(Task task);
    void syncTasks(Task task);
    void syncUser(User user);
    void syncUsers();
}
