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
import modele.metier.Laboratoire;

/**
 *
 * @author btssio
 */
public class DaoLaboratoire implements DaoInterface<Laboratoire, String> {

    @Override
    public Laboratoire getOne(String lab_code) throws Exception {
       
                
        Laboratoire result = new Laboratoire();
        String requete = "SELECT * FROM LABO WHERE LAB_CODE = ?";

        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, lab_code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = chargerUnLaboratoire(rs);

            }

        } catch (SQLException | DaoException ex) {
            throw new DaoException("DaoLaboratoire - getOne erreur : pb JDBC\n" + ex.getMessage());
        }

    
        return result;
    }

    @Override
    public ArrayList<Laboratoire> getAll() throws Exception {
       

        ArrayList<Laboratoire> result = new ArrayList<Laboratoire>();

        String requete = "SELECT * FROM LABO";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Laboratoire laboratoire = chargerUnLaboratoire(rs);
                result.add(laboratoire);
            }

        } catch (SQLException | DaoException ex) {
            throw new DaoException("DaoLaboratoire - getAll : pb JDBC\n" + ex.getMessage());
        }
        
       
        return result;
    }

    private Laboratoire chargerUnLaboratoire(ResultSet rs) throws DaoException {
        try {

            String labCode = rs.getString("LAB_CODE");
            String labNom = rs.getString("LAB_NOM");
            String labChefVente = rs.getString("LAB_CHEFVENTE");
            Laboratoire unLaboratoire = new Laboratoire(labCode, labNom, labChefVente);

            return unLaboratoire;

        } catch (SQLException ex) {
            throw new DaoException("DaoLaboratoire - chargerUnLaboratoire : pb JDBC\n" + ex.getMessage());
        }

    }

    @Override
    public int create(Laboratoire objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String idMetier, Laboratoire objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
