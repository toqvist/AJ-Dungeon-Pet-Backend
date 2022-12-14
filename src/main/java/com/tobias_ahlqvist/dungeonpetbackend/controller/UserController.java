package com.tobias_ahlqvist.dungeonpetbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tobias_ahlqvist.dungeonpetbackend.model.DBmodel;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.MediaType;

@RestController
public class UserController {

    @CrossOrigin
    @RequestMapping (
        value = "/createUser", 
        method = RequestMethod.POST, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void createUser(@RequestBody String username, String password, String petJSON) {
        
        String returnJSON =  DBmodel.createUser(username, password, petJSON);
        
    }

    @CrossOrigin
    @RequestMapping (
        value = "/login", 
        method = RequestMethod.POST, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String login(@RequestBody String username, String password) {
        //Get first JSON object,
        
        // loginCreds[0].username
        // loginCreds[0].password
        //DBmodel.login(); 

        return DBmodel.login(username, password);
    }

    @CrossOrigin
    @RequestMapping (
        value = "/save", 
        method = RequestMethod.POST, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String save(@RequestBody String inputJSON) {
        String placeholderUsername = "admin";
        //For testing purposes, userID is 1
        String returnJSON =  DBmodel.savePet(inputJSON, placeholderUsername);
        return returnJSON;
    }

    @CrossOrigin
    @RequestMapping (
        value = "/load", 
        method = RequestMethod.POST, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String load(@RequestBody String inputUsername) {
        //PlaceholderPet php = new PlaceholderPet();
        String placeholderUsername = "admin";
        String json =  DBmodel.loadPet(placeholderUsername);
        return json;
        
    }

    // @CrossOrigin
    // @RequestMapping (
    //     value = "/test", 
    //     method = RequestMethod.POST, 
    //     produces = MediaType.APPLICATION_JSON_VALUE
    // )
    // public String test(@RequestBody String inputJSON) {
    //     System.out.println(inputJSON);

    //     String returnJSON = inputJSON;
    //     return returnJSON;
    // }
}
