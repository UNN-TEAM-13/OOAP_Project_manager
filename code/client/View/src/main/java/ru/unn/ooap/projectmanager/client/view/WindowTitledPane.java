package ru.unn.ooap.projectmanager.client.view;

import javafx.scene.Node;
import javafx.stage.Stage;

abstract class WindowTitledPane {
    abstract Node getFakeNode();
    Stage getStage() {
        return (Stage) getFakeNode().getScene().getWindow();
    }
    void setWindowTitle(String title) {
        Stage stage = (Stage) getFakeNode().getScene().getWindow();
        stage.setTitle(title);
    }
}
