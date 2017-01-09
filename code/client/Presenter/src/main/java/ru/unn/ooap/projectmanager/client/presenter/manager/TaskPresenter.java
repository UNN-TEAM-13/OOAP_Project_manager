package ru.unn.ooap.projectmanager.client.presenter.manager;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;
import ru.unn.ooap.projectmanager.server.model.users.manager.ITask;

import java.util.Observable;
import java.util.Observer;

public class TaskPresenter implements Observer {
    private ManagerMainPresenter parentPresenter;
    private ITaskView view;
    private ITask task;

    private final BooleanProperty applyButtonDisable = new SimpleBooleanProperty();
    private final StringProperty titleText = new SimpleStringProperty();
    private final StringProperty descriptionText = new SimpleStringProperty();
    private final StringProperty givenHoursText = new SimpleStringProperty();

    private final ObjectProperty<ObservableList<IExecutor>> executors
            = new SimpleObjectProperty<>(FXCollections.observableArrayList());
    private final ObjectProperty<IExecutor> chosedExecutor = new SimpleObjectProperty<>();

    private final DoubleProperty spentHoursPercent = new SimpleDoubleProperty();
    private final BooleanProperty hideProgressInfo = new SimpleBooleanProperty(true);

    public TaskPresenter() {
        titleText.addListener((ov, olv, nev) -> validateInput());
        descriptionText.addListener((ov, olv, nev) -> validateInput());
        givenHoursText.addListener((ov, olv, nev) -> validateInput());
        titleText.set("");
        descriptionText.set("");
        givenHoursText.set("");
    }

    private void validateInput() {
        try {
            Double.parseDouble(givenHoursText.get());
            applyButtonDisable.set(titleText.get().equals(""));
        } catch (Exception e) {
            applyButtonDisable.set(true);
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
        titleText.set(task.getTitle());
        descriptionText.set(task.getDescription());
        givenHoursText.set(Double.toString(task.getGivenHours()));
        try {
            spentHoursPercent.set(task.getSpentHours() / task.getGivenHours());
            hideProgressInfo.set(false);
        } catch (NullPointerException e) {
            hideProgressInfo.set(true);
        }
        chosedExecutor.set(task.getExecutor());
    }

    public ITask getTask() {
        return task;
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

    public boolean getHideProgressInfo() {
        return hideProgressInfo.get();
    }

    public BooleanProperty hideProgressInfoProperty() {
        return hideProgressInfo;
    }

    public ObjectProperty<ObservableList<IExecutor>> executorsProperty() {
        return executors;
    }

    public ObservableList<IExecutor> getExecutors() {
        return executors.get();
    }

    public ObjectProperty<IExecutor> chosedExecutorProperty() {
        return chosedExecutor;
    }

    public IExecutor getChosedExecutor() {
        return chosedExecutor.get();
    }

    public void apply() {
        task.setExecutor(chosedExecutor.get());
        task.setTitle(titleText.get());
        task.setDescription(descriptionText.get());
        task.setGivenHours(Double.parseDouble(givenHoursText.get()));
    }

    public void setParentPresenter(final ManagerMainPresenter parentPresenter) {
        this.parentPresenter = parentPresenter;
        this.executors.get().clear();
        this.executors.get().setAll(parentPresenter.getUser().getExecutors());
    }

    @Override
    public void update(final Observable o, final Object arg) {
        setParentPresenter(parentPresenter);
    }
}
