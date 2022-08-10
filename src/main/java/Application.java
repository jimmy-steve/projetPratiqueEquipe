
import bd.MaConnection;
import dao.*;
import models.*;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        //------------------------------------------voici le singleTon pour la connection
        Connection connectionSingle = MaConnection.getInstance();
        //-----------------------------------------------------------------ajout d'un client

        Client client = new Client(91, "Michel Mambara", ("(450)582-2459"));
        ICommon iClientDao = new ClientDAOImpl(connectionSingle);
        iClientDao.saveDonnee(client);
        System.out.println(client);

        //------------------------------------------------------------------ajout d'un article

        Article article = new Article(100, "Vinagrier", 50.99, 25);
        ICommon iArticleDAO = new ArticleDAO(connectionSingle);
        iArticleDAO.saveDonnee(article);
        System.out.println(article);

        //-----------------------------------------------------------------------------ajout d'une commande

        Commande commande = new Commande(10, "2001-01-01", 40);
        ICommon iCommandeDao = new CommandeDAO(connectionSingle);
        iCommandeDao.saveDonnee(commande);
        System.out.println(commande);

        //-------------------------------------------------------------------------ajout d'une ligne de commande

        LigneCommande ligneCommande = new LigneCommande(10, 70, 12);
        ICommon iLigneCommandeDao = new LigneCommandeDAO(connectionSingle);
        iLigneCommandeDao.saveDonnee(ligneCommande);
        System.out.println(ligneCommande);

        //--------------------------------------------------------------------------ajout d'une ligne de livraison

        Livraison livraison = new Livraison(107, "2001-07-07");
        ICommon iLivraisonDao = new LivraisonDAO(connectionSingle);
        iLivraisonDao.saveDonnee(livraison);
        System.out.println(livraison);

        //-----------------------------------------------------------------------ajout d'une ligne de detail livraison


            DetailLivraison detailLivraison = new DetailLivraison(107, 1, 10, 3);
            ICommon iDetailLivraisonDao = new DetailLivraisonDAO(connectionSingle);
            iDetailLivraisonDao.saveDonnee(detailLivraison);
            System.out.println(detailLivraison);
        //-----------------------------------------------------------------------Select
        /**
         * Important pour compter les question et avoir la bonne sortie
         */
        int cpt = 0;
        //-----------------------------------------------------------------------Question1


        cpt = 1;
        Commande commandeQ1 = new Commande();
        ICommon iCommandDaoQ1 = new CommandeDAO(connectionSingle);
        iCommandDaoQ1.selectDonnee(commandeQ1);

        //-----------------------------------------------------------------------Question2
        cpt = 2;
        Client clientQ2 = new Client();
        ICommon iClientDaoQ2 = new ClientDAOImpl(connectionSingle);
        iClientDaoQ2.selectDonnee(clientQ2);
        //-----------------------------------------------------------------------Question3
        cpt = 3;
        Article articleQ3 = new Article();
        ICommon iArticleDaoQ3 = new ArticleDAO(connectionSingle);
        iArticleDaoQ3.selectDonnee(articleQ3);

        //-----------------------------------------------------------------------Question4
        cpt = 4;
        Article articleQ4 = new Article();
        ICommon iArticleDaoQ4 = new ArticleDAO(connectionSingle);
        iArticleDaoQ4.selectDonnee(articleQ4, cpt);

        //-----------------------------------------------------------------------Question5
        cpt = 5;
        Commande commandeQ5 = new Commande();
        ICommon iCommandDaoQ5 = new CommandeDAO(connectionSingle);
        iCommandDaoQ5.selectDonnee(commandeQ5, cpt);

        //-----------------------------------------------------------------------Question6
        cpt = 6;
        ICommon iClientDaoQ6 = new ClientDAOImpl(connectionSingle);
        Client clientQ6 = new Client();
        iClientDaoQ6.selectDonnee(clientQ6, cpt);

        //-----------------------------------------------------------------------Déconnexion


        MaConnection.seDeconnecter();


    }
}
