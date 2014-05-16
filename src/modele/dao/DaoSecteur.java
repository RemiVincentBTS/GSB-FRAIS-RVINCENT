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
import modele.metier.Secteur;

/**
 *
 * @author btssio
 */
public class DaoSecteur implements DaoInterface<Secteur, String> {

    @Override
    public Secteur getOne(String sec_code) throws Exception {
        
       
        Secteur result = new Secteur();

        String requete = "SELECT * FROM SECTEUR WHERE SEC_CODE = ?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, sec_code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = chargerUnSecteur(rs);

            }

        } catch (SQLException | DaoException ex) {
            throw new DaoException("DAO - getOneSecteur erreur : pb JDBC\n" + ex.getMessage());
        }
        
        
        return result;
    }

    @Override
    public ArrayList<Secteur> getAll() throws Exception {
        
     
        ArrayList<Secteur> result = new ArrayList<Secteur>();

        String requete = "SELECT * FROM SECTEUR";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Secteur secteur = chargerUnSecteur(rs);
                result.add(secteur);
            }

        } catch (SQLException | DaoException ex) {
            throw new DaoException("DAO - getListeVisiteurs pour un visiteur : pb JDBC\n" + ex.getMessage());
        }
        
        
        return result;
    }

    private Secteur chargerUnSecteur(ResultSet rs) throws DaoException {
        try {


            String codeSecteur = rs.getString("SEC_CODE");
            String libelleSecteur = (rs.getString("SEC_LIBELLE"));
            Secteur unSecteur = new Secteur(codeSecteur, libelleSecteur);

            return unSecteur;

        } catch (SQLException ex) {
            throw new DaoException("DaoSecteur - chargerUnSecteur : pb JDBC\n" + ex.getMessage());
        }

    }

    @Override
    public int create(Secteur objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String idMetier, Secteur objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
