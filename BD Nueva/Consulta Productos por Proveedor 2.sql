SELECT 
    productos.idproductos,
    productos.nombre_producto,
    productos.cantidad,
    proveedor.desc_proveedor as 'nombre empresa',
    persona.nombre as 'nombre contacto',
    persona.telefono,
    gasto_operativo.factura_gasto as 'n factura'
FROM
    pct3.productos
        INNER JOIN
    pct3.gasto_operativo ON productos.gasto_operativo_gasto_id = gasto_operativo.gasto_id
        INNER JOIN
    proveedor ON productos.proveedor_idproveedor = proveedor.idproveedor
        INNER JOIN
    persona ON proveedor.persona_idpersona = persona.idpersona order by nombre_producto;