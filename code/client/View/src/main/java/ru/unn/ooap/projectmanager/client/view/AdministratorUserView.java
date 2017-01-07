package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.unn.ooap.projectmanager.client.presenter.admin.UserPresenter;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

public class AdministratorUserView {
    @FXML
    private TextField username;
    @FXML
    private UserPresenter presenter;

    public void initUser(final IUser user) {
        presenter.setUser(user);
    }
}
