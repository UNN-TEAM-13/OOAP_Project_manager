package ru.unn.ooap.projectmanager.server.model.users.manager;

import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;

public interface ITask {
    String getTitle();
    void setTitle(String title);
    String getDescription();
    void setDescription(String description);
    double getGivenHours();
    void setGivenHours(double givenHours);
    double getSpentHours();
    double getLeftHours();
    Executor getExecutor();
    void setExecutor(Executor executor);
    boolean isDone();
    boolean isOpen();
    void close();
    void open();
}
