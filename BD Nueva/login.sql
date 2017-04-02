SELECT 
    `usuario`.`usuario`,
    `usuario`.`password`,
    `usuario`.`colaborador_empleado_id` AS `empleado_id`,
    `persona`.`nombre` AS `nombre`,
    `puesto`.`puesto_id` AS `acceso`,
    `puesto`.`descripcion_puesto` AS `tipo_acceso`
FROM
    `pct3`.`usuario` AS `usuario`,
    `pct3`.`colaborador` AS `colaborador`,
    `pct3`.`persona` AS `persona`,
    `pct3`.`puesto` AS `puesto`
WHERE
    `usuario`.`colaborador_empleado_id` = `colaborador`.`empleado_id`
        AND `colaborador`.`persona_idpersona` = `persona`.`idpersona`
        AND `colaborador`.`puesto_puesto_id` = `puesto`.`puesto_id`
        AND `usuario`.`usuario` = BINARY 'colabora'
        AND `usuario`.`password` = BINARY 'colabora';