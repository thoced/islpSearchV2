package islp.ResultPackage;

import islp.infoTuplePackage.InfoView;
import islp.Models.ResultModel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class ShowInfoAction implements EventHandler< MouseEvent> {

    private ResultArea resultArea;

    public ShowInfoAction(ResultArea resultArea) {
        this.resultArea = resultArea;
    }

    @Override
    public void handle(MouseEvent event) {

        if(event.getClickCount() > 1) {
            ResultModel resultModel = (ResultModel) this.resultArea.getSelectionModel().getSelectedItem();
            if (resultModel != null) {
                try {
                    List<ResultModel> list = resultModel.getListResultModelByKey();

                    // ouverture de la fenetre des infos
                    Stage stage = new Stage();
                    InfoView infoView = new InfoView(list);
                    infoView.getButtonOk().setOnAction((eventButton) -> {
                        stage.hide();
                    });
                    Scene scene = new Scene(infoView, 1024, 512);
                    stage.setScene(scene);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Liste des enregistrements identiques");
                    stage.showAndWait();


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
