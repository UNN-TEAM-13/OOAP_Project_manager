package ru.unn.ooap.projectmanager.server.model.projects;

import ru.unn.ooap.projectmanager.server.model.IDAL;

import java.util.List;

public final class Projects {
    private static Projects instance = null;
    private List<Project> projects;
    private final IDAL storage;

    private Projects(final IDAL storage) {
        this.storage = storage;
        storage.sync(this);
    }

    public static synchronized void init(final IDAL storage) {
        if (instance != null) {
            throw new AssertionError("Already initialized");
        }
        instance = new Projects(storage);
    }

    public static Projects getInstance() {
        return instance;
    }

    public Project create() {
        Project project = new Project();
        projects.add(project);
        storage.sync(this);
        return project;
    }

    public List<Project> getAll() {
        return projects;
    }

    public List<Project> getOpen() {
        return null;
    }

    public List<Project> getClosed() {
        return null;
    }

    Project createProject() {
        Project project = new Project();
        storage.sync(project);
        storage.sync(this);
        return project;
    }
}
