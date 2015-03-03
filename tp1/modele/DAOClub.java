/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import connexion.ConfigDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 1495567
 */
public class DAOClub {

    ResultSet rset = null;
    Connection con = null;
    PreparedStatement stmt = null;

    public DAOClub() {
    }

    //Méthode pour la connéxion à la base de données 
    public void connexion(String infoconnexion) {

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            con = ConfigDB.getConnection(infoconnexion);

        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        } catch (SQLException e) {
        }
    }

    //Méthode pour inserer les données 
    public void ExecuteSQL(String requete, int codeMembre, String nom, String prenom, String adresse,
            String statut, double revenueAnnuel) throws SQLException {

        stmt = con.prepareStatement(requete);

        stmt.setInt(1, codeMembre);
        stmt.setString(2, nom);
        stmt.setString(3, prenom);
        stmt.setString(4, adresse);
        stmt.setString(5, statut);
        stmt.setDouble(6, revenueAnnuel);

        stmt.executeUpdate();

    }

    //Méthode pour effacer des registre de la base des données 
    public void ExecuteDelete(String requete, int code) {

        try {

            stmt = con.prepareStatement(requete);

            stmt.setInt(1, code);
            stmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    //méthode pour executer un simple SECLECT
    public void executeSelect(String select) {
        try {

            stmt = con.prepareStatement(select);
            rset = stmt.executeQuery();

        } catch (SQLException e) {
        }

    }

    //Méthode pour registre l'information dans une liste
    public void enregistrerMembre() {

        try {

            while (rset.next()) {

                Registre.ajouterMembre(new Client(rset.getInt(1), rset.getString(2), rset.getString(3),
                        rset.getString(4), rset.getString(5), rset.getDouble(6)));
            }
        } catch (SQLException e) {
        }
    }

    //Mérthode pour la fermeture de la base de données 
    public void fermeture() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
        }

    }
}
