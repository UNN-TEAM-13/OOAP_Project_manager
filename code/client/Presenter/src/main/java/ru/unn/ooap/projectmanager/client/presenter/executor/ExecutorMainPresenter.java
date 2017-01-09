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

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ExecutorMainPresenter implements IUserMainPresenter, Observer {
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
        tasks.get().setAll(this.user.getTasks());

        user.addObserver(this);
        for (ITask task : this.user.getTasks()) {
            task.addObserver(this);
        }
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

    public void setSelectedTask(final ITask task) {
        if (task == null) {
            return;
        }
        try {
            view.showTask(task);
        } catch (IOException e) {
            // set bad status
            e.printStackTrace();
        }
    }

    @Override
    public void update(final Observable o, final Object arg) {
        // Subscribed only to to Executor and to tasks, assigned to current Executor
        tasks.get().clear();
        tasks.get().setAll(user.getTasks());
    }
}
