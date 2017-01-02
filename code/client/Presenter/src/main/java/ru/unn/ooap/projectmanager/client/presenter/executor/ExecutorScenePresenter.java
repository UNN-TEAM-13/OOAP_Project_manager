package ru.unn.ooap.projectmanager.client.presenter.executor;

import ru.unn.ooap.projectmanager.client.presenter.UserScenePresenter;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;

public class ExecutorScenePresenter implements UserScenePresenter {
    private Executor user;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(final User user) {
        this.user = (Executor) user;
    }
}
