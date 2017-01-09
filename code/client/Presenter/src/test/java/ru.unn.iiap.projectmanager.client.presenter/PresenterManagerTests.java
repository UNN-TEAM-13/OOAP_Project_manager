package ru.unn.iiap.projectmanager.client.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.ooap.projectmanager.client.presenter.manager.ProjectPresenter;
import ru.unn.ooap.projectmanager.client.presenter.manager.TaskPresenter;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PresenterManagerTests {
    private TaskPresenter taskPresenter;
    private ProjectPresenter projectPresenter;

    @Before
    public void setUp() {
        taskPresenter = new TaskPresenter();
        projectPresenter = new ProjectPresenter();

    }

    @After
    public void tearDown() {
        taskPresenter = null;
        projectPresenter = null;
    }

    @Test
    public void testGetDefaultValuesForTaskPresenter() {
        assertEquals(null, taskPresenter.getTask());
        taskPresenter.applyButtonDisableProperty().set(false);
        taskPresenter.hideProgressInfoProperty().set(false);
        assertFalse(taskPresenter.getApplyButtonDisable());
        assertEquals("", taskPresenter.titleTextProperty().get());
        assertEquals("", taskPresenter.descriptionTextProperty().get());
        assertEquals("", taskPresenter.givenHoursTextProperty().get());
        assertEquals(0.0, taskPresenter.spentHoursPercentProperty().get(), 0);
        assertEquals(0.0, taskPresenter.getSpentHoursPercent(), 0);
        assertFalse(taskPresenter.getHideProgressInfo());
        assertEquals(null, taskPresenter.getChosedExecutor());
        assertEquals(0, taskPresenter.getExecutors().size());
        assertEquals(null, taskPresenter.chosedExecutorProperty().get());
        assertEquals(0, taskPresenter.executorsProperty().get().size());
    }

    @Test
    public void testGetDefaultValuesForProjectPresenter() {
        assertEquals(null, projectPresenter.getProject());
        assertEquals("", projectPresenter.titleTextProperty().get());
        assertEquals("", projectPresenter.descriptionTextProperty().get());
        assertEquals(0, projectPresenter.getTasks().size());
        assertEquals(true, projectPresenter.applyButtonDisabledProperty().get());
        assertTrue(projectPresenter.getApplyButtonDisabled());
    }

}
