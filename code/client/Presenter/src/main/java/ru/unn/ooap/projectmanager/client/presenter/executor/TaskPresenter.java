package ru.unn.ooap.projectmanager.client.presenter.executor;

import javafx.beans.property.*;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;

public class TaskPresenter {
    private ITaskView view;
    private IExecutor executor;

    private final StringProperty spentTimeReport = new SimpleStringProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final DoubleProperty givenHours = new SimpleDoubleProperty();
    private final StringProperty givenHoursText = new SimpleStringProperty();
    private final DoubleProperty spentHours = new SimpleDoubleProperty();
    private final StringProperty spentHoursText = new SimpleStringProperty();
    private final IntegerProperty spentHoursPercent = new SimpleIntegerProperty();

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
