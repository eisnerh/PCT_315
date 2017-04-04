SELECT 
    `factura_cabina`.`factura_id`,
    `factura_cabina`.`cant_dia`,
    `factura_cabina`.`fecha`,
    `factura_cabina`.`impuesto_cabina`,
    `factura_cabina`.`precio_total_cabina`,
    `factura_cabina`.`cabina_cabina_id`,
    `factura_cabina`.`colaborador_empleado_id`,
    `factura_cabina`.`numero_factura`
FROM
    `pct3`.`factura_cabina`
WHERE
    `factura_cabina`.`numero_factura` = 1
    order by `factura_cabina`.`numero_factura`;