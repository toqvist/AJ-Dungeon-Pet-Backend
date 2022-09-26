DROP DATABASE IF EXISTS dungeon_pet;
CREATE DATABASE IF NOT EXISTS dungeon_pet;
USE dungeon_pet;

CREATE TABLE IF NOT EXISTS Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(25) NOT NULL,
    user_password VARCHAR(50) NOT NULL,
    petJSON VARCHAR(1000) NOT NULL
);

INSERT INTO Users(user_name, user_password, petJSON) VALUES('admin', 'password','{"type":"shroomy","age":"baby","isAlive":true,"name":"","food":5,"maxFood":10,"foodDecay":1,"foodDecayRate":60,"fun":5,"maxFun":10,"funDecay":1,"funDecayRate":30,"decayRate":10,"growthRate":900,"emotion":"okay","idle":"/Dungeon-Pet/src/sprites/shroomy/1_shroomy_idle.svg","run":"/Dungeon-Pet/src/sprites/shroomy/1_shroomy_run.svg","animProps":{"height":32,"width":32,"frameCount":4,"fps":6},"doing":"idle","activeSprite":"/Dungeon-Pet/src/sprites/shroomy/1_shroomy_idle.svg","speed":10,"secondsAlive":13}');