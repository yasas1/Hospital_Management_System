-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 05, 2017 at 03:33 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `attNo` int(11) NOT NULL,
  `empID` int(11) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `numofdays` int(5) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`attNo`, `empID`, `status`, `numofdays`, `date`) VALUES
(1, 15, 'dghgdh', 25, '2013-05-16'),
(3, 16, 'dhdhg', 21, '2013-04-18');

-- --------------------------------------------------------

--
-- Table structure for table `consultant`
--

CREATE TABLE `consultant` (
  `empID` int(11) NOT NULL,
  `specialty` varchar(20) DEFAULT NULL,
  `experiences` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consultant`
--

INSERT INTO `consultant` (`empID`, `specialty`, `experiences`) VALUES
(16, 'ggggg', '5 years'),
(23, 'operation', '7 years');

-- --------------------------------------------------------

--
-- Table structure for table `dischargedpatient`
--

CREATE TABLE `dischargedpatient` (
  `patientID` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `admittedDate` date NOT NULL,
  `dischargedDate` date NOT NULL,
  `wardID` int(11) DEFAULT NULL,
  `consultantID` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dischargedpatient`
--

INSERT INTO `dischargedpatient` (`patientID`, `name`, `age`, `address`, `admittedDate`, `dischargedDate`, `wardID`, `consultantID`) VALUES
(4, 'dis1', 4, 'dsgsfghsdf', '2017-05-10', '2017-05-11', 12, 21),
(3, 'yakasss', 3, 'fsgdfhd', '2014-01-13', '2017-07-04', 12, 23),
(2, 'baldla', 2, 'sfgdfh', '2017-05-11', '2017-07-05', 23, 32);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empID` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `contactNo` varchar(15) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empID`, `name`, `gender`, `address`, `contactNo`, `dob`) VALUES
(1, 'yakas', 'Male', 'fghdhgdgh', '42254245452', '2017-05-02'),
(2, 'blaaaaa', 'Male', 'dghhdghdg', '44444444', '2017-05-02'),
(3, 'fsgsfg', 'Female', 'sfgfshgfdsh', '311232442', '2017-05-03'),
(7, 'tttttt', 'Male', 'wawawaaa', '232323232', '2015-04-12'),
(21, 'fyhdfyh', 'Male', 'hgfdgjh', '5635635', '2014-06-09'),
(24, 'maintain1', 'Male', 'No 0000 ojhshgoshogh \nishgfigs', '24224232', '1968-03-12'),
(10, 'mmmmmmmmm', 'Male', 'yyyyyyy', '55555555555', '2013-07-08'),
(15, 'dfdfdf', 'Female', 'dghhdghdgh', '2844222', '2017-05-10'),
(23, 'yakaaasss', 'Male', 'sfgsfgdsfgdshdtedtdgxgxf', '134134143', '1977-04-19'),
(16, 'ghgghdg', 'Male', 'dhdghdgh', '5346356', '2017-05-11');

-- --------------------------------------------------------

--
-- Table structure for table `jundoctor`
--

