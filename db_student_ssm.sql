/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : db_student_ssm

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-05-24 13:43:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `c3p0testtable`
-- ----------------------------
DROP TABLE IF EXISTS `c3p0testtable`;
CREATE TABLE `c3p0testtable` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c3p0testtable
-- ----------------------------

-- ----------------------------
-- Table structure for `clazz`
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gradeId` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `remark` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gradeId` (`gradeId`),
  CONSTRAINT `clazz_ibfk_1` FOREIGN KEY (`gradeId`) REFERENCES `grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('12', '13', '网络工程1801', '网络工程专业2018届1班');
INSERT INTO `clazz` VALUES ('13', '1', '软件工程1101', '软件工程1101班');
INSERT INTO `clazz` VALUES ('14', '12', '计算机1101', '计算机专业1101班');
INSERT INTO `clazz` VALUES ('18', '12', '计算机1102', '计算机2班');
INSERT INTO `clazz` VALUES ('24', '12', '计算机1103', '');
INSERT INTO `clazz` VALUES ('25', '12', '计算机1102', '');
INSERT INTO `clazz` VALUES ('26', '18', '土木工程1班', '');
INSERT INTO `clazz` VALUES ('27', '20', '物联网1班', '');
INSERT INTO `clazz` VALUES ('28', '19', '机电1班', '');

-- ----------------------------
-- Table structure for `clazz_1`
-- ----------------------------
DROP TABLE IF EXISTS `clazz_1`;
CREATE TABLE `clazz_1` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `cremark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of clazz_1
-- ----------------------------
INSERT INTO `clazz_1` VALUES ('1', '物联1811', '1', '无');
INSERT INTO `clazz_1` VALUES ('2', '物联1812', '2', '无');
INSERT INTO `clazz_1` VALUES ('3', '计科1811', '3', '无');
INSERT INTO `clazz_1` VALUES ('4', '网络1911', '4', '无');
INSERT INTO `clazz_1` VALUES ('5', '软件1811', '5', '无');
INSERT INTO `clazz_1` VALUES ('6', '电商1811', '6', '无');

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `remark` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '软件工程2011届', '计算机学院软件工程专业2011届');
INSERT INTO `grade` VALUES ('12', '计算机2011届', '计算机学院计算机专业2011届。');
INSERT INTO `grade` VALUES ('13', '网络工程2018届', '计算机学院网络工程专业2018届。');
INSERT INTO `grade` VALUES ('16', '机械工程', '机械学院');
INSERT INTO `grade` VALUES ('17', '金融学', '管理学院\r\n');
INSERT INTO `grade` VALUES ('18', '土木工程', '土木院系');
INSERT INTO `grade` VALUES ('19', '机械电子工程', '机械工程');
INSERT INTO `grade` VALUES ('20', '物联网工程', '计算机学院');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(30) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('16', 'A4-101', '70', '计科_1班');
INSERT INTO `room` VALUES ('17', 'A4-201', '160', '空闲');
INSERT INTO `room` VALUES ('18', 'A4-301', '100', '计科_3班');
INSERT INTO `room` VALUES ('19', 'A5-101', '70', '机械_1班');
INSERT INTO `room` VALUES ('20', 'A6-101', '70', '计科_3班');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clazzId` int(11) NOT NULL,
  `sn` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` varchar(8) NOT NULL,
  `photo` varchar(128) NOT NULL,
  `remark` varchar(512) DEFAULT NULL,
  `age` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `gradeId` (`clazzId`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`clazzId`) REFERENCES `clazz` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('24', '13', 'S1543327958875', '张三', '123', '男', '/StudentManagerSSM/upload/1651330123827.png', '张三是河南人。', '1');
