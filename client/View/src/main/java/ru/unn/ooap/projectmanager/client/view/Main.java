package ru.unn.ooap.projectmanager.client.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.unn.ooap.projectmanager.server.model.users.Users;

public class Main extends Application {

    @Override
    public void start(Stage defaultStage) throws Exception {
        PMSStage primaryStage = new PMSStage();
        Users.init(primaryStage.getStorage());
        Parent root = FXMLLoader.load(getClass().getResource("AuthSceneView.fxml"));
        primaryStage.setTitle("Аутентификация");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        double height = primaryStage.getHeight();
        primaryStage.setMinHeight(height);
        primaryStage.setMaxHeight(height);
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
