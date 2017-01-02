package ru.unn.ooap.projectmanager.client.presenter;

import ru.unn.ooap.projectmanager.server.model.users.User;

public interface UserScenePresenter {
    void setUser(User user);
    User getUser();
}
