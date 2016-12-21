package ru.unn.ooap.projectmanager.client.presenter.executor;

public interface ITaskView {
    void setTitle(String title);
    void setDescription(String description);
    void setGivenHours(double givenHours);
    void setSpentHours(double spentHours);
}
