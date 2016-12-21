package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.admin.IAdminSceneView;
import ru.unn.ooap.projectmanager.client.presenter.admin.AdminScenePresenter;

public class AdminSceneView implements IAdminSceneView {
    @FXML
    private Pane content;
    @FXML
    private ListView users;

    private AdminScenePresenter presenter;
}
