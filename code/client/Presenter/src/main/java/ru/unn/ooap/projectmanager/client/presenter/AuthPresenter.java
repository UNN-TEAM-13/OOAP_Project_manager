package ru.unn.ooap.projectmanager.client.presenter;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;
import ru.unn.ooap.projectmanager.server.model.users.manager.IManager;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IAdministrator;

import java.io.IOException;

public class AuthPresenter {
    private IAuthView view;

    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final BooleanProperty buttonDisabled = new SimpleBooleanProperty();

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
        User user = Users.getInstance().auth(username.get(), password.get());
        view.setUser(user);
        try {
            if (user instanceof IExecutor) {
                view.showScene("ExecutorMainView.fxml");
            } else if (user instanceof IManager) {
                view.showScene("ManagerMainView.fxml");
            } else if (user instanceof IAdministrator) {
                view.showScene("AdministratorMainView.fxml");
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
