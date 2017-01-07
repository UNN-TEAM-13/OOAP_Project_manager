package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.manager.TaskPresenter;
import ru.unn.ooap.projectmanager.server.model.users.manager.ITask;

public class ManagerTaskView implements
        ru.unn.ooap.projectmanager.client.presenter.manager.ITaskView {
    @FXML
    private TextField title;
    @FXML
    private TextField description;
    @FXML
    private TextField givenHoursTextField;
    @FXML
    private ProgressBar spentHoursProgressBar;
    @FXML
    private Button apply;

    @FXML
    private TaskPresenter presenter;

    @FXML
    private void initialize() {
        title.textProperty().bindBidirectional(presenter.titleTextProperty());
        description.textProperty().bindBidirectional(presenter.descriptionTextProperty());
        givenHoursTextField.textProperty().bindBidirectional(presenter.givenHoursTextProperty());

        apply.setOnAction((actionEvent) -> presenter.apply());
    }

    void initTask(final ITask task) {
        presenter.setTask(task);
    }
}
