/*
 Navicat Premium Data Transfer

 Source Server         : li
 Source Server Type    : MySQL
 Source Server Version : 50506
 Source Host           : localhost:3306
 Source Schema         : admindemo

 Target Server Type    : MySQL
 Target Server Version : 50506
 File Encoding         : 65001

 Date: 31/01/2024 22:49:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', '李星', '12345', '5.32E+17', '云南昭通', '3537915165@qq.com', '13638883117', '管理员', '管理员');
INSERT INTO `admins` VALUES ('2', '白芷若', 'asf', '5.32E+17', '云南昭通', '3537915166@qq.com', '13638883118', '管理员', '管理员');
INSERT INTO `admins` VALUES ('3', '马雨琦', 'asc', '5.32E+17', '云南昭通', '3537915167@qq.com', '13638883119', '管理员', '管理员');
INSERT INTO `admins` VALUES ('4', '马宇玲', 'asc', '5.32E+17', '云南昭通', '3537915168@qq.com', '13638883120', '管理员', '管理员');
INSERT INTO `admins` VALUES ('5', '曾露露', 'asc', '5.32E+17', '云南昭通', '3537915169@qq.com', '13638883121', '管理员', '管理员');
INSERT INTO `admins` VALUES ('6', '何通', 'asc', '5.32E+17', '云南昭通', '3537915170@qq.com', '13638883122', '管理员', '管理员');
INSERT INTO `admins` VALUES ('7', '余年', 'asc', '5.32E+17', '云南昭通', '3537915171@qq.com', '13638883123', '管理员', '管理员');

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shopname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('1', '郑敏', '123', '532129197911402356', '云南昭通', '1241116181@qq.com', '17842459224', '昭源红公司', '商家', '管理员');
INSERT INTO `business` VALUES ('2', '郑敏', '123', '532129197911402356', '云南昭通', '1241116182@qq.com', '17842459225', '昭源红公司', '商家', '管理员');
INSERT INTO `business` VALUES ('3', '郑敏为', '124', '532129197911402356', '云南昭通', '1241116183@qq.com', '17842459226', '昭源红公司', '商家', '管理员');
INSERT INTO `business` VALUES ('4', '郑敏时', '125', '532129197911402356', '云南昭通', '1241116184@qq.com', '17842459227', '昭源红公司', '商家', '管理员');
INSERT INTO `business` VALUES ('5', '郑敏赞', '126', '532129197911402356', '云南昭通', '1241116185@qq.com', '17842459228', '昭源红公司', '商家', '管理员');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `production` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `origin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'gtm', '干天麻', '1000公斤', '小草坝');
INSERT INTO `goods` VALUES ('2', 'xtm', '鲜天麻', '1001公斤', '小草坝');
INSERT INTO `goods` VALUES ('3', 'wtm', '乌天麻', '1002公斤', '小草坝');
INSERT INTO `goods` VALUES ('4', 'yjwmj', '盐津乌骨鸡', '1000只', '盐津');
INSERT INTO `goods` VALUES ('5', 'ztpg', '昭通苹果', '1000公斤', '云南昭通');
INSERT INTO `goods` VALUES ('7', 'htm', '红天麻', '100公斤', '小草坝');
INSERT INTO `goods` VALUES ('8', 'zthj', '昭通花椒', '1000公斤', '昭通');
INSERT INTO `goods` VALUES ('9', 'qjht', '巧家红糖', '100公斤', '巧家');
INSERT INTO `goods` VALUES ('0', 'tm', '天麻', '1000', '昭通');
INSERT INTO `goods` VALUES ('0', 'apple', '苹果', '100', '昭通');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodsname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paystatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '2017121225', '123231d26', '李星', '17842459225', '云南昭通231号', '100', '100', '干天麻', '已付');
INSERT INTO `orders` VALUES ('2', '2017121226', '123231d27', '张三', '17842459226', '云南昭通232号', '60', '101', '鲜天麻', '已付');
INSERT INTO `orders` VALUES ('3', '2017121227', '123231d28', '李四', '17842459226', '云南昭通233号', '312', '102', '鲜天麻', '已付');
INSERT INTO `orders` VALUES ('4', '2017121228', '123231d29', '李心', '17842459227', '云南昭通234号', '400', '103', '鲜天麻', '已付');
INSERT INTO `orders` VALUES ('5', '2017121229', '123231d30', '王四', '17842459228', '云南昭通235号', '50', '104', '鲜天麻', '已付');
INSERT INTO `orders` VALUES ('6', '2017121230', '123231d31', '李星', '17842459229', '云南昭通236号', '100', '105', '鲜天麻', '已付');
INSERT INTO `orders` VALUES ('7', '2017121231', '123231d32', '李星', '17842459230', '云南昭通237号', '10', '106', '干天麻', '未付');
INSERT INTO `orders` VALUES ('8', '2017121232', '123231d33', '李星', '17842459231', '云南昭通238号', '8', '107', '干天麻', '未付');

-- ----------------------------
-- Table structure for tokens
-- ----------------------------
DROP TABLE IF EXISTS `tokens`;
CREATE TABLE `tokens`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tokens
-- ----------------------------
INSERT INTO `tokens` VALUES ('1', '李星', '12345', '5.32E+17', '云南昭通', '3537915165@qq.com', '13638883117', '管理员', '管理员');
INSERT INTO `tokens` VALUES ('2', '白芷若', 'asf', '5.32E+17', '云南昭通', '3537915166@qq.com', '13638883118', '管理员', '管理员');
INSERT INTO `tokens` VALUES ('3', '马雨琦', 'asc', '5.32E+17', '云南昭通', '3537915167@qq.com', '13638883119', '管理员', '管理员');
INSERT INTO `tokens` VALUES ('4', '马宇玲', 'asc', '5.32E+17', '云南昭通', '3537915168@qq.com', '13638883120', '管理员', '管理员');
INSERT INTO `tokens` VALUES ('5', '曾露露', 'asc', '5.32E+17', '云南昭通', '3537915169@qq.com', '13638883121', '管理员', '管理员');
INSERT INTO `tokens` VALUES ('6', '何通', 'asc', '5.32E+17', '云南昭通', '3537915170@qq.com', '13638883122', '管理员', '管理员');
INSERT INTO `tokens` VALUES ('7', '余年', 'asc', '5.32E+17', '云南昭通', '3537915171@qq.com', '13638883123', '管理员', '管理员');
INSERT INTO `tokens` VALUES ('8', '王俊', 'asc', '5.32E+17', '云南昭通', '3537915172@qq.com', '13638883124', '用户', '用户');
INSERT INTO `tokens` VALUES ('9', '卢彤', 'asc', '5.32E+17', '云南昭通', '3537915173@qq.com', '13638883125', '用户', '用户');
INSERT INTO `tokens` VALUES ('10', '韦亚南', 'asc', '5.32E+17', '云南昭通', '3537915174@qq.com', '13638883126', '用户', '用户');
INSERT INTO `tokens` VALUES ('11', '焦子扬', 'asc', '5.32E+17', '云南昭通', '3537915175@qq.com', '13638883127', '用户', '用户');
INSERT INTO `tokens` VALUES ('14', '鲁双鹏', 'asc', '5.32E+17', '云南昭通', '3537915176@qq.com', '13638883128', '用户', '用户');
INSERT INTO `tokens` VALUES ('15', '李佳彦', 'asc', '5.32E+17', '云南昭通', '3537915177@qq.com', '13638883129', '用户', '用户');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '李星', '12345', '5.32139E+17', '云南昭通', '3537915165@qq.com', '13638883117');
INSERT INTO `users` VALUES ('2', '白芷若', 'asf', '5.32139E+17', '云南昭通', '3537915166@qq.com', '13638883118');
INSERT INTO `users` VALUES ('3', '马雨琦', 'asc', '5.32139E+17', '云南昭通', '3537915167@qq.com', '13638883119');
INSERT INTO `users` VALUES ('4', '马宇玲', 'asc', '5.32139E+17', '云南昭通', '3537915168@qq.com', '13638883120');
INSERT INTO `users` VALUES ('5', '曾露露', 'asc', '5.32139E+17', '云南昭通', '3537915169@qq.com', '13638883143');
INSERT INTO `users` VALUES ('6', '何通', 'asc', '5.32139E+17', '云南昭通', '3537915170@qq.com', '13638883122');
INSERT INTO `users` VALUES ('7', '余年', 'asc', '5.32139E+17', '云南昭通', '3537915171@qq.com', '13638883123');
INSERT INTO `users` VALUES ('8', '王俊', 'asca', '5.32139E+17', '云南昭通', '3537915172@qq.com', '13638883124');
INSERT INTO `users` VALUES ('10', '韦亚南', 'asc', '5.32139E+17', '云南昭通', '3537915174@qq.com', '13638883126');
INSERT INTO `users` VALUES ('11', '焦子扬', 'asc', '5.32139E+17', '云南昭通', '3537915175@qq.com', '13638883127');
INSERT INTO `users` VALUES ('14', '鲁双鹏', 'asc', '5.32139E+17', '云南昭通', '3537915176@qq.com', '13638883128');
INSERT INTO `users` VALUES ('15', '李佳彦', 'asc', '5.32139E+17', '云南昭通', '3537915177@qq.com', '13638883129');

SET FOREIGN_KEY_CHECKS = 1;
