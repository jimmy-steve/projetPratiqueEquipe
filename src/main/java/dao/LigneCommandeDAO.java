package dao;

import models.LigneCommande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe Ligne CommandeDAO
 * Permet de persister les données pour les lignes de commandes
 * @author Francis Lafontaine
 */
public class LigneCommandeDAO implements ICommon{
    private static Connection connection;

    /**
     * Constructeur avec une connection pour persister les données
     * @param connection
     */
    public LigneCommandeDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     *  Permet d'insérer un enregistrement dans la BD d'une ligne commande
     * @param ligneCommande
     * @throws SQLException
     */
    public static void insererLigneCommande(LigneCommande ligneCommande ) throws SQLException {
        try {
            System.out.println("Insertion effectuée...");
            String query = "INSERT INTO ligne_commande (no_commande, no_article, quantite) values (?, ?, ?)";
            PreparedStatement pr = connection.prepareStatement(query);

            pr.setInt(1,ligneCommande.getNoCommande());
            pr.setInt(2,ligneCommande.getNoArticle());
            pr.setInt(3,ligneCommande.getQuantite());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Sauvegardé la donné dans la base de donnée
     * @param objet
     */
    @Override
    public void saveDonnee(Object objet) {
        try {
            insererLigneCommande((LigneCommande) objet);
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
