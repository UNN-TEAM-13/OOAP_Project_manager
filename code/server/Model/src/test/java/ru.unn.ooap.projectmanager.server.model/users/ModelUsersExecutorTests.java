package ru.unn.ooap.projectmanager.server.model.users;

import org.junit.Test;
import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;
import static org.junit.Assert.*;

public class ModelUsersExecutorTests {
    @Test
    public void testGetExecutorTasks() {
        Executor testExecutor = new Executor(1,"","");
        Task testTask1 = new Task(1,"","",null, testExecutor,20,10,false,false,null);
        Task testTask2 = new Task(1,"","",null, testExecutor,20,10,false,false,null);
        assertEquals(2, testExecutor.getTasks().size());
    }
}
