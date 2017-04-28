SELECT 
    productos.idproductos,
    productos.nombre_producto,
    sum(cantidad),
    gasto_operativo.factura_gasto
FROM
    pct3.productos
        INNER JOIN
    pct3.gasto_operativo ON productos.gasto_operativo_gasto_id = gasto_operativo.gasto_id
WHERE
    gasto_operativo.factura_gasto LIKE '%%'
        AND gasto_operativo.fecha_gasto LIKE '%%'
group by productos.nombre_producto;