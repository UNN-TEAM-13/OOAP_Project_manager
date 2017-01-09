package ru.unn.ooap.projectmanager.server.model.users;

import org.junit.Test;
import ru.unn.ooap.projectmanager.server.model.users.manager.Manager;

import static org.junit.Assert.assertEquals;

public class ModelUsersManagerTests {
    @Test
    public void testCreateEmptyManager() {
        Manager testManager = new Manager(1, "", "");
        assertEquals(1, testManager.getID());
        assertEquals("", testManager.getUsername());
    }

//    @Test
//    public void testCreateProject() {
//        Manager testManager = new Manager(1, "", "");
//        testManager.createProject();
//    }
//
//    @Test
//    public void testGetProjects() {
//        Manager testManager = new Manager(1, "", "");
//        Project testProject = new Project(1, "", "", null, null);
//        assertEquals(1, testManager.getProjects());
//    }
//
//    @Test
//    public void testCreateTask() {
//        Manager testManager = new Manager(1, "", "");
//        Project testProject = new Project(1, "", "", null, null);
//        testManager.createTask(testProject);
//    }
}
