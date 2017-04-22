SELECT 
    productos.idproductos,
    productos.nombre_producto,
    proveedor.desc_proveedor,
    persona.nombre,
    persona.telefono
FROM
    pct3.productos
        INNER JOIN
    proveedor ON proveedor.idproveedor = productos.proveedor_idproveedor
        INNER JOIN
    persona ON proveedor.persona_idpersona = persona.idpersona
