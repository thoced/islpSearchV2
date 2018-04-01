package islp.islp.controllers;

import islp.Models.ArrayNumero;
import islp.Models.NumeroModel;
import islp.Models.ResultModel;
import islp.views.ButtonArea;
import islp.views.ComboListRegistre;
import islp.views.InputArea;
import islp.views.ResultArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RechercheController implements EventHandler {

    private ComboListRegistre comboListRegistre;

    public RechercheController(ComboListRegistre comboListRegistre) {
        this.comboListRegistre = comboListRegistre;
    }

    @Override
    public void handle(Event event) {

        // clear
        InputArea inputArea = (InputArea) SingletonObjectManager.getInstance().getObjects().get(InputArea.class);
        if(inputArea != null){

            ArrayNumero arrayNumero = inputArea.getListNumero();
            if(arrayNumero.size() == 0)
                return;

            if(comboListRegistre == null || comboListRegistre.getSelectionModel().getSelectedItem() == null)
                return;

            String registre = comboListRegistre.getSelectionModel().getSelectedItem().toString();
            String table = "t_islp_" + registre;

            String sql = "select * from " + table + " where numero LIKE ?";

            ObservableList<ResultModel> observableList = FXCollections.observableArrayList();
            observableList.clear();



            int cpt = 1;

            for(NumeroModel numero : arrayNumero) {
                    try {
                        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement(sql);
                        ps.setString(1,  "%" + numero.getNumero() + "%" );
                        ResultSet result = ps.executeQuery();
                        if(result != null){
                            while(result.next()){
                                ResultModel model = new ResultModel();
                                model.setId(cpt);
                                model.setNumero(result.getString("numero"));
                                model.setLand(result.getString("land"));
                                model.setNom(result.getString("nom"));
                                model.setPrenom(result.getString("prenom"));
                                model.setDateNaissance(result.getString("date_naissance"));
                                model.setTypeIslp(result.getString("type_islp"));
                                model.setNumeroIslp(result.getString("numero_islp"));
                                model.setAnnee(result.getString("annee"));

                                observableList.add(model);
                                cpt++;

                            }
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }


            ResultArea resultArea = (ResultArea) SingletonObjectManager.getInstance().getObjects().get(ResultArea.class);
            if(resultArea != null){

                resultArea.setItems(observableList);
            }



        }

    }
}
