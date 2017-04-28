CREATE PROCEDURE `actualizar_precio_doble` (in precio_doble float)
BEGIN
UPDATE `cabina` SET `precio`= precio_doble WHERE `tipo_cabina` = 'Doble';

END