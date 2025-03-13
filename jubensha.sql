/*
 Navicat Premium Data Transfer

 Source Server         : javaee01
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : localhost:3306
 Source Schema         : jubensha

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 13/03/2025 10:36:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int NOT NULL,
  `admin_zh` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `admin_pwd` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (402, 'myjc922', '123456');

-- ----------------------------
-- Table structure for jb
-- ----------------------------
DROP TABLE IF EXISTS `jb`;
CREATE TABLE `jb`  (
  `jb_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `jb_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '剧本名',
  `jb_tag` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '剧本分类',
  `jb_num` int NULL DEFAULT NULL COMMENT '剧本开局人数',
  `jb_jj` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '剧本简介',
  `jb_price` int NULL DEFAULT NULL COMMENT '单人价格',
  `jb_status` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '1表示上架，0表示未上架',
  `jb_nd` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '剧本难度',
  `jb_wz` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '剧本图片网址',
  PRIMARY KEY (`jb_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jb
-- ----------------------------
INSERT INTO `jb` VALUES ('1', '余光千百遍', '情感', 6, '我无数次深夜的思念，打了又删的短信，以及隔着人群，总是不自觉瞥向你的余光。这些，最好你永远都不要知道。', 89, 0000000001, '入门', 'https://wx1.sinaimg.cn/mw690/e60238a1gy1hv133tvtedj20m80uk7gl.jpg');
INSERT INTO `jb` VALUES ('10', '安妮弗斯奇遇记', '推理', 6, '我的老朋友海蒂小姐你好。\r\n在丁达尔克书馆做帮工可还顺利？\r\n近来，我因为一桩上世纪末的奇怪案件犯了头疼，因为千年浩劫的缘故太多线索已经无法追溯，如今仅能通过我的归魂使们对案件进行重查，但一查才发现，在浩劫来临前的二十年里，那座小镇上竟有着数不清的诡异案件，这实在有些伤脑筋。', 129, 0000000001, '困难', 'https://wx2.sinaimg.cn/mw690/e60238a1gy1hv144p6w4gj20go0nlgyr.jpg');
INSERT INTO `jb` VALUES ('2', '雪乡连环杀人事件', '恐怖', 6, '年三十，北道河，村里出了个杀人魔。杀了一个又一个，最后一个杀老婆。七个小孩来串门，联起手来把案破。\r\n', 99, 0000000001, '进阶', 'https://wx3.sinaimg.cn/mw690/e60238a1gy1hv133v8bwcj20u0159b29.jpg');
INSERT INTO `jb` VALUES ('2aBcpvn2', '余光千百遍', '情感', 6, '我无数次深夜的思念，打了又删的短信，以及隔着人群，总是不自觉瞥向你的余光。这些，最好你永远都不要知道。', 89, NULL, '入门', 'https://wx1.sinaimg.cn/mw690/e60238a1gy1hv133tvtedj20m80uk7gl.jpg');
INSERT INTO `jb` VALUES ('3', '待君归', '情感', 6, '世人常说，黑白有界，善恶有别。可谁又分得清善恶黑白，是非对错..\r\n天梦一场，一杯入梦酒一场人生梦，不同的人，不同的选择，纵有无数种选择又当如何？一切皆如同日升月落，昼夜分明。\r\n如今我已然知晓，只待与君常相守，可君，何时归', 109, 0000000001, '适中', 'https://wx2.sinaimg.cn/mw690/e60238a1gy1hv133wyxphj21yv2rf1kz.jpg');
INSERT INTO `jb` VALUES ('3tmQpTl5', '余光千百遍', '情感', 6, '我无数次深夜的思念，打了又删的短信，以及隔着人群，总是不自觉瞥向你的余光。这些，最好你永远都不要知道。', 89, NULL, '入门', 'https://wx1.sinaimg.cn/mw690/e60238a1gy1hv133tvtedj20m80uk7gl.jpg');
INSERT INTO `jb` VALUES ('4', '反派修正计划', '阵营', 9, '摄像机？这不降维打击还用飞鸽传书的情报组织！\r\n大电棍？请问哪位武林高手敢与我的大电棍交锋！\r\n青霉素？这位太医，不如试试我这个神药？\r\n穿越夺权两不误，欢乐刺激尽在《反派修正计划》！\r\n让我们在这混乱的位面之中进行一场紧张刺激的修正之旅吧。\r\n', 109, 0000000001, '烧脑', 'https://wx1.sinaimg.cn/mw690/e60238a1gy1hv133t4p5jj20b40fq0v7.jpg');
INSERT INTO `jb` VALUES ('4zoUzpQW', '余光千百遍', '情感', 6, '我无数次深夜的思念，打了又删的短信，以及隔着人群，总是不自觉瞥向你的余光。这些，最好你永远都不要知道。', 89, NULL, '入门', 'https://wx1.sinaimg.cn/mw690/e60238a1gy1hv133tvtedj20m80uk7gl.jpg');
INSERT INTO `jb` VALUES ('5', '烟云南渡', '情感', 7, '我曾在城市的炮火声中听到你们\r\n也曾在山与海的雪色中凝望你们\r\n一寸山河一寸血，十万青年十万兵\r\n风尘仆仆，你们身披朝日与皎月，踏烟云南渡\r\n霞雾莹莹，你们高举祈愿与梦想，望他日北归\r\n决决华夏，处处是你们一撇一擦写下民族之脊梁\r\n浩浩九州，每每是你们挥毫泼墨谱曲中国之战歌\r\n若有人问此去昆明十里远，可曾悔过？\r\n“吾中华之学术斐然，为华夏之文明传承，为国之未来！“\r\n吾辈\r\n万难不悔\r\n', 129, 0000000001, '困难', 'https://wx4.sinaimg.cn/mw690/e60238a1gy1hv133xcfctj20gg0nx441.jpg');
INSERT INTO `jb` VALUES ('6', '枭雄', '民国', 6, '有人锦衣华服，却揣着一颗卖国的心！\r\n有人窘迫街头，却抱着守护家国的念！\r\n', 119, 0000000001, '进阶', 'https://wx3.sinaimg.cn/mw690/e60238a1gy1hv133xncydj20h80od0yu.jpg');
INSERT INTO `jb` VALUES ('7', '水镜出版社', '推理', 8, '你相信吗，水镜的本没有鬼，水镜的恐怖，没有那种东西，龙岗城近日发生多起失踪案，警方进行了一系列调查后发现，所有的线索均指向一家名为水镜的出版社。而今天，正好是这家公司招新的日子。八位心怀梦想的求职者，八篇诡异的面试作品，密室，凶案，奇怪的面试官，究竟谁才是连环杀人犯？穿过层层迷雾，那入隐藏在最深处的杀机是否会浮出水面？准备好了吗？这里是水镜出版社，请说出，你的故事！', 109, 0000000001, '适中', 'https://wx3.sinaimg.cn/mw690/e60238a1gy1hv133y43yfj20u016g18u.jpg');
INSERT INTO `jb` VALUES ('8', '说谎者', '推理', 6, '“怎么了？这位先生？进我们警局有什么事？”\r\n“我要自首，我......杀了人。”\r\n', 119, 0000000001, '困难', 'https://wx4.sinaimg.cn/mw690/e60238a1gy1hv133ykijaj20u01f4k6g.jpg');
INSERT INTO `jb` VALUES ('9', '祁山', '古风', 6, '正始十年，一场密谋已久的政变，敲响了时代变天的讯号。\r\n魏国朝堂风云四起，蜀汉又因丞相仙逝举国动荡。\r\n在这三国最后一舞中，有人为大魏鸣奏了一曲，慷慨悲壮的挽歌；有人长驱直入，翻越数里荒芜；有人为爱；有人为名；有人只为心中理想......\r\n臣等正欲死战，陛下何故先降？\r\n三军将士在列，此刻命运悉数掌握在手，蜀汉与曹魏的去留皆由尔等来定!', 109, 0000000001, '适中', 'https://wx4.sinaimg.cn/mw690/e60238a1gy1hv133z9b2nj21ww2pg4qp.jpg');
INSERT INTO `jb` VALUES ('E2FqePhf', '1', '1', 2, '1', 1, NULL, '1', '1');
INSERT INTO `jb` VALUES ('ovZwKKXO', '余光千百遍', '情感', 6, '我无数次深夜的思念，打了又删的短信，以及隔着人群，总是不自觉瞥向你的余光。这些，最好你永远都不要知道。', 89, NULL, '入门', 'https://wx1.sinaimg.cn/mw690/e60238a1gy1hv133tvtedj20m80uk7gl.jpg');

-- ----------------------------
-- Table structure for jb_yy
-- ----------------------------
DROP TABLE IF EXISTS `jb_yy`;
CREATE TABLE `jb_yy`  (
  `jb_yy_id` int NOT NULL AUTO_INCREMENT COMMENT '与user_jb_yy的jb_yy_id相连',
  `jb_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '剧本的id',
  `yy_num` int NULL DEFAULT NULL COMMENT '剧本预约人数',
  PRIMARY KEY (`jb_yy_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jb_yy
-- ----------------------------
INSERT INTO `jb_yy` VALUES (12, '1', 3);
INSERT INTO `jb_yy` VALUES (13, '4', 2);
INSERT INTO `jb_yy` VALUES (14, '5', 1);
INSERT INTO `jb_yy` VALUES (15, '7', 3);
INSERT INTO `jb_yy` VALUES (16, '9', 3);
INSERT INTO `jb_yy` VALUES (17, '10', 1);
INSERT INTO `jb_yy` VALUES (18, '1', 1);
INSERT INTO `jb_yy` VALUES (19, '10', 2);
INSERT INTO `jb_yy` VALUES (20, '2', 1);
INSERT INTO `jb_yy` VALUES (21, '3', 1);
INSERT INTO `jb_yy` VALUES (22, '4', 2);
INSERT INTO `jb_yy` VALUES (23, '5', 3);
INSERT INTO `jb_yy` VALUES (24, '6', 1);
INSERT INTO `jb_yy` VALUES (25, '7', 3);
INSERT INTO `jb_yy` VALUES (26, '9', 2);
INSERT INTO `jb_yy` VALUES (27, '8', 2);
INSERT INTO `jb_yy` VALUES (28, '1', 1);
INSERT INTO `jb_yy` VALUES (29, '2', 1);
INSERT INTO `jb_yy` VALUES (30, '10', 1);
INSERT INTO `jb_yy` VALUES (31, '10', 1);

-- ----------------------------
-- Table structure for user_jb_yy
-- ----------------------------
DROP TABLE IF EXISTS `user_jb_yy`;
CREATE TABLE `user_jb_yy`  (
  `user_jb_yy_id` int NOT NULL AUTO_INCREMENT COMMENT '预约id',
  `jb_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '剧本id',
  `user_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '外键，用户id，连接用户表',
  `pay_status` int NULL DEFAULT 0 COMMENT '1为已支付，0为未支付',
  `jb_yy_id` int NULL DEFAULT NULL COMMENT '外键，与jb_yy的jb_yy_id相连接',
  PRIMARY KEY (`user_jb_yy_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_jb_yy
-- ----------------------------
INSERT INTO `user_jb_yy` VALUES (15, '3', '506Grf29', 0, 10);
INSERT INTO `user_jb_yy` VALUES (16, '5', '506Grf29', 0, 14);
INSERT INTO `user_jb_yy` VALUES (17, '8', '506Grf29', 0, 27);
INSERT INTO `user_jb_yy` VALUES (19, '1', '506Grf29', 0, 12);
INSERT INTO `user_jb_yy` VALUES (20, '4', 'GRTzOPM6', 0, 13);
INSERT INTO `user_jb_yy` VALUES (21, '5', 'GRTzOPM6', 0, 14);
INSERT INTO `user_jb_yy` VALUES (22, '7', 'GRTzOPM6', 0, 15);
INSERT INTO `user_jb_yy` VALUES (23, '9', 'GRTzOPM6', 0, 16);
INSERT INTO `user_jb_yy` VALUES (24, '10', 'GRTzOPM6', 0, 17);
INSERT INTO `user_jb_yy` VALUES (27, '2', 'zqXKKpZe', 0, 20);
INSERT INTO `user_jb_yy` VALUES (34, '8', 'zqXKKpZe', 0, 27);
INSERT INTO `user_jb_yy` VALUES (35, '3', 'zqXKKpZe', 0, 10);
INSERT INTO `user_jb_yy` VALUES (36, '1', 'zqXKKpZe', 0, 12);
INSERT INTO `user_jb_yy` VALUES (37, '4', 'zqXKKpZe', 0, 13);
INSERT INTO `user_jb_yy` VALUES (38, '7', 'zqXKKpZe', 0, 15);
INSERT INTO `user_jb_yy` VALUES (39, '9', 'zqXKKpZe', 0, 16);
INSERT INTO `user_jb_yy` VALUES (40, '10', 'zqXKKpZe', 0, 19);
INSERT INTO `user_jb_yy` VALUES (41, '4', 'zqXKKpZe', 0, 22);
INSERT INTO `user_jb_yy` VALUES (42, '5', 'zqXKKpZe', 0, 23);
INSERT INTO `user_jb_yy` VALUES (43, '7', 'zqXKKpZe', 0, 25);
INSERT INTO `user_jb_yy` VALUES (44, '6', 'zqXKKpZe', 0, 24);
INSERT INTO `user_jb_yy` VALUES (45, '3', 'FdFLFXy2', 0, 10);
INSERT INTO `user_jb_yy` VALUES (46, '1', 'FdFLFXy2', 0, 12);
INSERT INTO `user_jb_yy` VALUES (47, '9', 'FdFLFXy2', 0, 16);
INSERT INTO `user_jb_yy` VALUES (48, '7', 'FdFLFXy2', 0, 15);
INSERT INTO `user_jb_yy` VALUES (49, '5', 'FdFLFXy2', 0, 23);
INSERT INTO `user_jb_yy` VALUES (50, '7', 'FdFLFXy2', 0, 25);
INSERT INTO `user_jb_yy` VALUES (51, '9', 'FdFLFXy2', 0, 26);
INSERT INTO `user_jb_yy` VALUES (52, '8', 'FdFLFXy2', 0, 27);
INSERT INTO `user_jb_yy` VALUES (53, '1', 'XaP7Y5X9', 0, NULL);
INSERT INTO `user_jb_yy` VALUES (54, '2', 'XaP7Y5X9', 0, NULL);
INSERT INTO `user_jb_yy` VALUES (57, '10', 'XaP7Y5X9', 0, NULL);
INSERT INTO `user_jb_yy` VALUES (59, '10', 'UgN9RC5o', 0, NULL);
INSERT INTO `user_jb_yy` VALUES (62, '3', 'UgN9RC5o', 0, 10);

-- ----------------------------
-- Table structure for user_sc
-- ----------------------------
DROP TABLE IF EXISTS `user_sc`;
CREATE TABLE `user_sc`  (
  `user_sc_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `jb_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '外键，与jb相连',
  PRIMARY KEY (`user_sc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_sc
-- ----------------------------
INSERT INTO `user_sc` VALUES (10, '506Grf29', '1');
INSERT INTO `user_sc` VALUES (11, 'GRTzOPM6', '5');
INSERT INTO `user_sc` VALUES (12, 'GRTzOPM6', '10');
INSERT INTO `user_sc` VALUES (13, 'zqXKKpZe', '5');
INSERT INTO `user_sc` VALUES (14, 'zqXKKpZe', '6');
INSERT INTO `user_sc` VALUES (15, 'zqXKKpZe', '7');
INSERT INTO `user_sc` VALUES (16, 'zqXKKpZe', '9');
INSERT INTO `user_sc` VALUES (17, 'zqXKKpZe', '8');
INSERT INTO `user_sc` VALUES (22, 'XaP7Y5X9', '10');
INSERT INTO `user_sc` VALUES (24, 'UgN9RC5o', '10');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '手机号，也是登陆账号',
  `user_pwd` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `user_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('506Grf29', '马喽', '12366879', '123456');
INSERT INTO `users` VALUES ('e37ycWax', '阮云蕾', '12345678', 'qwe4');
INSERT INTO `users` VALUES ('FdFLFXy2', 'equal', '28739494', '000111');
INSERT INTO `users` VALUES ('GNdFU8mn', 'yy', '123', '123456');
INSERT INTO `users` VALUES ('GRTzOPM6', '1', '1', '123456');
INSERT INTO `users` VALUES ('gwbR3Lpu', '229210101', '13437556575', '77777');
INSERT INTO `users` VALUES ('hL5Y65YD', '3', '3', '3');
INSERT INTO `users` VALUES ('Ky9xFmaZ', '马琳莹', '27893445522', '12399');
INSERT INTO `users` VALUES ('RLJnONXt', '2', '2', '2');
INSERT INTO `users` VALUES ('rNIXY58M', '张怡沁', '12345678441', '17890');
INSERT INTO `users` VALUES ('U2aOqS7D', '蛐蛐', '14253748933', '88888');
INSERT INTO `users` VALUES ('UgN9RC5o', '11', '11', '1');
INSERT INTO `users` VALUES ('XaP7Y5X9', '9', '9', '9');
INSERT INTO `users` VALUES ('XpEkFFt8', 'qdjfjdl', '24537496083', '666666');
INSERT INTO `users` VALUES ('YJmko2Yc', '张梦哲', '12345678334', 'qwert');
INSERT INTO `users` VALUES ('zqXKKpZe', '蔡妤静', '12345999123', '12wer');

SET FOREIGN_KEY_CHECKS = 1;
