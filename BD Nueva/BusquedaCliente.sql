SELECT 
    cliente_empresa.codigo_cliente, persona.nombre
FROM
    cliente_empresa
        INNER JOIN
    persona ON cliente_empresa.persona_idpersona = persona.idpersona
WHERE
    persona.nombre LIKE '%B%'