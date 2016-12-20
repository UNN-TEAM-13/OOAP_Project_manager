package ru.unn.ooap.projectmanager.server.model.users;

public class User {
    private String username;
    private String password;
    private Role role;

    public enum Role {
        ADMIN, MANAGER, EXECUTOR;
    }
}
