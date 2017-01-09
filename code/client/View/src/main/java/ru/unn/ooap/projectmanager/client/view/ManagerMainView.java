package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.manager.IManagerMainView;
import ru.unn.ooap.projectmanager.client.presenter.manager.ManagerMainPresenter;
import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.manager.IProject;
import ru.unn.ooap.projectmanager.server.model.users.manager.ITask;

import java.io.IOException;

public class ManagerMainView extends UserMainView implements IManagerMainView {
    @FXML
    private Pane content;
    @FXML
    private TreeView<String> projects;
    @FXML
    private Button createProjectButton;
    @FXML
    private Button createTaskButton;

    @FXML
    private ManagerMainPresenter presenter;

    @FXML
    void initialize() {
        presenter.setView(this);
        createProjectButton.setOnAction(actionEvent -> presenter.createProject());
        createTaskButton.setOnAction(actionEvent -> presenter.createTask());

        projects.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        presenter.setSelected(newValue.getValue());
                    }
                }));
    }

    @Override
    public void initUser(final IUser user) {
        presenter.setUser(user);
    }

    @Override
    public void showProject(final IProject project) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManagerProjectView.fxml"));
        content.getChildren().clear();
        content.getChildren().add(loader.load());
        ManagerProjectView controller = loader.<ManagerProjectView>getController();
        controller.initProject(project);
    }

    @Override
    public void showTask(final ITask task) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManagerTaskView.fxml"));
        content.getChildren().clear();
        content.getChildren().add(loader.load());
        ManagerTaskView controller = loader.<ManagerTaskView>getController();
        controller.initTask(task);
    }
}
