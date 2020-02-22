-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tatdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tatdb` ;

-- -----------------------------------------------------
-- Schema tatdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tatdb` DEFAULT CHARACTER SET utf8 ;
USE `tatdb` ;

-- -----------------------------------------------------
-- Table `trello_csv_file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trello_csv_file` ;

CREATE TABLE IF NOT EXISTS `trello_csv_file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(100) NULL,
  `path_and_file_name` VARCHAR(100) NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `topic`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `topic` ;

CREATE TABLE IF NOT EXISTS `topic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(500) NOT NULL,
  `description` TEXT(10000) NULL,
  `day_of_program` VARCHAR(45) NULL,
  `cohort` VARCHAR(45) NULL,
  `unit` VARCHAR(45) NULL,
  `length_in_min` INT NULL,
  `trello_csv_file_id` INT NOT NULL,
  `date_lectured` DATE NULL,
  PRIMARY KEY (`id`, `trello_csv_file_id`),
  INDEX `fk_topic_trello_csv_file1_idx` (`trello_csv_file_id` ASC),
  CONSTRAINT `fk_topic_trello_csv_file1`
    FOREIGN KEY (`trello_csv_file_id`)
    REFERENCES `trello_csv_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instructor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `instructor` ;

CREATE TABLE IF NOT EXISTS `instructor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `active` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instructor_topic`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `instructor_topic` ;

CREATE TABLE IF NOT EXISTS `instructor_topic` (
  `instructor_id` INT NOT NULL,
  `topic_id` INT NOT NULL,
  PRIMARY KEY (`instructor_id`, `topic_id`),
  INDEX `fk_instructor_has_topic_topic1_idx` (`topic_id` ASC),
  INDEX `fk_instructor_has_topic_instructor1_idx` (`instructor_id` ASC),
  CONSTRAINT `fk_instructor_has_topic_instructor1`
    FOREIGN KEY (`instructor_id`)
    REFERENCES `instructor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_instructor_has_topic_topic1`
    FOREIGN KEY (`topic_id`)
    REFERENCES `topic` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS sdtatuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'sdtatuser'@'localhost' IDENTIFIED BY 'sdtatuser';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `trello_csv_file`
-- -----------------------------------------------------
START TRANSACTION;
USE `tatdb`;
INSERT INTO `trello_csv_file` (`id`, `file_name`, `path_and_file_name`, `start_date`, `end_date`) VALUES (1, 'fileName', 'pathAndFileName', '2024-12-01 ', '2024-12-31');

COMMIT;


-- -----------------------------------------------------
-- Data for table `topic`
-- -----------------------------------------------------
START TRANSACTION;
USE `tatdb`;
INSERT INTO `topic` (`id`, `name`, `description`, `day_of_program`, `cohort`, `unit`, `length_in_min`, `trello_csv_file_id`, `date_lectured`) VALUES (1, 'topicName', 'topicDescription', '12', '23', '1', 60, 1, '2019-11-18');

COMMIT;


-- -----------------------------------------------------
-- Data for table `instructor`
-- -----------------------------------------------------
START TRANSACTION;
USE `tatdb`;
INSERT INTO `instructor` (`id`, `name`, `active`) VALUES (1, 'testInstructor', '1');

COMMIT;


-- -----------------------------------------------------
-- Data for table `instructor_topic`
-- -----------------------------------------------------
START TRANSACTION;
USE `tatdb`;
INSERT INTO `instructor_topic` (`instructor_id`, `topic_id`) VALUES (1, 1);

COMMIT;

