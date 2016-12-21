package ru.unn.ooap.projectmanager.server.model.users.manager;

import ru.unn.ooap.projectmanager.server.model.users.User;

public class Manager extends User {
    public Manager(int id, String un, String pw) {
        super(id, un, pw);
    }

    public void createProject(IProject project) {

    }

    public IProject getProjects() {
        return null;
    }
}
