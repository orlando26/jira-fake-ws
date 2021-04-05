-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jira_fake
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jira_fake` ;

-- -----------------------------------------------------
-- Schema jira_fake
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jira_fake` ;
USE `jira_fake` ;

-- -----------------------------------------------------
-- Table `jira_fake`.`project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`project` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL DEFAULT '0',
  `description` VARCHAR(500) NOT NULL DEFAULT '0',
  `creation_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL DEFAULT '',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`type` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`type` (
  `id` TINYINT(2) NOT NULL,
  `name` VARCHAR(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`priority`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`priority` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`priority` (
  `id` TINYINT(2) NOT NULL,
  `name` VARCHAR(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`status` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`status` (
  `id` TINYINT(2) NOT NULL,
  `project_id` INT(20) NOT NULL DEFAULT '0',
  `done_status` TINYINT(1) NOT NULL DEFAULT '0',
  `creation_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  INDEX `FK_status_project_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `FK__status__project`
    FOREIGN KEY (`project_id`)
    REFERENCES `jira_fake`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`rol` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`rol` (
  `id` TINYINT(2) NOT NULL,
  `rol` VARCHAR(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`user` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`user` (
  `id` INT NOT NULL,
  `username` VARCHAR(1000) NOT NULL DEFAULT '0',
  `name` VARCHAR(100) NOT NULL DEFAULT '0',
  `email` INT NOT NULL DEFAULT '0',
  `avatar_url` VARCHAR(100) NOT NULL DEFAULT '0',
  `rol_id` TINYINT(2) NOT NULL DEFAULT '0',
  `creation_date` DATETIME NOT NULL DEFAULT '0',
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK__user__rol_idx` (`rol_id` ASC) VISIBLE,
  CONSTRAINT `FK__user__rol`
    FOREIGN KEY (`rol_id`)
    REFERENCES `jira_fake`.`rol` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`issue`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`issue` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`issue` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `project_id` INT NOT NULL,
  `title` VARCHAR(300) NOT NULL DEFAULT '0',
  `type_id` TINYINT(2) NOT NULL,
  `status_id` TINYINT(2) NOT NULL DEFAULT '0',
  `priority_id` TINYINT(2) NOT NULL DEFAULT '',
  `description` VARCHAR(1000) NOT NULL,
  `story_points` INT NOT NULL DEFAULT '0',
  `time_estimate` INT NOT NULL DEFAULT '0',
  `time_spent` INT NOT NULL DEFAULT '0',
  `reporter_id` INT NOT NULL DEFAULT '0',
  `owner_id` INT NOT NULL DEFAULT '0',
  `subtask_id` INT NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_issue_type_idx` (`type_id` ASC) VISIBLE,
  INDEX `FK__issue__priority_idx` (`priority_id` ASC) VISIBLE,
  INDEX `FK__issue__project_idx` (`project_id` ASC) VISIBLE,
  INDEX `FK__issue__status_idx` (`status_id` ASC) VISIBLE,
  INDEX `FK__issue__subtask_idx` (`subtask_id` ASC) VISIBLE,
  INDEX `FK__issue__reporter_idx` (`reporter_id` ASC) VISIBLE,
  INDEX `FK__issue__owner_idx` (`owner_id` ASC) VISIBLE,
  CONSTRAINT `FK__issue__type`
    FOREIGN KEY (`type_id`)
    REFERENCES `jira_fake`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__priority`
    FOREIGN KEY (`priority_id`)
    REFERENCES `jira_fake`.`priority` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__project`
    FOREIGN KEY (`project_id`)
    REFERENCES `jira_fake`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__status`
    FOREIGN KEY (`status_id`)
    REFERENCES `jira_fake`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__subtask`
    FOREIGN KEY (`subtask_id`)
    REFERENCES `jira_fake`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__reporter`
    FOREIGN KEY (`reporter_id`)
    REFERENCES `jira_fake`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__issue__owner`
    FOREIGN KEY (`owner_id`)
    REFERENCES `jira_fake`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`sprint`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`sprint` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`sprint` (
  `id` INT NOT NULL,
  `title` VARCHAR(50) NOT NULL DEFAULT '0',
  `goals` VARCHAR(500) NOT NULL,
  `project_id` INT NOT NULL,
  `creation_date` DATETIME NOT NULL,
  `update_date` DATETIME NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  INDEX `FK__sprint__project_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `FK__sprint__project`
    FOREIGN KEY (`project_id`)
    REFERENCES `jira_fake`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`sprint_issue`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`sprint_issue` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`sprint_issue` (
  `id` INT NOT NULL,
  `sprint_id` INT NOT NULL DEFAULT '0',
  `issue_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK__sprint_issue__sprint_idx` (`sprint_id` ASC) VISIBLE,
  INDEX `FK__sprint_issue__issue_idx` (`issue_id` ASC) VISIBLE,
  CONSTRAINT `FK__sprint_issue__sprint`
    FOREIGN KEY (`sprint_id`)
    REFERENCES `jira_fake`.`sprint` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__sprint_issue__issue`
    FOREIGN KEY (`issue_id`)
    REFERENCES `jira_fake`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`comments` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`comments` (
  `id` INT NOT NULL,
  `text` VARCHAR(1000) NOT NULL DEFAULT '0',
  `user_id` INT NOT NULL DEFAULT '0',
  `issue_id` INT NOT NULL DEFAULT '0',
  `creation_date` DATETIME NOT NULL DEFAULT '0',
  `update_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK__comments_issue_idx` (`issue_id` ASC) VISIBLE,
  INDEX `FK__coments_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK__comments__issue`
    FOREIGN KEY (`issue_id`)
    REFERENCES `jira_fake`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__coments_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `jira_fake`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


-- -----------------------------------------------------
-- Table `jira_fake`.`project_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jira_fake`.`project_user` ;

CREATE TABLE IF NOT EXISTS `jira_fake`.`project_user` (
  `id` INT NOT NULL,
  `project_id` INT NOT NULL DEFAULT '0',
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK__project_user__project_idx` (`project_id` ASC) VISIBLE,
  INDEX `FK__project_user__user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK__project_user__project`
    FOREIGN KEY (`project_id`)
    REFERENCES `jira_fake`.`project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK__project_user__user`
    FOREIGN KEY (`user_id`)
    REFERENCES `jira_fake`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table of flags';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
