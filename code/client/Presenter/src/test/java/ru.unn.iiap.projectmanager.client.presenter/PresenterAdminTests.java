package ru.unn.iiap.projectmanager.client.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.ooap.projectmanager.client.presenter.admin.AdministratorMainPresenter;
import ru.unn.ooap.projectmanager.client.presenter.admin.UserPresenter;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

import java.util.Observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PresenterAdminTests {
    private UserPresenter userPresenter;
    private IUser iUser = new IUser() {
        @Override
        public void setUsername(final String un) {

        }

        @Override
        public void setPassword(final String pw) {

        }

        @Override
        public int getID() {
            return 0;
        }

        @Override
        public String getUsername() {
            return "";
        }

        @Override
        public boolean isPasswordValid(final String password) {
            return false;
        }

        @Override
        public void addObserver(final Observer o) {

        }

        @Override
        public void deleteObserver(final Observer o) {

        }

        @Override
        public void notifyObservers() {

        }
    };
    private AdministratorMainPresenter adminPresenter;



    @Before
    public void setUp() {
        userPresenter = new UserPresenter();
        adminPresenter = new AdministratorMainPresenter();
    }

    @After
    public void tearDown() {
        userPresenter = null;
        iUser = null;
        adminPresenter = null;
    }

    @Test
    public void testDefaultValuesForUserPresenter() {
        assertEquals("", userPresenter.usernameProperty().get());
        assertEquals("", userPresenter.passwordProperty().get());
    }

    @Test
    public void testChangeUsername() {
        userPresenter.usernameProperty().set("Test");
        assertEquals("Test", userPresenter.getUsername());
    }

    @Test
    public void testChangePassword() {
        userPresenter.passwordProperty().set("Test");
        assertEquals("Test", userPresenter.getPassword());
    }

    @Test
    public void testApplyUsernameButtonIsDisabled() {
        userPresenter.applyUsernameButtonDisabledProperty().set(true);
        assertTrue(userPresenter.getApplyUsernameButtonDisabled());
    }

    @Test
    public void testApplyPasswordButtonIsDisabled() {
        userPresenter.applyPasswordButtonDisabledProperty().set(true);
        assertTrue(userPresenter.getApplyPasswordButtonDisabled());
    }

    @Test
    public void testSetUsername() {
        userPresenter.setUser(iUser);
        assertEquals("", userPresenter.getUsername());
    }

    @Test
    public void testApplySetUsername() {
        userPresenter.setUser(iUser);
        userPresenter.usernameProperty().set("Test");
        userPresenter.applyUsername();

    }

    @Test
    public void testApplySetPassword() {
        userPresenter.setUser(iUser);
        userPresenter.passwordProperty().set("Test");
        userPresenter.applyPassword();

    }

    @Test
    public void testGetUser() {
        userPresenter.setUser(iUser);
        userPresenter.usernameProperty().set("Test");
        assertEquals(0, userPresenter.getUser().getID());
    }

    @Test
    public void testGetUsers() {
        assertEquals(0, adminPresenter.getUsers().size());
    }

}
