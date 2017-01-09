package ru.unn.ooap.projectmanager.server.model.users.manager;

import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;

public interface ITask extends ru.unn.ooap.projectmanager.server.model.tasks.ITask {
    String getTitle();
    void setTitle(String title);
    String getDescription();
    void setDescription(String description);
    double getGivenHours();
    void setGivenHours(double givenHours);
    double getSpentHours();
    double getLeftHours();
    Executor getExecutor();
    void setExecutor(IExecutor executor);
    Project getProject();
    void setProject(IProject project);
    boolean isDone();
    boolean isOpen();
    void close();
    void open();
}
