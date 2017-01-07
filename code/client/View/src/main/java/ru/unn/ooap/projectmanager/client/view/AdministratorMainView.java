package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.admin.IAdministratorMainView;
import ru.unn.ooap.projectmanager.client.presenter.admin.AdministratorMainPresenter;
import ru.unn.ooap.projectmanager.server.model.users.IUser;

public class AdministratorMainView extends UserMainView implements IAdministratorMainView {
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

    void initialize() {
        presenter.setView(this);
        createAdministratorButton.setOnAction(actionEvent -> presenter.createAdministrator());
        createManagerButton.setOnAction(actionEvent -> presenter.createManager());
        createExecutorButton.setOnAction(actionEvent -> presenter.createExecutor());
    }

    @Override
    public void initUser(final IUser user) {
        presenter.setUser(user);
    }
}
