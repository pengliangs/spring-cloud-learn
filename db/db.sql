DROP DATABASE IF EXISTS `my-learn-db`;

CREATE DATABASE  `my-learn-db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

USE `my-learn-db`;

-- ----------------------------
--  Table structure for `user_base_info` 
-- ----------------------------
DROP TABLE IF EXISTS `user_base_info` ;
CREATE TABLE `user_base_info` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_avatar` varchar(200) NOT NULL DEFAULT '' COMMENT '用户头像',
  `user_nickname` varchar(50) NOT NULL COMMENT '用户昵称',
  `user_sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别 （0女，1男）',
  `user_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '用户类型（0.真实用户、1.马甲用户）',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0.未删除 1.已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_nickname_unique` (`user_nickname`) USING BTREE COMMENT '用户名称唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

