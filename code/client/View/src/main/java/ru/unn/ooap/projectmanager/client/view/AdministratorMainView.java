package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.admin.IAdminMainView;
import ru.unn.ooap.projectmanager.client.presenter.admin.AdminMainPresenter;

public class AdministratorMainView extends WindowTitledPane implements IAdminMainView {
    @FXML
    private Pane content;
    @FXML
    private ListView users;
    @FXML
    private AdminMainPresenter presenter;

    private static final String WINDOW_TITLE = "PMS — Administrator";

    @Override
    Node getFakeNode() {
        return users;
    }

    void initialize() {
        setWindowTitle(WINDOW_TITLE);
        presenter.setUser(((PMSStage) getStage()).getUser());
    }


}
