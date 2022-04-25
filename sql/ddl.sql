-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `User` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `passwd` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `category` (
  `id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `user_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_id`
    FOREIGN KEY (`id`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Post` (
  `id` VARCHAR(45) NOT NULL,
  `category_id` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `user_id` VARCHAR(45) NULL,
  `reg_date` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `category_id_idx` (`category_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `mydb`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comment` (
  `id` VARCHAR(45) NOT NULL,
  `comment_text` VARCHAR(3000) NULL,
  `reg_date` DATETIME NULL,
  `post_id` VARCHAR(45) NULL,
  `user_id` VARCHAR(45) NULL,
  `reg_date` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `post_id_idx` (`post_id` ASC) VISIBLE,
  CONSTRAINT `post_id`
    FOREIGN KEY (`post_id`)
    REFERENCES `mydb`.`Post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;






