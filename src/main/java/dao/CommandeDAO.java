package dao;

import models.Commande;

import java.sql.*;
/**
 * Classe qui Implémente L'interface commune ICommon pour a commande
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class CommandeDAO implements ICommon{
    private String url;
    private String username;
    private String password;
    private static Connection connection = null;

    /**
     * Constructeur avec paramètre pour faire la connection
     * @param url
     * @param username
     * @param password
     */
    public CommandeDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Permet d'insérer un enregistrement dans la BD d'une commande
     * @param commande
     * @throws SQLException
     */
    public static void insererCommande(Commande commande ) throws SQLException {
        try {
            System.out.println("Insertion effectuée...");
            String query = "INSERT INTO commande (no_commande, date_commande, no_client) values (?, ?, ?)";
            PreparedStatement pr = connection.prepareStatement(query);

            pr.setInt(1,commande.getNoCommande());
            pr.setString(2,commande.getDateCommande());
            pr.setInt(3,commande.getNoClient());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de préparer la requête à effectuer pour la Question1
     * @param commande
     * @throws SQLException
     */
    public static void selectQuestion1(Commande commande ) throws SQLException {
        try {
            System.out.println("- Voici le résultat de la question 1 ! modifié avec 3 au lieu de 5  \n");
            String query = "select no_commande, date_commande\n" +
                    "from commande\n" +
                    "where no_client = 10\n" +
                    "and no_commande > 3;";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noCommande = resultSet.getInt(1);
                String dateCommande = resultSet.getString(2);
                System.out.printf("Numéro de commande :%d, \nLa date de la commande : %s\n", noCommande, dateCommande);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Sauvegardé la donné dans la base de donnée
     * @param objet qui est caster en commande
     */
    @Override
    public void saveDonnee(Object objet) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            insererCommande((Commande) objet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Faire une requête dans la base de donnée pour la question 1
     * @param objet
     */
    @Override
    public void selectDonnee(Object objet) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            selectQuestion1((Commande) objet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
