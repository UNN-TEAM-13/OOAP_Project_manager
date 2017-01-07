package ru.unn.ooap.projectmanager.server.model.users.administrator;

public interface IUser extends ru.unn.ooap.projectmanager.server.model.users.IUser {
    void setUsername(String un);
    void setPassword(String pw);
    //void beginTransaction();
    //void commit();
    //void rollback();
}
