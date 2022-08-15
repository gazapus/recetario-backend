-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema databasename
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema databasename
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `databasename` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema example
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gazapus
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gazapus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gazapus` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`TIPO_INGREDIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TIPO_INGREDIENTE` (
                                                         `id` INT NOT NULL,
                                                         `nombre` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`INGREDIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`INGREDIENTE` (
                                                    `id` INT NOT NULL AUTO_INCREMENT,
                                                    `nombre` VARCHAR(45) NOT NULL,
    `TIPO_INGREDIENTE_id` INT NOT NULL,
    PRIMARY KEY (`id`, `TIPO_INGREDIENTE_id`),
    INDEX `fk_INGREDIENTE_TIPO_INGREDIENTE_idx` (`TIPO_INGREDIENTE_id` ASC) VISIBLE,
    UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
    CONSTRAINT `fk_INGREDIENTE_TIPO_INGREDIENTE`
    FOREIGN KEY (`TIPO_INGREDIENTE_id`)
    REFERENCES `mydb`.`TIPO_INGREDIENTE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TIPO_CANTIDAD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TIPO_CANTIDAD` (
                                                      `id` INT NOT NULL,
                                                      `nombre` VARCHAR(45) NOT NULL,
    `abreviacion` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`RECETA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`RECETA` (
                                               `id` INT NOT NULL,
                                               `nombre` VARCHAR(45) NOT NULL,
    `descripcion` VARCHAR(45) NULL,
    `duracion` INT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`INGREDIENTE_RECETA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`INGREDIENTE_RECETA` (
                                                           `RECETA_id` INT NOT NULL,
                                                           `INGREDIENTE_id` INT NOT NULL,
                                                           `TIPO_CANTIDAD_id` INT NOT NULL,
                                                           `cantidad` FLOAT NOT NULL,
                                                           PRIMARY KEY (`RECETA_id`, `INGREDIENTE_id`, `TIPO_CANTIDAD_id`),
    INDEX `fk_INGREDIENTE_RECETA_INGREDIENTE1_idx` (`INGREDIENTE_id` ASC) VISIBLE,
    INDEX `fk_INGREDIENTE_RECETA_TIPO_CANTIDAD1_idx` (`TIPO_CANTIDAD_id` ASC) VISIBLE,
    CONSTRAINT `fk_INGREDIENTE_RECETA_RECETA1`
    FOREIGN KEY (`RECETA_id`)
    REFERENCES `mydb`.`RECETA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_INGREDIENTE_RECETA_INGREDIENTE1`
    FOREIGN KEY (`INGREDIENTE_id`)
    REFERENCES `mydb`.`INGREDIENTE` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_INGREDIENTE_RECETA_TIPO_CANTIDAD1`
    FOREIGN KEY (`TIPO_CANTIDAD_id`)
    REFERENCES `mydb`.`TIPO_CANTIDAD` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PASO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PASO` (
                                             `id` INT NOT NULL,
                                             `descripcion` VARCHAR(45) NULL,
    `orden` INT NOT NULL,
    `RECETA_id` INT NOT NULL,
    PRIMARY KEY (`id`, `RECETA_id`),
    INDEX `fk_PASO_RECETA1_idx` (`RECETA_id` ASC) VISIBLE,
    CONSTRAINT `fk_PASO_RECETA1`
    FOREIGN KEY (`RECETA_id`)
    REFERENCES `mydb`.`RECETA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TIPO_COMIDA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TIPO_COMIDA` (
                                                    `id` INT NOT NULL,
                                                    `nombre` VARCHAR(45) NOT NULL,
    `descripcion` VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TIPO_COMIDA_RECETA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TIPO_COMIDA_RECETA` (
                                                           `TIPO_COMIDA_id` INT NOT NULL,
                                                           `RECETA_id` INT NOT NULL,
                                                           PRIMARY KEY (`TIPO_COMIDA_id`, `RECETA_id`),
    INDEX `fk_TIPO_COMIDA_RECETA_RECETA1_idx` (`RECETA_id` ASC) VISIBLE,
    CONSTRAINT `fk_TIPO_COMIDA_RECETA_TIPO_COMIDA1`
    FOREIGN KEY (`TIPO_COMIDA_id`)
    REFERENCES `mydb`.`TIPO_COMIDA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_TIPO_COMIDA_RECETA_RECETA1`
    FOREIGN KEY (`RECETA_id`)
    REFERENCES `mydb`.`RECETA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

USE `databasename` ;

-- -----------------------------------------------------
-- Table `databasename`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `databasename`.`persona` (
                                                        `id` INT NOT NULL,
                                                        `nombre` VARCHAR(500) NULL DEFAULT NULL,
    `edad` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

USE `gazapus` ;

-- -----------------------------------------------------
-- Table `gazapus`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gazapus`.`persona` (
                                                   `dni` INT NOT NULL,
                                                   `nombre` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`dni`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
