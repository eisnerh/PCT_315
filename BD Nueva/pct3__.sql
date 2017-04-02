-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-04-2017 a las 07:39:56
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pct3`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_precio_doble` (IN `precio_doble` FLOAT)  BEGIN
UPDATE `cabina` SET `precio`= precio_doble WHERE `tipo_cabina` = 'Doble';

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_precio_sencilla` (IN `precio_doble` FLOAT)  BEGIN
UPDATE `cabina` SET `precio`= precio_doble WHERE `tipo_cabina` = 'Sencilla';

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabina`
--

CREATE TABLE `cabina` (
  `cabina_id` smallint(6) NOT NULL,
  `descripcion_cabina` varchar(30) NOT NULL,
  `estado_cabina` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `tipo_cabina` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Almacena el nombre de la cabina y actualizará el estado de ocupado a vacio.';

--
-- Volcado de datos para la tabla `cabina`
--

INSERT INTO `cabina` (`cabina_id`, `descripcion_cabina`, `estado_cabina`, `precio`, `tipo_cabina`) VALUES
(1, 'Uno', 'Libre', 10000, 'Sencilla'),
(2, 'Dos', 'Libre', 15000, 'Doble'),
(3, 'Tres', 'Libre', 15000, 'Doble'),
(4, 'Cuatro', 'Libre', 10000, 'Sencilla'),
(6, 'Cinco', 'Libre', 15000, 'Doble'),
(8, 'Seis', 'Libre', 15000, 'Doble');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_empresa`
--

CREATE TABLE `cliente_empresa` (
  `empresa_id` bigint(20) NOT NULL,
  `codigo_cliente` varchar(45) NOT NULL,
  `estado_cliente` tinyint(1) NOT NULL,
  `persona_idpersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente_empresa`
--

INSERT INTO `cliente_empresa` (`empresa_id`, `codigo_cliente`, `estado_cliente`, `persona_idpersona`) VALUES
(1, 'Cesar2', 0, 2),
(3, 'cualquiera', 1, 6),
(4, 'Fulano8', 1, 8),
(5, 'Metida14', 1, 16),
(6, 'Bala15', 1, 17),
(7, 'MAtias18', 1, 18),
(8, 'Ckiente21', 1, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaborador`
--

CREATE TABLE `colaborador` (
  `empleado_id` bigint(20) NOT NULL,
  `fecha_contrato` date NOT NULL,
  `fecha_despido` date DEFAULT NULL,
  `observaciones` varchar(45) DEFAULT NULL,
  `persona_idpersona` int(11) NOT NULL,
  `puesto_puesto_id` bigint(20) UNSIGNED NOT NULL,
  `horario_horario_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `colaborador`
--

INSERT INTO `colaborador` (`empleado_id`, `fecha_contrato`, `fecha_despido`, `observaciones`, `persona_idpersona`, `puesto_puesto_id`, `horario_horario_id`) VALUES
(2, '2017-03-01', '0000-00-00', NULL, 20, 1, 5),
(3, '2017-04-25', NULL, NULL, 1, 2, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_cabina`
--

CREATE TABLE `factura_cabina` (
  `factura_id` bigint(20) NOT NULL,
  `cant_dia` tinyint(4) NOT NULL,
  `fecha` date NOT NULL,
  `impuesto_cabina` float NOT NULL,
  `precio_total_cabina` bigint(20) NOT NULL,
  `cabina_cabina_id` smallint(6) NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL,
  `numero_factura` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gasto_operativo`
--

CREATE TABLE `gasto_operativo` (
  `gasto_id` bigint(20) NOT NULL,
  `tipo_gasto` varchar(50) NOT NULL DEFAULT 'planilla o gasto operativo',
  `monto_gasto` mediumint(9) NOT NULL,
  `fecha_gasto` date NOT NULL,
  `factura_gasto` varchar(45) NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `gasto_operativo`
--

INSERT INTO `gasto_operativo` (`gasto_id`, `tipo_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id`) VALUES
(24, 'planilla', 100000, '2017-03-01', '1', 2),
(25, 'ligula tortor, dictum', 919, '2017-11-08', '983', 2),
(26, 'Vestibulum ut eros', 468, '2016-04-03', '720', 2),
(27, 'Nunc sed orci', 872, '2016-04-08', '433', 2),
(28, 'nibh. Donec est', 178, '2017-04-04', '832', 2),
(29, 'a neque. Nullam', 278, '2017-07-11', '116', 2),
(30, 'ultrices sit amet,', 186, '2017-07-20', '942', 2),
(31, 'orci. Phasellus dapibus', 552, '2016-07-26', '970', 2),
(32, 'arcu. Nunc mauris.', 867, '2016-12-07', '788', 2),
(33, 'in, dolor. Fusce', 516, '2017-11-26', '66', 2),
(34, 'nibh sit amet', 149, '2017-07-30', '711', 2),
(35, 'sed dui. Fusce', 909, '2018-01-04', '11', 2),
(36, 'eu dolor egestas', 760, '2017-11-10', '886', 2),
(37, 'sagittis. Duis gravida.', 222, '2016-08-28', '765', 2),
(38, 'eros nec tellus.', 668, '2017-08-24', '350', 2),
(39, 'nec luctus felis', 134, '2018-03-20', '309', 2),
(40, 'sapien. Nunc pulvinar', 438, '2017-03-15', '652', 2),
(41, 'nisl. Maecenas malesuada', 798, '2017-12-06', '447', 2),
(42, 'Suspendisse eleifend. Cras', 461, '2016-08-03', '800', 2),
(43, 'accumsan laoreet ipsum.', 132, '2016-10-16', '618', 2),
(44, 'Quisque varius. Nam', 142, '2017-07-14', '401', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `horario_id` bigint(20) NOT NULL,
  `descripcion_horario` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`horario_id`, `descripcion_horario`) VALUES
(5, 'Diurno'),
(11, 'Nocturno'),
(12, 'Vespertino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `cedula` bigint(20) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `tipo_persona_idtipo_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES
(1, 'Eisner Lopez Acevedo', 800850956, '89564967', 'San Carlos', 9),
(2, 'Cesar', 1251212, '21212', '21212', 10),
(3, 'Diora', 12121, '2121', '21212', 10),
(4, 'Dirno', 121312, '89564961', 'San Carlos', 10),
(5, 'Melissa', 1212121, '21212421', 'San Carlos', 10),
(6, 'Karla', 21212410, '254542', '212121', 10),
(7, 'Fulano', 21212545, '3221212', 'san Carkis', 10),
(8, 'Fulano', 212121, '878787878', 'San Carlos', 10),
(9, 'Fulano2', 21212645, 'san Carkis', '3221212a', 10),
(10, 'Mengano', 2124567891, '32212121', 'san Carkis', 10),
(11, 'Mary', 12312565781, '212121421', 'Etilico', 10),
(12, 'Metida', 120140064, '212124523', 'San Carlos', 10),
(14, 'Metida', 1201400641, '212124523', 'San Carlos', 10),
(16, 'Metida', 120140064111, '212124523', 'San Carlos', 10),
(17, 'Bala', 212554757787, '2124212', '2124212', 10),
(18, 'MAtias', 6565765441, '1213121', 'San Carlos', 10),
(19, 'Juan Magan', 21214533586, '1123512', 'SAN CARLOS', 11),
(20, 'Etel', 2152425877, '124536', 'San Carlos', 9),
(21, 'Ckiente', 12522200, '1', 'CQ', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idproductos` bigint(20) NOT NULL,
  `nombre_producto` varchar(45) NOT NULL,
  `proveedor_idproveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL,
  `desc_proveedor` varchar(45) DEFAULT NULL,
  `persona_idpersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idproveedor`, `desc_proveedor`, `persona_idpersona`) VALUES
(1, 'Juan Magan19', 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

CREATE TABLE `puesto` (
  `puesto_id` bigint(20) UNSIGNED NOT NULL,
  `descripcion_puesto` varchar(45) NOT NULL,
  `pago_hora_sencilla` float NOT NULL,
  `pago_hora_extra` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`puesto_id`, `descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES
(1, 'Administrador', 3000, 5000),
(2, 'Empleado', 1000, 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_persona`
--

CREATE TABLE `tipo_persona` (
  `idtipo_persona` int(11) NOT NULL,
  `desc_persona` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_persona`
--

INSERT INTO `tipo_persona` (`idtipo_persona`, `desc_persona`) VALUES
(9, 'Empleado'),
(10, 'Cliente'),
(11, 'Proveedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `usuario` varchar(45) CHARACTER SET utf8 NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `usuario`, `password`, `colaborador_empleado_id`) VALUES
(1, 'admin', 'admin', 2),
(2, 'colabora', 'colabora', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cabina`
--
ALTER TABLE `cabina`
  ADD PRIMARY KEY (`cabina_id`),
  ADD UNIQUE KEY `descripcion_cabina_UNIQUE` (`descripcion_cabina`);

--
-- Indices de la tabla `cliente_empresa`
--
ALTER TABLE `cliente_empresa`
  ADD PRIMARY KEY (`empresa_id`),
  ADD KEY `cliente_empresa_FK_idx` (`persona_idpersona`),
  ADD KEY `persona_idpersona` (`persona_idpersona`);

--
-- Indices de la tabla `colaborador`
--
ALTER TABLE `colaborador`
  ADD PRIMARY KEY (`empleado_id`,`persona_idpersona`),
  ADD KEY `fk_colaborador_persona_idx` (`persona_idpersona`),
  ADD KEY `fk_colaborador_puesto1_idx` (`puesto_puesto_id`),
  ADD KEY `fk_colaborador_horario_idx` (`horario_horario_id`);

--
-- Indices de la tabla `factura_cabina`
--
ALTER TABLE `factura_cabina`
  ADD PRIMARY KEY (`factura_id`),
  ADD KEY `fk_factura_cabina_cabina1_idx` (`cabina_cabina_id`),
  ADD KEY `fk_factura_cabina_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indices de la tabla `gasto_operativo`
--
ALTER TABLE `gasto_operativo`
  ADD PRIMARY KEY (`gasto_id`),
  ADD KEY `fk_gasto_operativo_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`horario_id`),
  ADD UNIQUE KEY `descripcion_horario` (`descripcion_horario`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`),
  ADD UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  ADD KEY `fk_persona_tipo_persona1_idx` (`tipo_persona_idtipo_persona`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idproductos`),
  ADD KEY `fk_productos_proveedor1_idx` (`proveedor_idproveedor`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idproveedor`),
  ADD KEY `fk_proveedor_persona1_idx` (`persona_idpersona`);

--
-- Indices de la tabla `puesto`
--
ALTER TABLE `puesto`
  ADD PRIMARY KEY (`puesto_id`),
  ADD UNIQUE KEY `descripcion_puesto_UNIQUE` (`descripcion_puesto`);

--
-- Indices de la tabla `tipo_persona`
--
ALTER TABLE `tipo_persona`
  ADD PRIMARY KEY (`idtipo_persona`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD KEY `fk_usuario_colaborador1_idx` (`colaborador_empleado_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cabina`
--
ALTER TABLE `cabina`
  MODIFY `cabina_id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `cliente_empresa`
--
ALTER TABLE `cliente_empresa`
  MODIFY `empresa_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `colaborador`
--
ALTER TABLE `colaborador`
  MODIFY `empleado_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `factura_cabina`
--
ALTER TABLE `factura_cabina`
  MODIFY `factura_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `gasto_operativo`
--
ALTER TABLE `gasto_operativo`
  MODIFY `gasto_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `horario_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idproveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `puesto`
--
ALTER TABLE `puesto`
  MODIFY `puesto_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tipo_persona`
--
ALTER TABLE `tipo_persona`
  MODIFY `idtipo_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente_empresa`
--
ALTER TABLE `cliente_empresa`
  ADD CONSTRAINT `fk_cliente_empresa_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `colaborador`
--
ALTER TABLE `colaborador`
  ADD CONSTRAINT `fk_colaborador_horario` FOREIGN KEY (`horario_horario_id`) REFERENCES `horario` (`horario_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_colaborador_persona` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_colaborador_puesto1` FOREIGN KEY (`puesto_puesto_id`) REFERENCES `puesto` (`puesto_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura_cabina`
--
ALTER TABLE `factura_cabina`
  ADD CONSTRAINT `fk_factura_cabina_cabina1` FOREIGN KEY (`cabina_cabina_id`) REFERENCES `cabina` (`cabina_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_factura_cabina_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `gasto_operativo`
--
ALTER TABLE `gasto_operativo`
  ADD CONSTRAINT `fk_gasto_operativo_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_persona_tipo_persona1` FOREIGN KEY (`tipo_persona_idtipo_persona`) REFERENCES `tipo_persona` (`idtipo_persona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_productos_proveedor1` FOREIGN KEY (`proveedor_idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `fk_proveedor_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
