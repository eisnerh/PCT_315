(SELECT 
    factura_cabina.factura_id,
    factura_cabina.cant_dia,
    factura_cabina.fecha,
    factura_cabina.impuesto_cabina,
    factura_cabina.precio_total_cabina,
    cabina.descripcion_cabina,
    factura_cabina.numero_factura,
    cliente_empresa.codigo_cliente,
    colaborador.persona_idpersona,
    cliente_empresa.persona_idpersona
FROM
    cabina
        INNER JOIN
    factura_cabina ON cabina.cabina_id = factura_cabina.cabina_cabina_id
        INNER JOIN
    cliente_empresa ON factura_cabina.cliente_empresa_empresa_id = cliente_empresa.empresa_id
        INNER JOIN
    colaborador ON factura_cabina.colaborador_empleado_id = colaborador.empleado_id)
    union
    (select nombre from persona, colaborador where colaborador.persona_idpersona = persona.idpersona)