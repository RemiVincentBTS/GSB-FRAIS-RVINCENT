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
import modele.metier.Praticien;

/**
 *
 * @author btssio
 */
public class DaoPraticien implements DaoInterface<Praticien, String> {

    @Override
    public Praticien getOne(String numPraticien) throws Exception {
       
        Praticien result = new Praticien();

        String requete = "SELECT * FROM PRATICIEN WHERE PRA_NUM = ?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, numPraticien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = chargerUnPraticien(rs);

            }

        } catch (SQLException | DaoException ex) {
            throw new DaoException("DAO - getOnePraticien erreur : pb JDBC\n" + ex.getMessage());
        }

     
        return result;
    }

    @Override
    public ArrayList<Praticien> getAll() throws Exception {
        

        ArrayList<Praticien> result = new ArrayList<Praticien>();

        String requete = "SELECT * FROM PRATICIEN";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Praticien praticien = chargerUnPraticien(rs);
                result.add(praticien);
            }

        } catch (SQLException | DaoException ex) {
            throw new DaoException("DAO - getListePraticien pour un praticien : pb JDBC\n" + ex.getMessage());
        }

       
        return result;
    }

    private Praticien chargerUnPraticien(ResultSet rs) throws DaoException {
        try {

            String numPraticien = rs.getString("PRA_NUM");
            String nomPraticien = rs.getString("PRA_NOM");
            String prenomPraticien = rs.getString("PRA_PRENOM");
            String adressePraticien = rs.getString("PRA_ADRESSE");
            String villePraticien = rs.getString("PRA_VILLE");
            Praticien unPraticien = new Praticien(numPraticien, nomPraticien, prenomPraticien, adressePraticien, villePraticien);

            return unPraticien;

        } catch (SQLException ex) {
            throw new DaoException("DaoPraticien - chargerUnPraticien : pb JDBC\n" + ex.getMessage());
        }

    }

    @Override
    public int create(Praticien objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String idMetier, Praticien objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
