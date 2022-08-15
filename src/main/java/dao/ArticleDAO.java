package dao;

import models.Article;

import java.sql.*;

/**
 * Classe qui Implémente L'interface commune ICommon pour l'article
 * Permet de persister les données pour les articles
 *
 * @author Francis Lafontaine,Erick Solis Bedon, Gabriel Gagnon
 * @since 04/aout/2022
 */
public class ArticleDAO implements ICommon {
    private static Connection connection;

    /**
     * Constructeur avec paramètre avec une connection
     *
     * @param connection
     */
    public ArticleDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Permet de préparer la requête pour insérer un article
     *
     * @param article
     */
    private void insererArticle(Article article) {
        try {
            System.out.println("Insertion effectuée...");
            String query = "INSERT INTO article (no_article, description, prix_unitaire, quantite_en_stock) values (?, ?, ?, ?)";
            PreparedStatement pr = connection.prepareStatement(query);

            pr.setInt(1, article.getNoArticle());
            pr.setString(2, article.getDescription());
            pr.setDouble(3, article.getPrixUnitaire());
            pr.setInt(4, article.getQuantite());
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Préparer la requête qui va répondre à la question 3
     * 3. Les Articles dont la description débute par la lettre « C ».
     *
     * @param article
     */
    private void selectQuestion3(Article article) {
        try {
            System.out.println("\n- Voici le résultat de la question 3 ! La description commence par C  \n");
            String query = "select no_article, description, prix_unitaire, quantite_en_stock from article \n" +
                    "where description like upper('C%');";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noArticle = resultSet.getInt(1);
                String description = resultSet.getString(2);
                int prixUnitaire = resultSet.getInt(3);
                int quantite = resultSet.getInt(4);
                System.out.printf("\nNuméro de l'article :%d \nLa Description : %s\nLe prix unitaire : %d\nLa quantité : %s\n", noArticle, description, prixUnitaire, quantite);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Permet de Préparer la requête qui va répondre à la question 4
     * 4. Les Articles dont le prix est supérieur à la moyenne.
     *
     * @param objet
     */
    private void selectQuestion4(Article objet) {
        try {
            System.out.println("\n- Voici le résultat de la question 4 ! Les Produit ayant le prix supérieur de la moyenne  \n");
            String query = "select no_article, description, prix_unitaire, quantite_en_stock\n" +
                    "        from article\n" +
                    "        where prix_unitaire > (select avg(prix_unitaire) from article);";

            PreparedStatement pr = connection.prepareStatement(query);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int noArticle = resultSet.getInt(1);
                String description = resultSet.getString(2);
                int prixUnitaire = resultSet.getInt(3);
                int quantite = resultSet.getInt(4);
                System.out.printf("\nNuméro de l'article :%d \nLa Description : %s\nLe prix unitaire : %d\nLa quantité : %s\n", noArticle, description, prixUnitaire, quantite);
            }
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permet de Sauvegardé les donnée d'un article
     *
     * @param objet qui est caster en Article
     */
    @Override
    public void saveDonnee(Object objet) {
        insererArticle((Article) objet);
    }

    /**
     * Permet de faire une requête dans la base donnée qui permet de répondre à la question 3
     *
     * @param objet
     */
    @Override
    public void selectDonnee(Object objet) {
        selectQuestion3((Article) objet);
    }

    /**
     * Permet de faire une requête dans la base donnée qui permet de répondre à la question 4
     * on ajoute un compteur pour permettre le passe d'un paramètre qui nous redirigeration par la suite
     *
     * @param objet qui sera caster en article
     * @param i     un compteur
     */
    @Override
    public void selectDonnee(Object objet, int i) {
        if (i == 4) {
            selectQuestion4((Article) objet);
        }
    }
}

