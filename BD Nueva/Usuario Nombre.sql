SELECT 
    usuario.idusuario,
    usuario.usuario,
    usuario.password,SELECT `colaborador`.`empleado_id`,
    `colaborador`.`fecha_contrato`,
    `colaborador`.`fecha_despido`,
    `colaborador`.`observaciones`,
    `colaborador`.`persona_idpersona`,
    `colaborador`.`puesto_puesto_id`,
    `colaborador`.`horario_horario_id`
FROM `pct3`.`colaborador`;

    usuario.colaborador_empleado_id,
    persona.nombre
FROM
    pct3.usuario
        INNER JOIN
    colaborador ON colaborador.empleado_id = usuario.colaborador_empleado_id
        INNER JOIN
    persona ON colaborador.persona_idpersona = persona.idpersona
WHERE
    persona.nombre LIKE '%Eisner%'