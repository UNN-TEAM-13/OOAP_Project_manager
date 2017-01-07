package ru.unn.ooap.projectmanager.client.presenter.executor;

import javafx.beans.property.*;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;
import ru.unn.ooap.projectmanager.server.model.users.executor.ITask;

public class TaskPresenter {
    private ITaskView view;
    private IExecutor executor;
    private ITask task;

    private final StringProperty spentTimeReport = new SimpleStringProperty("");
    private final StringProperty title = new SimpleStringProperty("");
    private final StringProperty description = new SimpleStringProperty("");
    private final StringProperty givenHoursText = new SimpleStringProperty("");
    private final StringProperty spentHoursText = new SimpleStringProperty("");
    private final DoubleProperty spentHoursPercent = new SimpleDoubleProperty();

    public void setView(final ITaskView view) {
        this.view = view;
    }

    public ITaskView getView() {
        return view;
    }

    public void setExecutor(final IExecutor executor) {
        this.executor = executor;
    }

    public IExecutor getExecutor() {
        return executor;
    }

    public void setTask(final ITask task) {
        this.task = task;
        title.set(task.getTitle());
        description.set(task.getDescription());
        givenHoursText.set(Double.toString(task.getGivenHours()));
        spentHoursText.set(Double.toString(task.getSpentHours()));
        spentHoursPercent.set(task.getSpentHours() / task.getGivenHours());
    }

    public ITask getTask() {
        return task;
    }

    public StringProperty spendTimeReportProperty() {
        return spentTimeReport;
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty givenHoursTextProperty() {
        return description;
    }

    public String getGivenHoursText() {
        return description.get();
    }

    public StringProperty spentHoursTextProperty() {
        return spentHoursText;
    }

    public String getSpentHoursText() {
        return spentHoursText.get();
    }

    public DoubleProperty spentHoursPercentProperty() {
        return spentHoursPercent;
    }

    public Double getSpentHoursPercent() {
        return spentHoursPercent.get();
    }
}