INSERT INTO `student` VALUES ('25', '13', 'S1543328011478', '李四', '123456', '女', '/StudentManagerSSM/upload/1543408773940.jpg', '李四是河南人。', '2');
INSERT INTO `student` VALUES ('33', '12', 'S1651332918607', 'rewr', 'ee', '男', '/StudentManagerSSM/photo/student.jpg', 'e', 'e');
INSERT INTO `student` VALUES ('34', '12', 'S1651332970340', '小宇', '967072', '男', '/StudentManagerSSM/photo/student.jpg', '肖湘政', '25');
INSERT INTO `student` VALUES ('40', '12', 'S1651336165936', 'fd', 'fd', '男', '/StudentManagerSSM/photo/student.jpg', 'fd', 'fd');
INSERT INTO `student` VALUES ('41', '12', 'f11111', 'fdsa', '33', '男', '/StudentManagerSSM/photo/student.jpg', '3', '3');
INSERT INTO `student` VALUES ('42', '12', 'f11111', '1111', '22', '男', '/StudentManagerSSM/photo/student.jpg', '3', '3');
INSERT INTO `student` VALUES ('47', '12', '11111', 'fads', '1111', '男', '/StudentManagerSSM/photo/student.jpg', '', '11');
INSERT INTO `student` VALUES ('48', '12', '24341', 'rfesr', 're', '男', '/StudentManagerSSM/photo/student.jpg', '', '32');
INSERT INTO `student` VALUES ('49', '12', '24341', 'rewrre', 'ijihyiu', '男', '/StudentManagerSSM/photo/student.jpg', 're', '32');
INSERT INTO `student` VALUES ('50', '14', 'fdsa', 'fsd', 'fsad', '男', '/StudentManagerSSM/photo/student.jpg', '', 'fdsaa11111');
INSERT INTO `student` VALUES ('51', '12', '222', '111', '333', '男', '/StudentManagerSSM/photo/student.jpg', '555', '444');

-- ----------------------------
-- Table structure for `student_1`
-- ----------------------------
DROP TABLE IF EXISTS `student_1`;
CREATE TABLE `student_1` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `snum` varchar(20) DEFAULT NULL,
  `ssex` varchar(2) DEFAULT NULL,
  `sage` int(11) DEFAULT NULL,
  `cid` varchar(50) DEFAULT NULL,
  `sstatus` varchar(10) DEFAULT NULL,
  `sremark` varchar(50) DEFAULT NULL,
  `idcard` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `entime` varchar(20) DEFAULT NULL,
  `pswd` varchar(30) DEFAULT NULL,
  `pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of student_1
-- ----------------------------
INSERT INTO `student_1` VALUES ('43', '肖肖', '18104011129', '女', '24', '网络工程1801', '正常', '无', '51072319970716003', '13912345678', '四川省泸州市', '2019-09-01', '123456', '');
INSERT INTO `student_1` VALUES ('51', '刘小宇', '18104011129', '男', '24', '网络工程1801', '正常', 'LOL', '51072319970716003', '13912345678', '四川省绵阳市', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010200811.jpg');
INSERT INTO `student_1` VALUES ('55', '肖湘政', '18104011129', '女', '24', '软件工程1101', '正常', '无', '51072319970716003', '13912345678', '四川省泸州市', '2019-09-01', '123456', 'http://localhost:8080/StudentManagerSSM/photo/1.jpg');
INSERT INTO `student_1` VALUES ('56', '肖湘政', '18104011129', '女', '24', '物联网1班', '正常', '无', '51072319970716003', '13912345678', '四川省泸州市', '2019-09-01', '123456', '');
INSERT INTO `student_1` VALUES ('57', '肖湘政', '18104011129', '女', '24', '土木工程1班', '正常', '无', '51072319970716003', '13912345678', '四川省泸州市', '2019-09-01', '123456', '');
INSERT INTO `student_1` VALUES ('58', '肖湘政_2', '18104011129', '女', '24', '网络工程1801', '正常', '无', '51072319970716003', '13912345678', '四川省泸州市', '2019-09-01', '123456', 'http://localhost:8080/StudentManagerSSM/photo/1.jpg');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
INSERT INTO `user` VALUES ('9', '小宇', '123456');
INSERT INTO `user` VALUES ('10', '111', '222');
