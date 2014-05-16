/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Secteur {
    
    private String codeSecteur;
    private String libelleSecteur;

    public Secteur() {
    }
    
    @Override
    public String toString() {
        return libelleSecteur;
    }
    
    public Secteur(String codeSecteur, String libelleSecteur) {
        this.codeSecteur=codeSecteur;
        this.libelleSecteur=libelleSecteur;

    }

    public String getCodeSecteur() {
        return codeSecteur;
    }

    public void setCodeSecteur(String codeSecteur) {
        this.codeSecteur = codeSecteur;
    }

    public String getLibelleSecteur() {
        return libelleSecteur;
    }

    public void setLibelleSecteur(String libelleSecteur) {
        this.libelleSecteur = libelleSecteur;
    }
    
   
}
