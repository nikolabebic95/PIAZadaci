-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2017 at 01:40 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `skiskolica2017`
--
CREATE DATABASE IF NOT EXISTS `skiskolica2017` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `skiskolica2017`;

-- --------------------------------------------------------

--
-- Table structure for table `iznajmljivanje`
--

DROP TABLE IF EXISTS `iznajmljivanje`;
CREATE TABLE IF NOT EXISTS `iznajmljivanje` (
  `idracun` int(11) NOT NULL AUTO_INCREMENT,
  `datumpreuz` date NOT NULL,
  `idkorisnik` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `idopreme` int(11) NOT NULL,
  `imapopust` tinyint(1) NOT NULL,
  `razduzeno` tinyint(1) NOT NULL,
  `ukupno_naplata` double DEFAULT NULL,
  `planiranovracanje` date NOT NULL,
  `depozit` int(20) NOT NULL,
  PRIMARY KEY (`idracun`),
  KEY `idkorisnik` (`idkorisnik`,`idopreme`),
  KEY `idopreme` (`idopreme`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=11 ;

--
-- Dumping data for table `iznajmljivanje`
--

INSERT INTO `iznajmljivanje` (`idracun`, `datumpreuz`, `idkorisnik`, `idopreme`, `imapopust`, `razduzeno`, `ukupno_naplata`, `planiranovracanje`, `depozit`) VALUES
(1, '2017-02-01', 'sanja', 4, 1, 1, 7200, '2017-02-08', 2160),
(2, '2017-02-01', 'sanja', 7, 1, 1, 4000, '2017-02-08', 1200),
(3, '2017-02-01', 'sanja', 11, 1, 1, 1200, '2017-02-08', 360),
(4, '2017-02-03', 'kaca', 1, 0, 0, NULL, '2017-02-10', 2100),
(5, '2017-02-03', 'kaca', 8, 0, 0, NULL, '2017-02-10', 1800),
(6, '2017-02-06', 'maja', 2, 1, 0, NULL, '2017-02-10', 1200),
(7, '2017-02-06', 'maja', 9, 1, 0, NULL, '2017-02-10', 300),
(8, '2017-02-06', 'maja', 11, 1, 0, NULL, '2017-02-10', 225),
(9, '2017-02-06', 'neca', 6, 0, 0, NULL, '2017-02-10', 630),
(10, '2017-02-08', 'sasa', 14, 0, 0, NULL, '2017-02-19', 288);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
CREATE TABLE IF NOT EXISTS `korisnik` (
  `username` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `ime` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `god_skijanja` int(11) NOT NULL,
  `zelim_casove` tinyint(1) NOT NULL,
  `je_instruktor` tinyint(4) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`username`, `password`, `ime`, `prezime`, `god_skijanja`, `zelim_casove`, `je_instruktor`) VALUES
('drasko', 'sifra123', 'Drazen', 'Draskovic', 7, 0, 1),
('kaca', 'sifra123', 'Katarina', 'Milenkovic', 2, 1, 0),
('maja', 'sifra123', 'Maja', 'Vukasovic', 0, 1, 0),
('neca', 'sifra123', 'Nemanja', 'Kojic', 3, 0, 0),
('sanja', 'sifra123', 'Sanja', 'Delcev', 0, 1, 0),
('sasa', 'sifra123', 'Sasa', 'Stojanovic', 2, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `skioprema`
--

DROP TABLE IF EXISTS `skioprema`;
CREATE TABLE IF NOT EXISTS `skioprema` (
  `idopreme` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `vrsta` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `kolicina` int(11) NOT NULL,
  `velicina` double DEFAULT NULL,
  `cenapodanu` double NOT NULL,
  PRIMARY KEY (`idopreme`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=15 ;

--
-- Dumping data for table `skioprema`
--

INSERT INTO `skioprema` (`idopreme`, `naziv`, `vrsta`, `kolicina`, `velicina`, `cenapodanu`) VALUES
(1, 'Atomic', 'skije', 12, 140, 700),
(2, 'Elan', 'skije', 15, 150, 800),
(3, 'Nordica', 'skije', 22, 160, 950),
(4, 'Rossignol', 'skije', 16, 165, 900),
(5, 'Atomic ', 'pancerice', 15, 41, 400),
(6, 'Fisher', 'pancerice', 16, 43, 420),
(7, 'Rossignol', 'pancerice', 18, 40, 500),
(8, 'Atomic', 'pancerice', 8, 45, 600),
(9, 'Elan', 'stap', 18, 125, 200),
(10, 'Volkl', 'stap', 25, 135, 180),
(11, 'Rossignol', 'stap', 30, 150, 150),
(12, 'Atomic', 'naocare', 25, NULL, 100),
(13, 'Volkl', 'naocare', 22, NULL, 80),
(14, 'Scott', 'naocare', 25, NULL, 80);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `iznajmljivanje`
--
ALTER TABLE `iznajmljivanje`
  ADD CONSTRAINT `iznajmljivanje_ibfk_1` FOREIGN KEY (`idkorisnik`) REFERENCES `korisnik` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `iznajmljivanje_ibfk_2` FOREIGN KEY (`idopreme`) REFERENCES `skioprema` (`idopreme`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;