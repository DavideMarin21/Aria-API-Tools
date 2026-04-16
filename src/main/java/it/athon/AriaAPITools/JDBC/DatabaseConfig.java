package it.athon.AriaAPITools.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import it.athon.AriaAPITools.utils.ConfigLoader;

public class DatabaseConfig {

    private static ConfigLoader config = new ConfigLoader();

    private static final String url = config.getProperty("db.url");
    private static final String USER = config.getProperty("db.user");
    private static final String PASSWORD = config.getProperty("db.password");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,USER,PASSWORD);
    }
}

