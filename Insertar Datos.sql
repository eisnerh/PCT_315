INSERT INTO `gasto_operativo` (`gasto_id`, `descripcion_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `persona_idpersona`) VALUES
(1, 'Cine', 5600, '2017-02-12', '111479', 1),
(6, 'Palomitas', 2850, '2017-02-13', '14173306', 1);


--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`horario_id`, `descripcion_horario`) VALUES
(1, 'Diurnos'),
(2, 'Vespertino'),
(3, 'Nocturno');

INSERT INTO `persona` (`idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES
(1, 'Eisner Lopez', '800850956', '89564967', 'CQ', 3);

INSERT INTO `puesto` (`puesto_id`, `descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES
(3, 'Usuario del Sistema', 3000, 1500),
(100, 'Administradora', 5000, 7000);

INSERT INTO `tipo_persona` (`idtipo_persona`, `desc_persona`) VALUES
(1, 'Cliente'),
(2, 'Colaborador'),
(3, 'Proveedor');