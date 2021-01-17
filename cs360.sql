-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 16 Ιαν 2021 στις 19:44:18
-- Έκδοση διακομιστή: 10.4.17-MariaDB
-- Έκδοση PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `cs360`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `administrative`
--

CREATE TABLE `administrative` (
  `employee_id` varchar(50) NOT NULL,
  `username` varchar(15) NOT NULL,
  `degree_title` varchar(26) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `administrative`
--

INSERT INTO `administrative` (`employee_id`, `username`, `degree_title`) VALUES
('1fe647f8-8772-4ea5-b938-2c206b7266a8', 'admin', 'degree'),
('7d6fea0a-ed6d-408d-8fae-b84f7d5dc5af', 'admin', 'degree'),
('8c61d23a-0cc5-44d8-bab9-723b4e98a6f8', 'admin', 'degree'),
('b4a28645-3df7-41c4-9abc-23e1882ca0a0', 'admin', 'degree'),
('bd88c5d4-aa0b-4112-8e87-7cd1689afe95', 'admin', 'degree');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `assistant_manager`
--

CREATE TABLE `assistant_manager` (
  `employee_id` varchar(50) NOT NULL,
  `username` varchar(15) NOT NULL,
  `degree_title` varchar(26) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `assistant_manager`
--

INSERT INTO `assistant_manager` (`employee_id`, `username`, `degree_title`) VALUES
('16cbd8f6-ff3e-4f8d-9b99-a6308ed487e8', 'as32', 'degree'),
('20eb6de1-d9c0-4780-87ac-9c6ce3166026', 'as5', 'degree'),
('27501040-2d0c-4c9b-8703-2da111b18d66', 'as34', 'degree'),
('3f357b16-ebda-424d-9cc1-1016a1d19af1', 'as44', 'degree'),
('3f975126-d877-42d3-837e-47bf1c8087e8', 'as35', 'degree'),
('4018d73e-0b62-4376-a152-441b3c3648d1', 'as22', 'degree'),
('4c42583b-f4e4-48e3-9a9b-0aa593ca69e3', 'as3', 'degree'),
('50155b3e-2f85-46fa-b0d4-2dcae4cf67b7', 'as12', 'degree'),
('519c7bb3-5abe-4d28-b46c-2427fec4d932', 'as23', 'degree'),
('5b580a96-94ea-415b-b9e7-19e45567b178', 'as24', 'degree'),
('6303b90b-5752-4e5c-bd44-8b46255d0199', 'as25', 'degree'),
('650462d1-ec9f-4774-9dfb-9176f87c35da', 'as42', 'degree'),
('6b620ac4-4ff8-45e5-8f50-404d7032f9e6', 'as2', 'degree'),
('743cc152-68e8-4a90-91a3-17b67a3af91f', 'as15', 'degree'),
('8a38be1e-eb4a-461a-a1f2-524e0b183384', 'as4', 'degree'),
('ab8777a0-549f-4257-8ef3-3556e2d16165', 'as21', 'degree'),
('b56f7d8a-abc9-46cd-b0e6-258867adf860', 'as1', 'degree'),
('c281e873-a03c-497d-a0c6-2bb688f73089', 'as13', 'degree'),
('c510d71d-78e2-471d-9a8e-9c6a266efcce', 'as14', 'degree'),
('ca2866ed-7074-4c2d-9e2d-52a11bf7588d', 'as45', 'degree'),
('d0975faf-0b73-42e1-aa1c-a23a2904f0d4', 'as43', 'degree'),
('d78c1beb-c1e0-4e75-9f7e-ce879e845da8', 'as31', 'degree'),
('da94f793-d834-4b72-98d3-bdda30f4239c', 'as33', 'degree'),
('dffa2d62-97b6-47ad-adb3-fa71e3c050cc', 'as11', 'degree'),
('e4b8a78b-1665-44f0-ad76-9ec3315bddc3', 'as41', 'degree');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `cardiologist`
--

CREATE TABLE `cardiologist` (
  `doctor_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `cardiologist`
--

INSERT INTO `cardiologist` (`doctor_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('554641ad-4c8a-4268-8ae4-9c34854449f6', 'doc', 'doc', '1234567890', 'address z 3', 'doc3', 'docdoc', 'doc3@example.com', ''),
('85e95ea0-d46c-4252-9e03-24d3f08aa0f0', 'doc', 'doc', '1234567890', 'address z 4', 'doc4', 'docdoc', 'doc4@example.com', ''),
('aafe811a-679c-4e3b-95b2-63e294c8d8a9', 'doc', 'doc', '1234567890', 'address z 5', 'doc5', 'docdoc', 'doc5@example.com', ''),
('e7b16330-7c14-4301-8190-84b006d6367c', 'doc', 'doc', '1234567890', 'address z 1', 'doc1', 'docdoc', 'doc1@example.com', ''),
('fe626366-2658-4aa8-bcf6-1a434cd9cc06', 'doc', 'doc', '1234567890', 'address z 2', 'doc2', 'docdoc', 'doc2@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `diagnose`
--

CREATE TABLE `diagnose` (
  `diagnose_id` varchar(50) NOT NULL,
  `exam_id` varchar(50) NOT NULL,
  `disease_name` varchar(50) DEFAULT NULL,
  `nurse_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `diagnose`
--

INSERT INTO `diagnose` (`diagnose_id`, `exam_id`, `disease_name`, `nurse_id`) VALUES
('558da527-ab12-4422-a63c-c4b6c1f2373b', '23bf1569-45e0-4933-86b1-141b23541aad', 'heart_attack', NULL),
('648f8e5f-52e3-40e0-9b6f-36d109b74464', 'c8d47edc-45eb-4d12-95f6-ef5d867302d7', 'COVID', NULL),
('e6ed8bd2-9557-4565-b9dc-1ce2e94d5625', '209b833a-452a-4978-9f4b-9ab1cd9a69ac', 'alzheimer', NULL),
('f7dbe33d-599e-4e40-942b-a9db0fcf6f3a', '7d6cb9c2-e450-4f40-9d0c-f7776070474b', 'brain_tumor', NULL),
('ffd1ac3a-ab35-4b68-897b-7a77bda2649e', 'ff6ec6a5-c942-413d-a11c-14299b2df1e8', 'dehydration', NULL);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `diagnose_symptoms`
--

CREATE TABLE `diagnose_symptoms` (
  `diagnose_id` varchar(50) NOT NULL,
  `exam_id` varchar(50) NOT NULL,
  `symptoms` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `diagnose_symptoms`
--

INSERT INTO `diagnose_symptoms` (`diagnose_id`, `exam_id`, `symptoms`) VALUES
('558da527-ab12-4422-a63c-c4b6c1f2373b', '23bf1569-45e0-4933-86b1-141b23541aad', 'heart_pain'),
('558da527-ab12-4422-a63c-c4b6c1f2373b', '23bf1569-45e0-4933-86b1-141b23541aad', 'trouble_walking'),
('648f8e5f-52e3-40e0-9b6f-36d109b74464', 'c8d47edc-45eb-4d12-95f6-ef5d867302d7', 'cough'),
('648f8e5f-52e3-40e0-9b6f-36d109b74464', 'c8d47edc-45eb-4d12-95f6-ef5d867302d7', 'fever'),
('648f8e5f-52e3-40e0-9b6f-36d109b74464', 'c8d47edc-45eb-4d12-95f6-ef5d867302d7', 'sneezing'),
('e6ed8bd2-9557-4565-b9dc-1ce2e94d5625', '209b833a-452a-4978-9f4b-9ab1cd9a69ac', 'memory_loss'),
('f7dbe33d-599e-4e40-942b-a9db0fcf6f3a', '7d6cb9c2-e450-4f40-9d0c-f7776070474b', 'headaches'),
('f7dbe33d-599e-4e40-942b-a9db0fcf6f3a', '7d6cb9c2-e450-4f40-9d0c-f7776070474b', 'nausea'),
('ffd1ac3a-ab35-4b68-897b-7a77bda2649e', 'ff6ec6a5-c942-413d-a11c-14299b2df1e8', 'dry_mouth'),
('ffd1ac3a-ab35-4b68-897b-7a77bda2649e', 'ff6ec6a5-c942-413d-a11c-14299b2df1e8', 'weight_loss');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `disease`
--

CREATE TABLE `disease` (
  `name` varchar(50) NOT NULL,
  `transmissibility` varchar(25) DEFAULT NULL,
  `incubation` varchar(50) DEFAULT NULL,
  `therapy_duration` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `disease`
--

INSERT INTO `disease` (`name`, `transmissibility`, `incubation`, `therapy_duration`) VALUES
('alzheimer', 'unable', '', ''),
('brain_tumor', 'unable', '120_days', ''),
('breathing_problems', 'unable', '', ''),
('broken_bone', 'unable', '', ''),
('COVID', '2_metres', '', ''),
('dehydration', 'unable', '', ''),
('diabetes', 'unable', '', ''),
('flu', 'droplets', '', ''),
('heart_attack', 'unable', '', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `disease_symptoms`
--

CREATE TABLE `disease_symptoms` (
  `name` varchar(50) NOT NULL,
  `symptoms` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `disease_symptoms`
--

INSERT INTO `disease_symptoms` (`name`, `symptoms`) VALUES
('alzheimer', 'memory_loss'),
('brain_tumor', 'headaches'),
('brain_tumor', 'nausea'),
('breathing_problems', 'cough'),
('COVID', 'cough'),
('COVID', 'fever'),
('dehydration', 'dry_mouth'),
('diabetes', 'thirst'),
('diabetes', 'weight_loss'),
('flu', 'sneezing'),
('heart_attack', 'heart_pain'),
('heart_attack', 'trouble_speaking'),
('heart_attack', 'trouble_walking');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `doctor`
--

CREATE TABLE `doctor` (
  `username` varchar(50) NOT NULL,
  `doctor_id` varchar(50) NOT NULL,
  `type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `doctor`
--

INSERT INTO `doctor` (`username`, `doctor_id`, `type`) VALUES
('doc1', 'e7b16330-7c14-4301-8190-84b006d6367c', 'cardiologist'),
('doc11', '8ad68f51-9e3e-4889-9a71-dfce5ed48bb5', 'surgeon'),
('doc12', '14d35947-0716-42d8-880e-de1f28395383', 'surgeon'),
('doc13', '6fac57bf-9ff4-4d2a-89e8-896182b46847', 'surgeon'),
('doc14', '634bf26a-e568-44df-a65f-754d533cc729', 'surgeon'),
('doc15', '41ec8419-f09b-4447-9a9f-c9ab0e6f6a8d', 'surgeon'),
('doc2', 'fe626366-2658-4aa8-bcf6-1a434cd9cc06', 'cardiologist'),
('doc21', '786a2db4-7788-49a2-834d-126cab22e9db', 'neurologist'),
('doc22', 'd8c30961-2797-4ce5-9511-1c30b7337a29', 'neurologist'),
('doc23', '51f62cd9-f9c1-4860-846c-d93b3ac9f4b9', 'neurologist'),
('doc24', '86838a99-7e2e-4e59-a3ea-9bd212737645', 'neurologist'),
('doc25', '7e8a33f1-05d2-45ab-a758-b021c50ba529', 'neurologist'),
('doc3', '554641ad-4c8a-4268-8ae4-9c34854449f6', 'cardiologist'),
('doc31', '77b308c1-af96-476f-abbe-b7f892611c57', 'general_practitioner'),
('doc32', '8af0a3d9-55b4-44ad-ad9d-bacb378e2b74', 'general_practitioner'),
('doc33', 'f8f3182e-0269-4e36-bea5-05b0bbc87446', 'general_practitioner'),
('doc34', '0d7364ca-2d96-46e0-82cc-173650dde31b', 'general_practitioner'),
('doc35', '8c5d3d17-a347-4ae8-977e-bd5639b9e50c', 'general_practitioner'),
('doc4', '85e95ea0-d46c-4252-9e03-24d3f08aa0f0', 'cardiologist'),
('doc41', 'c36736ae-27af-4e3b-b3b9-8d104f01ac71', 'haematologist'),
('doc42', '249157ce-03f9-4146-8109-ca7c55484a0b', 'haematologist'),
('doc43', '6c42645e-1661-41bf-914d-083be8677016', 'haematologist'),
('doc44', '6329431f-91c2-41ba-8411-5b512d392421', 'haematologist'),
('doc45', '32af0506-84bf-4103-8f16-9bc2edb7fc0a', 'haematologist'),
('doc5', 'aafe811a-679c-4e3b-95b2-63e294c8d8a9', 'cardiologist');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `employee`
--

CREATE TABLE `employee` (
  `employee_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `department` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `employee`
--

INSERT INTO `employee` (`employee_id`, `name`, `lastname`, `phone`, `address`, `department`, `username`, `password`, `email`) VALUES
('16cbd8f6-ff3e-4f8d-9b99-a6308ed487e8', 'as', 'as', '0011111111', 'address w', 'depr1', 'as32', 'admin', 'as@example.com'),
('1fe647f8-8772-4ea5-b938-2c206b7266a8', 'admin', 'admin', '0000111111', 'address w', 'depr1', 'admin', 'admin', 'admin@example.com'),
('1ffd3b53-1945-45c4-b708-0b2ff47462ef', 'empl', 'empl', '1234123411', 'address x43', 'dep 43', 'empl43', 'emplempl', 'empl43@example.com'),
('20eb6de1-d9c0-4780-87ac-9c6ce3166026', 'as', 'as', '0011111111', 'address w', 'depr1', 'as5', 'admin', 'as@example.com'),
('27501040-2d0c-4c9b-8703-2da111b18d66', 'as', 'as', '0011111111', 'address w', 'depr1', 'as34', 'admin', 'as@example.com'),
('2a0fe6b4-641e-49fd-bef7-c304402c904a', 'empl', 'empl', '1234123411', 'address x34', 'dep 34', 'empl34', 'emplempl', 'empl34@example.com'),
('2fe654a7-ad20-4414-9ecb-404a583a20d1', 'empl', 'empl', '1234123411', 'address x4', 'dep 4', 'empl4', 'emplempl', 'empl4@example.com'),
('3a2185e9-b5ce-4b9c-9c7c-93f2b75c9801', 'empl', 'empl', '1234123411', 'address x31', 'dep 31', 'empl31', 'emplempl', 'empl31@example.com'),
('3edc4f34-d421-4d33-957e-9d7856154536', 'empl', 'empl', '1234123411', 'address x42', 'dep 42', 'empl42', 'emplempl', 'empl42@example.com'),
('3f357b16-ebda-424d-9cc1-1016a1d19af1', 'as', 'as', '0011111111', 'address w', 'depr1', 'as44', 'admin', 'as@example.com'),
('3f975126-d877-42d3-837e-47bf1c8087e8', 'as', 'as', '0011111111', 'address w', 'depr1', 'as35', 'admin', 'as@example.com'),
('4018d73e-0b62-4376-a152-441b3c3648d1', 'as', 'as', '0011111111', 'address w', 'depr1', 'as22', 'admin', 'as@example.com'),
('41c293ce-3eb2-4511-a24a-637a3b17574a', 'empl', 'empl', '1234123411', 'address x33', 'dep 33', 'empl33', 'emplempl', 'empl33@example.com'),
('43927d32-5628-421e-b790-ddabdfc51402', 'empl', 'empl', '1234123411', 'address x1', 'dep 1', 'empl1', 'emplempl', 'empl1@example.com'),
('4c42583b-f4e4-48e3-9a9b-0aa593ca69e3', 'as', 'as', '0011111111', 'address w', 'depr1', 'as3', 'admin', 'as@example.com'),
('4d685809-4d67-479e-bb8b-e97d7f3c6a66', 'empl', 'empl', '1234123411', 'address x45', 'dep 45', 'empl45', 'emplempl', 'empl45@example.com'),
('4ffbc31d-c598-4224-9fc3-08a1c2be316f', 'empl', 'empl', '1234123411', 'address x12', 'dep 12', 'empl12', 'emplempl', 'empl12@example.com'),
('50155b3e-2f85-46fa-b0d4-2dcae4cf67b7', 'as', 'as', '0011111111', 'address w', 'depr1', 'as12', 'admin', 'as@example.com'),
('519c7bb3-5abe-4d28-b46c-2427fec4d932', 'as', 'as', '0011111111', 'address w', 'depr1', 'as23', 'admin', 'as@example.com'),
('5609d1aa-afc9-4dbe-ae15-7fae2b39135a', 'empl', 'empl', '1234123411', 'address x32', 'dep 32', 'empl32', 'emplempl', 'empl32@example.com'),
('5b580a96-94ea-415b-b9e7-19e45567b178', 'as', 'as', '0011111111', 'address w', 'depr1', 'as24', 'admin', 'as@example.com'),
('5dc13966-b562-4fb3-8dae-45792fac523a', 'empl', 'empl', '1234123411', 'address x13', 'dep 13', 'empl13', 'emplempl', 'empl13@example.com'),
('6303b90b-5752-4e5c-bd44-8b46255d0199', 'as', 'as', '0011111111', 'address w', 'depr1', 'as25', 'admin', 'as@example.com'),
('650462d1-ec9f-4774-9dfb-9176f87c35da', 'as', 'as', '0011111111', 'address w', 'depr1', 'as42', 'admin', 'as@example.com'),
('673870a6-66c3-4a97-8c51-ad9c5aafd3b4', 'empl', 'empl', '1234123411', 'address x14', 'dep 14', 'empl14', 'emplempl', 'empl14@example.com'),
('6b620ac4-4ff8-45e5-8f50-404d7032f9e6', 'as', 'as', '0011111111', 'address w', 'depr1', 'as2', 'admin', 'as@example.com'),
('6dd583be-d2c8-43b2-b1f1-3a42cf1815a4', 'empl', 'empl', '1234123411', 'address x22', 'dep 22', 'empl22', 'emplempl', 'empl22@example.com'),
('6e60d70c-d0b9-4ba0-84ba-e6f89ef34d95', 'empl', 'empl', '1234123411', 'address x3', 'dep 3', 'empl3', 'emplempl', 'empl3@example.com'),
('736e9380-7807-4e49-b745-a84113a99c37', 'empl', 'empl', '1234123411', 'address x44', 'dep 44', 'empl44', 'emplempl', 'empl44@example.com'),
('743cc152-68e8-4a90-91a3-17b67a3af91f', 'as', 'as', '0011111111', 'address w', 'depr1', 'as15', 'admin', 'as@example.com'),
('7bf5a000-0a52-4c86-9b52-f0ab06e69b6a', 'empl', 'empl', '1234123411', 'address x5', 'dep 5', 'empl5', 'emplempl', 'empl5@example.com'),
('7d6fea0a-ed6d-408d-8fae-b84f7d5dc5af', 'admin', 'admin', '0000111111', 'address w', 'depr1', 'admin', 'admin', 'admin@example.com'),
('8a38be1e-eb4a-461a-a1f2-524e0b183384', 'as', 'as', '0011111111', 'address w', 'depr1', 'as4', 'admin', 'as@example.com'),
('8c61d23a-0cc5-44d8-bab9-723b4e98a6f8', 'admin', 'admin', '0000111111', 'address w', 'depr1', 'admin', 'admin', 'admin@example.com'),
('8c989e6f-ccfc-46c8-8e9c-f8e2530da5fb', 'empl', 'empl', '1234123411', 'address x23', 'dep 23', 'empl23', 'emplempl', 'empl23@example.com'),
('92c762d0-697c-43c6-a850-c698c526059d', 'empl', 'empl', '1234123411', 'address x15', 'dep 15', 'empl15', 'emplempl', 'empl15@example.com'),
('93bccf48-2805-444b-a4ee-414e176138f0', 'empl', 'empl', '1234123411', 'address x11', 'dep 11', 'empl11', 'emplempl', 'empl11@example.com'),
('97a0a139-970f-4c41-bb0a-bd977a021761', 'empl', 'empl', '1234123411', 'address x41', 'dep 41', 'empl41', 'emplempl', 'empl41@example.com'),
('a17ecace-5030-40b9-b3d7-af9c7b94203e', 'empl', 'empl', '1234123411', 'address x25', 'dep 25', 'empl25', 'emplempl', 'empl25@example.com'),
('a21a11f0-1a88-4c3f-8484-4ff0824383aa', 'empl', 'empl', '1234123411', 'address x21', 'dep 21', 'empl21', 'emplempl', 'empl21@example.com'),
('ab8777a0-549f-4257-8ef3-3556e2d16165', 'as', 'as', '0011111111', 'address w', 'depr1', 'as21', 'admin', 'as@example.com'),
('b119af78-d5cc-4c4f-9039-78d43009a5f3', 'empl', 'empl', '1234123411', 'address x35', 'dep 35', 'empl35', 'emplempl', 'empl35@example.com'),
('b4308781-5d7c-40fe-936d-6d87bc98e139', 'empl', 'empl', '1234123411', 'address x24', 'dep 24', 'empl24', 'emplempl', 'empl24@example.com'),
('b4a28645-3df7-41c4-9abc-23e1882ca0a0', 'admin', 'admin', '0000111111', 'address w', 'depr1', 'admin', 'admin', 'admin@example.com'),
('b56f7d8a-abc9-46cd-b0e6-258867adf860', 'as', 'as', '0011111111', 'address w', 'depr1', 'as1', 'admin', 'as@example.com'),
('bd88c5d4-aa0b-4112-8e87-7cd1689afe95', 'admin', 'admin', '0000111111', 'address w', 'depr1', 'admin', 'admin', 'admin@example.com'),
('c281e873-a03c-497d-a0c6-2bb688f73089', 'as', 'as', '0011111111', 'address w', 'depr1', 'as13', 'admin', 'as@example.com'),
('c510d71d-78e2-471d-9a8e-9c6a266efcce', 'as', 'as', '0011111111', 'address w', 'depr1', 'as14', 'admin', 'as@example.com'),
('c697d803-9361-476b-8df0-ed626387a77c', 'empl', 'empl', '1234123411', 'address x2', 'dep 2', 'empl2', 'emplempl', 'empl2@example.com'),
('ca2866ed-7074-4c2d-9e2d-52a11bf7588d', 'as', 'as', '0011111111', 'address w', 'depr1', 'as45', 'admin', 'as@example.com'),
('d0975faf-0b73-42e1-aa1c-a23a2904f0d4', 'as', 'as', '0011111111', 'address w', 'depr1', 'as43', 'admin', 'as@example.com'),
('d78c1beb-c1e0-4e75-9f7e-ce879e845da8', 'as', 'as', '0011111111', 'address w', 'depr1', 'as31', 'admin', 'as@example.com'),
('da94f793-d834-4b72-98d3-bdda30f4239c', 'as', 'as', '0011111111', 'address w', 'depr1', 'as33', 'admin', 'as@example.com'),
('dffa2d62-97b6-47ad-adb3-fa71e3c050cc', 'as', 'as', '0011111111', 'address w', 'depr1', 'as11', 'admin', 'as@example.com'),
('e4b8a78b-1665-44f0-ad76-9ec3315bddc3', 'as', 'as', '0011111111', 'address w', 'depr1', 'as41', 'admin', 'as@example.com');

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_cardiologist`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_cardiologist` (
`doctor_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_gp`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_gp` (
`doctor_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_haematologist`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_haematologist` (
`doctor_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_neurologist`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_neurologist` (
`doctor_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_n_gp`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_n_gp` (
`nurse_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_n_haematologist`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_n_haematologist` (
`nurse_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_n_neurologist`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_n_neurologist` (
`nurse_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_n_surgeon`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_n_surgeon` (
`nurse_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Στημένη δομή για προβολή `employee_to_surgeon`
-- (Δείτε παρακάτω για την πραγματική προβολή)
--
CREATE TABLE `employee_to_surgeon` (
`doctor_id` varchar(50)
,`name` varchar(20)
,`lastname` varchar(20)
,`username` varchar(15)
,`email` varchar(26)
);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `examination`
--

CREATE TABLE `examination` (
  `exam_id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `exam_room` varchar(50) DEFAULT NULL,
  `nurse_id` varchar(50) DEFAULT NULL,
  `doctor_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `examination`
--

INSERT INTO `examination` (`exam_id`, `name`, `exam_room`, `nurse_id`, `doctor_id`) VALUES
('209b833a-452a-4978-9f4b-9ab1cd9a69ac', 'heart_checkup', 'C3', '', '7e8a33f1-05d2-45ab-a758-b021c50ba529'),
('23bf1569-45e0-4933-86b1-141b23541aad', 'nuclear_cardiac_stress', 'C8', '', 'aafe811a-679c-4e3b-95b2-63e294c8d8a9'),
('289f907b-0e68-4612-b603-2f4599cc4e1f', 'Echocardiogram', 'C5', '05b9586a-ec27-4b20-b828-e2e062c5cfad', '249157ce-03f9-4146-8109-ca7c55484a0b'),
('7d6cb9c2-e450-4f40-9d0c-f7776070474b', 'Electrocardiogram', 'C9', '', ''),
('afe93784-fb24-4fbe-b2b2-cb2bf1abffca', 'heart_checkup', 'C3', 'b9401477-6950-4536-acc0-2a1c19137459', '7e8a33f1-05d2-45ab-a758-b021c50ba529'),
('c8d47edc-45eb-4d12-95f6-ef5d867302d7', 'nuclear_cardiac_stress', 'C2', '', '77b308c1-af96-476f-abbe-b7f892611c57'),
('d720c9c6-70ad-47cf-a1dc-0efd2ec39d0e', 'nuclear_cardiac_stress', 'C2', '98c69da9-e9ef-48e0-b7b5-9ac4e3a36abe', '77b308c1-af96-476f-abbe-b7f892611c57'),
('ff6ec6a5-c942-413d-a11c-14299b2df1e8', 'Echocardiogram', 'C5', '', '249157ce-03f9-4146-8109-ca7c55484a0b');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `general_practitioner`
--

CREATE TABLE `general_practitioner` (
  `doctor_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `general_practitioner`
--

INSERT INTO `general_practitioner` (`doctor_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('0d7364ca-2d96-46e0-82cc-173650dde31b', 'doc', 'doc', '1234567890', 'address z 34', 'doc34', 'docdoc', 'doc34@example.com', ''),
('77b308c1-af96-476f-abbe-b7f892611c57', 'doc', 'doc', '1234567890', 'address z 31', 'doc31', 'docdoc', 'doc31@example.com', ''),
('8af0a3d9-55b4-44ad-ad9d-bacb378e2b74', 'doc', 'doc', '1234567890', 'address z 32', 'doc32', 'docdoc', 'doc32@example.com', ''),
('8c5d3d17-a347-4ae8-977e-bd5639b9e50c', 'doc', 'doc', '1234567890', 'address z 35', 'doc35', 'docdoc', 'doc35@example.com', ''),
('f8f3182e-0269-4e36-bea5-05b0bbc87446', 'doc', 'doc', '1234567890', 'address z 33', 'doc33', 'docdoc', 'doc33@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `haematologist`
--

CREATE TABLE `haematologist` (
  `doctor_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `haematologist`
--

INSERT INTO `haematologist` (`doctor_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('249157ce-03f9-4146-8109-ca7c55484a0b', 'doc', 'doc', '1234567890', 'address z 42', 'doc42', 'docdoc', 'doc42@example.com', ''),
('32af0506-84bf-4103-8f16-9bc2edb7fc0a', 'doc', 'doc', '1234567890', 'address z 45', 'doc45', 'docdoc', 'doc45@example.com', ''),
('6329431f-91c2-41ba-8411-5b512d392421', 'doc', 'doc', '1234567890', 'address z 44', 'doc44', 'docdoc', 'doc44@example.com', ''),
('6c42645e-1661-41bf-914d-083be8677016', 'doc', 'doc', '1234567890', 'address z 43', 'doc43', 'docdoc', 'doc43@example.com', ''),
('c36736ae-27af-4e3b-b3b9-8d104f01ac71', 'doc', 'doc', '1234567890', 'address z 41', 'doc41', 'docdoc', 'doc41@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `medication`
--

CREATE TABLE `medication` (
  `med_id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `dosage` varchar(15) DEFAULT NULL,
  `use_for` varchar(20) DEFAULT NULL,
  `exp_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `medication`
--

INSERT INTO `medication` (`med_id`, `name`, `type`, `dosage`, `use_for`, `exp_date`) VALUES
('036df03e-b6f6-4bbf-a2d5-0ca03edb48f3', 'cardiolip', 'pill', '850mg', 'heart_attack', '2022-03-26 00:00:00'),
('0b274f8e-5ffc-454a-9cbb-efa61800efee', 'Zithromax', 'pill', '250mg', 'breathing_problems', '2023-07-07 00:00:00'),
('1e3ad6bd-2a50-4aae-aba0-5901074f47c4', 'Exelon', 'pill', '900mg', 'alzheimer', '2023-10-10 00:00:00'),
('301a8399-5a1d-45fc-b62a-f5b6bb9771c8', 'cold_n_flu', 'pill', '500mg', 'flu', '2023-02-10 00:00:00'),
('4413e782-3c65-45b8-b41d-b0aa8283f93c', 'pioglitazone', 'pill', '450mg', 'diabetes', '2021-10-10 00:00:00'),
('4c0cc4c4-afe6-48a3-920a-5cb053ffb03f', 'niflamol', 'pill', '1000mg', 'broken_bone', '2022-06-10 00:00:00'),
('5274ce48-7737-48ea-8c48-cbbdf2301ae4', 'intravenous_fluid', 'fluid', 'not_specified', 'dehydration', '2023-06-12 00:00:00'),
('6babb042-d329-49ae-be4b-d87205b67633', 'niflamol', 'pill', '500mg', 'broken_bone', '2022-01-10 00:00:00'),
('78c35c0f-d62b-43ca-87f9-69705540d564', 'cold_n_flu', 'pill', '250mg', 'flu', '2023-02-10 00:00:00'),
('a992e8e2-792b-412a-bd94-450d00f54aeb', 'pfizer_bionteck_covid19', 'needle_vaccine', '0.3ml', 'COVID', '2024-05-10 00:00:00'),
('d7cfcfbd-027f-42c0-aaaf-e99cd3d1d1e5', 'cardiolip', 'pill', '500mg', 'heart_attack', '2022-01-20 00:00:00'),
('dd3c1269-c262-4f35-8d0b-33f2d6a1d59b', 'Exelon', 'pill', '450mg', 'alzheimer', '2022-05-10 00:00:00'),
('f7a96d97-2628-44b6-99cc-047f66926978', 'Temozolomide', 'intravenously', 'not_specified', 'brain_tumor', '2021-08-18 00:00:00'),
('fc40715a-7e6c-40ad-98b0-1866cb4b70b1', 'cold_n_flu', 'pill', '1000mg', 'flu', '2023-07-07 00:00:00');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `neurologist`
--

CREATE TABLE `neurologist` (
  `doctor_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `neurologist`
--

INSERT INTO `neurologist` (`doctor_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('51f62cd9-f9c1-4860-846c-d93b3ac9f4b9', 'doc', 'doc', '1234567890', 'address z 23', 'doc23', 'docdoc', 'doc23@example.com', ''),
('786a2db4-7788-49a2-834d-126cab22e9db', 'doc', 'doc', '1234567890', 'address z 21', 'doc21', 'docdoc', 'doc21@example.com', ''),
('7e8a33f1-05d2-45ab-a758-b021c50ba529', 'doc', 'doc', '1234567890', 'address z 25', 'doc25', 'docdoc', 'doc25@example.com', ''),
('86838a99-7e2e-4e59-a3ea-9bd212737645', 'doc', 'doc', '1234567890', 'address z 24', 'doc24', 'docdoc', 'doc24@example.com', ''),
('d8c30961-2797-4ce5-9511-1c30b7337a29', 'doc', 'doc', '1234567890', 'address z 22', 'doc22', 'docdoc', 'doc22@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `nurse`
--

CREATE TABLE `nurse` (
  `username` varchar(50) NOT NULL,
  `nurse_id` varchar(50) NOT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `nurse`
--

INSERT INTO `nurse` (`username`, `nurse_id`, `type`) VALUES
('nurse1', '774a249d-2810-4109-8476-4642c5241023', 'nurse_neurologist'),
('nurse11', '25031ff0-555a-4c84-8855-7b206adcd8f0', 'nurse_general_practitioner'),
('nurse12', '98c69da9-e9ef-48e0-b7b5-9ac4e3a36abe', 'nurse_general_practitioner'),
('nurse13', '465e9165-d754-4fd1-a7f7-1d6415b8399c', 'nurse_general_practitioner'),
('nurse14', 'a57f3e32-0823-45f2-9600-f908b4cdb949', 'nurse_general_practitioner'),
('nurse15', '4ce7a065-e9b6-4b9c-b7d7-7d173e57b5ab', 'nurse_general_practitioner'),
('nurse2', '08cf4971-a819-47b4-ace3-419c1231262d', 'nurse_neurologist'),
('nurse21', '7a255c3a-c3f7-4a72-9ec1-1d48c5c309ae', 'nurse_haematologist'),
('nurse22', '05b9586a-ec27-4b20-b828-e2e062c5cfad', 'nurse_haematologist'),
('nurse23', '80e76861-ca9b-4f04-82d7-e98dad6986d5', 'nurse_haematologist'),
('nurse24', 'd72ebe93-0acc-4a90-8e6b-e8ea1ac2f5b1', 'nurse_haematologist'),
('nurse25', 'ff58bbde-128f-4b85-8dd0-75bd699cd90e', 'nurse_haematologist'),
('nurse3', 'b9401477-6950-4536-acc0-2a1c19137459', 'nurse_neurologist'),
('nurse31', '00b51a91-37e5-469e-b4cb-bbe693cbb343', 'nurse_surgeon'),
('nurse32', '0cdc8338-82ec-4e79-98fc-e0167b1a8f7a', 'nurse_surgeon'),
('nurse33', '4e3c1af1-de1a-4b7b-91fd-1e7eaa2fc5af', 'nurse_surgeon'),
('nurse34', '94f5f97b-4e11-49c9-bfad-7f585317972a', 'nurse_surgeon'),
('nurse35', '3e12e3b5-b731-4b91-b8bd-3bb337cb7476', 'nurse_surgeon'),
('nurse4', '9df88ebb-578d-494c-8bc5-60ecc6d39e1a', 'nurse_neurologist'),
('nurse5', 'f81c60cd-28dd-4fd8-b474-f2c160f0318d', 'nurse_neurologist');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `nurse_general_practitioner`
--

CREATE TABLE `nurse_general_practitioner` (
  `nurse_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `nurse_general_practitioner`
--

INSERT INTO `nurse_general_practitioner` (`nurse_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('25031ff0-555a-4c84-8855-7b206adcd8f0', 'nurse', 'nurse', '1234567980', 'address y11', 'nurse11', 'nursenurse', 'nurse11@example.com', ''),
('465e9165-d754-4fd1-a7f7-1d6415b8399c', 'nurse', 'nurse', '1234567980', 'address y13', 'nurse13', 'nursenurse', 'nurse13@example.com', ''),
('4ce7a065-e9b6-4b9c-b7d7-7d173e57b5ab', 'nurse', 'nurse', '1234567980', 'address y15', 'nurse15', 'nursenurse', 'nurse15@example.com', ''),
('98c69da9-e9ef-48e0-b7b5-9ac4e3a36abe', 'nurse', 'nurse', '1234567980', 'address y12', 'nurse12', 'nursenurse', 'nurse12@example.com', ''),
('a57f3e32-0823-45f2-9600-f908b4cdb949', 'nurse', 'nurse', '1234567980', 'address y14', 'nurse14', 'nursenurse', 'nurse14@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `nurse_haematologist`
--

CREATE TABLE `nurse_haematologist` (
  `nurse_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `nurse_haematologist`
--

INSERT INTO `nurse_haematologist` (`nurse_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('05b9586a-ec27-4b20-b828-e2e062c5cfad', 'nurse', 'nurse', '1234567980', 'address y22', 'nurse22', 'nursenurse', 'nurse22@example.com', ''),
('7a255c3a-c3f7-4a72-9ec1-1d48c5c309ae', 'nurse', 'nurse', '1234567980', 'address y21', 'nurse21', 'nursenurse', 'nurse21@example.com', ''),
('80e76861-ca9b-4f04-82d7-e98dad6986d5', 'nurse', 'nurse', '1234567980', 'address y23', 'nurse23', 'nursenurse', 'nurse23@example.com', ''),
('d72ebe93-0acc-4a90-8e6b-e8ea1ac2f5b1', 'nurse', 'nurse', '1234567980', 'address y24', 'nurse24', 'nursenurse', 'nurse24@example.com', ''),
('ff58bbde-128f-4b85-8dd0-75bd699cd90e', 'nurse', 'nurse', '1234567980', 'address y25', 'nurse25', 'nursenurse', 'nurse25@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `nurse_neurologist`
--

CREATE TABLE `nurse_neurologist` (
  `nurse_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `nurse_neurologist`
--

INSERT INTO `nurse_neurologist` (`nurse_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('08cf4971-a819-47b4-ace3-419c1231262d', 'nurse', 'nurse', '1234567980', 'address y2', 'nurse2', 'nursenurse', 'nurse2@example.com', ''),
('774a249d-2810-4109-8476-4642c5241023', 'nurse', 'nurse', '1234567980', 'address y1', 'nurse1', 'nursenurse', 'nurse1@example.com', ''),
('9df88ebb-578d-494c-8bc5-60ecc6d39e1a', 'nurse', 'nurse', '1234567980', 'address y4', 'nurse4', 'nursenurse', 'nurse4@example.com', ''),
('b9401477-6950-4536-acc0-2a1c19137459', 'nurse', 'nurse', '1234567980', 'address y3', 'nurse3', 'nursenurse', 'nurse3@example.com', ''),
('f81c60cd-28dd-4fd8-b474-f2c160f0318d', 'nurse', 'nurse', '1234567980', 'address y5', 'nurse5', 'nursenurse', 'nurse5@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `nurse_surgeon`
--

CREATE TABLE `nurse_surgeon` (
  `nurse_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `nurse_surgeon`
--

INSERT INTO `nurse_surgeon` (`nurse_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('00b51a91-37e5-469e-b4cb-bbe693cbb343', 'nurse', 'nurse', '1234567980', 'address y31', 'nurse31', 'nursenurse', 'nurse31@example.com', ''),
('0cdc8338-82ec-4e79-98fc-e0167b1a8f7a', 'nurse', 'nurse', '1234567980', 'address y32', 'nurse32', 'nursenurse', 'nurse32@example.com', ''),
('3e12e3b5-b731-4b91-b8bd-3bb337cb7476', 'nurse', 'nurse', '1234567980', 'address y35', 'nurse35', 'nursenurse', 'nurse35@example.com', ''),
('4e3c1af1-de1a-4b7b-91fd-1e7eaa2fc5af', 'nurse', 'nurse', '1234567980', 'address y33', 'nurse33', 'nursenurse', 'nurse33@example.com', ''),
('94f5f97b-4e11-49c9-bfad-7f585317972a', 'nurse', 'nurse', '1234567980', 'address y34', 'nurse34', 'nursenurse', 'nurse34@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `orders`
--

CREATE TABLE `orders` (
  `exam_id` varchar(50) NOT NULL,
  `doctor_id` varchar(50) DEFAULT NULL,
  `nurse_id` varchar(50) DEFAULT NULL,
  `exam_name` varchar(50) DEFAULT NULL,
  `exam_room` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `orders`
--

INSERT INTO `orders` (`exam_id`, `doctor_id`, `nurse_id`, `exam_name`, `exam_room`) VALUES
('289f907b-0e68-4612-b603-2f4599cc4e1f', '249157ce-03f9-4146-8109-ca7c55484a0b', '05b9586a-ec27-4b20-b828-e2e062c5cfad', 'Echocardiogram', 'C5'),
('afe93784-fb24-4fbe-b2b2-cb2bf1abffca', '7e8a33f1-05d2-45ab-a758-b021c50ba529', 'b9401477-6950-4536-acc0-2a1c19137459', 'heart_checkup', 'C3'),
('d720c9c6-70ad-47cf-a1dc-0efd2ec39d0e', '77b308c1-af96-476f-abbe-b7f892611c57', '98c69da9-e9ef-48e0-b7b5-9ac4e3a36abe', 'nuclear_cardiac_stress', 'C2');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `patient`
--

CREATE TABLE `patient` (
  `patient_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `insurance` varchar(40) DEFAULT NULL,
  `amka` varchar(11) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `patient`
--

INSERT INTO `patient` (`patient_id`, `name`, `lastname`, `phone`, `address`, `insurance`, `amka`, `username`, `password`, `email`, `employee_id`) VALUES
('16a7955b-5ea4-49a3-a435-9f5898d0c296', 'droyle', 'noname', '6989992319', 'neverland', 'Droyle_trick', '987654321', 'droyle', 'droyle', 'droyle98@hot.com', 'null'),
('2bd44f8b-d2d0-439f-bbeb-ef7a11d3ae2c', 'pat', 'pat', '1234123443', 'address', '1insurance1', '11111111111', 'pat1', 'pat', 'pat@example.com', 'null'),
('5544dfc3-adbe-4ebf-a50c-1cc6f6371e6e', 'tolis', 'maurogiannakis', '6981234859', 'neverland', 'Golden_trick', '123456789', 'tolis98', 'tolis98', 'tolis98@hot.com', 'null'),
('576598e2-e935-43e3-a2e5-3fb05b1610dc', 'pat', 'pat', '1234123443', 'address', '1insurance1', '11111111111', 'pat5', 'pat', 'pat@example.com', 'null'),
('7d45a6a1-0fdb-4b6b-aff5-da446eb4ef14', 'pat', 'pat', '1234123443', 'address', '1insurance1', '11111111111', 'pat2', 'pat', 'pat@example.com', 'null'),
('8ceba197-1e72-45e0-a3b8-ff8062fb4941', 'pat', 'pat', '1234123443', 'address', '1insurance1', '11111111111', 'pat4', 'pat', 'pat@example.com', 'null'),
('9bffab13-e791-4186-918c-b8dbc0130842', 'dragonio', 'nothing', '6989992319', 'neverland', 'Darktick', '987654321', 'dragonio', 'dragonio', 'dragonio@hot.com', 'null'),
('ae1fb13a-39fb-4146-9888-108163addba6', 'biskoto', 'atall', '6989992319', 'neverland', 'ticktock', '987654321', 'biskoto', 'biskoto', 'biskoto98@hot.com', 'null'),
('daf96912-8e32-4336-872c-4b0734f26e2d', 'pat', 'pat', '1234123443', 'address', '1insurance1', '11111111111', 'pat3', 'pat', 'pat@example.com', 'null'),
('f3a7533d-2044-49c0-84b0-97a921c9f94b', 'habos', 'varsamis', '6989992319', 'neverland', 'Golden_trick', '987654321', 'habos98', 'habos98', 'habos98@hot.com', 'null');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `prescribe`
--

CREATE TABLE `prescribe` (
  `exam_id` varchar(50) NOT NULL,
  `med_id` varchar(50) NOT NULL,
  `date` datetime DEFAULT NULL,
  `doctor_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `prescribe`
--

INSERT INTO `prescribe` (`exam_id`, `med_id`, `date`, `doctor_id`) VALUES
('209b833a-452a-4978-9f4b-9ab1cd9a69ac', 'dd3c1269-c262-4f35-8d0b-33f2d6a1d59b', '2021-01-17 21:00:02', '7e8a33f1-05d2-45ab-a758-b021c50ba529'),
('23bf1569-45e0-4933-86b1-141b23541aad', 'd7cfcfbd-027f-42c0-aaaf-e99cd3d1d1e5', '2021-01-17 21:00:01', 'aafe811a-679c-4e3b-95b2-63e294c8d8a9'),
('7d6cb9c2-e450-4f40-9d0c-f7776070474b', 'f7a96d97-2628-44b6-99cc-047f66926978', '2021-01-17 21:00:06', ''),
('c8d47edc-45eb-4d12-95f6-ef5d867302d7', 'a992e8e2-792b-412a-bd94-450d00f54aeb', '2021-01-17 21:00:03', '77b308c1-af96-476f-abbe-b7f892611c57'),
('ff6ec6a5-c942-413d-a11c-14299b2df1e8', '5274ce48-7737-48ea-8c48-cbbdf2301ae4', '2021-01-17 21:00:04', '249157ce-03f9-4146-8109-ca7c55484a0b');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `shift`
--

CREATE TABLE `shift` (
  `date` datetime NOT NULL,
  `doctor_id` varchar(50) DEFAULT NULL,
  `nurse_id` varchar(50) DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  `department` varchar(40) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `shift`
--

INSERT INTO `shift` (`date`, `doctor_id`, `nurse_id`, `type`, `department`, `employee_id`) VALUES
('2019-02-15 21:00:00', '8ad68f51-9e3e-4889-9a71-dfce5ed48bb5', '', 'surgeon', 'surgeries', ''),
('2019-02-15 21:00:01', '634bf26a-e568-44df-a65f-754d533cc729', '', 'surgeon', 'surgeries', ''),
('2019-02-15 21:00:02', 'd8c30961-2797-4ce5-9511-1c30b7337a29', '', 'neurologist', 'neurology', ''),
('2019-02-15 21:00:03', '7e8a33f1-05d2-45ab-a758-b021c50ba529', '', 'neurologist', 'neurology', ''),
('2019-02-15 21:00:04', '249157ce-03f9-4146-8109-ca7c55484a0b', '', 'haematologist', 'haematology', ''),
('2019-02-15 21:00:05', '6c42645e-1661-41bf-914d-083be8677016', '', 'haematologist', 'haematology', ''),
('2019-02-15 21:00:06', 'f8f3182e-0269-4e36-bea5-05b0bbc87446', '', 'general_practitioner', 'general_practices', ''),
('2019-02-15 21:00:07', '8c5d3d17-a347-4ae8-977e-bd5639b9e50c', '', 'general_practitioner', 'general_practices', ''),
('2019-02-15 21:00:08', 'fe626366-2658-4aa8-bcf6-1a434cd9cc06', '', 'cardiologist', 'cardiology', ''),
('2019-02-15 21:00:09', 'e7b16330-7c14-4301-8190-84b006d6367c', '', 'cardiologist', 'cardiology', ''),
('2019-02-15 21:00:10', '', '00b51a91-37e5-469e-b4cb-bbe693cbb343', 'nurse_surgeon', 'surgeries', ''),
('2019-02-15 21:00:11', '', '0cdc8338-82ec-4e79-98fc-e0167b1a8f7a', 'nurse_surgeon', 'surgeries', ''),
('2019-02-15 21:00:12', '', '9df88ebb-578d-494c-8bc5-60ecc6d39e1a', 'nurse_neurologist', 'neurology', ''),
('2019-02-15 21:00:13', '', 'f81c60cd-28dd-4fd8-b474-f2c160f0318d', 'nurse_neurologist', 'neurology', ''),
('2019-02-15 21:00:14', '', 'ff58bbde-128f-4b85-8dd0-75bd699cd90e', 'nurse_haematologist', 'haematology', ''),
('2019-02-15 21:00:15', '', 'd72ebe93-0acc-4a90-8e6b-e8ea1ac2f5b1', 'nurse_haematologist', 'haematology', ''),
('2019-02-15 21:00:16', '', '25031ff0-555a-4c84-8855-7b206adcd8f0', 'nurse_general_practitioner', 'general_practices', ''),
('2019-02-15 21:00:17', '', '4ce7a065-e9b6-4b9c-b7d7-7d173e57b5ab', 'nurse_general_practitioner', 'general_practices', ''),
('2019-02-15 21:00:18', '', '', 'employee', 'employee_office', '3edc4f34-d421-4d33-957e-9d7856154536'),
('2019-02-15 21:00:19', '', '', 'employee', 'employee_office', '43927d32-5628-421e-b790-ddabdfc51402'),
('2019-02-15 21:00:20', '', '', 'administrative', 'administrative_office', '8c61d23a-0cc5-44d8-bab9-723b4e98a6f8'),
('2019-02-15 21:00:21', '', '', 'administrative', 'administrative_office', 'b4a28645-3df7-41c4-9abc-23e1882ca0a0'),
('2019-02-15 21:00:22', '', '', 'assistant_manager', 'assistant_manager_office', '519c7bb3-5abe-4d28-b46c-2427fec4d932'),
('2019-02-15 21:00:23', '', '', 'assistant_manager', 'assistant_manager_office', '8a38be1e-eb4a-461a-a1f2-524e0b183384'),
('2019-05-19 21:00:00', '41ec8419-f09b-4447-9a9f-c9ab0e6f6a8d', '', 'surgeon', 'surgeries', ''),
('2019-05-19 21:00:01', '8ad68f51-9e3e-4889-9a71-dfce5ed48bb5', '', 'surgeon', 'surgeries', ''),
('2019-05-19 21:00:02', '786a2db4-7788-49a2-834d-126cab22e9db', '', 'neurologist', 'neurology', ''),
('2019-05-19 21:00:03', '86838a99-7e2e-4e59-a3ea-9bd212737645', '', 'neurologist', 'neurology', ''),
('2019-05-19 21:00:04', '6329431f-91c2-41ba-8411-5b512d392421', '', 'haematologist', 'haematology', ''),
('2019-05-19 21:00:05', 'c36736ae-27af-4e3b-b3b9-8d104f01ac71', '', 'haematologist', 'haematology', ''),
('2019-05-19 21:00:06', '0d7364ca-2d96-46e0-82cc-173650dde31b', '', 'general_practitioner', 'general_practices', ''),
('2019-05-19 21:00:07', '8c5d3d17-a347-4ae8-977e-bd5639b9e50c', '', 'general_practitioner', 'general_practices', ''),
('2019-05-19 21:00:08', 'aafe811a-679c-4e3b-95b2-63e294c8d8a9', '', 'cardiologist', 'cardiology', ''),
('2019-05-19 21:00:09', 'fe626366-2658-4aa8-bcf6-1a434cd9cc06', '', 'cardiologist', 'cardiology', ''),
('2019-05-19 21:00:10', '', '94f5f97b-4e11-49c9-bfad-7f585317972a', 'nurse_surgeon', 'surgeries', ''),
('2019-05-19 21:00:11', '', '00b51a91-37e5-469e-b4cb-bbe693cbb343', 'nurse_surgeon', 'surgeries', ''),
('2019-05-19 21:00:12', '', 'f81c60cd-28dd-4fd8-b474-f2c160f0318d', 'nurse_neurologist', 'neurology', ''),
('2019-05-19 21:00:13', '', '08cf4971-a819-47b4-ace3-419c1231262d', 'nurse_neurologist', 'neurology', ''),
('2019-05-19 21:00:14', '', 'ff58bbde-128f-4b85-8dd0-75bd699cd90e', 'nurse_haematologist', 'haematology', ''),
('2019-05-19 21:00:15', '', '7a255c3a-c3f7-4a72-9ec1-1d48c5c309ae', 'nurse_haematologist', 'haematology', ''),
('2019-05-19 21:00:16', '', '4ce7a065-e9b6-4b9c-b7d7-7d173e57b5ab', 'nurse_general_practitioner', 'general_practices', ''),
('2019-05-19 21:00:17', '', 'a57f3e32-0823-45f2-9600-f908b4cdb949', 'nurse_general_practitioner', 'general_practices', ''),
('2019-05-19 21:00:18', '', '', 'employee', 'employee_office', '3f975126-d877-42d3-837e-47bf1c8087e8'),
('2019-05-19 21:00:19', '', '', 'employee', 'employee_office', '92c762d0-697c-43c6-a850-c698c526059d'),
('2019-05-19 21:00:20', '', '', 'administrative', 'administrative_office', '7d6fea0a-ed6d-408d-8fae-b84f7d5dc5af'),
('2019-05-19 21:00:21', '', '', 'administrative', 'administrative_office', '8c61d23a-0cc5-44d8-bab9-723b4e98a6f8'),
('2019-05-19 21:00:22', '', '', 'assistant_manager', 'assistant_manager_office', 'ca2866ed-7074-4c2d-9e2d-52a11bf7588d'),
('2019-05-19 21:00:23', '', '', 'assistant_manager', 'assistant_manager_office', '3f975126-d877-42d3-837e-47bf1c8087e8'),
('2020-04-19 21:00:00', '14d35947-0716-42d8-880e-de1f28395383', '', 'surgeon', 'surgeries', ''),
('2020-04-19 21:00:01', '6fac57bf-9ff4-4d2a-89e8-896182b46847', '', 'surgeon', 'surgeries', ''),
('2020-04-19 21:00:02', '7e8a33f1-05d2-45ab-a758-b021c50ba529', '', 'neurologist', 'neurology', ''),
('2020-04-19 21:00:03', '786a2db4-7788-49a2-834d-126cab22e9db', '', 'neurologist', 'neurology', ''),
('2020-04-19 21:00:04', '6c42645e-1661-41bf-914d-083be8677016', '', 'haematologist', 'haematology', ''),
('2020-04-19 21:00:05', '249157ce-03f9-4146-8109-ca7c55484a0b', '', 'haematologist', 'haematology', ''),
('2020-04-19 21:00:06', '0d7364ca-2d96-46e0-82cc-173650dde31b', '', 'general_practitioner', 'general_practices', ''),
('2020-04-19 21:00:07', 'f8f3182e-0269-4e36-bea5-05b0bbc87446', '', 'general_practitioner', 'general_practices', ''),
('2020-04-19 21:00:08', '85e95ea0-d46c-4252-9e03-24d3f08aa0f0', '', 'cardiologist', 'cardiology', ''),
('2020-04-19 21:00:09', 'e7b16330-7c14-4301-8190-84b006d6367c', '', 'cardiologist', 'cardiology', ''),
('2020-04-19 21:00:10', '', '00b51a91-37e5-469e-b4cb-bbe693cbb343', 'nurse_surgeon', 'surgeries', ''),
('2020-04-19 21:00:11', '', '0cdc8338-82ec-4e79-98fc-e0167b1a8f7a', 'nurse_surgeon', 'surgeries', ''),
('2020-04-19 21:00:12', '', '774a249d-2810-4109-8476-4642c5241023', 'nurse_neurologist', 'neurology', ''),
('2020-04-19 21:00:13', '', 'f81c60cd-28dd-4fd8-b474-f2c160f0318d', 'nurse_neurologist', 'neurology', ''),
('2020-04-19 21:00:14', '', '7a255c3a-c3f7-4a72-9ec1-1d48c5c309ae', 'nurse_haematologist', 'haematology', ''),
('2020-04-19 21:00:15', '', '05b9586a-ec27-4b20-b828-e2e062c5cfad', 'nurse_haematologist', 'haematology', ''),
('2020-04-19 21:00:16', '', '4ce7a065-e9b6-4b9c-b7d7-7d173e57b5ab', 'nurse_general_practitioner', 'general_practices', ''),
('2020-04-19 21:00:17', '', '98c69da9-e9ef-48e0-b7b5-9ac4e3a36abe', 'nurse_general_practitioner', 'general_practices', ''),
('2020-04-19 21:00:18', '', '', 'employee', 'employee_office', 'b4a28645-3df7-41c4-9abc-23e1882ca0a0'),
('2020-04-19 21:00:19', '', '', 'employee', 'employee_office', 'b4308781-5d7c-40fe-936d-6d87bc98e139'),
('2020-04-19 21:00:20', '', '', 'administrative', 'administrative_office', 'b4a28645-3df7-41c4-9abc-23e1882ca0a0'),
('2020-04-19 21:00:21', '', '', 'administrative', 'administrative_office', '8c61d23a-0cc5-44d8-bab9-723b4e98a6f8'),
('2020-04-19 21:00:22', '', '', 'assistant_manager', 'assistant_manager_office', '5b580a96-94ea-415b-b9e7-19e45567b178'),
('2020-04-19 21:00:23', '', '', 'assistant_manager', 'assistant_manager_office', '4018d73e-0b62-4376-a152-441b3c3648d1'),
('2020-11-18 21:00:00', '41ec8419-f09b-4447-9a9f-c9ab0e6f6a8d', '', 'surgeon', 'surgeries', ''),
('2020-11-18 21:00:01', '6fac57bf-9ff4-4d2a-89e8-896182b46847', '', 'surgeon', 'surgeries', ''),
('2020-11-18 21:00:02', '86838a99-7e2e-4e59-a3ea-9bd212737645', '', 'neurologist', 'neurology', ''),
('2020-11-18 21:00:03', '786a2db4-7788-49a2-834d-126cab22e9db', '', 'neurologist', 'neurology', ''),
('2020-11-18 21:00:04', '32af0506-84bf-4103-8f16-9bc2edb7fc0a', '', 'haematologist', 'haematology', ''),
('2020-11-18 21:00:05', '249157ce-03f9-4146-8109-ca7c55484a0b', '', 'haematologist', 'haematology', ''),
('2020-11-18 21:00:06', '8c5d3d17-a347-4ae8-977e-bd5639b9e50c', '', 'general_practitioner', 'general_practices', ''),
('2020-11-18 21:00:07', '77b308c1-af96-476f-abbe-b7f892611c57', '', 'general_practitioner', 'general_practices', ''),
('2020-11-18 21:00:08', 'e7b16330-7c14-4301-8190-84b006d6367c', '', 'cardiologist', 'cardiology', ''),
('2020-11-18 21:00:09', '85e95ea0-d46c-4252-9e03-24d3f08aa0f0', '', 'cardiologist', 'cardiology', ''),
('2020-11-18 21:00:10', '', '4e3c1af1-de1a-4b7b-91fd-1e7eaa2fc5af', 'nurse_surgeon', 'surgeries', ''),
('2020-11-18 21:00:11', '', '94f5f97b-4e11-49c9-bfad-7f585317972a', 'nurse_surgeon', 'surgeries', ''),
('2020-11-18 21:00:12', '', '9df88ebb-578d-494c-8bc5-60ecc6d39e1a', 'nurse_neurologist', 'neurology', ''),
('2020-11-18 21:00:13', '', '774a249d-2810-4109-8476-4642c5241023', 'nurse_neurologist', 'neurology', ''),
('2020-11-18 21:00:14', '', '7a255c3a-c3f7-4a72-9ec1-1d48c5c309ae', 'nurse_haematologist', 'haematology', ''),
('2020-11-18 21:00:15', '', 'ff58bbde-128f-4b85-8dd0-75bd699cd90e', 'nurse_haematologist', 'haematology', ''),
('2020-11-18 21:00:16', '', '25031ff0-555a-4c84-8855-7b206adcd8f0', 'nurse_general_practitioner', 'general_practices', ''),
('2020-11-18 21:00:17', '', '98c69da9-e9ef-48e0-b7b5-9ac4e3a36abe', 'nurse_general_practitioner', 'general_practices', ''),
('2020-11-18 21:00:18', '', '', 'employee', 'employee_office', '1fe647f8-8772-4ea5-b938-2c206b7266a8'),
('2020-11-18 21:00:19', '', '', 'employee', 'employee_office', '5609d1aa-afc9-4dbe-ae15-7fae2b39135a'),
('2020-11-18 21:00:20', '', '', 'administrative', 'administrative_office', '8c61d23a-0cc5-44d8-bab9-723b4e98a6f8'),
('2020-11-18 21:00:21', '', '', 'administrative', 'administrative_office', 'b4a28645-3df7-41c4-9abc-23e1882ca0a0'),
('2020-11-18 21:00:22', '', '', 'assistant_manager', 'assistant_manager_office', '4018d73e-0b62-4376-a152-441b3c3648d1'),
('2020-11-18 21:00:23', '', '', 'assistant_manager', 'assistant_manager_office', '50155b3e-2f85-46fa-b0d4-2dcae4cf67b7'),
('2021-01-17 21:00:00', '41ec8419-f09b-4447-9a9f-c9ab0e6f6a8d', '', 'surgeon', 'surgeries', ''),
('2021-01-17 21:00:01', '6fac57bf-9ff4-4d2a-89e8-896182b46847', '', 'surgeon', 'surgeries', ''),
('2021-01-17 21:00:02', '7e8a33f1-05d2-45ab-a758-b021c50ba529', '', 'neurologist', 'neurology', ''),
('2021-01-17 21:00:03', '51f62cd9-f9c1-4860-846c-d93b3ac9f4b9', '', 'neurologist', 'neurology', ''),
('2021-01-17 21:00:04', '249157ce-03f9-4146-8109-ca7c55484a0b', '', 'haematologist', 'haematology', ''),
('2021-01-17 21:00:05', '32af0506-84bf-4103-8f16-9bc2edb7fc0a', '', 'haematologist', 'haematology', ''),
('2021-01-17 21:00:06', '77b308c1-af96-476f-abbe-b7f892611c57', '', 'general_practitioner', 'general_practices', ''),
('2021-01-17 21:00:07', '8af0a3d9-55b4-44ad-ad9d-bacb378e2b74', '', 'general_practitioner', 'general_practices', ''),
('2021-01-17 21:00:08', 'aafe811a-679c-4e3b-95b2-63e294c8d8a9', '', 'cardiologist', 'cardiology', ''),
('2021-01-17 21:00:09', 'e7b16330-7c14-4301-8190-84b006d6367c', '', 'cardiologist', 'cardiology', ''),
('2021-01-17 21:00:10', '', '4e3c1af1-de1a-4b7b-91fd-1e7eaa2fc5af', 'nurse_surgeon', 'surgeries', ''),
('2021-01-17 21:00:11', '', '00b51a91-37e5-469e-b4cb-bbe693cbb343', 'nurse_surgeon', 'surgeries', ''),
('2021-01-17 21:00:12', '', 'f81c60cd-28dd-4fd8-b474-f2c160f0318d', 'nurse_neurologist', 'neurology', ''),
('2021-01-17 21:00:13', '', '9df88ebb-578d-494c-8bc5-60ecc6d39e1a', 'nurse_neurologist', 'neurology', ''),
('2021-01-17 21:00:14', '', 'd72ebe93-0acc-4a90-8e6b-e8ea1ac2f5b1', 'nurse_haematologist', 'haematology', ''),
('2021-01-17 21:00:15', '', '80e76861-ca9b-4f04-82d7-e98dad6986d5', 'nurse_haematologist', 'haematology', ''),
('2021-01-17 21:00:16', '', '465e9165-d754-4fd1-a7f7-1d6415b8399c', 'nurse_general_practitioner', 'general_practices', ''),
('2021-01-17 21:00:17', '', '25031ff0-555a-4c84-8855-7b206adcd8f0', 'nurse_general_practitioner', 'general_practices', ''),
('2021-01-17 21:00:18', '', '', 'employee', 'employee_office', '5dc13966-b562-4fb3-8dae-45792fac523a'),
('2021-01-17 21:00:19', '', '', 'employee', 'employee_office', 'b119af78-d5cc-4c4f-9039-78d43009a5f3'),
('2021-01-17 21:00:20', '', '', 'administrative', 'administrative_office', '7d6fea0a-ed6d-408d-8fae-b84f7d5dc5af'),
('2021-01-17 21:00:21', '', '', 'administrative', 'administrative_office', 'b4a28645-3df7-41c4-9abc-23e1882ca0a0'),
('2021-01-17 21:00:22', '', '', 'assistant_manager', 'assistant_manager_office', '6303b90b-5752-4e5c-bd44-8b46255d0199'),
('2021-01-17 21:00:23', '', '', 'assistant_manager', 'assistant_manager_office', '8a38be1e-eb4a-461a-a1f2-524e0b183384');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `suffers_from`
--

CREATE TABLE `suffers_from` (
  `patient_id` varchar(50) NOT NULL,
  `disease_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `supervised_by`
--

CREATE TABLE `supervised_by` (
  `exam_id` varchar(50) NOT NULL,
  `med_id` varchar(50) DEFAULT NULL,
  `doctor_id` varchar(50) DEFAULT NULL,
  `diagnose_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `surgeon`
--

CREATE TABLE `surgeon` (
  `doctor_id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `email` varchar(26) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `surgeon`
--

INSERT INTO `surgeon` (`doctor_id`, `name`, `lastname`, `phone`, `address`, `username`, `password`, `email`, `employee_id`) VALUES
('14d35947-0716-42d8-880e-de1f28395383', 'doc', 'doc', '1234567890', 'address z 12', 'doc12', 'docdoc', 'doc12@example.com', ''),
('41ec8419-f09b-4447-9a9f-c9ab0e6f6a8d', 'doc', 'doc', '1234567890', 'address z 15', 'doc15', 'docdoc', 'doc15@example.com', ''),
('634bf26a-e568-44df-a65f-754d533cc729', 'doc', 'doc', '1234567890', 'address z 14', 'doc14', 'docdoc', 'doc14@example.com', ''),
('6fac57bf-9ff4-4d2a-89e8-896182b46847', 'doc', 'doc', '1234567890', 'address z 13', 'doc13', 'docdoc', 'doc13@example.com', ''),
('8ad68f51-9e3e-4889-9a71-dfce5ed48bb5', 'doc', 'doc', '1234567890', 'address z 11', 'doc11', 'docdoc', 'doc11@example.com', '');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `undergo`
--

CREATE TABLE `undergo` (
  `patient_id` varchar(50) NOT NULL,
  `exam_id` varchar(50) NOT NULL,
  `date` datetime DEFAULT NULL,
  `symptoms` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `undergo`
--

INSERT INTO `undergo` (`patient_id`, `exam_id`, `date`, `symptoms`) VALUES
('16a7955b-5ea4-49a3-a435-9f5898d0c296', 'c8d47edc-45eb-4d12-95f6-ef5d867302d7', '2021-01-17 21:00:03', NULL),
('16a7955b-5ea4-49a3-a435-9f5898d0c296', 'd720c9c6-70ad-47cf-a1dc-0efd2ec39d0e', '2021-01-17 21:00:03', NULL),
('5544dfc3-adbe-4ebf-a50c-1cc6f6371e6e', '23bf1569-45e0-4933-86b1-141b23541aad', '2021-01-17 21:00:01', NULL),
('9bffab13-e791-4186-918c-b8dbc0130842', '289f907b-0e68-4612-b603-2f4599cc4e1f', '2021-01-17 21:00:04', NULL),
('9bffab13-e791-4186-918c-b8dbc0130842', 'ff6ec6a5-c942-413d-a11c-14299b2df1e8', '2021-01-17 21:00:04', NULL),
('ae1fb13a-39fb-4146-9888-108163addba6', '7d6cb9c2-e450-4f40-9d0c-f7776070474b', '2021-01-17 21:00:06', NULL),
('f3a7533d-2044-49c0-84b0-97a921c9f94b', '209b833a-452a-4978-9f4b-9ab1cd9a69ac', '2021-01-17 21:00:02', NULL),
('f3a7533d-2044-49c0-84b0-97a921c9f94b', 'afe93784-fb24-4fbe-b2b2-cb2bf1abffca', '2021-01-17 21:00:02', NULL);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `visit`
--

CREATE TABLE `visit` (
  `patient_id` varchar(50) NOT NULL,
  `date` datetime NOT NULL,
  `cure` varchar(40) DEFAULT NULL,
  `doctor_id` varchar(50) DEFAULT NULL,
  `nurse_id` varchar(50) DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `visit`
--

INSERT INTO `visit` (`patient_id`, `date`, `cure`, `doctor_id`, `nurse_id`, `employee_id`, `state`) VALUES
('16a7955b-5ea4-49a3-a435-9f5898d0c296', '2021-01-17 21:00:03', 'pfizer_bionteck_covid19', '77b308c1-af96-476f-abbe-b7f892611c57', '98c69da9-e9ef-48e0-b7b5-9ac4e3a36abe', '', 'released'),
('2bd44f8b-d2d0-439f-bbeb-ef7a11d3ae2c', '2021-01-10 00:00:00', '', '', '', '', 'STABLE'),
('5544dfc3-adbe-4ebf-a50c-1cc6f6371e6e', '2021-01-17 21:00:01', 'cardiolip', 'aafe811a-679c-4e3b-95b2-63e294c8d8a9', '', '', 'hospitalized'),
('576598e2-e935-43e3-a2e5-3fb05b1610dc', '2021-01-10 00:00:00', '', '', '', '', 'STABLE'),
('7d45a6a1-0fdb-4b6b-aff5-da446eb4ef14', '2021-01-10 00:00:00', '', '', '', '', 'STABLE'),
('8ceba197-1e72-45e0-a3b8-ff8062fb4941', '2021-01-10 00:00:00', '', '', '', '', 'STABLE'),
('9bffab13-e791-4186-918c-b8dbc0130842', '2021-01-17 21:00:04', 'intravenous_fluid', '249157ce-03f9-4146-8109-ca7c55484a0b', '05b9586a-ec27-4b20-b828-e2e062c5cfad', '', 'hospitalized'),
('ae1fb13a-39fb-4146-9888-108163addba6', '2021-01-17 21:00:06', 'Temozolomide', '', '', '', ''),
('daf96912-8e32-4336-872c-4b0734f26e2d', '2021-01-10 00:00:00', '', '', '', '', 'STABLE'),
('f3a7533d-2044-49c0-84b0-97a921c9f94b', '2021-01-17 21:00:02', 'Exelon', '7e8a33f1-05d2-45ab-a758-b021c50ba529', 'b9401477-6950-4536-acc0-2a1c19137459', '', 'released');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `visit_diseases`
--

CREATE TABLE `visit_diseases` (
  `date` datetime NOT NULL,
  `patient_id` varchar(50) NOT NULL,
  `diseases` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `visit_diseases`
--

INSERT INTO `visit_diseases` (`date`, `patient_id`, `diseases`) VALUES
('2021-01-17 21:00:03', '16a7955b-5ea4-49a3-a435-9f5898d0c296', 'cancer'),
('2021-01-17 21:00:03', '16a7955b-5ea4-49a3-a435-9f5898d0c296', 'flu'),
('2021-01-10 00:00:00', '2bd44f8b-d2d0-439f-bbeb-ef7a11d3ae2c', 'cancer'),
('2021-01-17 21:00:01', '5544dfc3-adbe-4ebf-a50c-1cc6f6371e6e', 'diabetes'),
('2021-01-17 21:00:01', '5544dfc3-adbe-4ebf-a50c-1cc6f6371e6e', 'flu'),
('2021-01-10 00:00:00', '576598e2-e935-43e3-a2e5-3fb05b1610dc', 'cancer'),
('2021-01-10 00:00:00', '7d45a6a1-0fdb-4b6b-aff5-da446eb4ef14', 'cancer'),
('2021-01-10 00:00:00', '8ceba197-1e72-45e0-a3b8-ff8062fb4941', 'cancer'),
('2021-01-17 21:00:04', '9bffab13-e791-4186-918c-b8dbc0130842', 'diabetes'),
('2021-01-17 21:00:04', '9bffab13-e791-4186-918c-b8dbc0130842', 'staphylococos'),
('2021-01-17 21:00:06', 'ae1fb13a-39fb-4146-9888-108163addba6', 'COVID'),
('2021-01-17 21:00:06', 'ae1fb13a-39fb-4146-9888-108163addba6', 'dehydration'),
('2021-01-10 00:00:00', 'daf96912-8e32-4336-872c-4b0734f26e2d', 'cancer'),
('2021-01-17 21:00:02', 'f3a7533d-2044-49c0-84b0-97a921c9f94b', 'flu'),
('2021-01-17 21:00:02', 'f3a7533d-2044-49c0-84b0-97a921c9f94b', 'pneumonia');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `visit_symptoms`
--

CREATE TABLE `visit_symptoms` (
  `patient_id` varchar(50) NOT NULL,
  `date` datetime NOT NULL,
  `symptoms` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Άδειασμα δεδομένων του πίνακα `visit_symptoms`
--

INSERT INTO `visit_symptoms` (`patient_id`, `date`, `symptoms`) VALUES
('16a7955b-5ea4-49a3-a435-9f5898d0c296', '2021-01-17 21:00:03', 'cough'),
('16a7955b-5ea4-49a3-a435-9f5898d0c296', '2021-01-17 21:00:03', 'fever'),
('16a7955b-5ea4-49a3-a435-9f5898d0c296', '2021-01-17 21:00:03', 'sneezing'),
('2bd44f8b-d2d0-439f-bbeb-ef7a11d3ae2c', '2021-01-10 00:00:00', 'heart_pain'),
('5544dfc3-adbe-4ebf-a50c-1cc6f6371e6e', '2021-01-17 21:00:01', 'heart_pain'),
('5544dfc3-adbe-4ebf-a50c-1cc6f6371e6e', '2021-01-17 21:00:01', 'trouble_walking'),
('576598e2-e935-43e3-a2e5-3fb05b1610dc', '2021-01-10 00:00:00', 'heart_pain'),
('7d45a6a1-0fdb-4b6b-aff5-da446eb4ef14', '2021-01-10 00:00:00', 'heart_pain'),
('8ceba197-1e72-45e0-a3b8-ff8062fb4941', '2021-01-10 00:00:00', 'heart_pain'),
('9bffab13-e791-4186-918c-b8dbc0130842', '2021-01-17 21:00:04', 'dry_mouth'),
('9bffab13-e791-4186-918c-b8dbc0130842', '2021-01-17 21:00:04', 'weight_loss'),
('ae1fb13a-39fb-4146-9888-108163addba6', '2021-01-17 21:00:06', 'headaches'),
('ae1fb13a-39fb-4146-9888-108163addba6', '2021-01-17 21:00:06', 'nausea'),
('daf96912-8e32-4336-872c-4b0734f26e2d', '2021-01-10 00:00:00', 'heart_pain'),
('f3a7533d-2044-49c0-84b0-97a921c9f94b', '2021-01-17 21:00:02', 'memory_loss');

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_cardiologist`
--
DROP TABLE IF EXISTS `employee_to_cardiologist`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_cardiologist`  AS SELECT `cardiologist`.`doctor_id` AS `doctor_id`, `cardiologist`.`name` AS `name`, `cardiologist`.`lastname` AS `lastname`, `cardiologist`.`username` AS `username`, `cardiologist`.`email` AS `email` FROM `cardiologist` ;

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_gp`
--
DROP TABLE IF EXISTS `employee_to_gp`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_gp`  AS SELECT `general_practitioner`.`doctor_id` AS `doctor_id`, `general_practitioner`.`name` AS `name`, `general_practitioner`.`lastname` AS `lastname`, `general_practitioner`.`username` AS `username`, `general_practitioner`.`email` AS `email` FROM `general_practitioner` ;

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_haematologist`
--
DROP TABLE IF EXISTS `employee_to_haematologist`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_haematologist`  AS SELECT `haematologist`.`doctor_id` AS `doctor_id`, `haematologist`.`name` AS `name`, `haematologist`.`lastname` AS `lastname`, `haematologist`.`username` AS `username`, `haematologist`.`email` AS `email` FROM `haematologist` ;

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_neurologist`
--
DROP TABLE IF EXISTS `employee_to_neurologist`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_neurologist`  AS SELECT `neurologist`.`doctor_id` AS `doctor_id`, `neurologist`.`name` AS `name`, `neurologist`.`lastname` AS `lastname`, `neurologist`.`username` AS `username`, `neurologist`.`email` AS `email` FROM `neurologist` ;

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_n_gp`
--
DROP TABLE IF EXISTS `employee_to_n_gp`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_n_gp`  AS SELECT `nurse_general_practitioner`.`nurse_id` AS `nurse_id`, `nurse_general_practitioner`.`name` AS `name`, `nurse_general_practitioner`.`lastname` AS `lastname`, `nurse_general_practitioner`.`username` AS `username`, `nurse_general_practitioner`.`email` AS `email` FROM `nurse_general_practitioner` ;

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_n_haematologist`
--
DROP TABLE IF EXISTS `employee_to_n_haematologist`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_n_haematologist`  AS SELECT `nurse_haematologist`.`nurse_id` AS `nurse_id`, `nurse_haematologist`.`name` AS `name`, `nurse_haematologist`.`lastname` AS `lastname`, `nurse_haematologist`.`username` AS `username`, `nurse_haematologist`.`email` AS `email` FROM `nurse_haematologist` ;

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_n_neurologist`
--
DROP TABLE IF EXISTS `employee_to_n_neurologist`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_n_neurologist`  AS SELECT `nurse_neurologist`.`nurse_id` AS `nurse_id`, `nurse_neurologist`.`name` AS `name`, `nurse_neurologist`.`lastname` AS `lastname`, `nurse_neurologist`.`username` AS `username`, `nurse_neurologist`.`email` AS `email` FROM `nurse_neurologist` ;

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_n_surgeon`
--
DROP TABLE IF EXISTS `employee_to_n_surgeon`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_n_surgeon`  AS SELECT `nurse_surgeon`.`nurse_id` AS `nurse_id`, `nurse_surgeon`.`name` AS `name`, `nurse_surgeon`.`lastname` AS `lastname`, `nurse_surgeon`.`username` AS `username`, `nurse_surgeon`.`email` AS `email` FROM `nurse_surgeon` ;

-- --------------------------------------------------------

--
-- Δομή για προβολή `employee_to_surgeon`
--
DROP TABLE IF EXISTS `employee_to_surgeon`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_to_surgeon`  AS SELECT `surgeon`.`doctor_id` AS `doctor_id`, `surgeon`.`name` AS `name`, `surgeon`.`lastname` AS `lastname`, `surgeon`.`username` AS `username`, `surgeon`.`email` AS `email` FROM `surgeon` ;

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `administrative`
--
ALTER TABLE `administrative`
  ADD PRIMARY KEY (`employee_id`,`username`);

--
-- Ευρετήρια για πίνακα `assistant_manager`
--
ALTER TABLE `assistant_manager`
  ADD PRIMARY KEY (`employee_id`,`username`);

--
-- Ευρετήρια για πίνακα `cardiologist`
--
ALTER TABLE `cardiologist`
  ADD PRIMARY KEY (`doctor_id`,`username`);

--
-- Ευρετήρια για πίνακα `diagnose`
--
ALTER TABLE `diagnose`
  ADD PRIMARY KEY (`diagnose_id`,`exam_id`);

--
-- Ευρετήρια για πίνακα `diagnose_symptoms`
--
ALTER TABLE `diagnose_symptoms`
  ADD PRIMARY KEY (`diagnose_id`,`exam_id`,`symptoms`);

--
-- Ευρετήρια για πίνακα `disease`
--
ALTER TABLE `disease`
  ADD PRIMARY KEY (`name`);

--
-- Ευρετήρια για πίνακα `disease_symptoms`
--
ALTER TABLE `disease_symptoms`
  ADD PRIMARY KEY (`name`,`symptoms`);

--
-- Ευρετήρια για πίνακα `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`username`,`doctor_id`);

--
-- Ευρετήρια για πίνακα `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`,`username`);

--
-- Ευρετήρια για πίνακα `examination`
--
ALTER TABLE `examination`
  ADD PRIMARY KEY (`exam_id`);

--
-- Ευρετήρια για πίνακα `general_practitioner`
--
ALTER TABLE `general_practitioner`
  ADD PRIMARY KEY (`doctor_id`,`username`);

--
-- Ευρετήρια για πίνακα `haematologist`
--
ALTER TABLE `haematologist`
  ADD PRIMARY KEY (`doctor_id`,`username`);

--
-- Ευρετήρια για πίνακα `medication`
--
ALTER TABLE `medication`
  ADD PRIMARY KEY (`med_id`);

--
-- Ευρετήρια για πίνακα `neurologist`
--
ALTER TABLE `neurologist`
  ADD PRIMARY KEY (`doctor_id`,`username`);

--
-- Ευρετήρια για πίνακα `nurse`
--
ALTER TABLE `nurse`
  ADD PRIMARY KEY (`username`,`nurse_id`);

--
-- Ευρετήρια για πίνακα `nurse_general_practitioner`
--
ALTER TABLE `nurse_general_practitioner`
  ADD PRIMARY KEY (`nurse_id`,`username`);

--
-- Ευρετήρια για πίνακα `nurse_haematologist`
--
ALTER TABLE `nurse_haematologist`
  ADD PRIMARY KEY (`nurse_id`,`username`);

--
-- Ευρετήρια για πίνακα `nurse_neurologist`
--
ALTER TABLE `nurse_neurologist`
  ADD PRIMARY KEY (`nurse_id`,`username`);

--
-- Ευρετήρια για πίνακα `nurse_surgeon`
--
ALTER TABLE `nurse_surgeon`
  ADD PRIMARY KEY (`nurse_id`,`username`);

--
-- Ευρετήρια για πίνακα `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`exam_id`);

--
-- Ευρετήρια για πίνακα `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patient_id`,`username`);

--
-- Ευρετήρια για πίνακα `prescribe`
--
ALTER TABLE `prescribe`
  ADD PRIMARY KEY (`exam_id`,`med_id`);

--
-- Ευρετήρια για πίνακα `shift`
--
ALTER TABLE `shift`
  ADD PRIMARY KEY (`date`);

--
-- Ευρετήρια για πίνακα `suffers_from`
--
ALTER TABLE `suffers_from`
  ADD PRIMARY KEY (`patient_id`,`disease_name`);

--
-- Ευρετήρια για πίνακα `supervised_by`
--
ALTER TABLE `supervised_by`
  ADD PRIMARY KEY (`exam_id`);

--
-- Ευρετήρια για πίνακα `surgeon`
--
ALTER TABLE `surgeon`
  ADD PRIMARY KEY (`doctor_id`,`username`);

--
-- Ευρετήρια για πίνακα `undergo`
--
ALTER TABLE `undergo`
  ADD PRIMARY KEY (`patient_id`,`exam_id`);

--
-- Ευρετήρια για πίνακα `visit`
--
ALTER TABLE `visit`
  ADD PRIMARY KEY (`patient_id`,`date`);

--
-- Ευρετήρια για πίνακα `visit_diseases`
--
ALTER TABLE `visit_diseases`
  ADD PRIMARY KEY (`patient_id`,`date`,`diseases`);

--
-- Ευρετήρια για πίνακα `visit_symptoms`
--
ALTER TABLE `visit_symptoms`
  ADD PRIMARY KEY (`patient_id`,`date`,`symptoms`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
