package ru.unn.ooap.projectmanager.server.model.projects;

import ru.unn.ooap.projectmanager.server.model.tasks.Task;

import java.util.List;

public class Project {
    private String title;
    private String description;
    private List<Task> tasks;

    public Project(final String title) {
        this.title = title;
    }

    public void setTitle(final String newTitle) {
        title = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(final String newDescription) {
        description = newDescription;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(final Task newTask) {
        tasks.add(newTask);
    }
}
