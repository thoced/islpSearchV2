package islp.infoTuplePackage;


import islp.Models.ResultModel;
import islp.ResultPackage.ResultArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class InfoView extends BorderPane {

    private ResultArea tableView;

    private List<ResultModel> list;

    private Button buttonOk;

    public InfoView(List<ResultModel> list) {

        this.list = list;
        ObservableList<ResultModel> observableList = FXCollections.observableArrayList(this.list);
        tableView = new ResultArea();
        tableView.getColumns().remove(tableView.getBng());
        tableView.setItems(observableList);

        // ajout du tableView au centre
        this.setCenter(tableView);

        // ajout du bouton
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_RIGHT);
        buttonOk = new Button("Ok");
        buttonOk.setMinWidth(64);
        buttonOk.setMinHeight(48);
        buttonOk.setLineSpacing(8);
        hBox.getChildren().addAll(buttonOk);
        this.setBottom(hBox);

    }

    public ResultArea getTableView() {
        return tableView;
    }

    public Button getButtonOk() {
        return buttonOk;
    }
}
