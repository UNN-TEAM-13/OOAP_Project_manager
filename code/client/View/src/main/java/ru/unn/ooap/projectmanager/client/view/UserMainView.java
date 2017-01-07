package ru.unn.ooap.projectmanager.client.view;

import javafx.scene.Node;
import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.IUser;

abstract class UserMainView implements IUserMainView {
    abstract Node getNode();
    public IUser getUser() {
        PMSStage window = (PMSStage) getNode().getScene().getWindow();
        return window.getUser();
    }
}
