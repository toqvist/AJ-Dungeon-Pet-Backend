package com.tobias_ahlqvist.dungeonpetbackend;

import com.tobias_ahlqvist.helpers.DatabaseHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DungeonPetBackendApplication {

	public static void main(String[] args) {
		
		//Connect to server, connection can be accessed in DatabaseHelper
		DatabaseHelper.dbConnect("dungeon_pet");

		SpringApplication.run(DungeonPetBackendApplication.class, args);
	}

}
