package islp.controllers;

import islp.Models.ResultModel;
import islp.ResultPackage.ResultArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BngStatutAction implements EventHandler<ActionEvent> {

    public enum STATUT {STUP,VOL,MOEURS,CRIME,ECOFIN,DELETE};

    private STATUT statut;

    public BngStatutAction(STATUT statut) {
        this.statut = statut;
    }

    @Override
    public void handle(ActionEvent event) {

        ResultArea resultArea = (ResultArea) SingletonObjectManager.getInstance().getObjects().get(ResultArea.class);
        if(resultArea != null){


            for(Object obj : resultArea.getSelectionModel().getSelectedItems()){
                ResultModel resultModel = (ResultModel) obj;
                // changement du statut

                // mise à jour du result model
                try {
                    changeStatut(resultModel);
                    updateModel(resultModel);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }


        }

    }

    private void updateModel(ResultModel resultModel) throws SQLException {


        String sql = "UPDATE " + resultModel.getRegistre() + " SET bng = ? WHERE id = ?";
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1,resultModel.getBng());
        ps.setLong(2,resultModel.getId());
        ps.executeUpdate();

    }

    private void changeStatut(ResultModel resultModel) {
        StringBuilder str = new StringBuilder();
        if(resultModel.getBng() != null)
            str.append(resultModel.getBng());

        switch (statut){
            case STUP: if(!str.toString().contains("S"))str.append("S");
            break;
            case VOL: if(!str.toString().contains("V"))str.append("V");
            break;
            case MOEURS: if(!str.toString().contains("M"))str.append("M");
            break;
            case CRIME:  if(!str.toString().contains("C"))str.append("C");
            break;
            case ECOFIN:  if(!str.toString().contains("E"))str.append("E");
            break;
            case DELETE: str.delete(0,str.length());
            break;
        }

        resultModel.setBng(str.toString());



    }


}
