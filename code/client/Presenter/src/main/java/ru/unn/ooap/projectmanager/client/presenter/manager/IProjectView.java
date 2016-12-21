package ru.unn.ooap.projectmanager.client.presenter.manager;

public interface IProjectView {
    String getTitle();
    void setTitle(String title);
    String getDescription();
    void setDescription(String description);
    void setCanApply(boolean canApply);
}
