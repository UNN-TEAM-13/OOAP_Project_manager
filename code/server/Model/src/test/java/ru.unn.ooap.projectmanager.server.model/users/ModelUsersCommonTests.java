package ru.unn.ooap.projectmanager.server.model.users;

import org.junit.Test;
import static org.junit.Assert.*;

public class ModelUsersCommonTests {
    @Test
    public void testCreateEmptyUser() {
        User testUser = new User();
        assertEquals(0, testUser.getID());
        assertEquals(null, testUser.getUsername());
    }

    @Test
    public void testCreateSpecificUser() {
        User testUser = new User(25, "testName", "TestPassword");
        assertEquals(25, testUser.getID());
        assertEquals("testName", testUser.getUsername());
    }

    @Test
    public void testPasswordIsValid() {
        User testUser = new User(25, "testName", "TestPassword");
        assertTrue(testUser.isPasswordValid("TestPassword"));
    }

    @Test
    public void testChangePasswordIfOldIsTrue() {
        User testUser = new User(25, "testName", "TestPassword");
        assertTrue(testUser.changePassword("TestPassword", "NewTest"));
        assertTrue(testUser.isPasswordValid("NewTest"));
    }

    @Test
    public void testChangePasswordIfOldIsFalse() {
        User testUser = new User(25, "testName", "TestPassword");
        assertFalse(testUser.changePassword("OldPW", "NewPW"));
        assertFalse(testUser.isPasswordValid("NewPW"));
    }

    @Test
    public void testSetUiD() {
        User testUser = new User(25, "testName", "TestPassword");
        testUser.setId(30);
        assertEquals(30,testUser.getID());
    }

    @Test
    public void testSetUsername() {
        User testUser = new User(25, "testName", "TestPassword");
        testUser.setUsername("NewTestName");
        assertEquals("NewTestName", testUser.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExistsUsername() {
        User testUser = new User(25, "testName", "TestPassword");
        User testUser2 = new User(25, "test", "TestPassword");
        testUser.setUsername(testUser2.getUsername());
    }

    @Test
    public void testSetPassword() {
        User testUser = new User(25, "testName", "TestPassword");
        testUser.setPassword("NewPassword");
        assertTrue(testUser.isPasswordValid("NewPassword"));
    }

    @Test
    public void testToStringUsername() {
        User testUser = new User(25, "testName", "TestPassword");
        assertEquals("testName", testUser.toString());
    }
}
