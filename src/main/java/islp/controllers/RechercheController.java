package islp.controllers;

import islp.Models.ArraySearch;
import islp.Models.ResultModel;
import islp.Models.SearchModel;
import islp.views.ComboListRegistre;
import islp.views.InputArea;
import islp.ResultPackage.ResultArea;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RechercheController implements EventHandler,ChangeListener<String> {

    private ComboListRegistre comboListRegistre;

    private int nbTuple;

    public RechercheController() {
    }

    public RechercheController(ComboListRegistre comboListRegistre) {
        this.comboListRegistre = comboListRegistre;
    }

    public int getNbTuple() {
        return nbTuple;
    }

    public static int getNbTupleForRegistre(String registre){
        String table = "t_islp_" + registre;
        String sql = "select count(*) from " + table;
        try {
            Statement ps = SingletonConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = ps.executeQuery(sql);
            while(resultSet.next()){
                return resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public void handle(Event event) {

        // clear
        InputArea inputArea = (InputArea) SingletonObjectManager.getInstance().getObjects().get(InputArea.class);
        if(inputArea != null){

            ArraySearch arraySearch = inputArea.getListNumero();
            if(arraySearch.size() == 0)
                return;

            if(comboListRegistre == null || comboListRegistre.getSelectionModel().getSelectedItem() == null)
                return;

            String registre = comboListRegistre.getSelectionModel().getSelectedItem().toString();
            String table = "t_islp_" + registre;

            String sql = "select * from " + table + " where numero LIKE ? OR nom LIKE ? OR prenom LIKE ?";

            ObservableList<ResultModel> observableList = FXCollections.observableArrayList();
            observableList.clear();

            int cpt = 1;

            for(SearchModel search : arraySearch) {
                    try {
                        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement(sql);
                        ps.setString(1,  "%" + search.getSearchValue() + "%" );
                        ps.setString(2,  "%" + search.getSearchValue() + "%" );
                        ps.setString(3,  "%" + search.getSearchValue() + "%" );
                        ResultSet result = ps.executeQuery();
                        if(result != null){
                            while(result.next()){
                                ResultModel model = new ResultModel();
                                model.setCpt(cpt);
                                model.setId(result.getLong("id"));
                                model.setNumero(result.getString("numero"));
                                model.setLand(result.getString("land"));
                                model.setNom(result.getString("nom"));
                                model.setPrenom(result.getString("prenom"));
                                model.setDateNaissance(result.getString("date_naissance"));
                                model.setTypeIslp(result.getString("type_islp"));
                                model.setNumeroIslp(result.getString("numero_islp"));
                                model.setAnnee(result.getString("annee"));
                                model.setBng(result.getString("bng"));
                                model.setRegistre(table);

                                // si le model n'est pas deja dans l'observable list (basé sur le nom, prenom, numero et date de naissance, alors on ajoute
                                if(!observableList.contains(model))
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

                resultArea.getItems().clear();
                resultArea.setItems(observableList);
                resultArea.refresh();



            }



        }

    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        String registre = t1;
        String table = "t_islp_" + registre;
        String sql = "select count(*) from " + table;
        try {
            Statement ps = SingletonConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = ps.executeQuery(sql);
            while(resultSet.next()){
                nbTuple = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
