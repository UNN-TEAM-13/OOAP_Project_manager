package ru.unn.ooap.projectmanager.server.model.users;

import ru.unn.ooap.projectmanager.server.model.IObservable;

public interface IUser extends IObservable {
    int getID();
    String getUsername();
    boolean isPasswordValid(String password);
    // methods which are common for all roles
}
