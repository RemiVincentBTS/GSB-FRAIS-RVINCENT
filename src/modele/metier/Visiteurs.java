/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;


/**
 *
 * @author btssio
 * 
 */

public class Visiteurs {
    
    private String matricule = null;
    private String nom = null;
    private String prenom = null;
    private String cp = null;
    private String ville = null;
    private String date_embauche = null;
    private String adresse = null;
    private Secteur secteur;
    private Laboratoire laboratoire;

    @Override
    public String toString() {
        return nom + " " + prenom;
    }

    public Visiteurs() {
    }


    public Visiteurs(String matricule, String nom, String prenom, String cp, String ville, String date_embauche, String adresse, Secteur secteur, Laboratoire laboratoire) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.cp = cp;
        this.ville = ville;
        this.date_embauche = date_embauche;
        this.adresse = adresse;
        this.secteur = secteur;
        this.laboratoire = laboratoire;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Laboratoire getLaboratoire() {
        return laboratoire;
    }

    public void setLaboratoire(Laboratoire laboratoire) {
        this.laboratoire = laboratoire;
    }   
    
    public String getMatricule() {
        return matricule;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(String date_embauche) {
        this.date_embauche = date_embauche;
    }
    
    
    
}
