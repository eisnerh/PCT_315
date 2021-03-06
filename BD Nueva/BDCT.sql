-- MySQL Script generated by MySQL Workbench
-- mié 08 mar 2017 19:11:36 CST
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
-- Table `pct3`.`cabina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`cabina` ;

CREATE TABLE IF NOT EXISTS `pct3`.`cabina` (
  `cabina_id` SMALLINT(6) NOT NULL AUTO_INCREMENT,
  `descripcion_cabina` VARCHAR(30) NOT NULL,
  `estado_cabina` VARCHAR(45) NOT NULL,
  `precio` FLOAT NOT NULL,
  `tipo_cabina` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cabina_id`),
  UNIQUE INDEX `descripcion_cabina_UNIQUE` (`descripcion_cabina` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Almacena el nombre de la cabina y actualizará el estado de ocupado a vacio.';


-- -----------------------------------------------------
-- Table `pct3`.`cliente_empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`cliente_empresa` ;

CREATE TABLE IF NOT EXISTS `pct3`.`cliente_empresa` (
  `empresa_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre_empresa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`empresa_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`tipo_persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`tipo_persona` ;

CREATE TABLE IF NOT EXISTS `pct3`.`tipo_persona` (
  `idtipo_persona` INT NOT NULL AUTO_INCREMENT,
  `desc_persona` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipo_persona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pct3`.`persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`persona` ;

CREATE TABLE IF NOT EXISTS `pct3`.`persona` (
  `idpersona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `cedula` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `tipo_persona_idtipo_persona` INT NOT NULL,
  PRIMARY KEY (`idpersona`),
  INDEX `fk_persona_tipo_persona1_idx` (`tipo_persona_idtipo_persona` ASC),
  CONSTRAINT `fk_persona_tipo_persona1`
    FOREIGN KEY (`tipo_persona_idtipo_persona`)
    REFERENCES `pct3`.`tipo_persona` (`idtipo_persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pct3`.`puesto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`puesto` ;

CREATE TABLE IF NOT EXISTS `pct3`.`puesto` (
  `puesto_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion_puesto` VARCHAR(30) NOT NULL,
  `pago_hora_sencilla` FLOAT NOT NULL,
  `pago_hora_extra` FLOAT NOT NULL,
  PRIMARY KEY (`puesto_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`colaborador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`colaborador` ;

CREATE TABLE IF NOT EXISTS `pct3`.`colaborador` (
  `empleado_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `fecha_contrato` DATE NOT NULL,
  `fecha_despido` DATE NULL,
  `observaciones` VARCHAR(45) NULL,
  `persona_idpersona` INT NOT NULL,
  `puesto_puesto_id` BIGINT(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`empleado_id`),
  INDEX `fk_colaborador_persona_idx` (`persona_idpersona` ASC),
  INDEX `fk_colaborador_puesto1_idx` (`puesto_puesto_id` ASC),
  CONSTRAINT `fk_colaborador_persona`
    FOREIGN KEY (`persona_idpersona`)
    REFERENCES `pct3`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_colaborador_puesto1`
    FOREIGN KEY (`puesto_puesto_id`)
    REFERENCES `pct3`.`puesto` (`puesto_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`dato_empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`dato_empresa` ;

CREATE TABLE IF NOT EXISTS `pct3`.`dato_empresa` (
  `iddato_empresa` INT NOT NULL AUTO_INCREMENT,
  `empresa_propietario` VARCHAR(45) NOT NULL,
  `empresa_nombre` VARCHAR(45) NOT NULL,
  `empresa_sa` VARCHAR(45) NOT NULL,
  `empresa_cedula_juridica` VARCHAR(45) NOT NULL,
  `empresa_telefono1` VARCHAR(45) NOT NULL,
  `empresa_direccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iddato_empresa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pct3`.`factura_cabina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`factura_cabina` ;

CREATE TABLE IF NOT EXISTS `pct3`.`factura_cabina` (
  `factura_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cant_dia` TINYINT(4) NOT NULL,
  `fecha` DATE NOT NULL,
  `impuesto_cabina` FLOAT NOT NULL,
  `precio_total_cabina` BIGINT(20) NOT NULL,
  `cabina_cabina_id` SMALLINT(6) NOT NULL,
  `dato_empresa_iddato_empresa` INT NOT NULL,
  `cliente_empresa_empresa_id` BIGINT(20) NOT NULL,
  `colaborador_empleado_id` BIGINT(20) NOT NULL,
  `hora_entrada` TIME NOT NULL,
  `hora_salida` TIME NOT NULL,
  PRIMARY KEY (`factura_id`),
  INDEX `fk_factura_cabina_cabina1_idx` (`cabina_cabina_id` ASC),
  INDEX `fk_factura_cabina_dato_empresa1_idx` (`dato_empresa_iddato_empresa` ASC),
  INDEX `fk_factura_cabina_cliente_empresa1_idx` (`cliente_empresa_empresa_id` ASC),
  INDEX `fk_factura_cabina_colaborador1_idx` (`colaborador_empleado_id` ASC),
  CONSTRAINT `fk_factura_cabina_cabina1`
    FOREIGN KEY (`cabina_cabina_id`)
    REFERENCES `pct3`.`cabina` (`cabina_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_cabina_dato_empresa1`
    FOREIGN KEY (`dato_empresa_iddato_empresa`)
    REFERENCES `pct3`.`dato_empresa` (`iddato_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_cabina_cliente_empresa1`
    FOREIGN KEY (`cliente_empresa_empresa_id`)
    REFERENCES `pct3`.`cliente_empresa` (`empresa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_cabina_colaborador1`
    FOREIGN KEY (`colaborador_empleado_id`)
    REFERENCES `pct3`.`colaborador` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


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
  `colaborador_empleado_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`gasto_id`),
  INDEX `fk_gasto_operativo_colaborador1_idx` (`colaborador_empleado_id` ASC),
  CONSTRAINT `fk_gasto_operativo_colaborador1`
    FOREIGN KEY (`colaborador_empleado_id`)
    REFERENCES `pct3`.`colaborador` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`horario` ;

CREATE TABLE IF NOT EXISTS `pct3`.`horario` (
  `horario_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descripcion_horario` VARCHAR(45) NOT NULL,
  `colaborador_empleado_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`horario_id`),
  INDEX `fk_horario_colaborador1_idx` (`colaborador_empleado_id` ASC),
  CONSTRAINT `fk_horario_colaborador1`
    FOREIGN KEY (`colaborador_empleado_id`)
    REFERENCES `pct3`.`colaborador` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`proveedor` ;

CREATE TABLE IF NOT EXISTS `pct3`.`proveedor` (
  `idproveedor` INT NOT NULL AUTO_INCREMENT,
  `desc_proveedor` VARCHAR(45) NULL,
  `persona_idpersona` INT NOT NULL,
  PRIMARY KEY (`idproveedor`),
  INDEX `fk_proveedor_persona1_idx` (`persona_idpersona` ASC),
  CONSTRAINT `fk_proveedor_persona1`
    FOREIGN KEY (`persona_idpersona`)
    REFERENCES `pct3`.`persona` (`idpersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pct3`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`productos` ;

CREATE TABLE IF NOT EXISTS `pct3`.`productos` (
  `idproductos` INT NOT NULL AUTO_INCREMENT,
  `monto_producto` VARCHAR(45) NULL,
  `nombre_producto` VARCHAR(45) NULL,
  `fecha` DATE NULL,
  `proveedor_idproveedor` INT NOT NULL,
  PRIMARY KEY (`idproductos`),
  INDEX `fk_productos_proveedor1_idx` (`proveedor_idproveedor` ASC),
  CONSTRAINT `fk_productos_proveedor1`
    FOREIGN KEY (`proveedor_idproveedor`)
    REFERENCES `pct3`.`proveedor` (`idproveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pct3`.`inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`inventario` ;

CREATE TABLE IF NOT EXISTS `pct3`.`inventario` (
  `inventario_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_inventario_producto` VARCHAR(30) NOT NULL,
  `cant_producto` INT(11) NOT NULL,
  `fecha_compra_producto` DATE NOT NULL,
  `proveedor_proveedor_id` BIGINT(20) UNSIGNED NOT NULL,
  `productos_idproductos` INT NOT NULL,
  PRIMARY KEY (`inventario_id`),
  INDEX `fk_inventario_productos1_idx` (`productos_idproductos` ASC),
  CONSTRAINT `fk_inventario_productos1`
    FOREIGN KEY (`productos_idproductos`)
    REFERENCES `pct3`.`productos` (`idproductos`)
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
  `colaborador_empleado_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`planilla_id`),
  INDEX `fk_planilla_colaborador1_idx` (`colaborador_empleado_id` ASC),
  CONSTRAINT `fk_planilla_colaborador1`
    FOREIGN KEY (`colaborador_empleado_id`)
    REFERENCES `pct3`.`colaborador` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pct3`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`usuario` ;

CREATE TABLE IF NOT EXISTS `pct3`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `colaborador_empleado_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `fk_usuario_colaborador1_idx` (`colaborador_empleado_id` ASC),
  CONSTRAINT `fk_usuario_colaborador1`
    FOREIGN KEY (`colaborador_empleado_id`)
    REFERENCES `pct3`.`colaborador` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pct3`.`marcas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pct3`.`marcas` ;

CREATE TABLE IF NOT EXISTS `pct3`.`marcas` (
  `idmarcas` INT NOT NULL AUTO_INCREMENT,
  `hora_entrada` TIME NOT NULL,
  `hora_salild` TIME NOT NULL,
  `fecha` DATE NOT NULL,
  `colaborador_empleado_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idmarcas`),
  INDEX `fk_marcas_colaborador1_idx` (`colaborador_empleado_id` ASC),
  CONSTRAINT `fk_marcas_colaborador1`
    FOREIGN KEY (`colaborador_empleado_id`)
    REFERENCES `pct3`.`colaborador` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
