package org.example.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorDao {
    int id;
    String firstName;
    String lastName;

    public ActorDao(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static ActorDao makeActor(ResultSet rs) throws SQLException {
        int id = rs.getInt("actor_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        return new ActorDao(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "%d: %s %s".formatted(this.id, this.firstName, this.lastName);
    }
}
