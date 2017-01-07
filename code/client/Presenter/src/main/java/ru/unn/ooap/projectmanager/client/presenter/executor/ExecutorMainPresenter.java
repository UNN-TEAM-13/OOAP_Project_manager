package ru.unn.ooap.projectmanager.client.presenter.executor;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;
import ru.unn.ooap.projectmanager.server.model.users.executor.ITask;

public class ExecutorMainPresenter implements IUserMainPresenter {
    private IExecutor user;
    private IExecutorMainView view;
    private final ObjectProperty<ObservableList<ITask>> tasks
            = new SimpleObjectProperty<>(FXCollections.observableArrayList());

    @Override
    public void setView(final IUserMainView view) {
        this.view = (IExecutorMainView) view;
    }

    IExecutorMainView getView() {
        return view;
    }

    public void setUser(final IUser user) {
        this.user = (IExecutor) user;
        tasks.get().clear();
        tasks.set(FXCollections.observableArrayList(this.user.getTasks()));
    }

    IExecutor getUser() {
        return user;
    }

    public ObservableList<ITask> getTasks() {
        return tasks.get();
    }

    public ObjectProperty<ObservableList<ITask>> tasksProperty() {
        return tasks;
    }
}
