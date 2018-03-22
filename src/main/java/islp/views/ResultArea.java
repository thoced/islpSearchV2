package islp.views;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ResultArea extends TableView {

    private TableColumn id;
    private TableColumn numero;
    private TableColumn nom;
    private TableColumn prenom;
    private TableColumn dateNaissance;
    private TableColumn type;
    private TableColumn numIslp;
    private TableColumn millesime;

    public ResultArea() {
        super();

        initColumns();
    }

    private void initColumns(){
         id = new TableColumn("id");
         this.getColumns().add(id);

         numero = new TableColumn("numéro");
         this.getColumns().add(numero);

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



    }
}
