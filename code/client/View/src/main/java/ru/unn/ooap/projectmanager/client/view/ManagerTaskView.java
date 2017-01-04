package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.manager.TaskPresenter;

public class ManagerTaskView implements
        ru.unn.ooap.projectmanager.client.presenter.manager.ITaskView {
    @FXML
    private TextField title;
    @FXML
    private TextField description;
    @FXML
    private TextField givenHoursTextField;
    @FXML
    private Button apply;
    @FXML
    private TaskPresenter presenter;

    private void initialize() {
        title.textProperty().bindBidirectional(presenter.titleTextProperty());
        description.textProperty().bindBidirectional(presenter.descriptionTextProperty());
        givenHoursTextField.textProperty().bindBidirectional(presenter.givenHoursTextProperty());

        apply.setOnAction((actionEvent) -> presenter.apply());
    }
}
