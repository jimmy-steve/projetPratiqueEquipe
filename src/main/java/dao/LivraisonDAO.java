package dao;

import models.Livraison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe de la livraison DAO
 * Permet de persister les données pour les livraisons
 * @author Francis Lafontaine,Erick Solis Bedon, Gabriel Gagnon
 * @since 9 aout 2022
 */
public class LivraisonDAO implements ICommon{
    private static Connection connection;

    /**
     * Constructeur avec une connection pour persister les données
     * @param connection
     */
    public LivraisonDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Permet d'insérer un enregistrement dans la BD d'une detail_commande
     * @param livraison
     * @throws SQLException
     */
    public static void insererLivraison(Livraison livraison ) throws SQLException {
        try {
            System.out.println("Insertion effectuée...");
            String query = "INSERT INTO livraison (no_livraison, date_livraison) values (?, ?)";
            PreparedStatement pr = connection.prepareStatement(query);

            pr.setInt(1,livraison.getNoLivraison());
            pr.setString(2,livraison.getDateLivraison());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Permet de Sauvegardé la donné dans la base de donnée
     * @param objet
     */
    @Override
    public void saveDonnee(Object objet) {
        try {
            insererLivraison((Livraison) objet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectDonnee(Object objet) {

    }

    @Override
    public void selectDonnee(Object objet, int i) {

    }
}
