package islp.main;

import islp.views.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IslpMainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {




        Scene mainScene = new Scene(new MainPane(),1024,768);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
