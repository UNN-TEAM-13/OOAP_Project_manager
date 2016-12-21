package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.manager.IProjectView;
import ru.unn.ooap.projectmanager.client.presenter.manager.ProjectPresenter;

public class ProjectView implements IProjectView {
    @FXML
    TextField title;
    @FXML
    TextField description;
    @FXML
    Button applyButton;

    ProjectPresenter presenter = new ProjectPresenter(this);




}
