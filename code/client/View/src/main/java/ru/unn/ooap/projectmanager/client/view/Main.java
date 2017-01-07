package ru.unn.ooap.projectmanager.client.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.unn.ooap.projectmanager.server.model.projects.Projects;
import ru.unn.ooap.projectmanager.server.model.tasks.Tasks;
import ru.unn.ooap.projectmanager.server.model.users.Users;

public class Main extends Application {

    @Override
    public void start(final Stage defaultStage) throws Exception {
        PMSStage primaryStage = new PMSStage();
        Users.init(primaryStage.getStorage());
        Projects.init(primaryStage.getStorage());
        Tasks.init(primaryStage.getStorage());
        Parent root = FXMLLoader.load(getClass().getResource("AuthMainView.fxml"));
        primaryStage.setTitle("PMS");
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
