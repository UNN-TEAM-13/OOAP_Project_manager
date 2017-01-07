package ru.unn.ooap.projectmanager.client.presenter;

import ru.unn.ooap.projectmanager.server.model.users.IUser;

import java.io.IOException;

public interface IAuthView {
    void setUser(IUser user);
    void showScene(String fxmlFile) throws IOException;
}
