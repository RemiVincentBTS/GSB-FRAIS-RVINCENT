/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.sql.Date;

/**
 *
 * @author btssio
 */
public class RapportVisite {
    
    private int numRapportVisite;
    private Visiteurs Visiteur;  
    private Praticien Praticien;
    Date dateRapportVisite;
    String bilanRapportVisite;
    String motifRapportVisite;

    @Override
    public String toString() {
        return "Rapport n°"+numRapportVisite;
    }  
    
     public RapportVisite() {
    }
    
     

    public RapportVisite(int numRapportVisite, Visiteurs Visiteur, Praticien Praticien, Date dateRapportVisite, String bilanRapportVisite, String motifRapportVisite) {
        this.numRapportVisite = numRapportVisite;
        this.Visiteur = Visiteur;
        this.Praticien = Praticien;
        this.dateRapportVisite = dateRapportVisite;
        this.bilanRapportVisite = bilanRapportVisite;
        this.motifRapportVisite = motifRapportVisite;
    }

    public int getNumRapportVisite() {
        return numRapportVisite;
    }

    public void setNumRapportVisite(int numRapportVisite) {
        this.numRapportVisite = numRapportVisite;
    }

    public Visiteurs getVisiteur() {
        return Visiteur;
    }

    public void setVisiteur(Visiteurs Visiteur) {
        this.Visiteur = Visiteur;
    }

    public Praticien getPraticien() {
        return Praticien;
    }

    public void setPraticien(Praticien Praticien) {
        this.Praticien = Praticien;
    }

    public Date getDateRapportVisite() {
        return dateRapportVisite;
    }

    public void setDateRapportVisite(Date dateRapportVisite) {
        this.dateRapportVisite = dateRapportVisite;
    }

    public String getBilanRapportVisite() {
        return bilanRapportVisite;
    }

    public void setBilanRapportVisite(String bilanRapportVisite) {
        this.bilanRapportVisite = bilanRapportVisite;
    }

    public String getMotifRapportVisite() {
        return motifRapportVisite;
    }

    public void setMotifRapportVisite(String motifRapportVisite) {
        this.motifRapportVisite = motifRapportVisite;
    }

   
    
}

