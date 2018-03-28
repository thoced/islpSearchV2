package islp.views;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class ImportDialog extends GridPane implements EventHandler{

    private Stage parentStage;

    private Label labelText;

    private ComboListRegistre comboListRegistre;

    private Button nextButton;

    private Button cancelButton;

    private boolean isNext = false;

    public ImportDialog(Stage parentStage) {
        super();
        this.parentStage = parentStage;

        initGridPane();
    }


    public boolean isNext() {
        return isNext;
    }

    public String getRegistreSelected(){
        return (String) comboListRegistre.getSelectionModel().getSelectedItem().toString();
    }

    private void initGridPane() {


        labelText = new Label("Veuillez sélectionner le registre dans lequel les nouvelles données vont être importées");
        labelText.setWrapText(true);
        labelText.setTextAlignment(TextAlignment.CENTER);

        nextButton = new Button("Suivant");
        cancelButton = new Button("Annuler");
        nextButton.setOnAction(this);
        cancelButton.setOnAction(this);
        cancelButton.setAlignment(Pos.CENTER);
        nextButton.setAlignment(Pos.CENTER);


        this.setPrefSize(640,480);
        this.setAlignment(Pos.CENTER);
        this.setHgap(20);
        Insets insets = new Insets(20);
        this.setPadding(insets);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(50);
        rowConstraints.setFillHeight(true);
        rowConstraints.setVgrow(Priority.SOMETIMES);
        getRowConstraints().add(0,rowConstraints);
        getRowConstraints().add(1,rowConstraints);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        columnConstraints.setFillWidth(true);
        columnConstraints.setHgrow(Priority.SOMETIMES);
        getColumnConstraints().add(0,columnConstraints);
        getColumnConstraints().add(1,columnConstraints);

        comboListRegistre = new ComboListRegistre(parentStage);

        add(labelText,0,0);
        add(comboListRegistre,1,0);
        add(cancelButton,0,1);
        add(nextButton,1,1);




    }


    @Override
    public void handle(Event event) {
       if(event.getSource() == nextButton){
           if(!comboListRegistre.getSelectionModel().isEmpty())
            isNext = true;
           this.getScene().getWindow().hide();
       }
       if(event.getSource() == cancelButton){
           isNext = false;
           this.getScene().getWindow().hide();
       }
    }
}
