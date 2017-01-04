package ru.unn.ooap.projectmanager.server.model.users.administrator;

import java.util.List;

public interface IAdministrator extends IUser {
    List<? extends IUser> getUsers();
    List<? extends IUser> getAdministrators();
    List<? extends IUser> getManagers();
    List<? extends IUser> getExecutors();
    IUser createAdministrator();
    IUser createManager();
    IUser createExecutor();
}
