package ru.unn.ooap.projectmanager.client.view;

import javafx.scene.Node;
import javafx.stage.Stage;

abstract class WindowTitledPane {
    abstract Node getFakeNode();
    abstract String getWindowTitle();

    Stage getStage() {
        return (Stage) getFakeNode().getScene().getWindow();
    }

    void setWindowTitle(final String title) {
        Stage stage = (Stage) getFakeNode().getScene().getWindow();
        stage.setTitle(title);
    }

    void initialize() {
        setWindowTitle(getWindowTitle());
    }
}
