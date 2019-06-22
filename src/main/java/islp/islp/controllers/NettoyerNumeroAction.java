package islp.islp.controllers;

import islp.Models.NumeroModel;
import islp.Models.SearchModel;
import islp.views.InputArea;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.awt.*;

public class NettoyerNumeroAction implements EventHandler{

    private InputArea textArea;

    public NettoyerNumeroAction(InputArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void handle(Event event) {

        String out = new String();

        textArea.setText("");

        if(textArea != null){
            for(SearchModel numero : textArea.getListNumero()){
               //numero.setNumero(numero.getNumero().replace(".",""));
               out += "coucou";
            }

            System.out.println(out);
            textArea.setText(out);

        }
    }
}
