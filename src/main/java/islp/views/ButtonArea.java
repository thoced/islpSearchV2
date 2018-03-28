package islp.views;

import islp.islp.controllers.RechercheController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;

public class ButtonArea extends HBox {
    private Button recherche;

    public ButtonArea() {
        super();

        this.setMinHeight(64);
        this.setMaxHeight(64);
        initButton();

    }

    private void initButton(){
        recherche = new Button("Rechercher");
        recherche.setMaxSize(128,64);
        recherche.setOnAction(new RechercheController());
        this.getChildren().add(recherche);
    }


}
