package islp.optionPackage;

import islp.controllers.CConfig;
import islp.controllers.PropertiesNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.*;

import java.io.IOException;

public class OptionAction implements EventHandler<ActionEvent>{

    private Stage parentStage;

    private Stage stage;

    private OptionDialog optionDialog = null;

    private CConfig config;

    public OptionAction(Stage parentStage) {
        this.parentStage = parentStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

         if(optionDialog == null) {
             optionDialog = new OptionDialog(parentStage);
             try {
                 config = new CConfig();
             } catch (IOException e) {
                 e.printStackTrace();
             } catch (PropertiesNotFoundException e) {
                 e.printStackTrace();
             }
             optionDialog.getDriverTextField().setText(config.getDriver());
             optionDialog.getHostTextField().setText(config.getUrl());
             optionDialog.getLoginTextField().setText(config.getLogin());
             optionDialog.getPasswordTextField().setText(config.getPassword());
             optionDialog.getButtonCancel().setOnAction((ActionEvent a) -> {
                 hideAndClose();
             });
             optionDialog.getButtonOk().setOnAction((ActionEvent a) -> {
                 try {
                     CConfig config = new CConfig();
                     config.setDriver(optionDialog.getDriverTextField().getText());
                     config.setUrl(optionDialog.getHostTextField().getText());
                     config.setLogin(optionDialog.getLoginTextField().getText());
                     config.setPassword(optionDialog.getPasswordTextField().getText());
                     config.saveConfig();
                     hideAndClose();
                 } catch (IOException e) {
                     e.printStackTrace();
                 } catch (PropertiesNotFoundException e) {
                     e.printStackTrace();
                 }
             });
             Scene scene = new Scene(optionDialog, 640, 320);
             scene.getStylesheets().add("style.css");
             stage = new Stage();
             stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, (WindowEvent a) -> {
                 hideAndClose();
             });
             stage.initStyle(StageStyle.UTILITY);
             stage.initModality(Modality.APPLICATION_MODAL);
             stage.setScene(scene);
             stage.setTitle("Options");
             stage.showAndWait();

         }

    }

    private void hideAndClose() {
        if(optionDialog != null){
            stage.hide();
            optionDialog = null;
        }
    }
}
