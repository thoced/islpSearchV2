package islp.importPackage;

import islp.views.Button;
import islp.views.ComboListRegistre;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class ImportDialog extends GridPane {

    private Stage parentStage;

    private Label labelText;

    private Label labelWarning;

    private Label labelStructure;

    private ComboListRegistre comboListRegistre;

    private Button nextButton;

    private Button cancelButton;

    private boolean isNext = false;

    public ImportDialog(Stage parentStage) {
        super();
        this.parentStage = parentStage;

        initGridPane();
    }

    public ComboListRegistre getComboListRegistre() {
        return comboListRegistre;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public boolean isNext() {
        return isNext;
    }

    public String getRegistreSelected() {
        return (String) comboListRegistre.getSelectionModel().getSelectedItem().toString();
    }

    private void initGridPane() {


        labelText = new Label("Veuillez sélectionner le registre dans lequel les nouvelles données vont être importées");
        labelText.setWrapText(true);
        labelText.setTextAlignment(TextAlignment.CENTER);

        labelWarning = new Label("!!! Attention, le fichier au format CSS doit contenir des séparateurs de type - Tabulation - !!!");
        labelWarning.setWrapText(true);
        labelWarning.setTextAlignment(TextAlignment.LEFT);
        labelWarning.setTextFill(Color.color(1, 0, 0));

        labelStructure = new Label("Structure du fichier:\n\n" +
                "- numero\n" +
                "- pays\n" +
                "- nom\n" +
                "- prenom\n" +
                "- date de naissance\n" +
                "- type islp\n" +
                "- numero islp\n" +
                "- annee islp\n");
        labelStructure.setTextAlignment(TextAlignment.LEFT);
        labelStructure.setWrapText(true);


        nextButton = new Button("Suivant");
        cancelButton = new Button("Annuler");
        cancelButton.setAlignment(Pos.CENTER);
        nextButton.setAlignment(Pos.CENTER);

        this.setPrefSize(640, 480);
        this.setAlignment(Pos.CENTER);
        this.setHgap(20);
        Insets insets = new Insets(20);
        this.setPadding(insets);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(50);
        rowConstraints.setFillHeight(true);
        rowConstraints.setVgrow(Priority.SOMETIMES);
        RowConstraints rowConstraintsButton = new RowConstraints();
        rowConstraintsButton.setPercentHeight(15);
        getRowConstraints().add(0, rowConstraints);
        getRowConstraints().add(1, rowConstraints);
        getRowConstraints().add(2, rowConstraintsButton);




        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        columnConstraints.setFillWidth(true);
        columnConstraints.setHgrow(Priority.SOMETIMES);
        getColumnConstraints().add(0, columnConstraints);
        getColumnConstraints().add(1, columnConstraints);

        comboListRegistre = new ComboListRegistre(parentStage);

        add(labelText, 0, 0);
        add(comboListRegistre, 1, 0);
        add(labelWarning, 0, 1);
        add(labelStructure,1,1);
        add(cancelButton, 0, 2);
        add(nextButton, 1, 2);


    }

}
