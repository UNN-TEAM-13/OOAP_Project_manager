package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.unn.ooap.projectmanager.client.presenter.IAuthView;
import ru.unn.ooap.projectmanager.client.presenter.AuthPresenter;
import ru.unn.ooap.projectmanager.server.model.users.User;

import java.io.IOException;

public class AuthMainView implements IAuthView {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private AuthPresenter presenter;

    public void initialize() {
        presenter.setView(this);
        loginButton.setOnAction(event -> presenter.auth());
        usernameTextField.textProperty().bindBidirectional(presenter.usernameProperty());
        passwordField.textProperty().bindBidirectional(presenter.passwordProperty());
    }

    @Override
    public void setUser(final User user) {
        PMSStage currStage = (PMSStage) loginButton.getScene().getWindow();
        currStage.setUser(user);
    }

    @Override
    public void showScene(final String fxmlMarkup) throws IOException {
        Stage currStage = (Stage) loginButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlMarkup));
        currStage.setMaxHeight(Double.MAX_VALUE);
        currStage.setMinHeight(Double.MIN_VALUE);
        currStage.setScene(new Scene(root));
        currStage.show();
    }
}
