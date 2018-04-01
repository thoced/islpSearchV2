package islp.views;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class OptionDialog extends GridPane {
    private TextField driverTextField;
    private TextField loginTextField;
    private PasswordField passwordTextField;
    private TextField hostTextField;
    private Button buttonCancel;
    private Button buttonOk;

    public OptionDialog(Stage parentStage) {
        
        initOption();
    }

    public TextField getDriverTextField() {
        return driverTextField;
    }

    public TextField getHostTextField() {
        return hostTextField;
    }

    public TextField getLoginTextField() {
        return loginTextField;
    }

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public Button getButtonCancel() {
        return buttonCancel;
    }

    public Button getButtonOk() {
        return buttonOk;
    }

    private void initOption() {

        ColumnConstraints columnConstraintsLabel = new ColumnConstraints();
        columnConstraintsLabel.setPercentWidth(30);
        columnConstraintsLabel.setHgrow(Priority.ALWAYS);
        columnConstraintsLabel.setHalignment(HPos.RIGHT);
        ColumnConstraints columnConstraintsTextField = new ColumnConstraints();
        columnConstraintsTextField.setPercentWidth(60);
        columnConstraintsTextField.setHgrow(Priority.ALWAYS);
        columnConstraintsTextField.setHalignment(HPos.RIGHT);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(10);
        rowConstraints.setVgrow(Priority.ALWAYS);
        rowConstraints.setValignment(VPos.CENTER);

        getColumnConstraints().add(0,columnConstraintsLabel);
        getColumnConstraints().add(1,columnConstraintsTextField);
        getRowConstraints().add(0,rowConstraints);
        getRowConstraints().add(1,rowConstraints);
        getRowConstraints().add(2,rowConstraints);
        getRowConstraints().add(3,rowConstraints);
        getRowConstraints().add(4,rowConstraints);
        getRowConstraints().add(5,rowConstraints);


        Label driverLabel = new Label("Driver mysql:");
        add(driverLabel,0,0);
        Label hostLabel = new Label("Host name:");
        add(hostLabel,0,1);
        Label loginLabel = new Label("Login:");
        add(loginLabel,0,2);
        Label passwordLabel = new Label("Password:");
        add(passwordLabel,0,3);


        driverTextField = new TextField();
        add(driverTextField,1,0);
        hostTextField = new TextField();
        add(hostTextField,1,1);
        loginTextField = new TextField();
        add(loginTextField,1,2);
        passwordTextField = new PasswordField();
        add(passwordTextField,1,3);

        buttonCancel = new Button("Annuler");
        buttonCancel.setCancelButton(true);
        buttonOk = new Button("Sauvegarder");
        add(buttonCancel,0,5);
        add(buttonOk,1,5);

    }
}
