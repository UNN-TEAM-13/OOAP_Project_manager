package ru.unn.ooap.projectmanager.server.model.projects;

import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.tasks.Task;

import java.util.List;

public class Project {
    private int id;
    private String title;
    private String description;
    private List<Task> tasks;
    private IDAL storage;

    public Project() {

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
    public void addTask(Task task) {

    }
}
