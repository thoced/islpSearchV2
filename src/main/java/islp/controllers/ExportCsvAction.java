package islp.controllers;

import islp.Models.ResultModel;
import islp.ResultPackage.ResultArea;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class ExportCsvAction implements EventHandler {

    private Stage parentStage;

    private boolean onlyItemSelected = false;

    public ExportCsvAction(Stage parentStage,boolean onlyItemSelected) {
        this.parentStage = parentStage;
        this.onlyItemSelected = onlyItemSelected;
    }

    @Override
    public void handle(Event event) {

        StringBuilder stringBuilder = new StringBuilder();
        ResultArea resultArea = (ResultArea) SingletonObjectManager.getInstance().getObjects().get(ResultArea.class);

        ObservableList selectionModel;
        if(onlyItemSelected)
             selectionModel = resultArea.getSelectionModel().getSelectedItems();
        else
            selectionModel = resultArea.getItems();


        for(Object result : selectionModel){
           ResultModel resultModel = (ResultModel) result;
           stringBuilder.append(resultModel.getNumero() + ";" + resultModel.getNom() + ";" + resultModel.getPrenom() + ";" + resultModel.getDateNaissanceFormat() + ";"
                   + resultModel.getTypeIslp() + ";" + resultModel.getNumeroIslp() + ";" + resultModel.getAnnee() +  ";" + resultModel.getBngFormat() + "\n ");


        }

        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Excel files (*.csv)", "*.csv");

        String csv = stringBuilder.toString();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Export CSV des résultats");
        chooser.setSelectedExtensionFilter(extFilter);
        File file = chooser.showSaveDialog(parentStage.getScene().getWindow());
        if(file != null){
            try {

                System.setProperty( "file.encoding", "UTF-16");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(csv.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
