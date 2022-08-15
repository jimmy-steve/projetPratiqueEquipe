package dao;

import models.DetailLivraison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe qui Implémente L'interface commune ICommon pour a detail livraison
 * Permet de persister les données pour les details Livraisons
 *
 * @author Francis Lafontaine,Erick Solis Bedon, Gabriel Gagnon
 * @since 09/aout/2022
 */
public class DetailLivraisonDAO implements ICommon {
    private static Connection connection;

    /**
     * Constructeur avec une connection pour persister les données
     *
     * @param connection
     */
    public DetailLivraisonDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Permet de Sauvegardé la donné dans la base de donnée
     *
     * @param objet
     */
    @Override
    public void saveDonnee(Object objet) {
        insererDetailLivraison((DetailLivraison) objet);
    }

    @Override
    public void selectDonnee(Object objet) {

    }

    @Override
    public void selectDonnee(Object objet, int i) {

    }

    /**
     * Permet d'insérer un enregistrement dans la BD d'une detail_commande
     *
     * @param detailLivraison
     */
    private void insererDetailLivraison(DetailLivraison detailLivraison) {
        try {
            System.out.println("Insertion effectuée...");
            String query = "INSERT INTO detail_livraison (no_livraison, no_commande, no_article, quantite_livrer) values (?, ?, ?, ?)";
            PreparedStatement pr = connection.prepareStatement(query);

            pr.setInt(1, detailLivraison.getNoLivraison());
            pr.setInt(2, detailLivraison.getNoCommande());
            pr.setInt(3, detailLivraison.getNoArticle());
            pr.setInt(4, detailLivraison.getQuantiteLivree());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}