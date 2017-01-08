package ru.unn.ooap.projectmanager.server.model.users.executor;

import ru.unn.ooap.projectmanager.server.model.tasks.Tasks;
import ru.unn.ooap.projectmanager.server.model.users.User;

import java.util.List;

public class Executor extends User implements IExecutor {
    public Executor(final int id, final String un, final String pw) {
        super(id, un, pw);
    }

    public List<? extends ITask> getTasks() {
        return Tasks.getInstance().get(this);
    }
}
