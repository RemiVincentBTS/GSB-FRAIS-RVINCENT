/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class EchantillonOffert {
    
    private Visiteurs visiteur;
    private RapportVisite rapportVisite;
    private Medicament medicament;
    private int quantite;

    public EchantillonOffert() {
    }

    @Override
    public String toString() {
        return " "+quantite;
    }
    
    

    public EchantillonOffert(Visiteurs visiteur, RapportVisite rapportVisite, Medicament medicament, int quantite) {
        this.visiteur = visiteur;
        this.rapportVisite = rapportVisite;
        this.medicament = medicament;
        this.quantite = quantite;
    }

    public Visiteurs getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteurs visiteur) {
        this.visiteur = visiteur;
    }

    public RapportVisite getRapportVisite() {
        return rapportVisite;
    }

    public void setRapportVisite(RapportVisite rapportVisite) {
        this.rapportVisite = rapportVisite;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
}

