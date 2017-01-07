package ru.unn.ooap.projectmanager.client.view;

import ru.unn.ooap.projectmanager.client.presenter.IUserMainView;
import ru.unn.ooap.projectmanager.server.model.users.IUser;

abstract class UserMainView implements IUserMainView {
    abstract void initUser(IUser user);
}
