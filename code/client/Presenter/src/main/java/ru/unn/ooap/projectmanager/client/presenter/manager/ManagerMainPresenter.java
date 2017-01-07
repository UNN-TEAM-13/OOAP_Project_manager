package ru.unn.ooap.projectmanager.client.presenter.manager;

import ru.unn.ooap.projectmanager.client.presenter.IUserMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.manager.IManager;

public class ManagerMainPresenter implements IUserMainPresenter {
    private IManager user;
    private IManagerMainView view;

    @Override
    public void setView(final IUserMainView view) {
        this.view = (IManagerMainView) view;
    }

    IManagerMainView getView() {
        return view;
    }

    public void setUser(final IUser user) {
        this.user = (IManager) user;
        //here load projects and tasks
    }

    IManager getUser() {
        return user;
    }

    public void createTask() {
        // TBD
        // Если в данный момент открыт проект
        // — создаём задачу с этим проектом
        // Если в данный момент открыта задача
        // или ничего не открыто
        // — создаём просто задачу,
        // не присваиваяя ей какой-либо проект
    }

    public void createProject() {
        // TBD
        // То же, что в таске
    }
}
