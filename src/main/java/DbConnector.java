import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static String URL = "jdbc:mysql://localhost:3306/binance";
    public static String USER = "root";
    public static String PASSWORD = "admin";

    public static Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("Połączono");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
