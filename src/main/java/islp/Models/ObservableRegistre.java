package islp.Models;

import islp.islp.controllers.SingletonConnection;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class ObservableRegistre extends ArrayList<RegistreModel>{
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
        }
    }
}
