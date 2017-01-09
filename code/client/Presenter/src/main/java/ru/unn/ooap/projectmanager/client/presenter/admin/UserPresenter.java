package ru.unn.ooap.projectmanager.client.presenter.admin;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

public class UserPresenter {
    private IUser user;
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final BooleanProperty applyUsernameButtonDisabled = new SimpleBooleanProperty();
    private final BooleanProperty applyPasswordButtonDisabled = new SimpleBooleanProperty();

    public UserPresenter() {
        username.addListener((observable, oldValue, newValue) -> validateUsername());
        password.addListener((observable, oldValue, newValue) -> validatePassword());
        username.set("");
        password.set("");
    }

    private void validateUsername() {
        applyUsernameButtonDisabled.set(username.get().equals(""));
    }

    private void validatePassword() {
        applyPasswordButtonDisabled.set(password.get().equals(""));
    }

    public void setUser(final IUser user) {
        System.out.println("UserPresenter.setUser: IUser user == " + user);
        this.user = user;
        username.set(user.getUsername());
    }

    public IUser getUser() {
        return user;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public boolean getApplyUsernameButtonDisabled() {
        return applyUsernameButtonDisabled.get();
    }

    public BooleanProperty applyUsernameButtonDisabledProperty() {
        return applyUsernameButtonDisabled;
    }

    public boolean getApplyPasswordButtonDisabled() {
        return applyPasswordButtonDisabled.get();
    }

    public BooleanProperty applyPasswordButtonDisabledProperty() {
        return applyPasswordButtonDisabled;
    }

    public void applyUsername() {
        try {
            user.setUsername(username.get());
        } catch (IllegalArgumentException e) {
            // here set bad status
        }
    }

    public void applyPassword() {
        try {
            user.setPassword(password.get());
        } catch (IllegalArgumentException e) {
            // here set bad status
        }
    }
}
