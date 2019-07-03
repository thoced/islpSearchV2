package islp.importPackage;

import islp.Models.DataModel;
import islp.Models.DataModelImporter;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class ImportAction extends Service<Integer>implements EventHandler {
    private static final Logger log = Logger.getLogger(ImportAction.class.getName());

    private final int TIME_SLEEP  = 1;

    private Stage parentStage;

    private Stage stage;

    private ImportDialog importDialog = null;

    private ProgressIndicator progressIndicator = new ProgressIndicator();

    private Runnable createWorker;

    private Thread thread;

    private File file = null;

    public ImportAction(Stage parentStage) {
          this.parentStage = parentStage;
          this.progressIndicator.progressProperty().bind(this.progressProperty());
          this.setOnSucceeded((WorkerStateEvent event) ->{
              importDialog.getCancelButton().setDisable(false);
              importDialog.getNextButton().setDisable(false);
              importDialog.getComboListRegistre().setDisable(false);
          });

          this.setOnFailed((WorkerStateEvent event) -> {
              importDialog.getCancelButton().setDisable(false);
              importDialog.getNextButton().setDisable(false);
              importDialog.getComboListRegistre().setDisable(false);
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Erreur dans la tâche de fond");
              alert.setContentText("Une erreur est survenue dans l'éxécution du processus d'ajout des données");
              alert.showAndWait();
          });

          this.setOnCancelled((WorkerStateEvent event) -> {
              if(isRunning()) {
                  importDialog.getCancelButton().setDisable(false);
                  importDialog.getNextButton().setDisable(false);
                  importDialog.getComboListRegistre().setDisable(false);
                  Alert alert = new Alert(Alert.AlertType.WARNING);
                  alert.setTitle("Arret brutale");
                  alert.setContentText("L'éxécution du processsus d'ajout des données a été arreté manuellement");
                  alert.showAndWait();
              }
          });

          this.setOnRunning((WorkerStateEvent event) -> {
              importDialog.getNextButton().setDisable(true);
              importDialog.getComboListRegistre().setDisable(true);
          } );




    }


    @Override
    public void handle(Event event) {

        if(importDialog == null) {
            importDialog = new ImportDialog(parentStage);

            importDialog.getCancelButton().setOnAction((ActionEvent a) -> {
                    if(ImportAction.this.isRunning()) {

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Annulation de l'import");
                        alert.setContentText("Etes vous sûr de vouloir arreter l'importation ?");
                        alert.getButtonTypes().setAll(ButtonType.YES,ButtonType.NO);
                        Optional<ButtonType> option = alert.showAndWait();
                        if(option.get() == ButtonType.YES){
                            ImportAction.this.cancel();
                            stage.hide();
                        }

                    }else
                        stage.hide();
            });

            importDialog.getNextButton().setOnAction((ActionEvent a) -> {
                importData();
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
            stage.addEventHandler(WindowEvent.WINDOW_HIDING, (WindowEvent a) -> {
                importDialog = null;
                if(ImportAction.this.isRunning())
                    ImportAction.this.cancel();
            });
            stage.showAndWait();

        }
    }

    private void importData() {
        if(!importDialog.getComboListRegistre().getSelectionModel().isEmpty()){
            FileChooser fileChooser = new FileChooser();
            file = fileChooser.showOpenDialog(null);
            if (file != null) {
                progressIndicator.setVisible(true);
                this.restart();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de sélection de registre");
            alert.setContentText("Veuillez sélectionner un registre");
            alert.showAndWait();
        }

    }



    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>(){

            @Override
            protected Integer call() throws IOException, SQLException, InterruptedException {
                DataModelImporter importer = new DataModelImporter(file, importDialog.getRegistreSelected());

                double minProgress = 1.0f / ((double)importer.size());
                double progress = 0f;
                updateProgress(0,1);

                for (DataModel model : importer) {
                    // Thread.sleep(10);
                    importer.writeTrupleDb(model);
                    updateProgress(progress,1f);
                    progress += minProgress;
                    if(this.isCancelled())
                        break;
                    Thread.sleep(TIME_SLEEP);
                }

                importer.close();

                updateProgress(1f,1f);
                return 1;
            }
        };
    }
}




