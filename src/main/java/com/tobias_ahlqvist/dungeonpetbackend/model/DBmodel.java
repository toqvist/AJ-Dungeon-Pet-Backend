package com.tobias_ahlqvist.dungeonpetbackend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.tobias_ahlqvist.helpers.DatabaseHelper;

public class DBmodel {

    private static String query_createUser = "INSERT INTO Users(user_name, user_password, petJSON) VALUES(?,?,?)";
    private static String query_deleteUser = "";

    private static String query_updatePet = "UPDATE Users SET petJSON = ? WHERE(user_name = ?);";
    private static String query_loadPet = "SELECT petJSON FROM Users WHERE user_name = ?;";

    public static String createUser(String username, String password, String petJSON) {

        String result = "{ \"result\" : \"success\" }";

        try (PreparedStatement sqlQuery = DatabaseHelper.connection.prepareStatement(query_createUser)) {
            sqlQuery.setString(1, username);
            sqlQuery.setString(2, password);
            sqlQuery.setString(3, petJSON);

            System.out.println(sqlQuery);

            sqlQuery.executeUpdate();
            result = "{ \"result\" : \"success\" }";
        } catch (SQLException e) {
            System.out.println("Can't create user");
            e.printStackTrace();
            result = "{ \"result\" : \"failed\" }";
        }

        return result;
    }

    public static String savePet(String petJson, String username) {

        String result = "{ \"result\" : \"success\" }";

        // Create a pet in pet table
        try (PreparedStatement sqlQuery = DatabaseHelper.connection.prepareStatement(query_updatePet)) {
            sqlQuery.setString(1, petJson);
            sqlQuery.setString(2, username);

            System.out.println(sqlQuery);

            sqlQuery.executeUpdate();
            result = "{ \"result\" : \"success\" }";
        } catch (SQLException e) {
            System.out.println("Can't save pet");
            e.printStackTrace();
            result = "{ \"result\" : \"failed\" }";
        }
        return result;
    }

    public static String loadPet(String username) {

        String result;

        // Create a pet in pet table
        try (PreparedStatement sqlQuery = DatabaseHelper.connection.prepareStatement(query_loadPet)) {
            
            sqlQuery.setString(1, username);

            System.out.println(sqlQuery);

            ResultSet resultSet = sqlQuery.executeQuery();
            // System.out.println(resultSet);
            
            result = resultSet.getString("petJSON");
            // System.out.println(result);

            
        } catch (SQLException e) {

            System.out.println("Can't load pet");
            e.printStackTrace();
            result = "{ \"result\" : \"failed\" }";
        }
        return result;
    }

}
