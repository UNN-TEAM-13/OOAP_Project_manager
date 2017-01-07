package ru.unn.ooap.projectmanager.server.model.projects;

import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.users.manager.IProject;

import java.util.ArrayList;
import java.util.List;

public class Project implements IProject {
    private int id;
    private String title;
    private String description;
    private final List<Task> tasks = new ArrayList<>();
    private final IDAL storage;

    public Project(final IDAL storage) {
        this.storage = storage;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public void addTask(final Task task) {
        tasks.add(task);
        storage.sync(this);
    }

    @Override
    public String toString() {
        return title;
    }
}
