package ru.unn.ooap.projectmanager.server.model;

import org.junit.Test;
import ru.unn.ooap.projectmanager.server.model.projects.Project;

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
    public void testToStringProjectTitle() {
        Project testProject = new Project(1, "", "", null, null);
        assertEquals("", testProject.toString());
    }

}
