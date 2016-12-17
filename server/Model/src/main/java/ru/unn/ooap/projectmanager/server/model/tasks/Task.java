package ru.unn.ooap.projectmanager.server.model.tasks;

import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;

public class Task implements
        ru.unn.ooap.projectmanager.server.model.users.executor.ITask,
        ru.unn.ooap.projectmanager.server.model.users.manager.ITask {

    private String title;
    private String description;
    private Executor executor;
    private double givenHours;
    private double spentHours;

    public Task(final String title) {
        this.title = title;
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

    public void setExecutor(final Executor executor) {
        this.executor = executor;
    }

    public Executor getExecutor() {
        return executor;
    }

    public double getGivenHours() {
        return givenHours;
    }

    public void setGivenHours(final double givenHours) {
        if (givenHours <= 0) {
            throw new IllegalArgumentException();
        }
        this.givenHours = givenHours;
    }

    public void addSpentHours(final double additionalSpentHours) {
        if (additionalSpentHours < 0) {
            throw new IllegalArgumentException();
        }
        spentHours += additionalSpentHours;
    }

    public double getSpentHours() {
        return spentHours;
    }

    public double getLeftHours() {
        return givenHours - spentHours;
    }
}
