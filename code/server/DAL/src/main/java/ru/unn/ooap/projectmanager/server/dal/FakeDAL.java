package ru.unn.ooap.projectmanager.server.dal;

import ru.unn.ooap.projectmanager.server.model.IDAL;

import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.projects.Projects;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

import java.util.ArrayList;
import java.util.List;

public class FakeDAL implements IDAL {
    public void sync(final Project project) {
        project.setTitle("Test");
    }

    public void sync(final Projects projects) {
        String str = new String("test");
    }

    public void sync(final Task task) {
        String str = new String("test");
    }

    public void sync(final User user) {
        String str = new String("test");
    }

    public void sync(final Users users) {
        List<User> usersList = new ArrayList<User>();
        usersList.add(new Manager(1, "Test", "Test"));
        users.setUsers(usersList);
    }

    public void sync(final Administrator admin) {
        String str = new String("test");
    }

    public void sync(final Manager manager) {
        String str = new String("test");
    }

    public void sync(final Executor executor) {
        String str = new String("test");
    }
}
