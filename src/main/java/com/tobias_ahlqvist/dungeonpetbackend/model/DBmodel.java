package com.tobias_ahlqvist.dungeonpetbackend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.tobias_ahlqvist.helpers.DatabaseHelper;

public class DBmodel {

    //public String placeholderPet = "{\"type\":\"shroomy\",\"age\":\"baby\",\"isAlive\":true,\"name\":\"\",\"food\":5,\"maxFood\":10,\"foodDecay\":1,\"foodDecayRate\":60,\"fun\":4,\"maxFun\":10,\"funDecay\":1,\"funDecayRate\":30,\"decayRate\":10,\"growthRate\":900,\"emotion\":\"okay\",\"idle\":\"/Dungeon-Pet/src/sprites/shroomy/1_shroomy_idle.svg\",\"run\":\"/Dungeon-Pet/src/sprites/shroomy/1_shroomy_run.svg\",\"animProps\":{\"height\":32,\"width\":32,\"frameCount\":4,\"fps\":6},\"doing\":\"idle\",\"activeSprite\":\"/Dungeon-Pet/src/sprites/shroomy/1_shroomy_idle.svg\",\"speed\":10,\"secondsAlive\":942}";

    private static String query_createUser = "INSERT INTO Users(user_name, user_password, petJSON) VALUES(?,?,?)";
    private static String query_deleteUser = "DELETE FROM Users WHERE (user_name = ?);";
    private static String query_selectUser = "SELECT user_name FROM Users WHERE (user_name = ? AND user_password = ?)";

    private static String query_updatePet = "UPDATE Users SET petJSON = ? WHERE(user_name = ?);";
    private static String query_loadPet = "SELECT petJSON FROM Users WHERE user_name = ?;";

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

        String result = "";

        // Create a pet in pet table
        try (PreparedStatement sqlQuery = DatabaseHelper.connection.prepareStatement(query_loadPet)) {
            
            sqlQuery.setString(1, username);

            System.out.println(sqlQuery);

            ResultSet resultSet = sqlQuery.executeQuery();

            while (resultSet.next()) {
                result += resultSet.getString("petJSON");
            }
            
        } catch (SQLException e) {

            System.out.println("Can't load pet");
            e.printStackTrace();
            result = "{ \"result\" : \"failed\" }";
        }
        return result;
    }

    public static String createUser (String username, String password, String petJSON) {

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

    public static String createUser (String username) {

        String result = "{ \"result\" : \"failed\" }";

        try (PreparedStatement sqlQuery = DatabaseHelper.connection.prepareStatement(query_deleteUser)) {
            sqlQuery.setString(1, username);

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

    public static String login (String username, String password) {

        String result = "{ \"result\" : \"success\" }";

        try (PreparedStatement sqlQuery = DatabaseHelper.connection.prepareStatement(query_selectUser)) {
            sqlQuery.setString(1, username);
            sqlQuery.setString(2, password);

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

}
