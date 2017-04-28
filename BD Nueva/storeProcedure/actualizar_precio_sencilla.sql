CREATE PROCEDURE `actualizar_precio_sencilla` (in precio_doble float)
BEGIN
UPDATE `cabina` SET `precio`= precio_doble WHERE `tipo_cabina` = 'Sencilla';

END