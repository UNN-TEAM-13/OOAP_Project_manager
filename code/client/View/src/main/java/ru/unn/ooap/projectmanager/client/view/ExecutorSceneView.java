package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.executor.IExecutorSceneView;
import ru.unn.ooap.projectmanager.client.presenter.executor.ExecutorScenePresenter;


public class ExecutorSceneView implements IExecutorSceneView {
    @FXML
    private Pane content;
    @FXML
    private ListView tasks;

    private ExecutorScenePresenter presenter;
}
