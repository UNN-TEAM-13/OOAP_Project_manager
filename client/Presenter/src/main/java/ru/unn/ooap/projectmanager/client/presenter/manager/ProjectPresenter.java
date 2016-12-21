package ru.unn.ooap.projectmanager.client.presenter.manager;

import ru.unn.ooap.projectmanager.server.model.users.manager.IProject;

public class ProjectPresenter {
    private IProjectView view;
    private IProject project;

    public ProjectPresenter(IProjectView view, IProject project) {
        this.view = view;
    }

    void apply() {
        project.setTitle(view.getTitle());
        project.setDescription(view.getDescription());
    }
}
