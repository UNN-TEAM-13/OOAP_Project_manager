package ru.unn.ooap.projectmanager.client.presenter.executor;

import javafx.beans.property.*;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;

public class TaskPresenter {
    private ITaskView view;
    private IExecutor executor;

    private StringProperty spentTimeReport = new SimpleStringProperty();
    private StringProperty title = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private DoubleProperty givenHours = new SimpleDoubleProperty();
    private StringProperty givenHoursText = new SimpleStringProperty();
    private DoubleProperty spentHours = new SimpleDoubleProperty();
    private StringProperty spentHoursText = new SimpleStringProperty();
    private IntegerProperty spentHoursPercent = new SimpleIntegerProperty();

    public void setView(ITaskView view) {
        this.view = view;
    }

    public void setExecutor(IExecutor executor) {
        this.executor = executor;
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

    public IntegerProperty spentHoursPercentProperty() {
        return spentHoursPercent;
    }

    public Integer getSpentHoursPercent() {
        return spentHoursPercent.get();
    }
}
