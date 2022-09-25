package com.tobias_ahlqvist.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    public static String driver = "jdbc";
    public static String dbType = "mysql";
    public static String server = "localhost";
    public static int port = 3306;

    public static Connection connection = null;

    public static void dbConnect(String database) {
        String connectionString = driver + ":" +
                dbType + "://" +
                server + ":" + port +
                "/" + database;

        try {
            connection = DriverManager.getConnection(connectionString, "root", "tobiastobias123");
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Connection to database failed.");
            e.printStackTrace();
        }
        
        // return connection;
    }

}
