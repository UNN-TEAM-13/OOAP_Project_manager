package ru.unn.ooap.projectmanager.server.model.users;

import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

import java.util.ArrayList;
import java.util.List;

public final class Users {
    private static Users instance;
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

    public void setUsers(final List<User> users) {
        Users.users = users;
    }

    public Administrator createAdministrator() {
        return null;
    }

    public Manager createManager() {
        return null;
    }

    public Executor createExecutor() {
        return null;
    }

    public List<User> get() {
        return new ArrayList<>(users);
    }

    public List<Administrator> getAdministrators() {
        List<Administrator> administrators = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Administrator) {
                administrators.add((Administrator) user);
            }
        }
        return administrators;
    }

    public List<Manager> getManagers() {
        List<Manager> managers = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Manager) {
                managers.add((Manager) user);
            }
        }
        return managers;
    }

    public List<Executor> getExecutors() {
        List<Executor> executors = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Executor) {
                executors.add((Executor) user);
            }
        }
        return executors;
    }
}
