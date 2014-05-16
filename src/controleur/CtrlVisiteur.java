package controleur;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.*;
import modele.metier.*;
import vue.VueVisiteur;

/**
 * Contrôleur de la fenêtre VuePresence
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class CtrlVisiteur extends CtrlAbstrait {

    private DaoVisiteur daoVisiteur = new DaoVisiteur();
    private DaoSecteur daoSecteur = new DaoSecteur();
    private DaoLaboratoire daoLaboratoire = new DaoLaboratoire();
    private static List<Visiteurs> lesVisiteurs = null;
    private static List<Secteur> lesSecteurs = null;
    private static List<Laboratoire> lesLaboratoires = null;

    public CtrlVisiteur(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueVisiteur(this);

    }

    public void fichierQuitter() throws Exception {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Ambulances", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.QUITTER_APPLICATION);
        }
    }

    public void retourMenu() throws Exception {
        this.getCtrlPrincipal().action(EnumAction.RETOUR_MENU);
    }

    // Remplissage des listes déroulantes pour l'initialisation
    public void chargerLesJComboBox() throws Exception {

        try {
            lesVisiteurs = daoVisiteur.getAll();
            lesLaboratoires = daoLaboratoire.getAll();
            lesSecteurs = daoSecteur.getAll();

        } catch (DaoException ex) {
            Logger.getLogger(CtrlVisiteur.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        // On clean les listes déroulantes.
        getVue().getModeleJComboBoxVisiteur().removeAllElements();
        getVue().getModeleJComboBoxSecteur().removeAllElements();
        getVue().getModeleJComboBoxLaboratoire().removeAllElements();

        // On remplit les listes déroulantes
        for (Visiteurs unVisiteur : lesVisiteurs) {
            getVue().getModeleJComboBoxVisiteur().addElement(unVisiteur);
        }


        for (Secteur unSecteur : lesSecteurs) {
            getVue().getModeleJComboBoxSecteur().addElement(unSecteur);
        }

        for (Laboratoire unLaboratoire : lesLaboratoires) {
            getVue().getModeleJComboBoxLaboratoire().addElement(unLaboratoire);
        }


    }

    // Méthode d'initialisation de la fenêtre visiteur 
    public void initialiserFenetre() throws Exception { 
        // On appele la méthode qui permet d'afficher la liste des visiteurs.
        chargerLesJComboBox();
        // On récupère le visiteur selectionné (c'est le premier de liste).
        Visiteurs unVisiteur = (Visiteurs) getVue().getModeleJComboBoxVisiteur().getSelectedItem();
        // On appele méthode qui permet d'afficher le reste des champs en fonction de l'item selectionné
        chargerInformationsVisiteur(unVisiteur);


    }

    // Fonction qui remplit tous les champs de la vue visiteur en fonction du visiteur selectionné dans la première jComboxBox
    public void chargerInformationsVisiteur(Visiteurs unVisiteur) {
        // On remplit les JTextFields pour un visiteur
        getVue().getjTextFieldNomVisiteur().setText(unVisiteur.getNom());
        getVue().getjTextFieldPrenomVisiteur().setText(unVisiteur.getPrenom());
        getVue().getjTextFieldAdresseVisiteur().setText(unVisiteur.getAdresse());
        getVue().getjTextFieldVilleVisiteur().setText(unVisiteur.getVille());
        getVue().getjTextFieldCodePostalVisiteur().setText(unVisiteur.getCp());
        // Pour les secteurs il existe des visiteurs qui n'ont pas de secteurs donc on pré-remplie "pas de secteur" pour ces visiteurs
        if (unVisiteur.getSecteur().getLibelleSecteur() == null) {
            getVue().getModeleJComboBoxSecteur().setSelectedItem("Pas de Secteur");
        } else {
            getVue().getModeleJComboBoxSecteur().setSelectedItem(unVisiteur.getSecteur());
        }
        // On remplit le JComboBox des laboratoires
        getVue().getModeleJComboBoxLaboratoire().setSelectedItem(unVisiteur.getLaboratoire());

    }

    public void ChercherUnVisiteur() {
        Visiteurs unVisiteur = (Visiteurs) getVue().getModeleJComboBoxVisiteur().getSelectedItem();
        chargerInformationsVisiteur(unVisiteur);
    }

    public void Precedent() {
        // On calcule la taille max de la liste déroulante
        int tailleMax = getVue().getjComboBoxListeVisiteurs().getItemCount();
        // On calcule la taille de la liste déroulante jusqu'à l'item selectionné
        int tailleActuelle = getVue().getjComboBoxListeVisiteurs().getSelectedIndex();
        if (tailleActuelle != 0) {
            int VisiteurPrecedent = getVue().getjComboBoxListeVisiteurs().getSelectedIndex() - 1;
            getVue().getjComboBoxListeVisiteurs().setSelectedIndex(VisiteurPrecedent);
        } else {
            // -1 car la liste commence à 0
            getVue().getjComboBoxListeVisiteurs().setSelectedIndex(tailleMax - 1);
        }

        Visiteurs unVisiteur = (Visiteurs) getVue().getModeleJComboBoxVisiteur().getSelectedItem();
        chargerInformationsVisiteur(unVisiteur);
    }

    public void Suivant() {
        // On calcule la taille max de la liste déroulante (-1 car car ca commence à 0)
        int tailleMax = getVue().getjComboBoxListeVisiteurs().getItemCount() - 1;
        // On calcule la taille de la liste déroulante jusqu'à l'item selectionné
        int tailleActuelle = getVue().getjComboBoxListeVisiteurs().getSelectedIndex();
        if (tailleActuelle != tailleMax) {
            int VisiteurSuivant = getVue().getjComboBoxListeVisiteurs().getSelectedIndex() + 1;
            getVue().getjComboBoxListeVisiteurs().setSelectedIndex(VisiteurSuivant);
        } else {
            getVue().getjComboBoxListeVisiteurs().setSelectedIndex(0);
        }

        Visiteurs unVisiteur = (Visiteurs) getVue().getModeleJComboBoxVisiteur().getSelectedItem();
        chargerInformationsVisiteur(unVisiteur);

    }


    @Override
    public VueVisiteur getVue() {
        return (VueVisiteur) vue;
    }

    public void visiteurAfficher() {
        String msg = "erreur"; // message à afficher en cas d'erreur
        // récupérer les valeurs saisies
        if (getVue() != null) {
        }
    }
}
