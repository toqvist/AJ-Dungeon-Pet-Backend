DROP DATABASE IF EXISTS dungeon_pet;
CREATE DATABASE IF NOT EXISTS dungeon_pet;
USE moviedb;

CREATE TABLE IF NOT EXISTS person (
    person_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(25) NOT NULL,
    user_password VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS pets (
	pet_id INT PRIMARY KEY AUTO_INCREMENT,
    pet_name VARCHAR(25) NOT NULL,
    object VARCHAR(500) NOT NULL
);