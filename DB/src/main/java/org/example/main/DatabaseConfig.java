package org.example.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    private static final String URL = "jdbc:sqlite:/Users/paulbaier/School/SoftwareEngineering/db/Sakila";

    @Bean
    public Connection sqliteConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
