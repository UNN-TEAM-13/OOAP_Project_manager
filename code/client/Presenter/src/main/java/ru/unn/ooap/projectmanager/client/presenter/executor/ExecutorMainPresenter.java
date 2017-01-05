package ru.unn.ooap.projectmanager.client.presenter.executor;

import ru.unn.ooap.projectmanager.client.presenter.UserScenePresenter;
import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;

public class ExecutorMainPresenter implements UserScenePresenter {
    private Executor user;

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public void setUser(final IUser user) {
        this.user = (Executor) user;
    }
}
