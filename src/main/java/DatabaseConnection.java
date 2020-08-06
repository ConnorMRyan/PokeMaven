import java.sql.*;

public class DatabaseConnection {
    Connection db;

    DatabaseConnection() {
        try {
            this.db = DriverManager.getConnection("jdbc:postgresql://localhost/pokeMaven", "postgres", "password");
        } catch (Exception e) {
            System.err.println("Could not connect!");
        }
    }

    public Monster makeAMonster(int pokemonID, int level, String name) throws SQLException {
        String query = "SELECT * FROM pokemon where number = " + pokemonID;
        return getMonster(level, query, name);
    }

    public Monster makeAMonster(int pokemonID, int level) throws SQLException {
        String query = "SELECT * FROM pokemon where number = " + pokemonID;
        return getMonster(level, query);
    }

    public Monster makeAMonster(String pokemonName, int level, String name) throws SQLException {
        String query = "SELECT * FROM pokemon WHERE pokemon.name = " + "'" + pokemonName + "'";
        return getMonster(level, query, name);
    }

    public Monster makeAMonster(String pokemonName, int level) throws SQLException {
        String query = "SELECT * FROM pokemon WHERE pokemon.name = " + "'" + pokemonName + "'";
        return getMonster(level, query);
    }

    private Monster getMonster(int level, String query, String name) throws SQLException {
        Statement stmt = db.createStatement();
        ResultSet results = stmt.executeQuery(query);
        results.next();
        return new Monster(results.getInt("HP"), results.getInt("Attack"),
                results.getInt("Defense"), results.getInt("Special"),
                results.getInt("Speed"), results.getInt("typeOne"),
                results.getInt("typeTwo"), level, name, results.getString("name"));
    }

    private Monster getMonster(int level, String query) throws SQLException {
        Statement stmt = db.createStatement();
        ResultSet results = stmt.executeQuery(query);
        results.next();
        return new Monster(results.getInt("HP"), results.getInt("Attack"),
                results.getInt("Defense"), results.getInt("Special"),
                results.getInt("Speed"), results.getInt("typeOne"),
                results.getInt("typeTwo"), level, results.getString("name"));
    }

}

