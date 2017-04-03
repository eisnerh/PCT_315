SELECT 
    persona.idpersona,
    persona.nombre,
    cliente_empresa.codigo_cliente,
    tipo_persona.desc_persona
FROM
    pct3.persona,
    pct3.cliente_empresa,
    pct3.tipo_persona
WHERE
    persona.idpersona = cliente_empresa.persona_idpersona
        AND persona.tipo_persona_idtipo_persona = tipo_persona.idtipo_persona
        AND tipo_persona.desc_persona = 'cliente'