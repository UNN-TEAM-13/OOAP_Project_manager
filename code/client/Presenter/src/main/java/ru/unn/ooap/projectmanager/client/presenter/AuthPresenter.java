package ru.unn.ooap.projectmanager.client.presenter;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;

import java.io.IOException;

public class AuthPresenter {
    private IAuthView view;

    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty status = new SimpleStringProperty();
    private BooleanProperty buttonDisabled = new SimpleBooleanProperty();

    public AuthPresenter() {
        // initialisation
    }

    public void setView(final IAuthView view) {
        this.view = view;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public BooleanProperty buttonDisabledProperty() {
        return buttonDisabled;
    }

    public boolean isButtonDisabled() {
        return buttonDisabled.get();
    }

    public void auth() {
        User user = Users.auth(username.get(), password.get());
        view.setUser(user);
        try {
            if (user instanceof Executor) {
                view.showScene("ExecutorSceneView.fxml");
            } else if (user instanceof Manager) {
                view.showScene("ManagerSceneView.fxml");
            } else if (user instanceof Administrator) {
                view.showScene("AdminSceneView.fxml");
            } else if (user == null) {
                status.set("Ошибка: введены неправильные данные");
            } else {
                status.set("Ошибка: неожиданный ответ сервера");
            }
        } catch (IOException e) {
            status.set("Ошибка ввода-вывода");
        }
    }
}
