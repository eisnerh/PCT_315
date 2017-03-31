SELECT 
    puesto_id AS id,
    descripcion_puesto AS puesto,
    pago_hora_sencilla AS sencilla,
    pago_hora_extra AS extra
FROM
    pct3.puesto
WHERE
    descripcion_puesto LIKE '%%'
ORDER BY puesto;