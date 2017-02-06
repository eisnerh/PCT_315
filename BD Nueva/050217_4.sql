-- MySQL Script generated by MySQL Workbench
-- dom 05 feb 2017 20:35:47 CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pct3
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pct3` ;

-- -----------------------------------------------------
-- Schema pct3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pct3` DEFAULT CHARACTER SET utf8 ;
USE `pct3` ;

-- -----------------------------------------------------
-- Table `pct3`.`precio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`precio` ;

CREATE TABLE IF NOT EXISTS `pct3`.`precio` (
  `precio_id` TINYINT(4) NOT NULL AUTO_INCREMENT,
  `descripcion_precio` VARCHAR(30) NOT NULL,
  `monto_precio` FLOAT NOT NULL,
  PRIMARY KEY (`precio_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`cabina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`cabina` ;

CREATE TABLE IF NOT EXISTS `pct3`.`cabina` (
  `cabina_id` SMALLINT(6) NOT NULL AUTO_INCREMENT,
  `descripcion_cabina` VARCHAR(30) NOT NULL,
  `estado_cabina` TINYINT(4) NOT NULL,
  `precio_precio_id` TINYINT(4) NOT NULL,
  PRIMARY KEY (`cabina_id`),
  UNIQUE INDEX `descripcion_cabina_UNIQUE` (`descripcion_cabina` ASC),
  INDEX `fk_cabina_precio1_idx` (`precio_precio_id` ASC),
  CONSTRAINT `fk_cabina_precio1`
    FOREIGN KEY (`precio_precio_id`)
    REFERENCES `pct3`.`precio` (`precio_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`inventario` ;

