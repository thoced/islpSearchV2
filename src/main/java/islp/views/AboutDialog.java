package islp.views;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AboutDialog extends BorderPane{
    private Stage parentStage;

    private GridPane gridPane;

    private Button buttonCancel;

    public AboutDialog(Stage parentStage) {
        this.parentStage = parentStage;

        initAbout();
    }

    public Button getButtonCancel() {
        return buttonCancel;
    }

    private void initAbout() {

        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(80);
        columnConstraints.setHalignment(HPos.CENTER);
        gridPane.getColumnConstraints().add(0,columnConstraints);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(40);
        rowConstraints.setValignment(VPos.CENTER);
        gridPane.getRowConstraints().add(0,rowConstraints);
        gridPane.getRowConstraints().add(1,rowConstraints);
        setCenter(gridPane);


        Label labelAbout = new Label("IslpSearch V2 est un logiciel de recherche de titulaire de numéros de gsm enregistrés dans les différents registres " +
                "des zones de police locale et dans les registres de la police fédérale, le logiciel permet d'effectuer des recherches de masse sur un ensemble de numéros.");
        labelAbout.setTextAlignment(TextAlignment.CENTER);
        labelAbout.setWrapText(true);
        gridPane.add(labelAbout,0,0);

        Label labelDev = new Label("Developpé par THONON Cédric");
        gridPane.add(labelDev,0,1);

        buttonCancel = new Button("Cancel");
        Insets insets = new Insets(16);
        buttonCancel.setPadding(insets);
        buttonCancel.setCenterShape(true);
        setBottom(buttonCancel);
    }
}
