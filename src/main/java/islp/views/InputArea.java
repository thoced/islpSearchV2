package islp.views;

import islp.Models.ArraySearch;
import islp.Models.NumeroModel;
import islp.Models.SearchModel;
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

    public ArraySearch getListNumero(){

        ArraySearch arrayNumero = new ArraySearch();
        String text = getText().trim();
        String[] splitNumero = text.split("\n");
        if(splitNumero != null){
            for(String s : splitNumero){
                if(s != null && !s.isEmpty()) {
                    SearchModel search = new SearchModel(s);
                    arrayNumero.add(search);
                }
            }
        }

        return arrayNumero;
    }


}