CREATE TABLE IF NOT EXISTS `pct3`.`inventario` (
  `inventario_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_producto` VARCHAR(30) NOT NULL,
  `cant_producto` INT(11) NOT NULL,
  `fecha_compra_producto` DATE NOT NULL,
  `precio_inventario` FLOAT NOT NULL,
  PRIMARY KEY (`inventario_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`estatus_empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`estatus_empleado` ;

CREATE TABLE IF NOT EXISTS `pct3`.`estatus_empleado` (
  `id_estado_empleado` INT NOT NULL AUTO_INCREMENT,
  `estado_empleado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_estado_empleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pct3`.`horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`horario` ;

CREATE TABLE IF NOT EXISTS `pct3`.`horario` (
  `horario_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `entrada` VARCHAR(30) NOT NULL,
  `salida` VARCHAR(30) NOT NULL,
  `descanso` VARCHAR(30) NOT NULL,
  `descripcion_horario` VARCHAR(45) NOT NULL,
  `monto_hora_sencilla` FLOAT NOT NULL,
  `monto_hora_extra` FLOAT NOT NULL,
  PRIMARY KEY (`horario_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`puesto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`puesto` ;

CREATE TABLE IF NOT EXISTS `pct3`.`puesto` (
  `puesto_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `horario_horario_id` BIGINT(20) UNSIGNED NOT NULL,
  `descripcion_puesto` VARCHAR(30) NOT NULL,
  `salario_base` INT(11) NOT NULL,
  `pago_hora_sencilla` FLOAT NOT NULL,
  `pago_hora_extra` FLOAT NOT NULL,
  PRIMARY KEY (`puesto_id`, `horario_horario_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`empleado` ;

CREATE TABLE IF NOT EXISTS `pct3`.`empleado` (
  `empleado_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre_empleado` VARCHAR(30) NOT NULL,
  `apellido_empleado` VARCHAR(30) NOT NULL,
  `cedula_empleado` VARCHAR(20) NOT NULL,
  `direccion` VARCHAR(50) NOT NULL,
  `telefono_empleado` VARCHAR(50) NOT NULL,
  `telefono2_empleado` VARCHAR(45) NULL,
  `fecha_contrato` DATE NOT NULL,
  `fecha_despido` DATE NULL,
  `observaciones` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `inventario_inventario_id` INT(11) NOT NULL,
  `estatus_empleado_id_estado_empleado` INT NOT NULL,
  `horario_horario_id` BIGINT(20) NOT NULL,
  `puesto_puesto_id` BIGINT(20) UNSIGNED NOT NULL,
  `puesto_horario_horario_id` BIGINT(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`empleado_id`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC),
  INDEX `fk_empleado_inventario1_idx` (`inventario_inventario_id` ASC),
  INDEX `fk_empleado_estatus_empleado1_idx` (`estatus_empleado_id_estado_empleado` ASC),
  INDEX `fk_empleado_horario1_idx` (`horario_horario_id` ASC),
  INDEX `fk_empleado_puesto1_idx` (`puesto_puesto_id` ASC, `puesto_horario_horario_id` ASC),
  CONSTRAINT `fk_empleado_inventario1`
    FOREIGN KEY (`inventario_inventario_id`)
    REFERENCES `pct3`.`inventario` (`inventario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_estatus_empleado1`
    FOREIGN KEY (`estatus_empleado_id_estado_empleado`)
    REFERENCES `pct3`.`estatus_empleado` (`id_estado_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_horario1`
    FOREIGN KEY (`horario_horario_id`)
    REFERENCES `pct3`.`horario` (`horario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_puesto1`
    FOREIGN KEY (`puesto_puesto_id` , `puesto_horario_horario_id`)
    REFERENCES `pct3`.`puesto` (`puesto_id` , `horario_horario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`empresa` ;

CREATE TABLE IF NOT EXISTS `pct3`.`empresa` (
  `empresa_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre_empresa` VARCHAR(30) NOT NULL,
  `cedula_juridica` VARCHAR(30) NOT NULL,
  `telefono1_empresa` VARCHAR(30) NOT NULL,
  `telefono2_empresa` VARCHAR(30) NOT NULL,
  `descripcion_empresa` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`empresa_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`cliente_empresarial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`cliente_empresarial` ;

CREATE TABLE IF NOT EXISTS `pct3`.`cliente_empresarial` (
  `cliente_id_empresarial` INT NOT NULL AUTO_INCREMENT,
  `empresa_empresa_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`cliente_id_empresarial`),
  INDEX `fk_cliente_empresarial_empresa1_idx` (`empresa_empresa_id` ASC),
  CONSTRAINT `fk_cliente_empresarial_empresa1`
    FOREIGN KEY (`empresa_empresa_id`)
    REFERENCES `pct3`.`empresa` (`empresa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`cliente` ;

CREATE TABLE IF NOT EXISTS `pct3`.`cliente` (
  `cliente_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `apellido_cliente` VARCHAR(45) NOT NULL,
  `apellido2_cliente` VARCHAR(45) NOT NULL,
  `cedula_cliente` VARCHAR(20) NOT NULL,
  `empleado_empleado_id` BIGINT(20) NOT NULL,
  `cliente_empresarial_cliente_id_empresarial` INT NOT NULL,
  PRIMARY KEY (`cliente_id`),
  UNIQUE INDEX `cedula_cliente_UNIQUE` (`cedula_cliente` ASC),
  INDEX `fk_cliente_empleado1_idx` (`empleado_empleado_id` ASC),
  INDEX `fk_cliente_cliente_empresarial1_idx` (`cliente_empresarial_cliente_id_empresarial` ASC),
  CONSTRAINT `fk_cliente_empleado1`
    FOREIGN KEY (`empleado_empleado_id`)
    REFERENCES `pct3`.`empleado` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_cliente_empresarial1`
    FOREIGN KEY (`cliente_empresarial_cliente_id_empresarial`)
    REFERENCES `pct3`.`cliente_empresarial` (`cliente_id_empresarial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`factura_cabina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`factura_cabina` ;

CREATE TABLE IF NOT EXISTS `pct3`.`factura_cabina` (
  `factura_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cant_dia` TINYINT(4) NOT NULL,
  `fecha` DATE NOT NULL,
  `descuento_factura` FLOAT NOT NULL,
  `impuesto_cabina` FLOAT NOT NULL,
  `precio_total_cabina` BIGINT(20) NOT NULL,
  `empleado_empleado_id` BIGINT(20) NOT NULL,
  `cabina_cabina_id` SMALLINT(6) NOT NULL,
  `empleado_empleado_id1` BIGINT(20) NOT NULL,
  `cliente_cliente_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`factura_id`, `empleado_empleado_id`),
  INDEX `fk_factura_cabina_cabina1_idx` (`cabina_cabina_id` ASC),
  INDEX `fk_factura_cabina_empleado1_idx` (`empleado_empleado_id1` ASC),
  INDEX `fk_factura_cabina_cliente1_idx` (`cliente_cliente_id` ASC),
  CONSTRAINT `fk_factura_cabina_cabina1`
    FOREIGN KEY (`cabina_cabina_id`)
    REFERENCES `pct3`.`cabina` (`cabina_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_cabina_empleado1`
    FOREIGN KEY (`empleado_empleado_id1`)
    REFERENCES `pct3`.`empleado` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_cabina_cliente1`
    FOREIGN KEY (`cliente_cliente_id`)
    REFERENCES `pct3`.`cliente` (`cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`tipo_gasto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`tipo_gasto` ;

CREATE TABLE IF NOT EXISTS `pct3`.`tipo_gasto` (
  `id_tipo_gasto` INT NOT NULL AUTO_INCREMENT,
  `descripcion_tipo_gasto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_gasto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pct3`.`gasto_operativo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`gasto_operativo` ;

CREATE TABLE IF NOT EXISTS `pct3`.`gasto_operativo` (
  `gasto_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descripcion_gasto` VARCHAR(50) NOT NULL,
  `monto_gasto` MEDIUMINT(9) NOT NULL,
  `fecha_gasto` DATE NOT NULL,
  `factura_gasto` VARCHAR(45) NOT NULL,
  `empleado_empleado_id` BIGINT(20) NOT NULL,
  `tipo_gasto_id_tipo_gasto` INT NOT NULL,
  PRIMARY KEY (`gasto_id`),
  INDEX `fk_gasto_operativo_empleado1_idx` (`empleado_empleado_id` ASC),
  INDEX `fk_gasto_operativo_tipo_gasto1_idx` (`tipo_gasto_id_tipo_gasto` ASC),
  CONSTRAINT `fk_gasto_operativo_empleado1`
    FOREIGN KEY (`empleado_empleado_id`)
    REFERENCES `pct3`.`empleado` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gasto_operativo_tipo_gasto1`
    FOREIGN KEY (`tipo_gasto_id_tipo_gasto`)
    REFERENCES `pct3`.`tipo_gasto` (`id_tipo_gasto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`planilla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`planilla` ;

CREATE TABLE IF NOT EXISTS `pct3`.`planilla` (
  `planilla_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descripcion_planilla` VARCHAR(30) NOT NULL,
  `fecha_planilla` DATE NOT NULL,
  `total_hora_sencilla` FLOAT NOT NULL,
  `total_hora_extra` FLOAT NOT NULL,
  `total_deduc_ccss` FLOAT NOT NULL,
  `deducciones` FLOAT NOT NULL,
  `monto_pago_planilla` FLOAT NOT NULL,
  `empleado_empleado_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`planilla_id`),
  INDEX `fk_planilla_empleado1_idx` (`empleado_empleado_id` ASC),
  CONSTRAINT `fk_planilla_empleado1`
    FOREIGN KEY (`empleado_empleado_id`)
    REFERENCES `pct3`.`empleado` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`proveedor` ;

CREATE TABLE IF NOT EXISTS `pct3`.`proveedor` (
  `proveedor_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` VARCHAR(30) NOT NULL,
  `contacto_proveedor` VARCHAR(45) NOT NULL,
  `telefono1_proveedor` VARCHAR(45) NOT NULL,
  `telefono2_proveedor` VARCHAR(45) NULL,
  `empleado_empleado_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`proveedor_id`),
  INDEX `fk_proveedor_empleado_idx` (`empleado_empleado_id` ASC),
  CONSTRAINT `fk_proveedor_empleado`
    FOREIGN KEY (`empleado_empleado_id`)
    REFERENCES `pct3`.`empleado` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`tipo_usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`tipo_usuario` ;

CREATE TABLE IF NOT EXISTS `pct3`.`tipo_usuario` (
  `id_tipo_usuario` INT NOT NULL AUTO_INCREMENT,
  `descripcion_tipo_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo_usuario`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
