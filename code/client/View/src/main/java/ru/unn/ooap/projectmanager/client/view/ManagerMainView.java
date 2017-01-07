package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.manager.IManagerMainView;
import ru.unn.ooap.projectmanager.client.presenter.manager.ManagerMainPresenter;
import ru.unn.ooap.projectmanager.server.model.users.IUser;

public class ManagerMainView extends UserMainView implements IManagerMainView {
    @FXML
    private Pane content;
    @FXML
    private TreeView projects;
    @FXML
    private Button createProjectButton;
    @FXML
    private Button createTaskButton;

    @FXML
    private ManagerMainPresenter presenter;

    void initialize() {
        presenter.setView(this);
        createProjectButton.setOnAction(actionEvent -> presenter.createProject());
        createTaskButton.setOnAction(actionEvent -> presenter.createTask());
    }

    @Override
    public void initUser(final IUser user) {
        presenter.setUser(user);
    }
}
