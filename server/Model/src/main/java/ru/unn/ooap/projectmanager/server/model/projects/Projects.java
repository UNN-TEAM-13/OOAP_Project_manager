package ru.unn.ooap.projectmanager.server.model.projects;

import ru.unn.ooap.projectmanager.server.model.IDAL;

import java.util.List;

public class Projects {
    private static Projects instance = null;
    private List<Project> projects;
    private IDAL storage;

    private Projects(IDAL storage) {
        this.storage = storage;
        storage.sync(this);
    }

    public synchronized static void init(IDAL storage) {
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
}
