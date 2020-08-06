import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) throws SQLException {

        Connection db = DriverManager.getConnection("jdbc:postgresql://localhost/pokeMaven", "postgres", "password");
        System.out.println("connected");
    }
}
