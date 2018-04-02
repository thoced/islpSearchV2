package islp.islp.controllers;

import islp.views.AboutDialog;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AboutAction implements EventHandler{

    private Stage parentStage;
    private Stage stage;

    private AboutDialog aboutDialog = null;

    public AboutAction(Stage parentStage) {
        this.parentStage = parentStage;
    }

    @Override
    public void handle(Event event) {

        aboutDialog = new AboutDialog(parentStage);
        aboutDialog.getButtonCancel().setOnAction((ActionEvent a) ->  {
            stage.hide();
        });
        Scene scene = new Scene(aboutDialog,640,320);
        scene.getStylesheets().add("style.css");
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("About");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNIFIED);
        stage.showAndWait();

    }
}
