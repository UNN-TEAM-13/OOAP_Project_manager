package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.executor.IExecutorMainView;
import ru.unn.ooap.projectmanager.client.presenter.executor.ExecutorMainPresenter;


public class ExecutorMainView extends UserMainView implements IExecutorMainView {
    @FXML
    private Pane content;
    @FXML
    private ListView tasks;

    @FXML
    private ExecutorMainPresenter presenter;

    @Override
    Node getNode() {
        return tasks;
    }

    void initialize() {
        presenter.setView(this);
    }
}
