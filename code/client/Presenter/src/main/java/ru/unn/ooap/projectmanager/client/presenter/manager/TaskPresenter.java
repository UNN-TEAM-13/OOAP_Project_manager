package ru.unn.ooap.projectmanager.client.presenter.manager;

import javafx.beans.property.*;
import ru.unn.ooap.projectmanager.server.model.users.manager.IManager;

public class TaskPresenter {
    private IManager manager;
    private ITaskView view;

    private BooleanProperty applyButtonDisable = new SimpleBooleanProperty();
    private StringProperty titleText = new SimpleStringProperty();
    private StringProperty descriptionText = new SimpleStringProperty();
    private StringProperty givenHoursText = new SimpleStringProperty();
    private DoubleProperty spentHoursPercent = new SimpleDoubleProperty();

    public TaskPresenter() {
        // initialisation
    }

    public void setView(ITaskView view) {
        this.view = view;
    }

    public void setManager(IManager manager) {
        this.manager = manager;
    }

    public BooleanProperty applyButtonDisableProperty() {
        return applyButtonDisable;
    }

    public boolean getApplyButtonDisable() {
        return applyButtonDisable.get();
    }

    public StringProperty titleTextProperty() {
        return titleText;
    }

    public StringProperty descriptionTextProperty() {
        return descriptionText;
    }

    public StringProperty givenHoursTextProperty() {
        return givenHoursText;
    }

    public DoubleProperty spentHoursPercentProperty() {
        return spentHoursPercent;
    }

    public double getSpentHoursPercent() {
        return spentHoursPercent.get();
    }

    public void apply() {
        // do apply
    }
}
