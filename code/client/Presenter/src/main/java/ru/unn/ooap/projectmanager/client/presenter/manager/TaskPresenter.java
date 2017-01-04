package ru.unn.ooap.projectmanager.client.presenter.manager;

import javafx.beans.property.*;
import ru.unn.ooap.projectmanager.server.model.users.manager.IManager;

public class TaskPresenter {
    private IManager manager;
    private ITaskView view;

    private final BooleanProperty applyButtonDisable = new SimpleBooleanProperty();
    private final StringProperty titleText = new SimpleStringProperty();
    private final StringProperty descriptionText = new SimpleStringProperty();
    private final StringProperty givenHoursText = new SimpleStringProperty();
    private final DoubleProperty spentHoursPercent = new SimpleDoubleProperty();

    public TaskPresenter() {
        // initialisation
    }

    public void setView(final ITaskView view) {
        this.view = view;
    }

    public ITaskView getView() {
        return view;
    }

    public void setManager(final IManager manager) {
        this.manager = manager;
    }

    public IManager getManager() {
        return manager;
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
