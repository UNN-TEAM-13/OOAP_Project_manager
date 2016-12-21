package ru.unn.ooap.projectmanager.server.model.users;

public class User {
    private int id;
    private String username;
    private String password;

    public User(){

    }

    public User(final int id, final String username, final String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isPasswordValid(final String pw) {
        return password.equals(pw);
    }

    boolean changePassword(final String oldPW, final String newPW) {
        if (oldPW.equals(password)) {
            password = newPW;
            return true;
        } else {
            return false;
        }
    }
}
