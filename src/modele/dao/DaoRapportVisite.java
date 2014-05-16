/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.jdbc.Jdbc;
import modele.metier.RapportVisite;

/**
 *
 * @author btssio
 */
public class DaoRapportVisite implements DaoInterface<RapportVisite, String> {

    @Override
    public RapportVisite getOne(String numRapport) throws Exception {
        

        RapportVisite result = new RapportVisite();

        String requete = "SELECT * FROM RAPPORT_VISITE WHERE RAP_NUM = ?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, numRapport);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = chargerUnRapportVisite(rs);

            }

        } catch (Exception ex) {
            throw new DaoException("DAO - getOneRapportVisite erreur : pb JDBC\n" + ex.getMessage());
        }

        
        return result;
    }

    public RapportVisite getOneMax() throws Exception {
        

        RapportVisite result = new RapportVisite();

        String requete = "SELECT * FROM RAPPORT_VISITE WHERE RAP_NUM = (SELECT MAX (RAP_NUM) FROM RAPPORT_VISITE)";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = chargerUnRapportVisite(rs);

            }

        } catch (Exception ex) {
            throw new DaoException("DAO - getOneRapportVisite erreur : pb JDBC\n" + ex.getMessage());
        }

       
        return result;
    }

    @Override
    public ArrayList<RapportVisite> getAll() throws Exception {
        

        ArrayList<RapportVisite> result = new ArrayList<RapportVisite>();

        String requete = "SELECT * FROM RAPPORT_VISITE";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RapportVisite rapportVisite = chargerUnRapportVisite(rs);
                result.add(rapportVisite);
            }

        } catch (Exception ex) {
            throw new DaoException("DAO - getListeRapportVisite pour un RapportVisite : pb JDBC\n" + ex.getMessage());
        }

        
        return result;
    }

    private RapportVisite chargerUnRapportVisite(ResultSet rs) throws DaoException, Exception {
        try {

            DaoVisiteur daoVisiteur = new DaoVisiteur();
            DaoPraticien daoPraticien = new DaoPraticien();

            RapportVisite unRapportVisite = new RapportVisite();
            unRapportVisite.setNumRapportVisite(rs.getInt("RAP_NUM"));
            unRapportVisite.setVisiteur(daoVisiteur.getOne(rs.getString("VIS_MATRICULE")));
            unRapportVisite.setPraticien(daoPraticien.getOne(rs.getString("PRA_NUM")));
            unRapportVisite.setDateRapportVisite(rs.getDate("RAP_DATE"));
            unRapportVisite.setBilanRapportVisite(rs.getString("RAP_BILAN"));
            unRapportVisite.setMotifRapportVisite(rs.getString("RAP_MOTIF"));


            return unRapportVisite;

        } catch (SQLException ex) {
            throw new DaoException("DaoPresence - chargerUnRapportVisite : pb JDBC\n" + ex.getMessage());
        }

    }

    @Override
    public int create(RapportVisite unRapportVisite) throws Exception {

        String requete = "INSERT INTO RAPPORT_VISITE (VIS_MATRICULE, PRA_NUM, RAP_DATE, RAP_BILAN, RAP_MOTIF) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, unRapportVisite.getVisiteur().getMatricule());
            ps.setString(2, unRapportVisite.getPraticien().getNumPraticien());
            ps.setDate(3, unRapportVisite.getDateRapportVisite());
            ps.setString(4, unRapportVisite.getBilanRapportVisite());
            ps.setString(5, unRapportVisite.getMotifRapportVisite());
            ps.executeQuery();


        } catch (Exception ex) {
            throw new DaoException("DAO - CREATE un RapportVisite : pb JDBC\n" + ex.getMessage());
        }

        
        return 0;
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String idMetier, RapportVisite objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
