package islp.views;

import islp.Models.ResultModel;
import islp.islp.controllers.CopyClipBoardController;
import islp.views.cellRenderFactory.CellNumeroColor;
import islp.views.tableCell.DateNaissanceTableCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DataFormat;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;

public class ResultArea extends TableView implements EventHandler<ContextMenuEvent> {

    private final ContextMenu contextMenu;
    private TableColumn id;
    private TableColumn numero;
    private TableColumn land;
    private TableColumn nom;
    private TableColumn prenom;
    private TableColumn dateNaissance;
    private TableColumn type;
    private TableColumn numIslp;
    private TableColumn millesime;

    private String numeroCurrent;
    private static ResultModel saveModel;

    public ResultArea() {
        super();
        initColumns();

        // Context Menu - Copy to ClipBoard
        contextMenu = new ContextMenu();
        MenuItem copyClipBoardMenu = new MenuItem("Copie dans le presse papier");
        copyClipBoardMenu.setOnAction(new CopyClipBoardController(this));
        contextMenu.getItems().add(copyClipBoardMenu);
        this.setOnContextMenuRequested(this);


        ObservableList observableList = FXCollections.observableArrayList();
        ResultModel model = new ResultModel();
        model.setNumero("32494386461");
        model.setNom("Thonon");
        model.setPrenom("Cedric");
        model.setDateNaissance("19810713");
        observableList.add(model);

        ResultModel model2 = new ResultModel();
        model2.setNumero("32494386461");
        model2.setNom("Thonon");
        model2.setPrenom("Cedric");
        model2.setDateNaissance("19810713");
        observableList.add(model2);

        this.setItems(observableList);


    }



    private void initColumns(){


         id = new TableColumn("id");
         this.getColumns().add(id);

         numero = new TableColumn("numéro");
         this.getColumns().add(numero);

         land = new TableColumn("pays");
         this.getColumns().add(land);

         nom = new TableColumn("nom");
         this.getColumns().add(nom);

         prenom = new TableColumn("prénom");
         this.getColumns().add(prenom);

         dateNaissance = new TableColumn("date de naissance");
         this.getColumns().add(dateNaissance);

         type = new TableColumn("type");
         this.getColumns().add(type);

         numIslp = new TableColumn("numéro Islp");
         this.getColumns().add(numIslp);

         millesime = new TableColumn("Année");
         this.getColumns().add(millesime);



         id.setCellValueFactory(new PropertyValueFactory<ResultModel,Integer>("id"));
         numero.setCellValueFactory(new PropertyValueFactory<ResultModel,String>("numero"));
         land.setCellValueFactory(new PropertyValueFactory<ResultModel,String>("land"));
         nom.setCellValueFactory(new PropertyValueFactory<ResultModel,String>("nom"));
         prenom.setCellValueFactory(new PropertyValueFactory<ResultModel,String>("prenom"));
         dateNaissance.setCellValueFactory(new PropertyValueFactory<ResultModel,String>("dateNaissance"));
         type.setCellValueFactory(new PropertyValueFactory<ResultModel,String>("typeIslp"));
         numIslp.setCellValueFactory(new PropertyValueFactory<ResultModel,String>("numeroIslp"));
         millesime.setCellValueFactory(new PropertyValueFactory<ResultModel,String>("annee"));


         dateNaissance.setCellFactory(DateNaissanceTableCell.forTableColumn());



        getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @Override
    public void handle(ContextMenuEvent event) {
        contextMenu.show(this.getScene().getWindow(),event.getScreenX(),event.getScreenY());
    }
}
