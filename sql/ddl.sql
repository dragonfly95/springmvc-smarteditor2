-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
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
  PRIMARY KEY (`id`))
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
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comment` (
  `id` VARCHAR(45) NOT NULL,
  `comment_text` VARCHAR(3000) NULL,
  `reg_date` TIMESTAMP NULL,
  `post_id` VARCHAR(45) NULL,
  `user_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;







