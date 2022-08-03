package bd;

import java.sql.*;

public class Bd {
    public static Connection connection = null;
    public static PreparedStatement prepareStatement = null;
    public static String query = null;
    public static ResultSet resultSet = null;

    public static void seConnecter() throws SQLException {
        System.out.println("Connexion établie avec succès avec la bd MySQL ....\n");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vente", "root",
                "Lareaultlaval7");
    }

    public static void seDeconnecter() throws SQLException {
        System.out.println("\nFermeture de la connexion...");
        prepareStatement.close();
        connection.close();
    }

}
