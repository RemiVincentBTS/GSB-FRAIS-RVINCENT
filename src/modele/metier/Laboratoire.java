/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Laboratoire {
    private String labCode=null;
    private String labNom=null;
    private String labChefVente=null;

    public Laboratoire() {
        
    }
    
    @Override
    public String toString() {
        return labNom;
    }
    
    public Laboratoire(String labCode, String labNom, String labChefVente) {
        this.labCode=labCode;
        this.labNom=labNom;
        this.labChefVente=labChefVente;
    }

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public String getLabNom() {
        return labNom;
    }

    public void setLabNom(String labNom) {
        this.labNom = labNom;
    }

    public String getLabChefVente() {
        return labChefVente;
    }

    public void setLabChefVente(String labChefVente) {
        this.labChefVente = labChefVente;
    }
    
    
}
