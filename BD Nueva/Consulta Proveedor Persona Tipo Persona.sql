SELECT 
    proveedor.idproveedor AS 'ID Proveedor',
    proveedor.desc_proveedor AS 'Nombre Proveedor',
    persona.nombre AS 'Nombre Contacto',
    persona.cedula AS 'Cédula',
    persona.telefono AS 'Teléfono',
    persona.direccion AS 'Dirección',
    tipo_persona.desc_persona AS 'Tipo Persona'
FROM
    proveedor
        INNER JOIN
    persona ON proveedor.persona_idpersona = persona.idpersona
        INNER JOIN
    tipo_persona ON persona.tipo_persona_idtipo_persona = tipo_persona.idtipo_persona
WHERE
    proveedor.desc_proveedor LIKE '%N%'