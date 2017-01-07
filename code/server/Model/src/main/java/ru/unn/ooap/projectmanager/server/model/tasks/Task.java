package ru.unn.ooap.projectmanager.server.model.tasks;

import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;

public class Task implements ru.unn.ooap.projectmanager.server.model.users.executor.ITask,
        ru.unn.ooap.projectmanager.server.model.users.manager.ITask {

    /*
     As we work with objects directly, we don't need IDs for Task, Project and User,
     */
    private int id;
    private String title;
    private String description;
    private Executor executor;
    private Project project;
    private double givenHours;
    private double spentHours;
    private boolean open;
    private boolean done;

    public Task() {
        // initialisation
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setExecutor(final Executor executor) {
        this.executor = executor;
    }

    @Override
    public Executor getExecutor() {
        return executor;
    }

    @Override
    public void setProject(final Project project) {
        this.project = project;
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public double getGivenHours() {
        return givenHours;
    }

    @Override
    public void setGivenHours(final double givenHours) {
        if (givenHours <= 0) {
            throw new IllegalArgumentException();
        }
        this.givenHours = givenHours;
    }

    @Override
    public void addSpentHours(final double additionalSpentHours) {
        if (additionalSpentHours < 0) {
            throw new IllegalArgumentException();
        }
        spentHours += additionalSpentHours;
    }

    @Override
    public double getSpentHours() {
        return spentHours;
    }

    @Override
    public double getLeftHours() {
        return givenHours - spentHours;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void setDone(final boolean done) {
        this.done = done;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void open() {
        open = true;
    }

    @Override
    public void close() {
        open = false;
    }
}