CREATE TABLE `jundoctor` (
  `empID` int(11) NOT NULL,
  `workfield` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jundoctor`
--

INSERT INTO `jundoctor` (`empID`, `workfield`) VALUES
(15, 'operation');

-- --------------------------------------------------------

--
-- Table structure for table `maintainstaff`
--

CREATE TABLE `maintainstaff` (
  `empID` int(11) NOT NULL,
  `maintainType` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maintainstaff`
--

INSERT INTO `maintainstaff` (`empID`, `maintainType`) VALUES
(24, 'ground');

-- --------------------------------------------------------

--
-- Table structure for table `nurse`
--

CREATE TABLE `nurse` (
  `empID` int(11) NOT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `wardID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nurse`
--

INSERT INTO `nurse` (`empID`, `grade`, `wardID`) VALUES
(8, 'b', 4),
(18, 'B', 34),
(10, 'A', 12),
(12, 'A', 23);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientID` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `contactNo` varchar(15) DEFAULT NULL,
  `recommendation` varchar(20) DEFAULT NULL,
  `admittedDate` date DEFAULT NULL,
  `wardID` int(11) DEFAULT NULL,
  `consultantID` int(11) DEFAULT NULL,
  `jdoctorID` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patienttest`
--

CREATE TABLE `patienttest` (
  `patientID` int(11) NOT NULL,
  `testID` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `result` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patienttest`
--

INSERT INTO `patienttest` (`patientID`, `testID`, `date`, `result`) VALUES
(2, 10, '2015-06-12', 'good'),
(3, 10, '2017-06-13', 'bad'),
(2, 9, '2017-06-21', 'dfgsdgs'),
(3, 6, '2017-05-19', 'fgjhfgjkh'),
(2, 6, '2017-06-21', 'fdfjg');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymentID` int(11) NOT NULL,
  `patientID` int(11) NOT NULL,
  `paymentfor` varchar(30) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `paymethod` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentID`, `patientID`, `paymentfor`, `amount`, `paymethod`, `date`) VALUES
(20, 23, 'ghgd', 34553, 'Credit Card', '2010-06-06'),
(15, 31, 'dfhgdhdgh', 60000, 'Check', '2013-08-15'),
(16, 31, 'sfgsrfg', 50000, 'Debit Card', '2010-06-15'),
(18, 36, 'gddhg', 25425, 'Credit Card', '2017-05-18'),
(21, 46, 'fdhghgd', 4546364, 'Credit Card', '2013-07-09'),
(22, 31, 'fsgsfgfs', 12000, 'Cash', '2017-05-09');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `testID` int(11) NOT NULL,
  `description` varchar(30) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `conditions` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`testID`, `description`, `price`, `conditions`) VALUES
(6, 'aaaaaa', 400000, 'kkkkk'),
(10, 'anemanda', 84784, 'ona ekak'),
(9, 'bl bla bla', 40000, 'age up 24');

-- --------------------------------------------------------

--
-- Table structure for table `treatment`
--

CREATE TABLE `treatment` (
  `treatmentNo` int(11) NOT NULL,
  `patientID` int(11) NOT NULL,
  `reason` varchar(30) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `result` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `treatment`
--

INSERT INTO `treatment` (`treatmentNo`, `patientID`, `reason`, `description`, `result`, `date`) VALUES
(1, 46, 'res', 'des', 'result', '2014-03-15'),
(2, 46, 'res2', 'des2', 'result2', '2014-02-10'),
(3, 47, 'res3', 'des3', 'result3', '2013-01-24'),
(4, 47, 'res4', 'des4', 'result', '2012-12-10'),
(5, 2, 'fgdfg', 'fgdfgd', 'fgfdgbhd', '2008-12-16'),
(6, 3, 'dtytyed', 'tedyety', 'edtydety', '2017-05-03');

-- --------------------------------------------------------

--
-- Table structure for table `ward`
--

CREATE TABLE `ward` (
  `wardID` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `location` varchar(30) DEFAULT NULL,
  `building` varchar(10) DEFAULT NULL,
  `floor` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ward`
--

INSERT INTO `ward` (`wardID`, `name`, `location`, `building`, `floor`) VALUES
(10, 'accident ward ', 'colombo 7', 'A', '3rd floor');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`attNo`,`empID`),
  ADD KEY `empID` (`empID`);

--
-- Indexes for table `consultant`
--
ALTER TABLE `consultant`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `dischargedpatient`
--
ALTER TABLE `dischargedpatient`
  ADD PRIMARY KEY (`patientID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `jundoctor`
--
ALTER TABLE `jundoctor`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `maintainstaff`
--
ALTER TABLE `maintainstaff`
  ADD PRIMARY KEY (`empID`);

--
-- Indexes for table `nurse`
--
ALTER TABLE `nurse`
  ADD PRIMARY KEY (`empID`),
  ADD KEY `wardID` (`wardID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`),
  ADD KEY `wardID` (`wardID`),
  ADD KEY `consultantID` (`consultantID`),
  ADD KEY `jdoctorID` (`jdoctorID`);

--
-- Indexes for table `patienttest`
--
ALTER TABLE `patienttest`
  ADD PRIMARY KEY (`patientID`,`testID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymentID`),
  ADD KEY `patientID` (`patientID`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`testID`);

--
-- Indexes for table `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`treatmentNo`,`patientID`),
  ADD KEY `patientID` (`patientID`);

--
-- Indexes for table `ward`
--
ALTER TABLE `ward`
  ADD PRIMARY KEY (`wardID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `attNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `empID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `paymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
  MODIFY `testID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `treatment`
--
ALTER TABLE `treatment`
  MODIFY `treatmentNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `ward`
--
ALTER TABLE `ward`
  MODIFY `wardID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
