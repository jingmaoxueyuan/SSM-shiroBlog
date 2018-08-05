/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-08-04 16:21:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `blogid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `label_id` int(11) DEFAULT NULL,
  `something` varchar(255) DEFAULT NULL,
  `content` varchar(2555) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`blogid`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('2', '2', '2', '2', '2', '2', null, '已发布', null);
INSERT INTO `blog` VALUES ('4', '1', '1', '安排', '<p>1</p>', '1', '2018-07-29', '已发布', '狗粉丝都得死5');
INSERT INTO `blog` VALUES ('24', '1', '1', 'test', '<p>2</p>', null, null, '未发布', 'test');
INSERT INTO `blog` VALUES ('26', '1', '1', '张金辉狗儿子', '<p><img src=\"http://localhost:8080//GruduationProject/image/1533001335037045883.jpg\" title=\"1533001335037045883.jpg\" alt=\"QQ截图20180730201651.jpg\"/></p>', null, null, '已发布', '狗粉丝都去死');
INSERT INTO `blog` VALUES ('27', '1', '2', '安排', '<p>安排一哈</p>', null, '2018-07-31', '已发布', '测试一哈');
INSERT INTO `blog` VALUES ('28', '1', '4', '测试', '<p>1</p>', null, '2018-07-31', '未发布', 'test');
INSERT INTO `blog` VALUES ('29', '1', '4', '测试', '<p>13</p>', null, '2018-07-31', '未发布', 'test');
INSERT INTO `blog` VALUES ('30', '1', '1', '放弃把少年', '<p>13</p>', null, '2018-07-31', '已发布', 'Java从入门到放弃');
INSERT INTO `blog` VALUES ('31', '1', '1', 'aaa', '<p>13</p>', null, '2018-07-31', '已发布', 'Node JS 从入门到放弃');
INSERT INTO `blog` VALUES ('32', '1', '13', '1', '<p><img src=\"http://localhost:8080//GruduationProject/image/1533110601350068431.jpg\" title=\"1533110601350068431.jpg\" alt=\"tese.jpg\"/></p>', null, '2018-08-01', '未发布', 'kk');
INSERT INTO `blog` VALUES ('33', '1', '13', '1', '<p>a 啊</p>', null, '2018-08-01', '未发布', 'kk');
INSERT INTO `blog` VALUES ('36', '1', '2', '张金辉都得死', '', null, '2018-08-03', '已发布', '狗张金辉');
INSERT INTO `blog` VALUES ('37', '1', '14', '测试', '', null, '2018-08-03', '已发布', '2018/8/3');
INSERT INTO `blog` VALUES ('38', '1', '1', '测试', '', null, '2018-08-03', '已发布', '你妈死了');
INSERT INTO `blog` VALUES ('39', '1', '1', '侧是', '', null, '2018-08-03', '已发布', '二货');
INSERT INTO `blog` VALUES ('40', '1', '14', '啊', '', null, '2018-08-03', '已发布', '我是一片文章');
INSERT INTO `blog` VALUES ('41', '1', '2', '1 ', '', null, '2018-08-03', '已发布', '文章测试');
INSERT INTO `blog` VALUES ('42', '1', '2', '都是', '<p>如果他是傻逼那范晓辉也是傻逼</p><p><img src=\"http://localhost:8080/GruduationProject/image/1533365293736005472.jpg\" title=\"1533365293736005472.jpg\" alt=\"tese.jpg\" width=\"191\" height=\"162\"/><img src=\"http://img.baidu.com/hi/jx2/j_0003.gif\"/>测试 测试测试测试测试</p><p style=\"text-align: center;\">测试</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1<br/></p><p>11</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p><br/></p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p>', null, '2018-08-03', '已发布', '测试文章');
INSERT INTO `blog` VALUES ('43', '17', '1', '1', '<p>xxxxxxx<img src=\"http://localhost:8080//GruduationProject/image/1533348118987003961.gif\" title=\"1533348118987003961.gif\" alt=\"微信图片_20180803145105.gif\"/></p>', null, '2018-08-03', '已发布', 'User发布');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_Id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `create_Date` date DEFAULT NULL,
  PRIMARY KEY (`comment_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '文章不错', '2018-08-03');
INSERT INTO `comment` VALUES ('2', '666', '2018-08-03');

