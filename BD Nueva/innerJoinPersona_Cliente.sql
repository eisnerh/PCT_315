SELECT 
    cliente_empresa.codigo_cliente,
    IF(cliente_empresa.estado_cliente = 0,
        'Activo',
        'Betado') AS estado,
    persona.nombre,
    persona.cedula
FROM
    cliente_empresa
        INNER JOIN
    persona ON cliente_empresa.persona_idpersona = persona.idpersona;