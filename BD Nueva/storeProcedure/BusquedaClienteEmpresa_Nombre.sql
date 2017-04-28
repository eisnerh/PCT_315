CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_precio_doble`(IN `precio_doble` FLOAT)
BEGIN
UPDATE `cabina` SET `precio`= precio_doble WHERE `tipo_cabina` = 'Doble';

END