package dao;

import models.Commande;

import java.sql.*;

/**
 * Classe qui Implémente L'interface commune ICommon pour a commande
 *
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class CommandeDAO implements ICommon {

    private static Connection connection;

    public CommandeDAO(Connection connection) {
        this.connection = connection;
    }

//    private String url;
//    private String username;
//    private String password;
//    private static Connection connection = null;
//
//    /**
//     * Constructeur avec paramètre pour faire la connection
//     *
//     * @param url
//     * @param username
//     * @param password
//     */
//    public CommandeDAO(String url, String username, String password) {
//        this.url = url;
//        this.username = username;
//        this.password = password;
//    }

    /**
     * Permet d'insérer un enregistrement dans la BD d'une commande
     *
     * @param commande
     * @throws SQLException
     */
    public static void insererCommande(Commande commande) throws SQLException {
        try {
            System.out.println("Insertion effectuée...");
            String query = "INSERT INTO commande (no_commande, date_commande, no_client) values (?, ?, ?)";
            PreparedStatement pr = connection.prepareStatement(query);

            pr.setInt(1, commande.getNoCommande());
            pr.setString(2, commande.getDateCommande());
            pr.setInt(3, commande.getNoClient());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de préparer la requête à effectuer pour la Question1
     * 1. noCommande et dateCommande des Commandes du Client #10 dont le noCommande est supérieur à 5.
     *
     * @param commande
     * @throws SQLException
     */
    public static void selectQuestion1(Commande commande) throws SQLException {
        try {
            System.out.println("\n- Voici le résultat de la question 1 ! modifié avec 3 au lieu de 5  \n");
            String query = "select no_commande, date_commande\n" +
                    "from commande\n" +
                    "where no_client = 10\n" +
                    "and no_commande > 3;";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noCommande = resultSet.getInt(1);
                String dateCommande = resultSet.getString(2);
                System.out.printf("\nNuméro de commande :%d \nLa date de la commande : %s\n", noCommande, dateCommande);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de préparer la requête à effectuer pour la Question5
     * 5. La liste des noCommande avec les noLivraisons associées, et ce, incluant aussi les noCommandes sans
     * livraison.
     *
     * @param commande
     * @throws SQLException
     */
    public static void selectQuestion5(Commande commande) throws SQLException {
        try {
            System.out.println("\n- Voici le résultat de la question 5 ! La liste des noCommande avec noLivraison \n ");
            String query = "select c.no_commande,liv.no_livraison\n" +
                    "from commande c JOIN ligne_commande l ON (c.no_commande = l.no_commande)\n" +
                    "\t\t\t\tJOIN detail_livraison d ON (l.no_commande = d.no_commande)\n" +
                    "                JOIN livraison liv ON (d.no_livraison = liv.no_livraison)             \n" +
                    "group by c.no_commande ;";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noCommande = resultSet.getInt(1);
                int noLivraison = resultSet.getInt(2);
                System.out.printf("\nNuméro de commande :%d \nLe numéro de livraison : %s\n", noCommande, noLivraison);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Sauvegardé la donné dans la base de donnée
     *
     * @param objet qui est caster en commande
     */
    @Override
    public void saveDonnee(Object objet) {
        try {
            insererCommande((Commande) objet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Faire une requête dans la base de donnée pour la question 1
     *
     * @param objet
     */
    @Override
    public void selectDonnee(Object objet) {
        try {
            selectQuestion1((Commande) objet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectDonnee(Object objet, int i) {
        if (i == 5) {
            try {
                selectQuestion5((Commande) objet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
