package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.executor.ITaskView;
import ru.unn.ooap.projectmanager.client.presenter.executor.TaskPresenter;
import ru.unn.ooap.projectmanager.server.model.users.executor.ITask;

public class ExecutorTaskView implements ITaskView {
    @FXML
    private TextField reportSpentTimeText;
    @FXML
    private Button reportSpentTimeButton;
    @FXML
    private TaskPresenter presenter;

    @FXML
    private void initialize() {
        presenter.setView(this);
        reportSpentTimeButton.setOnAction((actionEvent) -> presenter.reportSpentTime());
        reportSpentTimeText.textProperty().bindBidirectional(presenter.spendTimeReportProperty());
    }

    void initTask(final ITask task) {
        presenter.setTask(task);
    }
}
