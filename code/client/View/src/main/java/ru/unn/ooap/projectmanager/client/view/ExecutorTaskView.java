package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.executor.ITaskView;
import ru.unn.ooap.projectmanager.client.presenter.executor.TaskPresenter;

public class ExecutorTaskView implements ITaskView {
    @FXML
    private TextField reportSpentTime;
    @FXML
    private TaskPresenter presenter;


    private void initialize() {
        presenter.setView(this);
        reportSpentTime.textProperty().bindBidirectional(presenter.spendTimeReportProperty());
    }
}
