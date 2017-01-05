package ru.unn.ooap.projectmanager.client.presenter.manager;

import ru.unn.ooap.projectmanager.client.presenter.UserScenePresenter;
import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

public class ManagerMainPresenter implements UserScenePresenter {
    private Manager user;

    @Override
    public void setUser(final IUser user) {
        this.user = (Manager) user;
    }

    @Override
    public IUser getUser() {
        return user;
    }
}
