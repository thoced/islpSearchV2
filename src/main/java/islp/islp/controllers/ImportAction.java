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

import java.io.File;
import java.io.IOException;

public class ImportAction implements EventHandler {

    private Stage parentStage;


    public ImportAction(Stage parentStage) {
        this.parentStage = parentStage;
    }

    @Override
    public void handle(Event event) {

        ImportDialog importDialog = new ImportDialog(parentStage);
        Scene scene = new Scene(importDialog,600,480);
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
                    AlertView alertView = new AlertView("Erreur", "Erreur dans le fichier");

                }
            }




        }


    }
}
