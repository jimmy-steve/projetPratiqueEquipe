package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Nom de la classe : Maconnection
 *
 * @author Francis Lafontaine
 * @since 10 aout 2022
 */
public class MaConnection {
    private String url = "jdbc:mysql://localhost:3306/vente";
    private String username = "root";
    private String password = "Lareaultlaval7";

    private static Connection connect;

    /**
     * Constructeur de la connection
     */
    private MaConnection() {
        try {
            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Permet de getter la connection
     *
     * @return
     */
    public static Connection getInstance() {
        if (connect == null) {
            new MaConnection();
        }
        return connect;
    }

    /**
     * Permet de se déconnecter
     */
    public static void seDeconnecter() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\nDéconnexion...\n");
    }

}
