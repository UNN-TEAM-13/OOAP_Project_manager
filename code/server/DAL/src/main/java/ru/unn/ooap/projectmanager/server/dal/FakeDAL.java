package ru.unn.ooap.projectmanager.server.dal;

import ru.unn.ooap.projectmanager.server.model.IDAL;

import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.projects.Projects;
import ru.unn.ooap.projectmanager.server.model.tasks.Tasks;
import ru.unn.ooap.projectmanager.server.model.users.User;
import ru.unn.ooap.projectmanager.server.model.users.Users;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

import java.util.ArrayList;
import java.util.List;

public class FakeDAL implements IDAL {
    private final List<User> usersList = new ArrayList<>();
    private final List<Project> projectsList = new ArrayList<>();
    private final List<Task> tasksList = new ArrayList<>();

    public FakeDAL() {
        usersList.add(new Manager(1, "TestManager", " "));

        Executor testExecutor = new Executor();
        testExecutor.setId(2);
        testExecutor.setUsername("TestExecutor");
        testExecutor.setPassword(" ");
        usersList.add(testExecutor);

        Task testTask1 = new Task();
        testTask1.setTitle("Test task 1");
        testTask1.setExecutor(testExecutor);
        Task testTask2 = new Task();
        testTask2.setTitle("Test task 2");
        testTask2.setExecutor(testExecutor);
        tasksList.add(testTask1);
        tasksList.add(testTask2);

        Project project = new Project();
        project.setTitle("Test Project");
        project.setDescription("Project, created just to proof of work");
        projectsList.add(project);


    }

    @Override
    public void sync(final Project project) {
        project.setTitle("Test");
    }

    @Override
    public void sync(final Projects projects) {
        projects.setProjects(projectsList);
    }

    @Override
    public void sync(final Task task) {
        String str = new String("test");
    }

    @Override
    public void sync(final Tasks tasks) {
        tasks.setTasks(tasksList);
    }

    @Override
    public void sync(final User user) {
        String str = new String("test");
    }

    @Override
    public void sync(final Users users) {
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
