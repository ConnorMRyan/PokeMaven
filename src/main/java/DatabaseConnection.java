import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection db = DriverManager.getConnection("jdbc:postgresql://localhost/pokeMaven", "postgres", "password");
        } catch (Exception e) {
            System.err.println("Could not connect!");
        }
    }

}

