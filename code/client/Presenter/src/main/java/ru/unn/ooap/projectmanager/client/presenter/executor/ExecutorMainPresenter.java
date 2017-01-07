package ru.unn.ooap.projectmanager.client.presenter.executor;

import ru.unn.ooap.projectmanager.client.presenter.IUserMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;

public class ExecutorMainPresenter implements IUserMainPresenter {
    private IExecutor user;
    private IExecutorMainView view;

    @Override
    public void setView(final IUserMainView view) {
        this.view = (IExecutorMainView) view;
        user = (IExecutor) view.getUser();
    }

    IExecutorMainView getView() {
        return view;
    }

    IExecutor getUser() {
        return user;
    }
}
