package ru.unn.ooap.projectmanager.server.model.users.manager;

import ru.unn.ooap.projectmanager.server.model.IObservable;
import ru.unn.ooap.projectmanager.server.model.tasks.Task;

import java.util.List;

public interface IProject extends IObservable {
    void setTitle(String title);
    String getTitle();
    void setDescription(String description);
    String getDescription();
    void addTask(Task task);
    List<Task> getTasks();
    // getPlan();
    // setPlan();
}
