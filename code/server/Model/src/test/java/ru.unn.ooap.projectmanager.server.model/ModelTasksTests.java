package ru.unn.ooap.projectmanager.server.model;

import org.junit.Test;
import ru.unn.ooap.projectmanager.server.model.tasks.Task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

    @Test(expected = IllegalArgumentException.class)
    public void testProvideWrongHoursForTask() {
        Task testTask = new Task(1, "", "", null, null, 0, 0, false, false, null);
        testTask.addSpentHours(-2);
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

}
