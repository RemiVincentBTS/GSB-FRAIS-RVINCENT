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
import modele.metier.EchantillonOffert;

/**
 *
 * @author btssio
 */
public class DaoEchantillonOffert implements DaoInterface<EchantillonOffert, String> {

    public EchantillonOffert getOneSpecial(int numRapportVisite, String numMedicament, String vis_matricule) throws Exception {
        
        EchantillonOffert result = new EchantillonOffert();

        String requete = "SELECT * FROM OFFRIR WHERE VIS_MATRICULE = ? AND RAP_NUM = ? AND MED_DEPOTLEGAL = ?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, vis_matricule);
            ps.setInt(2, numRapportVisite);
            ps.setString(3, numMedicament);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = chargerUnEchantillonOffert(rs);

            }

        } catch (Exception ex) {
            throw new DaoException("DAO - getOneSpecialEchantillonOffert erreur : pb JDBC\n" + ex.getMessage());
        }
        
       
        return result;
    }

    public ArrayList<EchantillonOffert> getAllSpecial(int numRapportVisite) throws Exception {  

        ArrayList<EchantillonOffert> result = new ArrayList<EchantillonOffert>();
        String requete = "SELECT * FROM OFFRIR WHERE RAP_NUM = ?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1, numRapportVisite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EchantillonOffert echantillonOffert = chargerUnEchantillonOffert(rs);
                result.add(echantillonOffert);
            }

        } catch (Exception ex) {
            throw new DaoException("DAO - getAll special pour un EchantillonOffert : pb JDBC\n" + ex.getMessage());
        }
        
       
        return result;
    }

    @Override
    public ArrayList<EchantillonOffert> getAll() throws Exception {
      

        ArrayList<EchantillonOffert> result = new ArrayList<EchantillonOffert>();

        String requete = "SELECT * FROM OFFRIR";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EchantillonOffert echantillonOffert = chargerUnEchantillonOffert(rs);
                result.add(echantillonOffert);
            }

        } catch (Exception ex) {
            throw new DaoException("DAO - getAll  pour un EchantillonOffert : pb JDBC\n" + ex.getMessage());
        }

       
        return result;
    }

    private EchantillonOffert chargerUnEchantillonOffert(ResultSet rs) throws DaoException, Exception {
        try {
            DaoVisiteur daoVisiteur = new DaoVisiteur();
            DaoRapportVisite daoRapportVisite = new DaoRapportVisite();
            DaoMedicament daoMedicament = new DaoMedicament();
            EchantillonOffert UnEchantillonOffert = new EchantillonOffert();
            UnEchantillonOffert.setVisiteur(daoVisiteur.getOne(rs.getString("VIS_MATRICULE")));
            UnEchantillonOffert.setRapportVisite(daoRapportVisite.getOne(rs.getString("RAP_NUM")));
            UnEchantillonOffert.setMedicament(daoMedicament.getOne(rs.getString("MED_DEPOTLEGAL")));
            UnEchantillonOffert.setQuantite(rs.getInt("OFF_QTE"));

            return UnEchantillonOffert;

        } catch (SQLException ex) {
            throw new DaoException("DaoEchantillonOffert - chargerUnEchantillonOffert : pb JDBC\n" + ex.getMessage());
        }

    }

    @Override
    public int create(EchantillonOffert unEchantillonOffert) throws Exception {
        
        
        String requete = "INSERT INTO OFFRIR (VIS_MATRICULE, RAP_NUM, MED_DEPOTLEGAL, OFF_QTE) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, unEchantillonOffert.getVisiteur().getMatricule());
            ps.setInt(2, unEchantillonOffert.getRapportVisite().getNumRapportVisite());
            ps.setString(3, unEchantillonOffert.getMedicament().getDepotLegalMedicament());
            ps.setInt(4, unEchantillonOffert.getQuantite());
            ps.executeQuery();

        } catch (Exception ex) {
            throw new DaoException("DAO - CREATE un Echantillon : pb JDBC\n" + ex.getMessage());
        }

        
        return 0;
    }

    @Override
    public int update(String idMetier, EchantillonOffert objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EchantillonOffert getOne(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
