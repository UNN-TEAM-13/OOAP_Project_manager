package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TaskView implements ru.unn.ooap.projectmanager.client.presenter.executor.ITaskView,
                                 ru.unn.ooap.projectmanager.client.presenter.manager.ITaskView {
    @FXML
    private TextField title;
    @FXML
    private TextField description;
    @FXML
    private TextField givenHoursText;
    @FXML
    private TextField spentHoursText;
    @FXML
    private TextField leftHoursText;

    @Override
    public void setTitle(final String title) {
        this.title.setText(title);
    }

    @Override
    public void setDescription(final String description) {
        this.description.setText(description);
    }

    @Override
    public void setGivenHours(final double givenHours) {
        givenHoursText.setText("" + givenHours);
        refreshLeftHoursText();
    }

    @Override
    public void setSpentHours(final double spentHours) {
        spentHoursText.setText("" + spentHours);
        refreshLeftHoursText();
    }

    @Override
    public double getGivenHours() {
        return Double.parseDouble(givenHoursText.getText());
    }

    private void refreshLeftHoursText() {
        leftHoursText.setText("" + (Double.parseDouble(givenHoursText.getText())
                                    - Double.parseDouble(spentHoursText.getText())));
    }
}
