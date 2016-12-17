package ru.unn.ooap.projectmanager.server.model.users.executor;

public interface ITask {
    String getTitle();
    String getDescription();
    double getGivenHours();
    double getSpentHours();
    double getLeftHours();
    void addSpentHours(double additionalSpentHours);
}
