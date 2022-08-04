import dao.ArticleDAO;
import dao.ClientDAOImpl;
import dao.ICommon;
import models.Article;
import models.Client;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World !");

        String url = "jdbc:mysql://localhost:3306/vente";
        String username = "root";
        String password = "Lareaultlaval7";

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


        //System.out.println(iProductDao.getProductById(1L));
    }
}
