package islp.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AboutDialog extends BorderPane{
    private Stage parentStage;
    private Button buttonCancel;

    public AboutDialog(Stage parentStage) {
        this.parentStage = parentStage;

        initAbout();
    }

    public Button getButtonCancel() {
        return buttonCancel;
    }

    private void initAbout() {

        Label labelAbout = new Label("IslpSearch V2 est un logiciel de recherche de titulaire de numéros de gsm enregistrés dans les différents registres " +
                "des zones de police locale et dans les registres de la police fédérale, le logiciel permet d'effectuer des recherches de masse sur un ensemble de numéros " +
                "(Développé par Thonon cédric)");
        labelAbout.setTextAlignment(TextAlignment.CENTER);
        labelAbout.setWrapText(true);
        setCenter(labelAbout);



        buttonCancel = new Button("Cancel");
        Insets insets = new Insets(16);
        buttonCancel.setPadding(insets);
        buttonCancel.setCenterShape(true);
        setBottom(buttonCancel);
    }
}
