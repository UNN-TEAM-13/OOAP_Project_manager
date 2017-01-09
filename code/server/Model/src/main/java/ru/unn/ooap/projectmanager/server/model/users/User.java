package ru.unn.ooap.projectmanager.server.model.users;

import ru.unn.ooap.projectmanager.server.model.IDAL;

import java.io.Serializable;
import java.util.Observable;

public class User extends Observable implements IUser,
        ru.unn.ooap.projectmanager.server.model.users.administrator.IUser, Serializable {
    private int id;
    private String username;
    private String password;
    transient private IDAL storage;

    public User(final IDAL storage) {
        this(-1, "", "", storage);
    }

    public User(final int id, final String username, final String password, final IDAL storage) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.storage = storage;
    }

    public int getID() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isPasswordValid(final String pw) {
        return password.equals(pw);
    }

    public boolean changePassword(final String oldPW, final String newPW) {
        if (oldPW.equals(password)) {
            password = newPW;
            storage.sync(this);
            setChanged();
            notifyObservers();
            return true;
        } else {
            return false;
        }
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setUsername(final String username) {
        for (User user : Users.getInstance().get()) {
            if (user != this && user.getUsername().equals(username)) {
                throw new IllegalArgumentException("User with this username already exists");
            }
        }
        this.username = username;
        storage.sync(this);
        setChanged();
        notifyObservers();
    }

    public void setPassword(final String password) {
        this.password = password;
        storage.sync(this);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
