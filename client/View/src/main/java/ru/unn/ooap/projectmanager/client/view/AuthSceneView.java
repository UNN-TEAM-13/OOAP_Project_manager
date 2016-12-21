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

public class AuthSceneView implements IAuthView {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private final AuthPresenter presenter = new AuthPresenter();

    public void initialize() {
        loginButton.setOnAction(event -> presenter.auth());
    }

    @Override
    public String getUsernameText() {
        return usernameTextField.getText();
    }

    @Override
    public void setUsernameText(final String text) {
        usernameTextField.setText(text);
    }

    @Override
    public String getPasswordText() {
        return passwordField.getText();
    }

    @Override
    public boolean getButtonState() {
        return loginButton.isDisabled();
    }

    @Override
    public void setButtonState(final boolean enabled) {
        loginButton.setDisable(!enabled);
    }

    @Override
    public void setUser(User user) {
        PMSStage currStage = (PMSStage) loginButton.getScene().getWindow();
        currStage.setUser(user);
    }

    private void showScene(final String title, final String fxmlMarkup) throws IOException {
        Stage currStage = (Stage) loginButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlMarkup));
        currStage.setTitle(title);
        currStage.setMaxHeight(Double.MAX_VALUE);
        currStage.setMinHeight(Double.MIN_VALUE);
        currStage.setScene(new Scene(root));
        currStage.show();
    }

    @Override
    public void showAdminScene() throws IOException {
        showScene("Администратор", "AdminSceneView.fxml");
    }

    @Override
    public void showManagerScene() throws IOException {
        showScene("Менеджер", "ManagerSceneView.fxml");
    }

    @Override
    public void showExecutorScene() throws IOException {
        showScene("Исполнитель", "ExecutorSceneView.fxml");
    }
}
