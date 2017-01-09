package ru.unn.ooap.projectmanager.server.model.users;

import ru.unn.ooap.projectmanager.server.model.IObservable;

import java.io.Serializable;

public interface IUser extends IObservable, Serializable {
    int getID();
    String getUsername();
    boolean isPasswordValid(String password);
    // methods which are common for all roles
}
