package ru.unn.ooap.projectmanager.server.model.users;

public class Users {
    private static Users ourInstance = new Users();

    public static Users getInstance() {
        return ourInstance;
    }

    private Users() {
    }
}
