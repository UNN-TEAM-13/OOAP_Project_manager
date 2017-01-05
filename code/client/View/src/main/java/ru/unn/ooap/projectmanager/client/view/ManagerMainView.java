package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.manager.IManagerMainView;
import ru.unn.ooap.projectmanager.client.presenter.manager.ManagerMainPresenter;

public class ManagerMainView extends WindowTitledPane implements IManagerMainView {
    @FXML
    private Pane content;
    @FXML
    private TreeView projects;

    private ManagerMainPresenter presenter;


    private static final String WINDOW_TITLE = "PMS — Manager";

    @Override
    Node getFakeNode() {
        return projects;
    }

    void initialize() {
        setWindowTitle(WINDOW_TITLE);
    }
}
