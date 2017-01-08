package ru.unn.ooap.projectmanager.server.model.users.administrator;

import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.Users;

import java.util.List;

public class Administrator extends User implements IAdministrator {
    public Administrator(final int id, final String un, final String pw) {
        super(id, un, pw);
    }

    public List<? extends IUser> getUsers() {
        return Users.getInstance().get();
    }

    public List<? extends IUser> getAdministrators() {
        return Users.getInstance().getAdministrators();
    }

    public List<? extends IUser> getManagers() {
        return Users.getInstance().getManagers();
    }

    public List<? extends IUser> getExecutors() {
        return Users.getInstance().getExecutors();
    }

    public IUser createAdministrator() {
        return Users.getInstance().createAdministrator();
    }

    public IUser createManager() {
        return Users.getInstance().createManager();
    }

    public IUser createExecutor() {
        return Users.getInstance().createExecutor();
    }
}
