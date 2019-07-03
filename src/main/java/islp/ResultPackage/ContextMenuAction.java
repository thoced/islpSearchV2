package islp.ResultPackage;

import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;

public class ContextMenuAction implements EventHandler< ContextMenuEvent> {

    private ResultArea resultArea;

    public ContextMenuAction(ResultArea resultArea){
        this.resultArea = resultArea;
    }

    @Override
    public void handle(ContextMenuEvent event) {

        resultArea.getContext().show(resultArea.getScene().getWindow(),event.getScreenX(),event.getScreenY());
    }
}
