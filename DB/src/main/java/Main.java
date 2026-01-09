import java.sql.*;
import java.util.ArrayList;

class Actor {
    int id;
    String firstName;
    String lastName;

    public Actor(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Actor makeActor(ResultSet rs) throws SQLException {
        int id = rs.getInt("actor_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new Actor(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "%d: %s %s".formatted(this.id, this.firstName, this.lastName);
    }
}

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:/Users/paulbaier/School/SoftwareEngineering/db/Sakila";
        Connection conn = null;
        Statement stmt = null;
//        try (Connection conn = DriverManager.getConnection(url);
//             Statement stmt = conn.createStatement()) {
        try {
            System.out.println("Connected to SQLite!");

            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM actor");
            ArrayList<Actor> actors = new ArrayList<>();
            while (rs.next()) {
                actors.add(Actor.makeActor(rs));
                System.out.println(actors.getLast());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
}
