package ru.unn.ooap.projectmanager.client.presenter;

import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;

import java.io.IOException;

public class AuthPresenter {
    private IAuthView view;
    private String username;
    private String password;
    private String status;
    private boolean isButtonActive;

    public AuthPresenter(IAuthView view) {
        this.view = view;
    }

    private void setStatus(final String statusString) {
        status = statusString;
    }

    public String getStatus() {
        return status;
    }

    public void auth() {
        User user = Users.auth(view.getUsernameText(), view.getUsernameText());
        view.setUser(user);
        try {
            if (user instanceof Executor) {
                view.showScene("Исполнитель", "ExecutorSceneView.fxml");
            } else if (user instanceof Manager) {
                view.showScene("Менеджер", "ManagerSceneView.fxml");
            } else if (user instanceof Administrator) {
                view.showScene("Администратор", "AdminSceneView.fxml");
            } else if (user == null) {
                setStatus("FAIL: Wrong authentication data");
            } else {
                setStatus("FAIL: Unexpected response");
            }
        } catch (IOException e) {
            setStatus("FAIL: Input/output error");
        }
    }
}
