package islp.Models;

import islp.controllers.SingletonConnection;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
