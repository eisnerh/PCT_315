-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 08, 2017 at 07:10 PM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pct3`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Actualizar_Precio_Doble` (IN `precio_doble` FLOAT)  BEGIN
UPDATE `cabina` SET `precio`= precio_doble WHERE `tipo_cabina` = 'Doble';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Actualizar_Precio_Sencilla` (IN `Nuevo_Precio` INT)  NO SQL
UPDATE `cabina` SET `precio`= Nuevo_Precio WHERE `tipo_cabina` = 'Sencilla'$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cabina_vacia` (IN `estadoCabina` VARCHAR(45))  BEGIN
Select * from cabina where estado_cabina = estadoCabina;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `login` (IN `usuario` VARCHAR(45), IN `passw` VARCHAR(45))  BEGIN
SELECT `usuario`.`usuario`, `usuario`.`password`, `usuario`.`colaborador_empleado_id`, `persona`.`nombre` FROM `pct3`.`usuario` AS `usuario`, `pct3`.`colaborador` AS `colaborador`, `pct3`.`persona` AS `persona` WHERE `usuario`.`colaborador_empleado_id` = `colaborador`.`empleado_id` AND `colaborador`.`persona_idpersona` = `persona`.`idpersona` AND `usuario`.`usuario` = usuario AND `usuario`.`password` = passw;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `muestra_todas_cabinas` ()  BEGIN
	select descripcion_cabina, estado_cabina, precio, tipo_cabina from cabina;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `precio_tipoCabina` (IN `tipoCabina` VARCHAR(45))  BEGIN
SELECT COUNT( * ) as cuenta, `cabina`.`tipo_cabina` as tipo_cabina, 
`cabina`.`precio`as precio FROM `pct3`.`cabina` AS `cabina` GROUP BY `tipo_cabina`, `precio`
having ((tipo_cabina = tipoCabina));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `todas_cabinas` (IN `var1` VARCHAR(45))  BEGIN

select * from cabina where estado_cabina = var1;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `cabina`
--

