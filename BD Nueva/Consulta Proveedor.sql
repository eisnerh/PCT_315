SELECT 
    proveedor.idproveedor,
    proveedor.desc_proveedor,
    persona.nombre
FROM
    pct3.proveedor
        INNER JOIN
    persona ON proveedor.persona_idpersona = persona.idpersona
WHERE
    proveedor.desc_proveedor = 'Juan Magan19';