-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2015 at 10:14 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `studentwork`
--

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE IF NOT EXISTS `feedbacks` (
`id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `time` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
`id` int(11) NOT NULL,
  `ownerId` int(11) NOT NULL,
  `senderId` int(11) NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `ownerId`, `senderId`, `content`, `status`) VALUES
(1, 1, 2, 'Anh mai yeu em', 1),
(2, 1, 2, 'Đây là tn thứ 2', 1),
(3, 1, 2, 'Đây là tn thứ 3', 1),
(4, 1, 3, 'Đây là của thanwhf khác', 2);

-- --------------------------------------------------------

--
-- Table structure for table `relationships`
--

CREATE TABLE IF NOT EXISTS `relationships` (
`relationshipId` int(11) NOT NULL,
  `fromUserId` int(11) NOT NULL,
  `toUserId` int(11) NOT NULL,
  `status` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student_awards`
--

CREATE TABLE IF NOT EXISTS `student_awards` (
`id` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `award` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `more` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_awards`
--

INSERT INTO `student_awards` (`id`, `studentID`, `award`, `year`, `more`) VALUES
(2, 0, 'Giai dep trai nhat Ha Noi', 2014, 'Giai danh cho nhung thanh nien sinh nam 1994 hoc ngu nhat nhung deptrai nhat'),
(3, 0, 'Giai hoc ngu nhat Vn', 2006, 'Ngu vl'),
(4, 1, 'Chém gió', 13232, '23qs1'),
(5, 1, 'Anh yêu em', 13232, ''),
(7, 1, 'An lz nhe', 2015, 'ư'),
(8, 1, 'qưq', 2015, '');

-- --------------------------------------------------------

--
-- Table structure for table `student_basic`
--

CREATE TABLE IF NOT EXISTS `student_basic` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `college` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `inYear` int(4) DEFAULT NULL,
  `major` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `maritalStatus` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nation` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `more` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_basic`
--

INSERT INTO `student_basic` (`id`, `studentId`, `birthday`, `gender`, `college`, `inYear`, `major`, `maritalStatus`, `nation`, `more`) VALUES
(1, 1, '2015-04-01', 'male', 'DH Cong Nghe - DHQGHN', 0, 'Khoa hoc may tinh', 'doc than', 'Viet Nam', 'Dang tim kiem nguoi yeu'),
(2, 3, '2015-04-05', 'male', '', 0, '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `student_certifications`
--

CREATE TABLE IF NOT EXISTS `student_certifications` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `certification` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_certifications`
--

INSERT INTO `student_certifications` (`id`, `studentId`, `certification`, `year`) VALUES
(1, 1, 'Ăn buồi ko', 2015);

-- --------------------------------------------------------

--
-- Table structure for table `student_events`
--

CREATE TABLE IF NOT EXISTS `student_events` (
`id` int(11) NOT NULL,
  `studentID` int(11) DEFAULT NULL,
  `event` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `place` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `time` date DEFAULT NULL,
  `more` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_events`
--

INSERT INTO `student_events` (`id`, `studentID`, `event`, `place`, `time`, `more`) VALUES
(7, 1, 'q', 'q', '2015-01-01', 'q');

-- --------------------------------------------------------

--
-- Table structure for table `student_exp`
--

CREATE TABLE IF NOT EXISTS `student_exp` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `company` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startTime` date DEFAULT NULL,
  `finishTime` date DEFAULT NULL,
  `more` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_exp`
--

INSERT INTO `student_exp` (`id`, `studentId`, `company`, `title`, `startTime`, `finishTime`, `more`) VALUES
(1, 1, 'FSOFT', 'Làm tình', '2015-01-01', '2015-01-01', '');

-- --------------------------------------------------------

--
-- Table structure for table `student_interests`
--

CREATE TABLE IF NOT EXISTS `student_interests` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `interest` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_interests`
--

INSERT INTO `student_interests` (`id`, `studentId`, `interest`) VALUES
(1, 1, 'Play game: Aoe Of Empires'),
(2, 1, 'Xem film 20+');

-- --------------------------------------------------------

--
-- Table structure for table `student_languages`
--

CREATE TABLE IF NOT EXISTS `student_languages` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `language` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `level` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student_posts`
--

CREATE TABLE IF NOT EXISTS `student_posts` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `content` text COLLATE utf8_unicode_ci,
  `time` datetime DEFAULT NULL,
  `likes` int(11) NOT NULL,
  `comments` int(11) NOT NULL,
  `shares` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_posts`
--

INSERT INTO `student_posts` (`id`, `studentId`, `content`, `time`, `likes`, `comments`, `shares`) VALUES
(13, 1, 'Em cắn chặt môi mình, em muốn chia tay anh ạ. Nhưng em không biết lý do, thậm chí, tận sâu trong trái tim mình, em vẫn cồn cào những nỗi nhớ và da diết yêu anh...\r\n\r\nMỗi lần mình bên nhau em vẫn luôn hỏi anh: “Lý do gì khiến anh yêu em?” dẫu đôi khi chẳng cần những câu trả lời. Không phải vì em không biết, cũng không hẳn là vì muốn nghe, cũng chẳng đến mức cần xác định tình cảm, tất cả chỉ vì em thấy mình đáng yêu hơn khi hỏi anh như vậy.\r\n\r\nÍt ra những lúc đó, em có thể cảm thấy tim mình ấm dần lên khi biết có một người đang nghe em nói và em có một đối tượng để có thể hỏi.Thì thầm 97 được thực hiện bởi Kún và Nhóm Sản Xuất\r\nYêu không cần lý do\r\nẢnh minh họa\r\nHàng trăm, hàng vạn lần câu cửa miệng của em với anh vẫn là câu hỏi đó. Em không biết tại sao còn có nhiều thắc mắc khác mà em không hỏi, tại sao cứ mãi là câu hỏi đó để rồi biết em không thể có 1 câu trả lời chính xác và đôi khi làm anh đau đầu tìm một lý do để thỏa mãn em. Thế nhưng chưa một lần em đặt tay lên tim mình tự hỏi: “Lý do gì khiến em yêu anh?”\r\n\r\nĐể rồi một ngày khi mình xa nhau, em vẫn ích kỉ mang câu hỏi đó giấu trong lòng, ngọ nguậy và làm nổ tung tất thảy. Lần cuối, anh đặt tay mình nắm lấy những ngón tay đang cựa quậy run rẩy nơi em và nói:\r\n\r\n- Lý do gì khiến em yêu anh?\r\n\r\nEm khẽ cười – Một nụ cười thật nhạt hòa lẫn trong làn nước mưa lạnh ngắt\r\n\r\n- Vậy em muốn biết lý do gì khiến anh hết yêu em không?\r\n\r\nBàn tay em tuột khỏi lòng bàn tay anh. Nó bơ vơ và cô đơn đến tội nghiệp. Khi còn yêu nhau, những câu hỏi vẫn luôn dở dang không có đáp án, vậy mà khi chia tay, chẳng phải chỉ cần hết yêu là hết yêu, sao cần những lý do làm cớ?\r\n\r\n- Mình chia tay nhé!\r\n\r\nEm cắn chặt môi mình, em muốn chia tay anh ạ. Nhưng em không biết lý do, thậm chí, tận sâu trong trái tim mình, em vẫn cồn cào những nỗi nhớ và da diết yêu anh. Lí do? Lại là những lý do? Trong cuộc tình của chúng mình, những yêu thương đã sớm nhường chỗ cho những lý do không cần thiết. Và như thế, em và anh chia tay không lý do, đúng hơn là bắt đầu với những câu hỏi và tận khi kết thúc cũng vẫn chưa có câu trả lời!\r\nYêu không cần lý do\r\nẢnh minh họa\r\n3 tháng sau\r\n\r\nEm yêu một người khác!\r\n\r\nKhông tồn tại những khúc mắc hay lý do quẩn quanh như đã từng với anh. Em sống yên lặng hơn và thỏa mãn với thứ tình yêu tẻ nhạt bên cạnh. Em thú nhận rằng đôi khi mún được nổi loạn, nhưng em không làm được, bởi lẽ em không có lý do - những lý do để thay đổi!\r\n\r\nNhư cây khô lâu ngày không được tưới, thứ tình cảm trong em hao mòn và ngày một chai sạn. Kết thúc thứ tình yêu không sóng gió này là một cái tát in hằn năm ngón tay mình trên má người bạn trai .\r\n\r\nEm chia tay... lại một lần nữa!\r\n\r\nNhưng lần này, em có lý do để từ bỏ, để cuốn gói mọi cảm xúc và ném thẳng vào quãng thời gian 2 tháng qua một cách tỉnh táo nhất. Lý do đó chẳng qua là: Người yêu em có một người bạn gái khác ngoài em! Em trách anh ta đã thay đổi! Thế nhưng chưa một lần em đặt tay lên tim mình và tự hỏi: “Lẽ nào chưa bao giờ em đổi thay?”\r\n\r\nEm đã khác xưa rất nhiều. Em yêu người sau bằng cái cách em nghĩ là an toàn và không rạn nứt. Em yêu người sau bằng cái cách không giống như đã từng với anh. Em yêu người sau bằng cả con người không phải là em. Và rồi thì thứ tình yêu', '2015-04-07 00:00:00', 0, 0, 0),
(14, 1, 'Lý do gì khiến ta thông nhau? Em chán a nh rồi\n\n\nVì sao', '2015-04-05 10:25:55', 0, 0, 0),
(28, 1, 'Ngợp mắt’ trước vẻ lộng lẫy của dàn mỹ nhân Việt trên thảm đỏ HTV Awards 05/04/2015 | TuanzyPh | 1040 lượt xem (Blogtamsu) - Người hâm mộ đã được "chiêu đãi" bữa tiệc thời trang của loạt sao Việt đình đám, đổ bộ trên thảm đỏ của lễ trao giải HTV Awards tối 4/4. Sky thi nhau truyền tay bản rap “Cứ việc ghét Sơn Tùng” Mỹ nhân Việt “thi nhau” gây chú ý với vòng 1 “vượt mặt” Hà Tăng và Thu Minh: Những điểm chung của 2 bà bầu đang ‘hot’ nhất Vbiz Vào tối 4/4, lễ trao giải HTV Awards đã được tổ chức long trọng tại Tp. HCM với sự góp mặt của nhiều khách mời là những nghệ sĩ nổi tiếng trong làng giải trí Việt. Sẽ là một thiếu sót nếu không nhắc tới sự tham dự của dàn mỹ nhân lộng lẫy tỏa sáng rực rỡ khu vực thảm đỏ như Thanh Hằng, Lý Nhã Kỳ, Minh Hằng, Tóc Tiên, Diễm My 9X,… Sự ‘đổ bộ’ của nhiều style váy dạ hội được thiết kế nổi bật, kì công giúp các người đẹp tự tin khoe nét quyến rũ, sang trọng tại đêm hội trao giải lần này. Không hề tỏ ra thua kém đàn chị, Tóc Tiên gợi cảm với đầm đuôi cá khoe vai trần, Diễm My 9X tôn vóc dáng ngọc ngà với áo dài cách điệu, MC The Remix Hoàng Oanh kiêu sa với váy ren đậm chất ‘tiểu thư’,… _MG_3452Siêu mẫu Thanh Hằng tiếp tục trở thành điểm nhấn thu hút bậc nhất trên thảm đỏ với cây trang phục xanh bắt mắt cùng vóc dáng chuẩn đẹp của một siêu mẫu', '2015-04-05 11:47:31', 12, 7, 0),
(29, 1, 'sấ', '2015-04-05 13:23:58', 0, 0, 0),
(30, 1, 'rêf', '2015-04-05 13:33:40', 0, 0, 0),
(31, 1, 'êfe', '2015-04-05 13:36:23', 0, 0, 0),
(32, 1, 'Sao éo đc', '2015-04-05 13:37:04', 0, 0, 0),
(33, 1, 'nhu 1 cai loz', '2015-04-05 13:47:23', 0, 0, 0),
(34, 1, 'Mệt mỏi', '2015-04-05 14:06:14', 0, 0, 0),
(35, 1, 'Sao lại thế', '2015-04-05 14:06:20', 0, 0, 0),
(36, 1, 'nhu ca l', '2015-04-05 14:13:50', 0, 0, 0),
(37, 1, 'nhu cai lo', '2015-04-05 14:14:06', 0, 0, 0),
(38, 1, 'dsds', '2015-04-05 14:14:12', 0, 0, 0),
(39, 1, 'co an loz ko', '2015-04-05 14:33:31', 0, 0, 0),
(40, 1, 'vaic', '2015-04-05 14:40:06', 0, 0, 0),
(41, 1, 'Chán lắm rồi', '2015-04-05 14:40:28', 0, 0, 0),
(42, 1, 'sao jndadmawpdaw faw', '2015-04-05 14:41:48', 0, 0, 0),
(43, 1, 'đs', '2015-04-05 14:43:14', 0, 0, 0),
(44, 1, 'mãi k làm đc', '2015-04-05 14:43:43', 0, 0, 0),
(45, 1, 'ijeorigjwr[kgegr', '2015-04-05 14:44:06', 0, 0, 0),
(46, 1, 'anh k muon', '2015-04-05 14:45:51', 0, 0, 0),
(47, 1, 'ênf', '2015-04-05 14:46:59', 0, 0, 0),
(48, 1, 'Đã đăng thành công', '2015-04-05 14:48:11', 0, 0, 0),
(49, 1, 'đãn ffawng thành công', '2015-04-05 14:48:43', 0, 0, 0),
(50, 1, 'có lẽ a vào em ta nên dừng lại', '2015-04-05 14:51:04', 0, 0, 0),
(51, 1, 'Đời nhu beep', '2015-04-05 15:20:16', 0, 0, 0),
(52, 1, 'adada', '2015-04-07 21:17:40', 0, 0, 0),
(53, 1, 'dvfdfd', '2015-04-09 09:11:26', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student_projects`
--

CREATE TABLE IF NOT EXISTS `student_projects` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `project` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `link` text COLLATE utf8_unicode_ci,
  `more` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_projects`
--

INSERT INTO `student_projects` (`id`, `studentId`, `project`, `link`, `more`) VALUES
(1, 1, NULL, NULL, NULL),
(2, 1, 'Sơn bg', '1', ''),
(3, 1, 'Nhu 1 con gio', '', ''),
(4, 1, 'Anh thông em', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `student_shares`
--

CREATE TABLE IF NOT EXISTS `student_shares` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `postId` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `likes` int(11) NOT NULL,
  `comments` int(11) NOT NULL,
  `shares` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_shares`
--

INSERT INTO `student_shares` (`id`, `studentId`, `postId`, `time`, `likes`, `comments`, `shares`) VALUES
(1, 1, 0, '0000-00-00 00:00:00', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student_skills`
--

CREATE TABLE IF NOT EXISTS `student_skills` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `skill` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `level` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_skills`
--

INSERT INTO `student_skills` (`id`, `studentId`, `skill`, `level`) VALUES
(1, 1, 'Ăn lồn ko?', 5);

-- --------------------------------------------------------

--
-- Table structure for table `student_studyings`
--

CREATE TABLE IF NOT EXISTS `student_studyings` (
`id` int(11) NOT NULL,
  `studentID` int(11) DEFAULT NULL,
  `className` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `score` float DEFAULT NULL,
  `conduct` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_studyings`
--

INSERT INTO `student_studyings` (`id`, `studentID`, `className`, `score`, `conduct`) VALUES
(1, 3, NULL, NULL, NULL),
(2, 1, 'Lớp 12', 96, '1');

-- --------------------------------------------------------

--
-- Table structure for table `student_volunteers`
--

CREATE TABLE IF NOT EXISTS `student_volunteers` (
`id` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `organization` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cause` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startTime` date DEFAULT NULL,
  `finishTime` date DEFAULT NULL,
  `isNow` int(4) DEFAULT NULL,
  `more` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `student_volunteers`
--

INSERT INTO `student_volunteers` (`id`, `studentId`, `organization`, `role`, `cause`, `startTime`, `finishTime`, `isNow`, `more`) VALUES
(1, 1, 'Hoi tinh nguyen sinh vien Luc Ngan', 'Tinh nguyen vien', 'Giup do tre em tan tat', '2015-04-01', NULL, 1, 'Khong co gi dac biet'),
(2, 3, 'Hoi dong sex Viet Nam', 'Dien vien chinh', 'khong co gi dac biet', '2015-04-01', '2017-04-01', 0, 'Khong co gi dac biet');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`id` int(11) NOT NULL,
  `type` text COLLATE utf8_unicode_ci NOT NULL,
  `username` text COLLATE utf8_unicode_ci NOT NULL,
  `email` text COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL,
  `fullname` text COLLATE utf8_unicode_ci,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastLogin` int(11) DEFAULT NULL,
  `lastActivity` int(11) DEFAULT NULL,
  `activation` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `type`, `username`, `email`, `password`, `fullname`, `phone`, `address`, `avatar`, `lastLogin`, `lastActivity`, `activation`) VALUES
(1, 'student', 'nhs3108', 'nhs3108@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Hồng Sơn Nguyễn', '', '', '', -2147483648, 2147483647, ''),
(2, '', 'chandoi', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'student', 'nhu1cailoz', 'nhs3108@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Sơng', '', 'Bac giang', '', -2147483648, 2147483647, '1a2e2e428375749b389af5ee9d861cd9');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `feedbacks`
--
ALTER TABLE `feedbacks`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `relationships`
--
ALTER TABLE `relationships`
 ADD PRIMARY KEY (`relationshipId`);

--
-- Indexes for table `student_awards`
--
ALTER TABLE `student_awards`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_basic`
--
ALTER TABLE `student_basic`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_certifications`
--
ALTER TABLE `student_certifications`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_events`
--
ALTER TABLE `student_events`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_exp`
--
ALTER TABLE `student_exp`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_interests`
--
ALTER TABLE `student_interests`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_languages`
--
ALTER TABLE `student_languages`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_posts`
--
ALTER TABLE `student_posts`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_projects`
--
ALTER TABLE `student_projects`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_shares`
--
ALTER TABLE `student_shares`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_skills`
--
ALTER TABLE `student_skills`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_studyings`
--
ALTER TABLE `student_studyings`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_volunteers`
--
ALTER TABLE `student_volunteers`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `feedbacks`
--
ALTER TABLE `feedbacks`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `relationships`
--
ALTER TABLE `relationships`
MODIFY `relationshipId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student_awards`
--
ALTER TABLE `student_awards`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `student_basic`
--
ALTER TABLE `student_basic`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `student_certifications`
--
ALTER TABLE `student_certifications`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `student_events`
--
ALTER TABLE `student_events`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `student_exp`
--
ALTER TABLE `student_exp`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `student_interests`
--
ALTER TABLE `student_interests`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `student_languages`
--
ALTER TABLE `student_languages`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student_posts`
--
ALTER TABLE `student_posts`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `student_projects`
--
ALTER TABLE `student_projects`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `student_shares`
--
ALTER TABLE `student_shares`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `student_skills`
--
ALTER TABLE `student_skills`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `student_studyings`
--
ALTER TABLE `student_studyings`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `student_volunteers`
--
ALTER TABLE `student_volunteers`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
