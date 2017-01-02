package ru.unn.ooap.projectmanager.server.model.users;

import javafx.scene.control.ListView;
import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IAdminisrator;
import ru.unn.ooap.projectmanager.server.model.users.manager.IManager;

import java.util.List;

public final class Users {
    private static Users instance = null;
    private static IDAL storage;
    private static List<IUser> users;

    private Users(final IDAL storage) {
        Users.storage = storage;
        storage.sync(this);
    }

    public static synchronized void init(final IDAL storage) {
        if (instance != null) {
            throw new AssertionError("Already initialized");
        }
        instance = new Users(storage);
    }

    public static Users getInstance() {
        return instance;
    }

    public static IUser auth(final String un, final String pw) {
        for (IUser user : users) {
            if (user.getUsername().equals(un) && user.isPasswordValid(pw)) {
                return user;
            }
        }
        return null;
    }

    public static void setUsers(final List<IUser> users) {
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

    public List<IUser> get() {
        return users;
    }
}
