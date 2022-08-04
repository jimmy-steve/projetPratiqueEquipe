package dao;

import models.Client;

import java.sql.*;
/**
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class ClientDAOImpl implements ICommon {
    private String url;
    private String username;
    private String password;
    private static Connection connection = null;

    public ClientDAOImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

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
}