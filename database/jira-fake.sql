-- MySQL Script generated by MySQL Workbench
-- Thu 08 Apr 2021 09:58:46 PM CDT
-- Model: jira-fake-EER    Version: 1.0

-- Version: Initial.

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jira-fake
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jira-fake` ;

-- -----------------------------------------------------
-- Schema jira-fake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jira-fake` ;
USE `jira-fake` ;

-- -----------------------------------------------------
-- Table `jira-fake`.`project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`project` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(500) NOT NULL DEFAULT '',
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jira-fake`.`type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`type` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`type` (
  `id` TINYINT(2) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Predefined issue type values.';


-- -----------------------------------------------------
-- Table `jira-fake`.`priority`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`priority` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`priority` (
  `id` TINYINT(2) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Predefined issue priority values.';


-- -----------------------------------------------------
-- Table `jira-fake`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`status` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`status` (
  `id` TINYINT(2) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `project_id` INT(20) NOT NULL,
  `done_status` TINYINT(1) NOT NULL DEFAULT 0,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `FK__status__project_idx` (`project_id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  CONSTRAINT `FK__status__project`
    FOREIGN KEY (`project_id`)
    REFERENCES `jira-fake`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'User-defined issue progress status for a specific project.';


-- -----------------------------------------------------
-- Table `jira-fake`.`rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`rol` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`rol` (
  `id` TINYINT(2) NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `rol_UNIQUE` (`rol` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Predefined user rol values.';


-- -----------------------------------------------------
-- Table `jira-fake`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`user` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`user` (
  `id` INT NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `lastname` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `avatar_url` VARCHAR(100) NOT NULL,
  `rol_id` TINYINT(2) NOT NULL DEFAULT 2,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `FK__user__rol_idx` (`rol_id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `FK__user__rol`
    FOREIGN KEY (`rol_id`)
    REFERENCES `jira-fake`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jira-fake`.`issue`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`issue` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`issue` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `project_id` INT NOT NULL,
  `title` VARCHAR(300) NOT NULL,
  `type_id` TINYINT(2) NOT NULL DEFAULT 1,
  `description` VARCHAR(1000) NOT NULL DEFAULT '',
  `priority_id` TINYINT(2) NOT NULL DEFAULT 1,
  `status_id` TINYINT(2) NOT NULL DEFAULT 1,
  `story_points` INT NOT NULL DEFAULT 0,
  `time_estimate` INT NOT NULL DEFAULT 60,
  `time_spent` INT NOT NULL DEFAULT 0,
  `reporter_id` INT NOT NULL,
  `owner_id` INT NOT NULL,
  `subtask_id` INT NOT NULL,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `FK__issue__type_idx` (`type_id` ASC) VISIBLE,
  INDEX `FK__issue__priority_idx` (`priority_id` ASC) VISIBLE,
  INDEX `FK__issue__project_idx` (`project_id` ASC) VISIBLE,
  INDEX `FK__issue__status_idx` (`status_id` ASC) VISIBLE,
  INDEX `FK__issue__subtask_idx` (`subtask_id` ASC) VISIBLE,
  INDEX `FK__issue__reporter_idx` (`reporter_id` ASC) VISIBLE,
  INDEX `FK__issue__owner_idx` (`owner_id` ASC) VISIBLE,
  CONSTRAINT `FK__issue__type`
    FOREIGN KEY (`type_id`)
    REFERENCES `jira-fake`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__priority`
    FOREIGN KEY (`priority_id`)
    REFERENCES `jira-fake`.`priority` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__project`
    FOREIGN KEY (`project_id`)
    REFERENCES `jira-fake`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__status`
    FOREIGN KEY (`status_id`)
    REFERENCES `jira-fake`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__subtask`
    FOREIGN KEY (`subtask_id`)
    REFERENCES `jira-fake`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__reporter`
    FOREIGN KEY (`reporter_id`)
    REFERENCES `jira-fake`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__owner`
    FOREIGN KEY (`owner_id`)
    REFERENCES `jira-fake`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jira-fake`.`sprint`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`sprint` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`sprint` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `goals` VARCHAR(500) NOT NULL DEFAULT '',
  `project_id` INT NOT NULL,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `FK__sprint__project_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `FK__sprint__project`
    FOREIGN KEY (`project_id`)
    REFERENCES `jira-fake`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jira-fake`.`sprint_issue`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`sprint_issue` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`sprint_issue` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sprint_id` INT NOT NULL,
  `issue_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK__sprint_issue__sprint_idx` (`sprint_id` ASC) VISIBLE,
  INDEX `FK__sprint_issue__issue_idx` (`issue_id` ASC) VISIBLE,
  CONSTRAINT `FK__sprint_issue__sprint`
    FOREIGN KEY (`sprint_id`)
    REFERENCES `jira-fake`.`sprint` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__sprint_issue__issue`
    FOREIGN KEY (`issue_id`)
    REFERENCES `jira-fake`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jira-fake`.`comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`comments` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(1000) NOT NULL,
  `user_id` INT NOT NULL,
  `issue_id` INT NOT NULL,
  `creation_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `FK__comments_issue_idx` (`issue_id` ASC) VISIBLE,
  INDEX `FK__coments__user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK__comments__issue`
    FOREIGN KEY (`issue_id`)
    REFERENCES `jira-fake`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__coments__user`
    FOREIGN KEY (`user_id`)
    REFERENCES `jira-fake`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Comments on a specific issue made by a specific user.';


