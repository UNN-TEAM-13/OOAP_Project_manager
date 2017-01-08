package ru.unn.ooap.projectmanager.server.model.tasks;

import ru.unn.ooap.projectmanager.server.model.IDAL;
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
    private final IDAL storage;

    public Task(final IDAL storage) {
        this(-1, "", "", null, null, 0, 0, false, false, storage);
    }

    // Only for in DAL use
//CHECKSTYLE:OFF
    public Task(final int id, final String title, final String description,
                final Project project, final Executor executor,
                final double givenHours, final double spentHours,
                final boolean open, final boolean done, final IDAL storage) {
//CHECKSTYLE:ON
        this.id = id;
        this.title = title;
        this.description = description;
        this.project = project;
        this.executor = executor;
        this.givenHours = givenHours;
        this.spentHours = spentHours;
        this.open = open;
        this.done = done;
        this.storage = storage;
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
        storage.sync(this);
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

    @Override
    public String toString() {
        return title;
    }
}
