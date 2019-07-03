package islp.Models;

import islp.controllers.SingletonConnection;
import javafx.beans.property.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultModel {

    private BooleanProperty group = new SimpleBooleanProperty();
    private LongProperty id = new SimpleLongProperty();
    private IntegerProperty cpt = new SimpleIntegerProperty();
    private StringProperty numero = new SimpleStringProperty();
    private StringProperty land = new SimpleStringProperty();
    private StringProperty nom = new SimpleStringProperty();
    private StringProperty prenom = new SimpleStringProperty();
    private StringProperty dateNaissance = new SimpleStringProperty();
    private StringProperty typeIslp = new SimpleStringProperty();
    private StringProperty numeroIslp = new SimpleStringProperty();
    private StringProperty annee = new SimpleStringProperty();
    private StringProperty bng = new SimpleStringProperty();
    private StringProperty registre = new SimpleStringProperty();

    public ResultModel() {
    }

    public boolean getGroup() {
        return group.get();
    }

    public BooleanProperty groupProperty() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group.set(group);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public int getCpt() {
        return cpt.get();
    }

    public IntegerProperty cptProperty() {
        return cpt;
    }

    public void setCpt(int cpt) {
        this.cpt.set(cpt);
    }

    public String getNumero() {
        return numero.get();
    }

    public StringProperty numeroProperty() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public String getLand() {
        return land.get();
    }

    public StringProperty landProperty() {
        return land;
    }

    public void setLand(String land) {
        this.land.set(land);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getDateNaissance() {
        return dateNaissance.get();
    }

    public StringProperty dateNaissanceProperty() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance.set(dateNaissance);
    }

    public String getTypeIslp() {
        return typeIslp.get();
    }

    public StringProperty typeIslpProperty() {
        return typeIslp;
    }

    public void setTypeIslp(String typeIslp) {
        this.typeIslp.set(typeIslp);
    }

    public String getNumeroIslp() {
        return numeroIslp.get();
    }

    public StringProperty numeroIslpProperty() {
        return numeroIslp;
    }

    public void setNumeroIslp(String numeroIslp) {
        this.numeroIslp.set(numeroIslp);
    }

    public String getAnnee() {
        return annee.get();
    }

    public StringProperty anneeProperty() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee.set(annee);
    }

    public String getDateNaissanceFormat(){
        if(dateNaissance.getValue() != null && !dateNaissance.getValue().isEmpty()) {
            String annee = dateNaissance.getValue().substring(0, 4);
            String mois = dateNaissance.getValue().substring(4, 6);
            String jour = dateNaissance.getValue().substring(6, 8);
            String dateNaissanceFormat = jour + "/" + mois + "/" + annee;
            return dateNaissanceFormat;
        }
        else
            return null;

    }

    public String getBng() {
        return bng.get();
    }

    public StringProperty bngProperty() {
        return bng;
    }

    public void setBng(String bng) {
        this.bng.set(bng);
    }

    public String getRegistre() {
        return registre.get();
    }

    public StringProperty registreProperty() {
        return registre;
    }

    public void setRegistre(String registre) {
        this.registre.set(registre);
    }

    public List<ResultModel> getListResultModelByKey() throws SQLException {
        ArrayList<ResultModel> list = new ArrayList<ResultModel>();


        String sql = "SELECT * FROM " + this.getRegistre() + " WHERE nom = ? AND prenom = ? AND numero = ?";
        System.out.println(sql);
        PreparedStatement ps =  SingletonConnection.getInstance().getConnection().prepareStatement(sql);
        ps.setString(1,this.getNom());
        ps.setString(2,this.getPrenom());
        ps.setString(3,this.getNumero());
        ResultSet resultSet = ps.executeQuery();
        int cpt = 1;
        while(resultSet.next()){
            ResultModel model = new ResultModel();
            model.setCpt(cpt);
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setLand(resultSet.getString("land"));
            model.setNom(resultSet.getString("nom"));
            model.setPrenom(resultSet.getString("prenom"));
            model.setDateNaissance(resultSet.getString("date_naissance"));
            model.setTypeIslp(resultSet.getString("type_islp"));
            model.setNumeroIslp(resultSet.getString("numero_islp"));
            model.setAnnee(resultSet.getString("annee"));
            model.setBng(resultSet.getString("bng"));
            model.setRegistre(this.getRegistre());
            list.add(model);
        }


        return list;
    }

    @Override
    public boolean equals(Object obj) {
       ResultModel model = (ResultModel) obj;
        if(model.getNumero().equals(this.getNumero()) &&
                model.getNom().equals(this.getNom()) &&
                model.getPrenom().equals(this.getPrenom()) &&
                model.getDateNaissance().equals(this.getDateNaissance())){
            return true;

        }
        else
            return false;

    }
}
