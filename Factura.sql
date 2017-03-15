SELECT `dato_empresa`.`empresa_nombre`, `dato_empresa`.`empresa_cedula_juridica`, `dato_empresa`.`empresa_telefono1`, `dato_empresa`.`empresa_direccion`, `factura_cabina`.`fecha`, `cliente_empresa`.`codigo_cliente`, `factura_cabina`.`factura_id`, `cabina`.`descripcion_cabina`, `factura_cabina`.`impuesto_cabina`, `factura_cabina`.`precio_total_cabina`, `factura_cabina`.`cant_dia`, `persona`.`nombre` FROM `pct3`.`factura_cabina` AS `factura_cabina`, `pct3`.`cabina` AS `cabina`, `pct3`.`cliente_empresa` AS `cliente_empresa`, `pct3`.`colaborador` AS `colaborador`, `pct3`.`dato_empresa` AS `dato_empresa`, `pct3`.`persona` AS `persona` WHERE `factura_cabina`.`cabina_cabina_id` = `cabina`.`cabina_id` AND `factura_cabina`.`cliente_empresa_empresa_id` = `cliente_empresa`.`empresa_id` AND `factura_cabina`.`colaborador_empleado_id` = `colaborador`.`empleado_id` AND `factura_cabina`.`dato_empresa_iddato_empresa` = `dato_empresa`.`iddato_empresa` AND `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `factura_cabina`.`fecha` = {d '2017-03-04' }