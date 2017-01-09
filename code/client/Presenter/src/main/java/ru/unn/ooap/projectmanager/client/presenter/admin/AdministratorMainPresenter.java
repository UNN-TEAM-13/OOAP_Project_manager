package ru.unn.ooap.projectmanager.client.presenter.admin;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IAdministrator;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class AdministratorMainPresenter implements IUserMainPresenter, Observer {
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
        for (IUser suser : users.get()) {
            suser.deleteObserver(this);
        }
        users.get().clear();
        users.set(FXCollections.observableArrayList(this.user.getUsers()));
        for (IUser suser : users.get()) {
            suser.addObserver(this);
        }
    }

    public ObservableList<IUser> getUsers() {
        return users.get();
    }

    public ObjectProperty<ObservableList<IUser>> usersProperty() {
        return users;
    }

    private void showUserView(final IUser user) {
        try {
            view.showUser(user);
        } catch (IOException e) {
            //here we have to set status
            e.printStackTrace();
        }

    }

    public void setSelectedUser(final IUser user) {
        if (user == null) {
            return;
        }
        showUserView(user);
    }

    public void createAdministrator() {
        IUser newAdministrator = user.createAdministrator();
        newAdministrator.addObserver(this);
        showUserView(newAdministrator);
    }

    public void createManager() {
        IUser newManager = user.createManager();
        newManager.addObserver(this);
        showUserView(newManager);
    }

    public void createExecutor() {
        IUser newExecutor = user.createExecutor();
        newExecutor.addObserver(this);
        showUserView(newExecutor);
    }

    @Override
    public void update(final Observable o, final Object arg) {
        users.get().clear();
        users.get().setAll(user.getUsers());
    }
}
