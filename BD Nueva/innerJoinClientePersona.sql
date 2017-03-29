SELECT 
    *
FROM
    pct3.cliente_empresa
        INNER JOIN
    pct3.persona ON cliente_empresa.persona_idpersona = persona.idpersona
WHERE
    nombre = 'matias';