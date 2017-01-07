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

public class ManagerMainPresenter implements IUserMainPresenter {
    private IManager user;
    private IManagerMainView view;
    private final ObjectProperty<TreeItem<Object>> root
            = new SimpleObjectProperty<>(new TreeItem<>("Root item"));

    @Override
    public void setView(final IUserMainView view) {
        this.view = (IManagerMainView) view;
    }

    IManagerMainView getView() {
        return view;
    }

    private void constructTreeRoot() {
        for (IProject project : user.getProjects()) {
            TreeItem<Object> projectTreeItem = new TreeItem<>(project);
            for (ITask task : project.getTasks()) {
                TreeItem<Object> taskTreeItem = new TreeItem<>(task);
                projectTreeItem.getChildren().add(taskTreeItem);
            }
            root.get().getChildren().clear();
            root.get().getChildren().add(projectTreeItem);
        }
    }

    public void setUser(final IUser user) {
        this.user = (IManager) user;
        constructTreeRoot();
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
        // TBD
        // Если в данный момент открыт проект
        // — создаём задачу с этим проектом
        // Если в данный момент открыта задача
        // или ничего не открыто
        // — создаём просто задачу,
        // не присваиваяя ей какой-либо проект
    }

    public void createProject() {
        // TBD
        // То же, что в таске
    }
}
