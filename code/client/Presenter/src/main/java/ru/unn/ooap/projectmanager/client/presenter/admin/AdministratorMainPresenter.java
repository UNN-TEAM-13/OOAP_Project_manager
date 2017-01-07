package ru.unn.ooap.projectmanager.client.presenter.admin;

import ru.unn.ooap.projectmanager.client.presenter.IUserMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IAdministrator;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

public class AdministratorMainPresenter implements IUserMainPresenter {
    private IAdministrator user;
    private IAdministratorMainView view;

    @Override
    public void setView(final IUserMainView view) {
        this.view = (IAdministratorMainView) view;
        user = (IAdministrator) view.getUser();
    }

    IAdministratorMainView getView() {
        return view;
    }

    private void showUserView(final IUser user) {
        /*
        here we show in the view's content-pane AdministratorUserView
        also, we should pass there this presenter and set here that

        in fact we just need to pass to AdministratorUserView IUser, that we want to represent
         */
    }

    public void createAdministrator() {
        IUser newAdministrator = user.createAdministrator();
        showUserView(user);
    }

    public void createManager() {
        IUser newManager = user.createManager();
        showUserView(user);
    }

    public void createExecutor() {
        IUser newExecutor = user.createManager();
        showUserView(user);
    }
}
