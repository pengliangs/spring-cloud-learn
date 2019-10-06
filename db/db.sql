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
  `id` bigint(20) NOT NULL COMMENT '����',
  `user_avatar` varchar(200) NOT NULL DEFAULT '' COMMENT '�û�ͷ��',
  `user_nickname` varchar(50) NOT NULL COMMENT '�û��ǳ�',
  `user_sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '�Ա� ��0Ů��1�У�',
  `user_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '�û����ͣ�0.��ʵ�û���1.����û���',
  `createTime` datetime NOT NULL COMMENT '����ʱ��',
  `update_time` datetime NOT NULL COMMENT '�޸�ʱ��',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0.δɾ�� 1.��ɾ��',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_nickname_unique` (`user_nickname`) USING BTREE COMMENT '�û�����Ψһ����'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

