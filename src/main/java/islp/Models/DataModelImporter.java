package islp.Models;

import islp.islp.controllers.SingletonConnection;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataModelImporter extends ArrayList<DataModel> {

    private File file = null;

    private String registre = null;

    private String computeRegistre = "t_islp_zp_5278_seraing_neupre";

    private PreparedStatement preparedStatement;

    private int fileSize;

    public DataModelImporter() throws SQLException {
        super();

    }

    public DataModelImporter(File file,String registre) throws IOException, SQLException {

        this.file = file;
        this.registre = registre;

        if(registre != null)
            computeRegistre = "t_islp_" + registre;

        String sql = "insert into " + computeRegistre +  "(numero,land,nom,prenom,date_naissance,type_islp,numero_islp,annee) " +
                "values (?,?,?,?,?,?,?,?)";


        if(preparedStatement != null)
            preparedStatement.close();

        preparedStatement = SingletonConnection.getInstance().getConnection().prepareStatement(sql);

        this.clear();

        if(this.file != null){
            FileInputStream fileInputStream = new FileInputStream(this.file);
            if(fileInputStream != null){
               BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));

               String line = null;
               while((line = bufferedReader.readLine()) != null){

                        String[] split = line.split("\t");
                        // si la séparation se fait avec des tabulations
                        if(split != null && split.length > 7){
                            DataModel model = new DataModel();
                            model.setNumero(split[0].trim());
                            model.setLand(split[1].trim());
                            model.setNom(split[2].trim());
                            model.setPrenom(split[3].trim());
                            model.setDateNaissance(split[4].trim());
                            model.setTypeIslp(split[5].trim());
                            model.setNumeroIslp(split[6].trim());
                            model.setAnneeIslp(split[7].trim());
                            this.add(model);

                    }
               }

               bufferedReader.close();

            }

            fileInputStream.close();
        }
    }

    public String getRegistre() {
        return registre;
    }

    public void setRegistre(String registre) {
        this.registre = registre;
    }


    public void writeTrupleDb(DataModel model) throws SQLException {

            if(preparedStatement != null && !preparedStatement.isClosed()) {

                try {
                    preparedStatement.setString(1, model.getNumero());
                    preparedStatement.setString(2, model.getLand());
                    preparedStatement.setString(3, model.getNom());
                    preparedStatement.setString(4, model.getPrenom());
                    preparedStatement.setString(5, model.getDateNaissance());
                    preparedStatement.setString(6, model.getTypeIslp());
                    preparedStatement.setString(7, model.getNumeroIslp());
                    preparedStatement.setString(8, model.getAnneeIslp());
                    preparedStatement.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {

                }
            }


    }

    public void close() throws SQLException {
        if(preparedStatement != null)
            preparedStatement.close();
    }
}
