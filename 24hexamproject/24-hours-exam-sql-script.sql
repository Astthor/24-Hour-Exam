-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE DATABASE 24h;
USE 24h;

-- -----------------------------------------------------
-- Table `supervisor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supervisor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(70) NULL,
  `email` VARCHAR(60) NULL,
  `supervisor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_supervisor_id`
    FOREIGN KEY (`supervisor_id`)
    REFERENCES `supervisor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_supervisor_id_idx` ON `student` (`supervisor_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `supervisor`
-- -----------------------------------------------------
START TRANSACTION;
USE `24h`;
INSERT INTO `supervisor` VALUES (1, 'Tomas');
INSERT INTO `supervisor` VALUES (2, 'Erik');
INSERT INTO `supervisor` VALUES (3, 'Arturo');
INSERT INTO `supervisor` VALUES (4, 'Marianne');
INSERT INTO `supervisor` VALUES (5, 'Karl');

COMMIT;


-- -----------------------------------------------------
-- Data for table `student`
-- -----------------------------------------------------
START TRANSACTION;
USE `24h`;
INSERT INTO `student`  VALUES (1, 'Anna M', 'annamaria@stud.kea.dk', 1);
INSERT INTO `student`  VALUES (2, 'Maria S', 'maria-s@stud.kea.dk', 1);
INSERT INTO `student`  VALUES (3, 'Astthor', 'astthor@stud.kea.dk', 2);

COMMIT;

