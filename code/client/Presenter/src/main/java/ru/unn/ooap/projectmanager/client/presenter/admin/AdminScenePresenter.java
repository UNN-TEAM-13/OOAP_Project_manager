package ru.unn.ooap.projectmanager.client.presenter.admin;

import ru.unn.ooap.projectmanager.client.presenter.UserScenePresenter;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;

public class AdminScenePresenter implements UserScenePresenter{
    private Administrator user;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(final User user) {
        this.user = (Administrator) user;
    }
}
