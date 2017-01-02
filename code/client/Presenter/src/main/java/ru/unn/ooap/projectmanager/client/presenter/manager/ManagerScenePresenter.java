package ru.unn.ooap.projectmanager.client.presenter.manager;

import ru.unn.ooap.projectmanager.client.presenter.UserScenePresenter;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

public class ManagerScenePresenter implements UserScenePresenter {
    private Manager user;

    @Override
    public void setUser(final User user) {
        this.user = (Manager) user;
    }

    @Override
    public User getUser() {
        return user;
    }
}
