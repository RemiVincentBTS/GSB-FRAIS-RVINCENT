package controleur;

import javax.swing.JOptionPane;
import vue.VueMenu;

/**
 * Contrôleur de la fenêtre VueMenu
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class CtrlMenu extends CtrlAbstrait {

    public CtrlMenu(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueMenu(this);
    }

    public void fichierQuitter() throws Exception {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Ambulances", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.QUITTER_APPLICATION);
        }
    }

    public void afficherFenetreVisiteur() throws Exception {
        this.getCtrlPrincipal().action(EnumAction.AFFICHER_FENETRE_VISITEUR);
    }
    
    public void afficherFenetreRapportVisite() throws Exception { 
        this.getCtrlPrincipal().action(EnumAction.AFFICHER_FENETRE_RAPPORT_VISITE);
    }

    @Override
    public VueMenu getVue() {
        return (VueMenu) vue;
    }
}
