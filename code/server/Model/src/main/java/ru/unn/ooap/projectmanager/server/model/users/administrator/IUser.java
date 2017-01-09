package ru.unn.ooap.projectmanager.server.model.users.administrator;

import java.io.Serializable;

public interface IUser extends ru.unn.ooap.projectmanager.server.model.users.IUser, Serializable {
    void setUsername(String un);
    void setPassword(String pw);
}
