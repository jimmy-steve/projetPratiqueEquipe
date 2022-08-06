import dao.ArticleDAO;
import dao.ClientDAOImpl;
import dao.CommandeDAO;
import dao.ICommon;
import models.*;

public class Application {
    public static void main(String[] args) {
        //----------------------------------------------------------------variable de connexion
        String url = "jdbc:mysql://localhost:3306/vente";
        String username = "root";
        String password = "Lareaultlaval7";

        //-----------------------------------------------------------------ajout d'un client

//        Client client = new Client(108,"Michel Mambara10", ("(450)582-2459"));
//        ICommon iClientDao = new ClientDAOImpl(url, username, password);
//        iClientDao.saveDonnee(client);
//        System.out.println(client);

        //------------------------------------------------------------------ajout d'un article
//        Article article = new Article(72, "allelluriaaaaaaa", 50.99, 25);
//        ICommon iArticleDAO = new ArticleDAO(url, username, password);
//        iArticleDAO.saveDonnee(article);
//        System.out.println(article);

        //-----------------------------------------------------------------------------ajout d'une commande
//        Commande commande = new Commande(10, "2001-01-01", 40);
//        ICommon iCommandeDao = new CommandeDAO(url, username, password);
//        iCommandeDao.saveDonnee(commande);
//        System.out.println(commande);

        //-------------------------------------------------------------------------ajout d'une ligne de commande
//        LigneCommande ligneCommande = new LigneCommande(10, 20, 40);
//        ICommon iLigneCommandeDao = new LigneCommandeDAO(url, username, password);
//        iLigneCommandeDao.saveDonnee(ligneCommande);
//        System.out.println(ligneCommande);
        //--------------------------------------------------------------------------ajout d'une ligne de livraison
//        Livraison livraison = new Livraison(107, "2001-07-07");
//        ICommon iLivraisonDao = new LivraisonDAO(url, username, password);
//        iLivraisonDao.saveDonnee(livraison);
//        System.out.println(livraison);

        //-----------------------------------------------------------------------ajout d'une ligne de detail livraison
//        DetailLivraison detailLivraison = new DetailLivraison(107, 10, 20, 40);
//
//        ICommon iDetail_livraisonDao = new DetailLivraisonDAO(url, username, password);
//        iDetail_livraisonDao.saveDonnee(detailLivraison);
//        System.out.println(detailLivraison);


        //-----------------------------------------------------------------------Select
        /**
         * Important pour compter les question et avoir la bonne sortie
         */
        int cpt = 0;
        //-----------------------------------------------------------------------Question1
        cpt = 1;
        Commande commandeQ1 = new Commande();
        ICommon iCommandDaoQ1 = new CommandeDAO(url, username, password);
        iCommandDaoQ1.selectDonnee(commandeQ1);

        //-----------------------------------------------------------------------Question2
        cpt = 2;
        Client clientQ2 = new Client();
        ICommon iClientDaoQ2 = new ClientDAOImpl(url, username, password);
        iClientDaoQ2.selectDonnee(clientQ2);

        //-----------------------------------------------------------------------Question3
        cpt = 3;
        Article articleQ3 = new Article();
        ICommon iArticleDaoQ3 = new ArticleDAO(url, username, password);
        iArticleDaoQ3.selectDonnee(articleQ3);

        //-----------------------------------------------------------------------Question4
        cpt = 4;
        Article articleQ4 = new Article();
        ICommon iArticleDaoQ4 = new ArticleDAO(url, username, password);
        iArticleDaoQ4.selectDonnee(articleQ4, cpt);

        //-----------------------------------------------------------------------Question5
        cpt= 5;
        Commande commandeQ5 = new Commande();
        ICommon iCommandDaoQ5 = new CommandeDAO(url, username, password);
        iCommandDaoQ5.selectDonnee(commandeQ5, cpt);

        //-----------------------------------------------------------------------Question6
        cpt= 6;
        Client clientQ6 = new Client();
        ICommon iClientDaoQ6 = new ClientDAOImpl(url, username, password);
        iClientDaoQ6.selectDonnee(clientQ6, cpt);
    }
}
