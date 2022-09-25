package com.tobias_ahlqvist.dungeonpetbackend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tobias_ahlqvist.helpers.DatabaseHelper;

public class DBmodel {

    // private Connection connection;
    private static String query_createPet = "INSERT INTO Pets(jsonobject) VALUES(?);";
    private static String query_assignOwner = "INSERT INTO PetOwners(pet_id, user_id) VALUES(?,?);";

    public DBmodel(Connection connection) {
    }

    /**
     */
    public static String savePet(String petJson, int userID) {

        String result = "{ \"result\" : \"success\" }";

        // Create a pet in pet table
        try (PreparedStatement sqlQuery = DatabaseHelper.connection.prepareStatement(query_createPet)) {
            sqlQuery.setString(1, petJson);

            System.out.println(sqlQuery);

            sqlQuery.executeUpdate();
            result = "{ \"result\" : \"success\" }";
        } catch (SQLException e) {
            System.out.println("Can't create pet");
            e.printStackTrace();
            result = "{ \"result\" : \"Create pet failed\" }";
        }

        // Set owner of pet
        // try (PreparedStatement sqlQuery = this.connection.prepareStatement(query_assignOwner)) {
        //     sqlQuery.setString(1, pet_id);
        //     sqlQuery.setString(2, user_id);
            
        //     System.out.println(sqlQuery);

        //     sqlQuery.executeUpdate();

        // } catch (SQLException e) {
        //     System.out.println("Can't create pet");
        //     e.printStackTrace();
        // }

        
        return result;
    }

}
