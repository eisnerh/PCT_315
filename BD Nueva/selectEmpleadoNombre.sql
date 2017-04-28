SELECT 
    colaborador.empleado_id, persona.nombre
FROM
    pct3.colaborador
        INNER JOIN
    pct3.persona ON colaborador.persona_idpersona = persona.idpersona
WHERE
    persona.nombre LIKE '%%'
ORDER BY persona.nombre