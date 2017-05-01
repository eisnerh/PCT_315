SELECT 
    productos.nombre_producto,
    SUM(productos.cant) AS Cant,
    gasto_operativo.factura_gasto
FROM
    pct3.productos
        INNER JOIN
    pct3.gasto_operativo ON productos.gasto_operativo_gasto_id = gasto_operativo.gasto_id
WHERE
    gasto_operativo.factura_gasto LIKE '%%'
        AND gasto_operativo.fecha_gasto LIKE '%%'
        AND Cant > 0
GROUP BY nombre_producto , factura_gasto