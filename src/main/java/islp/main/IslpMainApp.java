package islp.main;

import islp.views.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;


import java.net.URL;

public class IslpMainApp extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        Scene mainScene = new Scene(new MainPane(primaryStage),1024,768);
        URL cssURL = getClass().getResource("style.css");
        mainScene.getStylesheets().add("style.css");



        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Islp Search V2");
        primaryStage.show();
    }
}
