/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modele.dao.*;
import modele.jdbc.Jdbc;
import modele.metier.*;
import vue.VueRapportVisite;

/**
 *
 * @author btssio
 */
public class CtrlRapportVisite extends CtrlAbstrait {

    private DaoPraticien daoPracticien = new DaoPraticien();
    private DaoRapportVisite daoRapportVisite = new DaoRapportVisite();
    private DaoEchantillonOffert daoEchantillonOffert = new DaoEchantillonOffert();
    private DaoVisiteur daoVisiteur = new DaoVisiteur();
    private DaoMedicament daoMedicament = new DaoMedicament();
    private static List<RapportVisite> lesRapportVisite = null;
    private static List<Praticien> lesPracticiens = null;
    private static List<EchantillonOffert> lesEchantillonsOfferts = null;
    private static List<Visiteurs> lesVisiteurs = null;
    private static List<Medicament> lesMedicaments = null;

    public CtrlRapportVisite(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueRapportVisite(this);

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

    public void initialiserFenetre() throws Exception {

        // On appele la méthode qui permet d'afficher la liste des Praticiens.
        chargerLesJComboBox();
        // On récupère l'objet selectionné
        RapportVisite unRapportVisite = (RapportVisite) getVue().getModeleJComboBoxNumeroRapport().getSelectedItem();

        // Ces lignes permettent de revenir à la normal à la fin de la création d'un nouveau rapport de visite
        getVue().getjButtonAjouterRapport().setVisible(false);
        getVue().getjButtonMedicament().setVisible(false);
        getVue().getjButtonPrecedent().setEnabled(true);
        getVue().getjButtonSuivant().setEnabled(true);
        getVue().getjButtonSaisieRapport().setVisible(true);
        getVue().getjComboBoxNumeroRapport().setEnabled(false);

        // On vide le tableau
        ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).setRowCount(0);

        // On appele méthode qui permet d'afficher le reste des champs en fonction de l'item selectionné
        chargerInformationsRapportVisite(unRapportVisite);


    }

    // Méthode qui permet de charger un rapport de visite avec ses échantillons celon le visiteur selectionné
    public void chargerInformationsRapportVisite(RapportVisite unRapportVisite) throws Exception {
        // On remplit les champs pour un rapport de visite
        getVue().getjDateChooserDateRapport().setDate(unRapportVisite.getDateRapportVisite());
        getVue().getjTextFieldMotifVisite().setText(unRapportVisite.getMotifRapportVisite());
        getVue().getjTextAreaBilan().setText(unRapportVisite.getBilanRapportVisite());
        
        // On remplit la liste déroulante des practiciens en fonction du rapport selectionné
        getVue().getModeleJComboBoxPraticien().setSelectedItem(unRapportVisite.getPraticien());
        getVue().getModeleJComboBoxVisiteur().setSelectedItem(unRapportVisite.getVisiteur());
        ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).setRowCount(0);

        // On récupère le numero de rapport du rapport en cours de visualisation
        int numRapport = unRapportVisite.getNumRapportVisite();
        
        // On récupère les échantillons en relation avec le rapport en cours de visualisation
        lesEchantillonsOfferts = daoEchantillonOffert.getAllSpecial(numRapport);
        