-- ----------------------------
-- Table structure for `comment_blog`
-- ----------------------------
DROP TABLE IF EXISTS `comment_blog`;
CREATE TABLE `comment_blog` (
  `comment_Blog_Id` int(11) NOT NULL,
  `comment_Id` int(11) DEFAULT NULL,
  `Blog_Id` int(11) DEFAULT NULL,
  `user_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_Blog_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_blog
-- ----------------------------
INSERT INTO `comment_blog` VALUES ('1', '1', '4', '1');
INSERT INTO `comment_blog` VALUES ('2', '2', '4', '1');
INSERT INTO `comment_blog` VALUES ('3', '1', '43', '1');
INSERT INTO `comment_blog` VALUES ('4', '2', '42', '1');
INSERT INTO `comment_blog` VALUES ('5', '2', '43', '1');
INSERT INTO `comment_blog` VALUES ('6', '2', '43', '2');
INSERT INTO `comment_blog` VALUES ('7', '1', '43', null);

-- ----------------------------
-- Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `label_id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL,
  `create_Date` date DEFAULT NULL,
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', 'Java', '2018-07-31');
INSERT INTO `label` VALUES ('2', 'spring1', '2018-07-31');
INSERT INTO `label` VALUES ('3', 'Shiro', '2018-08-01');
INSERT INTO `label` VALUES ('4', 'jquery', '2019-02-01');
INSERT INTO `label` VALUES ('13', 'Ubuntu啊', '2018-08-01');
INSERT INTO `label` VALUES ('14', '啊', '2018-08-01');
INSERT INTO `label` VALUES ('15', '分类测试', '2018-08-03');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `resourse` varchar(255) DEFAULT NULL,
  `permission_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'user:save', '用户保存');
INSERT INTO `permission` VALUES ('2', 'user:delete', '用户删除');
INSERT INTO `permission` VALUES ('3', 'user:view', '用户列表查看');
INSERT INTO `permission` VALUES ('4', 'user:insert', '用户插入');
INSERT INTO `permission` VALUES ('5', 'user:upload', '用户修改');
INSERT INTO `permission` VALUES ('6', 'essay:view', '文章列表查看');
INSERT INTO `permission` VALUES ('7', 'essay:status', '文章状态');
INSERT INTO `permission` VALUES ('8', 'essay:delete', '文章删除');
INSERT INTO `permission` VALUES ('9', 'essay:insert', '文章插入');
INSERT INTO `permission` VALUES ('10', 'essay:updata', '文章更新显示');
INSERT INTO `permission` VALUES ('11', 'essay:updataEssay', '文章更新');
INSERT INTO `permission` VALUES ('12', 'essay:searchEssay', '文章搜索');
INSERT INTO `permission` VALUES ('13', 'label:view', '分类列表显示');
INSERT INTO `permission` VALUES ('14', 'label:insert', '分类插入');
INSERT INTO `permission` VALUES ('15', 'label:updateLabel', '分类更新显示');
INSERT INTO `permission` VALUES ('16', 'label:update', '分类更新');
INSERT INTO `permission` VALUES ('17', 'label:delete', '分类删除');
INSERT INTO `permission` VALUES ('18', 'role:view', '角色列表显示');
INSERT INTO `permission` VALUES ('19', 'role:findRoleView', '角色更新显示');
INSERT INTO `permission` VALUES ('20', 'role:update', '角色更新');
INSERT INTO `permission` VALUES ('21', 'role:delete', '角色删除');
INSERT INTO `permission` VALUES ('22', 'role:passwordresetting', '角色密码重置');
INSERT INTO `permission` VALUES ('23', 'permission:view', '权限列表显示');
INSERT INTO `permission` VALUES ('24', 'permission:insert', '权限插入');
INSERT INTO `permission` VALUES ('25', 'permission:update', '权限更新');
INSERT INTO `permission` VALUES ('26', 'permission:delete', '权限删除');
INSERT INTO `permission` VALUES ('27', 'permission:permissionview', '权限分配显示');
INSERT INTO `permission` VALUES ('28', 'permission:permissionallot', '权限分配');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `create_Date` date DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '2018-04-02');
INSERT INTO `role` VALUES ('2', 'user', '2018-08-07');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '2', '1');
INSERT INTO `role_permission` VALUES ('3', '3', '1');
INSERT INTO `role_permission` VALUES ('4', '4', '1');
INSERT INTO `role_permission` VALUES ('5', '5', '1');
INSERT INTO `role_permission` VALUES ('6', '6', '1');
INSERT INTO `role_permission` VALUES ('7', '7', '1');
INSERT INTO `role_permission` VALUES ('8', '8', '1');
INSERT INTO `role_permission` VALUES ('9', '9', '1');
INSERT INTO `role_permission` VALUES ('10', '10', '1');
INSERT INTO `role_permission` VALUES ('11', '11', '1');
INSERT INTO `role_permission` VALUES ('12', '12', '1');
INSERT INTO `role_permission` VALUES ('13', '13', '1');
INSERT INTO `role_permission` VALUES ('14', '14', '1');
INSERT INTO `role_permission` VALUES ('15', '15', '1');
INSERT INTO `role_permission` VALUES ('16', '16', '1');
INSERT INTO `role_permission` VALUES ('17', '17', '1');
INSERT INTO `role_permission` VALUES ('18', '18', '1');
INSERT INTO `role_permission` VALUES ('19', '19', '1');
INSERT INTO `role_permission` VALUES ('20', '20', '1');
INSERT INTO `role_permission` VALUES ('21', '21', '1');
INSERT INTO `role_permission` VALUES ('22', '22', '1');
INSERT INTO `role_permission` VALUES ('23', '23', '1');
INSERT INTO `role_permission` VALUES ('24', '24', '1');
INSERT INTO `role_permission` VALUES ('25', '25', '1');
INSERT INTO `role_permission` VALUES ('26', '26', '1');
INSERT INTO `role_permission` VALUES ('27', '27', '1');
INSERT INTO `role_permission` VALUES ('28', '28', '1');
INSERT INTO `role_permission` VALUES ('97', '1', '2');
INSERT INTO `role_permission` VALUES ('98', '2', '2');
INSERT INTO `role_permission` VALUES ('99', '3', '2');
INSERT INTO `role_permission` VALUES ('100', '4', '2');
INSERT INTO `role_permission` VALUES ('101', '5', '2');
INSERT INTO `role_permission` VALUES ('102', '6', '2');
INSERT INTO `role_permission` VALUES ('103', '7', '2');
INSERT INTO `role_permission` VALUES ('104', '8', '2');
INSERT INTO `role_permission` VALUES ('105', '9', '2');
INSERT INTO `role_permission` VALUES ('106', '10', '2');
INSERT INTO `role_permission` VALUES ('107', '11', '2');
INSERT INTO `role_permission` VALUES ('108', '12', '2');
INSERT INTO `role_permission` VALUES ('109', '13', '2');
INSERT INTO `role_permission` VALUES ('110', '14', '2');
INSERT INTO `role_permission` VALUES ('111', '15', '2');
INSERT INTO `role_permission` VALUES ('112', '16', '2');
INSERT INTO `role_permission` VALUES ('113', '17', '2');
INSERT INTO `role_permission` VALUES ('114', '18', '2');
INSERT INTO `role_permission` VALUES ('115', '19', '2');
INSERT INTO `role_permission` VALUES ('116', '20', '2');
INSERT INTO `role_permission` VALUES ('117', '21', '2');
INSERT INTO `role_permission` VALUES ('118', '22', '2');
INSERT INTO `role_permission` VALUES ('119', '23', '2');
INSERT INTO `role_permission` VALUES ('120', '24', '2');
INSERT INTO `role_permission` VALUES ('121', '25', '2');
INSERT INTO `role_permission` VALUES ('122', '26', '2');
INSERT INTO `role_permission` VALUES ('123', '27', '2');
INSERT INTO `role_permission` VALUES ('124', '28', '2');

-- ----------------------------
-- Table structure for `role_user`
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_Date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('1', '1', '1', '2018-08-02');
INSERT INTO `role_user` VALUES ('2', '2', '12', '2018-08-02');
INSERT INTO `role_user` VALUES ('3', '1', '13', '2018-08-02');
INSERT INTO `role_user` VALUES ('11', '2', '14', '2018-08-02');
INSERT INTO `role_user` VALUES ('12', '2', '17', '2018-08-03');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `nick` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '3fed7a346e430ea4c2aa10250928f4de', '男', '2018-07-21', 'Thud', '范晓辉无敌帅', '/1533365391570.jpg');
INSERT INTO `user` VALUES ('12', 'admin888', 'b5b728d5113a608e3c3a4a9aa5de3325', '女', '2018-07-24', null, null, null);
INSERT INTO `user` VALUES ('13', 'admin8', '5ff365a34917dbc8dd83e85560afb6c6', '男', '2018-07-24', null, null, null);
INSERT INTO `user` VALUES ('14', '1', 'e756d27bdbca9de24d67e424549561f8', '男', '2018-07-24', null, null, null);
INSERT INTO `user` VALUES ('15', '123', '8eda1535b635e6b2c3672cc502249fe0', '男', '2018-07-24', null, null, null);
INSERT INTO `user` VALUES ('16', '12', 'ed66dc16ee4bead9a1483060e3008a75', '男', '2018-07-25', null, null, null);
INSERT INTO `user` VALUES ('17', 'user', '42e07e77cbaaf630acb946447aa979bd', '男', '2018-07-26', null, null, null);
