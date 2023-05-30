/*
 Navicat Premium Data Transfer

 Source Server         : lk
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : zszy

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 29/05/2023 23:35:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                               `name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '名称',
                               `status` int NOT NULL COMMENT '状态',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'dictionary' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES (6, '系统推送', 1);
INSERT INTO `dictionary` VALUES (7, '紧急通知', 1);
INSERT INTO `dictionary` VALUES (8, '普通推送', 1);

-- ----------------------------
-- Table structure for donate
-- ----------------------------
DROP TABLE IF EXISTS `donate`;
CREATE TABLE `donate`  (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `donate_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '捐赠名',
                           `remark` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '备注',
                           `create_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'donate' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of donate
-- ----------------------------
INSERT INTO `donate` VALUES (8, '衣服', '来自匿名者捐赠的两件衣服，捐赠到凉山地区', '2023-05-09 20:46:41');
INSERT INTO `donate` VALUES (9, '书籍（文学和图画书）', '张明为孤儿院捐赠课外书120本', '2023-05-09 23:03:12');

-- ----------------------------
-- Table structure for life
-- ----------------------------
DROP TABLE IF EXISTS `life`;
CREATE TABLE `life`  (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                         `life_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '服务名',
                         `start_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '开始时间',
                         `end_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '结束时间',
                         `remark` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '备注信息',
                         `image_url` varchar(230) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '图片',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'life' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of life
-- ----------------------------
INSERT INTO `life` VALUES (8, '买菜服务', '2023-04-15', '2023-06-15', '买菜服务，收费标准为25/次', 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//97d6e6ba-d3e3-4db5-8be5-a54b65ce6d37_蔬菜.jpg');
INSERT INTO `life` VALUES (9, '代取快递', '2023-01-01', '2023-12-31', '带去快递，收费标准为：15/次', 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//0332ec65-323e-46ef-8c6f-55d3d936dcb8_快递.jpeg');
INSERT INTO `life` VALUES (10, '代购服务', '2023-02-01', '2023-12-31', '代购服务，收费标准为：25/次', 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//098e8bdf-c02a-44cf-8d46-56b40dcd030c_代购.jpg');
INSERT INTO `life` VALUES (14, '家政服务', '2023-05-05', '2023-12-31', '家政服务，收费标准：底价80/次', 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//7b3e77db-7422-4ffa-81b7-7325a54ee734_家政.jpeg');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `title` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '标题',
                           `content` varchar(130) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '内容',
                           `user_id` int NOT NULL COMMENT '接收人',
                           `type` int NOT NULL COMMENT '类型',
                           `create_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'notice' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (10, '安全培训', '2023-05-13，在公司开展安全培训', 16, 1, '2023-05-09 23:06:18');
INSERT INTO `notice` VALUES (11, '消防演练', '2023-05-07', 16, 3, '2023-05-09 23:07:52');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `product_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '回收物名',
                            `image_url` varchar(230) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
                            `sort_id` int NULL DEFAULT NULL COMMENT '分类',
                            `remark` varchar(130) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注信息',
                            `user_id` int NULL DEFAULT NULL COMMENT '用户',
                            `employee_id` int NULL DEFAULT NULL COMMENT '员工',
                            `store_id` int NULL DEFAULT NULL COMMENT '仓库名',
                            `status` int NULL DEFAULT NULL COMMENT '状态',
                            `create_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'product' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (4, '汽车', 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//c4b809d4-a70c-4c16-8955-9b4727c9a5b5_汽车.jpeg', 12, '汽车1辆', 6, 17, 12, 3, '2023-04-29');

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`  (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                         `sort_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '分类名',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'sort' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES (8, '塑料类型');
INSERT INTO `sort` VALUES (9, '废纸类型');
INSERT INTO `sort` VALUES (10, '废旧电器类型');
INSERT INTO `sort` VALUES (11, '工业废料类型');
INSERT INTO `sort` VALUES (12, '汽车类型');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
                          `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                          `store_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '仓库名',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'store' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (9, '废纸仓库');
INSERT INTO `store` VALUES (10, '电器仓库');
INSERT INTO `store` VALUES (11, '塑料仓库');
INSERT INTO `store` VALUES (12, '汽车仓库');
INSERT INTO `store` VALUES (13, '工业废料');

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car`  (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `carNo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '车牌号',
                          `licensePlateColor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车牌颜色',
                          `carStatus` int NOT NULL DEFAULT 0 COMMENT '运营状态（0营业 1停运）',
                          `carType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车辆类型',
                          `manageScope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '车辆经营范围',
                          `totalMass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '总质量',
                          `checkWeight` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '核定载质量',
                          `carDelete` int NOT NULL DEFAULT 0 COMMENT '是否被删除(0否，1是)',
                          `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                          PRIMARY KEY (`id`) USING BTREE,
                          UNIQUE INDEX `index_carNo`(`carNo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '车辆表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES (1, '川A54921', '绿色', 0, '小型货车', '成都市双流区', '1.5T', '3.5T', 0, '2023-04-28 14:27:46', '2023-04-28 14:27:46');
INSERT INTO `t_car` VALUES (2, '川A80317', '绿色', 0, '小型货车', '成都市双流区', '1.5T', '3.5T', 0, '2023-04-28 14:32:07', '2023-04-28 14:32:32');
INSERT INTO `t_car` VALUES (4, '川A59628', '蓝色', 0, '中型货车', '成都市双流区', '2.5T', '6.5T', 0, '2023-04-28 14:29:40', '2023-04-28 14:33:39');
INSERT INTO `t_car` VALUES (5, '川A40725', '蓝色', 0, '中型货车', '成都市双流区', '2.5T', '6.5T', 0, '2023-04-28 14:33:20', '2023-04-28 14:35:01');
INSERT INTO `t_car` VALUES (6, '川A7E642', '蓝色', 0, '大型货车', '成都市双流区', '3,5T', '10.5T', 0, '2023-04-28 14:28:49', '2023-05-27 21:54:12');
INSERT INTO `t_car` VALUES (7, '川A62312', '蓝色', 0, '大型货车', '成都市双流区', '3,5T', '10.5T', 0, '2023-04-28 14:36:35', '2023-05-27 21:53:48');
INSERT INTO `t_car` VALUES (8, '川A50217', '蓝色', 0, '大型货车', '成都市双流区', '3,5T', '10.5T', 0, '2023-04-28 14:36:49', '2023-05-27 21:51:35');

-- ----------------------------
-- Table structure for t_china_division
-- ----------------------------
DROP TABLE IF EXISTS `t_china_division`;
CREATE TABLE `t_china_division`  (
                                     `cityCode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '开始代码',
                                     `provinceCode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '省代码',
                                     `level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '城市级别',
                                     `shorthandName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '简写名称',
                                     `abbPy` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '拼音',
                                     `firstLetter` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '首字母',
                                     `allCode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '全代码',
                                     `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '全写名称'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '中国行政区划表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_china_division
-- ----------------------------

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `dictName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典名称',
                           `dictType` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典类型',
                           `dictDelete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '字典是否被删除（0：未删除，1：删除）',
                           `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '数据字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES (1, '普通通知', 'NOTICE_SIMPLE', 0, '2023-04-14 15:39:43', '2023-04-14 15:39:43');
INSERT INTO `t_dict` VALUES (2, '系统通知', 'NOTICE_SYSTEM', 0, '2023-04-14 15:41:10', '2023-04-14 15:41:10');
INSERT INTO `t_dict` VALUES (3, '紧急通知', 'NOTICE_URGENT', 0, '2023-04-14 15:41:47', '2023-04-14 15:41:47');
INSERT INTO `t_dict` VALUES (4, '安全通知', 'NOTICE_SAFE', 0, '2023-04-14 15:42:11', '2023-04-14 15:42:11');
INSERT INTO `t_dict` VALUES (5, '培训通知', 'NOTICE_TRAIN', 0, '2023-04-14 15:43:28', '2023-04-14 15:43:28');
INSERT INTO `t_dict` VALUES (6, '服饰类型', 'CLOTHES', 0, '2023-04-27 11:47:42', '2023-04-27 22:13:23');
INSERT INTO `t_dict` VALUES (7, '纸类类型', 'PAPER', 0, '2023-04-27 11:48:30', '2023-04-27 18:09:40');
INSERT INTO `t_dict` VALUES (8, '塑料类型', 'PLASTICS', 0, '2023-04-27 11:49:03', '2023-04-27 18:09:27');
INSERT INTO `t_dict` VALUES (9, '电器类型', 'ELECTRICAL_EQUIPMENT', 0, '2023-04-27 11:50:06', '2023-04-27 18:09:28');
INSERT INTO `t_dict` VALUES (10, '废旧金属类型', 'SCRAP_METAL', 0, '2023-04-27 11:51:32', '2023-04-27 18:09:29');
INSERT INTO `t_dict` VALUES (11, '工业废料类型', 'INDUSTRIAL_WASTE', 0, '2023-04-27 11:52:14', '2023-04-27 18:09:30');

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `fileName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文件真实名称',
                           `fileUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '文件路径',
                           `fileSize` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件大小',
                           `fileType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '文件类型',
                           `fileDelete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '文件是否删除（0：未删除，1：已删除）',
                           `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_file
-- ----------------------------

-- ----------------------------
-- Table structure for t_life
-- ----------------------------
DROP TABLE IF EXISTS `t_life`;
CREATE TABLE `t_life`  (
                           `id` int NOT NULL,
                           `lifeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '生活服务名称',
                           `lifeType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '生活服务类型',
                           `serverMoney` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '服务费用标准',
                           `lifeStatus` int NULL DEFAULT 0 COMMENT '服务状态（0启用，1关闭）',
                           `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '服务描述',
                           `staffId` int NULL DEFAULT NULL COMMENT '服务负责人（员工id）',
                           `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_life
-- ----------------------------

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `userId` int NOT NULL COMMENT '用户ID',
                             `dictId` int NOT NULL COMMENT '通知数据字典ID',
                             `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
                             `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
                             `noticeSendTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '通知发送时间',
                             `noticeDeadlineTime` datetime NULL DEFAULT NULL COMMENT '通知截止时间',
                             `noticeDelete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '通知是否被删除',
                             `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '通知表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_notice
-- ----------------------------

-- ----------------------------
-- Table structure for t_recycle
-- ----------------------------
DROP TABLE IF EXISTS `t_recycle`;
CREATE TABLE `t_recycle`  (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                              `recycleName` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '回收物名',
                              `sortId` int NOT NULL COMMENT '货物类型id',
                              `count` double NULL DEFAULT NULL COMMENT '总质量(数量)',
                              `money` double NULL DEFAULT NULL COMMENT '总金额',
                              `imageUrl` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图片',
                              `recycleDate` datetime NULL DEFAULT NULL COMMENT '回收日期',
                              `remark` varchar(130) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注信息',
                              `warehouseId` int NULL DEFAULT NULL COMMENT '仓库id',
                              `staffId` int NULL DEFAULT NULL COMMENT '回收员工id',
                              `status` int NULL DEFAULT 0 COMMENT '状态（0未删除、1删除）',
                              `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'product' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_recycle
-- ----------------------------
INSERT INTO `t_recycle` VALUES (1, '衣服', 6, 500, 100, 'sdgfddfsdf', '2023-04-15 00:00:00', '衣服', 1, 1, 0, '2023-04-27 16:40:25', '2023-04-27 17:47:50');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `roleName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
                           `roleLevel` int NOT NULL DEFAULT 1 COMMENT '角色等级(超管1，企业负责人2，企业员工3)',
                           `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `updateTIme` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE INDEX `roleName`(`roleName`) USING BTREE COMMENT '角色名称唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '超级管理员', 1, '2023-04-14 15:44:14', '2023-04-14 15:44:14');
INSERT INTO `t_role` VALUES (2, '管理员', 2, '2023-04-14 15:44:21', '2023-04-14 15:44:21');
INSERT INTO `t_role` VALUES (3, '员工', 3, '2023-04-14 15:44:58', '2023-05-27 21:05:51');

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff`  (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `roleId` int NULL DEFAULT NULL COMMENT '角色id',
                            `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '员工姓名',
                            `sex` int NULL DEFAULT NULL COMMENT '性别（0男，1女）',
                            `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
                            `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
                            `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
                            `contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '相关联系人',
                            `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES (1, 3, '张明', 0, '15244816101', '四川省成都市双流区', '96338589@qq.com', '李敏豪18782736435', '2023-04-27 17:05:58', '2023-04-27 17:06:54');
INSERT INTO `t_staff` VALUES (2, 3, '王明', 0, '19822956351', '四川省成都市双流区', 'wangsahng@qq.com', '王海19822956351', '2023-05-27 21:22:38', '2023-05-27 21:28:24');
INSERT INTO `t_staff` VALUES (3, 3, '吴悦', 1, '18228151031', '四川省成都市双流区', 'linfei@qq.com', '林斐19891514189', '2023-05-27 21:24:09', '2023-05-27 21:28:46');
INSERT INTO `t_staff` VALUES (4, 3, '姜昕', 1, '15314816123', '四川省成都市双流区', 'wangshan@qq.com', '王山19822956381', '2023-05-27 21:27:47', '2023-05-27 21:28:12');

-- ----------------------------
-- Table structure for t_train_month
-- ----------------------------
DROP TABLE IF EXISTS `t_train_month`;
CREATE TABLE `t_train_month`  (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `topic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '培训主题',
                                  `trainDate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '培训日期',
                                  `year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年份',
                                  `month` int NOT NULL COMMENT '月份',
                                  `trainDelete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否被删除',
                                  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '安全教育培训-月度资料表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_train_month
-- ----------------------------
INSERT INTO `t_train_month` VALUES (1, '消防安全培训', '2022-01-07', '2022', 1, 0, '2023-05-27 19:23:04', '2023-05-27 19:29:18');
INSERT INTO `t_train_month` VALUES (2, '工作培训', '2022-02-15', '2022', 2, 0, '2023-05-27 19:29:34', '2023-05-27 19:43:49');

-- ----------------------------
-- Table structure for t_train_month_file_link
-- ----------------------------
DROP TABLE IF EXISTS `t_train_month_file_link`;
CREATE TABLE `t_train_month_file_link`  (
                                            `trainId` int NOT NULL,
                                            `fileId` int NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '安全教育培训-月度资料关联附件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_train_month_file_link
-- ----------------------------
INSERT INTO `t_train_month_file_link` VALUES (1, 1);
INSERT INTO `t_train_month_file_link` VALUES (2, 2);

-- ----------------------------
-- Table structure for t_train_quarter
-- ----------------------------
DROP TABLE IF EXISTS `t_train_quarter`;
CREATE TABLE `t_train_quarter`  (
                                    `id` int NOT NULL AUTO_INCREMENT,
                                    `topic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '培训主题',
                                    `trainDate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '培训日期',
                                    `year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年份',
                                    `quarter` int NOT NULL COMMENT '季度(1,2,3,4)',
                                    `trainDelete` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否被删除',
                                    `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                    `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '安全教育培训-季度资料表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_train_quarter
-- ----------------------------

-- ----------------------------
-- Table structure for t_train_quarter_file_link
-- ----------------------------
DROP TABLE IF EXISTS `t_train_quarter_file_link`;
CREATE TABLE `t_train_quarter_file_link`  (
                                              `trainId` int NOT NULL,
                                              `fileId` int NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '安全教育培训-季度资料关联附件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_train_quarter_file_link
-- ----------------------------

-- ----------------------------
-- Table structure for t_train_year
-- ----------------------------
DROP TABLE IF EXISTS `t_train_year`;
CREATE TABLE `t_train_year`  (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `topic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '培训主题',
                                 `trainDate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '培训日期',
                                 `year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年份',
                                 `trainDelete` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否被删除',
                                 `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '安全教育培训-年度资料表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_train_year
-- ----------------------------

-- ----------------------------
-- Table structure for t_train_year_file_link
-- ----------------------------
DROP TABLE IF EXISTS `t_train_year_file_link`;
CREATE TABLE `t_train_year_file_link`  (
                                           `trainId` int NOT NULL,
                                           `fileId` int NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '安全教育培训-年度资料关联附件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_train_year_file_link
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `roleId` int NOT NULL DEFAULT 3 COMMENT '角色ID',
                           `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
                           `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '123456' COMMENT '密码',
                           `userName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名称',
                           `realName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '真实姓名',
                           `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话号码',
                           `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
                           `headImage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
                           `sex` int NULL DEFAULT 2 COMMENT '性别(0：男，1：女，2：未知)',
                           `userBlock` tinyint(1) NULL DEFAULT 0 COMMENT '是否禁止使用（0：未禁止，1：禁止）',
                           `whetherLogin` tinyint(1) NULL DEFAULT 0 COMMENT '是否登录（1：登录，0：未登录）',
                           `token` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '用户令牌',
                           `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 1, '510001', '123456', '超管', '超级管理员', '15244817109', NULL, NULL, 2, 0, 0, NULL, '2023-04-27 17:16:56', '2023-05-02 14:38:29');
INSERT INTO `t_user` VALUES (2, 2, '510002', '123456', '企业负责人', '企业负责人', '19822956351', NULL, NULL, 2, 0, 0, NULL, '2023-04-27 17:26:16', '2023-05-02 14:38:29');
INSERT INTO `t_user` VALUES (3, 3, '510003', '123456', '普通用户张明', '张明', '18785622310', NULL, NULL, 0, 0, 0, NULL, '2023-04-27 17:27:31', '2023-05-02 14:38:29');
INSERT INTO `t_user` VALUES (4, 3, '510004', '123456', '普通用户李菲', '李菲', '19822956798', '295623451@qq.com', '', 1, 0, 0, NULL, '2023-04-27 18:26:29', '2023-05-02 14:38:29');

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse`  (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `warehouseName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '仓库名称',
                                `warehouseType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '仓库类型',
                                `volume` double NULL DEFAULT NULL COMMENT '容量',
                                `count` int NULL DEFAULT NULL COMMENT '仓库数量',
                                `staffId` int NULL DEFAULT NULL COMMENT '仓库负责人（员工id）',
                                `status` int NULL DEFAULT 0 COMMENT '是否删除（0否，1是）',
                                `createTime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `updateTime` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------
INSERT INTO `t_warehouse` VALUES (1, '服饰仓库', '小型仓库', 1000, 2, 1, 0, '2023-04-27 17:41:32', '2023-04-28 00:03:33');
INSERT INTO `t_warehouse` VALUES (2, '纸类仓库', '大型仓库', 2000, 2, 2, 0, '2023-04-27 22:39:46', '2023-04-28 00:03:34');
INSERT INTO `t_warehouse` VALUES (3, '塑料仓库', '中型仓库', 3000, 2, 3, 0, '2023-04-27 22:40:47', '2023-04-28 00:03:35');
INSERT INTO `t_warehouse` VALUES (4, '电器仓库', '大型仓库', 3000, 2, 4, 0, '2023-04-27 22:40:58', '2023-04-28 00:03:35');
INSERT INTO `t_warehouse` VALUES (5, '废旧金属仓库', '大型仓库', 5000, 2, 5, 0, '2023-04-27 22:41:37', '2023-04-28 00:03:36');
INSERT INTO `t_warehouse` VALUES (6, '工业废料仓库', '大型仓库', 6000, 2, 6, 0, '2023-04-27 22:42:19', '2023-04-28 00:03:39');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
                         `user_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
                         `password` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
                         `real_name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '姓名',
                         `address` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '地址',
                         `phone` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '联系方式',
                         `user_type` int NOT NULL COMMENT '用户类型',
                         `image_url` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
                         `sex` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                         `email` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'user' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, 'admin', '12345', '超管', '四川省成都市双流区', '18229563590', 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//aa677d43-71cb-4a4e-8393-3a3091cc8b3f_3.jpg', '1', '19129932@qq.com');
INSERT INTO `user` VALUES (7, '回收管理员', '12345', '管理员', '四川省成都市双流区', '19822956351', 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//b9b83b88-1cf5-4099-83a7-18d72d73a396_11.jpg', '1', '789456218@qq.com');
INSERT INTO `user` VALUES (16, '员工', '12345', '杨宇', '四川省成都市双流区', '18229563551', 2, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//6f2a5de8-ad7d-4889-83d8-6b0463df7c57_1.jpg', '1', '964485793@qq.com');
INSERT INTO `user` VALUES (17, '员工', '12345', '马菲', '成都市双流区', '19225631470', 2, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2023-05-09//8ca0e656-a8cb-42ce-8170-356a3a84fa47_28.jpg', '2', '943185102@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
