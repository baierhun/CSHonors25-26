package org.example.main.commands;

import org.example.main.dao.ActorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.sql.*;
import java.util.ArrayList;

@ShellComponent
public class Commands {

    private final Connection connection;

    @Autowired
    public Commands(Connection connection) {
        this.connection = connection;
    }

    @ShellMethod("List all actors")
    public void listActors() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM actor");
        ResultSet rs = stmt.executeQuery();

        ArrayList<ActorDao> actors = new ArrayList<>();
        while (rs.next()) {
            actors.add(ActorDao.makeActor(rs));
            System.out.println(actors.getLast());
        }

        rs.close();
        stmt.close();
    }
}
