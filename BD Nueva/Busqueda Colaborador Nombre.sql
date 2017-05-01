SELECT 
    colaborador.empleado_id,
    persona.idpersona,
    persona.nombre,
    persona.cedula,
    persona.direccion,
    persona.telefono,
    colaborador.fecha_contrato,
    colaborador.fecha_despido,
    colaborador.horario_horario_id,
    horario.descripcion_horario,
    colaborador.observaciones,
    colaborador.puesto_puesto_id,
    puesto.descripcion_puesto
FROM
    colaborador
        INNER JOIN
    persona ON colaborador.persona_idpersona = persona.idpersona
        INNER JOIN
    horario ON colaborador.horario_horario_id = horario.horario_id
        INNER JOIN
    puesto ON colaborador.puesto_puesto_id = puesto.puesto_id
WHERE
    persona.nombre LIKE '%%'