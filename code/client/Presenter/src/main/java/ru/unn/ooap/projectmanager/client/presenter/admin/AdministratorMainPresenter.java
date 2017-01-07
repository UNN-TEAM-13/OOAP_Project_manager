package ru.unn.ooap.projectmanager.client.presenter.admin;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IAdministrator;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

public class AdministratorMainPresenter implements IUserMainPresenter {
    private IAdministrator user;
    private IAdministratorMainView view;
    private final ObjectProperty<ObservableList<IUser>> users
            = new SimpleObjectProperty<>(FXCollections.observableArrayList());

    @Override
    public void setView(final IUserMainView view) {
        this.view = (IAdministratorMainView) view;
    }

    IAdministratorMainView getView() {
        return view;
    }

    public void setUser(final ru.unn.ooap.projectmanager.server.model.users.IUser user) {
        this.user = (IAdministrator) user;
        users.get().clear();
        users.set(FXCollections.observableArrayList(this.user.getUsers()));
    }

    public ObservableList<IUser> getUsers() {
        return users.get();
    }

    public ObjectProperty<ObservableList<IUser>> usersProperty() {
        return users;
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
