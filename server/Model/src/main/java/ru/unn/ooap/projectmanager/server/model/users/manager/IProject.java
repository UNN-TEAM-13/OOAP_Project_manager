package ru.unn.ooap.projectmanager.server.model.users.manager;

import java.util.List;

public interface IProject {
    void setTitle(String title);
    String getTitle();
    void setDescription(String description);
    String getDescription();
    void addTask(ITask task);
    List<ITask> getTasks();
    // TODO:
    // getPlan();
    // setPlan();
}
