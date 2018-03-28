package islp.views;

import islp.Models.ObservableRegistre;
import islp.Models.RegistreModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ComboListRegistre extends ComboBox{
    private Stage parentStage;

    public ComboListRegistre(Stage parentStage) {
        super();
        this.parentStage = parentStage;

        ObservableRegistre observableRegistre = new ObservableRegistre();
        ObservableList<RegistreModel> observableList = FXCollections.observableArrayList(observableRegistre);
        setItems(observableList);



    }
}