CREATE TABLE `cabina` (
  `cabina_id` smallint(6) NOT NULL,
  `descripcion_cabina` varchar(30) NOT NULL,
  `estado_cabina` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `tipo_cabina` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Almacena el nombre de la cabina y actualizará el estado de ocupado a vacio.';

--
-- Dumping data for table `cabina`
--

INSERT INTO `cabina` (`cabina_id`, `descripcion_cabina`, `estado_cabina`, `precio`, `tipo_cabina`) VALUES
(1, 'MalBicho', 'Libre', 10000, 'Sencilla'),
(2, 'Johns', 'Libre', 15000, 'Doble'),
(3, 'Thomas', 'Libre', 10000, 'Sencilla'),
(4, 'Compton', 'Libre', 10000, 'Sencilla'),
(5, 'Evans', 'Libre', 15000, 'Doble'),
(6, 'Hogan', 'Libre', 10000, 'Sencilla'),
(7, 'Moses', 'Libre', 15000, 'Doble'),
(8, 'Jacobs', 'Libre', 10000, 'Sencilla'),
(9, 'Kerr', 'Libre', 10000, 'Sencilla'),
(10, 'Obrien', 'Libre', 15000, 'Doble'),
(11, 'Duke', 'Libre', 15000, 'Doble'),
(12, 'Cain', 'Libre', 10000, 'Sencilla'),
(13, 'Neal', 'Libre', 15000, 'Doble'),
(14, 'Mcdonald', 'Libre', 15000, 'Doble'),
(15, 'Chandler', 'Libre', 15000, 'Doble'),
(16, 'Hull', 'Libre', 15000, 'Doble'),
(17, 'Garner', 'Libre', 15000, 'Doble'),
(18, 'Buckner', 'Libre', 15000, 'Doble'),
(19, 'Holden', 'Bloqueo', 15000, 'Doble'),
(20, 'Adkins', 'Libre', 10000, 'Sencilla'),
(21, 'Mcgowan', 'Libre', 10000, 'Sencilla'),
(22, 'Campos', 'Libre', 10000, 'Sencilla'),
(23, 'Phillips', 'Libre', 10000, 'Sencilla'),
(24, 'Adams', 'Libre', 10000, 'Sencilla'),
(25, 'Stark', 'Libre', 10000, 'Sencilla'),
(26, 'Hurst', 'Libre', 15000, 'Doble'),
(27, 'Gay', 'Limpieza', 15000, 'Doble'),
(28, 'Watkins', 'Libre', 10000, 'Sencilla'),
(29, 'Middleton', 'Libre', 10000, 'Sencilla'),
(30, 'Vincent', 'Libre', 15000, 'Doble'),
(31, 'Santa', 'Libre', 10000, 'Sencilla'),
(32, 'Maria', 'Libre', 10000, 'Sencilla'),
(33, 'Marca', 'Libre', 10000, 'Sencilla'),
(34, 'Hola', 'Libre', 10000, 'Sencilla'),
(35, 'Marta', 'Libre', 15000, 'Doble');

-- --------------------------------------------------------

--
-- Table structure for table `cliente_empresa`
--

CREATE TABLE `cliente_empresa` (
  `empresa_id` bigint(20) NOT NULL,
  `nombre_empresa` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente_empresa`
--

INSERT INTO `cliente_empresa` (`empresa_id`, `nombre_empresa`) VALUES
(1, 'Elit Ltd'),
(2, 'Dignissim Tempor Arcu Incorporated'),
(3, 'Ligula Limited'),
(4, 'Et Tristique Pellentesque Inc.'),
(5, 'Lacinia Mattis Integer Foundation'),
(6, 'Enim PC'),
(7, 'Congue In Scelerisque Corp.'),
(8, 'Dapibus Rutrum Corporation'),
(9, 'Etiam Gravida PC'),
(10, 'Sagittis Felis Donec Limited'),
(11, 'Id PC'),
(12, 'Sed PC'),
(13, 'At Iaculis Quis Incorporated'),
(14, 'Nec Limited'),
(15, 'Graham Acosta'),
(16, 'Yuli Cruz'),
(17, 'Eagan Armstrong'),
(18, 'Ethan Landry'),
(19, 'Branden Mcclure'),
(20, 'Baxter Workman'),
(21, 'Carl Mills'),
(22, 'Jesse Lewis'),
(23, 'Cooper Ayala'),
(24, 'Asher Albert'),
(25, 'Maxwell Sears'),
(26, 'Alden Holden'),
(27, 'Lionel Chaney'),
(28, 'Merrill Foley'),
(29, 'Tucker Preston'),
(30, 'Rigel Page'),
(31, 'Noah Joyner'),
(32, 'Logan Gardner'),
(33, 'Zephania Wolf'),
(34, 'Valentine Cameron'),
(35, 'Jua'),
(36, 'Maridilia'),
(37, 'Eli'),
(38, 'Eli'),
(39, 'Marta'),
(40, 'Eli'),
(41, 'Hellen Maria'),
(42, 'Eisner Lopez'),
(43, 'Eisner Lopez'),
(44, 'Jason Momoa'),
(45, 'Marcos'),
(46, 'Mark'),
(47, 'Mark'),
(48, 'Edell'),
(49, 'Luis'),
(50, 'Luis'),
(51, 'Marco'),
(52, 'Eisner'),
(53, 'MalParido'),
(54, 'MalParido');

-- --------------------------------------------------------

--
-- Table structure for table `colaborador`
--

CREATE TABLE `colaborador` (
  `empleado_id` bigint(20) NOT NULL,
  `fecha_contrato` date NOT NULL,
  `fecha_despido` date DEFAULT NULL,
  `observaciones` varchar(45) DEFAULT NULL,
  `persona_idpersona` int(11) NOT NULL,
  `puesto_puesto_id` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `colaborador`
--

INSERT INTO `colaborador` (`empleado_id`, `fecha_contrato`, `fecha_despido`, `observaciones`, `persona_idpersona`, `puesto_puesto_id`) VALUES
(1, '2017-02-23', NULL, NULL, 1, 0),
(2, '2007-02-08', NULL, NULL, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `dato_empresa`
--

CREATE TABLE `dato_empresa` (
  `iddato_empresa` int(11) NOT NULL,
  `empresa_propietario` varchar(45) NOT NULL,
  `empresa_nombre` varchar(45) NOT NULL,
  `empresa_sa` varchar(45) NOT NULL,
  `empresa_cedula_juridica` varchar(45) NOT NULL,
  `empresa_telefono1` varchar(45) NOT NULL,
  `empresa_direccion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dato_empresa`
--

INSERT INTO `dato_empresa` (`iddato_empresa`, `empresa_propietario`, `empresa_nombre`, `empresa_sa`, `empresa_cedula_juridica`, `empresa_telefono1`, `empresa_direccion`) VALUES
(1, 'Cesar Gonzalez', 'Cabinas el Tropico', 'Cabinas el Tropico', '111111212121121', '21212121', 'Guatuso');

-- --------------------------------------------------------

--
-- Table structure for table `factura_cabina`
--

CREATE TABLE `factura_cabina` (
  `factura_id` bigint(20) NOT NULL,
  `cant_dia` tinyint(4) NOT NULL,
  `fecha` date NOT NULL,
  `impuesto_cabina` float NOT NULL,
  `precio_total_cabina` bigint(20) NOT NULL,
  `cabina_cabina_id` smallint(6) NOT NULL,
  `dato_empresa_iddato_empresa` int(11) NOT NULL,
  `cliente_empresa_empresa_id` bigint(20) NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `factura_cabina`
--

INSERT INTO `factura_cabina` (`factura_id`, `cant_dia`, `fecha`, `impuesto_cabina`, `precio_total_cabina`, `cabina_cabina_id`, `dato_empresa_iddato_empresa`, `cliente_empresa_empresa_id`, `colaborador_empleado_id`) VALUES
(1, 1, '2017-02-01', 1300, 10000, 9, 1, 1, 1),
(2, 2, '2017-03-01', 1300, 10000, 9, 1, 2, 1),
(3, 3, '2017-03-04', 3900, 30000, 28, 1, 46, 1),
(4, 2, '2017-03-04', 2600, 20000, 28, 1, 46, 1),
(5, 3, '2017-03-04', 3900, 30000, 28, 1, 46, 1),
(6, 3, '2017-03-04', 3900, 30000, 3, 1, 46, 1),
(7, 3, '2017-03-04', 3900, 30000, 3, 1, 46, 1),
(8, 30, '2017-03-04', 195000, 1500000, 3, 1, 46, 1),
(9, 2, '2017-03-04', 2600, 20000, 3, 1, 46, 1),
(10, 1, '2017-03-05', 1300, 10000, 3, 1, 48, 1),
(11, 1, '2017-03-05', 2015, 15500, 30, 1, 49, 1),
(12, 15, '2017-03-06', 19500, 150000, 28, 1, 42, 1),
(13, 2, '2017-03-06', 2600, 20000, 28, 1, 48, 1),
(14, 2, '2017-03-06', 2600, 20000, 28, 1, 49, 1),
(15, 15, '2017-03-06', 19500, 150000, 28, 1, 45, 1),
(16, 10, '2017-03-06', 13000, 100000, 24, 1, 53, 1);

-- --------------------------------------------------------

--
-- Table structure for table `gasto_operativo`
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
-- Dumping data for table `gasto_operativo`
--

INSERT INTO `gasto_operativo` (`gasto_id`, `descripcion_gasto`, `monto_gasto`, `fecha_gasto`, `factura_gasto`, `colaborador_empleado_id`) VALUES
(1, '212121', 212121, '2017-02-23', '1200', 1);

-- --------------------------------------------------------

--
-- Table structure for table `horario`
--

CREATE TABLE `horario` (
  `horario_id` bigint(20) NOT NULL,
  `descripcion_horario` varchar(45) NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `inventario`
--

CREATE TABLE `inventario` (
  `inventario_id` int(11) NOT NULL,
  `nombre_inventario_producto` varchar(30) NOT NULL,
  `cant_producto` int(11) NOT NULL,
  `fecha_compra_producto` date NOT NULL,
  `proveedor_proveedor_id` bigint(20) UNSIGNED NOT NULL,
  `productos_idproductos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `marcas`
--

CREATE TABLE `marcas` (
  `idmarcas` int(11) NOT NULL,
  `hora_entrada` time NOT NULL,
  `hora_salild` time NOT NULL,
  `fecha` date NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `cedula` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `tipo_persona_idtipo_persona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`idpersona`, `nombre`, `cedula`, `telefono`, `direccion`, `tipo_persona_idtipo_persona`) VALUES
(1, 'Eisner Lopez', '84484', '84484', '84484', 3),
(2, 'Edell Madrigal', '8448484', '84484121', '844842121', 1),
(3, 'Jessica Gonzalez', '748484', '84484212', '84484121', 2),
(4, 'Marcos', '212121', '89564976', '5454545', 3),
(5, 'Edell Madrigal', '200250021', '', 'San Carlos', 3);

-- --------------------------------------------------------

--
-- Table structure for table `planilla`
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
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `idproductos` int(11) NOT NULL,
  `monto_producto` varchar(45) DEFAULT NULL,
  `nombre_producto` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `proveedor_idproveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL,
  `desc_proveedor` varchar(45) DEFAULT NULL,
  `persona_idpersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `puesto`
--

CREATE TABLE `puesto` (
  `puesto_id` bigint(20) UNSIGNED NOT NULL,
  `descripcion_puesto` varchar(30) NOT NULL,
  `pago_hora_sencilla` float NOT NULL,
  `pago_hora_extra` float NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Testing`
--

CREATE TABLE `Testing` (
  `Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Testing`
--

INSERT INTO `Testing` (`Id`) VALUES
(2),
(4),
(6),
(8),
(10),
(12),
(14),
(16),
(18),
(20),
(22),
(24),
(26),
(28),
(30),
(32),
(34),
(36),
(38),
(40),
(42),
(44),
(46),
(48),
(50),
(52),
(54),
(56),
(58),
(60),
(62),
(64),
(66),
(68),
(70),
(72),
(74),
(76),
(78),
(80),
(82),
(84),
(86),
(88),
(90),
(92),
(94),
(96),
(98),
(100),
(102),
(104),
(106),
(108),
(110),
(112),
(114),
(116),
(118),
(120),
(122),
(124),
(126),
(128),
(130),
(132),
(134),
(136),
(138),
(140),
(142),
(144),
(146),
(148),
(150),
(152),
(154),
(156),
(158),
(160),
(162),
(164),
(166),
(168),
(170),
(172),
(174),
(176),
(178),
(180),
(182),
(184),
(186),
(188),
(190),
(192),
(194),
(196),
(198),
(200),
(202),
(204),
(206),
(208),
(210),
(212),
(214),
(216),
(218),
(220),
(222),
(224),
(226),
(228),
(230),
(232),
(234),
(236),
(238),
(240),
(242),
(244),
(246),
(248),
(250),
(252),
(254),
(256),
(258),
(260),
(262),
(264),
(266),
(268),
(270),
(272),
(274),
(276),
(278),
(280),
(282),
(284),
(286),
(288),
(290),
(292),
(294),
(296),
(298),
(300),
(302),
(304),
(306),
(308),
(310),
(312),
(314),
(316),
(318),
(320),
(322),
(324),
(326),
(328),
(330),
(332),
(334),
(336),
(338),
(340),
(342),
(344),
(346),
(348),
(350),
(352),
(354),
(356),
(358),
(360),
(362),
(364),
(366),
(368),
(370),
(372),
(374),
(376),
(378),
(380),
(382),
(384),
(386),
(388),
(390),
(392),
(394),
(396),
(398),
(400),
(402),
(404),
(406),
(408),
(410),
(412),
(414),
(416),
(418),
(420),
(422),
(424),
(426),
(428),
(430),
(432),
(434),
(436),
(438),
(440),
(442),
(444),
(446),
(448),
(450),
(452),
(454),
(456),
(458),
(460),
(462),
(464),
(466),
(468),
(470),
(472),
(474),
(476),
(478),
(480),
(482),
(484),
(486),
(488),
(490),
(492),
(494),
(496),
(498),
(500),
(502),
(504),
(506),
(508),
(510),
(512),
(514),
(516),
(518),
(520),
(522),
(524),
(526),
(528),
(530),
(532),
(534),
(536),
(538),
(540),
(542),
(544),
(546),
(548),
(550),
(552),
(554),
(556),
(558),
(560),
(562),
(564),
(566),
(568),
(570),
(572),
(574),
(576),
(578),
(580),
(582),
(584),
(586),
(588),
(590),
(592),
(594),
(596),
(598),
(600),
(602),
(604),
(606),
(608),
(610),
(612),
(614),
(616),
(618),
(620),
(622),
(624),
(626),
(628),
(630),
(632),
(634),
(636),
(638),
(640),
(642),
(644),
(646),
(648),
(650),
(652),
(654),
(656),
(658),
(660),
(662),
(664),
(666),
(668),
(670),
(672),
(674),
(676),
(678),
(680),
(682),
(684),
(686),
(688),
(690),
(692),
(694),
(696),
(698),
(700),
(702),
(704),
(706),
(708),
(710),
(712),
(714),
(716),
(718),
(720),
(722),
(724),
(726),
(728),
(730),
(732),
(734),
(736),
(738),
(740),
(742),
(744),
(746),
(748),
(750),
(752),
(754),
(756),
(758),
(760),
(762),
(764),
(766),
(768),
(770),
(772),
(774),
(776),
(778),
(780),
(782),
(784),
(786),
(788),
(790),
(792),
(794),
(796),
(798),
(800),
(802),
(804),
(806),
(808),
(810),
(812),
(814),
(816),
(818),
(820),
(822),
(824),
(826),
(828),
(830),
(832),
(834),
(836),
(838),
(840),
(842),
(844),
(846),
(848),
(850),
(852),
(854),
(856),
(858),
(860),
(862),
(864),
(866),
(868),
(870),
(872),
(874),
(876),
(878),
(880),
(882),
(884),
(886),
(888),
(890),
(892),
(894),
(896),
(898),
(900),
(902),
(904),
(906),
(908),
(910),
(912),
(914),
(916),
(918),
(920),
(922),
(924),
(926),
(928),
(930),
(932),
(934),
(936),
(938),
(940),
(942),
(944),
(946),
(948),
(950),
(952),
(954),
(956),
(958),
(960),
(962),
(964),
(966),
(968),
(970),
(972),
(974),
(976),
(978),
(980),
(982),
(984),
(986),
(988),
(990),
(992),
(994),
(996),
(998),
(1000),
(1002),
(1004),
(1006),
(1008),
(1010),
(1012),
(1014),
(1016),
(1018),
(1020),
(1022),
(1024),
(1026),
(1028),
(1030),
(1032),
(1034),
(1036),
(1038),
(1040),
(1042),
(1044),
(1046),
(1048),
(1050),
(1052),
(1054),
(1056),
(1058),
(1060),
(1062),
(1064),
(1066),
(1068),
(1070),
(1072),
(1074),
(1076),
(1078),
(1080),
(1082),
(1084),
(1086),
(1088),
(1090),
(1092),
(1094),
(1096),
(1098),
(1100),
(1102),
(1104),
(1106),
(1108),
(1110),
(1112),
(1114),
(1116),
(1118),
(1120),
(1122),
(1124),
(1126),
(1128),
(1130),
(1132),
(1134),
(1136),
(1138),
(1140),
(1142),
(1144),
(1146),
(1148),
(1150),
(1152),
(1154),
(1156),
(1158),
(1160),
(1162),
(1164),
(1166),
(1168),
(1170),
(1172),
(1174),
(1176),
(1178),
(1180),
(1182),
(1184),
(1186),
(1188),
(1190),
(1192),
(1194),
(1196),
(1198),
(1200),
(1202),
(1204),
(1206),
(1208),
(1210),
(1212),
(1214),
(1216),
(1218),
(1220),
(1222),
(1224),
(1226),
(1228),
(1230),
(1232),
(1234),
(1236),
(1238),
(1240),
(1242),
(1244),
(1246),
(1248),
(1250),
(1252),
(1254),
(1256),
(1258),
(1260),
(1262),
(1264),
(1266),
(1268),
(1270),
(1272),
(1274),
(1276),
(1278),
(1280),
(1282),
(1284),
(1286),
(1288),
(1290),
(1292),
(1294),
(1296),
(1298),
(1300),
(1302),
(1304),
(1306),
(1308),
(1310),
(1312),
(1314),
(1316),
(1318),
(1320),
(1322),
(1324),
(1326),
(1328),
(1330),
(1332),
(1334),
(1336),
(1338),
(1340),
(1342),
(1344),
(1346),
(1348),
(1350),
(1352),
(1354),
(1356),
(1358),
(1360),
(1362),
(1364),
(1366),
(1368),
(1370),
(1372),
(1374),
(1376),
(1378),
(1380),
(1382),
(1384),
(1386),
(1388),
(1390),
(1392),
(1394),
(1396),
(1398),
(1400),
(1402),
(1404),
(1406),
(1408),
(1410),
(1412),
(1414),
(1416),
(1418),
(1420),
(1422),
(1424),
(1426),
(1428),
(1430),
(1432),
(1434),
(1436),
(1438),
(1440),
(1442),
(1444),
(1446),
(1448),
(1450),
(1452),
(1454),
(1456),
(1458),
(1460),
(1462),
(1464),
(1466),
(1468),
(1470),
(1472),
(1474),
(1476),
(1478),
(1480),
(1482),
(1484),
(1486),
(1488),
(1490),
(1492),
(1494),
(1496),
(1498),
(1500),
(1502),
(1504),
(1506),
(1508),
(1510),
(1512),
(1514),
(1516),
(1518),
(1520),
(1522),
(1524),
(1526),
(1528),
(1530),
(1532),
(1534),
(1536),
(1538),
(1540),
(1542),
(1544),
(1546),
(1548),
(1550),
(1552),
(1554),
(1556),
(1558),
(1560),
(1562),
(1564),
(1566),
(1568),
(1570),
(1572),
(1574),
(1576),
(1578),
(1580),
(1582),
(1584),
(1586),
(1588),
(1590),
(1592),
(1594),
(1596),
(1598),
(1600),
(1602),
(1604),
(1606),
(1608),
(1610),
(1612),
(1614),
(1616),
(1618),
(1620),
(1622),
(1624),
(1626),
(1628),
(1630),
(1632),
(1634),
(1636),
(1638),
(1640),
(1642),
(1644),
(1646),
(1648),
(1650),
(1652),
(1654),
(1656),
(1658),
(1660),
(1662),
(1664),
(1666),
(1668),
(1670),
(1672),
(1674),
(1676),
(1678),
(1680),
(1682),
(1684),
(1686),
(1688),
(1690),
(1692),
(1694),
(1696),
(1698),
(1700),
(1702),
(1704),
(1706),
(1708),
(1710),
(1712),
(1714),
(1716),
(1718),
(1720),
(1722),
(1724),
(1726),
(1728),
(1730),
(1732),
(1734),
(1736),
(1738),
(1740),
(1742),
(1744),
(1746),
(1748),
(1750),
(1752),
(1754),
(1756),
(1758),
(1760),
(1762),
(1764),
(1766),
(1768),
(1770),
(1772),
(1774),
(1776),
(1778),
(1780),
(1782),
(1784),
(1786),
(1788),
(1790),
(1792),
(1794),
(1796),
(1798),
(1800),
(1802),
(1804),
(1806),
(1808),
(1810),
(1812),
(1814),
(1816),
(1818),
(1820),
(1822),
(1824),
(1826),
(1828),
(1830),
(1832),
(1834),
(1836),
(1838),
(1840),
(1842),
(1844),
(1846),
(1848),
(1850),
(1852),
(1854),
(1856),
(1858),
(1860),
(1862),
(1864),
(1866),
(1868),
(1870),
(1872),
(1874),
(1876),
(1878),
(1880),
(1882),
(1884),
(1886),
(1888),
(1890),
(1892),
(1894),
(1896),
(1898),
(1900),
(1902),
(1904),
(1906),
(1908),
(1910),
(1912),
(1914),
(1916),
(1918),
(1920),
(1922),
(1924),
(1926),
(1928),
(1930),
(1932),
(1934),
(1936),
(1938),
(1940),
(1942),
(1944),
(1946),
(1948),
(1950),
(1952),
(1954),
(1956),
(1958),
(1960),
(1962),
(1964),
(1966),
(1968),
(1970),
(1972),
(1974),
(1976),
(1978),
(1980),
(1982),
(1984),
(1986),
(1988),
(1990),
(1992),
(1994),
(1996),
(1998),
(2000);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_persona`
--

CREATE TABLE `tipo_persona` (
  `idtipo_persona` int(11) NOT NULL,
  `desc_persona` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_persona`
--

INSERT INTO `tipo_persona` (`idtipo_persona`, `desc_persona`) VALUES
(1, 'Cliente'),
(2, 'Proveedor'),
(3, 'Empleado');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `colaborador_empleado_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`idusuario`, `usuario`, `password`, `colaborador_empleado_id`) VALUES
(1, 'admin', 'admin', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cabina`
--
ALTER TABLE `cabina`
  ADD PRIMARY KEY (`cabina_id`),
  ADD UNIQUE KEY `descripcion_cabina_UNIQUE` (`descripcion_cabina`);

--
-- Indexes for table `cliente_empresa`
--
ALTER TABLE `cliente_empresa`
  ADD PRIMARY KEY (`empresa_id`);

--
-- Indexes for table `colaborador`
--
ALTER TABLE `colaborador`
  ADD PRIMARY KEY (`empleado_id`),
  ADD KEY `fk_colaborador_persona_idx` (`persona_idpersona`),
  ADD KEY `fk_colaborador_puesto1_idx` (`puesto_puesto_id`);

--
-- Indexes for table `dato_empresa`
--
ALTER TABLE `dato_empresa`
  ADD PRIMARY KEY (`iddato_empresa`);

--
-- Indexes for table `factura_cabina`
--
ALTER TABLE `factura_cabina`
  ADD PRIMARY KEY (`factura_id`),
  ADD KEY `fk_factura_cabina_cabina1_idx` (`cabina_cabina_id`),
  ADD KEY `fk_factura_cabina_dato_empresa1_idx` (`dato_empresa_iddato_empresa`),
  ADD KEY `fk_factura_cabina_cliente_empresa1_idx` (`cliente_empresa_empresa_id`),
  ADD KEY `fk_factura_cabina_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indexes for table `gasto_operativo`
--
ALTER TABLE `gasto_operativo`
  ADD PRIMARY KEY (`gasto_id`),
  ADD KEY `fk_gasto_operativo_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indexes for table `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`horario_id`),
  ADD KEY `fk_horario_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indexes for table `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`inventario_id`),
  ADD KEY `fk_inventario_productos1_idx` (`productos_idproductos`);

--
-- Indexes for table `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`idmarcas`),
  ADD KEY `fk_marcas_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`),
  ADD KEY `fk_persona_tipo_persona1_idx` (`tipo_persona_idtipo_persona`);

--
-- Indexes for table `planilla`
--
ALTER TABLE `planilla`
  ADD PRIMARY KEY (`planilla_id`),
  ADD KEY `fk_planilla_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idproductos`),
  ADD KEY `fk_productos_proveedor1_idx` (`proveedor_idproveedor`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idproveedor`),
  ADD KEY `fk_proveedor_persona1_idx` (`persona_idpersona`);

--
-- Indexes for table `puesto`
--
ALTER TABLE `puesto`
  ADD PRIMARY KEY (`puesto_id`),
  ADD KEY `fk_puesto_colaborador1_idx` (`colaborador_empleado_id`);

--
-- Indexes for table `Testing`
--
ALTER TABLE `Testing`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tipo_persona`
--
ALTER TABLE `tipo_persona`
  ADD PRIMARY KEY (`idtipo_persona`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD KEY `fk_usuario_colaborador1_idx` (`colaborador_empleado_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cabina`
--
ALTER TABLE `cabina`
  MODIFY `cabina_id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `cliente_empresa`
--
ALTER TABLE `cliente_empresa`
  MODIFY `empresa_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT for table `colaborador`
--
ALTER TABLE `colaborador`
  MODIFY `empleado_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `dato_empresa`
--
ALTER TABLE `dato_empresa`
  MODIFY `iddato_empresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `factura_cabina`
--
ALTER TABLE `factura_cabina`
  MODIFY `factura_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `gasto_operativo`
--
ALTER TABLE `gasto_operativo`
  MODIFY `gasto_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `horario`
--
ALTER TABLE `horario`
  MODIFY `horario_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `inventario`
--
ALTER TABLE `inventario`
  MODIFY `inventario_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `marcas`
--
ALTER TABLE `marcas`
  MODIFY `idmarcas` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `planilla`
--
ALTER TABLE `planilla`
  MODIFY `planilla_id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `productos`
--
ALTER TABLE `productos`
  MODIFY `idproductos` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idproveedor` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `puesto`
--
ALTER TABLE `puesto`
  MODIFY `puesto_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tipo_persona`
--
ALTER TABLE `tipo_persona`
  MODIFY `idtipo_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `colaborador`
--
ALTER TABLE `colaborador`
  ADD CONSTRAINT `fk_colaborador_persona` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `factura_cabina`
--
ALTER TABLE `factura_cabina`
  ADD CONSTRAINT `fk_factura_cabina_cabina1` FOREIGN KEY (`cabina_cabina_id`) REFERENCES `cabina` (`cabina_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_cabina_cliente_empresa1` FOREIGN KEY (`cliente_empresa_empresa_id`) REFERENCES `cliente_empresa` (`empresa_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_cabina_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_factura_cabina_dato_empresa1` FOREIGN KEY (`dato_empresa_iddato_empresa`) REFERENCES `dato_empresa` (`iddato_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `gasto_operativo`
--
ALTER TABLE `gasto_operativo`
  ADD CONSTRAINT `fk_gasto_operativo_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `fk_horario_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `fk_inventario_productos1` FOREIGN KEY (`productos_idproductos`) REFERENCES `productos` (`idproductos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `marcas`
--
ALTER TABLE `marcas`
  ADD CONSTRAINT `fk_marcas_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_persona_tipo_persona1` FOREIGN KEY (`tipo_persona_idtipo_persona`) REFERENCES `tipo_persona` (`idtipo_persona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `planilla`
--
ALTER TABLE `planilla`
  ADD CONSTRAINT `fk_planilla_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_productos_proveedor1` FOREIGN KEY (`proveedor_idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `fk_proveedor_persona1` FOREIGN KEY (`persona_idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `puesto`
--
ALTER TABLE `puesto`
  ADD CONSTRAINT `puesto_ibfk_1` FOREIGN KEY (`puesto_id`) REFERENCES `colaborador` (`puesto_puesto_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_colaborador1` FOREIGN KEY (`colaborador_empleado_id`) REFERENCES `colaborador` (`empleado_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
