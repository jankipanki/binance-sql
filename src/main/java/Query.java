import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {


    public static void executeQuery(String query) throws SQLException {
        Connection connection = null;

        try {
            connection = DbConnector.connect();
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            connection.close();
        }
    }
}