package islp.islp.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import islp.Models.ResultModel;
import islp.views.ResultArea;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExportPdfAction implements EventHandler{

    private Stage parentStage;

    private Stage stage;

    private boolean onlyItemSelected = false;

    private Document document;

    public ExportPdfAction(Stage parentStage,boolean onlyItemSelected) {
        this.parentStage = parentStage;
        this.onlyItemSelected = onlyItemSelected;
    }

    @Override
    public void handle(Event event) {


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export pdf des résultats");

        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");

        fileChooser.setSelectedExtensionFilter(extFilter);
        File file = fileChooser.showSaveDialog(parentStage);

        if(file == null)
            return;

        document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            // reception des résultats
            ResultArea resultArea = (ResultArea) SingletonObjectManager.getInstance().getObjects().get(ResultArea.class);

            if(onlyItemSelected){
                writeElements(resultArea.getSelectionModel().getSelectedItems());
            }
            else
                writeElements(resultArea.getItems());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
            document.close();
        } finally {
            document.close();
        }
    }

    private void writeElements(ObservableList selectedItems) throws DocumentException {
        for(Object model : selectedItems){
            if(model instanceof ResultModel){
                String out = ((ResultModel)model).getNumero() + " - " + ((ResultModel)model).getNom() + " " + ((ResultModel)model).getPrenom() + " (" + ((ResultModel)model).getDateNaissanceFormat() + ") - " +
                        ((ResultModel)model).getNumeroIslp() + "/" +  ((ResultModel)model).getAnnee() + " - " + ((ResultModel)model).getTypeIslp();
                document.add(new Paragraph(out));
            }
        }
    }
}
