package ru.unn.iiap.projectmanager.client.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.ooap.projectmanager.client.presenter.AuthPresenter;
import ru.unn.ooap.projectmanager.client.presenter.IAuthView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PresenterCommonTests {
    private AuthPresenter authPresenter;
    private IAuthView authView;

    @Before
    public void setUp() {
        authPresenter = new AuthPresenter();

    }

    @After
    public void tearDown() {
        authPresenter = null;
    }

    @Test
    public void testGetDefaultValues() {
        assertEquals(null, authPresenter.usernameProperty().get());
        assertEquals(null, authPresenter.passwordProperty().get());
        assertEquals(null, authPresenter.statusProperty().get());
        assertFalse(authPresenter.buttonDisabledProperty().get());
    }

    @Test
    public void testSetStatus() {
        authPresenter.statusProperty().set("Test");
        assertEquals("Test", authPresenter.getStatus());
    }

    @Test
    public void testIsButtonDisabled() {
        authPresenter.buttonDisabledProperty().set(true);
        assertTrue(authPresenter.isButtonDisabled());
    }
}
