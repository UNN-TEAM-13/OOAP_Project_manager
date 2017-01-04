package ru.unn.ooap.projectmanager.server.model.users.administrator;

import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.Users;

import java.util.List;

public class Administrator extends User implements IAdministrator {
    List<? extends IUser> getUsers() {
        return Users.getInstance().get();
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
