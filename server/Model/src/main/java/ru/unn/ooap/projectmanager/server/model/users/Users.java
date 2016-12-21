package ru.unn.ooap.projectmanager.server.model.users;

import ru.unn.ooap.projectmanager.server.model.IDAL;

import java.util.List;

public class Users {
    private static Users instance = null;
    private static IDAL storage;
    private static List<User> users;

    private Users(IDAL storage) {
        this.storage = storage;
        storage.sync(this);
    }

    public synchronized static void init(IDAL storage) {
        if (instance != null) {
            throw new AssertionError("Already initialized");
        }
        instance = new Users(storage);
    }

    public static Users getInstance() {
        return instance;
    }

    public static User auth(final String un, final String pw) {
        for (User user : users) {
            if (user.getUsername().equals(un)
                    && user.isPasswordValid(pw)) {
                return user;
            }
        }
        return null;
    }

    public static void setUsers(List<User> users) {
        Users.users = users;
    }
}
