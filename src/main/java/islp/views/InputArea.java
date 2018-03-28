package islp.views;

import islp.Models.ArrayNumero;
import islp.Models.NumeroModel;
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

    public ArrayNumero getListNumero(){

        ArrayNumero arrayNumero = new ArrayNumero();
        String text = getText();
        String[] splitNumero = text.split("\n");
        if(splitNumero != null){
            for(String s : splitNumero){
                NumeroModel numero = new NumeroModel(s);
                arrayNumero.add(numero);
            }
        }

        return arrayNumero;
    }


}
