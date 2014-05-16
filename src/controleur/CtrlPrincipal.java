package controleur;

import static controleur.EnumAction.*;
import javax.swing.JOptionPane;
import modele.jdbc.Jdbc;

/**
 * Controleur principal (ou frontal) - un lien vers chaque contrôleur de base
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class CtrlPrincipal {

    private CtrlVisiteur ctrlVisiteur = null;
    private CtrlMenu ctrlMenu = null;
    private CtrlRapportVisite ctrlRapportVisite = null;

    /**
     * action par défaut action au démarrage de l'application
     */
    public void action() {
        if (ctrlMenu == null) {
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }

    public void action(EnumAction action) throws Exception {
        switch (action) {
            case AFFICHER_FENETRE_VISITEUR: // activation de vuePresence depuis vueMenu
                afficherFenetreVisiteur();
                break;
            case AFFICHER_FENETRE_RAPPORT_VISITE:
                afficherFenetreRapportVisite();
                break;
            case RETOUR_MENU:    // retour à vueMenu depuis la vuePresence
                retourMenu();
                break;
            case QUITTER_APPLICATION: // fin de l'application depuis vueMenu
                quitterApplication();
                break;
        }

    }

    /**
     * Fin définitive de l'application La demande de confirmation est gérée par
     * le contrôleur spécialisé
     */
    private void quitterApplication() {
        try {
            Jdbc.getInstance().deconnecter();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }
    }

    /**
     * Transition vueMenu / vuePresence
     */
    
    private void afficherFenetreRapportVisite() throws Exception {
        if (ctrlRapportVisite == null) {
            ctrlRapportVisite = new CtrlRapportVisite(this);
        }
        
        ctrlRapportVisite.initialiserFenetre();
        ctrlRapportVisite.getVue().setVisible(true);
        ctrlMenu.getVue().setVisible(false);
    }  
    
    private void afficherFenetreVisiteur() throws Exception {
        
        if (ctrlVisiteur == null) {
            ctrlVisiteur = new CtrlVisiteur(this);
        } 
        ctrlVisiteur.initialiserFenetre();
        ctrlVisiteur.getVue().setVisible(true);
        ctrlMenu.getVue().setVisible(false);
      
    }

     
    
    /**
     * Transition vue x à vueMenu
     */
    private void retourMenu() {
        if (ctrlMenu == null) {
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlVisiteur.getVue().setVisible(false);
        ctrlMenu.getVue().setVisible(true);
    }
    
 
}
