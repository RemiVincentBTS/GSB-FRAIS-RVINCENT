package modele.dao;

import java.sql.*;
import java.util.ArrayList;
import modele.jdbc.Jdbc;
import modele.metier.Visiteurs;

//La classe DaoVisiteur :
//On crée une liste visiteurs
//Ensuite on éxecute la requete 
//Puis on met les résultats de la requête dans la liste
public class DaoVisiteur implements DaoInterface<Visiteurs, String> {

    @Override
    public Visiteurs getOne(String vis_matricule) throws Exception {
        
        
        Visiteurs result = new Visiteurs();

        String requete = "SELECT * FROM VISITEUR WHERE VIS_MATRICULE = ?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, vis_matricule);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = chargerUnVisiteur(rs);

            }

        } catch (Exception ex) {
            throw new DaoException("DAO - getOne pour un visiteur : pb JDBC\n" + ex.getMessage());
        }
        
       
        
        return result;
    }

    @Override
    public ArrayList<Visiteurs> getAll() throws Exception {
        Jdbc.getInstance().connecter();
        ArrayList<Visiteurs> result = new ArrayList<Visiteurs>();

        String requete = "SELECT * FROM VISITEUR";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Visiteurs visiteur = chargerUnVisiteur(rs);
                result.add(visiteur);
            }


        } catch (Exception ex) {
            throw new DaoException("DAO - getAll pour un visiteur : pb JDBC\n" + ex.getMessage());
        }
        
        return result;
    }

    private Visiteurs chargerUnVisiteur(ResultSet rs) throws DaoException, Exception {

        try {

            DaoSecteur daoSecteur = new DaoSecteur();
            DaoLaboratoire daoLaboratoire = new DaoLaboratoire();
            Visiteurs visiteur = new Visiteurs();
            visiteur.setMatricule(rs.getString("VIS_MATRICULE"));
            visiteur.setNom(rs.getString("VIS_NOM"));
            visiteur.setPrenom(rs.getString("Vis_PRENOM"));
            visiteur.setAdresse(rs.getString("VIS_ADRESSE"));
            visiteur.setCp(rs.getString("VIS_CP"));
            visiteur.setVille(rs.getString("VIS_VILLE"));
            visiteur.setDate_embauche(rs.getString("VIS_DATEEMBAUCHE"));
            visiteur.setSecteur(daoSecteur.getOne(rs.getString("SEC_CODE")));
            visiteur.setLaboratoire(daoLaboratoire.getOne(rs.getString("LAB_CODE")));

            return visiteur;

        } catch (SQLException ex) {
            throw new DaoException("DaoVisiteur - chargerUnVisiteur : pb JDBC\n" + ex.getMessage());
        }



    }

    @Override
    public int create(Visiteurs objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(String idMetier, Visiteurs objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
