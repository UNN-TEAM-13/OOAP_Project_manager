package ru.unn.ooap.projectmanager.server.model;

import org.junit.Test;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.tasks.Task;
import ru.unn.ooap.projectmanager.server.model.users.executor.Executor;

import static org.junit.Assert.*;

public class ModelTasksTests {
    @Test
    public void testCreateEmptyTask() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        assertEquals(1, testTask.getID());
        assertEquals("", testTask.getTitle());
        assertEquals("", testTask.getDescription());
        assertEquals(null, testTask.getProject());
        assertEquals(null, testTask.getExecutor());
        assertEquals(0, testTask.getGivenHours(), 0);
        assertEquals(0, testTask.getSpentHours(), 0);
        assertFalse(testTask.isOpen());
        assertFalse(testTask.isDone());
    }

    @Test
    public void testSetTaskTitle() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        testTask.setTitle("testTitle");
        assertEquals("testTitle", testTask.getTitle());
    }

//    @Test
//    public void testSetTaskDescription() {
//        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
//        testTask.setDescription("testDescription");
//        assertEquals("testDescription", testTask.getDescription());
//    }

    @Test
    public void testMarkTaskAsComplete() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        testTask.setDone(true);
        assertTrue(testTask.isDone());
    }

    @Test
    public void testProvideSpentHoursForTask() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        testTask.addSpentHours(10);
        assertEquals(10, testTask.getSpentHours(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProvideWrongHoursForTask() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        testTask.addSpentHours(-2);
    }

    @Test
    public void testThatTaskIsOpen() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        testTask.open();
        assertTrue(testTask.isOpen());
    }

    @Test
    public void testThatTaskIsClosed() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, true, false, null);
        testTask.close();
        assertFalse(testTask.isOpen());
    }

    @Test
    public void testProvideGivenHoursForTask() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        testTask.setGivenHours(20);
        assertEquals(20, testTask.getGivenHours(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProvideWrongGivenHoursForTask() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        testTask.setGivenHours(-10);
    }

    @Test
    public void testCheckLeftTimeCalculation() {
        Task testTask = new Task(1, "", "", null, null, 20, 10, false, false, null);
        assertEquals(10, testTask.getLeftHours(), 0);
    }

    @Test
    public void testToStringTaskTitle() {
        Task testTask = new Task(1, "", "", null, null, 20, 10, false, false, null);
        assertEquals("", testTask.toString());
    }

    @Test
    public void testSetProjectForTask() {
        Task testTask = new Task(1, "", "", null, null, 20, 10, false, false, null);
        Project testProject = new Project(1, "", "", null, null);
        testTask.setProject(testProject);
        assertEquals(testProject, testTask.getProject());
    }

    @Test
    public void testSetExecutorForTask() {
        Task testTask = new Task(1, "", "", null, null, 20, 10, false, false, null);
        Executor testExecutor = new Executor(1, "", "");
        testTask.setExecutor(testExecutor);
        assertEquals(testExecutor, testTask.getExecutor());
    }
}
