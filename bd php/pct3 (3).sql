-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 17-02-2017 a las 20:19:45
-- Versión del servidor: 5.7.17-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.13-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pct3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabina`
--

CREATE TABLE `cabina` (
  `cabina_id` smallint(6) NOT NULL,
  `descripcion_cabina` varchar(30) NOT NULL,
  `estado_cabina` varchar(45) NOT NULL,
  `precio_precio_id` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Almacena el nombre de la cabina y actualizará el estado de ocupado a vacio.';

--
-- Volcado de datos para la tabla `cabina`
--

INSERT INTO `cabina` (`cabina_id`, `descripcion_cabina`, `estado_cabina`, `precio_precio_id`) VALUES
(31, 'Rogan', 'Ocupada', 1),
(32, 'Ashton', 'Libre', 2),
(33, 'Ciaran', 'Limpieza', 1),
(34, 'Wayne', 'Ocupada', 1),
(35, 'Deacon', 'Libre', 2),
(36, 'Hiram', 'Limpieza', 1),
(37, 'Jasper', 'Ocupada', 1),
(38, 'Aquila', 'Libre', 2),
(39, 'Price', 'Bloqueada', 1),
(40, 'Noah', 'Libre', 1),
(41, 'Owen', 'Ocupada', 2),
(42, 'Erich', 'Libre', 1),
(43, 'Logan', 'Limpieza', 2),
(44, 'Allistair', 'Ocupada', 1),
(45, 'Reece', 'Libre', 1),
(46, 'Gage', 'Limpieza', 1),
(47, 'Orson', 'Ocupada', 1),
(48, 'Dennis', 'Limpieza', 1),
(49, 'Randall', 'Bloqueada', 1),
(50, 'Preston', 'Libre', 1),
(51, 'Macaulay', 'Ocupada', 2),
(52, 'Dominic', 'Libre', 2),
(53, 'Thane', 'Bloqueada', 2),
(54, 'Curran', 'Libre', 2),
(55, 'Nasim', 'Ocupada', 1),
(56, 'Lee', 'Libre', 2),
(57, 'Xenos', 'Ocupada', 1),
(58, 'Channing', 'Limpieza', 2),
(59, 'Reuben', 'Ocupada', 2),
(60, 'Josiah', 'Libre', 1);

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
  `horario_horario_id` bigint(20) NOT NULL,
  `puesto_puesto_id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `colaborador`
--

