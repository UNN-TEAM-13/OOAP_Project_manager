package ru.unn.ooap.projectmanager.client.view;

import javafx.scene.Node;
import javafx.stage.Stage;

abstract class WindowTitledPane {
    abstract Node getFakeNode();
    abstract String getWindowTitle();

    protected Stage getStage() {
        System.out.print("setStage invocation");
        return (Stage) getFakeNode().getScene().getWindow();
    }

    protected void setWindowTitle(final String title) {
        System.out.print("setWindowTitle invocation");
        getStage().setTitle(title);
        System.out.print("Now stage title is: " + getStage().getTitle());
    }

    protected void initialize() {
        // Need rewrite — initialization runs before stage assignment
        // also, i do not know why, initialization for WindowTitledPane subclasses
        // just DO NOT RUNS at all

        setWindowTitle(getWindowTitle());
    }
}
