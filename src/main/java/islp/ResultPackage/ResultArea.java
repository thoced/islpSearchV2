package islp.ResultPackage;

import islp.Models.ResultModel;
import islp.controllers.BngStatutAction;
import islp.controllers.CopyClipBoardController;
import islp.ResultPackage.bngRenderFactory.BngTableCell;
import islp.ResultPackage.tableCell.DateNaissanceTableCell;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResultArea extends TableView {

    private ContextMenu context;
    private TableColumn id;
    private TableColumn numero;
    private TableColumn land;
    private TableColumn nom;
    private TableColumn prenom;
    private TableColumn dateNaissance;
    private TableColumn type;
    private TableColumn numIslp;
    private TableColumn millesime;
    private TableColumn bng;

    private String numeroCurrent;
    private static ResultModel saveModel;



    public ResultArea() {
        super();
        initColumns();

        // Context Menu - Copy to ClipBoard
        context = new ContextMenu();

        MenuItem copyClipBoardMenu = new MenuItem("Copie dans le presse papier");
        copyClipBoardMenu.setOnAction(new CopyClipBoardController(this));

        Menu bngStatutMenu = new Menu("Bng statut");
        MenuItem stupMenu = new MenuItem("Connu STUPS");
        stupMenu.setOnAction(new BngStatutAction(BngStatutAction.STATUT.STUP));

        MenuItem volMenu = new MenuItem("Connu VOLS");
        volMenu.setOnAction(new BngStatutAction(BngStatutAction.STATUT.VOL));

        MenuItem moeursMenu = new MenuItem("Connu MOEURS");
        moeursMenu.setOnAction(new BngStatutAction(BngStatutAction.STATUT.MOEURS));

        MenuItem crimeMenu = new MenuItem("Connu CRIME");
        crimeMenu.setOnAction(new BngStatutAction(BngStatutAction.STATUT.CRIME));

        MenuItem ecofinMenu = new MenuItem("Connu ECOFIN");
        ecofinMenu.setOnAction(new BngStatutAction(BngStatutAction.STATUT.ECOFIN));

        MenuItem delMenu = new MenuItem("Supprimer tous les statuts");
        delMenu.setOnAction(new BngStatutAction(BngStatutAction.STATUT.DELETE));
        bngStatutMenu.getItems().addAll(stupMenu, volMenu, moeursMenu, crimeMenu, ecofinMenu, delMenu);

        context.getItems().add(copyClipBoardMenu);
        context.getItems().add(bngStatutMenu);


    }


    private void initColumns() {


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

        bng = new TableColumn("Bng");
        bng.setMinWidth(65);
        this.getColumns().add(bng);


        id.setCellValueFactory(new PropertyValueFactory<ResultModel, Integer>("cpt"));
        numero.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("numero"));
        land.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("land"));
        nom.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("prenom"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("dateNaissance"));
        type.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("typeIslp"));
        numIslp.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("numeroIslp"));
        millesime.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("annee"));
        bng.setCellValueFactory(new PropertyValueFactory<ResultModel, String>("bng"));


        dateNaissance.setCellFactory(DateNaissanceTableCell.forTableColumn());
        bng.setCellFactory(BngTableCell.forTableColumn());


        getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public ContextMenu getContext() {
        return context;
    }


    public TableColumn getIdColumn() {
        return id;
    }

    public TableColumn getNumero() {
        return numero;
    }

    public TableColumn getLand() {
        return land;
    }

    public TableColumn getNom() {
        return nom;
    }

    public TableColumn getPrenom() {
        return prenom;
    }

    public TableColumn getDateNaissance() {
        return dateNaissance;
    }

    public TableColumn getType() {
        return type;
    }

    public TableColumn getNumIslp() {
        return numIslp;
    }

    public TableColumn getMillesime() {
        return millesime;
    }

    public TableColumn getBng() {
        return bng;
    }
}
