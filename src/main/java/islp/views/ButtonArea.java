package islp.views;

import islp.Models.RegistreModel;
import islp.islp.controllers.RechercheController;
import islp.islp.controllers.SingletonConnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ButtonArea extends HBox {

    private Stage parentStage;

    private Label label;

    private ComboListRegistre comboListRegistre;

    private Button recherche;
    private Label nbTupleLabel;


    public ButtonArea(Stage parentStage) {
        super();
        this.parentStage = parentStage;
        this.setMinHeight(64);
        this.setMaxHeight(64);
        this.setAlignment(Pos.CENTER);
        Insets insets = new Insets(8);
        this.setPadding(insets);
        this.setSpacing(32);
        initButton();

    }

    private void initButton(){

        label = new Label("Registre des recherches:");
        label.setTextAlignment(TextAlignment.CENTER);
        label.setWrapText(true);
        this.getChildren().add(label);

        comboListRegistre = new ComboListRegistre(parentStage);
        this.getChildren().add(comboListRegistre);
        comboListRegistre.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<RegistreModel>() {
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
        });


        recherche = new Button("Rechercher");
        recherche.setMaxSize(128,64);
        recherche.setOnAction(new RechercheController(comboListRegistre));
        this.getChildren().add(recherche);

        nbTupleLabel = new Label();
        nbTupleLabel.setTextAlignment(TextAlignment.RIGHT);
        this.getChildren().add(nbTupleLabel);

    }


}
