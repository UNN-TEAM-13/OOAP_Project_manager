package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.manager.IManagerSceneView;
import ru.unn.ooap.projectmanager.client.presenter.manager.ManagerScenePresenter;

public class ManagerSceneView implements IManagerSceneView {
    @FXML
    private Pane content;
    @FXML
    private TreeView projects;

    private ManagerScenePresenter presenter;
}