        int nbLigne = 0;
        // On rempli le tableau des échantillons avec les échantillons récupérés
        for (EchantillonOffert unEchantillonOffert : lesEchantillonsOfferts) {
            ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).setRowCount(nbLigne + 1);
            getVue().getjTableEchantillon().setValueAt(unEchantillonOffert.getMedicament(), nbLigne, 0);
            getVue().getjTableEchantillon().setValueAt(unEchantillonOffert.getQuantite(), nbLigne, 1);
            nbLigne++;
        }





    }
    // Méthode qui rempli les listes déroulantes
    public void chargerLesJComboBox() throws Exception {
        
        try {
            lesRapportVisite = daoRapportVisite.getAll();
            lesPracticiens = daoPracticien.getAll();
            lesVisiteurs = daoVisiteur.getAll();

        } catch (DaoException ex) {
            Logger.getLogger(CtrlRapportVisite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        // On clean les listes déroulantes.
        getVue().getModeleJComboBoxPraticien().removeAllElements();
        getVue().getModeleJComboBoxNumeroRapport().removeAllElements();

        // On remplit les listes déroulantes
        for (Praticien unPracticien : lesPracticiens) {
            getVue().getModeleJComboBoxPraticien().addElement(unPracticien);
        }

        for (RapportVisite unRapportVisite : lesRapportVisite) {
            getVue().getModeleJComboBoxNumeroRapport().addElement(unRapportVisite);
        }

        for (Visiteurs unVisiteur : lesVisiteurs) {
            getVue().getModeleJComboBoxVisiteur().addElement(unVisiteur);
        }

    }

    // Méthode qui permet de saisir un nouveau rapport avec ses échantillons
    public void SaisieNouveauRapportVisite() throws Exception {
        
        // Objet rapport de visite pour créer le nouveau rapport
        RapportVisite unRapportVisite = new RapportVisite();

        // On récupère les données que l'utilisateur a saisi et on les insère dans un rapport de visite
        unRapportVisite.setVisiteur((Visiteurs) getVue().getModeleJComboBoxVisiteur().getSelectedItem());
        unRapportVisite.setPraticien((Praticien) getVue().getModeleJComboBoxPraticien().getSelectedItem());
        unRapportVisite.setDateRapportVisite(Jdbc.utilDateToSqlDate(getVue().getjDateChooserDateRapport().getDate()));
        unRapportVisite.setMotifRapportVisite(getVue().getjTextFieldMotifVisite().getText());
        unRapportVisite.setBilanRapportVisite(getVue().getjTextAreaBilan().getText());

        // Ce rapport de visite permet de récupérer le dernier rapport créé avant la création du rapport du visite que l'on est en train de créer
        // et donc de récupérer son numero de rapport généré par la bdd 
        RapportVisite dernierRapportVisite = new RapportVisite();
        dernierRapportVisite = daoRapportVisite.getOneMax();
        
        // On créé le rapport de visite dans la bdd
        daoRapportVisite.create(unRapportVisite);
        
        // On créé un nouvel objet rapport de visite
        RapportVisite unRapportVisiteCréé = new RapportVisite();
        // On récupère le dernier rapport de visite créé (c'est celui que l'utilisateur créé)
        unRapportVisiteCréé = daoRapportVisite.getOneMax();

        // On créé l'échantillon par rapport au rapport de visite créé
        int nbLigne = ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).getRowCount();
        int compteur = 0;
        while (compteur + 1 <= nbLigne) {
            EchantillonOffert unEchantillonOffert = new EchantillonOffert();
            unEchantillonOffert.setRapportVisite(unRapportVisiteCréé);
            unEchantillonOffert.setVisiteur(unRapportVisiteCréé.getVisiteur());
            unEchantillonOffert.setMedicament((Medicament) getVue().getjTableEchantillon().getValueAt(compteur, 0));
            unEchantillonOffert.setQuantite((Integer) getVue().getjTableEchantillon().getValueAt(compteur, 1));
            daoEchantillonOffert.create(unEchantillonOffert);
            compteur++;
        }

        // On vérifie que le rapport a bien été créé en comparant les objets rapports de visite avant et après la création
        if (unRapportVisiteCréé.getNumRapportVisite() > dernierRapportVisite.getNumRapportVisite()) {
            JOptionPane.showMessageDialog(null, "Le rapport de visite a été créé avec succès.", "Rapport créé !", JOptionPane.INFORMATION_MESSAGE);
            initialiserFenetre();
        } else {
            JOptionPane.showMessageDialog(null, "Erreur, le rapport de visite n'a pas été créé", "Erreur", JOptionPane.ERROR_MESSAGE);
            initialiserFenetre();
        }
    }

    // méthode qui permet de remplir le tableau des médicament pendant la création
    public void ChoixMedicament() throws Exception {

        lesMedicaments = daoMedicament.getAll();
        Medicament medicaments[] = new Medicament[lesMedicaments.size()];
        int i = 0;
        for (Medicament unMedicament : lesMedicaments) {
            medicaments[i] = unMedicament;
            i++;

        }

        JComboBox medicamentComboBox = new JComboBox(medicaments);
        JTextField quantiteJtextField = new JTextField();

        EchantillonOffert unEchantillon = new EchantillonOffert();

        int nbLigne = ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).getRowCount();
        boolean medoc = false;

        int reponse = JOptionPane.showConfirmDialog(null, new Object[]{medicamentComboBox, "Entrer une Quantité :", quantiteJtextField}, "Choix Médicament", JOptionPane.YES_NO_OPTION);
        unEchantillon.setMedicament((Medicament) medicamentComboBox.getSelectedItem());
        unEchantillon.setQuantite(Integer.parseInt(quantiteJtextField.getText()));
        if ((unEchantillon.getMedicament() != null) && (unEchantillon.getQuantite() > 0)) {
            medoc = true;
        }

        if (reponse == JOptionPane.YES_OPTION && medoc == true) {
            ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).setRowCount(nbLigne + 1);
            getVue().getjTableEchantillon().setValueAt(unEchantillon.getMedicament(), nbLigne, 0);
            getVue().getjTableEchantillon().setValueAt(unEchantillon.getQuantite(), nbLigne, 1);


        }



    }

    public void PreparationSaisieNouveauRapportVisite() {

        java.sql.Date date = java.sql.Date.valueOf("2000-01-01");
        getVue().getModeleJComboBoxVisiteur().setSelectedItem("Selectionnez svp");
        getVue().getModeleJComboBoxPraticien().setSelectedItem("Selectionnez svp");
        getVue().getjDateChooserDateRapport().setDate(date);
        getVue().getjTextFieldMotifVisite().setText("Saisir svp");
        getVue().getjTextAreaBilan().setText("Saisir svp");

        getVue().getjButtonPrecedent().setEnabled(false);
        getVue().getjButtonSuivant().setEnabled(false);
        getVue().getjButtonSaisieRapport().setVisible(false);
        getVue().getjButtonAjouterRapport().setVisible(true);
        getVue().getjButtonMedicament().setVisible(true);
        ((DefaultTableModel) getVue().getjTableEchantillon().getModel()).setRowCount(0);


    }

    public void Precedent() throws Exception {
        // On calcule la taille max de la liste déroulante
        int tailleMax = getVue().getjComboBoxNumeroRapport().getItemCount();
        // On calcule la taille de la liste déroulante jusqu'à l'item selectionné
        int tailleActuelle = getVue().getjComboBoxNumeroRapport().getSelectedIndex();
        if (tailleActuelle != 0) {
            int NumeroRapportPrecedent = getVue().getjComboBoxNumeroRapport().getSelectedIndex() - 1;
            getVue().getjComboBoxNumeroRapport().setSelectedIndex(NumeroRapportPrecedent);
        } else {
            // -1 car la liste commence à 0
            getVue().getjComboBoxNumeroRapport().setSelectedIndex(tailleMax - 1);
        }

        RapportVisite unRapportVisite = (RapportVisite) getVue().getModeleJComboBoxNumeroRapport().getSelectedItem();
        chargerInformationsRapportVisite(unRapportVisite);
    }

    public void Suivant() throws Exception {
        // On calcule la taille max de la liste déroulante (-1 car car ca commence à 0)
        int tailleMax = getVue().getjComboBoxNumeroRapport().getItemCount() - 1;
        // On calcule la taille de la liste déroulante jusqu'à l'item selectionné
        int tailleActuelle = getVue().getjComboBoxNumeroRapport().getSelectedIndex();
        if (tailleActuelle != tailleMax) {
            int RapportVisiteSuivant = getVue().getjComboBoxNumeroRapport().getSelectedIndex() + 1;
            getVue().getjComboBoxNumeroRapport().setSelectedIndex(RapportVisiteSuivant);
        } else {
            getVue().getjComboBoxNumeroRapport().setSelectedIndex(0);
        }

        RapportVisite unRapportVisite = (RapportVisite) getVue().getModeleJComboBoxNumeroRapport().getSelectedItem();
        chargerInformationsRapportVisite(unRapportVisite);

    }

    @Override
    public VueRapportVisite getVue() {
        return (VueRapportVisite) vue;
    }

    public void RapportVisiteAfficher() {
        String msg = "erreur"; // message à afficher en cas d'erreur
        // récupérer les valeurs saisies
        if (getVue() != null) {
        }


    }
}
