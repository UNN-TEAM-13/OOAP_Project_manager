package ru.unn.ooap.projectmanager.client.presenter.manager;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.ooap.projectmanager.server.model.users.manager.IProject;
import ru.unn.ooap.projectmanager.server.model.users.manager.ITask;

public class ProjectPresenter {
    private IProjectView view;
    private IProject project;

    private final StringProperty titleText = new SimpleStringProperty();
    private final StringProperty descriptionText = new SimpleStringProperty();
    private final BooleanProperty applyButtonDisabled = new SimpleBooleanProperty();
    private final ObjectProperty<ObservableList<ITask>> tasks
            = new SimpleObjectProperty<>(FXCollections.observableArrayList());

    public ProjectPresenter() {
        titleText.addListener((observable, oldValue, newValue) -> validateInput());
        titleText.set("");
        descriptionText.set("");
    }

    private void validateInput() {
        applyButtonDisabled.set(titleText.get().equals(""));
    }

    public void setView(final IProjectView view) {
        this.view = view;
    }

    public IProjectView getView() {
        return view;
    }

    public void setProject(final IProject project) {
        this.project = project;
        titleText.set(project.getTitle());
        descriptionText.set(project.getDescription());
        tasks.set(FXCollections.observableArrayList(project.getTasks()));
    }

    public IProject getProject() {
        return project;
    }

    public StringProperty titleTextProperty() {
        return titleText;
    }

    public StringProperty descriptionTextProperty() {
        return descriptionText;
    }

    public boolean getApplyButtonDisabled() {
        return applyButtonDisabled.get();
    }

    public BooleanProperty applyButtonDisabledProperty() {
        return applyButtonDisabled;
    }

    public ObservableList<ITask> getTasks() {
        return tasks.get();
    }

    public void apply() {
        project.setTitle(titleText.get());
        project.setDescription(descriptionText.get());
    }
}
