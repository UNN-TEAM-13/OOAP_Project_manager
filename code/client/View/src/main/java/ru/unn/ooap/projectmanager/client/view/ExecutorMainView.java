package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.executor.IExecutorMainView;
import ru.unn.ooap.projectmanager.client.presenter.executor.ExecutorMainPresenter;


public class ExecutorMainView extends WindowTitledPane implements IExecutorMainView {
    @FXML
    private Pane content;
    @FXML
    private ListView tasks;

    @FXML
    private ExecutorMainPresenter presenter;

    private static final String WINDOW_TITLE = "PMS — Executor";

    @Override
    Node getFakeNode() {
        return tasks;
    }

    @Override
    public String getWindowTitle() {
        return WINDOW_TITLE;
    }
}
