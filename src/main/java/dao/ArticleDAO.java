package dao;

import models.Article;

import java.sql.*;

/**
 * Classe qui Implémente L'interface commune ICommon pour l'article
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class ArticleDAO implements ICommon{
    private String url;
    private String username;
    private String password;
    private static Connection connection = null;

    /**
     * Constructeur avec paramètre pour créer une connection
     * @param url
     * @param username
     * @param password
     */
    public ArticleDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Permet de préparer la requête pour insérer un article
     * @param article
     */
    private void insererArticle(Article article) {
        try {
            System.out.println("Insertion effectuée...");
            String query = "INSERT INTO article (no_article, description, prix_unitaire, quantite_en_stock) values (?, ?, ?, ?)";
            PreparedStatement pr = connection.prepareStatement(query);

            pr.setInt(1,article.getNoArticle());
            pr.setString(2,article.getDescription());
            pr.setDouble(3,article.getPrixUnitaire());
            pr.setInt(4,article.getQuantite());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Préparer la requête qui va répondre à la question 3
     * @param article
     */
    private void selectQuestion3(Article article) {
        try {
            System.out.println("- Voici le résultat de la question 3 ! La description commence par C  \n");
            String query = "select no_article, description, prix_unitaire, quantite_en_stock from article \n" +
                    "where description like upper('C%');";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noArticle = resultSet.getInt(1);
                String description = resultSet.getString(2);
                int prixUnitaire = resultSet.getInt(3);
                int quantite = resultSet.getInt(4);
                System.out.printf("\nNuméro de l'article :%d, \nLa Description : %s\nLe prix unitaire : %d\nLa quantité : %s\n", noArticle, description, prixUnitaire, quantite);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Permet de Sauvegardé les donnée d'un article
     * @param objet qui est caster en Article
     */
    @Override
    public void saveDonnee(Object objet) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            insererArticle((Article) objet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de faire une requête dans la base donnée qui permet de répondre à la question 3
     * @param objet
     */
    @Override
    public void selectDonnee(Object objet) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            selectQuestion3((Article) objet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

