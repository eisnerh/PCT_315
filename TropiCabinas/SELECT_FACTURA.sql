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
persona.nombre, 
cliente_empresa.codigo_cliente, 
colaborador.persona_idpersona 
FROM 
pct3.factura_cabina AS factura_cabina, pct3.cabina AS cabina, pct3.cliente_empresa AS cliente_empresa, pct3.persona AS persona, pct3.colaborador AS colaborador WHERE factura_cabina.cabina_cabina_id = cabina.cabina_id AND factura_cabina.cliente_empresa_empresa_id = cliente_empresa.empresa_id AND cliente_empresa.persona_idpersona = persona.idpersona AND factura_cabina.colaborador_empleado_id = colaborador.empleado_id AND colaborador.persona_idpersona = persona.idpersona