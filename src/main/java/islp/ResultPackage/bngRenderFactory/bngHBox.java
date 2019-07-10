package islp.ResultPackage.bngRenderFactory;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class bngHBox extends HBox {

    private String statutBng;

    public bngHBox(String bng) {
        super();
        this.statutBng = bng;

        this.setSpacing(1);

        if(statutBng == null)
            return;


        if(statutBng.contains("S")){
            Button but = new Button("S");
            Tooltip tooltip = new Tooltip("Stupéfiants");
            but.setTooltip(tooltip);
            but.setStyle("-fx-background-color: #FFFF00; -fx-border-width: 1px;");
            but.setMinSize(12,12);
            this.getChildren().add(but);
        }
        if(statutBng.contains("C")){
            Button but = new Button("C");
            Tooltip tooltip = new Tooltip("Atteinte aux personnes");
            but.setTooltip(tooltip);
            but.setStyle("-fx-background-color: #FF0000; -fx-border-width: 1px;");
            but.setMinSize(12,12);
            this.getChildren().add(but);
        }
        if(statutBng.contains("M")){
            Button but = new Button("M");
            Tooltip tooltip = new Tooltip("Moeurs");
            but.setTooltip(tooltip);
            but.setStyle("-fx-background-color: #FF00FF; -fx-border-width: 1px;");
            but.setMinSize(12,12);
            this.getChildren().add(but);
        }
        if(statutBng.contains("E")){
            Button but = new Button("E");
            Tooltip tooltip = new Tooltip("EcoFin");
            but.setTooltip(tooltip);
            but.setStyle("-fx-background-color: #0000FF; -fx-border-width: 1px;");
            but.setMinSize(12,12);
            this.getChildren().add(but);
        }
        if(statutBng.contains("V")){
            Button but = new Button("V");
            Tooltip tooltip = new Tooltip("Atteinte aux biens");
            but.setTooltip(tooltip);
            but.setStyle("-fx-background-color: #FFAA00; -fx-border-width: 1px;");
            but.setMinSize(12,12);
            this.getChildren().add(but);
        }

    }
}
