SELECT 
    cabina.descripcion_cabina,
    cliente_empresa.codigo_cliente,
    factura_cabina.factura_id,
    factura_cabina.cant_dia,
    factura_cabina.fecha,
    factura_cabina.impuesto_cabina,
    factura_cabina.precio_total_cabina,
    factura_cabina.cabina_cabina_id,
    (SELECT 
            nombre
        FROM
            pct3.colaborador
                INNER JOIN
            pct3.persona ON colaborador.persona_idpersona = persona.idpersona
        WHERE
            empleado_id = 3) AS nombreColaborador,
    factura_cabina.numero_factura,
    factura_cabina.cliente_empresa_empresa_id,
    persona.nombre AS nombre_cliente
FROM
    cabina
        INNER JOIN
    factura_cabina ON cabina.cabina_id = factura_cabina.cabina_cabina_id
        INNER JOIN
    cliente_empresa ON factura_cabina.cliente_empresa_empresa_id = cliente_empresa.empresa_id
        INNER JOIN
    persona ON cliente_empresa.persona_idpersona = persona.idpersona
        INNER JOIN
    colaborador ON factura_cabina.colaborador_empleado_id = colaborador.empleado_id
WHERE
    factura_cabina.numero_factura = 5
