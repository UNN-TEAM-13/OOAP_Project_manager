package ru.unn.ooap.projectmanager.server.model.users;

import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IAdminisrator;

import java.util.List;

public final class Users {
    private static Users instance = null;
    private static IDAL storage;
    private static List<User> users;

    private Users() {
    }

    public static void init(final IDAL storage) {
        synchronized (Users.class) {
            if (instance != null) {
                throw new AssertionError("Already initialized");
            }
            instance = new Users();
            Users.storage = storage;
            storage.sync(instance);
        }
    }

    public static Users getInstance() {
        return instance;
    }

    public static User auth(final String un, final String pw) {
        for (User user : users) {
            if (user.getUsername().equals(un) && user.isPasswordValid(pw)) {
                return user;
            }
        }
        return null;
    }

    public static void setUsers(final List<User> users) {
        Users.users = users;
    }

    public IAdminisrator createAdministrator() {
        return null;
    }

    public IAdminisrator createManager() {
        return null;
    }

    public IAdminisrator createExecutor() {
        return null;
    }

    public List<? extends IUser> get() {
        return users;
    }
}
