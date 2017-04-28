CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cabina`(in descripcionCabina varchar(45), in estado_cabina varchar(45), in precio int, in tipo_cabina varchar(45))
BEGIN
	INSERT INTO `pct3`.`cabina`
(`descripcion_cabina`,
`estado_cabina`,
`precio`,
`tipo_cabina`)
VALUES
(descripcionCabina,
estado_cabina,
precio,
tipo_cabina);
END