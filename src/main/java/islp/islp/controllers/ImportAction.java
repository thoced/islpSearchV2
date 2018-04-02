package islp.islp.controllers;

import islp.Models.DataModel;
import islp.Models.DataModelImporter;
import islp.views.AlertView;
import islp.views.ImportDialog;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
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

    private Stage stage;

    private ImportDialog importDialog = null;

    private ProgressIndicator progressIndicator = new ProgressIndicator();

    private Runnable createWorker;

    private Thread thread;

    public ImportAction(Stage parentStage) {
        this.parentStage = parentStage;
    }



    @Override
    public void handle(Event event) {

        if(importDialog == null) {
            importDialog = new ImportDialog(parentStage);
            importDialog.getCancelButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(thread != null)
                        thread.interrupt();
                        stage.hide();
                }
            });
            importDialog.getNextButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    progressIndicator.setProgress(0);
                    importDialog.getNextButton().setDisable(true);
                    importDialog.getCancelButton().setDisable(true);
                    importDialog.getComboListRegistre().setDisable(true);
                    importData();
                }
            });
            progressIndicator.setVisible(false);
            importDialog.add(progressIndicator,1,1);
            Scene scene = new Scene(importDialog, 600, 480);
            scene.getStylesheets().add("style.css");
            stage = new Stage();
            stage.setScene(scene);
            stage.initOwner(parentStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.UNIFIED);
            stage.setTitle("Sélection du registre");
            stage.addEventHandler(WindowEvent.WINDOW_HIDING, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    importDialog = null;
                }
            });
            stage.showAndWait();

        }
    }

    private void importData() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            progressIndicator.setVisible(true);
            createWorker = createWorker(file);
            thread = new Thread(createWorker);
            thread.start();
        }
        else {
            importDialog.getNextButton().setDisable(false);
            importDialog.getComboListRegistre().setDisable(false);
            importDialog.getCancelButton().setDisable(false);
        }
    }

    public Task createWorker(File file) {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                DataModelImporter importer = new DataModelImporter(file, importDialog.getRegistreSelected());

                double minProgress = 1.0f / ((double)importer.size());
                double progress = 0f;

                    for (DataModel model : importer) {
                       // Thread.sleep(10);
                        importer.writeTrupleDb(model);
                        progressIndicator.setProgress(progress);
                        progress += minProgress;
                    }
                    progressIndicator.setProgress(1f);
                    importDialog.getNextButton().setDisable(false);
                    importDialog.getComboListRegistre().setDisable(false);
                return true;
            }
        };
    }


}




