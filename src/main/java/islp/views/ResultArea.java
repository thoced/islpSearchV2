package islp.views;

import islp.Models.ResultModel;
import islp.views.cellRenderFactory.CellNumeroColor;
import islp.views.tableCell.DateNaissanceTableCell;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import javax.xml.transform.Result;

public class ResultArea extends TableView {

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
}
