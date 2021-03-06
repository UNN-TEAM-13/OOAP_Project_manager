package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.admin.IUserView;
import ru.unn.ooap.projectmanager.client.presenter.admin.UserPresenter;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

public class AdministratorUserView implements IUserView {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button applyUsernameButton;
    @FXML
    private Button applyPasswordButton;

    @FXML
    private UserPresenter presenter;

    @FXML
    void initialize() {
        applyUsernameButton.setOnAction((actionEvent) -> presenter.applyUsername());
        applyPasswordButton.setOnAction((actionEvent) -> presenter.applyPassword());
        username.textProperty().bindBidirectional(presenter.usernameProperty());
        password.textProperty().bindBidirectional(presenter.passwordProperty());
    }

    public void initUser(final IUser user) {
        presenter.setUser(user);
    }
}
