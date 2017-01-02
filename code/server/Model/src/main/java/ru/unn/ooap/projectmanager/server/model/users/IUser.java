package ru.unn.ooap.projectmanager.server.model.users;

public interface IUser {
    String getUsername();
    boolean isPasswordValid(String password);
    // methods which are common for all roles
}
