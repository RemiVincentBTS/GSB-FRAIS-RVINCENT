/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Medicament {

    private String depotLegalMedicament;
    private String nomCommercialMedicament;

    public Medicament() {
    }

    @Override
    public String toString() {
        return  nomCommercialMedicament;
    }
    
    public Medicament(String depotLegalMedicament, String nomCommercialMedicament) {
        this.depotLegalMedicament = depotLegalMedicament;
        this.nomCommercialMedicament = nomCommercialMedicament;   
    }

    public String getDepotLegalMedicament() {
        return depotLegalMedicament;
    }

    public void setDepotLegalMedicament(String depotLegalMedicament) {
        this.depotLegalMedicament = depotLegalMedicament;
    }

    public String getNomCommercialMedicament() {
        return nomCommercialMedicament;
    }

    public void setNomCommercialMedicament(String nomCommercialMedicament) {
        this.nomCommercialMedicament = nomCommercialMedicament;
    }
    
    
}


