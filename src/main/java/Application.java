import dao.ClientDAOImpl;
import dao.IClientDao;
import dao.ICommon;
import models.Client;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World !");

        String url = "jdbc:mysql://localhost:3306/vente";
        String username = "root";
        String password = "Lareaultlaval7";

        Client client = new Client(101,"Michel Mambara2", ("(450)582-2459"));

        IClientDao iClientDao = new ClientDAOImpl(url, username, password);
        //---------------sauvegarde dans la base de donnée
        iClientDao.saveClient(client);
        System.out.println(client);


        //System.out.println(iProductDao.getProductById(1L));
    }
}
