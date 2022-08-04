package dao;

import models.Client;

import java.sql.*;
/**
 * Classe qui Implémente L'interface commune ICommon pour le client
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class ClientDAOImpl implements ICommon {
    private String url;
    private String username;
    private String password;
    private static Connection connection = null;

    /**
     * Constructeur avec paramèetre pour faire la connection
     * @param url
     * @param username
     * @param password
     */
    public ClientDAOImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Permet d'insérer un enregistrement dans la BD d'un client
     * @param client
     * @throws SQLException
     */
    public static void insererClient(Client client ) throws SQLException {
        System.out.println("Insertion effectuée...");
        String query = "INSERT INTO client (no_client, nom_client, no_telephone) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,client.getNoClient());
        statement.setString(2,client.getNomClient());
        statement.setString(3,client.getNoTelephone());
        statement.executeUpdate();
        statement.close();
    }

    /**
     * Permet de préparer la requête à effectuer pour la Question2
     * 2. Le noClient, noTéléphone du Client et noCommande pour les Commandes faites le 4/06/2000.
     * @param client
     * @throws SQLException
     */
    public static void selectQuestion2(Client client ) throws SQLException {
        try {
            System.out.println("\n- Voici le résultat de la question 2 ! modifié avec le 2/06/2000  \n");
            String query = "select c.no_client, c.no_telephone, d.no_commande, d.date_commande\n" +
                    "from client c JOIN commande d ON (c.no_client = d.no_client)\n" +
                    "where d.date_commande = str_to_date('2/06/2000','%d/%m/%Y');";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noClient = resultSet.getInt(1);
                String noTelephone = resultSet.getString(2);
                int noCommande = resultSet.getInt(3);
                String dateCommande = resultSet.getString(4);
                System.out.printf("\nNuméro du client :%d, \nLe numéro de téléphone : %s\nLe numéro de la commande : %d\nLa date de la commande : %s\n", noClient, noTelephone, noCommande, dateCommande);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de préparer la requête à effectuer pour la Question6
     * 6. Le noClient, noTéléphone des Clients sans aucune commande
     *
     * @param client
     * @throws SQLException
     */
    public static void selectQuestion6(Client client ) throws SQLException {
        try {
            System.out.println("\n- Voici le résultat de la question 6 ! Les client sans aucune commande  \n");
            /**
             * A corriger c'est toute les autre client sauf eux
             */
            // TODO: 2022-08-04 --------------------------------------------------------requete sql à modifier
            String query = "SELECT distinct(c.no_client), c.no_telephone \n" +
                    "FROM client c JOIN commande l ON (c.no_client = l.no_client)\n" +
                    "WHERE c.no_client IN (\n" +
                    "10,20,30,40\n" +
                    ");";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noClient = resultSet.getInt(1);
                String noTelephone = resultSet.getString(2);
                System.out.printf("\nNuméro du client :%d, \nLe numéro de téléphone : %s\n", noClient, noTelephone);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Sauvegardé la donné dans la base de donnée
     * @param objet qui est caster en client
     */
    @Override
    public void saveDonnee(Object objet) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            insererClient((Client) objet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Faire une requête dans la base de donnée
     * @param objet qui est caster en Client
     */
    @Override
    public void selectDonnee(Object objet) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            selectQuestion2((Client) objet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de faire une requête dans la base donnée qui permet de répondre à la question 6
     * on ajoute un compteur pour permettre le passe d'un paramètre qui nous redirigeration par la suite
     * @param objet
     * @param i
     */
    @Override
    public void selectDonnee(Object objet, int i) {
        if (i == 6){
            try {
                connection = DriverManager.getConnection(url, username, password);
                selectQuestion6((Client) objet);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}