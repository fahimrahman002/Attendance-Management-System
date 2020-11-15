-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2020 at 05:03 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `attendance_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_data`
--

CREATE TABLE `admin_data` (
  `name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_data`
--

INSERT INTO `admin_data` (`name`, `username`, `pass`, `email`, `phone`) VALUES
('Fahim ', 'admin', '1234', 'admin23@gmail.com', '0161589913');

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` varchar(20) NOT NULL,
  `month` int(11) NOT NULL,
  `D1` tinyint(1) NOT NULL DEFAULT 0,
  `D2` tinyint(1) NOT NULL DEFAULT 0,
  `D3` tinyint(1) NOT NULL DEFAULT 0,
  `D4` tinyint(1) NOT NULL DEFAULT 0,
  `D5` tinyint(1) NOT NULL DEFAULT 0,
  `D6` tinyint(1) NOT NULL DEFAULT 0,
  `D7` tinyint(1) NOT NULL DEFAULT 0,
  `D8` tinyint(1) NOT NULL DEFAULT 0,
  `D9` tinyint(1) NOT NULL DEFAULT 0,
  `D10` tinyint(1) NOT NULL DEFAULT 0,
  `D11` tinyint(1) NOT NULL DEFAULT 0,
  `D12` tinyint(1) NOT NULL DEFAULT 0,
  `D13` tinyint(1) NOT NULL DEFAULT 0,
  `D14` tinyint(1) NOT NULL DEFAULT 0,
  `D15` tinyint(1) NOT NULL DEFAULT 0,
  `D16` tinyint(1) NOT NULL DEFAULT 0,
  `D17` tinyint(1) NOT NULL DEFAULT 0,
  `D18` tinyint(1) NOT NULL DEFAULT 0,
  `D19` tinyint(1) NOT NULL DEFAULT 0,
  `D20` tinyint(1) NOT NULL DEFAULT 0,
  `D21` tinyint(1) NOT NULL DEFAULT 0,
  `D22` tinyint(1) NOT NULL DEFAULT 0,
  `D23` tinyint(1) NOT NULL DEFAULT 0,
  `D24` tinyint(1) NOT NULL DEFAULT 0,
  `D25` tinyint(1) NOT NULL DEFAULT 0,
  `D26` tinyint(1) NOT NULL DEFAULT 0,
  `D27` tinyint(1) NOT NULL DEFAULT 0,
  `D28` tinyint(1) NOT NULL DEFAULT 0,
  `D29` tinyint(1) NOT NULL DEFAULT 0,
  `D30` tinyint(1) NOT NULL DEFAULT 0,
  `D31` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `month`, `D1`, `D2`, `D3`, `D4`, `D5`, `D6`, `D7`, `D8`, `D9`, `D10`, `D11`, `D12`, `D13`, `D14`, `D15`, `D16`, `D17`, `D18`, `D19`, `D20`, `D21`, `D22`, `D23`, `D24`, `D25`, `D26`, `D27`, `D28`, `D29`, `D30`, `D31`) VALUES
('100.10', 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
('100.10', 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student_data`
--

CREATE TABLE `student_data` (
  `id` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `address` text DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `blood_group` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_data`
--

INSERT INTO `student_data` (`id`, `pass`, `name`, `email`, `address`, `phone`, `blood_group`) VALUES
('100.10', '1234', 'Fahim', 'fahim@gmail.com', 'alsedodh	', '02734', 'B+');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_data`
--
ALTER TABLE `admin_data`
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `student_data`
--
ALTER TABLE `student_data`
  ADD UNIQUE KEY `id` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
