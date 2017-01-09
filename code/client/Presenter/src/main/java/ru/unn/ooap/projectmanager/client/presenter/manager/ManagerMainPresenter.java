package ru.unn.ooap.projectmanager.client.presenter.manager;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TreeItem;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.manager.IManager;
import ru.unn.ooap.projectmanager.server.model.users.manager.IProject;
import ru.unn.ooap.projectmanager.server.model.users.manager.ITask;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ManagerMainPresenter implements IUserMainPresenter, Observer {
    private IManager user;
    private IManagerMainView view;
    private final ObjectProperty<TreeItem<Object>> root
            = new SimpleObjectProperty<>(new TreeItem<>("Root item"));
    private Object selected;

    @Override
    public void setView(final IUserMainView view) {
        this.view = (IManagerMainView) view;
    }

    IManagerMainView getView() {
        return view;
    }

    private void constructTreeRoot() {
        root.get().getChildren().clear();
        for (IProject project : user.getProjects()) {
            TreeItem<Object> projectTreeItem = new TreeItem<>(project);
            for (ITask task : project.getTasks()) {
                TreeItem<Object> taskTreeItem = new TreeItem<>(task);
                projectTreeItem.getChildren().add(taskTreeItem);
            }
            root.get().getChildren().add(projectTreeItem);
        }
    }

    public void setUser(final IUser user) {
        this.user = (IManager) user;
        constructTreeRoot();
        for (IProject project : ((IManager) user).getProjects()) {
            project.addObserver(this);
            for (ITask task : project.getTasks()) {
                task.addObserver(this);
            }
        }
    }

    IManager getUser() {
        return user;
    }

    public TreeItem<Object> getRoot() {
        return root.get();
    }

    public ObjectProperty<TreeItem<Object>> rootProperty() {
        return root;
    }

    public void setSelected(final Object object) {
        if (object == null) {
            return;
        }
        selected = object;
        try {
            if (object instanceof ITask) {
                view.showTask((ITask) object);
            } else if (object instanceof IProject) {
                view.showProject((IProject) object);
            }
        } catch (IOException e) {
            // here set status
        }
    }

    public void createTask() {
        ITask task;
        if (selected instanceof IProject) {
            task = user.createTask((IProject) selected);
        } else {
            task = user.createTask();
        }
        task.addObserver(this);
        setSelected(task);
    }

    public void createProject() {
        IProject project = user.createProject();
        project.addObserver(this);
        setSelected(project);
    }

    @Override
    public void update(final Observable o, final Object arg) {
        // Subscribed only to all Project and Task instances
        constructTreeRoot();
    }
}
