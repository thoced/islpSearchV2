package islp.Models;

import islp.islp.controllers.SingletonConnection;
import islp.main.IslpMainApp;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class ObservableRegistre extends ArrayList<RegistreModel>{

    private static final Logger log = Logger.getLogger(ObservableRegistre.class.getName());



    public ObservableRegistre() {


        String sql = "select * from t_registre_zone ORDER BY registre ASC";
        try {
            Statement st = SingletonConnection.getInstance().getConnection().createStatement();
            ResultSet result = st.executeQuery(sql);
            if(result != null){
                while(result.next()){
                    RegistreModel model = new RegistreModel(result.getString("registre"));
                    add(model);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        } catch(NullPointerException e){
            System.out.println("TEST !!!!!!!!!! " + e.getMessage());
            log.debug(e.getMessage());
        }

    }

}
