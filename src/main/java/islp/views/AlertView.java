package islp.views;

import javafx.scene.control.Alert;

public class AlertView {
    public AlertView(String title,String contentAlert){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(contentAlert);
        alert.show();

    }
}
