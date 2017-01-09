package ru.unn.ooap.projectmanager.server.model.users.executor;

import ru.unn.ooap.projectmanager.server.model.IDAL;
import ru.unn.ooap.projectmanager.server.model.tasks.Tasks;
import ru.unn.ooap.projectmanager.server.model.users.User;

import java.util.List;

public class Executor extends User implements IExecutor {
    public Executor(final IDAL storage) {
        super(storage);
    }

    public Executor(final int id, final String un, final String pw, final IDAL storage) {
        super(id, un, pw, storage);
    }

    public List<? extends ITask> getTasks() {
        return Tasks.getInstance().get(this);
    }
}
