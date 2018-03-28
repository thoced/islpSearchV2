package islp.Models;

import java.io.Serializable;

public class DataModel implements Serializable {

    private String typeIslp;
    private String numeroIslp;
    private String anneeIslp;
    private String numero;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String land;

    public DataModel() {
    }

    public String getTypeIslp() {
        return typeIslp;
    }

    public void setTypeIslp(String typeIslp) {
        this.typeIslp = typeIslp;
    }

    public String getNumeroIslp() {
        return numeroIslp;
    }

    public void setNumeroIslp(String numeroIslp) {
        this.numeroIslp = numeroIslp;
    }

    public String getAnneeIslp() {
        return anneeIslp;
    }

    public void setAnneeIslp(String anneeIslp) {
        this.anneeIslp = anneeIslp;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "typeIslp='" + typeIslp + '\'' +
                ", numeroIslp='" + numeroIslp + '\'' +
                ", anneeIslp='" + anneeIslp + '\'' +
                ", numero='" + numero + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", land='" + land + '\'' +
                '}';
    }
}
