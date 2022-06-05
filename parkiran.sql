-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2022 at 01:38 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkiran`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_parkiran`
--

CREATE TABLE `data_parkiran` (
  `NoKendaraan` varchar(10) NOT NULL,
  `JenisKendaraan` varchar(10) NOT NULL,
  `Biaya` int(15) NOT NULL,
  `LamaParkir` int(5) NOT NULL,
  `TotalBiaya` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_parkiran`
--

INSERT INTO `data_parkiran` (`NoKendaraan`, `JenisKendaraan`, `Biaya`, `LamaParkir`, `TotalBiaya`) VALUES
('AB5443FF', 'Mobil', 5000, 2, 10000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_parkiran`
--
ALTER TABLE `data_parkiran`
  ADD PRIMARY KEY (`NoKendaraan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
