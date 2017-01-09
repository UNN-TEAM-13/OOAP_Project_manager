package ru.unn.ooap.projectmanager.server.model.projects;

import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.users.manager.IProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Project extends Observable implements IProject {
    private int id;
    private String title;
    private String description;
    private final List<Task> tasks;
    private final IDAL storage;

    public Project(final IDAL storage) {
        this(-1, "", "", new ArrayList<Task>(), storage);
    }

    // Only for inDAL use
    public Project(final int id, final String title, final String description,
                   final List<Task> tasks, final IDAL storage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.storage = storage;
    }

    public int getId() {
        return id;
    }

    public void setTitle(final String title) {
        this.title = title;
        storage.sync(this);
        setChanged();
        notifyObservers();
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(final String description) {
        this.description = description;
        storage.sync(this);
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return title;
    }
}
