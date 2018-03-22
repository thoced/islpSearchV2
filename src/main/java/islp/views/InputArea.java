package islp.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class InputArea extends TextArea{

    public InputArea() {
        super();

        this.setMinWidth(128);
        this.setMaxWidth(192);
    }


}
