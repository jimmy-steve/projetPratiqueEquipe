import bd.DbCon;
import dao.*;
import models.*;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        //-----------------------------------------------------------------ajout d'un client

        ICommon iClientDao = null;
        try {
            Client client = new Client(90,"Michel Mambara", ("(450)582-2459"));
            iClientDao = new ClientDAOImpl(DbCon.getConnection());
            iClientDao.saveDonnee(client);
            System.out.println(client);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //------------------------------------------------------------------ajout d'un article

        ICommon iArticleDAO = null;
        try {
            Article article = new Article(100, "Vinagrier", 50.99, 25);
            iArticleDAO = new ArticleDAO(DbCon.getConnection());
            iArticleDAO.saveDonnee(article);
            System.out.println(article);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //-----------------------------------------------------------------------------ajout d'une commande
        ICommon iCommandeDao = null;
        try{
            Commande commande = new Commande(10, "2001-01-01", 40);
            iCommandeDao = new CommandeDAO(DbCon.getConnection());
            iCommandeDao.saveDonnee(commande);
            System.out.println(commande);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //-------------------------------------------------------------------------ajout d'une ligne de commande
        ICommon iLigneCommandeDao =null;
        try{
            LigneCommande ligneCommande = new LigneCommande(10, 70, 12);
            iLigneCommandeDao = new LigneCommandeDAO(DbCon.getConnection());
            iLigneCommandeDao.saveDonnee(ligneCommande);
            System.out.println(ligneCommande);

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //--------------------------------------------------------------------------ajout d'une ligne de livraison
        ICommon iLivraisonDao =null;
        try{
            Livraison livraison = new Livraison(107, "2001-07-07");
            iLivraisonDao = new LivraisonDAO(DbCon.getConnection());
            iLivraisonDao.saveDonnee(livraison);
            System.out.println(livraison);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //-----------------------------------------------------------------------ajout d'une ligne de detail livraison
        ICommon iDetailLivraisonDao =null;
        try{
            DetailLivraison detailLivraison = new DetailLivraison(107, 1, 10, 3);
            iDetailLivraisonDao = new DetailLivraisonDAO(DbCon.getConnection());
            iDetailLivraisonDao.saveDonnee(detailLivraison);
            System.out.println(detailLivraison);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //-----------------------------------------------------------------------Select
        /**
         * Important pour compter les question et avoir la bonne sortie
         */
        int cpt = 0;
        //-----------------------------------------------------------------------Question1
        cpt = 1;
        ICommon iCommandDaoQ1 = null;
        try {
            Commande commandeQ1 = new Commande();
            iCommandDaoQ1 = new CommandeDAO(DbCon.getConnection());
            iCommandDaoQ1.selectDonnee(commandeQ1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //-----------------------------------------------------------------------Question2
        cpt = 2;
        ICommon iClientDaoQ2 = null;
        try {
            Client clientQ2 = new Client();
            iClientDaoQ2 = new ClientDAOImpl(DbCon.getConnection());
            iClientDaoQ2.selectDonnee(clientQ2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //-----------------------------------------------------------------------Question3
        cpt = 3;
        ICommon iArticleDaoQ3 = null;
        try {
            Article articleQ3 = new Article();
            iArticleDaoQ3 = new ArticleDAO(DbCon.getConnection());
            iArticleDaoQ3.selectDonnee(articleQ3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //-----------------------------------------------------------------------Question4
        cpt = 4;
        ICommon iArticleDaoQ4 = null;
        try {
            Article articleQ4 = new Article();
            iArticleDaoQ4 = new ArticleDAO(DbCon.getConnection());
            iArticleDaoQ4.selectDonnee(articleQ4, cpt);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //-----------------------------------------------------------------------Question5
        cpt= 5;

        ICommon iCommandDaoQ5 = null;
        try {
            Commande commandeQ5 = new Commande();
            iCommandDaoQ5 = new CommandeDAO(DbCon.getConnection());
            iCommandDaoQ5.selectDonnee(commandeQ5, cpt);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //-----------------------------------------------------------------------Question6
        cpt= 6;

        ICommon iClientDaoQ6 = null;
        try {
            iClientDaoQ6 = new ClientDAOImpl(DbCon.getConnection());
            Client clientQ6 = new Client();
            iClientDaoQ6.selectDonnee(clientQ6, cpt);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //-----------------------------------------------------------------------Déconnexion
        try {
            DbCon.seDeconnecter();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
