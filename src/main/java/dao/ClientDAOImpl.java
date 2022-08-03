package dao;

import bd.Bd;
import models.Client;

import java.sql.*;

public class ClientDAOImpl implements IClientDao {
    private String url;
    private String username;
    private String password;

    public ClientDAOImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static void insererClient(Client client ) throws SQLException {
        System.out.println("Insertion effectuée...");
        String query = "INSERT INTO client (no_client, nom_client, no_telephone) values (" + client.getNoClient()
                + ", '" + client.getNomClient() + "', '" + client.getNoTelephone() + "');";
        Bd.prepareStatement = Bd.connection.prepareStatement(query);
        Bd.prepareStatement.executeUpdate(query);
    }

    @Override
    public void saveClient(Client client) {
        try {

            Bd.seConnecter();
            insererClient(client);
            Bd.seDeconnecter();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
