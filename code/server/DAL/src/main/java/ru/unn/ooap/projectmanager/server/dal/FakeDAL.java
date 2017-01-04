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
    @Override
    public void sync(final Project project) {
        project.setTitle("Test");
    }

    @Override
    public void sync(final Projects projects) {
        List<Project> projectsList = new ArrayList<>();
        Project project = new Project();
        project.setTitle("Test Project");
        project.setDescription("Project, created just to proof of work");
        projectsList.add(project);
        projects.setProjects(projectsList);
    }

    @Override
    public void sync(final Task task) {
        String str = new String("test");
    }

    @Override
    public void sync(final User user) {
        String str = new String("test");
    }

    @Override
    public void sync(final Users users) {
        List<User> usersList = new ArrayList<User>();
        usersList.add(new Manager(1, "TestManager", " "));

        Executor testExecutor = new Executor();
        testExecutor.setId(2);
        testExecutor.setUsername("TestExecutor");
        testExecutor.setPassword(" ");
        usersList.add(testExecutor);
        users.setUsers(usersList);
    }

    @Override
    public void sync(final Administrator admin) {
        String str = new String("test");
    }

    @Override
    public void sync(final Manager manager) {
        String str = new String("test");
    }

    @Override
    public void sync(final Executor executor) {
        String str = new String("test");
    }
}
