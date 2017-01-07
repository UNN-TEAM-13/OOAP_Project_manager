package ru.unn.ooap.projectmanager.server.model.tasks;

import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;

import java.util.ArrayList;
import java.util.List;

public final class Tasks {
    private static Tasks instance;
    private final IDAL storage;
    private List<Task> tasks;

    private Tasks(final IDAL storage) {
        this.storage = storage;
        storage.sync(this);
    }

    public static void init(final IDAL storage) {
        synchronized (Tasks.class) {
            if (instance != null) {
                throw new AssertionError("Already initialized");
            }
            instance = new Tasks(storage);
        }
    }

    public static Tasks getInstance() {
        return instance;
    }

    public Task create() {
        Task task = new Task();
        tasks.add(task);
        storage.sync(this);
        return task;
    }

    public Task create(final Project project) {
        Task task = this.create();
        task.setProject(project);
        return task;
    }

    public List<Task> get() {
        return new ArrayList<Task>(tasks);
    }

    public List<Task> get(final Project project) {
        /*
        This logic can be moved to DAL
        but for this project it is not good idea.
        */
        List<Task> tasksOfProject = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getProject() == project) {
                tasksOfProject.add(task);
            }
        }
        return tasksOfProject;
    }

    public  List<Task> get(final Executor executor) {
        List<Task> tasksOfExecutor = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getExecutor() == executor) {
                tasksOfExecutor.add(task);
            }
        }
        return tasksOfExecutor;
    }

    public void setTasks(final List<Task> tasks) {
        this.tasks = tasks;
    }
}
