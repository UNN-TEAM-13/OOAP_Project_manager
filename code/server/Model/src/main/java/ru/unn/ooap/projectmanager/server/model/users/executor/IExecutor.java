package ru.unn.ooap.projectmanager.server.model.users.executor;

import ru.unn.ooap.projectmanager.server.model.users.IUser;

import java.util.List;

public interface IExecutor extends IUser {
    List<? extends ITask> getTasks();
}
