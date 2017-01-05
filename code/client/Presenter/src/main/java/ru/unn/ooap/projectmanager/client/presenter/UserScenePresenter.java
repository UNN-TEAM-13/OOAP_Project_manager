package ru.unn.ooap.projectmanager.client.presenter;

import ru.unn.ooap.projectmanager.server.model.users.IUser;

public interface UserScenePresenter {
    void setUser(IUser user);
    IUser getUser();
}
