package com.tobias_ahlqvist.dungeonpetbackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tobias_ahlqvist.dungeonpetbackend.model.PlaceholderPet;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.MediaType;

@RestController
public class UserController {

    @CrossOrigin
    @RequestMapping (
        value = "/login", 
        method = RequestMethod.POST, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String login() {
        String returnJSON = "";
        return returnJSON;
    }

    @CrossOrigin
    @RequestMapping (
        value = "/save", 
        method = RequestMethod.POST, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String save(@RequestBody String inputJSON) {
        String returnJSON = "";
        return returnJSON;
    }

    @CrossOrigin
    @RequestMapping (
        value = "/load", 
        method = RequestMethod.POST, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String load() {
        PlaceholderPet php = new PlaceholderPet();
        

        return php.pet;
    }

    @CrossOrigin
    @RequestMapping (
        value = "/test", 
        method = RequestMethod.POST, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String test(@RequestBody String inputJSON) {
        System.out.println(inputJSON);

        String returnJSON = inputJSON;
        return returnJSON;
    }
}
