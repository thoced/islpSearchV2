package islp.controllers;

import islp.Models.ResultModel;
import islp.ResultPackage.ResultArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;

import java.util.HashMap;

public class CopyClipBoardController implements EventHandler<ActionEvent> {

    private ResultArea resultArea;

    public CopyClipBoardController(ResultArea resultArea) {
        this.resultArea = resultArea;
}

    @Override
    public void handle(ActionEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        clipboard.clear();
        DataFormat format = DataFormat.PLAIN_TEXT;
        HashMap<DataFormat,Object> map = new HashMap<>();
        String dataClip = new String();
        for(Object result : resultArea.getSelectionModel().getSelectedItems()){
            ResultModel model = (ResultModel) result;
            dataClip += model.getNumero() + "\t" + model.getNom() + " " + model.getPrenom() + "\t" + model.getDateNaissanceFormat() + System.lineSeparator();

          }
        map.put(format,dataClip);
        clipboard.setContent(map);

    }
}
