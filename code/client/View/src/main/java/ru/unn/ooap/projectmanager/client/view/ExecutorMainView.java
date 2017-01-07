package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.executor.IExecutorMainView;
import ru.unn.ooap.projectmanager.client.presenter.executor.ExecutorMainPresenter;
import ru.unn.ooap.projectmanager.server.model.users.IUser;

public class ExecutorMainView extends UserMainView implements IExecutorMainView {
    @FXML
    private Pane content;
    @FXML
    private ListView tasks;

    @FXML
    private ExecutorMainPresenter presenter;

    @FXML
    void initialize() {
        presenter.setView(this);
    }

    @Override
    public void initUser(final IUser user) {
        presenter.setUser(user);
    }
}
