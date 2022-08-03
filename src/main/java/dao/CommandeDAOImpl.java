package dao;

import bd.Bd;
import models.Commande;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommandeDAOImpl implements ICommandeDAO{

    private String url;
    private String username;
    private String password;

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
