package islp.controllers;

import javafx.event.Event;
import javafx.event.EventHandler;

public class CloseAction implements EventHandler{
    @Override
    public void handle(Event event) {
        System.exit(1);
    }
}
