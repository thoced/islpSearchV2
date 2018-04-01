package islp.views;

import islp.islp.controllers.RechercheController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ButtonArea extends HBox {

    private Stage parentStage;

    private Label label;

    private ComboListRegistre comboListRegistre;

    private Button recherche;



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

        recherche = new Button("Rechercher");
        recherche.setMaxSize(128,64);
        recherche.setOnAction(new RechercheController(comboListRegistre));
        this.getChildren().add(recherche);
    }


}
