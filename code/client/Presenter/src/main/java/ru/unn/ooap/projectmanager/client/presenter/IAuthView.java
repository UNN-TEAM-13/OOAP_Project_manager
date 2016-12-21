package ru.unn.ooap.projectmanager.client.presenter;

import ru.unn.ooap.projectmanager.server.model.users.User;

import java.io.IOException;

public interface IAuthView {
    void setUser(User user);
    void showExecutorScene() throws IOException;
    void showManagerScene() throws IOException;
    void showAdminScene() throws IOException;
    void setUsernameText(String username);
    String getUsernameText();
    String getPasswordText();
    boolean getButtonState();
    void setButtonState(boolean enabled);
}
