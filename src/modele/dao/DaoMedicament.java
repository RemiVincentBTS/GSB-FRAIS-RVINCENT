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
import modele.metier.Medicament;

/**
 *
 * @author btssio
 */
public class DaoMedicament implements DaoInterface<Medicament, String> {

    @Override
    public Medicament getOne(String numMedicament) throws Exception {
      

        Medicament result = new Medicament();

        String requete = "SELECT * FROM MEDICAMENT WHERE MED_DEPOTLEGAL = ?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, numMedicament);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = chargerUnMedicament(rs);

            }

        } catch (SQLException | DaoException ex) {
            throw new DaoException("DAO - getOneMedicament erreur : pb JDBC\n" + ex.getMessage());
        }

       
        return result;
    }

    @Override
    public ArrayList<Medicament> getAll() throws Exception {
       

        ArrayList<Medicament> result = new ArrayList<Medicament>();

        String requete = "SELECT * FROM MEDICAMENT";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicament medicament = chargerUnMedicament(rs);
                result.add(medicament);
            }

        } catch (SQLException | DaoException ex) {
            throw new DaoException("DAO - getListeMedicament pour un Medicament : pb JDBC\n" + ex.getMessage());
        }

       
        return result;
    }

    private Medicament chargerUnMedicament(ResultSet rs) throws DaoException {
        try {

            String numMedicament = rs.getString("MED_DEPOTLEGAL");
            String nomMedicament = rs.getString("MED_NOMCOMMERCIAL");

            Medicament unMedicament = new Medicament(numMedicament, nomMedicament);

            return unMedicament;

        } catch (SQLException ex) {
            throw new DaoException("DaoPresence - chargerUnPracticien : pb JDBC\n" + ex.getMessage());
        }

    }

    @Override
    public int create(Medicament objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String idMetier, Medicament objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
