package islp.views;

import islp.controllers.RechercheController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ButtonArea extends GridPane {

    private Stage parentStage;

    private Label label;

    private ComboListRegistre comboListRegistre;

    private Button recherche;

    private Button testCopy;

    private Label nbTupleLabel;


    public ButtonArea(Stage parentStage) {
        super();
        this.parentStage = parentStage;
        this.setMinHeight(64);
        this.setMaxHeight(64);
        this.setAlignment(Pos.CENTER);
        Insets insets = new Insets(8);
        this.setPadding(insets);
        initButton();

    }

    public Label getNbTupleLabel() {
        return nbTupleLabel;
    }

    public ComboListRegistre getComboListRegistre() {
        return comboListRegistre;
    }

    private void initButton(){

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setValignment(VPos.CENTER);
        rowConstraints.setPercentHeight(100);

        ColumnConstraints columnConstraintsLabel = new ColumnConstraints();
        columnConstraintsLabel.setHalignment(HPos.RIGHT);
        columnConstraintsLabel.setPercentWidth(25);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHalignment(HPos.CENTER);
        columnConstraints.setPercentWidth(25);

        ColumnConstraints columnConstraintsEnregistrement = new ColumnConstraints();
        columnConstraintsEnregistrement.setHalignment(HPos.LEFT);
        columnConstraintsEnregistrement.setPercentWidth(25);


        getRowConstraints().add(0,rowConstraints);
        getColumnConstraints().add(0,columnConstraintsLabel);
        getColumnConstraints().add(1,columnConstraints);
        getColumnConstraints().add(2,columnConstraints);
        getColumnConstraints().add(3,columnConstraintsEnregistrement);

        label = new Label("Registre des recherches:");
        label.setTextAlignment(TextAlignment.CENTER);
        label.setWrapText(true);
        add(label,0,0);

        comboListRegistre = new ComboListRegistre(parentStage);
        add(comboListRegistre,1,0);
       /* comboListRegistre.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RegistreModel>() {
        @Override
         public void changed(ObservableValue<? extends RegistreModel> observableValue, RegistreModel s, RegistreModel t1) {
            String registre = t1.getRegistreName();
            String table = "t_islp_" + registre;
            String sql = "select count(*) from " + table;
            try {
                Statement ps = SingletonConnection.getInstance().getConnection().createStatement();
                ResultSet resultSet = ps.executeQuery(sql);
                while(resultSet.next()){
                   nbTupleLabel.setText("Nombre d'enregistrement : " + String.valueOf(resultSet.getInt("count(*)")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        });*/


        recherche = new Button("Rechercher");
        recherche.setMaxSize(128,64);
        recherche.setOnAction(new RechercheController(comboListRegistre));
        add(recherche,2,0);

        nbTupleLabel = new Label("Nombre d'enregistrement:");
        nbTupleLabel.setTextAlignment(TextAlignment.RIGHT);
        add(nbTupleLabel,3,0);

    }


}
