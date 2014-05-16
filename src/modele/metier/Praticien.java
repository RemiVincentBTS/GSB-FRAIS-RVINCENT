/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Praticien {
    
    private String numPraticien;
    private String nomPraticien;
    private String prenomPraticien;
    private String adressePraticien;            
    private String villePraticien;
 

    public Praticien() {
    }
    
    @Override
    public String toString() {
        return nomPraticien + " " + prenomPraticien;
    }
    
    public Praticien(String numPraticien, String nomPraticien, String prenomPraticien, String adressePraticien, String villePraticien) {
        this.numPraticien = numPraticien;
        this.nomPraticien = nomPraticien;
        this.prenomPraticien = prenomPraticien;
        this.adressePraticien = adressePraticien;
        this.villePraticien = villePraticien;
    }

    public String getNumPraticien() {
        return numPraticien;
    }

    public void setNumPraticien(String numPraticien) {
        this.numPraticien = numPraticien;
    }

    public String getNomPraticien() {
        return nomPraticien;
    }

    public void setNomPraticien(String nomPraticien) {
        this.nomPraticien = nomPraticien;
    }

    public String getPrenomPraticien() {
        return prenomPraticien;
    }

    public void setPrenomPraticien(String prenomPraticien) {
        this.prenomPraticien = prenomPraticien;
    }

    public String getAdressePraticien() {
        return adressePraticien;
    }

    public void setAdressePraticien(String adressePraticien) {
        this.adressePraticien = adressePraticien;
    }

    public String getVillePraticien() {
        return villePraticien;
    }

    public void setVillePraticien(String villePraticien) {
        this.villePraticien = villePraticien;
    }
    
    
}
