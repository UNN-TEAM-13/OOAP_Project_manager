package ru.unn.ooap.projectmanager.server.model.users.executor;

public interface ITask extends ru.unn.ooap.projectmanager.server.model.tasks.ITask {
    String getTitle();
    String getDescription();
    double getGivenHours();
    double getSpentHours();
    double getLeftHours();
    void addSpentHours(double additionalSpentHours);
    boolean isOpen();
    boolean isDone();
    void setDone(boolean done);
}
