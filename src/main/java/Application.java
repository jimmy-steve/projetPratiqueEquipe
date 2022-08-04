import dao.ArticleDAO;
import dao.ClientDAOImpl;
import dao.CommandeDAO;
import dao.ICommon;
import models.Article;
import models.Client;
import models.Commande;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World !");

        String url = "jdbc:mysql://localhost:3306/vente";
        String username = "root";
        String password = "MotdePasse";

        //-----------------------------------------------------------------ajout d'un client

//        Client client = new Client(109,"Michel Mambara11", ("(450)582-2459"));
//        ICommon iClientDao = new ClientDAOImpl(url, username, password);
//        iClientDao.saveDonnee(client);
//        System.out.println(client);

        //------------------------------------------------------------------ajout d'un article
//        Article article = new Article(73, "allelluribbbbb", 50.99, 25);
//        ICommon iArticleDAO = new ArticleDAO(url, username, password);
//        iArticleDAO.saveDonnee(article);
//        System.out.println(article);

        //-------------------------------------------------------------------ajout d'une commande
//        Commande commande = new Commande(11, "2001-01-01", 40);
//        ICommon iCommandeDao = new CommandeDAO(url, username, password);
//        iCommandeDao.saveDonnee(commande);
//        System.out.println(commande);




        //-----------------------------------------------------------------------Select
        /**
         * Important pour compter les question et avoir la bonne sortie
         */
        int cpt = 0;
        //-----------------------------------------------------------------------Question1
        cpt = 1;
        Commande commande = new Commande();
        ICommon iCommandDao = new CommandeDAO(url, username, password);
        iCommandDao.selectDonnee(commande);

        //-----------------------------------------------------------------------Question2
        cpt = 2;
        Client client = new Client();
        ICommon iClientDao = new ClientDAOImpl(url, username, password);
        iClientDao.selectDonnee(client);

        //-----------------------------------------------------------------------Question3
        cpt = 3;
        Article article = new Article();
        ICommon iArticleDao = new ArticleDAO(url, username, password);
        iArticleDao.selectDonnee(article);

        //-----------------------------------------------------------------------Question4
        cpt = 4;
        Article article4 = new Article();
        ICommon iArticleDao4 = new ArticleDAO(url, username, password);
        iArticleDao4.selectDonnee(article4, cpt);

        //-----------------------------------------------------------------------Question5
        cpt= 5;
        Commande commande5 = new Commande();
        ICommon iCommandDao5 = new CommandeDAO(url, username, password);
        iCommandDao5.selectDonnee(commande5, cpt);

        //-----------------------------------------------------------------------Question6
        // TODO: 2022-08-04 requete sql à modifier
        cpt= 6;
        Client client6 = new Client();
        ICommon iClientDao6 = new ClientDAOImpl(url, username, password);
        iClientDao6.selectDonnee(client6, cpt);//------------------------------------requete sql a modifier

        //System.out.println(iProductDao.getProductById(1L));
    }
}
