package ru.unn.ooap.projectmanager.server.model;

import org.junit.Test;
import ru.unn.ooap.projectmanager.server.model.projects.Project;
import ru.unn.ooap.projectmanager.server.model.tasks.Task;

import static org.junit.Assert.assertEquals;

public class ModelProjectTests {
    @Test
    public void testCreateEmptyProject() {
        Project testProject = new Project(1, "", "", null, null);
        assertEquals(1, testProject.getId());
        assertEquals("", testProject.getTitle());
        assertEquals("", testProject.getDescription());
        assertEquals(null, testProject.getTasks());
    }

    @Test
    public void testSetTitleOfProject() {
        Project testProject = new Project(1, "", "", null, null);
        testProject.setTitle("TestTitle");
        assertEquals("TestTitle", testProject.getTitle());
    }

    @Test
    public void testSetDescriptionOfProject() {
        Project testProject = new Project(1, "", "", null, null);
        testProject.setDescription("TestDescription");
        assertEquals("TestDescription", testProject.getDescription());
    }

    @Test
    public void testToStringProjectTitle() {
        Project testProject = new Project(1, "", "", null, null);
        assertEquals("", testProject.toString());
    }

    @Test
    public void testAddOneTaskToProject() {
        Project testProject = new Project(1, null, null, null, null);
        Task testTask = new Task(1,"","",null,null,0,0,true,false,null);
        testProject.addTask(testTask);
        assertEquals(1, testProject.getTasks().size());
    }


}
