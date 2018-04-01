package islp.Models;

import javafx.beans.property.*;

public class ResultModel {



    private BooleanProperty group = new SimpleBooleanProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty numero = new SimpleStringProperty();
    private StringProperty land = new SimpleStringProperty();
    private StringProperty nom = new SimpleStringProperty();
    private StringProperty prenom = new SimpleStringProperty();
    private StringProperty dateNaissance = new SimpleStringProperty();
    private StringProperty typeIslp = new SimpleStringProperty();
    private StringProperty numeroIslp = new SimpleStringProperty();
    private StringProperty annee = new SimpleStringProperty();

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

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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
}
