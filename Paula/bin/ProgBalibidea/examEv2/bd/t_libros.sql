-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-01-2023 a las 19:10:19
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `exameneval2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_libros`
--

CREATE TABLE `t_libros` (
  `id` int(11) NOT NULL,
  `titulo` varchar(20) DEFAULT NULL,
  `autor` varchar(20) DEFAULT NULL,
  `editorial` varchar(20) DEFAULT NULL,
  `fechaPublicacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `t_libros`
--

INSERT INTO `t_libros` (`id`, `titulo`, `autor`, `editorial`, `fechaPublicacion`) VALUES
(1, 'Programacion en Java', 'Juan Torres', 'Elorrieta', '2020-01-01'),
(2, 'SQL y las BBDD', 'Ana Perez', 'Bilbao Editorial', '2019-01-01'),
(3, 'Entornos Desarrollo', 'Kepa Ortiz', 'Elorrieta', '2023-01-01'),
(4, 'Java Avanzado', 'Juan Torres', 'Elorrieta', '2022-01-01');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `t_libros`
--
ALTER TABLE `t_libros`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `t_libros`
--
ALTER TABLE `t_libros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
