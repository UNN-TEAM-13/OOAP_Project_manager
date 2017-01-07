package ru.unn.ooap.projectmanager.client.presenter.executor;

import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.executor.ITask;

import java.io.IOException;

public interface IExecutorMainView extends IUserMainView {
    void showTask(ITask task) throws IOException;
}
