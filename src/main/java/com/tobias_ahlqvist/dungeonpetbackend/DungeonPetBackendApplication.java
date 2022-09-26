package com.tobias_ahlqvist.dungeonpetbackend;

import com.tobias_ahlqvist.helpers.DatabaseHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.crypto.Data;

@SpringBootApplication
public class DungeonPetBackendApplication {

	public static void main(String[] args) {
		
		//Connect to server, connection can be accessed in DatabaseHelper
		DatabaseHelper.dbConnect("dungeon_pet");

		SpringApplication.run(DungeonPetBackendApplication.class, args);
	}

}
