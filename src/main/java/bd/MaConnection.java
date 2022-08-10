package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnection {
    private String url = "jdbc:mysql://localhost:3306/vente";
    private String username = "root";
    private String password = "Lareaultlaval7";

    private static Connection connect;

    private MaConnection() {
        try {
            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getInstance() {
        if (connect == null) {
            new MaConnection();
        }


        return connect;
    }
    public static void seDeconnecter() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\nDéconnexion...\n");
    }

}
