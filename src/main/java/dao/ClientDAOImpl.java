package dao;

import models.Client;

import java.sql.*;
import java.util.ArrayList;

/**
 * Classe qui Implémente L'interface commune ICommon pour le client
 * Permet de persister les données pour les clients
 *
 * @author Francis Lafontaine,Erick Solis Bedon, Gabriel Gagnon
 * @since 04/aout/2022
 */
public class ClientDAOImpl implements ICommon {
    private static Connection connection;

    private static ArrayList<Client> listeClients = new ArrayList<>();
    private Client client = null;

    /**
     * Constructeur avec une connection pour persister les données
     *
     * @param connection
     */
    public ClientDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Permet d'insérer un enregistrement dans la BD d'un client
     *
     * @param client
     * @throws SQLException
     */
    public static void insererClient(Client client) throws SQLException {
        System.out.println("Insertion effectuée...");
        String query = "INSERT INTO client (no_client, nom_client, no_telephone) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, client.getNoClient());
        statement.setString(2, client.getNomClient());
        statement.setString(3, client.getNoTelephone());
        statement.executeUpdate();
        statement.close();
    }

    /**
     * Permet de préparer la requête à effectuer pour la Question2
     * 2. Le noClient, noTéléphone du Client et noCommande pour les Commandes faites le 4/06/2000.
     *
     * @param client
     * @throws SQLException
     */
    public static void selectQuestion2(Client client) throws SQLException {
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
     * Fonction qui permet de préparer la requête pour l'affichage de tous les client
     *
     * @param client
     * @return une ArrayList de client
     * @throws SQLException
     */
    public static ArrayList<Client> afficherListeClient(Client client) throws SQLException {
        try {
            System.out.println("\n--------------------- Voici LA LISTE DE TOUS VOS CLIENT---------------\n");
            String query = "SELECT * FROM CLIENT;";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noClient = resultSet.getInt(1);
                String nomClient = resultSet.getString(2);
                String noTelephone = resultSet.getString(3);

                client = new Client(noClient, nomClient, noTelephone);

                listeClients.add(client);


                System.out.printf("\nNuméro du client :%d, \nLe nom du client : %s\nLe numéro de téléphone : %s\n", noClient, nomClient, noTelephone);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeClients;
    }

    /**
     * Permet de préparer la requête à effectuer pour la Question6
     * 6. Le noClient, noTéléphone des Clients sans aucune commande
     *
     * @param client
     * @throws SQLException
     */
    public static void selectQuestion6(Client client) throws SQLException {
        try {
            System.out.println("\n- Voici le résultat de la question 6 ! Les client sans aucune commande  \n");
            String query = "SELECT c1.no_client, c1.no_telephone\n" +
                    "FROM Client C1\n" +
                    "WHERE NOT EXISTS (SELECT *\n" +
                    "FROM Commande C2\n" +
                    "WHERE C1.no_client=C2.no_client);";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noClient = resultSet.getInt(1);
                String noTelephone = resultSet.getString(2);
                System.out.printf("\nNuméro du client :%d \nLe numéro de téléphone : %s\n", noClient, noTelephone);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Sauvegardé la donné dans la base de donnée
     *
     * @param objet qui est caster en client
     */
    @Override
    public void saveDonnee(Object objet) {
        try {
            insererClient((Client) objet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Faire une requête dans la base de donnée
     *
     * @param objet qui est caster en Client
     */
    @Override
    public void selectDonnee(Object objet) {
        try {
            selectQuestion2((Client) objet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de faire une requête dans la base donnée qui permet de répondre à la question 6
     * on ajoute un compteur pour permettre le passe d'un paramètre qui nous redirigeration par la suite
     * Permet aussi de réponde a plsusieurs information pour afficher la lis de tous les clients
     *
     * @param objet
     * @param i
     */
    @Override
    public void selectDonnee(Object objet, int i) {
        if (i == 6) {
            try {
                selectQuestion6((Client) objet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (i == 7) {
            try {
                afficherListeClient((Client) objet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}