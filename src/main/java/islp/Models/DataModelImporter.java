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

    private int fileSize;

    public DataModelImporter() {
        super();

    }

    public DataModelImporter(File file,String registre) throws IOException {

        this.file = file;
        this.registre = registre;

        if(registre != null)
            computeRegistre = "t_islp_" + registre;

        if(this.file != null){
            FileInputStream fileInputStream = new FileInputStream(this.file);
            if(fileInputStream != null){
               BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));

               while(bufferedReader.readLine() != null){
                    String line  = bufferedReader.readLine();
                    if(line != null){

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


    public void writeTrupleDb(DataModel model){

        String sql = "insert into " + computeRegistre +  "(numero,land,nom,prenom,date_naissance,type_islp,numero_islp,annee) " +
                "values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1,model.getNumero());
            ps.setString(2,model.getLand());
            ps.setString(3,model.getNom());
            ps.setString(4,model.getPrenom());
            ps.setString(5,model.getDateNaissance());
            ps.setString(6,model.getTypeIslp());
            ps.setString(7,model.getNumeroIslp());
            ps.setString(8,model.getAnneeIslp());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
