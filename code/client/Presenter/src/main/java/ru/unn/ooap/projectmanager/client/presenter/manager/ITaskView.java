package ru.unn.ooap.projectmanager.client.presenter.manager;

public interface ITaskView {
    void setTitle(String title);
    void setDescription(String description);
    void setGivenHours(double givenHours);
    void setSpentHours(double spentHours);
    double getGivenHours();
}
