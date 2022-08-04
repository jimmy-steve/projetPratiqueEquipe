package dao;

import bd.Bd;
import models.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandeDAOImpl implements ICommandeDAO{

    private String url;
    private String username;
    private String password;
    private static Connection connection = null;

    public void insererCommande(Commande commande){
        try {
            System.out.println("Insertion de noCommande " + commande.getNoCommande());
            String query = "INSERT INTO commande (no_commande, date_commande, no_client) values (commande.getNoCommande(), " +
                    "commande.getDateCommande(),commande.getNoClient()";
            Bd.prepareStatement = Bd.connection.prepareStatement(query);
            Bd.prepareStatement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Impossible de realiser l'insertion de la commande " + commande.getNoCommande());
        }


    }
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

    @Override
    public Commande getCommandeById(int noCommande) {
        try {
            Bd.seConnecter();
            String query = "SELECT * FROM commande WHERE id = ?";
            Bd.prepareStatement = Bd.connection.prepareStatement(query);
            Bd.prepareStatement.setInt(1,noCommande);
            Bd.resultSet = Bd.prepareStatement.executeQuery();
            Commande commande = new Commande();

            while(Bd.resultSet.next()){
                commande.setNoCommande(Bd.resultSet.getInt("no_commande"));
                commande.setDateCommande(Bd.resultSet.getString("date_commande"));
                commande.setNoClient(Bd.resultSet.getInt("no_client"));
            }
            Bd.seDeconnecter();
            return commande;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveCommande(Commande commande) {
        try {
            Bd.seConnecter();
            insererCommande(commande);
            Bd.seDeconnecter();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
