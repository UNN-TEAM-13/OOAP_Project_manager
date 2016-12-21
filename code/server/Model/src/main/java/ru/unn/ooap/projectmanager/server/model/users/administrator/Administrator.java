package ru.unn.ooap.projectmanager.server.model.users.administrator;

import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;

import java.util.List;

public class Administrator extends User {
    List<User> getUsers() {
        return Users.getInstance().get();
    }

    public Administrator createAdministrator() {
        return Users.getInstance().createAdministrator();
    }

    public Administrator createAdministrator() {
        return Users.getInstance().createAdministrator();
    }

    public Administrator createAdministrator() {
        return Users.getInstance().createAdministrator();
    }
}
