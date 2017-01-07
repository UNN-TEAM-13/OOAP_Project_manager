package ru.unn.ooap.projectmanager.client.presenter.admin;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

public class UserPresenter {
    private IUser user;
    private final StringProperty username = new SimpleStringProperty("");
    private final StringProperty password = new SimpleStringProperty("");
    private final BooleanProperty applyButtonDisabled = new SimpleBooleanProperty();

    public UserPresenter() {
        username.addListener((observable, oldValue, newValue) -> validateInput());
        password.addListener((observable, oldValue, newValue) -> validateInput());
        validateInput();
    }

    private boolean isUsernameValid() {
        return !username.get().equals("");
    }

    private boolean isPasswordValid() {
        return !password.get().equals("");
    }

    private void validateInput() {
        if (isUsernameValid() && isPasswordValid()) {
            applyButtonDisabled.set(false);
            // here set corresponding status
        } else {
            applyButtonDisabled.set(true);
            // here set corresponding statuses
        }
    }

    public void setUser(final IUser user) {
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

    public boolean getApplyButtonDisabled() {
        return applyButtonDisabled.get();
    }

    public BooleanProperty applyButtonDisabledProperty() {
        return applyButtonDisabled;
    }

    public void apply() {
        /*
        transaction = user.beginTransaction();
        try {
            transaction.setUsername(username.get());
            transaction.setPassword(password.get());
            user.commit(transaction);
        } catch (IllegalArgumentException e) {
            transaction.rollback();
            // User with this name already exists,
            // set corresponding status
        }
        */
    }
}
