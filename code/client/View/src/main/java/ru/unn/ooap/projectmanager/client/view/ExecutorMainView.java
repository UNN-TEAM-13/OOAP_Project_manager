package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.executor.IExecutorMainView;
import ru.unn.ooap.projectmanager.client.presenter.executor.ExecutorMainPresenter;
import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.executor.ITask;

import java.io.IOException;

public class ExecutorMainView extends UserMainView implements IExecutorMainView {
    @FXML
    private Pane content;
    @FXML
    private ListView<ITask> tasks;

    @FXML
    private ExecutorMainPresenter presenter;

    @FXML
    void initialize() {
        presenter.setView(this);
        tasks.getSelectionModel().selectedItemProperty().addListener(
                (ov, oldValue, newValue) -> presenter.setSelectedTask(newValue));
    }

    @Override
    public void initUser(final IUser user) {
        presenter.setUser(user);
    }

    @Override
    public void showTask(final ITask task) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExecutorTaskView.fxml"));
        content.getChildren().clear();
        content.getChildren().add(loader.load());
        ExecutorTaskView controller = loader.<ExecutorTaskView>getController();
        controller.initTask(task);
    }
}
