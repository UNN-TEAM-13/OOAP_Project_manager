package ru.unn.ooap.projectmanager.client.presenter.executor;

import javafx.beans.property.*;
import ru.unn.ooap.projectmanager.server.model.users.executor.ITask;

public class TaskPresenter {
    private ITaskView view;
    private ITask task;

    private final StringProperty spentTimeReport = new SimpleStringProperty();

    private final StringProperty title = new SimpleStringProperty("");
    private final StringProperty description = new SimpleStringProperty("");
    private final StringProperty givenHoursText = new SimpleStringProperty("");
    private final StringProperty spentHoursText = new SimpleStringProperty("");
    private final DoubleProperty spentHoursPercent = new SimpleDoubleProperty();
    private final BooleanProperty reportSpentTimeButtonDisabled
            = new SimpleBooleanProperty();

    public TaskPresenter() {
        spentTimeReport.addListener(((observable, oldValue, newValue) -> validateInput()));
        spentTimeReport.set("");
    }

    private void validateInput() {
        try {
            Double.parseDouble(spentTimeReport.get());
            reportSpentTimeButtonDisabled.set(false);
        } catch (Exception e) {
            reportSpentTimeButtonDisabled.set(true);
        }
    }

    public void setView(final ITaskView view) {
        this.view = view;
    }

    public ITaskView getView() {
        return view;
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
        return givenHoursText;
    }

    public String getGivenHoursText() {
        return givenHoursText.get();
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

    public BooleanProperty reportSpentTimeButtonDisabledProperty() {
        return reportSpentTimeButtonDisabled;
    }

    public boolean getReportSpentTimeButtonDisabled() {
        return reportSpentTimeButtonDisabled.get();
    }

    public void reportSpentTime() {
        task.addSpentHours(Double.parseDouble(spentTimeReport.get()));
    }
}
