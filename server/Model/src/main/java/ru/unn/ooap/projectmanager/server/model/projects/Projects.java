package ru.unn.ooap.projectmanager.server.model.projects;

import ru.unn.ooap.projectmanager.server.model.IDAL;

import java.util.List;

public class Projects {
    private static Projects instance = null;
    private List<Project> projects;
    private IDAL storage;

    private Projects(IDAL storage) {
        this.storage = storage;
        this.projects = storage.getProjects();
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
        storage.syncProjects(this);
    }

    public List<Project> getAll() {

    }

    public List<Project> getOpen() {

    }

    public List<Project> getClosed() {

    }


}
