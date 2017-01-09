package ru.unn.ooap.projectmanager.server.model.users.manager;

import ru.unn.ooap.projectmanager.server.model.users.IUser;
import ru.unn.ooap.projectmanager.server.model.users.executor.IExecutor;

import java.util.List;

public interface IManager extends IUser {
    List<? extends IProject> getProjects();
    ITask createTask();
    ITask createTask(IProject project);
    IProject createProject();
    List<? extends IExecutor> getExecutors();
}
