package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.IAuthView;
import ru.unn.ooap.projectmanager.client.presenter.AuthPresenter;

public class AuthView implements IAuthView {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private AuthPresenter presenter;
}
