SELECT 
    gasto_operativo.gasto_id,
    gasto_operativo.tipo_gasto,
    gasto_operativo.monto_gasto,
    gasto_operativo.fecha_gasto,
    gasto_operativo.factura_gasto,
    persona.nombre
FROM
    pct3.gasto_operativo
        INNER JOIN
    colaborador ON gasto_operativo.colaborador_empleado_id = colaborador.empleado_id
        INNER JOIN
    persona ON colaborador.persona_idpersona = persona.idpersona
    where gasto_operativo.factura_gasto like '%1%';