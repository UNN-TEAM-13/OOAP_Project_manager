package ru.unn.ooap.projectmanager.client.presenter.manager;

import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.manager.IProject;
import ru.unn.ooap.projectmanager.server.model.users.manager.ITask;

import java.io.IOException;

public interface IManagerMainView extends IUserMainView {
    void showProject(IProject project) throws IOException;
    void showTask(ITask project) throws IOException;
}
