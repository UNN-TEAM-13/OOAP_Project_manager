package ru.unn.ooap.projectmanager.server.model.users;

import org.junit.Test;
import ru.unn.ooap.projectmanager.server.model.users.administrator.Administrator;

import static org.junit.Assert.*;

public class ModelUsersAdministratorTests {
    @Test
    public void testCreateAdministrator() {
        Administrator testAdmin = new Administrator(1,"", "");
        assertEquals(1, testAdmin.getUsers());
    }

    @Test
    public void testAdminCreateAdmin() {
        Administrator testAdmin = new Administrator(1,"", "");
        testAdmin.createAdministrator();
        assertEquals(1,testAdmin.getAdministrators());
    }

    @Test
    public void testAdminCreateExecutor() {
        Administrator testAdmin = new Administrator(1,"", "");
        testAdmin.createExecutor();
        assertEquals(1, testAdmin.getExecutors());
    }

    @Test
    public void tesyAdminCreateManager() {
        Administrator testAdmin = new Administrator(1,"", "");
        testAdmin.createManager();
        assertEquals(1, testAdmin.getManagers());
    }
}
