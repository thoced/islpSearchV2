package islp.islp.controllers;

import islp.Models.DataModelImporter;
import islp.views.AlertView;
import islp.views.ImportDialog;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class ImportAction implements EventHandler {
    private static final Logger log = Logger.getLogger(ImportAction.class.getName());

    private Stage parentStage;

    public ImportAction(Stage parentStage) {
        this.parentStage = parentStage;
    }

    @Override
    public void handle(Event event) {

        ImportDialog importDialog = new ImportDialog(parentStage);
        Scene scene = new Scene(importDialog,600,480);
        scene.getStylesheets().add("style.css");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initOwner(parentStage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Sélection du registre");
        stage.showAndWait();


        if(importDialog.isNext()) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                try {
                    DataModelImporter importer = new DataModelImporter(file, importDialog.getRegistreSelected());
                    System.out.println("ok chargement effectué:  nb: " + importer.size());
                    importer.writeInDb();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.debug(e.getMessage());
                    AlertView alertView = new AlertView("Erreur", "Erreur dans le fichier");

                }
            }




        }


    }
}
