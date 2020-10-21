
SET NAMES utf8 ;

SET SQL_MODE='';

CREATE DATABASE IF NOT EXISTS `HelperMemberManager`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT ENCRYPTION='N';

USE `HelperMemberManager`;

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `uid` INT AUTO_INCREMENT PRIMARY KEY NOT NULL  COMMENT 'UUID',
  `username` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户登录名',
  `password` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
	`nickname` varchar(30) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称，建议为真实姓名',
  `phone` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
	`email` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮件地址',

  UNIQUE KEY (`username`),
  KEY `normalIndex` (`username`,`id`,`email`,`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- DROP TABLE IF EXISTS `tb_questionnaire`;
--
-- CREATE TABLE `tb_questionnaire` (
--   `qid` INT AUTO_INCREMENT PRIMARY KEY NOT NULL  COMMENT '申请表id',
--   `uid` INT NOT NULL COMMENT '用户id',
--   `nickname` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
--   `email` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
--   `phone` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
--   `problemdescription` text COLLATE utf8mb4_general_ci COMMENT '问题描述',
--   `comment` text COLLATE utf8mb4_general_ci COMMENT '备注',
-- 	`status` int NOT NULL DEFAULT '0' COMMENT '状态（0待审核，1待签到，2处理中待完成，3已完成）',
-- 	`helper_id` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'helper的id',
--
--   PRIMARY KEY (`qid`),
-- 	KEY `normalIndex` (`uid`,`status`,`helper_id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
--
--