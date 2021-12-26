-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2021 at 01:57 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_mngmt_albums`
--

-- --------------------------------------------------------

--
-- Table structure for table `actors`
--

CREATE TABLE `actors` (
  `id` bigint(20) NOT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `actors`
--

INSERT INTO `actors` (`id`, `birth_date`, `first_name`, `last_name`) VALUES
(1, '10-Jan-1952', 'John', 'Doe'),
(2, '05-07-1985', 'Amy', 'Eugene'),
(3, '11-12-1988', 'Laverne', 'Mann'),
(4, '19-02-1960', 'Janice', 'Preston'),
(5, '29-08-1977', 'Pauline', 'Rios');

-- --------------------------------------------------------

--
-- Table structure for table `actor_album`
--

CREATE TABLE `actor_album` (
  `actor_id` bigint(20) NOT NULL,
  `album_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `actor_album`
--

INSERT INTO `actor_album` (`actor_id`, `album_id`) VALUES
(1, 24),
(1, 33),
(2, 25),
(2, 26),
(3, 24),
(3, 25),
(4, 28),
(4, 27),
(5, 33),
(5, 24);

-- --------------------------------------------------------

--
-- Table structure for table `albums`
--

CREATE TABLE `albums` (
  `id` bigint(20) NOT NULL,
  `date_release` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `albums`
--

INSERT INTO `albums` (`id`, `date_release`, `description`, `title`) VALUES
(24, '10-03-1981', 'Top hits vol 1. description', 'Top Hits Vol 1'),
(25, '10-03-1982', 'Top hits vol 2. description', 'Top Hits Vol 2'),
(26, '10-03-1983', 'Top hits vol 3. description', 'Top Hits Vol 3'),
(27, '10-03-1984', 'Top hits vol 4. description', 'Top Hits Vol 4'),
(28, '10-03-1985', 'Top hits vol 5. description', 'Top Hits Vol 5'),
(29, '10-03-1986', 'Top hits vol 6. description', 'Top Hits Vol 6'),
(30, '10-03-1987', 'Top hits vol 7. description', 'Top Hits Vol 7'),
(31, '10-03-1988', 'Top hits vol 8. description', 'Top Hits Vol 8'),
(32, '10-03-1989', 'Top hits vol 9. description', 'Top Hits Vol 9'),
(33, '10-03-1990', 'Top hits vol 10. description', 'Top Hits Vol 10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actors`
--
ALTER TABLE `actors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `actor_album`
--
ALTER TABLE `actor_album`
  ADD KEY `FKls7etsu3k9gyo56ecs25ih3sy` (`album_id`),
  ADD KEY `FKcigqdpyjreahi0wbdv2uhjx2k` (`actor_id`);

--
-- Indexes for table `albums`
--
ALTER TABLE `albums`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actors`
--
ALTER TABLE `actors`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `albums`
--
ALTER TABLE `albums`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `actor_album`
--
ALTER TABLE `actor_album`
  ADD CONSTRAINT `FKcigqdpyjreahi0wbdv2uhjx2k` FOREIGN KEY (`actor_id`) REFERENCES `actors` (`id`),
  ADD CONSTRAINT `FKls7etsu3k9gyo56ecs25ih3sy` FOREIGN KEY (`album_id`) REFERENCES `albums` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
