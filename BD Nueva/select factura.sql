SELECT 
    factura_cabina.factura_id,
    factura_cabina.cant_dia,
    factura_cabina.fecha,
    factura_cabina.impuesto_cabina,
    factura_cabina.precio_total_cabina,
    factura_cabina.cabina_cabina_id,
    factura_cabina.colaborador_empleado_id,
    factura_cabina.numero_factura,
    factura_cabina.cliente_empresa_empresa_id,
    cabina.descripcion_cabina,
    cliente_empresa.codigo_cliente,
    colaborador.persona_idpersona,
    persona.nombre
FROM
    pct3.cabina AS c2,
    pct3.cliente_empresa AS cc2,
    pct3.colaborador AS cola3,
    pct3.persona,
    pct3.factura_cabina AS factura_cabina
        INNER JOIN
    pct3.cabina AS cabina ON factura_cabina.cabina_cabina_id = cabina.cabina_id
        INNER JOIN
    pct3.cliente_empresa AS cliente_empresa ON factura_cabina.cliente_empresa_empresa_id = cliente_empresa.empresa_id
        INNER JOIN
    pct3.colaborador AS colaborador ON factura_cabina.colaborador_empleado_id = colaborador.empleado_id
        INNER JOIN
    pct3.factura_cabina AS fc2 ON factura_cabina.persona_idpersona = p3.idpersona