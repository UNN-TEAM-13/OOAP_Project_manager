package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.manager.ManagerMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.manager.TaskPresenter;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;
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
    private ChoiceBox<IExecutor> executorChoiceBox;

    @FXML
    private TaskPresenter presenter;

    @FXML
    private void initialize() {
        title.textProperty().bindBidirectional(presenter.titleTextProperty());
        description.textProperty().bindBidirectional(presenter.descriptionTextProperty());
        givenHoursTextField.textProperty().bindBidirectional(presenter.givenHoursTextProperty());

        executorChoiceBox.getSelectionModel().selectedItemProperty()
                .addListener(((observable, oldValue, newValue) ->
                        presenter.chosedExecutorProperty().set(newValue)));

        apply.setOnAction((actionEvent) -> presenter.apply());
    }

    void initTask(final ITask task) {
        presenter.setTask(task);
        executorChoiceBox.getSelectionModel().select(presenter.getChosedExecutor());
    }

    void setParentPresenter(final ManagerMainPresenter parentPresenter) {
        presenter.setParentPresenter(parentPresenter);
    }
}
