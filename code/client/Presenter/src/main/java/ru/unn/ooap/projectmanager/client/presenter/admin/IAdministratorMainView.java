package ru.unn.ooap.projectmanager.client.presenter.admin;

import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

import java.io.IOException;

public interface IAdministratorMainView extends IUserMainView {
    void showUser(IUser user) throws IOException;
}
