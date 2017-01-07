package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.manager.IManagerMainView;
import ru.unn.ooap.projectmanager.client.presenter.manager.ManagerMainPresenter;

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

    @Override
    Node getNode() {
        return projects;
    }

    void initialize() {
        presenter.setView(this);
        createProjectButton.setOnAction(actionEvent -> presenter.createProject());
        createTaskButton.setOnAction(actionEvent -> presenter.createTask());
    }
}