INSERT INTO `colaborador` (`empleado_id`, `fecha_contrato`, `fecha_despido`, `observaciones`, `persona_idpersona`, `horario_horario_id`, `puesto_puesto_id`) VALUES
(1, '2015-10-13', NULL, NULL, 1, 1, 100),
(2, '2016-02-13', NULL, NULL, 100, 2, 3),
(3, '2015-02-17', NULL, NULL, 5, 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos_empresa`
--

CREATE TABLE `datos_empresa` (
  `iddatos_empresa` int(11) NOT NULL,
  `empresa_nombre` varchar(45) NOT NULL,
  `empresa_propietario` varchar(45) NOT NULL,
  `empresa_sa` varchar(45) NOT NULL,
  `empresa_cedula_juridica` varchar(45) NOT NULL,
  `empresa_telefono1` varchar(45) NOT NULL,
  `empresa_telefono2` varchar(45) NOT NULL,
  `empresa_direccion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Guarda la información que se muestra en la factura. Como son el dueño, nombre de la empresa, telefono. direccion';

--
-- Volcado de datos para la tabla `datos_empresa`
--

INSERT INTO `datos_empresa` (`iddatos_empresa`, `empresa_nombre`, `empresa_propietario`, `empresa_sa`, `empresa_cedula_juridica`, `empresa_telefono1`, `empresa_telefono2`, `empresa_direccion`) VALUES
(1, 'Cabinas El Trópico', 'Cesar Gonzalez', 'PYME', '1232112221441', '2464 0602', '', 'San Rafael de Guatuso, Alajuela');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `empresa_id` bigint(20) NOT NULL,
  `nombre_empresa` varchar(45) NOT NULL,
  `persona_idpersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`empresa_id`, `nombre_empresa`, `persona_idpersona`) VALUES
(1, 'SIGMA', 6),
(2, 'GESSA', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_cabina`
--

CREATE TABLE `factura_cabina` (
  `factura_id` bigint(20) NOT NULL,
  `cant_dia` tinyint(4) NOT NULL,
  `fecha` date NOT NULL,
  `sub_total` float NOT NULL,
  `impuesto_cabina` float NOT NULL,
  `precio_total_cabina` bigint(20) NOT NULL,
  `cabina_cabina_id` smallint(6) NOT NULL,
  `persona_idpersona` int(11) NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL,
  `datos_empresa_iddatos_empresa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `factura_cabina`
--

INSERT INTO `factura_cabina` (`factura_id`, `cant_dia`, `fecha`, `sub_total`, `impuesto_cabina`, `precio_total_cabina`, `cabina_cabina_id`, `persona_idpersona`, `colaborador_empleado_id`, `datos_empresa_iddatos_empresa`) VALUES
(7, 1, '2017-02-17', 1010, 1010, 2020, 31, 6, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gasto_operativo`
--

CREATE TABLE `gasto_operativo` (
  `gasto_id` bigint(20) NOT NULL,
  `descripcion_gasto` varchar(50) NOT NULL,
  `monto_gasto` mediumint(9) NOT NULL,
  `fecha_gasto` date NOT NULL,
  `factura_gasto` varchar(45) NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `gasto_operativo`
--

INSERT INTO `gasto_operativo` (`gasto_id`, `descripcion_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id`) VALUES
(1, 'Cine', 5600, '2017-02-12', '111479', 1),
(6, 'Palomitas', 2850, '2017-02-13', '14173306', 2);

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
(1, 'Diurnos'),
(2, 'Vespertino'),
(3, 'Nocturno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `inventario_id` int(11) NOT NULL,
  `nombre_producto` varchar(30) NOT NULL,
  `cant_producto` int(11) NOT NULL,
  `fecha_compra_producto` date NOT NULL,
  `proveedor_proveedor_id` bigint(20) UNSIGNED NOT NULL,
  `productos_idproductos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `idmarcas` int(11) NOT NULL,
  `hora_entrada` time NOT NULL,
  `hora_salild` time NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `cedula` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `tipo_persona_idtipo_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES
(1, 'Eisner Lopez', '800850956', '89564967', 'CQ', 2),
(4, 'Alan Winters', '31143', '9743', 'Est Limited', 2),
(5, 'Driscoll Fowler', '6926', 'X1Z 7M5', 'Id Incorporated', 2),
(6, 'Dale Castaneda', '4752', '228569', 'Vel Venenatis Vel Foundation', 1),
(7, 'Wyatt Shannon', '20307', '9219JZ', 'Magnis Associates', 1),
(8, 'Tarik Key', '09-226', '9885LP', 'Per Inceptos Hymenaeos LLP', 3),
(9, 'Brendan Rowe', '75353', '254279', 'Ullamcorper Viverra Associates', 1),
(10, 'Thaddeus Stokes', '10741', 'KS02 6TQ', 'Ipsum Sodales Industries', 3),
(11, 'Isaiah Butler', '1965', 'N5X 0T9', 'Odio LLP', 1),
(12, 'Hector Singleton', '09744', '95814', 'Sed PC', 3),
(13, 'Abdul Thomas', '9493', '32-358', 'Sagittis Nullam Ltd', 3),
(14, 'Palmer Dotson', 'P9 2YU', '78948', 'Tellus Corporation', 2),
(15, 'Wesley Michael', 'S6V 1A1', 'TI26 3JN', 'Pede Limited', 2),
(16, 'Walter Delgado', '21712', '73837', 'Sem Semper LLP', 2),
(17, 'Oleg Brooks', '572830', '27850', 'Neque LLP', 1),
(18, 'Blaze Jenkins', '44034', '131543', 'Lorem Foundation', 3),
(19, 'Stuart Donaldson', '8010WF', 'T2A 1M9', 'Duis Gravida Praesent Corp.', 2),
(20, 'Kareem Dixon', '751529', 'P8S 8N2', 'Morbi Quis Associates', 1),
(21, 'Hammett Mooney', '93648', '11918', 'Id Corporation', 1),
(22, 'Hammett Benton', '80796', '173360', 'Adipiscing Industries', 3),
(23, 'William Simon', '57940', '4372HB', 'Dictum Corp.', 2),
(24, 'Joseph Fox', '165474', '0423GA', 'Sed Orci Corporation', 3),
(25, 'Vernon Love', '7114', 'PF3 7RF', 'Pretium LLC', 2),
(26, 'Blaze Dillon', '923508', '1937', 'Eget Massa Institute', 3),
(27, 'Laith Harrington', '49255', '27168', 'Sapien Nunc Pulvinar Corporation', 2),
(28, 'Hakeem Gonzales', 'E1G 7G1', '02577', 'Consectetuer Euismod Est Corporation', 1),
(29, 'Charles Horn', '12946-207', '9047', 'Nunc Pulvinar Limited', 3),
(30, 'Harlan Tyler', '6675', '05823', 'Cras PC', 1),
(31, 'Robert Hawkins', '847396', '67362-813', 'Morbi Incorporated', 1),
(32, 'Thomas Lester', '9832', '475399', 'Placerat Incorporated', 3),
(33, 'Tobias Decker', '1346', '32865-131', 'Nunc Ac PC', 2),
(34, 'Porter Nichols', '2832', '47427', 'Nulla Limited', 2),
(35, 'Kennan Carter', '61316', '784602', 'Dignissim Limited', 1),
(36, 'Yardley Zamora', '33637', 'X4A 4A6', 'Natoque LLC', 3),
(37, 'Jacob Mcgowan', '52623', '07-600', 'Dictum Cursus Nunc Incorporated', 3),
(38, 'Prescott Tran', '6242TI', 'S7E 9A1', 'Tempus Limited', 3),
(39, 'Barrett Dillard', '07164-813', '09447', 'Magna Tellus Consulting', 1),
(40, 'Acton Richmond', '180604', '11401', 'Parturient LLC', 3),
(41, 'Carter Berry', '37153', '50206', 'Diam LLP', 3),
(42, 'Arthur Caldwell', '45493', 'B1G 4E5', 'Scelerisque Corporation', 1),
(43, 'Keegan Waters', '98404', '21001', 'Pharetra Felis LLP', 3),
(44, 'Mohammad Underwood', '3640', '63361-252', 'Dolor Donec Fringilla LLP', 2),
(45, 'Cain Bowman', '6900', '29746', 'Risus Duis Company', 1),
(46, 'Brandon Orr', '8362', '68735', 'Et Netus Corporation', 3),
(47, 'Scott Gamble', '71004', '0624', 'Dolor Associates', 1),
(48, 'Preston Underwood', '189129', 'S6 2XI', 'Pede Cum Industries', 1),
(49, 'Carter Snow', '18-981', '77315', 'Nec Corp.', 2),
(50, 'Malcolm Alford', '01-315', '41116', 'Ligula Eu Enim Institute', 3),
(51, 'Kennedy Park', '048089', '5096', 'Metus In Nec Company', 3),
(52, 'Brandon Hernandez', '244531', '11103', 'Mauris Institute', 1),
(53, 'Griffin Nieves', '468383', '94759', 'Augue Id Incorporated', 2),
(54, 'Jakeem Benton', '8378', '72760-913', 'Id Nunc Interdum Industries', 3),
(55, 'Armando Mercer', '06740-245', '72255', 'Vestibulum Associates', 1),
(56, 'Hashim Paul', '85946', '3246SZ', 'Magnis Dis Institute', 3),
(57, 'William Giles', '61002', '6266', 'Turpis Nulla Institute', 1),
(58, 'Jeremy Peterson', '89084', '17373', 'Id Erat Foundation', 1),
(59, 'Jerome Browning', '86018', '71-505', 'Ullamcorper Eu Euismod LLC', 1),
(60, 'Zephania Nash', '8579', '736249', 'Gravida Company', 2),
(61, 'Wayne Contreras', '25011', '42619', 'Sed PC', 1),
(62, 'Thor Hahn', '9149', '6368', 'Phasellus Fermentum Convallis LLC', 2),
(63, 'Jonas Glover', '93249', '2834', 'A Industries', 3),
(64, 'Colin Sanford', '489385', '44-695', 'Nullam Suscipit Est Corp.', 2),
(65, 'Randall Hoover', '212269', 'ZJ29 8TQ', 'Fusce Mi Corp.', 1),
(66, 'Uriah Gay', '9688', '65338-358', 'Dolor Corp.', 3),
(67, 'Nash Young', '21916', '75971', 'Tincidunt Tempus Risus Ltd', 1),
(68, 'Colorado Sutton', '116902', '85646', 'Non Enim Limited', 2),
(69, 'Cruz Sparks', '60704', 'A5W 6E3', 'Sit Amet Limited', 1),
(70, 'Jason Lynn', '10-626', '64456', 'Nec Tempus Scelerisque Associates', 3),
(71, 'Harrison Gordon', 'EF2D 0HB', '93438', 'Tortor Industries', 2),
(72, 'Isaiah England', '42095', '12-701', 'Rutrum Eu Ultrices Corp.', 1),
(73, 'Kuame Reyes', '440079', '2425', 'Donec Institute', 2),
(74, 'Gray Mercer', '44996', '80592', 'Ultrices Iaculis Odio Ltd', 1),
(75, 'Conan Burch', '20519', '35077', 'Aliquet Nec PC', 1),
(76, 'Calvin Chandler', '5931', '871201', 'Adipiscing Elit Limited', 2),
(77, 'Hiram Garrison', '44547', '22322', 'Fusce LLC', 2),
(78, 'Camden Joyner', '5135', '30604', 'Nec Enim LLC', 1),
(79, 'Patrick Newton', '78456', '62125', 'Tellus Eu LLP', 3),
(80, 'Jack Gregory', '2272EA', '509717', 'Facilisis Suspendisse LLP', 1),
(81, 'Brent Emerson', '79366', '171983', 'Aliquet Company', 2),
(82, 'Axel Sloan', '6830', '5393', 'Massa Non Ante Inc.', 2),
(83, 'Stephen Rodriquez', '37784-306', '571911', 'Viverra Corp.', 3),
(84, 'Marvin Shaw', '4783', '8943', 'Nunc Limited', 3),
(85, 'Lionel Washington', '40013', 'LA91 0WV', 'Pede Praesent Associates', 1),
(86, 'Curran Pope', '9204', '88534', 'Neque Et Nunc LLP', 1),
(87, 'Brady Copeland', '3645', '91231', 'Libero Incorporated', 2),
(88, 'Amos Hawkins', '6808', '4393', 'At Pede Consulting', 3),
(89, 'Felix Riggs', '7497', '42953', 'Et Ipsum Limited', 1),
(90, 'Zeph Berger', '175244', '08745', 'Magnis Dis Parturient Industries', 3),
(91, 'Kenyon Mejia', '72887', '217798', 'Ipsum Cursus Vestibulum Associates', 1),
(92, 'Thane Hill', '49988', '435849', 'Sed Ltd', 3),
(93, 'Amery Kane', '3169', '72821', 'Nulla Associates', 2),
(94, 'Colby Chandler', '1541MA', '7977', 'Lacus Quisque Associates', 1),
(95, 'Talon Preston', '21806', '91743', 'Sed Company', 3),
(96, 'Ross King', '5313', '47009', 'Et Pede Nunc Limited', 1),
(97, 'Giacomo Le', '49595', '70803', 'Ullamcorper Consulting', 2),
(98, 'Xavier Dixon', '7724', '85729', 'Et Foundation', 1),
(99, 'Nathan Vazquez', '6689YX', '13184', 'Volutpat Ltd', 2),
(100, 'Damon Thompson', '9680HZ', '15878', 'Luctus Lobortis Consulting', 2),
(101, 'Thaddeus Hayden', '21201', '03211', 'Ac Mattis Ornare Corporation', 3),
(102, 'Juan Magan', '800851656', '89501111', 'Bogota', 1),
(103, 'Eliseo Rueda', '12121212', '8900000', 'Cerveceria', 2),
(104, 'Marcos Rodrigues', '21212121', '21212522', 'AQui', 2),
(105, 'Miguel Josepht', '22121', 'asd', 'Pital', 2),
(106, 'Dinorah', '212121', '212121', '212121', 2),
(107, 'mAE', '212121', '212121', '212121', 2),
(108, 'Merlin Zambrano', '121212', '2121212', '212', 2),
(109, 'Macha Hona', '212121', '2121', '212', 2),
(110, 'Eric Vindas', '212121', '21212', '2121', 2),
(111, 'Michael Nite', '2121', '21212', '2121', 1),
(112, 'Marcos Vindas', '212121', '21212', '2121', 1),
(113, 'Nandy Doble', '212121', '212121', '212121', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `planilla`
--

CREATE TABLE `planilla` (
  `planilla_id` bigint(20) NOT NULL,
  `descripcion_planilla` varchar(30) NOT NULL,
  `fecha_planilla` date NOT NULL,
  `total_hora_sencilla` float NOT NULL,
  `total_hora_extra` float NOT NULL,
  `total_deduc_ccss` float NOT NULL,
  `deducciones` float NOT NULL,
  `monto_pago_planilla` float NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio`
--

CREATE TABLE `precio` (
  `precio_id` tinyint(4) NOT NULL,
  `descripcion_precio` varchar(30) NOT NULL,
  `monto_precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `precio`
--

INSERT INTO `precio` (`precio_id`, `descripcion_precio`, `monto_precio`) VALUES
(1, 'Sencilla', 10000),
(2, 'Doble', 15000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idproductos` int(11) NOT NULL,
  `monto_productos` varchar(45) DEFAULT NULL,
  `desc_productos` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

CREATE TABLE `puesto` (
  `puesto_id` bigint(20) UNSIGNED NOT NULL,
  `descripcion_puesto` varchar(30) NOT NULL,
  `pago_hora_sencilla` float NOT NULL,
  `pago_hora_extra` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`puesto_id`, `descripcion_puesto`, `pago_hora_sencilla`, `pago_hora_extra`) VALUES
(3, 'Usuario del Sistema', 3000, 1500),
(100, 'Administrador', 5000, 7000);

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
(1, 'Cliente'),
(2, 'Colaborador'),
(3, 'Proveedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `usuario`, `password`, `colaborador_empleado_id`) VALUES
(2, 'admin', 'admin', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cabina`
--
ALTER TABLE `cabina`
  ADD PRIMARY KEY (`cabina_id`),
  ADD UNIQUE KEY `descripcion_cabina_UNIQUE` (`descripcion_cabina`),
  ADD KEY `fk_cabina_precio1_idx` (`precio_precio_id`);

--
-- Indices de la tabla `colaborador`
--
ALTER TABLE `colaborador`
  ADD PRIMARY KEY (`empleado_id`),
  ADD KEY `fk_colaborador_persona_idx` (`persona_idpersona`),
  ADD KEY `fk_colaborador_horario1_idx` (`horario_horario_id`),
  ADD KEY `fk_colaborador_puesto1_idx` (`puesto_puesto_id`);

--
-- Indices de la tabla `datos_empresa`
--
ALTER TABLE `datos_empresa`
  ADD PRIMARY KEY (`iddatos_empresa`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`empresa_id`),
  ADD KEY `fk_empresa_persona1_idx` (`persona_idpersona`);

--
-- Indices de la tabla `factura_cabina`
--
ALTER TABLE `factura_cabina`
  ADD PRIMARY KEY (`factura_id`),
  ADD KEY `fk_factura_cabina_cabina1_idx` (`cabina_cabina_id`),
  ADD KEY `fk_factura_cabina_persona1_idx` (`persona_idpersona`),
  ADD KEY `fk_factura_cabina_colaborador1_idx` (`colaborador_empleado_id`),
  ADD KEY `fk_factura_cabina_datos_empresa1_idx` (`datos_empresa_iddatos_empresa`);

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
  ADD PRIMARY KEY (`horario_id`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`inventario_id`),
  ADD KEY `fk_inventario_productos1_idx` (`productos_idproductos`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`idmarcas`),
  ADD KEY `fk_marcas_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`),
  ADD KEY `fk_persona_tipo_persona1_idx` (`tipo_persona_idtipo_persona`);

--
-- Indices de la tabla `planilla`
--
ALTER TABLE `planilla`
  ADD PRIMARY KEY (`planilla_id`),
  ADD KEY `fk_planilla_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indices de la tabla `precio`
--
ALTER TABLE `precio`
  ADD PRIMARY KEY (`precio_id`);

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
  ADD PRIMARY KEY (`puesto_id`);

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
  MODIFY `cabina_id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
--
-- AUTO_INCREMENT de la tabla `colaborador`
--
ALTER TABLE `colaborador`
  MODIFY `empleado_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `datos_empresa`
--
ALTER TABLE `datos_empresa`
  MODIFY `iddatos_empresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `empresa_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `factura_cabina`
--
ALTER TABLE `factura_cabina`
  MODIFY `factura_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `gasto_operativo`
--
ALTER TABLE `gasto_operativo`
  MODIFY `gasto_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `horario_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `inventario_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `idmarcas` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;
--
-- AUTO_INCREMENT de la tabla `planilla`
--
ALTER TABLE `planilla`
  MODIFY `planilla_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `precio`
--
ALTER TABLE `precio`
  MODIFY `precio_id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `puesto`
--
ALTER TABLE `puesto`
  MODIFY `puesto_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
--
-- AUTO_INCREMENT de la tabla `tipo_persona`
--
ALTER TABLE `tipo_persona`
  MODIFY `idtipo_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cabina`
--
ALTER TABLE `cabina`
  ADD CONSTRAINT `fk_cabina_precio1` FOREIGN KEY (`precio_precio_id`) REFERENCES `precio` (`precio_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `colaborador`
--
ALTER TABLE `colaborador`
  ADD CONSTRAINT `fk_colaborador_horario1` FOREIGN KEY (`horario_horario_id`) REFERENCES `horario` (`horario_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_colaborador_persona` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_colaborador_puesto1` FOREIGN KEY (`puesto_puesto_id`) REFERENCES `puesto` (`puesto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `fk_empresa_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura_cabina`
--
ALTER TABLE `factura_cabina`
  ADD CONSTRAINT `fk_factura_cabina_cabina1` FOREIGN KEY (`cabina_cabina_id`) REFERENCES `cabina` (`cabina_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_cabina_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_cabina_datos_empresa1` FOREIGN KEY (`datos_empresa_iddatos_empresa`) REFERENCES `datos_empresa` (`iddatos_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_cabina_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `gasto_operativo`
--
ALTER TABLE `gasto_operativo`
  ADD CONSTRAINT `fk_gasto_operativo_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `fk_inventario_productos1` FOREIGN KEY (`productos_idproductos`) REFERENCES `productos` (`idproductos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD CONSTRAINT `fk_marcas_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_persona_tipo_persona1` FOREIGN KEY (`tipo_persona_idtipo_persona`) REFERENCES `tipo_persona` (`idtipo_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `planilla`
--
ALTER TABLE `planilla`
  ADD CONSTRAINT `fk_planilla_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_productos_proveedor1` FOREIGN KEY (`proveedor_idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `fk_proveedor_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