-- -----------------------------------------------------
-- Table `jira-fake`.`project_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira-fake`.`project_user` ;

CREATE TABLE IF NOT EXISTS `jira-fake`.`project_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `project_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK__project_user__project_idx` (`project_id` ASC) VISIBLE,
  INDEX `FK__project_user__user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK__project_user__project`
    FOREIGN KEY (`project_id`)
    REFERENCES `jira-fake`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__project_user__user`
    FOREIGN KEY (`user_id`)
    REFERENCES `jira-fake`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `jira-fake`.`type`
-- -----------------------------------------------------
START TRANSACTION;
USE `jira-fake`;
INSERT INTO `jira-fake`.`type` (`id`, `name`) VALUES (1, 'Task');
INSERT INTO `jira-fake`.`type` (`id`, `name`) VALUES (2, 'New feature');
INSERT INTO `jira-fake`.`type` (`id`, `name`) VALUES (3, 'Improvement');
INSERT INTO `jira-fake`.`type` (`id`, `name`) VALUES (4, 'Epic');
INSERT INTO `jira-fake`.`type` (`id`, `name`) VALUES (5, 'Bug');
INSERT INTO `jira-fake`.`type` (`id`, `name`) VALUES (6, 'Story');
INSERT INTO `jira-fake`.`type` (`id`, `name`) VALUES (7, 'Meeting');

COMMIT;


-- -----------------------------------------------------
-- Data for table `jira-fake`.`priority`
-- -----------------------------------------------------
START TRANSACTION;
USE `jira-fake`;
INSERT INTO `jira-fake`.`priority` (`id`, `name`) VALUES (1, 'Lowest');
INSERT INTO `jira-fake`.`priority` (`id`, `name`) VALUES (2, 'Low');
INSERT INTO `jira-fake`.`priority` (`id`, `name`) VALUES (3, 'Medium');
INSERT INTO `jira-fake`.`priority` (`id`, `name`) VALUES (4, 'High');
INSERT INTO `jira-fake`.`priority` (`id`, `name`) VALUES (5, 'Highest');
INSERT INTO `jira-fake`.`priority` (`id`, `name`) VALUES (6, 'Major');
INSERT INTO `jira-fake`.`priority` (`id`, `name`) VALUES (7, 'Critical');
INSERT INTO `jira-fake`.`priority` (`id`, `name`) VALUES (8, 'Blocker');

COMMIT;


-- -----------------------------------------------------
-- Data for table `jira-fake`.`rol`
-- -----------------------------------------------------
START TRANSACTION;
USE `jira-fake`;
INSERT INTO `jira-fake`.`rol` (`id`, `rol`) VALUES (1, 'Admin');
INSERT INTO `jira-fake`.`rol` (`id`, `rol`) VALUES (2, 'User');

COMMIT;

