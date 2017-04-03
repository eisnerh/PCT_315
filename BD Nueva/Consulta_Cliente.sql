CREATE DEFINER=`root`@`localhost` PROCEDURE `Consulta_Cliente`(IN _codigoCliente varchar(45))
BEGIN

SELECT 
    `tipo_persona`.`desc_persona` AS `Tipo Persona`,
    `cliente_empresa`.`codigo_cliente` AS `Codigo Cliente`,
    `persona`.`nombre` AS `Nombre`,
    `persona`.`idpersona` AS `Id Cliente`
FROM
    `persona`
        INNER JOIN
    `cliente_empresa` ON `cliente_empresa`.`persona_idpersona` = `persona`.`idpersona`
        INNER JOIN
    `tipo_persona` ON `persona`.`tipo_persona_idtipo_persona` = `tipo_persona`.`idtipo_persona`
WHERE
    `tipo_persona`.`desc_persona` = 'Cliente' and `cliente_empresa`.`codigo_cliente` = (_codigoCliente);
END