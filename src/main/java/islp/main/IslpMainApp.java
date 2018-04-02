package islp.main;

import islp.Models.RegistreModel;
import islp.islp.controllers.RechercheController;
import islp.views.MainPane;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.net.URL;

public class IslpMainApp extends Application {

    private MainPane mainPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainPane = new MainPane(primaryStage);
        mainPane.getButtonArea().getComboListRegistre().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RegistreModel>() {
            @Override
            public void changed(ObservableValue<? extends RegistreModel> observableValue, RegistreModel registreModel, RegistreModel t1) {
                mainPane.getButtonArea().getNbTupleLabel().setText("Nombre d'enregistrement: " + RechercheController.getNbTupleForRegistre(t1.getRegistreName()));


            }});

            Scene mainScene = new Scene(mainPane,1024,768);
        URL cssURL = getClass().getResource("style.css");
        mainScene.getStylesheets().add("style.css");
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Islp Search V2");
        primaryStage.show();
    }
}
