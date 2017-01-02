package ru.unn.ooap.projectmanager.client.presenter.manager;

public interface IProjectView {
    String getTitle();
    void setTitle(final String title);
    String getDescription();
    void setDescription(final String description);
    void setCanApply(final boolean canApply);
}
