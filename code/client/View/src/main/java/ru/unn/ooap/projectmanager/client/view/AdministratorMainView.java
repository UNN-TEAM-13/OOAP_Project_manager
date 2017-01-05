package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.admin.IAdministratorMainView;
import ru.unn.ooap.projectmanager.client.presenter.admin.AdministratorMainPresenter;

public class AdministratorMainView extends WindowTitledPane implements IAdministratorMainView {
    @FXML
    private Pane content;
    @FXML
    private ListView users;
    @FXML
    private Button createAdministratorButton;
    @FXML
    private Button createManagerButton;
    @FXML
    private Button createExecutorButton;

    @FXML
    private AdministratorMainPresenter presenter;

    private static final String WINDOW_TITLE = "PMS — Administrator";

    @Override
    Node getFakeNode() {
        return users;
    }

    @Override
    public String getWindowTitle() {
        return WINDOW_TITLE;
    }

    @Override
    void initialize() {
        super.initialize();
        presenter.setUser(((PMSStage) getStage()).getUser());

        createAdministratorButton.setOnAction(actionEvent -> presenter.createAdministrator());
        createManagerButton.setOnAction(actionEvent -> presenter.createManager());
        createExecutorButton.setOnAction(actionEvent -> presenter.createExecutor());
    }

}
