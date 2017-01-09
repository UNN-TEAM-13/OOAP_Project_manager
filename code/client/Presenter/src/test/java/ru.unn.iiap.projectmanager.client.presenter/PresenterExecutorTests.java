package ru.unn.iiap.projectmanager.client.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.ooap.projectmanager.client.presenter.executor.TaskPresenter;
import ru.unn.ooap.projectmanager.server.model.users.executor.ITask;

import java.util.Observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PresenterExecutorTests {
    private TaskPresenter taskPresenter;
    private ITask iTask = new ITask() {
        @Override
        public String getTitle() {
            return null;
        }

        @Override
        public String getDescription() {
            return null;
        }

        @Override
        public double getGivenHours() {
            return 0;
        }

        @Override
        public double getSpentHours() {
            return 0;
        }

        @Override
        public double getLeftHours() {
            return 0;
        }

        @Override
        public void addSpentHours(final double additionalSpentHours) {

        }

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public void setDone(final boolean done) {

        }

        @Override
        public int getID() {
            return 0;
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

    @Before
    public void setUp() {
        taskPresenter = new TaskPresenter();

    }

    @After
    public void tearDown() {
        taskPresenter = null;
        iTask = null;
    }
    @Test
    public void testGetDefaultValues() {
        assertEquals(null, taskPresenter.getTask());
        assertEquals("", taskPresenter.spendTimeReportProperty().get());
        assertEquals("", taskPresenter.titleProperty().get());
        assertEquals("", taskPresenter.getTitle());
        assertEquals("", taskPresenter.descriptionProperty().get());
        assertEquals("", taskPresenter.getDescription());
        assertEquals("", taskPresenter.givenHoursTextProperty().get());
        assertEquals("", taskPresenter.getGivenHoursText());
        assertEquals("", taskPresenter.spentHoursTextProperty().get());
        assertEquals("", taskPresenter.getSpentHoursText());
        assertEquals(0.0, taskPresenter.spentHoursPercentProperty().get(), 0);
        assertEquals(0.0, taskPresenter.getSpentHoursPercent(), 0);
        assertTrue(taskPresenter.reportSpentTimeButtonDisabledProperty().get());
        assertTrue(taskPresenter.getReportSpentTimeButtonDisabled());
        assertEquals(null, taskPresenter.getView());
    }

    @Test
    public void setTask() {
        taskPresenter.titleProperty().set("TestTitle");
        taskPresenter.descriptionProperty().set("TestDescription");
        taskPresenter.givenHoursTextProperty().set("20.0");
        taskPresenter.spentHoursTextProperty().set("10.0");
        taskPresenter.spentHoursPercentProperty().setValue(10);
        taskPresenter.setTask(iTask);
    }
    @Test
    public void testReportSpentTime() {
        taskPresenter.setTask(iTask);
        taskPresenter.spendTimeReportProperty().set("10");
        taskPresenter.reportSpentTime();

    }
}
