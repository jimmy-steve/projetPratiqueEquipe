package dao;

import models.Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class ArticleDAO implements ICommon{
    private String url;
    private String username;
    private String password;
    private static Connection connection = null;

    public ArticleDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

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
}

