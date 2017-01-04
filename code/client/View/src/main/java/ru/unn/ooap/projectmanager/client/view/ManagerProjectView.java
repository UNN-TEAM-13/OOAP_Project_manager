package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.manager.IProjectView;
import ru.unn.ooap.projectmanager.client.presenter.manager.ProjectPresenter;
/*
import javafx.scene.control.ListView;
import ru.unn.ooap.projectmanager.server.model.users.manager.ITask;
 */

public class ManagerProjectView implements IProjectView {
    @FXML
    private TextField title;
    @FXML
    private TextField description;
    @FXML
    private Button applyButton;
    /*
    @FXML
    private ListView<ITask> tasks;
     */

    @FXML
    private ProjectPresenter presenter;

    private void initialize() {
        applyButton.setOnAction((actionEvent) -> presenter.apply());
        title.textProperty().bindBidirectional(presenter.titleTextProperty());
        description.textProperty().bindBidirectional(presenter.descriptionTextProperty());
    }
}
