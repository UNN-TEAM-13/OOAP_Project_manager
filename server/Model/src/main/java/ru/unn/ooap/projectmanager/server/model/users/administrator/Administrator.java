package ru.unn.ooap.projectmanager.server.model.users.administrator;

import ru.unn.ooap.projectmanager.server.model.users.User;

import java.util.List;

public class Administrator extends User {

    private List<User> users;

    public void addUser(final User user) {
        users.add(user);
    }
}
