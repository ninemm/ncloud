/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : tcloud-admin

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2018-12-06 10:17:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for upms_department
-- ----------------------------
DROP TABLE IF EXISTS `upms_department`;
CREATE TABLE `upms_department` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `dept_name` varchar(30) NOT NULL COMMENT '部门名称',
  `dept_level` int(11) NOT NULL COMMENT '节点级别 0为根节点 1:一级节点 1:二级节点',
  `data_area` varchar(22) DEFAULT NULL COMMENT '数据域编码',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '上级部门ID',
  `is_parent` smallint(1) DEFAULT NULL COMMENT '是否上级节点',
  `order_reviewer_id` varchar(32) DEFAULT NULL COMMENT '订单审核人ID',
  `principal_user_id` varchar(32) DEFAULT NULL COMMENT '部门负责人ID',
  `child_ids` text COMMENT '所有子节点',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `order_list` int(11) DEFAULT NULL COMMENT '排序',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门';

-- ----------------------------
-- Records of upms_department
-- ----------------------------
INSERT INTO `upms_department` VALUES ('0', '武汉珈研', '0', '001', '', '1', null, '阿牛', 'ce9fd8bfb4b342a8ab0ea6d9931b446d;78a5da950afb403ea9028f196eb4db9e;', '武汉珈研', '0', '2017-07-27 17:21:37', '2017-07-27 17:21:39');
INSERT INTO `upms_department` VALUES ('01477a4814e3471facf6dac537d173b0', '依荞', '5', '001001002002002002', '15b8a9284d304465add50d224279acaf', '0', null, null, null, null, '2', '2017-12-14 19:39:38', null);
INSERT INTO `upms_department` VALUES ('017e3cd17db64494942d6ead450c1a73', '茂盛源', '5', '001001002002009001', 'a13d71ed4d2d46c48bf9ef6fdefeefb7', '0', null, null, null, null, '1', '2017-12-14 19:41:24', null);
INSERT INTO `upms_department` VALUES ('022231caec2a438a8c522d5f538c74f6', '国酒', '2', '001001007', '6ab47b7b0acd4547932a97621730b071', '1', null, '22ead5d7ef8847cdbcaaf1dbaf8d42c9', '22ead5d7ef8847cdbcaaf1dbaf8d42c9;', null, '8', '2018-01-20 21:01:59', '2018-03-05 17:59:29');
INSERT INTO `upms_department` VALUES ('02fefe398433421a8e33149e0955539f', '合信', '5', '001001001002004003', 'e97d32559ab14dfcaf3fb57ce2cfd41f', '0', null, null, null, null, '3', '2017-12-14 19:31:21', null);
INSERT INTO `upms_department` VALUES ('032df199f7af42edbd6d39ae936f8188', '商超部', '4', '001001001001002', 'eb0da9b8cd7c44c888477a4c1947bf44', '1', null, '7ace715943794ad3a0bab810575a362a', '7ace715943794ad3a0bab810575a362a;', null, '2', '2017-12-14 19:28:03', '2017-12-15 19:10:14');
INSERT INTO `upms_department` VALUES ('04c2f20e60d6424a863d739fc5e1080b', '向远慧组', '4', '001001002002007', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '7', '2017-12-14 19:38:45', null);
INSERT INTO `upms_department` VALUES ('06398ab1d271431bb293e80f1528a705', '陈秀丽组', '4', '001001002002008', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '8', '2017-12-14 19:38:53', null);
INSERT INTO `upms_department` VALUES ('08844c6314b944988c382e9a19273414', '李爽组', '4', '001001002002005', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '5', '2017-12-14 19:38:31', null);
INSERT INTO `upms_department` VALUES ('0cf7259bbebc4e28982dce14cd7c3df1', '鑫兴隆', '5', '001001002002001001', 'b50a364e2c6446c28fbc5b83407c2e6a', '0', null, null, null, null, '1', '2017-12-14 19:39:18', null);
INSERT INTO `upms_department` VALUES ('0cfed11947ee49a7b04a077c4df303ec', '清风', '3', '001001001005', 'e58667e0601b46ed8a2868546954c407', '0', null, '792b3da063e54ff1bea622bf64cba5ba', '792b3da063e54ff1bea622bf64cba5ba;', null, '5', '2018-01-19 22:43:39', '2018-01-29 16:21:18');
INSERT INTO `upms_department` VALUES ('0ea252c86d9347f58a37c1e738c311de', '程锴组', '4', '001001001002002', '61e16b3010194d968fed8ee25800b6fa', '1', null, null, null, null, '2', '2017-12-14 19:28:43', null);
INSERT INTO `upms_department` VALUES ('1582e28a8bba4611a8f628fdfc0fcd15', '立志', '5', '001001001002003002', 'e85121be89384c7ba86a95c3db8b4e6c', '0', null, null, null, null, '1', '2017-12-14 19:30:54', null);
INSERT INTO `upms_department` VALUES ('15b8a9284d304465add50d224279acaf', '黄利华组', '4', '001001002002002', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '2', '2017-12-14 19:38:10', null);
INSERT INTO `upms_department` VALUES ('17f5ec7d60e043a1a5e1ab4b10bacb73', '咸宁荞泰丰', '2', '001001004', '6ab47b7b0acd4547932a97621730b071', '1', null, null, '2fd2addcf013480e9f8f9c65788b2cf5;a9213a732d57411e94daa3d31d5e7096;b01c1e972d1d4f79a8b44f5559798dd2;', null, '4', '2017-12-20 21:06:05', null);
INSERT INTO `upms_department` VALUES ('19f7bfd0108f42698351089ed458b829', '黄鹤楼集团', '1', '001003', '0', '1', null, null, null, null, '3', '2018-01-16 17:47:00', null);
INSERT INTO `upms_department` VALUES ('1b0bb90779c94307bcb17c148cba5681', '汉桥', '5', '001001002002007001', '04c2f20e60d6424a863d739fc5e1080b', '0', null, null, null, null, '1', '2017-12-14 19:40:52', null);
INSERT INTO `upms_department` VALUES ('1b3bfa16365447b19ff7a57a1410f973', '鲍泽高组', '4', '001001001003004', '55c01e0e61564eba8001f9d5a9df9412', '0', null, null, '8afccc65e0634599a7442953ad696f24;0869aa4eef1d47d7a85e3d355ed3708c;', null, '1', '2017-12-14 19:29:40', null);
INSERT INTO `upms_department` VALUES ('1cbb2423706946dbb328fc048b5fcecf', '综合销售部', '4', '001001001001003', 'eb0da9b8cd7c44c888477a4c1947bf44', '0', null, null, null, null, '3', '2017-12-14 19:28:10', null);
INSERT INTO `upms_department` VALUES ('1e677b1ebfcd40d080a97bbb68dd3b3b', '黄酒部门', '3', '001001005003', 'c913f77079824f26985441eb10fe23e3', '0', null, null, 'f4609a97aff64881aafa498600029019;', null, '3', '2017-12-22 19:53:24', null);
INSERT INTO `upms_department` VALUES ('248fb886c24a471abe8d3fdc2408f13c', '总部', '3', '001001002001', 'c8b8aa836e194c95a5942a36b166af3f', '1', null, null, null, null, '1', '2017-12-14 19:35:12', null);
INSERT INTO `upms_department` VALUES ('29caf0a60730441d8e30955596ad7b4c', '超付批发', '5', '001003001001001001', '7b0cf58725a947f5a40cd95e902c4de2', '0', null, null, '42710989e88849359e1d4f250b28825b;', null, '1', '2018-01-16 18:22:30', null);
INSERT INTO `upms_department` VALUES ('2b2329fdef784808a7dccd9ff2de60fb', '银泰创意城', '3', '001003001001', '55e62aacfa0d459e8a1e75aaba973db4', '1', null, null, '32282144bcc24e2faa11123a1daecceb;2d4392b2fd9341a7a7fdec204cdb3f56;9a1dc32b1de244a2a1abae45b139e5bc;', null, '1', '2018-01-16 17:48:20', null);
INSERT INTO `upms_department` VALUES ('2b77faaeecfd4830b1a50fd6901c757a', '陈宇组', '4', '001001002002004', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '4', '2017-12-14 19:38:24', null);
INSERT INTO `upms_department` VALUES ('3046fd7aa0a74a679d0e1a89773d0f73', '帅柳组', '4', '001001002002006', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '6', '2017-12-14 19:38:37', null);
INSERT INTO `upms_department` VALUES ('3105528d84654eef89812f26be23e481', '马幸组', '5', '001001001001001002', '9dd2c516204b48b1b400fe54cf18743a', '0', '619cd0083d534e1e88fbc9784010c4a8', '619cd0083d534e1e88fbc9784010c4a8', 'e9b802a57ae4494ab28336b6d93cb377;79fc6554835046d881ecb206b84f4e3e;493f3036f291404eb74bf2e534ef7c6d;619cd0083d534e1e88fbc9784010c4a8;5d95c12cf70d47eb9190d93085a8ffc9;860cde4cdfe4445a96763876b1b3b45a;', null, '2', '2017-12-14 19:32:20', '2018-03-02 16:13:05');
INSERT INTO `upms_department` VALUES ('37d3bab0d1544505940ce6e02cddf7d7', '苦荞部门', '3', '001001005004', 'c913f77079824f26985441eb10fe23e3', '0', null, null, 'f3505bc871c543f2892b2722e69db537;', null, '4', '2017-12-25 09:55:52', null);
INSERT INTO `upms_department` VALUES ('39a6639636fd46528e81e3625f88a2ab', '鑫宏达', '5', '001001002002003001', '6f4dd8ea318c41358fad931456ab5fbd', '0', null, null, null, null, '1', '2017-12-14 19:39:56', null);
INSERT INTO `upms_department` VALUES ('3a5bdb5acfcd46598034121ad08b8c82', '何珍慧组', '5', '001001001001002002', '032df199f7af42edbd6d39ae936f8188', '0', null, null, null, null, '2', '2017-12-14 19:32:44', null);
INSERT INTO `upms_department` VALUES ('3f69a937ba824de6923193d28e188e91', '直营部', '3', '001001002002', 'c8b8aa836e194c95a5942a36b166af3f', '1', null, null, null, null, '2', '2017-12-14 19:35:23', null);
INSERT INTO `upms_department` VALUES ('4e6c732245c64f5f82f7be22093139c3', '白酒部门', '3', '001001005002', 'c913f77079824f26985441eb10fe23e3', '0', null, null, '5f8ca4bcbb0a4d9c978058056bc1138e;', null, '2', '2017-12-22 19:12:57', null);
INSERT INTO `upms_department` VALUES ('4f3c1d1167254d28b5eda6f4d56050b4', '大冶华劲', '2', '001001003', '6ab47b7b0acd4547932a97621730b071', '0', null, null, '33fb92029a654731981d0709e27a468c;', null, '3', '2017-12-14 19:26:55', null);
INSERT INTO `upms_department` VALUES ('5081b8b9c9774bac8ad946e488db3eee', '鄂渝', '5', '001001002002006001', '3046fd7aa0a74a679d0e1a89773d0f73', '0', null, null, null, null, '1', '2017-12-14 19:40:40', null);
INSERT INTO `upms_department` VALUES ('55c01e0e61564eba8001f9d5a9df9412', '直营二部', '3', '001001001003', 'e58667e0601b46ed8a2868546954c407', '1', null, null, '471961af978f45958e6b9505f1a7019f;', null, '3', '2017-12-14 19:27:33', null);
INSERT INTO `upms_department` VALUES ('55e62aacfa0d459e8a1e75aaba973db4', '武商贸易集团', '2', '001003001', '19f7bfd0108f42698351089ed458b829', '1', null, null, 'dd6dd89c80954525871ce4a1f50f90cc;', null, '1', '2018-01-16 17:47:53', null);
INSERT INTO `upms_department` VALUES ('5664de65a19c488c9744c26410fcba0e', '餐饮部', '4', '001001002001001', '248fb886c24a471abe8d3fdc2408f13c', '1', null, null, null, null, '1', '2017-12-14 19:35:44', null);
INSERT INTO `upms_department` VALUES ('58b2e2cead864497b101f407de25f61f', '清风', '5', '001001001002001001', 'a6c18cd9848d4b5bb009548dc3b7d408', '0', null, '8fa466a0c3114f14afce1aab6aa3218a', '2849e2bc51b44d88a7012ec8aad50878;8fa466a0c3114f14afce1aab6aa3218a;', null, '1', '2017-12-14 19:30:01', '2017-12-15 19:10:56');
INSERT INTO `upms_department` VALUES ('5ed84dd125f7435aa5916dd308e1af6e', '李国民组', '5', '001001001001002003', '032df199f7af42edbd6d39ae936f8188', '0', null, null, null, null, '3', '2017-12-14 19:32:52', null);
INSERT INTO `upms_department` VALUES ('61e16b3010194d968fed8ee25800b6fa', '直营一部', '3', '001001001002', 'e58667e0601b46ed8a2868546954c407', '1', null, '619cd0083d534e1e88fbc9784010c4a8', 'db932cbd142a419a91ad583cb0b1433f;889d05c759c8482eaa583f3008b79a04;', null, '2', '2017-12-14 19:27:27', '2018-01-19 14:43:31');
INSERT INTO `upms_department` VALUES ('620968477d2747ba919dda28e70e8cb1', '明明', '5', '001001002002008002', '06398ab1d271431bb293e80f1528a705', '0', null, null, null, null, '2', '2017-12-14 19:41:12', null);
INSERT INTO `upms_department` VALUES ('63e0f0764b9541ec9d3415f3f2658114', '广州龙泉', '2', '001002001', 'deaaabdd3cd8464a9592dc0e4d1a27eb', '1', null, null, '1398151304bc45fb818ee17c482a78d5;', null, '1', '2018-01-03 16:53:13', null);
INSERT INTO `upms_department` VALUES ('6590d0d632c141fa87ab3b1457057127', '玉红', '5', '001001002002008001', '06398ab1d271431bb293e80f1528a705', '0', null, null, null, null, '1', '2017-12-14 19:41:05', null);
INSERT INTO `upms_department` VALUES ('6ab47b7b0acd4547932a97621730b071', '劲牌公司', '1', '001001', '0', '1', null, null, null, null, '1', '2017-12-14 19:26:17', null);
INSERT INTO `upms_department` VALUES ('6f3a6d17462947a7b2b14a98787a4c6c', '新诚', '5', '001001002002005001', '08844c6314b944988c382e9a19273414', '0', null, null, null, null, '1', '2017-12-14 19:40:28', null);
INSERT INTO `upms_department` VALUES ('6f4dd8ea318c41358fad931456ab5fbd', '何学武组', '4', '001001002002003', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '3', '2017-12-14 19:38:17', null);
INSERT INTO `upms_department` VALUES ('7126c93a109648df957a5f76716b876a', '建新', '5', '001001001002002002', '0ea252c86d9347f58a37c1e738c311de', '0', null, null, null, null, '2', '2017-12-14 19:30:32', null);
INSERT INTO `upms_department` VALUES ('751187a1979146a1b3743193026afc7f', '张家文组', '4', '001001001003002', '55c01e0e61564eba8001f9d5a9df9412', '0', null, null, null, null, '3', '2017-12-14 19:29:26', null);
INSERT INTO `upms_department` VALUES ('756d01a11ba64d4aa3d31e3f6ff0f190', '广州龙泉(稻花香)', '3', '001002001001', '63e0f0764b9541ec9d3415f3f2658114', '0', null, null, '4134d2e51e5844a1abd4bc18ce343e11;7c86b5cedbe0448197618a19b98622b7;89385fdf920b480f8ffd6899e96b5e87;6a75843beb894c6d99e20311c7b0e2b1;ccc77d7ec5f6424e87992f7d2df5ccee;', null, '1', '2018-01-03 16:53:34', null);
INSERT INTO `upms_department` VALUES ('77a4b8ee6dd04536a987262e5c625d90', '刘顺发', '5', '001001002002002001', '15b8a9284d304465add50d224279acaf', '0', null, null, null, null, '1', '2017-12-14 19:39:32', null);
INSERT INTO `upms_department` VALUES ('796aa09db09e4d6fb07df50919fb5dee', '周远亮组', '4', '001001001003001', '55c01e0e61564eba8001f9d5a9df9412', '0', null, null, null, null, '4', '2017-12-14 19:29:19', null);
INSERT INTO `upms_department` VALUES ('7a9ee51b7eaa458bba329d6b9c696a70', '易亚伦组', '5', '001001002001001002', '5664de65a19c488c9744c26410fcba0e', '0', null, null, null, null, '2', '2017-12-14 19:37:03', null);
INSERT INTO `upms_department` VALUES ('7aee5b9028c541b1afa600db1364991f', '董细美组', '5', '001001001001002001', '032df199f7af42edbd6d39ae936f8188', '0', null, '5d95c12cf70d47eb9190d93085a8ffc9', null, null, '1', '2017-12-14 19:32:37', '2017-12-16 17:16:55');
INSERT INTO `upms_department` VALUES ('7b0cf58725a947f5a40cd95e902c4de2', '直营一部', '4', '001003001001001', '2b2329fdef784808a7dccd9ff2de60fb', '1', null, null, null, null, '1', '2018-01-16 18:22:11', null);
INSERT INTO `upms_department` VALUES ('7b62cbde853e40f285ce17638a5b8391', '茅台', '3', '001001007001', '022231caec2a438a8c522d5f538c74f6', '0', null, null, 'fe60836f7f7a410b89abbafc8db48893;', null, '1', '2018-01-20 21:02:25', null);
INSERT INTO `upms_department` VALUES ('7d6d059e072649a587c7db90444aa872', '万顺鑫', '5', '001001001002003001', 'e85121be89384c7ba86a95c3db8b4e6c', '0', null, null, null, null, '2', '2017-12-14 19:30:47', null);
INSERT INTO `upms_department` VALUES ('8010db17372544ef970e949fd4ee4acd', '刘昌文组', '4', '001001001003003', '55c01e0e61564eba8001f9d5a9df9412', '0', null, null, null, null, '2', '2017-12-14 19:29:33', null);
INSERT INTO `upms_department` VALUES ('93236e88e61e4d2180536bcb8c835c36', '汪梦龙组', '5', '001001001001001001', '9dd2c516204b48b1b400fe54cf18743a', '0', null, '8897e1e6dc76460895c19b00a980492b', 'e560c65edfac4730bbb09370d7f6001e;83a411e154214eb98b9b2de903da11db;41ed3adf92fa4fb191d6fd32eb6a2a79;8897e1e6dc76460895c19b00a980492b;', null, '1', '2017-12-14 19:32:14', '2018-01-25 15:45:36');
INSERT INTO `upms_department` VALUES ('9769e1c4bd2a4d53b4673baafb6f9916', '车销部门', '3', '001001004001', '17f5ec7d60e043a1a5e1ab4b10bacb73', '0', null, null, null, null, '5', '2017-12-20 21:13:28', '2017-12-20 21:13:51');
INSERT INTO `upms_department` VALUES ('99e2904e45124b6597697d9eb41b3ed3', '腾谷', '5', '001001001002001002', 'a6c18cd9848d4b5bb009548dc3b7d408', '0', null, '005f2018e58e419fb3471b42b4917e42', 'd0bd75000eed404487dc04df3220afe8;005f2018e58e419fb3471b42b4917e42;', null, '2', '2017-12-14 19:30:07', '2017-12-15 19:11:04');
INSERT INTO `upms_department` VALUES ('9dd2c516204b48b1b400fe54cf18743a', '餐饮部', '4', '001001001001001', 'eb0da9b8cd7c44c888477a4c1947bf44', '1', null, '619cd0083d534e1e88fbc9784010c4a8', '02b537aeaf6a44b8a407c5fed0a1cf01;ebda4cece29c419496b06dc840cbe408;2f414aad02d04441b5c0c589e5190fc1;223b14df0536406abeb43d28a253bee7;579c6981ba194cc2b272caaf2ea0b715;4661ce25c89f40d19fd0dc194afafd10;a2bd5d6fdfde4d41a6d7693a19ea8bee;5b0dc1dcc94f499f9a76090ea9f4cc41;', null, '1', '2017-12-14 19:27:54', '2018-01-19 14:55:20');
INSERT INTO `upms_department` VALUES ('9f71f8a7a0df4c83b9dd8d5ec2c80494', '茅台1', '3', '001001007002', '022231caec2a438a8c522d5f538c74f6', '0', null, '22ead5d7ef8847cdbcaaf1dbaf8d42c9', '23783c5d67e541ad8a0de7e929803727;', null, '2', '2018-01-20 21:45:01', '2018-03-05 17:59:02');
INSERT INTO `upms_department` VALUES ('a13d71ed4d2d46c48bf9ef6fdefeefb7', '唐荣组', '4', '001001002002009', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '9', '2017-12-14 19:39:01', null);
INSERT INTO `upms_department` VALUES ('a6c18cd9848d4b5bb009548dc3b7d408', '陈霞组', '4', '001001001002001', '61e16b3010194d968fed8ee25800b6fa', '1', null, '6b60a5599e1b41858795c37be51956f3', '6b60a5599e1b41858795c37be51956f3;', null, '1', '2017-12-14 19:28:36', '2017-12-15 19:10:42');
INSERT INTO `upms_department` VALUES ('b14c9be9844447eaaa39b0c679fb6dd1', '劲酒部门', '3', '001001005001', 'c913f77079824f26985441eb10fe23e3', '0', null, null, 'e4fec9df3f934164b840afa9327722de;', null, '1', '2017-12-22 19:12:42', null);
INSERT INTO `upms_department` VALUES ('b24ce300dc084cccb39236e323e5a22c', '习酒公司', '1', '001004', '0', '1', null, null, 'f13005bd3c7a4450bee445b2ce383376;', null, '10', '2018-01-29 10:59:42', null);
INSERT INTO `upms_department` VALUES ('b50a364e2c6446c28fbc5b83407c2e6a', '邹玲组', '4', '001001002002001', '3f69a937ba824de6923193d28e188e91', '1', null, null, null, null, '1', '2017-12-14 19:38:03', null);
INSERT INTO `upms_department` VALUES ('b9fc3766e8514c7ab2248cad10ebf60e', '咏梅', '5', '001001001002004001', 'e97d32559ab14dfcaf3fb57ce2cfd41f', '0', null, '58f5464b47ea4e18bf7834d30a80dc71', '626e1f78ee9a4cf38fbfd9664e586658;58f5464b47ea4e18bf7834d30a80dc71;', null, '1', '2017-12-14 19:31:09', '2017-12-15 19:11:16');
INSERT INTO `upms_department` VALUES ('be6416eb61a144ff87fc6b25f0bd90fb', '邱康组', '5', '001001002001001003', '5664de65a19c488c9744c26410fcba0e', '0', null, null, null, null, '3', '2017-12-14 19:37:10', null);
INSERT INTO `upms_department` VALUES ('bf41b355b97b44888b3465be8cb46577', '古酒', '3', '001001001004', 'e58667e0601b46ed8a2868546954c407', '0', null, null, '9b7a60b72d064d9d9ab212414a8f58e3;', null, '4', '2018-01-19 10:24:10', null);
INSERT INTO `upms_department` VALUES ('c11e5f292b5e42a4a54e556f78aed193', '新世界百货', '3', '001003001002', '55e62aacfa0d459e8a1e75aaba973db4', '0', null, null, 'cc6b1bb8b3f24267921ea9ba69d6f036;8a117c32a7ab47e6a876d68755445599;40aef31bb35b42b7b9c86ab22061f5a5;', null, '2', '2018-01-16 17:48:27', null);
INSERT INTO `upms_department` VALUES ('c13ae60a6af042c789d61004a91b4823', '正光', '5', '001001001002004002', 'e97d32559ab14dfcaf3fb57ce2cfd41f', '0', null, null, 'bfb55bfaa6d54c4188d066e9e11c3b34;', null, '2', '2017-12-14 19:31:14', null);
INSERT INTO `upms_department` VALUES ('c3c67e04e5cb4665bcb04b2584281fe6', '申科组', '5', '001001002001001004', '5664de65a19c488c9744c26410fcba0e', '0', null, null, null, null, '4', '2017-12-14 19:37:16', null);
INSERT INTO `upms_department` VALUES ('c8aa1bec61284aa98373e0c0383ac141', '习酒公司（劲酒）', '2', '001004001', 'b24ce300dc084cccb39236e323e5a22c', '0', null, null, '824e02bc63c540bd95313d7acff1b178;867797f313c3432cadf14db43eeed2b2;9470df3490a44fae8ce1e351615d3fb4;', null, '10', '2018-01-29 11:12:13', null);
INSERT INTO `upms_department` VALUES ('c8b8aa836e194c95a5942a36b166af3f', '启光商贸（白酒）', '2', '001001002', '6ab47b7b0acd4547932a97621730b071', '1', null, null, '05e218df692e42c3802fb06372bbe8a4;', null, '2', '2017-12-14 19:26:38', null);
INSERT INTO `upms_department` VALUES ('c913f77079824f26985441eb10fe23e3', '湖北事业部', '2', '001001005', '6ab47b7b0acd4547932a97621730b071', '1', null, 'caa97c59ae32436aab449480bfd590f1', 'caa97c59ae32436aab449480bfd590f1;', null, '5', '2017-12-22 19:12:28', '2017-12-22 19:15:22');
INSERT INTO `upms_department` VALUES ('c9925e9888cd4e5080391f4596171774', '鲁朋组', '5', '001001002001001001', '5664de65a19c488c9744c26410fcba0e', '0', null, null, null, null, '1', '2017-12-14 19:36:52', null);
INSERT INTO `upms_department` VALUES ('d5f1518493834dbeab7369c295c1290c', '鑫长生', '5', '001001002002004001', '2b77faaeecfd4830b1a50fd6901c757a', '0', null, null, null, null, '1', '2017-12-14 19:40:07', null);
INSERT INTO `upms_department` VALUES ('d79164b7cf5b4b8b96fe94b5c2cde429', '鑫茂盛', '5', '001001002002009002', 'a13d71ed4d2d46c48bf9ef6fdefeefb7', '0', null, null, null, null, '2', '2017-12-14 19:41:32', null);
INSERT INTO `upms_department` VALUES ('deaaabdd3cd8464a9592dc0e4d1a27eb', '白云边公司', '1', '001002', '0', '1', null, null, 'e64418168dff4111a62f4e5ad287c25d;', null, '2', '2018-01-03 16:51:48', null);
INSERT INTO `upms_department` VALUES ('e07acca2e03245698ca66cf1575dce19', '习酒公司（白酒）', '2', '001004002', 'b24ce300dc084cccb39236e323e5a22c', '0', null, null, '7a1c125dbbeb4dad920841c4e0791de6;1d36208a0e904bff85017921d5e4807d;', null, '10', '2018-01-29 11:12:26', null);
INSERT INTO `upms_department` VALUES ('e4334ecbb17c4ef1b610cb84c633f17d', '瑞佳', '5', '001001001002002001', '0ea252c86d9347f58a37c1e738c311de', '0', null, null, null, null, '1', '2017-12-14 19:30:26', null);
INSERT INTO `upms_department` VALUES ('e4c967ce5ed241cdb3a7725c42963374', '广州龙泉(劲酒)', '3', '001002001002', '63e0f0764b9541ec9d3415f3f2658114', '0', null, null, 'b36522edfec24d1384e6d651e90e956e;', null, '2', '2018-01-03 16:53:43', null);
INSERT INTO `upms_department` VALUES ('e4cf1da399f748069d30030ac124f1ae', '习酒公司（红酒）', '2', '001004003', 'b24ce300dc084cccb39236e323e5a22c', '0', null, null, 'ff3e7f711d4a4e08a1da2ce12631839c;d5372bd408a543ea9457cc0bafcea8a8;', null, '10', '2018-01-29 11:12:42', null);
INSERT INTO `upms_department` VALUES ('e58667e0601b46ed8a2868546954c407', '启光商贸（劲酒）', '2', '001001001', '6ab47b7b0acd4547932a97621730b071', '1', null, 'eaf5aecf83f44f63bf18365843a8327c', 'eaf5aecf83f44f63bf18365843a8327c;d9f3e2097b364a7e950cab8b2618a934;1252028deff7434dbd77cc91bff8dff2;38cd642b29f145979e36d7c867e26fd7;fd4d8ed313074548bc6e3a63bf0ef533;7d3c156c91e443da83aa1139b8fb2a39;', null, '1', '2017-12-14 19:26:32', '2018-01-23 09:21:01');
INSERT INTO `upms_department` VALUES ('e85121be89384c7ba86a95c3db8b4e6c', '周雷组', '4', '001001001002003', '61e16b3010194d968fed8ee25800b6fa', '1', null, null, null, null, '3', '2017-12-14 19:28:50', null);
INSERT INTO `upms_department` VALUES ('e97d32559ab14dfcaf3fb57ce2cfd41f', '朱云翔组', '4', '001001001002004', '61e16b3010194d968fed8ee25800b6fa', '1', null, null, 'fc022eaf6c274fd3a3a4a9fbd5a0d460;', null, '4', '2017-12-14 19:29:03', null);
INSERT INTO `upms_department` VALUES ('eb0da9b8cd7c44c888477a4c1947bf44', '总部', '3', '001001001001', 'e58667e0601b46ed8a2868546954c407', '1', null, null, '4e8f2e5ef22c460ca4bf7b04da8e8375;4dfafefb27404b96bccd4ea8171f7602;1223d8d7f1a24a50afc4bd846859e28e;ea89db427267407489395a8b62c9c24e;19f914661f5a4cb3a1edb97f1fe4a188;d317098089dd41ae9cc94db549a2dad1;8281eb212fe14829837521f7373c89e2;0e3e986405644e9fb22d08eb2aabb7c3;0e5d9e0d79464ff58e90a6ef7a50804f;', null, '1', '2017-12-14 19:27:14', null);
INSERT INTO `upms_department` VALUES ('ed7c6871011645feacfa9cd150f5a621', '弘兴', '5', '001001002002004002', '2b77faaeecfd4830b1a50fd6901c757a', '0', null, null, null, null, '2', '2017-12-14 19:40:15', null);
INSERT INTO `upms_department` VALUES ('f0f793bf4bfc47719cb8176879961603', '乔三白酒制业', '2', '001001006', '6ab47b7b0acd4547932a97621730b071', '0', null, null, null, null, '7', '2017-12-23 22:27:43', null);
INSERT INTO `upms_department` VALUES ('f492590bb64f4c48af18c94e322fa7ca', '雪梅', '3', '001001001006', 'e58667e0601b46ed8a2868546954c407', '0', null, null, '20c86e52b1124a4fa133a62ad6b9b3c3;144e45ea01f44089aaaebe5f8bc80e97;c7c959f9640c4286bbb59f5188412738;e8cf3cc32b0447e0a0f42147ef6151b7;936b7d67bb034d15890763d798ee4b79;5f19148171b14f90884c6d728276a5e4;6aab2bdeddf149f4b99816a59e0b9249;62393c2b32494e75a7be0062fd645cc5;e421d4a3099b486d8ed67b0aa1b10592;1c51ed85f82f4f2c85d62ffab27f0d4d;7a87f8c0e36e4cdd9889612d74576f6f;c255ab3163104281b2b2aad72dd770c2;b8dd52d508704736aaae8187319b6229;dd655abade434d9f90b7f103432a1bcc;4cb6b3683f1646f2afaaed4b778a5253;d810ff2a2c4a4745bffd51619c95c430;535562b1ecf94b9aa659cc0e5e8b5947;5b6ad6c845bc4d86953c1030a7989c79;236ca2bd87e0498698ac59119787c81f;a60c8f4e6ee5474fb4db263ec2683b55;8f6bf6a94bfe46c7a02d11bbea6f0440;ae5a1ad893bf4c8b8e3d83158afe26e4;1f2925165c7d47c8aeba2031507f707c;c0af4974186d406ca8edae34dd217e94;7ab57990588447468b09fb4fb753418b;1701f4f384aa424abac3793b09e071ef;5ae9ddd025c44fb495a03c5bc98cb3a5;de3806fb21f74a2d8b1fe2beef9968e4;076e77cab1f746ef90070cf11001b984;6d165f60d0824b328f74709dd674f130;11112951cc5141b4806a7b0d3a400bd2;01d1c8ecfbc64a92bd2cd3b31ed8c514;074d2670017746649de30b8945f4ce3c;8c93fbf3faa24065945d9cc99c9b3b9f;9d674f5974274126a7d517ba1056730f;b9795c3de7a548589b470893ef0d39fe;9172866ad5824327b3f42c1953a38580;5bd34925157f4e58ab5765ff500bbab1;27964d4af59e42cdb1f92c3837560ebb;ec174724f97044daa73b1a0097ce6a2a;35e2eb76d5e54452bb24aca9303cb668;b29affe16c254a9880c1a4aaa6f62273;359a2fcfd99949fbb511501af4c7341d;445921ecc9aa4e5cb96cbd2781be0f3c;51f6b1286fe74ea9850a724827850983;f74f9247f8654ffb9f6ee81bd55c6d35;bd81565a45f24ddb9ee95ce5de75804d;e561be0126fe478e80528ae2fd21e1ea;383634fd73744d478c5b3833ec532298;0b4176ac60d24c719be93a89f6f55623;e32e558716434fdcba74add5cac563ee;7ee46faa84954c239c1bf25bb977cc2d;f146d0facd47492cb78e697e436076b6;ea25911a6fe4430880e4781cea6ceb82;7a7c5e79adb04f33a4d784c4cf61fd8f;dfca4f9059f6462e98389a90afe4127f;fb3dd236642947f4a8d8a23b4d85f441;8c46cc86d1d040188f5a7e5c4bac5929;ef4d908bee27485c898a32ca7c20905f;1ee5b9bd76574447a1496fe5ad873900;67ca5661fe414a1aa85647279cb9f73e;5074d19886804c22b0bfee531578a12f;b6e9c61f3c484cf6a6f810ef667b667d;4322f6d9c42b46949d4b5c00311cbe5b;29422459893d4824bd668b93d1677219;2a11d62fd4d9434fa6f10ea665dcd84a;2249c2675b604aeda94326f6446254d8;bd5dff582bca47b6841103af87a6a6b8;d7ad551222f74b99ab5741f6228f2dee;a6b1b6a0eae24d11a25fb7dc8fcf56be;6d973960164543f89697b70951494070;85f2cce2f7f843098e1fe8ea0fb065ec;4860a0b46dbc4f94baa6ee3b80c639d7;4659d653c01449a19bc604c6fe40969c;e27c17c249144b1b85dbc2cd707b5783;0431a74b564042cbadfcf1e06b1751ed;fc3bef3d1ca845d1801790f9d75abfd3;9f33781e6b9c46ff86299e1fa33fc292;77a5f9726c924254aa2bd00b8dfb830f;54ede96122cd4a94b6e3097a8a0373ab;66c1f493038e4f8e976afe2dc228ddb2;167fb799bcb240748785d94e4308e69a;89fe409cff2845bb861faee68571b40f;919e5041e73e460d9ab56ee1517878c0;5699534b973c42ccbbae38017b0eda54;f5ab5d8dbd99486e89273385474bfe49;daf741a3e89d41a59dcc6717302a55ed;6e9e8473e06c45efb2bb956a26d15126;c237e1f3eed1402fb236612e142d632f;ab0edc01d57540c5a8eeb8daaf74af60;7e1bef71b44d4e9780fd79734d7af850;e3bd579be7144ca3bd3e1c034d0aa6d0;418f3229880a43af8f1716d560882ba5;ce8b62c3fb7a44929382a30a52f0fe08;d1b327ce0b604f9596c07519164dec94;91fc03efb09847f8a4b02b58828a3db5;af33940981bf470e9080b32802694375;67d0d0feb7c54bf0bcbfc4268423f64f;28806b7531fd46e98a56d623d539b347;32b9a08856ea4e87b6c8c6f5f419df81;558246ad7ddc4ce599b722d54a71b7a5;f27c61a044814390b07b143010692a2b;d1e2cb6dd03c44e7a1e413128b6327cc;09102185cf8b4211a8213c92e6748b93;12a0b9590ae14f1bac25a031c6431f0e;7b60cf6363a2473d99b77aad3d27e34b;1d9e5c35bda745b3acd7ce7fa953b75f;4d7e29f85bda4ec18d1ec8a42d0bbf4a;8ac838f2a33f4728b43f27073a27ee2d;0620aa33a0e345e1b69558874220cb8f;7be3551974bd4c9cb397e893c6a10a0c;', null, '6', '2018-01-20 18:10:29', null);

-- ----------------------------
-- Table structure for upms_dict
-- ----------------------------
DROP TABLE IF EXISTS `upms_dict`;
CREATE TABLE `upms_dict` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '字典名称',
  `icon` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '字典图标',
  `type` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '字典类型',
  `key` varchar(50) CHARACTER SET utf8mb4 NOT NULL COMMENT '键',
  `value` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '值',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `_type` (`type`),
  KEY `_value` (`value`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of upms_dict
-- ----------------------------
INSERT INTO `upms_dict` VALUES ('13', '件', null, '单位', 'unit', '100001', '2017-11-22 17:53:40');
INSERT INTO `upms_dict` VALUES ('14', '箱', null, '单位', 'unit', '100002', '2017-11-23 08:54:02');
INSERT INTO `upms_dict` VALUES ('15', '瓶', null, '单位', 'unit', '100003', '2017-11-23 08:54:11');
INSERT INTO `upms_dict` VALUES ('16', '罐', null, '单位', 'unit', '100004', '2017-11-23 08:54:29');
INSERT INTO `upms_dict` VALUES ('17', '桶', null, '单位', 'unit', '100005', '2017-11-23 08:56:29');
INSERT INTO `upms_dict` VALUES ('18', '包', null, '单位', 'unit', '100006', '2017-11-23 08:56:35');
INSERT INTO `upms_dict` VALUES ('19', '正常', null, 'customer_audit', 'normal', '100101', '2017-11-27 16:23:50');
INSERT INTO `upms_dict` VALUES ('20', '待审核', null, 'customer_audit', 'audit', '100102', '2017-11-27 16:24:53');
INSERT INTO `upms_dict` VALUES ('21', '拒绝', null, 'customer_audit', 'reject', '100103', '2017-11-27 16:25:14');
INSERT INTO `upms_dict` VALUES ('22', '库存建账', null, 'biz_type', 'init', '100201', '2017-11-28 14:41:33');
INSERT INTO `upms_dict` VALUES ('23', '采购入库', null, 'biz_type', 'instock', '100202', '2017-11-28 14:42:39');
INSERT INTO `upms_dict` VALUES ('24', '采购退货出库', null, 'biz_type', 'p_outstock', '100203', '2017-11-28 14:43:17');
INSERT INTO `upms_dict` VALUES ('25', '销售出库', null, 'biz_type', 'sales_outstock', '100204', '2017-11-28 14:43:44');
INSERT INTO `upms_dict` VALUES ('26', '销售退货入库', null, 'biz_type', 'sales_refund_instock', '100205', '2017-11-28 14:44:45');
INSERT INTO `upms_dict` VALUES ('27', '调拨单', null, 'biz_type', 'transfer_instock', '100206', '2017-11-28 14:45:48');
INSERT INTO `upms_dict` VALUES ('28', '调拨出库', null, 'biz_type', 'transfer_outstock', '100207', '2017-11-28 14:46:12');
INSERT INTO `upms_dict` VALUES ('29', '盘盈入库', null, 'biz_type', 'transfer_plus_instock', '100208', '2017-11-28 14:48:18');
INSERT INTO `upms_dict` VALUES ('30', '盘亏出库', null, 'biz_type', 'transfer_reduce_outstock', '100209', '2017-11-28 14:48:46');
INSERT INTO `upms_dict` VALUES ('31', 'A类', null, 'customer_subtype', 'A', '100301', '2017-11-29 00:13:48');
INSERT INTO `upms_dict` VALUES ('32', 'B类', null, 'customer_subtype', 'B', '100302', '2017-11-29 00:14:10');
INSERT INTO `upms_dict` VALUES ('33', 'C类', null, 'customer_subtype', 'C', '100303', '2017-11-29 00:14:35');
INSERT INTO `upms_dict` VALUES ('34', '普通', null, 'customer_kind', 'normal', '100401', '2017-11-29 00:18:10');
INSERT INTO `upms_dict` VALUES ('35', '销售商', null, 'customer_kind', 'seller', '100402', '2017-11-29 00:18:48');
INSERT INTO `upms_dict` VALUES ('36', '商品销售', null, 'biz_type', 'sales_order', '100210', '2017-12-08 10:31:06');
INSERT INTO `upms_dict` VALUES ('37', '客户拜访', null, 'customer_visit', 'visit', '100501', '2017-12-12 11:52:17');
INSERT INTO `upms_dict` VALUES ('38', '订单消息', null, 'message_type', 'order', '100601', '2017-12-12 14:39:01');
INSERT INTO `upms_dict` VALUES ('39', '客户消息', null, 'message_type', 'customer', '100602', '2017-12-12 14:39:20');
INSERT INTO `upms_dict` VALUES ('40', '客户审核消息', null, 'message_type', 'customer_visit', '100603', '2017-12-12 14:39:38');
INSERT INTO `upms_dict` VALUES ('41', '网点开发', null, 'customer_visit', 'develop', '100502', '2017-12-16 16:12:49');
INSERT INTO `upms_dict` VALUES ('42', '氛围布置', null, 'customer_visit', 'layout', '100503', '2017-12-16 16:13:52');
INSERT INTO `upms_dict` VALUES ('43', '产品陈列', null, 'customer_visit', 'put', '100504', '2017-12-16 16:14:45');
INSERT INTO `upms_dict` VALUES ('44', '客情维护', null, 'customer_visit', 'vindicate', '100505', '2017-12-16 16:15:36');
INSERT INTO `upms_dict` VALUES ('45', '待审核', null, 'order_status', '100701', '0', '2017-12-19 15:41:44');
INSERT INTO `upms_dict` VALUES ('46', '已审核', null, 'order_status', '100702', '1000', '2017-12-19 15:42:42');
INSERT INTO `upms_dict` VALUES ('47', '订单取消', null, 'order_status', '100703', '1001', '2017-12-19 15:43:07');
INSERT INTO `upms_dict` VALUES ('48', '部分出库', null, 'order_status', '2000', '100704', '2017-12-19 15:43:38');
INSERT INTO `upms_dict` VALUES ('49', '部分出库-订单关闭', null, 'order_status', '2001', '100705', '2017-12-19 15:44:01');
INSERT INTO `upms_dict` VALUES ('50', '全部出库', null, 'order_status', '3000', '100706', '2017-12-19 15:45:49');
INSERT INTO `upms_dict` VALUES ('51', '全部出库-订单关闭', null, 'order_status', '3001', '100707', '2017-12-19 15:46:14');
INSERT INTO `upms_dict` VALUES ('52', '100以内', null, 'area_coverage', '100', '0.1', '2017-12-23 14:29:14');
INSERT INTO `upms_dict` VALUES ('53', '500米以内', null, 'area_coverage', '500', '0.5', '2017-12-23 14:29:32');
INSERT INTO `upms_dict` VALUES ('54', '2KM以内', null, 'area_coverage', '2000', '2', '2017-12-23 14:30:15');
INSERT INTO `upms_dict` VALUES ('55', '商品营销', null, 'activity_category', '101001', '101001', '2018-01-17 14:34:26');
INSERT INTO `upms_dict` VALUES ('56', '投入活动', null, 'activity_category', '101002', '101002', '2018-01-17 14:34:45');
INSERT INTO `upms_dict` VALUES ('57', '公关赞助', null, 'activity_invest', '101101', '101101', '2018-01-17 14:35:41');
INSERT INTO `upms_dict` VALUES ('59', '消费培育', null, 'activity_invest', '101102', '101102', '2018-01-17 14:36:33');
INSERT INTO `upms_dict` VALUES ('60', '1个月', null, 'activity_time_interval', '100801', '100801', '2018-01-17 15:38:06');
INSERT INTO `upms_dict` VALUES ('61', '2个月', null, 'activity_time_interval', '100802', '100802', '2018-01-17 15:38:36');
INSERT INTO `upms_dict` VALUES ('62', '3个月', null, 'activity_time_interval', '100803', '100803', '2018-01-17 15:38:52');
INSERT INTO `upms_dict` VALUES ('63', '4个月', null, 'activity_time_interval', '100804', '100804', '2018-01-17 15:39:15');
INSERT INTO `upms_dict` VALUES ('64', '5个月', null, 'activity_time_interval', '100805', '100805', '2018-01-17 15:39:33');
INSERT INTO `upms_dict` VALUES ('65', '6个月', null, 'activity_time_interval', '100806', '100806', '2018-01-17 15:39:44');
INSERT INTO `upms_dict` VALUES ('66', '7个月', null, 'activity_time_interval', '100807', '100807', '2018-01-17 15:40:02');
INSERT INTO `upms_dict` VALUES ('67', '8个月', null, 'activity_time_interval', '100808', '100808', '2018-01-17 15:40:16');
INSERT INTO `upms_dict` VALUES ('68', '9个月', null, 'activity_time_interval', '100809', '100809', '2018-01-17 15:40:31');
INSERT INTO `upms_dict` VALUES ('69', '10个月', null, 'activity_time_interval', '100810', '100810', '2018-01-17 15:40:42');
INSERT INTO `upms_dict` VALUES ('70', '11个月', null, 'activity_time_interval', '100811', '100811', '2018-01-17 15:41:02');
INSERT INTO `upms_dict` VALUES ('71', '12个月', null, 'activity_time_interval', '100812', '100812', '2018-01-17 15:41:47');
INSERT INTO `upms_dict` VALUES ('75', '活动消息', null, 'message_type', 'activity', '100604', '2018-01-24 10:26:00');
INSERT INTO `upms_dict` VALUES ('76', '周计划', null, 'plan_type', 'week', '101201', '2018-01-24 15:30:52');
INSERT INTO `upms_dict` VALUES ('77', '月计划', null, 'plan_type', 'month', '101202', '2018-01-24 15:31:36');
INSERT INTO `upms_dict` VALUES ('78', '年计划', null, 'plan_type', 'year', '101203', '2018-01-24 15:32:25');
INSERT INTO `upms_dict` VALUES ('79', '终端广告', null, 'activity_invest', '101103', '101103', '2018-01-27 11:38:20');
INSERT INTO `upms_dict` VALUES ('80', '终端陈列', null, 'activity_invest', '101104', '101104', '2018-01-27 11:38:48');
INSERT INTO `upms_dict` VALUES ('81', '终端客情', null, 'activity_invest', '101105', '101105', '2018-01-27 11:39:07');
INSERT INTO `upms_dict` VALUES ('84', '待审核', null, 'refund_status', '100800', '0', '2018-02-02 14:14:00');
INSERT INTO `upms_dict` VALUES ('85', '已审核', null, 'refund_status', '100801', '1000', '2018-02-02 14:14:31');
INSERT INTO `upms_dict` VALUES ('86', '已撤销', null, 'refund_status', '100802', '1001', '2018-02-02 14:15:28');
INSERT INTO `upms_dict` VALUES ('87', '已拒绝', null, 'refund_status', '100803', '1002', '2018-02-02 14:15:46');
INSERT INTO `upms_dict` VALUES ('88', '部分入库', null, 'refund_status', '100804', '2000', '2018-02-02 14:16:05');
INSERT INTO `upms_dict` VALUES ('89', '全部入库', null, 'refund_status', '100805', '3000', '2018-02-02 14:16:50');
INSERT INTO `upms_dict` VALUES ('90', '商超赠品', null, 'activity_invest', '101106', '101106', '2018-02-28 11:17:42');
INSERT INTO `upms_dict` VALUES ('91', '进场费', null, 'activity_invest', '101107', '101107', '2018-02-28 11:20:50');
INSERT INTO `upms_dict` VALUES ('92', '赞助用酒', null, 'feeType_name_PR', '102001', '102001', '2018-02-28 16:13:01');
INSERT INTO `upms_dict` VALUES ('93', '活动场租', null, 'feeType_name_PR', '102002', '102002', '2018-02-28 16:13:12');
INSERT INTO `upms_dict` VALUES ('94', '消费联谊', null, 'feeType_name_PR', '102003', '102003', '2018-02-28 16:14:41');
INSERT INTO `upms_dict` VALUES ('95', '品鉴会', null, 'feeType_name_PR', '102004', '102004', '2018-02-28 16:16:00');
INSERT INTO `upms_dict` VALUES ('96', '临时市场代表薪资', null, 'feeType_name_PR', '102005', '102005', '2018-02-28 16:16:12');
INSERT INTO `upms_dict` VALUES ('97', '其他', null, 'feeType_name_PR', '102006', '102006', '2018-02-28 16:17:41');
INSERT INTO `upms_dict` VALUES ('98', '体验用酒', null, 'feeType_name_raise', '102007', '102007', '2018-02-28 16:17:29');
INSERT INTO `upms_dict` VALUES ('99', '意见领袖', null, 'feeType_name_raise', '102008', '102008', '2018-02-28 16:17:43');
INSERT INTO `upms_dict` VALUES ('100', '旗舰店产品支持', null, 'feeType_name_raise', '102009', '102009', '2018-02-28 16:17:55');
INSERT INTO `upms_dict` VALUES ('101', '宴席推广（仅限白酒）', null, 'feeType_name_raise', '102010', '102010', '2018-02-28 16:18:10');
INSERT INTO `upms_dict` VALUES ('102', '临期产品消化', null, 'feeType_name_raise', '102011', '102011', '2018-02-28 16:18:21');
INSERT INTO `upms_dict` VALUES ('103', '品鉴会', null, 'feeType_name_raise', '102012', '102012', '2018-02-28 16:18:32');
INSERT INTO `upms_dict` VALUES ('104', '市场研究', null, 'feeType_name_raise', '102013', '102013', '2018-02-28 16:18:45');
INSERT INTO `upms_dict` VALUES ('105', '单页（张）', null, 'feeType_name_AD', '102014', '102014', '2018-02-28 16:19:30');
INSERT INTO `upms_dict` VALUES ('106', 'PVC塑料', null, 'feeType_name_AD', '102015', '102015', '2018-02-28 16:19:38');
INSERT INTO `upms_dict` VALUES ('107', '亚克力板', null, 'feeType_name_AD', '102016', '102016', '2018-02-28 16:19:48');
INSERT INTO `upms_dict` VALUES ('108', '不干胶', null, 'feeType_name_AD', '102017', '102017', '2018-02-28 16:19:57');
INSERT INTO `upms_dict` VALUES ('109', '背胶', null, 'feeType_name_AD', '102018', '102018', '2018-02-28 16:20:11');
INSERT INTO `upms_dict` VALUES ('110', '喷绘布', null, 'feeType_name_AD', '102019', '102019', '2018-02-28 16:20:20');
INSERT INTO `upms_dict` VALUES ('111', '写真画面', null, 'feeType_name_AD', '102020', '102020', '2018-02-28 16:20:33');
INSERT INTO `upms_dict` VALUES ('112', '旗舰店装修', null, 'feeType_name_AD', '102021', '102021', '2018-02-28 16:20:40');
INSERT INTO `upms_dict` VALUES ('113', '店中店装修', null, 'feeType_name_AD', '102022', '102022', '2018-02-28 16:20:48');
INSERT INTO `upms_dict` VALUES ('114', '展架画面(平米)', null, 'feeType_name_AD', '102023', '102023', '2018-02-28 16:21:06');
INSERT INTO `upms_dict` VALUES ('115', '条幅(平米)', null, 'feeType_name_AD', '102024', '102024', '2018-02-28 16:22:29');
INSERT INTO `upms_dict` VALUES ('116', '菜单(A4/张)', null, 'feeType_name_AD', '102025', '102025', '2018-02-28 16:22:38');
INSERT INTO `upms_dict` VALUES ('117', '经销商车身', null, 'feeType_name_AD', '102026', '102026', '2018-02-28 16:22:46');
INSERT INTO `upms_dict` VALUES ('118', '店招', null, 'feeType_name_AD', '102027', '102027', '2018-02-28 16:22:59');
INSERT INTO `upms_dict` VALUES ('119', '灯箱', null, 'feeType_name_AD', '102028', '102028', '2018-02-28 16:23:15');
INSERT INTO `upms_dict` VALUES ('120', '看板（平米）', null, 'feeType_name_AD', '102029', '102029', '2018-02-28 16:23:36');
INSERT INTO `upms_dict` VALUES ('121', '橱窗贴（平米）', null, 'feeType_name_AD', '102030', '102030', '2018-02-28 16:23:48');
INSERT INTO `upms_dict` VALUES ('122', '其他', null, 'feeType_name_AD', '102031', '102031', '2018-02-28 16:23:56');
INSERT INTO `upms_dict` VALUES ('123', '终端发布费', null, 'feeType_name_display', '102032', '102032', '2018-02-28 16:24:50');
INSERT INTO `upms_dict` VALUES ('124', '店中店发布费', null, 'feeType_name_display', '102033', '102033', '2018-02-28 16:25:02');
INSERT INTO `upms_dict` VALUES ('125', '零售陈列', null, 'feeType_name_display', '102034', '102034', '2018-02-28 16:25:16');
INSERT INTO `upms_dict` VALUES ('126', '卖场陈列', null, 'feeType_name_display', '102035', '102035', '2018-02-28 16:25:25');
INSERT INTO `upms_dict` VALUES ('127', '餐饮陈列', null, 'feeType_name_display', '102036', '102036', '2018-02-28 16:25:39');
INSERT INTO `upms_dict` VALUES ('128', '快讯费(DM)', null, 'feeType_name_display', '102037', '102037', '2018-02-28 16:25:47');
INSERT INTO `upms_dict` VALUES ('129', '陈列客情', null, 'feeType_name_display', '102038', '102038', '2018-02-28 16:25:56');
INSERT INTO `upms_dict` VALUES ('131', '客情费用', null, 'feeType_name_SA', '102039', '102039', '2018-02-28 16:28:54');
INSERT INTO `upms_dict` VALUES ('132', '进场费', null, 'feeType_name_SA', '102040', '102040', '2018-02-28 16:29:11');
INSERT INTO `upms_dict` VALUES ('133', '条码费', null, 'feeType_name_SA', '102041', '102041', '2018-02-28 16:29:31');
INSERT INTO `upms_dict` VALUES ('135', '商超赠品', null, 'feeType_name_gift', '102042', '102042', '2018-02-28 16:30:59');
INSERT INTO `upms_dict` VALUES ('136', '团购费用', null, 'feeType_name_gift', '102043', '102043', '2018-02-28 16:31:09');
INSERT INTO `upms_dict` VALUES ('137', '劲酒中高端产品销售回馈', null, 'feeType_name_gift', '102044', '102044', '2018-02-28 16:31:24');
INSERT INTO `upms_dict` VALUES ('138', '促销管理', null, 'feeType_name_gift', '102045', '102045', '2018-02-28 16:31:41');
INSERT INTO `upms_dict` VALUES ('139', '端头', null, 'display_sell', '103001', '103001', '2018-02-28 18:40:20');
INSERT INTO `upms_dict` VALUES ('140', '地堆', null, 'display_sell', '103002', '103002', '2018-02-28 18:40:35');
INSERT INTO `upms_dict` VALUES ('141', '专架', null, 'display_sell', '103003', '103003', '2018-02-28 18:40:44');
INSERT INTO `upms_dict` VALUES ('142', '整组货架', null, 'display_sell', '103004', '103004', '2018-02-28 18:40:52');
INSERT INTO `upms_dict` VALUES ('143', '其他', null, 'display_sell', '103005', '103005', '2018-02-28 18:41:02');
INSERT INTO `upms_dict` VALUES ('144', '店中店发布费', null, 'display_shop', '103006', '103006', '2018-02-28 18:41:36');
INSERT INTO `upms_dict` VALUES ('145', '快讯费(DM)', null, 'display_dm', '103007', '103007', '2018-02-28 18:43:08');
INSERT INTO `upms_dict` VALUES ('146', '终端发布费', null, 'display_publish', '103008', '103008', '2018-02-28 18:43:47');
INSERT INTO `upms_dict` VALUES ('147', '陈列客情', null, 'display_CER', '103009', '103009', '2018-02-28 18:44:18');
INSERT INTO `upms_dict` VALUES ('148', '零售陈列', null, 'display_retail', '103010', '103010', '2018-02-28 18:45:12');
INSERT INTO `upms_dict` VALUES ('149', '摆台', null, 'display_catering', '103011', '103011', '2018-02-28 18:46:45');
INSERT INTO `upms_dict` VALUES ('150', '吧台', null, 'display_catering', '103012', '103012', '2018-02-28 18:46:55');
INSERT INTO `upms_dict` VALUES ('151', '冰柜', null, 'display_catering', '103013', '103013', '2018-02-28 18:47:06');
INSERT INTO `upms_dict` VALUES ('152', '堆箱', null, 'display_catering', '103014', '103014', '2018-02-28 18:47:14');
INSERT INTO `upms_dict` VALUES ('153', '其他', null, 'display_catering', '103015', '103015', '2018-02-28 18:47:22');
INSERT INTO `upms_dict` VALUES ('154', '经销商', null, 'channel_define', '1', '1', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('155', '销售商', null, 'channel_define', '2', '2', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('156', '二批商', null, 'channel_define', '3', '3', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('157', '三批商', null, 'channel_define', '4', '4', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('158', '卖场N类', null, 'channel_define', '5', '5', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('159', '卖场R类', null, 'channel_define', '6', '6', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('160', '卖场C类', null, 'channel_define', '7', '7', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('161', '大标超', null, 'channel_define', '8', '8', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('162', '中标超', null, 'channel_define', '9', '9', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('163', '小标超', null, 'channel_define', '10', '10', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('164', '便利N类', null, 'channel_define', '11', '11', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('165', '便利R类', null, 'channel_define', '12', '12', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('166', '便利C类', null, 'channel_define', '13', '13', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('167', '零售B类', null, 'channel_define', '14', '14', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('168', '零售C类', null, 'channel_define', '15', '15', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('169', '零售D类', null, 'channel_define', '16', '16', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('170', '餐饮A类', null, 'channel_define', '17', '17', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('171', '餐饮B类', null, 'channel_define', '18', '18', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('172', '餐饮C类', null, 'channel_define', '19', '19', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('173', '餐饮D类', null, 'channel_define', '20', '20', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('174', '特约销售商', null, 'channel_define', '21', '21', '2018-03-01 14:24:02');
INSERT INTO `upms_dict` VALUES ('175', '餐饮KA类', null, 'channel_define', '22', '22', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('176', '卖场T类', null, 'channel_define', '23', '23', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('177', '医药', null, 'channel_define', '28', '28', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('178', '酒店/宾馆', null, 'channel_define', '29', '29', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('179', '网吧', null, 'channel_define', '30', '30', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('180', '加油站/服务区', null, 'channel_define', '31', '31', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('181', '酒吧/夜场', null, 'channel_define', '32', '32', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('182', 'KTV/影院', null, 'channel_define', '33', '33', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('183', '企业机关', null, 'channel_define', '34', '34', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('184', '单位食堂', null, 'channel_define', '35', '35', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('185', '运动场馆', null, 'channel_define', '36', '36', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('186', '非酒类终端', null, 'channel_define', '37', '37', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('187', '休闲农庄', null, 'channel_define', '38', '38', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('188', '旅游景区餐饮', null, 'channel_define', '39', '39', '2018-03-01 14:24:03');
INSERT INTO `upms_dict` VALUES ('189', '无人售货', null, 'channel_define', '40', '40', '2018-03-01 14:24:03');

-- ----------------------------
-- Table structure for upms_group
-- ----------------------------
DROP TABLE IF EXISTS `upms_group`;
CREATE TABLE `upms_group` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `group_name` varchar(30) NOT NULL COMMENT '用户组名称',
  `group_code` varchar(22) NOT NULL COMMENT '用户组编号',
  `order_list` int(11) DEFAULT NULL COMMENT '排序',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '对应cc_department表，机构ID',
  `data_area` varchar(200) DEFAULT NULL COMMENT '数据域',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_group_code` (`group_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户组';

-- ----------------------------
-- Records of upms_group
-- ----------------------------
INSERT INTO `upms_group` VALUES ('13caca754b544b03af6d6c14c9fe5885', '经销商管理员', 'role02', '2', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('29950281f6b24b2a80de25249e5e53d8', '直营商管理员', 'role03', '3', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('3841892e21eb40fd888bc68a18105c9d', '经理', 'role05', '5', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('3bb78d9a66284e7096449f5dbb83b9fe', '主管', 'role06', '6', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('3c429741fd0f4e2e8f94ce0cc18b61e0', '综合库管', 'role08', '8', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('3a382f3f8a2a45fa8e545b8e51e93efb', '业务员', 'role10', '10', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('3d161c0f39e84f6996e92bdb42034b2a', '直营总监', 'role11', '11', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:09', null);
INSERT INTO `upms_group` VALUES ('029544125b8446759c42066626add7b1', '直营经理', 'role12', '12', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);

INSERT INTO `upms_group` VALUES ('3bbe419586074a87b7d74083ad9925e7', '直营财务主管', 'role14', '14', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('38727f17dc624bcebb5fa9506a08ce1f', '商超财务主管', 'role17', '17', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('00016234b8f64701bbfa138b5efc946f', '直营主管', 'role13', '13', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('0036d0a361b64f2badb0797db98d28d2', '账务人员', 'role20', '20', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);

INSERT INTO `upms_group` VALUES ('00a4875458fd4f58aa74f313093afa5d', '直营商管理员', 'role03', '3', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('0171a01201254acdb9a44292b67ed1f2', '直营财务主管', 'role14', '14', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('029544125b8446759c42066626add7b1', '直营经理', 'role12', '12', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('043e9dfd562241b28013ae69ab75a233', '综合库管', 'role08', '8', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('04a0f1762b4042bdaf356c1c325d08b8', '业务员', 'role10', '10', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('059e931bff174679a722c7573fdc6dc3', '商超经理', 'role15', '15', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('067916a4685a4ff6b59ec36387a61741', '经销商管理员', 'role02', '2', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:28', null);
INSERT INTO `upms_group` VALUES ('07ce8219093d417ea22567bc3a77b540', '直营财务主管', 'role14', '14', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('087631b275fe49848f5e69458b3ba325', '库管', 'role09', '9', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:00', null);
INSERT INTO `upms_group` VALUES ('08bd2d1485134eccbd4fc72d76ec9547', '财务主管', 'role07', '7', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('08df482e17144da9b15286084b32e667', '商超经理', 'role15', '15', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('0d11843f3cc54241875bd29d4d84ab5c', '综合库管', 'role08', '8', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:28', null);
INSERT INTO `upms_group` VALUES ('0d6e2476941e4d95802af683beb725a7', '直营主管', 'role13', '13', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('0e72d8e0e8d146cc8004a66687f43b97', '业务员', 'role10', '10', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('0f207cda9e4f4b9e8c3e83f4224cc7dc', '商超经理', 'role15', '15', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('0f468224928643d08f559d1b71d0ccee', '账务人员', 'role20', '20', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('10998c1197dd4fba8fe3979b4b81802f', '直营总监', 'role11', '11', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('11399a85d1244640a3207cdb53f99868', '直营经理', 'role12', '12', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('12d12980f66e4f2e9ecac7eb1f71ec33', '餐饮财务主管', 'role19', '19', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('12fa14a30c0c41a2b605a85a65d16095', '账务人员', 'role20', '20', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('13caca754b544b03af6d6c14c9fe5885', '经销商管理员', 'role02', '2', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('13f935f87d2e4508b3191045cc7ea394', '经理', 'role05', '5', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:33', null);
INSERT INTO `upms_group` VALUES ('1534bd84f5eb49e283632ca048171120', '商超经理', 'role15', '15', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('16bec8ac8cbf492998c3cff1de5d4001', '直营经理', 'role12', '12', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('16d4606a4b164400b5f1d991339c8b5b', '主管', 'role06', '6', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('174aadafcc6e486c8ac8ad50a07bb70f', '经销商管理员', 'role02', '2', null, '0', '001', '2017-11-01 09:44:13', '2017-11-29 15:42:55');
INSERT INTO `upms_group` VALUES ('176544ac2cd145bf9ac0a571ee51e129', '直营主管', 'role13', '13', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('176bafef94184f1181d8c94fd017b07d', '餐饮主管', 'role18', '18', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('1871a17a73fe49e29f93a30b565a91d6', '商超财务主管', 'role17', '17', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('188c6b265f8244ab93cff9d4691844bb', '商超主管', 'role16', '16', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('19f17b22b9c845b190cd06f25d61db41', '餐饮主管', 'role18', '18', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('1a0412c5f7784843a09cecdd6560ffcd', '财务主管', 'role07', '7', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('1b127a103b4f4575b63e1b16a91138e2', '直营经理', 'role12', '12', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('1bc0706508b2431a8b38594a1317ff6f', '直营财务主管', 'role14', '14', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('1bc45a4b326542898e7c9233d27c2e7d', '直营商管理员', 'role03', '3', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('1c6ec1d8fc2349e699a74bd509f06617', '商超经理', 'role15', '15', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('1cb6c74a51a54faf9a911ee814ec98c7', '账务人员', 'role20', '20', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('1e9e888c206a4669859dcb7d1a0984c1', '直营财务主管', 'role14', '14', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('1f2a367be69940ab8c498de4f4de52be', '直营总监', 'role11', '11', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:28', null);
INSERT INTO `upms_group` VALUES ('1fa37e9b046c47a0b98204a2e44e6790', '直营经理', 'role12', '12', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:12', null);
INSERT INTO `upms_group` VALUES ('20cabc94e2c844cb8790ae317938be46', '经理', 'role05', '5', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('21877df732514e459462219301758939', '直营财务主管', 'role14', '14', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('21c7821e69e548de90112ecd72def5a4', '商超经理', 'role15', '15', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('21d46de7870d4582bd121071d23f5d76', '餐饮财务主管', 'role19', '19', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('2304220292884a48a49402f3f1439214', '财务主管', 'role07', '7', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('25afa3d75c274fcbb80694ba25ff7352', '直营商管理员', 'role03', '3', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('2743755420c648858f644c1e165d440c', '账务人员', 'role20', '20', null, '0', '001', '2017-12-14 16:37:30', '2017-12-14 16:37:30');
INSERT INTO `upms_group` VALUES ('28c17112c838445da98fe9f3eb3a3795', '直营财务主管', 'role14', '14', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('28ef8dfd9bcd486590f61b35901215d6', '直营商管理员', 'role03', '3', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('29950281f6b24b2a80de25249e5e53d8', '直营商管理员', 'role03', '3', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('2a26f13b75c34b2fb64d5cef896dbc36', '直营经理', 'role12', '12', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('2a8a17f801f2476cb45c6b70a0344ffb', '商超财务主管', 'role17', '17', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('2b0c023b83c54a7c86cc02e8a377afb4', '直营总监', 'role11', '11', null, '0', '001', '2017-11-29 15:46:00', null);
INSERT INTO `upms_group` VALUES ('2bf60354d8f24d1fa5719a3f10289a20', '经理', 'role05', '5', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('2c0dfccc1e444956998881492d8369a6', '经销商老总', 'role04', '4', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('32bf60cbff5c468ab9528dbefe1f105a', '库管', 'role09', '9', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('332ed4460d0c4d2bb0cf08c88cbf106a', '账务人员', 'role20', '20', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('33605916e8dd46d2a0f5d2bc77e35ee4', '综合库管', 'role08', '8', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('33e7a97ee3574cc784929b4d984a49db', '商超经理', 'role15', '15', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('34219308ec8b4dcead81a51459d291f9', '商超经理', 'role15', '15', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('34a8e54532414027a7a77e447bb82deb', '业务员', 'role10', '10', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('3568e49c72f74afb833185dae9df23e7', '餐饮财务主管', 'role19', '19', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('35aa649e908346128306dbbc6c2d107f', '商超财务主管', 'role17', '17', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('35fe4b3dc2d040af9b4210ac166fdc46', '直营经理', 'role12', '12', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('3621ff91a1c0461c9bdbdf3a7a02e6c6', '主管', 'role06', '6', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('3712661859e640c998e5d06c6689a869', '库管', 'role09', '9', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('37a99e9c39fd4f658a5b04face80b525', '商超主管', 'role16', '16', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:00', null);
INSERT INTO `upms_group` VALUES ('380038bd89bd4400812aeae5bfb6a22f', '经销商老总', 'role04', '4', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('3f8013978e9a4d029e1bae3ebdcc9ee0', '综合库管', 'role08', '8', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:28', null);
INSERT INTO `upms_group` VALUES ('40195d0c73194ad89735088295d72104', '商超经理', 'role15', '15', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('40aa8c0cbe354e9da1e9eda0b25aaa86', '业务员', 'role10', '10', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('40da689eb7c148f39981c26e78a9db80', '综合库管', 'role08', '8', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('4128160cc28e4193a7c85750d772bc1a', '财务主管', 'role07', '7', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('41504a68f8d24b3493d5b7d54e2e59f3', '经销商老总', 'role04', '4', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('41ba2471f9294985862e71cddabcea92', '主管', 'role06', '6', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('420054ade4a04759a1214b49287b9a0d', '商超主管', 'role16', '16', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('42a8a3bd3fca41cf99d75886f038caed', '经理', 'role05', '5', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:09', null);
INSERT INTO `upms_group` VALUES ('43aa9cb7505f49c2bbe1e56f2ea5fc2e', '商超财务主管', 'role17', '17', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('448b94a6d3da45079e929278f6e5f966', '餐饮财务主管', 'role19', '19', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('44c0a726dcf14e08a59bd03d1df945c8', '直营主管', 'role13', '13', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('453d942289b143be8db863a0aeb01d78', '主管', 'role06', '6', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('455e0d47ea024238a7363ec2a1b4a8a7', '商超财务主管', 'role17', '17', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('45659219e86545aaaa9d3cdb4c73faa6', '商超财务主管', 'role17', '17', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('4594ad3c291e4402b02a368f6c9d2463', '直营商管理员', 'role03', '3', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('45af8ccaf384491ca07c1ad2ad6256a7', '商超经理', 'role15', '15', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('45ea77adf5c146fb9d81e944a80901b7', '综合库管', 'role08', '8', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('477bf3af9f2349c888d96479ac6e5a6d', '商超经理', 'role15', '15', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('4854ea7ea4c644e2a638fad6d2e84d7c', '综合库管', 'role08', '8', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('491dcc4b81244de7a8d1983665df3687', '经理', 'role05', '5', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('4a9cca776e5645aabd49f0279720ecb2', '餐饮主管', 'role18', '18', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('4b28409e90fa4a27bb13aec841894431', '餐饮主管', 'role18', '18', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('4c17ccb4442442e59c8af6e1cf17176b', '财务主管', 'role07', '7', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('4c6f0ec708c0431eade1040fa5228bda', '库管', 'role09', '9', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('4cc30e1b2ae646b8800c4286ada45fba', '餐饮财务主管', 'role19', '19', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('4eaa7d5ae101492f9fcfe5056c36d0d6', '商超主管', 'role16', '16', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('50b85cb068194ac287c9cc0c7f990cae', '综合库管', 'role08', '8', null, '0', '001', '2017-11-29 15:45:05', null);
INSERT INTO `upms_group` VALUES ('51ba15a5cb984bbd9615a474c99fc470', '综合库管', 'role08', '8', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('5279285c406a4a8ba489f50dbabd7d92', '餐饮财务主管', 'role19', '19', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('528b9ce6235b47e0b98741c0f4da4146', '经销商管理员', 'role02', '2', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:12', null);
INSERT INTO `upms_group` VALUES ('5332689530f14d9480a5f94ea8373c25', '直营商管理员', 'role03', '3', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('538814f2894a4555b02d72d70e9ecafe', '经销商管理员', 'role02', '2', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('53dea76048f64cc89714844c1420e61c', '直营主管', 'role13', '13', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('547af7394d894617a1400dfd7944c2b3', '财务主管', 'role07', '7', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('54988fa031e2477fa1cf9a4033c74059', '经理', 'role05', '5', null, '0', '001', '2017-11-24 14:42:35', '2017-12-14 17:40:05');
INSERT INTO `upms_group` VALUES ('56078118a2db43d0bc3df0105cfacd41', '直营主管', 'role13', '13', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('56637f2fc344497eaedb13eb92f4ec21', '库管', 'role09', '9', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:10', null);
INSERT INTO `upms_group` VALUES ('5685e116d7b94e25b03f8e83ace1d6d3', '商超财务主管', 'role17', '17', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('56d0c858f9ad443b818ff38c5853054a', '商超主管', 'role16', '16', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('56dc5d2ceecb4ecf814b2b021fc385d1', '财务主管', 'role07', '7', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('5757f5489d414bc59f07998a76f0f3df', '经销商老总', 'role04', '4', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('5789929be2ed432ca7d00e18595b84bf', '直营商管理员', 'role03', '3', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('57b0004c8de740d5acec827972a9ddab', '商超主管', 'role16', '16', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('580d1eb3d7464df4a952005f4140b73e', '经销商老总', 'role04', '4', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('58db466861994e45b799fed42e54eccb', '餐饮主管', 'role18', '18', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('5b8b52ec196040939a73da5eed42cec6', '直营总监', 'role11', '11', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:28', null);
INSERT INTO `upms_group` VALUES ('5bd14054fa824da1a1bd37e60a777453', '餐饮财务主管', 'role19', '19', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('5bd789c6f79f42b8afa18134e568aafe', '业务员', 'role10', '10', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('5c5c098a8cf74f708aba7c0e3ccf2b7f', '库管', 'role09', '9', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('5c99507b66f14c5182cd089d56efc203', '直营经理', 'role12', '12', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('5db569365820445e85a56fb8b3ce0d78', '商超财务主管', 'role17', '17', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('5e962a7d44b14afea6566ff5947d99d3', '商超主管', 'role16', '16', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('5f9b00f0cdac4b4681aaaa903778d90c', '账务人员', 'role20', '20', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('5fa372f1f85c4b18a27923b7810ac6c4', '商超经理', 'role15', '15', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('5ff92d6643ab46a5b90ad7c2a0fe52d3', '商超经理', 'role15', '15', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('604f41e7f38c40f0912d106860f0d37e', '直营经理', 'role12', '12', null, '0', '001', '2017-11-29 15:46:19', null);
INSERT INTO `upms_group` VALUES ('608bdb9fe5014575a324aa1ab51c369e', '经理', 'role05', '5', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('60e78710c1bf459baf25d01f8f1e6ada', '直营主管', 'role13', '13', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('60faacc4193b49f0ab1b8b783e2e705d', '直营商管理员', 'role03', '3', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('60fb3ecb806641679515680c0fa2c152', '财务主管', 'role07', '7', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('611b084c7ad74158980be8bc3c6109e7', '直营总监', 'role11', '11', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('613417c2fecc4412ad8e6e0c5d6f9b4b', '主管', 'role06', '6', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('6148101b0d664c5d86dcb4f3d7b1c66a', '餐饮主管', 'role18', '18', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('6169ecf195b74bf5b9d542e8cab7500d', '餐饮主管', 'role18', '18', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('6170b04294ad47ba9efdc80a7ae2e677', '商超财务主管', 'role17', '17', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('61d622523816449f83bd5714edd3f1e8', '综合库管', 'role08', '8', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:09', null);
INSERT INTO `upms_group` VALUES ('63d121f339fe416abe31e861f78878ff', '经理', 'role05', '5', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('644627df7a9b48f4827a6cb5945b92ff', '直营主管', 'role13', '13', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('6450270fd0744705817734a851d1b8d0', '直营主管', 'role13', '13', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('65d821e6f69e4ae29e53dea47980ea09', '经理', 'role05', '5', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('661765c929ff4bff995c1e5c80105c67', '经理', 'role05', '5', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('6695d64659e74e04943fd50b04ca7e9b', '直营商管理员', 'role03', '3', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:12', null);
INSERT INTO `upms_group` VALUES ('66dfe408a273455cb2739469b8b0e47b', '商超主管', 'role16', '16', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('6717c03b400042f7aae07cc480641b27', '商超财务主管', 'role17', '17', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('6848750a7c9d4ac3a91f3311a7b0e685', '经销商管理员', 'role02', '2', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('684df90435e74d729d26835809b1e7e3', '经销商管理员', 'role02', '2', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('69145fb26cfc458f94a78327eee98a3b', '经理', 'role05', '5', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('69ee7f7afecc4e57800db5602063da61', '餐饮主管', 'role18', '18', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('6b5a7c5338ed46838bb000197d0af99c', '餐饮财务主管', 'role19', '19', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('6be037d053a64eb6943e0bea8b95311a', '库管', 'role09', '9', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('6bf6ded418464d25b1bff7a30bb42ce8', '账务人员', 'role20', '20', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('6d1a4c18d4d34a369cdf9ed67c474046', '业务员', 'role10', '10', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('6d8766af168c4abb94fc2dfa1f1d1714', '直营主管', 'role13', '13', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('6e0ac32c0862457684a587a334b19cd2', '综合库管', 'role08', '8', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('6ed4d9fa68834886a4e1249942126c0a', '直营主管', 'role13', '13', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('6f08cc5795104423abd48c3613c012b5', '直营主管', 'role13', '13', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('7097a82721e34daca80cdae842dac86c', '账务人员', 'role20', '20', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('720d425488034519a066947aabf14c36', '财务主管', 'role07', '7', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('7294fc180670460aa8f7ecfb6bbe9357', '主管', 'role06', '6', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('7322a41f2f4f494c996779a8c9640c45', '商超财务主管', 'role17', '17', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('7360299ea7e443dc9379e0fbcf00423f', '餐饮主管', 'role18', '18', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('73c7a36e740645a28f36b742943e383b', '财务主管', 'role07', '7', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('74c0245c1e214258910a36095016648a', '业务员', 'role10', '10', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('75a16554e88140928a7163e908041854', '直营主管', 'role13', '13', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('78129c2e575044a0887ac5d9a29cd6b8', '直营财务主管', 'role14', '14', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('781a659c25974874bdb685f2451019f2', '经理', 'role05', '5', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('78fb80b776e84f098228c4afe4b24c4c', '经销商老总', 'role04', '4', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('791cc9c0a2a24b0c951ccc2ee2572ac0', '财务主管', 'role07', '7', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('791e2dffc6e04a5888cdc4a288e0dfc6', '直营财务主管', 'role14', '14', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('79ca6c9ed23d4290bdf8993f669cd304', '综合库管', 'role08', '8', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('7a4b137203da48448e448fb4e3a98665', '财务主管', 'role07', '7', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('7b00f195309c4ea294df6192ebc1dcc4', '雪冰测试账务组', 'data_cxb', '21', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-20 10:43:49', '2017-12-26 18:31:32');
INSERT INTO `upms_group` VALUES ('7bb03a71ddca44f6bb2e2e13ab6330fe', '直营总监', 'role11', '11', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('7bce1d41985643b59b28b8923ff984e1', '餐饮财务主管', 'role19', '19', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('7bda181707584ca7a3754b6000966343', '经理', 'role05', '5', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('7d0c18631c754cf2900b34ea112019b4', '直营总监', 'role11', '11', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:33', null);
INSERT INTO `upms_group` VALUES ('7e880600fa184735bcd3a1eaade07d94', '库管', 'role09', '9', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('7f047e4dd9474f15b523571670a45ed8', '经理', 'role05', '5', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('7f0ff9aada6649c08eed10679503a7a4', '商超主管', 'role16', '16', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('7f15e660b1df45eb8afedad5b7db8af9', '直营经理', 'role12', '12', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('7f903564840f4122a345e9d83c7702f0', '直营商管理员', 'role03', '3', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('7faf49dfdc3144f2ae44a233c83f1a1c', '经理', 'role05', '5', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('7fec7db175fe46e98f41457e08c196bb', '账务人员', 'role20', '20', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('802ca30582b94ba69e57aa97bb3da906', '直营财务主管', 'role14', '14', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('806a7bc1372b4bf0a14a88625da8fd03', '库管', 'role09', '9', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('82a8829384bb47faa54d920ac746660a', '直营经理', 'role12', '12', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('84d834cdcda04903be84b6bad6b7c8b7', '餐饮主管', 'role18', '18', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('85cf93ff36be43cab52cda76438a4b51', '账务人员', 'role20', '20', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('8720a61865ba45bb9560426672ed7cb7', '直营总监', 'role11', '11', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('876d010ccc4643739591dd259f6d46c1', '业务员', 'role10', '10', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('88d1c848efea462d87918259fbe46077', '餐饮主管', 'role18', '18', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('88d6f7c0fa4b480f95e327571c75fc34', '直营主管', 'role13', '13', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('8927608bf0914d25bdc19992c4d9bac3', '经理', 'role05', '5', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('893ffb51e0184b14895f9e50a745e708', '经理', 'role05', '5', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('894e6bbea5244e4bb92ee49835b65c71', '餐饮主管', 'role18', '18', null, '0', '001', '2017-11-29 15:48:57', null);
INSERT INTO `upms_group` VALUES ('89b8a6d158ec4dbaa43dc6b800210869', '商超经理', 'role15', '15', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('89d4e2a6b767421eb5acbd001ebee98c', '商超经理', 'role15', '15', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('89fa76cfa61f43a4adc68e88e7519496', '经销商老总', 'role04', '4', null, '0', '001', '2017-12-13 09:53:34', '2017-12-13 09:53:34');
INSERT INTO `upms_group` VALUES ('8a0cf422116940a3a6b431de6045e423', '账务人员', 'role20', '20', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('8a871f42a5ce4be8b6e3b97763f1d0be', '业务员', 'role10', '10', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('8b7ab43e7b644d2caddcb03a6006419c', '业务员', 'role10', '10', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('8b974447c492469b85011eb21ca86ce8', '经销商老总', 'role04', '4', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('8c440b81233b4a30981cd0f271829c4e', '直营财务主管', 'role14', '14', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('8cf7d4ebf0ae448b8ba9aee996751adc', '商超财务主管', 'role17', '17', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('8d5e40dd32ff49338e09b6e904f4f60d', '经销商老总', 'role04', '4', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('8da7a8964f3449f5a52da465a8b6b569', '商超财务主管', 'role17', '17', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('8dd200ddc4e34afa8d1f3b1aa30c037d', '综合库管', 'role08', '8', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('8e1a535492e54197ac86cdc36f5e1ebf', '餐饮财务主管', 'role19', '19', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('904693aa647949768479668867a7d36c', '餐饮财务主管', 'role19', '19', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('91b96ffb0420403cabeafe2abdd62f6f', '经销商老总', 'role04', '4', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('9201b6414a954197bd67ad5706591c3f', '业务员', 'role10', '10', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('9229ba4e01ae45649b3ebe70a366995f', '餐饮财务主管', 'role19', '19', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('9231d59ddb5b464b87b57ec336629376', '直营主管', 'role13', '13', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('923a519b7e424a278a899e0ed1eee8f0', '经销商老总', 'role04', '4', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('92a48dbf40c3404e89f82b9c51f94a8d', '业务员', 'role10', '10', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('9386490baaed4f1fb363aeb5a511c33d', '税务人员', 'role21', '21', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2018-03-05 15:24:55', '2018-03-06 10:43:01');
INSERT INTO `upms_group` VALUES ('943b2b4a166a4b36bbf3de45aef2e7bd', '账务人员', 'role20', '20', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('94e001990de64b82869d80bfc86e2323', '账务人员', 'role20', '20', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:33', null);
INSERT INTO `upms_group` VALUES ('95183ed0dcd44c97ae4d77ca49ea31e2', '经销商老总', 'role04', '4', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('9537c4bf2ee44dd2b93865d1235780d4', '餐饮财务主管', 'role19', '19', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('969eee4e71504e749aaf056b4ed421ee', '商超主管', 'role16', '16', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:10', null);
INSERT INTO `upms_group` VALUES ('971946cc16fe4e9fa2deaaf11ed92218', '直营总监', 'role11', '11', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('97b9f49f207d4e359fe50eb6e2256ade', '直营总监', 'role11', '11', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('97ec2688f7734bf7a93e094592f46e2f', '商超财务主管', 'role17', '17', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('980acef842074f63a3f36b43f9e34b70', '餐饮财务主管', 'role19', '19', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('985a2e5391b64022bc04454bd7b13f8e', '经理', 'role05', '5', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('98f6304ffab741ff8c27fd1f2ead7126', '商超经理', 'role15', '15', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('99617e0902f0412b99f9f785de9f10c4', '直营商管理员', 'role03', '3', null, '0', '001', '2017-12-13 09:53:20', '2017-12-13 09:53:20');
INSERT INTO `upms_group` VALUES ('9aafd92b46d141e6bb4510088f91d513', '商超经理', 'role15', '15', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('9b3064950a994c8e80211c9bc67ce522', '经销商老总', 'role04', '4', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('9b33617c36c44d25b548ab48ce700ae1', '商超经理', 'role15', '15', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('9be98da87094461abbebe7a711921c1f', '业务员', 'role10', '10', null, '0', '001', '2017-11-29 15:45:43', null);
INSERT INTO `upms_group` VALUES ('9c423c44c4c54ab48d9739c514568bc1', '商超主管', 'role16', '16', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('9c725c18aac2411f9d70dc80a6d4025e', '直营主管', 'role13', '13', null, '0', '001', '2017-11-29 15:46:31', null);
INSERT INTO `upms_group` VALUES ('9d0f6246ae004bb69f0dab8bee2d349b', '餐饮主管', 'role18', '18', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('9d52c7a6b0c54b58882deac22831a9b1', '库管', 'role09', '9', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('9db2aba75b24471f828558900b50d315', '直营总监', 'role11', '11', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('9db78b5983564017ae3a7123db629a65', '账务人员', 'role20', '20', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('9eac10c90d83460b9840114776b30eff', '经理', 'role05', '5', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('9ee71b28ece44ae894c9b6e2323d06a7', '直营主管', 'role13', '13', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('9ef4348bcec14411845d6cbf4cede040', '商超财务主管', 'role17', '17', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('a0c744515058422d88469041ee448690', '库管', 'role09', '9', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('a1e92563627e4062b2bb603cde164e6c', '直营商管理员', 'role03', '3', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('a20c2281097c48bd8f0ef97bd4859eb9', '财务主管', 'role07', '7', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('a224983f9d544311ac32b8a36b44cb3c', '综合库管', 'role08', '8', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('a38fdf3e017a48508bc790acdaa0369d', '直营总监', 'role11', '11', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('a3d5acd41dd14592ae34cc893c9024ae', '直营总监', 'role11', '11', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('a4c2adcc9ea44583a2531377a3f0021f', '直营主管', 'role13', '13', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('a58be813103b444fbe4f46df6715b2c6', '直营商管理员', 'role03', '3', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('a5dacaf126094a00a23c215d1cbad6f1', '账务人员', 'role20', '20', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:09', null);
INSERT INTO `upms_group` VALUES ('a7029b76f44c43eb8136007da1774c12', '经销商老总', 'role04', '4', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('a8e5f9e270a44a8b9ad102d3f42bac12', '直营总监', 'role11', '11', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('aa335e4c37b44501aaa8e36f3a45b10a', '餐饮财务主管', 'role19', '19', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('ab3c70d52f2c4368b2773a51dd3f107f', '直营经理', 'role12', '12', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('ab45cbde981a4fc08c740e5ac35e866b', '餐饮主管', 'role18', '18', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('aca57078f8984c00b8ba7611ba2e2ede', '业务员', 'role10', '10', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('ae53f968de704002a830fc2a251cb369', '财务主管', 'role07', '7', null, '0', '001', '2017-11-29 15:44:48', null);
INSERT INTO `upms_group` VALUES ('ae6db7571d2a41de8c688a979a22bf1b', '餐饮财务主管', 'role19', '19', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('ae86c63f79894070906d1cd5a0142912', '系统管理员', 'role01', '1', null, '0', '001', '2017-10-30 19:19:22', '2017-11-29 15:42:50');
INSERT INTO `upms_group` VALUES ('aee012fd9ea84a15866624550edc0fac', '经销商老总', 'role04', '4', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('af03eb2715f041fe972fd7d17c92e3a6', '账务人员', 'role20', '20', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:28', null);
INSERT INTO `upms_group` VALUES ('afb27bf581874ee582f5381d9cfd230f', '业务员', 'role10', '10', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('afd4936556c5467692072ac6c53b323f', '主管', 'role06', '6', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('b017303863604645b53afaeb35954b7e', '商超主管', 'role16', '16', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('b048917853c84a248ed373388268c4ab', '经销商老总', 'role04', '4', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('b07b16f406b243b4a563eb612e751d2b', '直营财务主管', 'role14', '14', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('b194c5792c4341bb9a9e95fe69ca6278', '财务主管', 'role07', '7', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('b21102d5217341a3bcb4f0d07dc9a5c8', '餐饮主管', 'role18', '18', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('b233cc7a9e4c4684836a4293d7e5dd4c', '主管', 'role06', '6', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('b3f8f4a5b534422dad11da6cf997f166', '直营财务主管', 'role14', '14', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('b40ebdb512264b1c8813b9d2123c5da5', '直营财务主管', 'role14', '14', null, '0', '001', '2017-11-29 15:47:17', null);
INSERT INTO `upms_group` VALUES ('b4252a7dac9b4c37aaee65b0f6d8e388', '商超主管', 'role16', '16', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('b4bcfd602fcc4522aa3a07d08965fc71', '直营主管', 'role13', '13', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('b59d04e5dfc14512886cfbd7b7eb7119', '餐饮财务主管', 'role19', '19', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('b6a01236044d4dafa6539d044a23b14a', '餐饮主管', 'role18', '18', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('b7a96af8441546d8af620b27aa09e5e0', '直营主管', 'role13', '13', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('b8d6be4da0c44316a1f567436d0f8d87', '库管', 'role09', '9', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('b97ec67cb0a64f39b3e5bb4db3fb2c5a', '综合库管', 'role08', '8', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('b99abd5532854230a1ee750a826d78ad', '主管', 'role06', '6', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('bb28ae65d9a1480496f3c1cb7db03868', '综合库管', 'role08', '8', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('bb3b241e980e498683d032d098483e90', '直营商管理员', 'role03', '3', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('bb3c73a209124c628e16967ca1413aa9', '商超主管', 'role16', '16', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('bbdbd482ad094c1d8bd8eea3944fbd70', '商超主管', 'role16', '16', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('bc335148047f4bd688fc376a6d327e43', '主管', 'role06', '6', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('bc4c0c86528c42a4a2af595e0aee1ce1', '商超主管', 'role16', '16', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_group` VALUES ('bcaf8f4933d34a95a57cba930e484b08', '餐饮财务主管', 'role19', '19', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('bd142b857a6e404a9331ce083869632d', '库管', 'role09', '9', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('bd4b39366e564dbfbd8be0df845f6317', '财务主管', 'role07', '7', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('bd6871f5a5534300b672f368a64b536b', '业务员', 'role10', '10', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('bd730b12e1c14057ab6de993e66c3dcf', '财务主管', 'role07', '7', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('bec17719e56047ed94026820df2e748b', '直营经理', 'role12', '12', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('bf50b351ad2941b49cbdf2bf5f9c6384', '餐饮财务主管', 'role19', '19', null, '0', '001', '2017-11-29 15:49:08', null);
INSERT INTO `upms_group` VALUES ('bf77b91e2da84cc2bdaa199cb35ac753', '主管', 'role06', '6', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('bf9930b3488e4af7b3b30783f672d423', '商超经理', 'role15', '15', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('c05a319c29e34ff7a78ace6392b6c62e', '经销商老总', 'role04', '4', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('c0625a3e3fac4763814e039189f18393', '主管', 'role06', '6', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('c12bdb05250448dc8b6acf215efa30ca', '账务人员', 'role20', '20', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('c151e5a442164d5caee48679ffb819a8', '直营经理', 'role12', '12', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:09', null);
INSERT INTO `upms_group` VALUES ('c290b0c24d704cbcbdc5af01c8d77f29', '业务员', 'role10', '10', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('c2b0c2b8ab73440882e37debeba8cc9b', '主管', 'role06', '6', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('c2e7e8dec9ad4b5b9adf0dfa6142d6cf', '餐饮主管', 'role18', '18', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('c3736a64335d4e6ca134b5a447f4d98f', '经销商老总', 'role04', '4', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('c3820c94f1f04f1489fa72641d3a403d', '直营经理', 'role12', '12', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('c3e5ddf1ff784341870645d1c128789f', '经理', 'role05', '5', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('c4c3f28b796d48aca32686735d6adc35', '主管', 'role06', '6', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('c5305c301c73455a8291aa8cf831b0e5', '库管', 'role09', '9', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('c67487fb2d32419f87fdefb1e289df8b', '综合库管', 'role08', '8', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('c7221e35841a473ab3ffcb7b3f5cf00e', '综合库管', 'role08', '8', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:33', null);
INSERT INTO `upms_group` VALUES ('c7549ee541354a14b6bfdd00eba07221', '直营商管理员', 'role03', '3', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('c891beb2bcbe422ba47f4149015404dc', '经销商老总', 'role04', '4', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('c91166a3654648c3899754b6730eb860', '库管', 'role09', '9', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('c95301da0e0c489390bbbeffb386409d', '主管', 'role06', '6', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('c986e206befb45538ccf95d271b7fdb0', '直营商管理员', 'role03', '3', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('cb1aba0496ea4686869b731243381127', '商超经理', 'role15', '15', null, '0', '001', '2017-11-29 15:47:42', null);
INSERT INTO `upms_group` VALUES ('cbb9428f0a644d85b001db7352b347b4', '库管', 'role09', '9', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('ccc887987cf2407c9dd95a7199e119cb', '直营主管', 'role13', '13', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:12', null);
INSERT INTO `upms_group` VALUES ('cde96230966b4a458827800fb24752a7', '餐饮主管', 'role18', '18', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('ce3f5cc9481345edbb105d4b05fbd53c', '直营总监', 'role11', '11', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:12', null);
INSERT INTO `upms_group` VALUES ('ce404a7f710441e3bc9330cb146637b5', '商超财务主管', 'role17', '17', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('cfb63d7fec204902bc21cb00e7152d4d', '商超财务主管', 'role17', '17', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('cfb71e879f2e456a802ba05de59bee70', '餐饮主管', 'role18', '18', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('d026554a2cda42ddb8e05c316d8ae376', '直营总监', 'role11', '11', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('d18e73beee684cd6a1551685bdaff72a', '主管', 'role06', '6', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_group` VALUES ('d1a43616602e46c680b792b7fdbbd509', '综合库管', 'role08', '8', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:12', null);
INSERT INTO `upms_group` VALUES ('d1a7dc3ac95a438c98a40f9959793154', '餐饮主管', 'role18', '18', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('d3248b788e024d31a54143164d98f9e1', '餐饮财务主管', 'role19', '19', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('d3e8c614a9844a63b1e15dbf5d864aa3', '直营商管理员', 'role03', '3', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('d4e40ecc744244458b88b6dc98d750f0', '库管', 'role09', '9', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:12', null);
INSERT INTO `upms_group` VALUES ('d52a51f779e94f6b8ca18da3156143c6', '商超财务主管', 'role17', '17', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('d57ff08b7bb448118a79f6e2a43ef13d', '财务主管', 'role07', '7', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_group` VALUES ('d633acbf27a848e08e8bd0220c79b92a', '库管', 'role09', '9', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('d644a4c22d3c4443b1f4cfa38e95fb7c', '主管', 'role06', '6', null, '0', '001', '2017-10-24 11:28:52', '2017-11-29 15:44:29');
INSERT INTO `upms_group` VALUES ('d693e4fcaba34faaafb3b625919e174b', '直营经理', 'role12', '12', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('d6aeced957834073af4888e086910c11', '商超财务主管', 'role17', '17', null, '0', '001', '2017-11-29 15:48:17', null);
INSERT INTO `upms_group` VALUES ('d7a555098a734d1291638f647ee59406', '直营总监', 'role11', '11', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('d8b5f44714af43c38f3e79021e4d667a', '主管', 'role06', '6', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('dcd018cd35074442979bfdb92156c43e', '业务员', 'role10', '10', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_group` VALUES ('dd54669fc6f94330a02708ab3a9ce304', '餐饮主管', 'role18', '18', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('dde377d87046430c9e8caecfe97a37ef', '财务主管', 'role07', '7', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('dded1cee32e4446a9c406a0eeb10530b', '直营财务主管', 'role14', '14', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('de6e7f72cc56493c917afc15eba9f19c', '商超主管', 'role16', '16', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('deaca25b5b9f472eb840797f393d29c9', '直营财务主管', 'role14', '14', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('ded75ca303e64e5da5e6500edc2d0e5b', '账务人员', 'role20', '20', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:28', null);
INSERT INTO `upms_group` VALUES ('dfcb08e6b4284a9b84fca17b3a0ace1a', '直营经理', 'role12', '12', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('e057e2965bb84c2484170308b4b428e6', '直营商管理员', 'role03', '3', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('e103d7c2bc7a40d7a0ef22340cceaa65', '主管', 'role06', '6', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('e277b3144db64776bc37bb51be0c56a2', '直营总监', 'role11', '11', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_group` VALUES ('e57230f5fa454aea928cd8a2f83cd51b', '账务人员', 'role20', '20', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('e579ab11b2cf4b9b856b50c12a11d20f', '业务员', 'role10', '10', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:50:59', null);
INSERT INTO `upms_group` VALUES ('e61af17b51a041c9b20b67df78a51caf', '直营总监', 'role11', '11', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:43', null);
INSERT INTO `upms_group` VALUES ('e6ba5bc65a8a4a388829a1058dbaeee3', '直营总监', 'role11', '11', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('e6df14da683342cca6f034a551a07e3b', '直营财务主管', 'role14', '14', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('e78df0505254408baa5fe10f286af06d', '直营财务主管', 'role14', '14', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_group` VALUES ('e792722f93a04e5ea8c0950fb8b7fe2b', '商超经理', 'role15', '15', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('e805de2e4fda4b839a7d6d4ded2c0759', '经销商老总', 'role04', '4', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('e8d6d7fec94f44549d43dbba339586f3', '直营经理', 'role12', '12', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('eab541e21f724d99b7284e2a22f936ea', '业务员', 'role10', '10', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_group` VALUES ('eb8710cadbe441c997731dc9637880ec', '直营经理', 'role12', '12', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('ebc5d5940f2b41b2ac0b070c3ef19413', '库管', 'role09', '9', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_group` VALUES ('ebf2c59ab42c453f97d4b168ce224197', '直营经理', 'role12', '12', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_group` VALUES ('ee333603151e4e0bb7707732521e296b', '经销商老总', 'role04', '4', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_group` VALUES ('f2b3b513bb60420d80c165349d3deff0', '直营经理', 'role12', '12', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('f2e57a108a414df8acfdbbbf7868bd18', '财务主管', 'role07', '7', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('f42fc64941a4475f83a568863156df3c', '商超主管', 'role16', '16', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('f431ec815b0a4678b633e048f3d60359', '财务主管', 'role07', '7', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('f4603457f6f946a5a05a872ca52a0967', '商超主管', 'role16', '16', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('f49ccb3c36344026984e459de43f51b3', '商超主管', 'role16', '16', null, '0', '001', '2017-11-29 15:48:01', null);
INSERT INTO `upms_group` VALUES ('f53d93a4a4774cd59de3b68e2febe99a', '直营财务主管', 'role14', '14', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('f6e5576d2e454a04bfac93c08183c657', '餐饮财务主管', 'role19', '19', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_group` VALUES ('f77116ebc17240dc94bec8008874d585', '直营财务主管', 'role14', '14', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_group` VALUES ('f7b728f87ec34148bb3cb6de1d3a3315', '库管', 'role09', '9', null, '0', '001', '2017-11-29 15:45:21', null);
INSERT INTO `upms_group` VALUES ('f830f051d64242bfa750f766b47584a7', '直营财务主管', 'role14', '14', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_group` VALUES ('f8ac9fa27a9f4587978ac7fe075da4ec', '商超主管', 'role16', '16', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('f8c5564b11984410b996a3c2d265dbf7', '账务人员', 'role20', '20', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:09', null);
INSERT INTO `upms_group` VALUES ('fa9585db8e2743a3baa6081496a73ce5', '综合库管', 'role08', '8', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:49', null);
INSERT INTO `upms_group` VALUES ('faec20d7bba04ffdb8bd2bd6afe8eaf2', '主管', 'role06', '6', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_group` VALUES ('fe4e2d1c709a47259dcf2fbede4b53b3', '直营商管理员', 'role03', '3', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_group` VALUES ('fe8828050679452eb54816421eab0bb2', '直营商管理员', 'role03', '3', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_group` VALUES ('ff1eafc432e947b8894d52d6580d76fa', '库管', 'role09', '9', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_group` VALUES ('ffdfd5079fb8458faefab5065cb07bc3', '商超财务主管', 'role17', '17', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);

-- ----------------------------
-- Table structure for upms_group_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `upms_group_role_rel`;
CREATE TABLE `upms_group_role_rel` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `group_id` varchar(32) NOT NULL COMMENT '分组ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  KEY `_group_id` (`group_id`),
  KEY `_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分组表与角色表关联表';

-- ----------------------------
-- Records of upms_group_role_rel
-- ----------------------------
INSERT INTO `upms_group_role_rel` VALUES ('007c101df4144c228230657ebf13e425', '53dea76048f64cc89714844c1420e61c', '7ca2e1151a15406c871520fe49ca017e');
INSERT INTO `upms_group_role_rel` VALUES ('007f6abf5c9148bbb2e3cf4b19613f42', '544c0f34c5364261a86457be1bae14f4', '3ca4c83fc099440ab12a85cabdff54c2');
INSERT INTO `upms_group_role_rel` VALUES ('00a3d68d9b8642d68a7b47519a4b65c4', '9db2aba75b24471f828558900b50d315', '145d39b51a4e4e8095a9e05af4e4997e');
INSERT INTO `upms_group_role_rel` VALUES ('00ddd8f29eb143548983aab78dd32e78', '0d11843f3cc54241875bd29d4d84ab5c', '2b1f17e0121748edb52c1731a3c70529');
INSERT INTO `upms_group_role_rel` VALUES ('00fc825fba7742cf8f154433d646e574', '5789929be2ed432ca7d00e18595b84bf', '06509f60f21a4f5a9e32d00595984976');
INSERT INTO `upms_group_role_rel` VALUES ('021ceae3ba7e4e4197845f9a67675cae', '8d5e40dd32ff49338e09b6e904f4f60d', '2e18647df3db405caa52a74c02e8db40');
INSERT INTO `upms_group_role_rel` VALUES ('0297fa041e3b48d4815b6dd3e1b632a5', '876d010ccc4643739591dd259f6d46c1', 'abaca15bc7634155adc82f893a7e1d96');
INSERT INTO `upms_group_role_rel` VALUES ('02ebde239b3844edbc1d3d63e5400715', 'a825360149f8408cbf533e05e48990ab', 'aaf48c7c9fa94286822db02cd9b53f14');
INSERT INTO `upms_group_role_rel` VALUES ('0342e7ade7fa4f7d9821424b5f12f62f', '1534bd84f5eb49e283632ca048171120', 'e0cbb06020714de388a8f7efdadabda6');
INSERT INTO `upms_group_role_rel` VALUES ('035c008026ed4ca4a34f8bee7c803fad', 'f788b1c2b5a54ba4aaf4bd0d61804502', 'd39bb88d50f449039a28a3ad84c06bc9');
INSERT INTO `upms_group_role_rel` VALUES ('0370690140db496c9a28bf4dbeb73631', '3d161c0f39e84f6996e92bdb42034b2a', 'c1a9aec88f2444f0a69e3ea0c812f074');
INSERT INTO `upms_group_role_rel` VALUES ('039f2a9274a5418b80ad72917a9712e5', '0171a01201254acdb9a44292b67ed1f2', 'c872e8d5394a4cef8958a99ca473a728');
INSERT INTO `upms_group_role_rel` VALUES ('047d4e1e30814b84b92f2d729802e628', 'd1a43616602e46c680b792b7fdbbd509', '1cd0bf27e99b418ca2b88ee39cde2986');
INSERT INTO `upms_group_role_rel` VALUES ('047efb8ab64144c9905f564a87e76894', '7f903564840f4122a345e9d83c7702f0', '4147ccdd48974cfbbb789f7bcca1f32b');
INSERT INTO `upms_group_role_rel` VALUES ('048fa6624ab04774ba0282d7435f83d7', '538814f2894a4555b02d72d70e9ecafe', 'c2d70cbd27d342ce90c88874beabaa98');
INSERT INTO `upms_group_role_rel` VALUES ('0570908f81be4a1a8b11e5ee8b750f8c', '5c5c098a8cf74f708aba7c0e3ccf2b7f', '1a81720034a8409ca43111d60ee5b291');
INSERT INTO `upms_group_role_rel` VALUES ('05bf64016caa48cca5b5acd148ad939b', '684df90435e74d729d26835809b1e7e3', '259196f5ba89464a9a93875d75437fe0');
INSERT INTO `upms_group_role_rel` VALUES ('068107d83e024e79ab8f1e4bda71dd94', '97b9f49f207d4e359fe50eb6e2256ade', 'e28d8287aa984e54884f0ede7b00dc12');
INSERT INTO `upms_group_role_rel` VALUES ('070512da8b34403b87424f86dd0d3d77', '7322a41f2f4f494c996779a8c9640c45', '81ef30f16c7b4043aa69b83d1126319c');
INSERT INTO `upms_group_role_rel` VALUES ('07828bcd804e4afa9b02d8ce3476a6b2', '9d0f6246ae004bb69f0dab8bee2d349b', '2afd81ba2e934b85891670905cf3fdd6');
INSERT INTO `upms_group_role_rel` VALUES ('0792c63598b34f489cc7ec08f1cd6e8f', 'c12bdb05250448dc8b6acf215efa30ca', '961277a9cc91495aa7d4a57d2cfad986');
INSERT INTO `upms_group_role_rel` VALUES ('0a379db2d8c54328adf9f3acb93595b3', '580d1eb3d7464df4a952005f4140b73e', '86464d7f4f994286877c65c06db45e9e');
INSERT INTO `upms_group_role_rel` VALUES ('0a69322d6888419282368f6468f902cc', 'b233cc7a9e4c4684836a4293d7e5dd4c', 'a31a397fbc21417e9186e63d1cfddef1');
INSERT INTO `upms_group_role_rel` VALUES ('0abbd8dff35e4018b0a974563a868a59', '1871a17a73fe49e29f93a30b565a91d6', '1f8412e9e67e4035ba89e04e034b434c');
INSERT INTO `upms_group_role_rel` VALUES ('0c92f2ee8b74448b80da89dab0a9e898', '9ee71b28ece44ae894c9b6e2323d06a7', 'a0b7ab54d08d44e4a8a52a81d6b7537f');
INSERT INTO `upms_group_role_rel` VALUES ('0cbd5bbd5599478fbd00fd711edd0862', 'e792722f93a04e5ea8c0950fb8b7fe2b', '5c97046e96cb420bb01a52f5e6b1b044');
INSERT INTO `upms_group_role_rel` VALUES ('0d80ab0ab54b4691bed6a044bef0f8af', 'e805de2e4fda4b839a7d6d4ded2c0759', '4b8dbacfe50c49f2a01092d165c191d9');
INSERT INTO `upms_group_role_rel` VALUES ('0d970ce9efb14d1ba358366512ff2b6b', '8cf7d4ebf0ae448b8ba9aee996751adc', '602c2fe80e464a58b2f1b68d50e29259');
INSERT INTO `upms_group_role_rel` VALUES ('0e092e592fd645d885ac0a595ed87da6', '35fe4b3dc2d040af9b4210ac166fdc46', '6e6cfe4a3e7a46e3a1d993f21dd2c568');
INSERT INTO `upms_group_role_rel` VALUES ('10cf115d880a4515b519688bb8f29ed0', '66dfe408a273455cb2739469b8b0e47b', '2a8b000a24eb4ea3962950f77ec4d75a');
INSERT INTO `upms_group_role_rel` VALUES ('11ec63d5587f47c7a57d177c201d7f25', 'faec20d7bba04ffdb8bd2bd6afe8eaf2', '9ee8cf0c25e142079c8b2542f001269b');
INSERT INTO `upms_group_role_rel` VALUES ('124e12e64a9f4371ae98118e287b4b0a', 'dcd018cd35074442979bfdb92156c43e', '7f1680aa544a4f4d971f16feae00d9b7');
INSERT INTO `upms_group_role_rel` VALUES ('12f143ad98a544ca984f500b5efe9f43', 'b194c5792c4341bb9a9e95fe69ca6278', 'bc641712dcb7435e9b1403c0a91d23a5');
INSERT INTO `upms_group_role_rel` VALUES ('1351201d526b41509f776ba258657eb4', '1fa37e9b046c47a0b98204a2e44e6790', 'dc851bab3f5d4a72991f43075f896d79');
INSERT INTO `upms_group_role_rel` VALUES ('148beff42ef64b73a7d6ec4642bae317', '8720a61865ba45bb9560426672ed7cb7', 'c42c093f483346fc94d64298dba1ce9c');
INSERT INTO `upms_group_role_rel` VALUES ('153e368e33fc4066b04363d664120f37', 'c3820c94f1f04f1489fa72641d3a403d', 'd2b97b5e171f4e47bd85f5c254e73b4e');
INSERT INTO `upms_group_role_rel` VALUES ('155de0c56fb44ce5af340c037686325a', '420054ade4a04759a1214b49287b9a0d', '4fdb0863dcb8437e9fecb999df1f0846');
INSERT INTO `upms_group_role_rel` VALUES ('15909a37bf3b4a3a9ebc5489d616a3e6', 'ded75ca303e64e5da5e6500edc2d0e5b', '9fa88e6da6fb44b6b346675d091d16dc');
INSERT INTO `upms_group_role_rel` VALUES ('15ccf8c3b14748a1a8734a970d700bba', '1b127a103b4f4575b63e1b16a91138e2', '7c1dfe888cbb43c385841c2664de7375');
INSERT INTO `upms_group_role_rel` VALUES ('1601c96335b9493ab2ca4719b25bfdea', 'e57230f5fa454aea928cd8a2f83cd51b', 'ea34b6a2059243fa875e51e1c57e3fb4');
INSERT INTO `upms_group_role_rel` VALUES ('164ffde9d8a34f51b1694d82e1d63df8', 'ae6db7571d2a41de8c688a979a22bf1b', '51cbcbec8b994b479628f399025d79b7');
INSERT INTO `upms_group_role_rel` VALUES ('19b44876f8304688984a036fca5e54e8', '74c0245c1e214258910a36095016648a', '8f1303f48c424c85a80d6ecc86609b22');
INSERT INTO `upms_group_role_rel` VALUES ('19cc1cf276d24e9a90a22b66e356810d', '33ac688a864a459cb083a55565d892ee', '5c5a5bf2ea8148aca7a72a8bbbcb21de');
INSERT INTO `upms_group_role_rel` VALUES ('1aa0229369dc41119787a50c54013a89', '60faacc4193b49f0ab1b8b783e2e705d', 'a155fd98e85a42978df1f4c6549820a1');
INSERT INTO `upms_group_role_rel` VALUES ('1b99c3dbc1944ca2b63193882d7cb095', '9231d59ddb5b464b87b57ec336629376', '2ad2e6684d314f459b858cf490e952cc');
INSERT INTO `upms_group_role_rel` VALUES ('1bd22a284bcc4637ba4e130f5b5b194b', '923a519b7e424a278a899e0ed1eee8f0', '8f154b87aa784bd38c04069df16c5fff');
INSERT INTO `upms_group_role_rel` VALUES ('1c1466a3d5c7436292b6e2e6423233a4', '9d52c7a6b0c54b58882deac22831a9b1', '8903823ec4144916977c033f2ea91abd');
INSERT INTO `upms_group_role_rel` VALUES ('1c70402fd70645e39a9422d8e76d2380', '44c0a726dcf14e08a59bd03d1df945c8', 'e7ebf6b99f36479394fdf5f1faeeee90');
INSERT INTO `upms_group_role_rel` VALUES ('1c80f7b922a3452e94b6a61e9e04658c', '1ddc1b64362c4e6a8525d87909a1b761', '2a411ba42998418b88e555b01114788b');
INSERT INTO `upms_group_role_rel` VALUES ('1cc7214b43c24f35a55de2d2213ecea6', 'd8eb3dbdbfdd4bfba596dddd4f413964', '7fe897f61553487999e9f109ef5fa3fb');
INSERT INTO `upms_group_role_rel` VALUES ('1d8cf49eb62b4937ba7feb8c19e48eac', '6450270fd0744705817734a851d1b8d0', '2d853c4152f84e43adcb1b79743a7455');
INSERT INTO `upms_group_role_rel` VALUES ('1f07fd32a2dc42a2abdf1b627f891289', 'a5dacaf126094a00a23c215d1cbad6f1', 'bfa3fc137b534b3b81f4fe623d13fced');
INSERT INTO `upms_group_role_rel` VALUES ('2072eab7b2a641d2a5df05233315cca9', 'b7a96af8441546d8af620b27aa09e5e0', '789841e58d424127b3041a3259d93008');
INSERT INTO `upms_group_role_rel` VALUES ('207830e93768425abc3ca48f273187cd', 'de6e7f72cc56493c917afc15eba9f19c', '968c4572ef044931b34e73783946902c');
INSERT INTO `upms_group_role_rel` VALUES ('20b499610b2346a7a791871410cb30c0', '10c7b8b1fbb749898d9f89e9f01889e6', '78512db5a1da40d18bd13294ec02b227');
INSERT INTO `upms_group_role_rel` VALUES ('20d0b43dbedf4c678fa4abcaa6383c43', 'a58be813103b444fbe4f46df6715b2c6', '05761780e0f649a5bce0301e818d5f7e');
INSERT INTO `upms_group_role_rel` VALUES ('20edb90458e3474797b03b0d7bfd53ad', '60e78710c1bf459baf25d01f8f1e6ada', 'a17b46688c5f473d8d31681ad6f1c80e');
INSERT INTO `upms_group_role_rel` VALUES ('2217c33f69044d818517cd22c1ff8ca9', '38b2c06a45284f9ababef5320581d40b', '20e413bb5471413d8163c76106981e11');
INSERT INTO `upms_group_role_rel` VALUES ('233d4ffb14d64d008c683b0f3a8a8aef', 'b8d6be4da0c44316a1f567436d0f8d87', '79b106b37c364a92ad0eb7011441f90a');
INSERT INTO `upms_group_role_rel` VALUES ('237e9af50e7948ee83a64bbc9b23e3b4', '9b3064950a994c8e80211c9bc67ce522', '24ca32f6d9204251a74732deb9573dd7');
INSERT INTO `upms_group_role_rel` VALUES ('23aa296ede77486fbad45ef5e1a11251', '4f2b9260c90d4fb0a3f2e90426118a38', '84623d03a1a541729ac57ee3757b027b');
INSERT INTO `upms_group_role_rel` VALUES ('23fd9b44d9314693b5926f1093f028f0', '2a8a17f801f2476cb45c6b70a0344ffb', '4dd2badb0ed24951830f7628a0ab2575');
INSERT INTO `upms_group_role_rel` VALUES ('242bceff93b1422583ea9dbc240822b4', '45659219e86545aaaa9d3cdb4c73faa6', 'c7dec3d37f40481381c9315822eac98e');
INSERT INTO `upms_group_role_rel` VALUES ('2443d646f1f0403da1edc7e1aa0c09df', 'c4c3f28b796d48aca32686735d6adc35', 'd16f33d9f8ba4ceda4c3c7c90a185a71');
INSERT INTO `upms_group_role_rel` VALUES ('2503e8b768a94e82a21f2e6c2b9af054', '1d1046b21535439db151d335a75d1d33', 'a11b017e53be4d5bbf56eab58b843819');
INSERT INTO `upms_group_role_rel` VALUES ('26015741a1744994826af742e023b007', 'd3248b788e024d31a54143164d98f9e1', '25cd7052207344f9b5223464be17ee32');
INSERT INTO `upms_group_role_rel` VALUES ('26712cfe1fd54ae997fa516451371d6b', '2304220292884a48a49402f3f1439214', '0ce5952eaad4442fa6ea8bdccf720731');
INSERT INTO `upms_group_role_rel` VALUES ('27423d5b8daf4056b662fb9e53e4ad55', 'e103d7c2bc7a40d7a0ef22340cceaa65', 'bcd1363af12e4ee49c00726ab60d54d3');
INSERT INTO `upms_group_role_rel` VALUES ('2757a085a93f4bb7a7e154ffa23e4358', 'fe4e2d1c709a47259dcf2fbede4b53b3', '2094c5b5a4ba41d299572105e921f00e');
INSERT INTO `upms_group_role_rel` VALUES ('27d86ab1cf1f4886bd4efe0eb337242a', '9201b6414a954197bd67ad5706591c3f', '3aacdb1b4fc04c08b45c4040422a51fd');
INSERT INTO `upms_group_role_rel` VALUES ('28bf02a0ace2419a890e0b114bca87be', 'f830f051d64242bfa750f766b47584a7', 'd6eb88027fe84a1695e89825e62fd270');
INSERT INTO `upms_group_role_rel` VALUES ('2957ac67303547f3a42c1a0b89f83c7b', 'bd6871f5a5534300b672f368a64b536b', '0fa41fa971e849d0af122babe2ab0047');
INSERT INTO `upms_group_role_rel` VALUES ('29e4838a0e274248ba9f334e23298905', 'a0c744515058422d88469041ee448690', '60701edb2a2844fcb4745cd900ff6fd3');
INSERT INTO `upms_group_role_rel` VALUES ('2a998a1f58f6427eaa4f7eebd0f34344', '21877df732514e459462219301758939', 'f5d3bfcc92c3465f9bcab876267ff0bc');
INSERT INTO `upms_group_role_rel` VALUES ('2aa0d5f5880445738a330c8d89a31bc8', '4278545e2957468385fa97b1178c8266', '11e4f5fba26a46e68b19b7fabc0dd66a');
INSERT INTO `upms_group_role_rel` VALUES ('2aaf36ebcd174086a7fb3a355be2d4d4', '188c6b265f8244ab93cff9d4691844bb', '462ff146288c4d4cab13b624f2431421');
INSERT INTO `upms_group_role_rel` VALUES ('2ad2246a820848f192a5d329212c3530', '21d46de7870d4582bd121071d23f5d76', '1c7700039ec34f02aa8c109f05488b0c');
INSERT INTO `upms_group_role_rel` VALUES ('2c08e2022b9241a9b147a882204ad977', '28ef8dfd9bcd486590f61b35901215d6', 'b9aaba2d66c04e6cb0b22d52d2ec58a1');
INSERT INTO `upms_group_role_rel` VALUES ('2f8f2bba1e4643e78e7006b5d99e91cc', '8927608bf0914d25bdc19992c4d9bac3', 'c5004148d2284b969e94d93fb9911569');
INSERT INTO `upms_group_role_rel` VALUES ('2f952c0658034c30866e90ba3e4efbc1', 'dd54669fc6f94330a02708ab3a9ce304', '8ffa3230cefd421da786754e95141706');
INSERT INTO `upms_group_role_rel` VALUES ('2fa80812ad844fdca9b407e33d28007f', '63d121f339fe416abe31e861f78878ff', 'e236ace4b5f64333952aecf35a8d91e6');
INSERT INTO `upms_group_role_rel` VALUES ('300fb4ee08344201b23524d5233bd479', 'afd4936556c5467692072ac6c53b323f', '6fc70a2e94b541a183167944fc1649bc');
INSERT INTO `upms_group_role_rel` VALUES ('307bbc5fb7434ac9ae50ffc7f8759be5', '6e0ac32c0862457684a587a334b19cd2', 'd72fe1848f404d939a5ba50e50546f07');
INSERT INTO `upms_group_role_rel` VALUES ('332056d91dda49208489cb9e2654620d', '7bb03a71ddca44f6bb2e2e13ab6330fe', 'b07498240ab449c8ba65198d0be0405d');
INSERT INTO `upms_group_role_rel` VALUES ('333775be080c4668b7100be8c608c8b4', 'a6a98ef70ce048929991ce9fe5974ae4', '6c7694349aff4bb086f1c47d61f47c89');
INSERT INTO `upms_group_role_rel` VALUES ('337ad75c1ad34ceaa920c750e3b3b73e', 'a1e92563627e4062b2bb603cde164e6c', 'ece2d1ffed4841469d63a59aedbded89');
INSERT INTO `upms_group_role_rel` VALUES ('33c13b766a154d84b61052a26722274c', '9c423c44c4c54ab48d9739c514568bc1', '033a27b840e74773938305c3747fa3c4');
INSERT INTO `upms_group_role_rel` VALUES ('3448aba867934cf6a8f42db4036e737a', '2c0dfccc1e444956998881492d8369a6', '8ae926c1a1524c4393472eb58f738d99');
INSERT INTO `upms_group_role_rel` VALUES ('348d4aaf9ad04184a508f2552233de8c', '242c8349537341109a32a4262a34b7a6', 'aa569a1188714cefba01bcd3a300d089');
INSERT INTO `upms_group_role_rel` VALUES ('34d7fd3a143d435ea2a246cae9c09553', '781a659c25974874bdb685f2451019f2', '0241b628808649f7bfc901b44c4e6765');
INSERT INTO `upms_group_role_rel` VALUES ('34e7629ef37b448981fd7124f1cfb5e2', '7294fc180670460aa8f7ecfb6bbe9357', '1b7cc0def0194d85859c5bda1d89564d');
INSERT INTO `upms_group_role_rel` VALUES ('34ff3aa258fd47b280168d7240931ae3', 'd52a51f779e94f6b8ca18da3156143c6', '00fe058e31d04df7a34bf440790b9b01');
INSERT INTO `upms_group_role_rel` VALUES ('3502b777830a4a3dab364fb59609e593', '34501a88cff14450b3df928958d40b48', '0fd6cf5428184189a9badc5784581d10');
INSERT INTO `upms_group_role_rel` VALUES ('35ab13116c704aeaa91528dd362f1ed9', '12d12980f66e4f2e9ecac7eb1f71ec33', '30bf3caec5c44c2dbb4c12c80f342629');
INSERT INTO `upms_group_role_rel` VALUES ('36040a2d587d4598a3d1fb8e2a853592', '6c84cdf98b834695a5dc708c97f6c2b8', 'c60cf726fa19464783157a925d388216');
INSERT INTO `upms_group_role_rel` VALUES ('36162a94af9342529b54a5752bdbd3b9', '92a48dbf40c3404e89f82b9c51f94a8d', 'a584ec9a3bdf4842b8b0ed5ed85f34ca');
INSERT INTO `upms_group_role_rel` VALUES ('363a7183a9374ef2b0f6012e5af377dd', 'b07b16f406b243b4a563eb612e751d2b', '1a2315839bc94e829dd92a4273622338');
INSERT INTO `upms_group_role_rel` VALUES ('3675ab89d5074a158c1f6cb42065728a', '306ddb76ee6d4cee9d916aa71d9184be', '49da3b11de00400996db9119274bf3ba');
INSERT INTO `upms_group_role_rel` VALUES ('36e411a2d8e742fabeb68661572dcea9', '4c17ccb4442442e59c8af6e1cf17176b', 'a4109d673b564aa4bc17d124f3703857');
INSERT INTO `upms_group_role_rel` VALUES ('37090a6c5d4d4591bafc29d23968217a', 'c891beb2bcbe422ba47f4149015404dc', 'f275b1f8788043eb9f61fb34470a46aa');
INSERT INTO `upms_group_role_rel` VALUES ('38858e5d041b4b9e886367bfbf263e74', '7b00f195309c4ea294df6192ebc1dcc4', '');
INSERT INTO `upms_group_role_rel` VALUES ('396145f7938f488495d8ca689d27e5a0', '16d4606a4b164400b5f1d991339c8b5b', 'bed005c70c854317a9c07f36d825eb4c');
INSERT INTO `upms_group_role_rel` VALUES ('399044b75c0b43c8bbac0d859c71375e', 'fae79d5e1ba54ec1ab7ef814c0565134', 'fa82b1360d604b72a4227d356d12a3b9');
INSERT INTO `upms_group_role_rel` VALUES ('3a05ab783834488aa81bffe2f5907359', '34a8e54532414027a7a77e447bb82deb', 'fb67028859974ccfa26a71a4035a13cf');
INSERT INTO `upms_group_role_rel` VALUES ('3ac404c9118945d6a1d918c2aa762c3b', '5fa372f1f85c4b18a27923b7810ac6c4', '32cc59f436ff4a349fd60c94690b139f');
INSERT INTO `upms_group_role_rel` VALUES ('3aec7e6e87694e8a9321aef868f39fb7', '35aa649e908346128306dbbc6c2d107f', '11fcdbe107ba4cea88b116960017af7d');
INSERT INTO `upms_group_role_rel` VALUES ('3b35955053e44d07bf7916953b6ce1da', '8cb1df38e5884f44af36cc90851a95c0', '3f5b4356d96048a29c6990fd6df93924');
INSERT INTO `upms_group_role_rel` VALUES ('3cb0df87c494412298364264357e571b', '41ba2471f9294985862e71cddabcea92', '6803686015954c24b1853b3bda7c38da');
INSERT INTO `upms_group_role_rel` VALUES ('3cec2c8e94704f099a61145e79355487', 'bf9930b3488e4af7b3b30783f672d423', '290c9e30aba54e8baef7f0b87508dccf');
INSERT INTO `upms_group_role_rel` VALUES ('3da5e64ffbe74e1f972d8e9a61533fe8', 'dbeacfa927de4419bbcbfa1be299a5ea', '91d8554cdc384d6b83634587776440bb');
INSERT INTO `upms_group_role_rel` VALUES ('3dd1397845ef44adbc6647f370af3051', '37a99e9c39fd4f658a5b04face80b525', '08463038de5e47ddbb99cdcd8ced3ac2');
INSERT INTO `upms_group_role_rel` VALUES ('3ded6c2b2e1f47d9a1ea6fa1135e3958', 'd026554a2cda42ddb8e05c316d8ae376', 'd8be4deb4865470193ef5278e8150dd3');
INSERT INTO `upms_group_role_rel` VALUES ('3e8b5abec657449ab316f7267caac818', '6170b04294ad47ba9efdc80a7ae2e677', '28fc3c688df14d3e91afa3858d843fca');
INSERT INTO `upms_group_role_rel` VALUES ('3eb1941e646048cab04990b61643efde', '42a8a3bd3fca41cf99d75886f038caed', '4953fff68e124f56864236f7540373d8');
INSERT INTO `upms_group_role_rel` VALUES ('3f4afa56cba94b349726f8330e8956dd', '8da7a8964f3449f5a52da465a8b6b569', 'e68dd52fe8114c4e866e62689a84f9d0');
INSERT INTO `upms_group_role_rel` VALUES ('3f7b732e9cce4252af598e03ff57dec6', 'bec17719e56047ed94026820df2e748b', 'af08e09a9e58427fa94146ba080eb4c3');
INSERT INTO `upms_group_role_rel` VALUES ('41f73e12fe2f4f7e885869835034478a', 'cb1aba0496ea4686869b731243381127', '6c583c1bad4e4e0ead53a4dced0b3148');
INSERT INTO `upms_group_role_rel` VALUES ('427343ffc148452f839e4f7cece85818', '9aafd92b46d141e6bb4510088f91d513', '7463521d17ba4e88b89269bfae711623');
INSERT INTO `upms_group_role_rel` VALUES ('42ab8f192808439da3c7599f6b45d339', 'c2accc11512048c29a2c7b5a26151e34', 'af1443a651f04984876e1fe02db8fd38');
INSERT INTO `upms_group_role_rel` VALUES ('42c4e500046e4a9392d0623c23a4bb0e', '58815bf2c3bc441aa82b2046620b6879', '4b32ffabf38f4347b6a2bc14aaf0587e');
INSERT INTO `upms_group_role_rel` VALUES ('4417b7f04977472e8e1e3a6272924e62', '6a5b0467b6ba45779c76de9bb2796986', '1d7f8e5376944d2eb89c86d938f6ea25');
INSERT INTO `upms_group_role_rel` VALUES ('449dc19d20404823aedf26e5a0b96505', '7f0ff9aada6649c08eed10679503a7a4', '571b71217c074f8a93e3f497b5ececac');
INSERT INTO `upms_group_role_rel` VALUES ('44a0a30d0d8a46d896287430c1ad4bcd', '455e0d47ea024238a7363ec2a1b4a8a7', '3c528940684548b9a61d9a815be11083');
INSERT INTO `upms_group_role_rel` VALUES ('44b5db564b5c4fd58dada819bd05cb26', 'ee333603151e4e0bb7707732521e296b', '49da3b11de00400996db9119274bf3ba');
INSERT INTO `upms_group_role_rel` VALUES ('45c8dc7b0f2247858b49353a2ef33f3e', '7864afabc27d4aa68fa936ff1b138fe2', 'e31f2ed586e747c6b1abea6765f98b05');
INSERT INTO `upms_group_role_rel` VALUES ('46215b3eee96430daddb0a921573bc9c', 'd693e4fcaba34faaafb3b625919e174b', '3fb97f9a33494ff1b40ab0e8eb7557b1');
INSERT INTO `upms_group_role_rel` VALUES ('46894984ddec450e9bf538dbabbf00c7', '40da689eb7c148f39981c26e78a9db80', '9f42d562bb304657902ceb04a48fafce');
INSERT INTO `upms_group_role_rel` VALUES ('472067b59bdd4e418bdbaae7ce4b599d', 'af03eb2715f041fe972fd7d17c92e3a6', 'e085d79053694c25a92d07b793cb9747');
INSERT INTO `upms_group_role_rel` VALUES ('47f4b1212c3c47de853c4fc61ac7ee3d', '969eee4e71504e749aaf056b4ed421ee', '6e38f70696ce4478bb5735653415fbb8');
INSERT INTO `upms_group_role_rel` VALUES ('484828ff24f54ddd965462a5b9c39cd7', '7097a82721e34daca80cdae842dac86c', '984051387afb4cb2890d014110b97931');
INSERT INTO `upms_group_role_rel` VALUES ('4870b63ec1464776b6f048ba846ce276', '611b084c7ad74158980be8bc3c6109e7', 'b2378589ade04fd2b372d19371136126');
INSERT INTO `upms_group_role_rel` VALUES ('48e9e033631148cdb67b56bf08be8b22', '791e2dffc6e04a5888cdc4a288e0dfc6', 'cc3606fe5e0e434d83d3d1d4142596cb');
INSERT INTO `upms_group_role_rel` VALUES ('49ce6e1aff2142ed89a331b824e73fed', 'bf754ab29f4e49a1abc74d2411001ec7', 'cd4aaa05a7ba4686a19ca6924b0610f5');
INSERT INTO `upms_group_role_rel` VALUES ('4a4d0f1e1a44400e9163268c18d5cd32', 'bd142b857a6e404a9331ce083869632d', '53df8490fc8d4e7794265067d26d02e7');
INSERT INTO `upms_group_role_rel` VALUES ('4a70a338443d4ab59063a93677bc19ae', '9eac10c90d83460b9840114776b30eff', '92698e36b4bd4ccca1592312d43c5e71');
INSERT INTO `upms_group_role_rel` VALUES ('4a8db680b1db4968b909759359ab2798', '6bf6ded418464d25b1bff7a30bb42ce8', '99e504aea0984e57835f1b074ec9c11f');
INSERT INTO `upms_group_role_rel` VALUES ('4aeb1c4d906842bc94eac0c3d9d1111b', '40aa8c0cbe354e9da1e9eda0b25aaa86', '63e3cb876c234e278eacf697afc1eb1b');
INSERT INTO `upms_group_role_rel` VALUES ('4b3bd79e3b594a0a9766d6b9b57f4eb2', '12fa14a30c0c41a2b605a85a65d16095', '5441f28bb6284e37b4453a8a1212520d');
INSERT INTO `upms_group_role_rel` VALUES ('4c14a6b4df9e42d1ae06cb32ea2e6010', '2b0c023b83c54a7c86cc02e8a377afb4', '27c5a66e8dae4aafbc8c939aedbdb117');
INSERT INTO `upms_group_role_rel` VALUES ('4c283acce5fa4aeeb1bfbe7a374d9406', 'c91166a3654648c3899754b6730eb860', '4144eca3a49a455e97b58d02ad9ff9c4');
INSERT INTO `upms_group_role_rel` VALUES ('4cb5f8a4ec7c47348035fc9ebbba3feb', '0f207cda9e4f4b9e8c3e83f4224cc7dc', '535b63572a604f9c8970fee97b3a95df');
INSERT INTO `upms_group_role_rel` VALUES ('4d1ac883c57f4d4e8a5ec5e74599f3ae', 'f2e57a108a414df8acfdbbbf7868bd18', '7b95d07752f247828c021cf0730e88c9');
INSERT INTO `upms_group_role_rel` VALUES ('4da2d2fdbe50445fbbed22177038e6b3', 'd8b5f44714af43c38f3e79021e4d667a', '4bc68fbf5e114ffbb9ac333c2651d8ce');
INSERT INTO `upms_group_role_rel` VALUES ('4e4fc0cf32ed40bdbb9c936dd70334b8', '5b8b52ec196040939a73da5eed42cec6', '4973d8ee5bb44b569919237a27f901a9');
INSERT INTO `upms_group_role_rel` VALUES ('4ef1390c73334e07a1f4883c0b02054a', 'a7029b76f44c43eb8136007da1774c12', '38035aaf19da44db883c3f9df3451bec');
INSERT INTO `upms_group_role_rel` VALUES ('4ef6a52c2c024208828dec03d6269eb0', 'f7b728f87ec34148bb3cb6de1d3a3315', '32bc185d3d4749ceaa7bffc34792af92');
INSERT INTO `upms_group_role_rel` VALUES ('4f40ce8cf5fd490d975e55ad84ef1645', '1c6ec1d8fc2349e699a74bd509f06617', 'bb43769184f14beca4c724beddd9d15c');
INSERT INTO `upms_group_role_rel` VALUES ('4f523cf759564de6a35b8181aed91a69', '029544125b8446759c42066626add7b1', '10ff2fcdb6d045719949b66afee0a79c');
INSERT INTO `upms_group_role_rel` VALUES ('4f5acd632bc84b91918f4a1a535f5161', '61cc564642404a17ae7aefffdd791661', 'f3a49a746a4e4905b10632aaca3f8185');
INSERT INTO `upms_group_role_rel` VALUES ('5002422c85e5499b885ab27b6250dce8', 'ff1eafc432e947b8894d52d6580d76fa', 'f3f4f48dcf6a415298af8e61adcba573');
INSERT INTO `upms_group_role_rel` VALUES ('517a8743517b4b85b530e2f6fcfab793', '5757f5489d414bc59f07998a76f0f3df', '373143321a274595a8287d36d384f9a9');
INSERT INTO `upms_group_role_rel` VALUES ('5201f59a89114d5baf382f53ff881b44', '16bec8ac8cbf492998c3cff1de5d4001', '6e40196e1fa341d0b579ee6e6d6f1f01');
INSERT INTO `upms_group_role_rel` VALUES ('55320816a3f7447baf0bcc769bd1163c', 'cde96230966b4a458827800fb24752a7', 'dc083c75a5044a6fb9949d1009df67a2');
INSERT INTO `upms_group_role_rel` VALUES ('558bc239b78849c6a1681a20e2b8eb74', '45b1f67046e84df19194fa669dae53b1', '6f3dce26836948ffa0c73b59302e8a49');
INSERT INTO `upms_group_role_rel` VALUES ('559d569786c3408c965e6e247507b9e0', 'b4252a7dac9b4c37aaee65b0f6d8e388', '7a591574669648438e9536854b98955d');
INSERT INTO `upms_group_role_rel` VALUES ('5605de56cfb94af494eb28fb963e5f39', 'd1a7dc3ac95a438c98a40f9959793154', '62b08fb1c9a141d0b698683329f009fc');
INSERT INTO `upms_group_role_rel` VALUES ('56298236844145f1bf0c3d4318da17dd', 'd18e73beee684cd6a1551685bdaff72a', '82e28d1d6fce4f37a24be32ff5e3bae3');
INSERT INTO `upms_group_role_rel` VALUES ('575250d1df0e4d5f9581400d504f1897', '26a604533edf472d8a63ffe01a084479', '46116ed79b2d472197e96087a8af7738');
INSERT INTO `upms_group_role_rel` VALUES ('57608522b6e646a98658c9d01e5e5b2e', '3841892e21eb40fd888bc68a18105c9d', '14e7450ea23c4b93baafe10476c12763');
INSERT INTO `upms_group_role_rel` VALUES ('57732be613ab4bc5a5b3ef0705a2a335', 'c7549ee541354a14b6bfdd00eba07221', 'f412b707f9ab432e8ee90d3d78bf7741');
INSERT INTO `upms_group_role_rel` VALUES ('577ed47066fe436793259e9304ed7f31', '7bce1d41985643b59b28b8923ff984e1', '0e73419717b14c0881d691aaec6b8bdb');
INSERT INTO `upms_group_role_rel` VALUES ('578e532f058d4248a0cab8c06c3df534', '88d1c848efea462d87918259fbe46077', 'b430796ddbce43e3a8882ab83abf2fb8');
INSERT INTO `upms_group_role_rel` VALUES ('58c637e50f0c4017befdbd380966d701', '9ef4348bcec14411845d6cbf4cede040', 'aaaacf21913e48949bbb7b4adab2fb2c');
INSERT INTO `upms_group_role_rel` VALUES ('591c4f02b8dd4c28ba95da907c931aba', 'aee012fd9ea84a15866624550edc0fac', 'd55533c0b08d4a2ca9244eb5652da8a6');
INSERT INTO `upms_group_role_rel` VALUES ('59548ef0cc2a4f9aab8163ec1f301227', '90b14d95f26f4036a83753b1741dd373', '7ffbe1bbf82a4df48c0e4fbbacbe07bb');
INSERT INTO `upms_group_role_rel` VALUES ('598b001d84774caf87714b378d562122', '6f08cc5795104423abd48c3613c012b5', '7b6f6efe96dd4f08bb48d9d50ba71b49');
INSERT INTO `upms_group_role_rel` VALUES ('59a3d76cab03439ca0b3237e64b7354e', '8a871f42a5ce4be8b6e3b97763f1d0be', '402c603d776d46b59877cce1765d1dcd');
INSERT INTO `upms_group_role_rel` VALUES ('5a29e17c28ad4dc1a754f4c0513d0c52', 'e579ab11b2cf4b9b856b50c12a11d20f', '44f6b944abb14cf58ceb21d012c48ee7');
INSERT INTO `upms_group_role_rel` VALUES ('5a67ca0bf28445c98924622bd710c987', '19bb94e070c74dc8ac68aa8e241efe38', '2f682cc4a8b845d08bd24ce221fe47f6');
INSERT INTO `upms_group_role_rel` VALUES ('5a90bacdcf6648deaf70530f8b8034d1', '043e9dfd562241b28013ae69ab75a233', '78c0c2f30e6f4e409fc5041a2dc200c5');
INSERT INTO `upms_group_role_rel` VALUES ('5b8da5bc233845c1b738ed69293805cf', '9be98da87094461abbebe7a711921c1f', 'b8cac670da294584945f34d7dc4d0499');
INSERT INTO `upms_group_role_rel` VALUES ('5c4f157863d8481bbc2d8abf247117f3', 'a20c2281097c48bd8f0ef97bd4859eb9', '1cb844709d294269893b69f442be449e');
INSERT INTO `upms_group_role_rel` VALUES ('5cf55d0619754de781de28b419d1086a', 'c3736a64335d4e6ca134b5a447f4d98f', '475990543c864fa785df667cd67a3009');
INSERT INTO `upms_group_role_rel` VALUES ('5d10980fef214029b8caaa32fd994ebe', '13f935f87d2e4508b3191045cc7ea394', '998aba184fa94776bea8ce10025e77fd');
INSERT INTO `upms_group_role_rel` VALUES ('5dea104a2bd04384a92fd1724cf50f39', 'c5925376ecb74887b35fa93590e0b435', 'e20b077a9fae47b58f92048225cdfdba');
INSERT INTO `upms_group_role_rel` VALUES ('5e3ba8bdcd364957ba477212909399cc', 'e78df0505254408baa5fe10f286af06d', '1aaa07d2abe9470ea0e960dbd7b21d87');
INSERT INTO `upms_group_role_rel` VALUES ('604ce5c1fb9a4119857cdccd13e22eb5', '56078118a2db43d0bc3df0105cfacd41', '15b41df1537d4a79adbfff2f73ec7602');
INSERT INTO `upms_group_role_rel` VALUES ('60c9c73f47ff4884bc2a87185cf89fc9', '943b2b4a166a4b36bbf3de45aef2e7bd', '70eefe63d3504620bb67ec21a8e315d6');
INSERT INTO `upms_group_role_rel` VALUES ('60cf6e8dd156424db8ce184c4556e4c3', '40195d0c73194ad89735088295d72104', '0c028f40bf52423f8b87521ab5ccb714');
INSERT INTO `upms_group_role_rel` VALUES ('60e63370c37842979c0c6dc86e42e915', 'b4bcfd602fcc4522aa3a07d08965fc71', '4283a18f317745a9988188971e72a6c9');
INSERT INTO `upms_group_role_rel` VALUES ('61c7096fe6e94f20acede2f03b4f39b5', 'b59d04e5dfc14512886cfbd7b7eb7119', '3a99f56bd1d04ec3b769e9f79c11037e');
INSERT INTO `upms_group_role_rel` VALUES ('61e5e3c13c3945be89b4a7fe917e1a84', 'b97ec67cb0a64f39b3e5bb4db3fb2c5a', '461390f29aeb4440a00a47c18773f76e');
INSERT INTO `upms_group_role_rel` VALUES ('627358e6919543999b3cb37a41b9e294', '4c6f0ec708c0431eade1040fa5228bda', 'acf0873cfbba4f6096409554356e1111');
INSERT INTO `upms_group_role_rel` VALUES ('63caa717fa38406aadf1b45a0ca0ac4b', 'e6ba5bc65a8a4a388829a1058dbaeee3', 'e4993b77194e425db3804784b3d748cd');
INSERT INTO `upms_group_role_rel` VALUES ('6404470a15684ff28b0b85cb3362e445', '9229ba4e01ae45649b3ebe70a366995f', 'b9fd52aee87e4e889f5d6e7f53333c1f');
INSERT INTO `upms_group_role_rel` VALUES ('6443f9bc3b17491f91399bc647275b8b', '658efec9e14148bebf8ab2f9ba4507d8', '3aeab9ae28f1478ba65a5d176f59ecd6');
INSERT INTO `upms_group_role_rel` VALUES ('644d511fc7aa4802b3b1cac7a4ea9255', 'a3d5acd41dd14592ae34cc893c9024ae', '3682da565d87405494b907feee6ed927');
INSERT INTO `upms_group_role_rel` VALUES ('64dac9c7603446a59d72f0575d856bc6', 'f345c67a2b804bffb93ab497fb9ee9ea', '7cac12da38ca409da88c5c348df2796a');
INSERT INTO `upms_group_role_rel` VALUES ('64f1dcf001354924b387d069b741428f', '13caca754b544b03af6d6c14c9fe5885', '5145cdc23045411792b2a43c2914d5f9');
INSERT INTO `upms_group_role_rel` VALUES ('657944af001347169751489199bbd269', '98f6304ffab741ff8c27fd1f2ead7126', 'bc22deb2ac2f420781117102ccc5cb7f');
INSERT INTO `upms_group_role_rel` VALUES ('65845308c18748cd9ff26352fdf5cc76', '547af7394d894617a1400dfd7944c2b3', 'e6b911e5dcd0482d847738905aa3c511');
INSERT INTO `upms_group_role_rel` VALUES ('65e68da660cd498aafeae3452c797b5f', '6be037d053a64eb6943e0bea8b95311a', '8ca39751359648a7a01a97dfd0ad50a1');
INSERT INTO `upms_group_role_rel` VALUES ('673a8a5e5ca04bd986b9e504f6fa2751', '380038bd89bd4400812aeae5bfb6a22f', '641ad294977e42eab5ba71b9ba9e79ff');
INSERT INTO `upms_group_role_rel` VALUES ('676b11e6dfe84a738351e651212e6c10', '608bdb9fe5014575a324aa1ab51c369e', 'a62f3926c9a24d70b80e76e09d0f5212');
INSERT INTO `upms_group_role_rel` VALUES ('67fef6d5b13543c9900094294b8d950e', '65d821e6f69e4ae29e53dea47980ea09', '0ef8ec75e4f44a579b244099cda7ba3c');
INSERT INTO `upms_group_role_rel` VALUES ('68542da34735407394993c19b3417baf', 'bcaf8f4933d34a95a57cba930e484b08', 'b4660eb58aea41a3aed39cedcbe6cd72');
INSERT INTO `upms_group_role_rel` VALUES ('6915e3296bd4484cb421cf79c32c5362', '95c2cbb6ad134fcebd5194d32cf61fbb', '356c5d74e7824d5c92196d3aa89e0d26');
INSERT INTO `upms_group_role_rel` VALUES ('69bb6663c3e94f1ead20faf8c1f9e131', '5332689530f14d9480a5f94ea8373c25', 'b4c84c66180642f09ea47b5202b7f826');
INSERT INTO `upms_group_role_rel` VALUES ('6a0d0a0deb5c47e78712ebb5d6658aa9', 'fee5a0fc90d24570a1c5748bdbde7acc', 'b6e4fc93ce4f4967aee08d03857fda47');
INSERT INTO `upms_group_role_rel` VALUES ('6ac46d9eb73d47bfb58c24419a17842f', 'cfb71e879f2e456a802ba05de59bee70', '33e74b87391b4864842e7b2c2bea09b8');
INSERT INTO `upms_group_role_rel` VALUES ('6b1876457ba444a0804bcbef1908a521', 'c05a319c29e34ff7a78ace6392b6c62e', 'c2110449aeb04426807c8f47be3430d1');
INSERT INTO `upms_group_role_rel` VALUES ('6b77bc56d5e4411b9fbe339a8aa8bb0e', '5685e116d7b94e25b03f8e83ace1d6d3', '1527091acefe450595c18640ea9c79c9');
INSERT INTO `upms_group_role_rel` VALUES ('6d5ee37a3c3d4a189fd86f7024727d79', '19f17b22b9c845b190cd06f25d61db41', 'c3b0f5e7f99546169ca7ccbc21d1ff45');
INSERT INTO `upms_group_role_rel` VALUES ('6d92a00bd73145588b920b222b16e848', 'bc4c0c86528c42a4a2af595e0aee1ce1', '7805c88188fe4fe8a4cdeafcb1c01a99');
INSERT INTO `upms_group_role_rel` VALUES ('6e04f6d6a9bd4be6b91d0da2f5cc5ebb', '4b28409e90fa4a27bb13aec841894431', '3b44935849e64c1381ce999a51779d2b');
INSERT INTO `upms_group_role_rel` VALUES ('6ec247644ba848978854b869d0a587ec', 'ee37ed3754b744b4a84ea85c3ccf49fa', '87c76433d0ab47b791352793313fd9b9');
INSERT INTO `upms_group_role_rel` VALUES ('7050fdf534bd4ce5aa456ef53289ffa4', 'f42fc64941a4475f83a568863156df3c', 'b12b5dcc5f204f5e91fac7e42ac6246b');
INSERT INTO `upms_group_role_rel` VALUES ('71bcbf9374454a9f869ae171c1204b71', '78fb80b776e84f098228c4afe4b24c4c', '609934574d9f43ebb08cba0194257187');
INSERT INTO `upms_group_role_rel` VALUES ('725b3197aa224f2fb8f28e0a79fdbe90', '4005fcdee33f43688bcc0b582fccc421', '89fc44bf5f554886954fc3c7ce1dc002');
INSERT INTO `upms_group_role_rel` VALUES ('73fe4781e27643b69c2c6048ac575d06', 'cc638b60c9be44c8aba0f4dc7349aa34', 'd85c050a389c4338a58ff03a46be6ba3');
INSERT INTO `upms_group_role_rel` VALUES ('7467ff032e9d4c8c896499bc0380fd8a', '25afa3d75c274fcbb80694ba25ff7352', '153122622aa44ec192b6e5e59eb41a0c');
INSERT INTO `upms_group_role_rel` VALUES ('7474a97e6771472198d8deb57d36be06', '720d425488034519a066947aabf14c36', '3cc3e7d44ea04a00994fa2826fe3f3df');
INSERT INTO `upms_group_role_rel` VALUES ('75256429a50b4202abad0a015f1b65c3', '56637f2fc344497eaedb13eb92f4ec21', 'dcb6a1984b784383b695b10bc9aa64f1');
INSERT INTO `upms_group_role_rel` VALUES ('7565525378074eabbd756c23aee76d85', '6b5a7c5338ed46838bb000197d0af99c', '24100752dae44fbdb196f85022468d3e');
INSERT INTO `upms_group_role_rel` VALUES ('7566e4c28afa47dcbb20bc120f9c0b42', '8b974447c492469b85011eb21ca86ce8', '7438c782beab44918e62d2939d19d188');
INSERT INTO `upms_group_role_rel` VALUES ('759584bed6e14e19bfaab0fb9dd2c5f0', '1fb08af16b6348638796e62f596b912a', '34ee90365a014dcc9e6be67d4a2725dc');
INSERT INTO `upms_group_role_rel` VALUES ('77eac799dd9940a8afa515e8d76553d5', '5e962a7d44b14afea6566ff5947d99d3', '1b957e6415004f95a156bd7b6bcbf0a1');
INSERT INTO `upms_group_role_rel` VALUES ('77eaf8d04d36443a85982b9585eab5cc', '7a4b137203da48448e448fb4e3a98665', '32eff409013f4b7484bda75ba1ff6461');
INSERT INTO `upms_group_role_rel` VALUES ('789a96b4cbc54f4e997c460d60d86236', '99617e0902f0412b99f9f785de9f10c4', '152b901ba01d4267a54812d94eea29ce');
INSERT INTO `upms_group_role_rel` VALUES ('78ee56d82b9b4ef7aab2e53c4aeedec1', 'd6aeced957834073af4888e086910c11', 'd5f2532cc6654573b1615fd81ee6222f');
INSERT INTO `upms_group_role_rel` VALUES ('78f118006d89427ebd205ee52a6f2b0a', 'd57ff08b7bb448118a79f6e2a43ef13d', '0835eb1ac3394613b27017c7acc318fb');
INSERT INTO `upms_group_role_rel` VALUES ('791eb642019441e7859bf1d5fb4a5680', '5db569365820445e85a56fb8b3ce0d78', '4280c4feb9624a47af7ae943f020d782');
INSERT INTO `upms_group_role_rel` VALUES ('7976e279c0c549349166a38cf074067d', 'c4a749535ecf4d8c903146f11faaaa87', 'bdcf01cdb613430f8d3da0aba148dd2c');
INSERT INTO `upms_group_role_rel` VALUES ('7a27070192d2420599f34a77012e228a', 'e6df14da683342cca6f034a551a07e3b', '51025cb27f274d68bbf03bb09c4b3bac');
INSERT INTO `upms_group_role_rel` VALUES ('7a43ac6d394c4f2a8ed161c8bd862638', '88d6f7c0fa4b480f95e327571c75fc34', '4f5e4cedcc2e431c9b2507d27f7c1904');
INSERT INTO `upms_group_role_rel` VALUES ('7a9d001adc11409ba350d51c8639821d', 'ab3c70d52f2c4368b2773a51dd3f107f', 'd9ea56b5778b4649a6bc5cb4f5688c63');
INSERT INTO `upms_group_role_rel` VALUES ('7b08e6897c2049ba8d9c8320435c8148', '894e6bbea5244e4bb92ee49835b65c71', 'e6d9ad65e7ad448e904871465c377022');
INSERT INTO `upms_group_role_rel` VALUES ('7bc039de98ae4ef2840b84e6c83faed6', '56d0c858f9ad443b818ff38c5853054a', '216d62ad953c4868930182bab9d11d8a');
INSERT INTO `upms_group_role_rel` VALUES ('7c47443c22f944cd82442f43270bfa4c', '74a79b8d049d496481e7958e3bfa76a0', 'a924e53d525d400ebcff9d847574386d');
INSERT INTO `upms_group_role_rel` VALUES ('7c6052a101214043b8d8e7a21448e68f', '00a4875458fd4f58aa74f313093afa5d', '42e6428bdd3c41d6a7809f72cd784aba');
INSERT INTO `upms_group_role_rel` VALUES ('7d7295804aed41999b40a10ce1a8ad95', 'c0625a3e3fac4763814e039189f18393', '0e32631fecb34e62aeef46bb33eb7d82');
INSERT INTO `upms_group_role_rel` VALUES ('7e812458f7d74777932fffbbb828001f', '9386490baaed4f1fb363aeb5a511c33d', 'c2d2c077e0264ea29c7e265f148da155');
INSERT INTO `upms_group_role_rel` VALUES ('7f49211a1f8642fb817d0218781ff197', 'dfcb08e6b4284a9b84fca17b3a0ace1a', '4fe89b2b240243098f7eb723e58a7243');
INSERT INTO `upms_group_role_rel` VALUES ('821f1d3ccc644a899a0bbf665b12c194', 'f4603457f6f946a5a05a872ca52a0967', 'bfa862869cff4317bdbd21edd46e741c');
INSERT INTO `upms_group_role_rel` VALUES ('82223ca75b2e442790c7b16c0fda51a5', '95183ed0dcd44c97ae4d77ca49ea31e2', '10e53b766baa401181d03b1e9d0f119c');
INSERT INTO `upms_group_role_rel` VALUES ('823d1921aa23404692bb779d352c81db', '85cf93ff36be43cab52cda76438a4b51', '165e3ff0f5f6452eb258c646adff1645');
INSERT INTO `upms_group_role_rel` VALUES ('82d347c9976f4834a7369ebbc2115bed', '613417c2fecc4412ad8e6e0c5d6f9b4b', '3eebf99f38674aa999117f8dec8cbe79');
INSERT INTO `upms_group_role_rel` VALUES ('8304b3f39e8642c288f0e08667cfb8df', 'ab45cbde981a4fc08c740e5ac35e866b', 'bfc0d53238a94c7b92ca17d083e617fc');
INSERT INTO `upms_group_role_rel` VALUES ('8366861e16834657a856549cc7e5c1a2', '33605916e8dd46d2a0f5d2bc77e35ee4', 'f5ac87f0109543f8a596cba5d7ed7a1b');
INSERT INTO `upms_group_role_rel` VALUES ('83f28e19f94847638129dd4fbd0e3c8b', '7e221cc4c1e6481080807bac0404d958', '38f359600b514fa1a8a2933fb0550f34');
INSERT INTO `upms_group_role_rel` VALUES ('85644ea7945f4eebb0dfa6c3a618a7bf', '30ab3d186f474106b41c6b1a8b55df39', 'a0f0243ccb20410d8b99bca1dbe46de4');
INSERT INTO `upms_group_role_rel` VALUES ('856a1f59d2a045e4b2ac2e1e307cddc1', 'c151e5a442164d5caee48679ffb819a8', 'f3bbdc7342794f12b90951755c8f0f9c');
INSERT INTO `upms_group_role_rel` VALUES ('8574ed2de1bb44aab3a0f7c1c314ceed', '5ce5163aa8024f1db986396b7d825daf', 'b7630cc73bd9452fb0f3c783c882ee98');
INSERT INTO `upms_group_role_rel` VALUES ('8637dafcca89476e9630ed8bb3167275', '3568e49c72f74afb833185dae9df23e7', '4fc49eccb9e946a789470e21451687bd');
INSERT INTO `upms_group_role_rel` VALUES ('86fce657199340509380cc7fb514cc1f', '7efd2365af954356b1c3543320198a87', '383ab4208a024d2e8604a2d817b6a1a8');
INSERT INTO `upms_group_role_rel` VALUES ('8829c7e68d8c49c79b552764d9b4b72b', 'c3e5ddf1ff784341870645d1c128789f', '619100ceaa5043fb9ef77cbded0532e7');
INSERT INTO `upms_group_role_rel` VALUES ('88da08777f044c8596a7cf34a4170cb6', '1cb6c74a51a54faf9a911ee814ec98c7', '0e38045c622f4994ac4f3ae194340f28');
INSERT INTO `upms_group_role_rel` VALUES ('88e14675de3543b59d229a0f1c6f7f44', 'f59a88a3faba4922b81545fc34337618', '2ab27f47929f410ca898f4dd09a84907');
INSERT INTO `upms_group_role_rel` VALUES ('89734695e34748d8abe806374337273e', '2a26f13b75c34b2fb64d5cef896dbc36', '48e6face92774dd299f4b7f4620a31b3');
INSERT INTO `upms_group_role_rel` VALUES ('8979e1ecd6ef425ca4c43e031dc87dec', 'd7a555098a734d1291638f647ee59406', '5e639e74f83a4f3d93a89b5aa0726990');
INSERT INTO `upms_group_role_rel` VALUES ('89c61bf2a62e458799ec61f541e03107', 'b40ebdb512264b1c8813b9d2123c5da5', '9e7c249ef7be46d2b3e3a0d3af2bc0cf');
INSERT INTO `upms_group_role_rel` VALUES ('8aee59ae13f445b9add6eec6fe29a3f5', 'bbdbd482ad094c1d8bd8eea3944fbd70', '774f612416d04335932d8346e424421e');
INSERT INTO `upms_group_role_rel` VALUES ('8afe45853951424bbd52d5b3b2200bdf', '0e72d8e0e8d146cc8004a66687f43b97', 'b960025c31f14b73ad09767cc1a3e3b3');
INSERT INTO `upms_group_role_rel` VALUES ('8b5956a132474f7785a6c1f915ed89e7', 'f1618584a52e48f29ce6e19ed7e7a294', 'e971063ec20146c380ea960e3e5b3b02');
INSERT INTO `upms_group_role_rel` VALUES ('8b706bee24314a70a019a77ba8d8f318', 'c3d19f1b62b745da81168b7cd277d772', '08e24867995148cdbb05b16dc08fb7f2');
INSERT INTO `upms_group_role_rel` VALUES ('8c3857d595e64eb2ada3773bbb8ca7b9', '34219308ec8b4dcead81a51459d291f9', '7269195822334e38b1eff4d32fa150fb');
INSERT INTO `upms_group_role_rel` VALUES ('8c5c27edd3e44fa5b6c6b27645558c46', '20d66d7b8a684e65b3bda666084b0c05', '08596d06ced74c7a8f497ed2325b2dd1');
INSERT INTO `upms_group_role_rel` VALUES ('8d0ab6379560424c8953051db830e598', '61d622523816449f83bd5714edd3f1e8', 'f6e14fb7f410402cb9659fb11940ffba');
INSERT INTO `upms_group_role_rel` VALUES ('8d44a551034d4091ac8640b84e4c9d84', 'c986e206befb45538ccf95d271b7fdb0', '3892fe7ace2840fa8be37ed4620bd6b7');
INSERT INTO `upms_group_role_rel` VALUES ('8e050aceaa3f476eb31e5023e03a55a8', '477bf3af9f2349c888d96479ac6e5a6d', '5e329fb7c9834d459be4b06b63bd6a07');
INSERT INTO `upms_group_role_rel` VALUES ('8e36406dc81c4529a53be9e3d2eeb682', 'bb28ae65d9a1480496f3c1cb7db03868', '8656911197bf485fa0143dc4a5501cb0');
INSERT INTO `upms_group_role_rel` VALUES ('8f3718e822df4b1f91950422ac7dabfd', '45af8ccaf384491ca07c1ad2ad6256a7', '1b8fd3c7264e42889a60a33041970ec0');
INSERT INTO `upms_group_role_rel` VALUES ('8f4e82be7b944b7994821c7358679593', 'ca657dc11f064b9bb70b124c3982f686', '7804ba1b657d44899b2f5cc242bfcbf7');
INSERT INTO `upms_group_role_rel` VALUES ('8f63fc6a07f644ac82025ca9f4791afe', 'b268eaaad5d64ad289e47d9a6fa5ee84', '1749d032c6ce4bdeb4a05adad02af2d7');
INSERT INTO `upms_group_role_rel` VALUES ('90bc100e7c30472b8f655bea01f7d8a1', '82a8829384bb47faa54d920ac746660a', '9cee575da6fe462097b834c2cacb502a');
INSERT INTO `upms_group_role_rel` VALUES ('91c5389953e04cceb34b810376f76791', 'c91df667b7f8453ab8c5595b62c11d63', '22e6c48b670241d99dd2c84900523825');
INSERT INTO `upms_group_role_rel` VALUES ('9202a536f0d3474cb1d4f44ea40c5b33', '75a16554e88140928a7163e908041854', 'c64bbd9b732b4aef822a799c2f0c64e2');
INSERT INTO `upms_group_role_rel` VALUES ('92177b0792ac47f2a554ae3a9df41b85', '174aadafcc6e486c8ac8ad50a07bb70f', 'bff1c3a9d4ff43b1af04bdae8b92fc32');
INSERT INTO `upms_group_role_rel` VALUES ('92ab7d6687a640408c8137197c94099a', '21c7821e69e548de90112ecd72def5a4', 'fac5151f4eaf4576be4bc5a48a6636bf');
INSERT INTO `upms_group_role_rel` VALUES ('92c4385e9ec24bb58dd1f2adb1b38384', '1e9e888c206a4669859dcb7d1a0984c1', 'b60288a6270a4a0da27fc3550e5370ae');
INSERT INTO `upms_group_role_rel` VALUES ('97bb7e31deed4092b3fdda7043564799', '4cc30e1b2ae646b8800c4286ada45fba', 'dffa612351e84fb59a2c199bb92b1a8e');
INSERT INTO `upms_group_role_rel` VALUES ('9a5cf496708148c9a54ac8edc2c4a1a5', '3712661859e640c998e5d06c6689a869', '567fc86f2eb74173895649cfbe53ca57');
INSERT INTO `upms_group_role_rel` VALUES ('9a7731aeff5143e98fe97a26e648304b', 'c290b0c24d704cbcbdc5af01c8d77f29', 'df8ce25532444b3794e08970b20d8ad8');
INSERT INTO `upms_group_role_rel` VALUES ('9ab2dc1be49d4619b557b8a910262473', 'f53d93a4a4774cd59de3b68e2febe99a', '5ba4ca4cdd9f40f3b744d9b176092fc4');
INSERT INTO `upms_group_role_rel` VALUES ('9b820b51be3f45709400f84438a24057', '13c55ed3ec4749e48c9c3aba8261d8a7', 'f44d28836ef64b2f81779c3bc6f9add5');
INSERT INTO `upms_group_role_rel` VALUES ('9c532a4d03844579a705a6eba749c891', 'ffdfd5079fb8458faefab5065cb07bc3', '56f13d2df0cd402e86660b39caf4b436');
INSERT INTO `upms_group_role_rel` VALUES ('9ccf3aedc2ba44a497a597d7d5ec61f7', '4eaa7d5ae101492f9fcfe5056c36d0d6', 'e3c2cd4b1b3041c69898ecfeea040ac2');
INSERT INTO `upms_group_role_rel` VALUES ('9cd08f8e01aa48b7937a116467dc29c7', '84d834cdcda04903be84b6bad6b7c8b7', '5f702459e520447d82ada8e69f80aa94');
INSERT INTO `upms_group_role_rel` VALUES ('9e32d678a70a4b3fa63222cfcc6cac3d', 'd633acbf27a848e08e8bd0220c79b92a', '3abf7132896a42f7be3bc5396ba03d4d');
INSERT INTO `upms_group_role_rel` VALUES ('9e72e2aa83614585a2e479ea4d7f6710', '7faf49dfdc3144f2ae44a233c83f1a1c', 'af837f257e3248ce98fe3bf053fff020');
INSERT INTO `upms_group_role_rel` VALUES ('9e93d0fe63b4465dbfca0c443a00e367', 'f49ccb3c36344026984e459de43f51b3', '16844757c6f54715b3f533f94ebe93a1');
INSERT INTO `upms_group_role_rel` VALUES ('9ee236c9828d4ad98ddf170beed9a178', '8c440b81233b4a30981cd0f271829c4e', '2730a410cac843049d39cde70cf139b4');
INSERT INTO `upms_group_role_rel` VALUES ('9f3420b0df7942f6a48c69ef4284c272', 'f431ec815b0a4678b633e048f3d60359', '76aea37bdc3f4c21b7de17757c759289');
INSERT INTO `upms_group_role_rel` VALUES ('9f7fde3daf7b47b0bc1614e2baaa6065', 'afb27bf581874ee582f5381d9cfd230f', 'a47800bdf96840498e1ce72501886206');
INSERT INTO `upms_group_role_rel` VALUES ('9f8582e52538422ba8a38ea7b04092a4', '791cc9c0a2a24b0c951ccc2ee2572ac0', 'ae4d4d828f484b0a96d855a75cdf20ab');
INSERT INTO `upms_group_role_rel` VALUES ('9fb0907ea12a4c8aa481c671d6680c4c', 'cffb70c195944b46bf8bbc4a7c866e9c', 'f301384a4fe84f52a83962abe44177da');
INSERT INTO `upms_group_role_rel` VALUES ('a137d7f0059848b5a35313f26ed423f1', '56dc5d2ceecb4ecf814b2b021fc385d1', '808606bb26434d0fb0d0273dd1599e1f');
INSERT INTO `upms_group_role_rel` VALUES ('a1684e5d2ed94291aee185bc19b715bf', '059b941d5f6b4e088af6241d84b97262', '4893fa2bee154ad594c05c9594e3fb84');
INSERT INTO `upms_group_role_rel` VALUES ('a20fdb9e47a4481ba6d5e7a34e716ae7', '176bafef94184f1181d8c94fd017b07d', 'fc38a9fcfddf43f8acbf023d219e677b');
INSERT INTO `upms_group_role_rel` VALUES ('a36a695bdf044a2790a31b668125fe2d', '491dcc4b81244de7a8d1983665df3687', '778844b5b51244ccb0521e691409dbf4');
INSERT INTO `upms_group_role_rel` VALUES ('a4d60d650cca4b47a054a5db0c80efd0', '448b94a6d3da45079e929278f6e5f966', 'e1635d338d474316b898abf8cef9f4ab');
INSERT INTO `upms_group_role_rel` VALUES ('a56c3237290a459582f25bf6c42ae7a8', '5c99507b66f14c5182cd089d56efc203', '6998218d922e413c8d9c0a6cc5680866');
INSERT INTO `upms_group_role_rel` VALUES ('a59852598d6e49679ee68f5a2ff1e32e', '69ee7f7afecc4e57800db5602063da61', '0a27f27188ea422095717a3c8d34cf10');
INSERT INTO `upms_group_role_rel` VALUES ('a5b803837a9d42d5a5ddcd954b467adf', '761aa0e60cd64e2cad53dd796d86cb58', '85670d102426490ebdfa08b2b13446b7');
INSERT INTO `upms_group_role_rel` VALUES ('a5dfcc84eb7e4dea98dfb1a7a914fe0c', 'ce404a7f710441e3bc9330cb146637b5', 'bfba279bee714e569dae0527538e3fd3');
INSERT INTO `upms_group_role_rel` VALUES ('a6a63ce0f251489c8596841c9020eb7f', '893ffb51e0184b14895f9e50a745e708', '6f7a69e35423435ea85b682381ea025f');
INSERT INTO `upms_group_role_rel` VALUES ('a907d843ef934dbf9c4be0bb1545cd27', '3dcb67d3283440669a02aba6856d5e15', 'e537adf15e7044049ab2a1949400ea50');
INSERT INTO `upms_group_role_rel` VALUES ('a90ec89052e947eeaf34807f0ecf33d2', '60fb3ecb806641679515680c0fa2c152', '178490f446f446bb842eecba54c9bc5d');
INSERT INTO `upms_group_role_rel` VALUES ('a9e056451f5d4d28a5ce5dfb0e496d55', '58db466861994e45b799fed42e54eccb', 'caa3d909fcea461c9eb3c5f0c6361eeb');
INSERT INTO `upms_group_role_rel` VALUES ('aa187c6e2c8e427184ebcaa6e631b9e1', 'a7d5072c9478402bb067df6576bc3120', '756bd9eb862142b8883ad8d4c6a655d0');
INSERT INTO `upms_group_role_rel` VALUES ('aa38618369d5418c865034b95ddf0f5a', '7360299ea7e443dc9379e0fbcf00423f', '6a068e45c555466b9dc567fd36b5f33e');
INSERT INTO `upms_group_role_rel` VALUES ('aa472ab85c434b8da53b03a4e99ed295', 'ebc5d5940f2b41b2ac0b070c3ef19413', '8c8e1d5913b14971822632eded135016');
INSERT INTO `upms_group_role_rel` VALUES ('ab7b73d8c11e4296b5cab6ff5d9dd63d', '8da923d6c5d74246bbb8a47048edfcfd', '2ee321326cba45d785538f97a4732c9e');
INSERT INTO `upms_group_role_rel` VALUES ('ab8e50b4f44f45dead2a1434090bdb35', 'fa9585db8e2743a3baa6081496a73ce5', 'c02c8e7e2e90445188d8fd0b7bacaca1');
INSERT INTO `upms_group_role_rel` VALUES ('aba1ba47a8c346d4a95345a4dac86604', 'b1929fa8d1b447aeb054f6da6c6a8077', 'dc97199c66424d6c9b4fc995c6e9fe7a');
INSERT INTO `upms_group_role_rel` VALUES ('ac225802a22c4d29a0cefc067cbd1cb4', '10998c1197dd4fba8fe3979b4b81802f', '33a2ed1613c14194942db2629cfe366c');
INSERT INTO `upms_group_role_rel` VALUES ('ace2e799d6de4dc6a1d63586667dfaed', '1f2a367be69940ab8c498de4f4de52be', '72b08285968a477b9625f20e49dbce34');
INSERT INTO `upms_group_role_rel` VALUES ('ad94a89f7d0e4ffbb422b652026ecea3', '3bbe419586074a87b7d74083ad9925e7', '1ec84926b4af489e9d416916d537877e');
INSERT INTO `upms_group_role_rel` VALUES ('aeb223e0c84b4eeb8b80ba339b34dada', '6848750a7c9d4ac3a91f3311a7b0e685', 'c63e24aa533a4f219fb0376d128c667b');
INSERT INTO `upms_group_role_rel` VALUES ('aeb9982f1a3c4bc08c892e3b900d737c', 'ae86c63f79894070906d1cd5a0142912', 'c942b45b361f429995fbbbfac7255fd9');
INSERT INTO `upms_group_role_rel` VALUES ('aee5c4bcfa534bfab7422c2d97e23e37', 'c5305c301c73455a8291aa8cf831b0e5', '6fc452504c8141d9b377316f45b84754');
INSERT INTO `upms_group_role_rel` VALUES ('afcae1f3d3574000a767fcfdacf85a67', '70e86e1dda1644a38a9129a2e06bf1ea', 'e53cd62069d744a290195667a10561dc');
INSERT INTO `upms_group_role_rel` VALUES ('b070e037d09e473bb1d073608231b9be', 'bd730b12e1c14057ab6de993e66c3dcf', 'ad65fd958eb641e2bb64abb7b91c64fd');
INSERT INTO `upms_group_role_rel` VALUES ('b09b53ffa8db4ce986b81f617e40a992', 'f8ac9fa27a9f4587978ac7fe075da4ec', '52374d846eb040b2afe067a0d9495fa7');
INSERT INTO `upms_group_role_rel` VALUES ('b104d703d38d4a1eb4b170c9ce0b6380', '41504a68f8d24b3493d5b7d54e2e59f3', 'fe4d1450eb754176a131ac2212027c9c');
INSERT INTO `upms_group_role_rel` VALUES ('b1f7ce7fa20d4a82b526e6f3bfeab4f7', '7fec7db175fe46e98f41457e08c196bb', 'a754d112196947689c5e12d85a511397');
INSERT INTO `upms_group_role_rel` VALUES ('b212e50deb4840f3967fe827ac9ac9a6', '97ec2688f7734bf7a93e094592f46e2f', 'b48deaaae5174b49888495947b955063');
INSERT INTO `upms_group_role_rel` VALUES ('b249a94b06e640ac96b9942739e7e6fc', 'ce3f5cc9481345edbb105d4b05fbd53c', '467b835126414013901ed0e70e8e68ae');
INSERT INTO `upms_group_role_rel` VALUES ('b37a9b11dfb040fcb1fdca69427188af', '3621ff91a1c0461c9bdbdf3a7a02e6c6', 'b0e3a25c9f8d473884174a54cbb4de77');
INSERT INTO `upms_group_role_rel` VALUES ('b4c809dedd06444aab08e634c41a2536', '8c268c2d8ad1444b9c1cd4361c7f58da', '152d5e5d1281472e91cb14886351eaf5');
INSERT INTO `upms_group_role_rel` VALUES ('b5bbf1008116442c9329d59cb91d15e2', '7f15e660b1df45eb8afedad5b7db8af9', '4dac6a3538b948bcbbf75b802699878c');
INSERT INTO `upms_group_role_rel` VALUES ('b5ce1bebb4a440a48c3b7c4b0d01731d', 'ebf2c59ab42c453f97d4b168ce224197', 'a1bfa2e589144a118aa9a0e80f1e7730');
INSERT INTO `upms_group_role_rel` VALUES ('b630761b104a45039581b526ef5faef9', 'ccc887987cf2407c9dd95a7199e119cb', 'c116cc01a2e3403c9ab5f9d4a8161895');
INSERT INTO `upms_group_role_rel` VALUES ('b7272239523b48e7ac480ec70655175a', '0036d0a361b64f2badb0797db98d28d2', 'd19e3095ddd54a9288d7d3d885bb6860');
INSERT INTO `upms_group_role_rel` VALUES ('b76da5d2bf224eb792428f9622ddacf5', '604f41e7f38c40f0912d106860f0d37e', '3c1b0438dea44eaebe21c707abd48ab9');
INSERT INTO `upms_group_role_rel` VALUES ('b77fae1632c14ec598c5b5ac325da283', 'eb8710cadbe441c997731dc9637880ec', 'f52491f18bbe409c97e8d3e23cdf6714');
INSERT INTO `upms_group_role_rel` VALUES ('b89a546cf46b45a5b5eab990e8717eea', '50b85cb068194ac287c9cc0c7f990cae', '2697546a040146ebbc220556469d5f87');
INSERT INTO `upms_group_role_rel` VALUES ('b89cc8bc5aa741de8bfb6c2593c7e089', '54988fa031e2477fa1cf9a4033c74059', 'e54715e3187c41f0bf5bebb54b29fc0d');
INSERT INTO `upms_group_role_rel` VALUES ('ba01ca9e88fd4157a897453d1134b82c', '19bdce0c5bfb40bc8fa56e4218dc3e6e', '5420f32d48ef408684d191ca7da9b5ea');
INSERT INTO `upms_group_role_rel` VALUES ('ba276da4d3404cc19713a4bf66aade75', '07ce8219093d417ea22567bc3a77b540', 'adc1aaa7b37741e8b636452fb4698f92');
INSERT INTO `upms_group_role_rel` VALUES ('ba5fea7906f047df816121a8a9bc86e3', '8a0cf422116940a3a6b431de6045e423', 'c5e1f7e2588a4df38e0d6350d64bcede');
INSERT INTO `upms_group_role_rel` VALUES ('bb05dd4f401742c199fdc06acd5e8707', '33e7a97ee3574cc784929b4d984a49db', '889de2553ccb4b8c8cb346e531dc2ba8');
INSERT INTO `upms_group_role_rel` VALUES ('bc8e233078ca44a891ed1b74f98e5a47', 'c7221e35841a473ab3ffcb7b3f5cf00e', 'a9d9813da91643dcb341d0742afd48d3');
INSERT INTO `upms_group_role_rel` VALUES ('bcbe92981b8c409c9b38fe3545014d1a', 'b3f8f4a5b534422dad11da6cf997f166', 'bf8ab03ed46447a28cafb29b932f4ce1');
INSERT INTO `upms_group_role_rel` VALUES ('bcc7a7f75533425cb6348ca03b1aa483', 'e277b3144db64776bc37bb51be0c56a2', '62663ea1f0e141b5859f13be82c26bb0');
INSERT INTO `upms_group_role_rel` VALUES ('bd78cc0f30ef4a3b989098a6648cc93d', '3f8013978e9a4d029e1bae3ebdcc9ee0', '98f3f3d2870448fd8d502484b8e8e8a0');
INSERT INTO `upms_group_role_rel` VALUES ('bdaa4f444fe64d49a6a34f6f926b2d17', '9537c4bf2ee44dd2b93865d1235780d4', 'd78e109415544a498ff4485d734c7238');
INSERT INTO `upms_group_role_rel` VALUES ('bde2b940e8c4402bbf46dca7a9899326', '5279285c406a4a8ba489f50dbabd7d92', '9632962315eb4667ab78b6bf609dfbcc');
INSERT INTO `upms_group_role_rel` VALUES ('bfb57205ae1a40a898a0a4204c5c60af', 'b21102d5217341a3bcb4f0d07dc9a5c8', 'c215f51f08734f9ba9165a40b3bcb19c');
INSERT INTO `upms_group_role_rel` VALUES ('bfbe0bb3d3d54bb3819d27040602b58f', '806a7bc1372b4bf0a14a88625da8fd03', '1e7f6648105a4ebda5f53d20235554ac');
INSERT INTO `upms_group_role_rel` VALUES ('bfefd7587e874d859834017c24022316', '4128160cc28e4193a7c85750d772bc1a', '27e50a8aa21c4825ba7c684a20258cc2');
INSERT INTO `upms_group_role_rel` VALUES ('c01751b10f2e43528f7deda430ff7b28', 'a4c2adcc9ea44583a2531377a3f0021f', 'e93580a699ec448aa1ac9b76eba9bb0a');
INSERT INTO `upms_group_role_rel` VALUES ('c11484b78efa4c2895b616489b8cd83d', '5bd14054fa824da1a1bd37e60a777453', '0dd07bfe085a4c2289ddad53cd81ee41');
INSERT INTO `upms_group_role_rel` VALUES ('c1299aed392845b9868b67a86512e96a', '7e880600fa184735bcd3a1eaade07d94', '9ef8d89ccd0d4ec8a90d49d39bb89ff1');
INSERT INTO `upms_group_role_rel` VALUES ('c3b07c5cd7b04fbd9a318c550c56d8d2', 'b017303863604645b53afaeb35954b7e', '060d3a86c4ad456594c976aa2685ddb9');
INSERT INTO `upms_group_role_rel` VALUES ('c5821dec0aa64ba883c1a690b23dda7d', '6ed4d9fa68834886a4e1249942126c0a', '42a3dd42dd614929b6e1a0fe23bb4394');
INSERT INTO `upms_group_role_rel` VALUES ('c59389eec943433095f5bdc07f5da9d9', 'd3e8c614a9844a63b1e15dbf5d864aa3', 'c27e7912bfdd4179b17d1b002a44d5ac');
INSERT INTO `upms_group_role_rel` VALUES ('c5a2d7a4cebc46709638df2bf2cf4da6', 'bd4b39366e564dbfbd8be0df845f6317', '52d1d0b6cdb8493abb7dd7390176812d');
INSERT INTO `upms_group_role_rel` VALUES ('c5ea751beb7a4bb99d3736e85191ac51', '101a91bfce3f46e1a9b9a8fe0a55edcb', '90d0b8a8c7834b78ab92f12619e32a2c');
INSERT INTO `upms_group_role_rel` VALUES ('ca82c56c95f046ada0aaed78f009aa9e', '4594ad3c291e4402b02a368f6c9d2463', '5362c33ed0364d1ba3e359930c55f628');
INSERT INTO `upms_group_role_rel` VALUES ('cab99f9b3c2c439abe5866a57f48d851', 'bd3759b95dc24c3dae0da6acf2f44f60', 'a76d6dcce9ae4059bfba4840015465dc');
INSERT INTO `upms_group_role_rel` VALUES ('cba57d15c12d4ef3b96cc850132e18ee', 'bb3b241e980e498683d032d098483e90', '886182320ec9401788a71d3c3d7c5db8');
INSERT INTO `upms_group_role_rel` VALUES ('cbca2d5f535346fe9ae1f1eae8fafbaf', '7f047e4dd9474f15b523571670a45ed8', '90ad2884b3444b679c28f62cb2ac433c');
INSERT INTO `upms_group_role_rel` VALUES ('cc34408eecb64a878dc61601f442e173', 'dde377d87046430c9e8caecfe97a37ef', '8de4a94d14ff4170a1872630b55b624a');
INSERT INTO `upms_group_role_rel` VALUES ('cc80f019fd414e03bfc08d450494b8bd', '73c7a36e740645a28f36b742943e383b', '304b4f537e70443dac549579a2fbd196');
INSERT INTO `upms_group_role_rel` VALUES ('cc84bb56218347c8bc650c8d23bac060', '45ea77adf5c146fb9d81e944a80901b7', '0ff4d8f68b2445da881a4accc0892610');
INSERT INTO `upms_group_role_rel` VALUES ('ccb43e801b3846beb3701d9cca17eff8', 'c2e7e8dec9ad4b5b9adf0dfa6142d6cf', '9fab63eafe724de58695d4562f5e3db5');
INSERT INTO `upms_group_role_rel` VALUES ('cd1c1492efd64dbb907d0cc9934b807c', '6695d64659e74e04943fd50b04ca7e9b', '30f23717b1c742228faf153f3934272f');
INSERT INTO `upms_group_role_rel` VALUES ('ce062519bcb549e79040361ac2af2ebd', '57b0004c8de740d5acec827972a9ddab', '0243bedc267448568058c04f258bb177');
INSERT INTO `upms_group_role_rel` VALUES ('ce3d6abf6e55444dacede4dba8a82ef4', '28c17112c838445da98fe9f3eb3a3795', '94a2a009dd394b50a16b577d3111f0c9');
INSERT INTO `upms_group_role_rel` VALUES ('ce5c4c02ec2843f399cfa77246b17ba9', '79ca6c9ed23d4290bdf8993f669cd304', '4944bc0186be4abeb7f1f8295e931bbd');
INSERT INTO `upms_group_role_rel` VALUES ('ce75f634e9234b7988b309af3760e7d6', '5f9b00f0cdac4b4681aaaa903778d90c', 'cacd88d3948a452fab3c90d80f287f05');
INSERT INTO `upms_group_role_rel` VALUES ('cecd187c62264acab670ff4c9186e600', '78129c2e575044a0887ac5d9a29cd6b8', 'e584d7c1e0324704a9b6a07f115cd339');
INSERT INTO `upms_group_role_rel` VALUES ('cf8a50cc3641466c8c2cbce529efdccd', 'c95301da0e0c489390bbbeffb386409d', '5cbc16e61ca54ce1bd40aa7a1a5930f4');
INSERT INTO `upms_group_role_rel` VALUES ('cffb34d89a6a45a9b3d2c9d014705f68', 'cbb9428f0a644d85b001db7352b347b4', 'bf28e38b169e4f5695824e54a7b28726');
INSERT INTO `upms_group_role_rel` VALUES ('d0d69600611b4828858116adf9ed1c95', '8b7ab43e7b644d2caddcb03a6006419c', 'f2cf7c1524074b9381788e00c6485e61');
INSERT INTO `upms_group_role_rel` VALUES ('d2144a5cd95a428f82160e55363dd103', 'd644a4c22d3c4443b1f4cfa38e95fb7c', 'ef5a1cd8625f4b41888444d1b2388aa2');
INSERT INTO `upms_group_role_rel` VALUES ('d31a732c4d344e3cb922724f0790dcb8', 'f2b3b513bb60420d80c165349d3deff0', '5b80a24a1274424ebef7a613c5c65f2f');
INSERT INTO `upms_group_role_rel` VALUES ('d32771f7536a4ad4bd73459c7ad8db83', 'd4e40ecc744244458b88b6dc98d750f0', '3f0ecf0c9156466fb49dd7eb7e1bbc65');
INSERT INTO `upms_group_role_rel` VALUES ('d33906bd700246a28c6016b960cfbfc3', '69145fb26cfc458f94a78327eee98a3b', 'd821f13e58f34c00b7c35afeee1354fa');
INSERT INTO `upms_group_role_rel` VALUES ('d351ae0a7a5146b19083ec427a3c087f', '904693aa647949768479668867a7d36c', 'b433df6f914544e9b8b2c2ee8a3d8eec');
INSERT INTO `upms_group_role_rel` VALUES ('d355463b9d6e41f1855fae55f87e0f7a', '91b96ffb0420403cabeafe2abdd62f6f', '26ac8b7c076249949cb3526f5a847424');
INSERT INTO `upms_group_role_rel` VALUES ('d3e3744eb3d349d7adca3a17fce38c89', 'a224983f9d544311ac32b8a36b44cb3c', '4db2e49854d14d3ca3ff4fc7c77e6734');
INSERT INTO `upms_group_role_rel` VALUES ('d55c3f52d19c400d82eb2d7905c4b043', '0f468224928643d08f559d1b71d0ccee', '96eb75e4f93340558bdaec09d4c1c69c');
INSERT INTO `upms_group_role_rel` VALUES ('d67c49f13fbf408c92cff4573c44995f', '7434532d8bbf4e4dad6f357a97a122dd', '7a5bc037ed68424da99f9ce46200d285');
INSERT INTO `upms_group_role_rel` VALUES ('d84a835666f645afb5cd1c86c327fa56', 'b99abd5532854230a1ee750a826d78ad', '409ab91ac1714729b78cdbb0ee54b00c');
INSERT INTO `upms_group_role_rel` VALUES ('d8af6574831b4591883cd52562633b44', '7d0c18631c754cf2900b34ea112019b4', '576537697bbd439884451cae5bdd5225');
INSERT INTO `upms_group_role_rel` VALUES ('d907e4d9228742cd9bf1507728e445e4', '04a0f1762b4042bdaf356c1c325d08b8', '812579d14fb54cdc884c4f96fe46ba71');
INSERT INTO `upms_group_role_rel` VALUES ('d9cf314fcfaa475cac90c474dbaee1a5', 'bf50b351ad2941b49cbdf2bf5f9c6384', '06f4d233d10249aabc0ff26e394b01d0');
INSERT INTO `upms_group_role_rel` VALUES ('da25fdc330dd446d85a870fcadf6d7b4', '802ca30582b94ba69e57aa97bb3da906', '6f677bc191244c3282ba567e67e0fdf7');
INSERT INTO `upms_group_role_rel` VALUES ('daaa0e1304474f07af3f0381ee216684', 'a8e5f9e270a44a8b9ad102d3f42bac12', '6a1f1f1ba6dc47828bfa08b7aead6ecf');
INSERT INTO `upms_group_role_rel` VALUES ('db20a9a1c14445bb9fb4d5e3fe6cc706', 'b048917853c84a248ed373388268c4ab', '8533a000b0f84f239a4f371d558afd06');
INSERT INTO `upms_group_role_rel` VALUES ('dba7f424ca224be89903b6252feaa0bc', 'e8d6d7fec94f44549d43dbba339586f3', '9edf1d2fd7ec4a51bd345f4544e0a8eb');
INSERT INTO `upms_group_role_rel` VALUES ('de4ec3bfd6cd432498f8906104e13ca0', '582b399664854025a845a02648392bbd', 'dc15aff2b82d43b0b6228ef05d228bea');
INSERT INTO `upms_group_role_rel` VALUES ('de9723e67114497fb13b544a990d79be', '985a2e5391b64022bc04454bd7b13f8e', '8e90da510f084774977ea538e21f59a9');
INSERT INTO `upms_group_role_rel` VALUES ('dec4bfd8bade483fb3f4d3459c61a32f', 'c2b0c2b8ab73440882e37debeba8cc9b', 'da0b719c828f49faba044b1e366eae67');
INSERT INTO `upms_group_role_rel` VALUES ('deed3b7327c34948b9a9c678dc19d89e', '5bd789c6f79f42b8afa18134e568aafe', '9577ad3cce4540ae90855b788b8d758e');
INSERT INTO `upms_group_role_rel` VALUES ('df38842a2da64b2e969ae3d159a87b95', '640675f3399b4e758939f38597bc5b94', 'f548d8079c1b47f490fb8e85b307796c');
INSERT INTO `upms_group_role_rel` VALUES ('dfaa468d04e444579c1fcea68200a1e7', '7bda181707584ca7a3754b6000966343', 'c8dd30ea2da84213b76b3cbcbc7e367d');
INSERT INTO `upms_group_role_rel` VALUES ('dfcdfe8117ff4055873dfdf4f6fa58d6', '059e931bff174679a722c7573fdc6dc3', '2e881cc147824245b7c68e29ba2f9999');
INSERT INTO `upms_group_role_rel` VALUES ('e0723534ab794c85806b593597c88870', '11399a85d1244640a3207cdb53f99868', '06592fe12d00420b9e7d57089ef37b75');
INSERT INTO `upms_group_role_rel` VALUES ('e0a3de8d05c24a0b836157376cf01250', '6d1a4c18d4d34a369cdf9ed67c474046', '1d427e3a978c4567aa4c5b8e1d48d80c');
INSERT INTO `upms_group_role_rel` VALUES ('e0d082cd95cd4432b651e3c5bd2547be', 'bf77b91e2da84cc2bdaa199cb35ac753', 'f9f2f16236c34e5798993116af3b5d73');
INSERT INTO `upms_group_role_rel` VALUES ('e1ee7aaf79a947548e8ef7ae2fe9e40d', 'f77116ebc17240dc94bec8008874d585', '9a3a1ef1357849b193bd5de2b9142d4c');
INSERT INTO `upms_group_role_rel` VALUES ('e4d5fcbf2f9e4d2eb601ad75717233f3', '980acef842074f63a3f36b43f9e34b70', '18a496dfb7094e9fb3e547c62f62d6bf');
INSERT INTO `upms_group_role_rel` VALUES ('e507b23eafe2494a8f4cac947265f6a5', 'c67487fb2d32419f87fdefb1e289df8b', '360120976f1346dc8acf2b97f411d861');
INSERT INTO `upms_group_role_rel` VALUES ('e59c01c245d54d0fad0187a48571a1bd', 'df58f2281de042c7a656bf196300a1be', '44e1923f405d4262b717f43c92c6ccb4');
INSERT INTO `upms_group_role_rel` VALUES ('e7292cbc0d2a4383938fd12fdfe2b2c1', '087631b275fe49848f5e69458b3ba325', '2035e56e7fe74830947ad6bff1a6d3b5');
INSERT INTO `upms_group_role_rel` VALUES ('e895accfc1654075a1e438d3be8c16f1', '43aa9cb7505f49c2bbe1e56f2ea5fc2e', '7f6c92a880934e91b429316a1fe2147b');
INSERT INTO `upms_group_role_rel` VALUES ('e8e4778f39774d3e922be30c764ffab1', '176544ac2cd145bf9ac0a571ee51e129', '82a9af3bb3b646518cbab089ba881fb7');
INSERT INTO `upms_group_role_rel` VALUES ('e97c83dc031f4ad79fdf71e7dfc2d1d7', '94e001990de64b82869d80bfc86e2323', 'c04595e9efef406f8a6ea25a8bbeeea6');
INSERT INTO `upms_group_role_rel` VALUES ('ea31326da4094a66891ca4bc189cbbb3', '1bc45a4b326542898e7c9233d27c2e7d', '01e098d6c8c3411f94537840dca36763');
INSERT INTO `upms_group_role_rel` VALUES ('ea5d6864d49447b5adf5c29e4b266730', '6d8766af168c4abb94fc2dfa1f1d1714', '8a8d44663fd245aab4166291749f5703');
INSERT INTO `upms_group_role_rel` VALUES ('ea79a9d011f44403b98bae62609b6551', 'b3b5f2e58b714bc5a6e27c4e41f5bc38', '01d59b8b65324146a73257697d4e3773');
INSERT INTO `upms_group_role_rel` VALUES ('ea9f72755aec48259479d66736fa0a79', 'dded1cee32e4446a9c406a0eeb10530b', '691aae58e26f4441871809fb99637982');
INSERT INTO `upms_group_role_rel` VALUES ('eb41faf45194416e816036f717c34f3a', '453d942289b143be8db863a0aeb01d78', 'c14e3293bee74c7084f45be0956ef9d1');
INSERT INTO `upms_group_role_rel` VALUES ('ecbfa1d24bf84572bb430cc7b6f98760', 'ae53f968de704002a830fc2a251cb369', 'd11bd69b51ac4a85998d21d8aaa73b60');
INSERT INTO `upms_group_role_rel` VALUES ('eccda2e812764d09afdc7c0a629702a5', '661765c929ff4bff995c1e5c80105c67', '9732e25540d74bfe8c88c7c287361a58');
INSERT INTO `upms_group_role_rel` VALUES ('ecd6a4019ea04b53b0e84e0d74e16656', '644627df7a9b48f4827a6cb5945b92ff', '8c60188a44c84818be340f6cccf4b013');
INSERT INTO `upms_group_role_rel` VALUES ('edc1e636dd3947ae84980de9cdf7d7d2', '4a9cca776e5645aabd49f0279720ecb2', '924562335ae24a1292cb0a044d1ef40e');
INSERT INTO `upms_group_role_rel` VALUES ('edd561098432459bb604308e5d220fd3', '08df482e17144da9b15286084b32e667', '22a071c93aef4119a00ba8b7a99f4921');
INSERT INTO `upms_group_role_rel` VALUES ('eeac9b3efe1942848688d14273b72079', 'e057e2965bb84c2484170308b4b428e6', 'a4af67fc28104048930eb98c02aad8f4');
INSERT INTO `upms_group_role_rel` VALUES ('eef0d6025e4f47839c57edb9f01ed236', '08bd2d1485134eccbd4fc72d76ec9547', '4b816cf68d5f46b6ad72c859ca8e61e3');
INSERT INTO `upms_group_role_rel` VALUES ('efe2b0a6e52f4ac1bdbbc9d515b9c247', '65d2ced0de5440a8b90a50cadaba0d47', 'a296058c92a54ceab7db0feca3e80ef4');
INSERT INTO `upms_group_role_rel` VALUES ('f007921f093b4fa6854579fd87b53d6d', '6148101b0d664c5d86dcb4f3d7b1c66a', '0183c9fa978d4f11b8ae93d6ae456987');
INSERT INTO `upms_group_role_rel` VALUES ('f2008ec9cdd74132978cdc54ecc54d92', 'f8c5564b11984410b996a3c2d265dbf7', '98cf8457fdbf428da796bebf66aa4130');
INSERT INTO `upms_group_role_rel` VALUES ('f307d171a4a34e189401ee88d32df858', 'b6a01236044d4dafa6539d044a23b14a', '4aa154ef9ec243d8a60401b389bbac2b');
INSERT INTO `upms_group_role_rel` VALUES ('f30dbe110acc4c488b1eaee6d31e46b0', '89b8a6d158ec4dbaa43dc6b800210869', '0ca27a3897aa408d8a55646ee7a0e531');
INSERT INTO `upms_group_role_rel` VALUES ('f328fc02cf7f47939a499f34239006df', 'f6e5576d2e454a04bfac93c08183c657', '782576e913c64a2b8fce058d583407d1');
INSERT INTO `upms_group_role_rel` VALUES ('f336189e8488417c90b7bfaddc60f461', '3a382f3f8a2a45fa8e545b8e51e93efb', '699f916e7ed4413ba672a7158c790d14');
INSERT INTO `upms_group_role_rel` VALUES ('f33da2e4f6ff49eeb69b9cc2279a1bf7', '9db78b5983564017ae3a7123db629a65', 'cfd2c8152c6e4457a03b9c5f05c4a717');
INSERT INTO `upms_group_role_rel` VALUES ('f35b039a65da4ee9b524b5c64472e45b', 'aa335e4c37b44501aaa8e36f3a45b10a', '867da979936f4cbfbd7e68c770ba2122');
INSERT INTO `upms_group_role_rel` VALUES ('f5151c095ed445fc9133addd66e22510', '0d6e2476941e4d95802af683beb725a7', '51cf94a296e04d89973ae4ec60d7f606');
INSERT INTO `upms_group_role_rel` VALUES ('f60b52ed3df9473595c9f99dc3279e00', 'deaca25b5b9f472eb840797f393d29c9', 'aa4e334834bd43a9815a740d82d5e9f6');
INSERT INTO `upms_group_role_rel` VALUES ('f62ddfd1438f4c95b51e202930464a1c', '067916a4685a4ff6b59ec36387a61741', 'db3db74e582d4108ba5a16b560fe2b3d');
INSERT INTO `upms_group_role_rel` VALUES ('f638dad779a643c8bc6cae9d0aecdbd1', '09fba9f8a4724e88870722cbf2c380b1', '642d1338555b465d937745974f6249ad');
INSERT INTO `upms_group_role_rel` VALUES ('f6f5513436844af78110581535cb90fd', '3c429741fd0f4e2e8f94ce0cc18b61e0', '7870ad132aae4c41895fe7296be70edc');
INSERT INTO `upms_group_role_rel` VALUES ('f7108ae43f7540e291b93b1c9212348f', '00016234b8f64701bbfa138b5efc946f', 'e768090f89e64b86b0846903874aa9d9');
INSERT INTO `upms_group_role_rel` VALUES ('f7588b54377b4762a70c2d83699340a0', '51ba15a5cb984bbd9615a474c99fc470', '50c44b196ac44f889e35b7c7a9f0c0bb');
INSERT INTO `upms_group_role_rel` VALUES ('f7819599ab5048aab5e9fb90f2116c2c', 'e61af17b51a041c9b20b67df78a51caf', '7ca5050d18a7461488c049fca501074b');
INSERT INTO `upms_group_role_rel` VALUES ('f786180b93f54cceb1d66a08e8f34700', 'bc335148047f4bd688fc376a6d327e43', '8631aced2f0e4c3fba71ce4aa40b4b93');
INSERT INTO `upms_group_role_rel` VALUES ('f7afcc7b8a6a460b9d8f405dd4c11f82', 'aa097e9da24743ad94acad870c45e79f', '4684a2a4116c4f3cae3cfd4c0c575b25');
INSERT INTO `upms_group_role_rel` VALUES ('f80032efa577463484e1f059e65bdac3', '89fa76cfa61f43a4adc68e88e7519496', '3579a03149074b86be57d0e18cb09107');
INSERT INTO `upms_group_role_rel` VALUES ('f919ab8e09e24da69bfeffa463693d03', '9b33617c36c44d25b548ab48ce700ae1', 'd9f05f50f0354a22b0c56cebf9fb55f7');
INSERT INTO `upms_group_role_rel` VALUES ('f9268ab535094de09edbc8de50eed9cd', 'a38fdf3e017a48508bc790acdaa0369d', 'd4e94833f9514b0e994f03e6398e7bb7');
INSERT INTO `upms_group_role_rel` VALUES ('f9372ccb3d964f29a8d3615a8d9a7c90', '6717c03b400042f7aae07cc480641b27', '889ba6c9e822410fbc2cb976aa06584f');
INSERT INTO `upms_group_role_rel` VALUES ('f99aec252a3f45778b5ef14d5c9dc028', '4854ea7ea4c644e2a638fad6d2e84d7c', '0b8ad21416094f27b330b6e0bec93cf2');
INSERT INTO `upms_group_role_rel` VALUES ('fa0761e9bc044e4782ef15de76bdfef3', '89d4e2a6b767421eb5acbd001ebee98c', 'c22dce38019a43488da8393980675121');
INSERT INTO `upms_group_role_rel` VALUES ('fa2db425e9c04f599f0c365548823aaa', 'aca57078f8984c00b8ba7611ba2e2ede', 'b6e7b0677af044609aacf739703c187d');
INSERT INTO `upms_group_role_rel` VALUES ('fa2e409ca340455c94cf6ccde04f080b', '6169ecf195b74bf5b9d542e8cab7500d', 'c3eb4f903f27421d860eead52b7c518d');
INSERT INTO `upms_group_role_rel` VALUES ('fa85adbefd42417a8d664219d0c46dc5', '1a0412c5f7784843a09cecdd6560ffcd', '6d6dc0e562ce4ea690295ec73a78b5c7');
INSERT INTO `upms_group_role_rel` VALUES ('fab5309d435d4ab297cb1debbd64f785', 'bb3c73a209124c628e16967ca1413aa9', '1239c6d2ada848069b9468dc99299c75');
INSERT INTO `upms_group_role_rel` VALUES ('fb079567489e47b1b1d23b7ae42b01db', '2bf60354d8f24d1fa5719a3f10289a20', '67e87916cc6543d5a904ee560bb69412');
INSERT INTO `upms_group_role_rel` VALUES ('fb07d25ac0d74acb902400e48a4cd3b2', '9c725c18aac2411f9d70dc80a6d4025e', '42c9b394147048cd9c77285ec57c1980');
INSERT INTO `upms_group_role_rel` VALUES ('fb34386875a94f10a2c74b55a699c01b', '8e1a535492e54197ac86cdc36f5e1ebf', 'abb5f994199e4c9a975c8e29dd3b91ce');
INSERT INTO `upms_group_role_rel` VALUES ('fb6d454e4224481d87281fbcd7b9e9df', 'eab541e21f724d99b7284e2a22f936ea', 'b15452ea99df49efb7cd53d876fc1ab7');
INSERT INTO `upms_group_role_rel` VALUES ('fbd8a93c45a14cfc918a546d7617e3d2', '38727f17dc624bcebb5fa9506a08ce1f', '26095981c4ac4ef18217fdce6f1f001b');
INSERT INTO `upms_group_role_rel` VALUES ('fbd960118acc41dabec25cec7e6af7d0', '3bb78d9a66284e7096449f5dbb83b9fe', 'db1b857d27094b418d9f33ef79c02c51');
INSERT INTO `upms_group_role_rel` VALUES ('fbeca1b1774c4155b7f3eac35b45a496', '332ed4460d0c4d2bb0cf08c88cbf106a', 'b815da5f06954f5cad2b378392677258');
INSERT INTO `upms_group_role_rel` VALUES ('fc47b0427b154ae9a90ed72dbdf6fbe2', 'fe8828050679452eb54816421eab0bb2', '0bb85bcab7cc4c63a9ea46945385e8fd');
INSERT INTO `upms_group_role_rel` VALUES ('fc5cd3bbb3214c5a80e66b8981183752', '8dd200ddc4e34afa8d1f3b1aa30c037d', 'ae4d1db13db44255b4831ea59557e9c0');
INSERT INTO `upms_group_role_rel` VALUES ('fcb446fe666748848f2ccca0ef87929b', '1bc0706508b2431a8b38594a1317ff6f', '916780bd2291401c93fab0cdbb31531f');
INSERT INTO `upms_group_role_rel` VALUES ('fd596bb8509548a88501f06dde8d6091', '29950281f6b24b2a80de25249e5e53d8', '25b2761626824e2693f6dff1f731c049');
INSERT INTO `upms_group_role_rel` VALUES ('fe77ae4bcc8840e68cb4c68e22a1777f', 'cfb63d7fec204902bc21cb00e7152d4d', '0715fa5e446f4d95a7c69df723ed2a18');
INSERT INTO `upms_group_role_rel` VALUES ('feb9a5fe40b44852a206236c0f2e74df', '528b9ce6235b47e0b98741c0f4da4146', '11969b4ea136489cabb368d130613554');
INSERT INTO `upms_group_role_rel` VALUES ('ff2684a76b214992a3de245caad37034', '971946cc16fe4e9fa2deaaf11ed92218', '256530cfda6140b280be5e7a62d72bd4');
INSERT INTO `upms_group_role_rel` VALUES ('ff4ec3a59eca4f3283554cfebca80e8c', '32bf60cbff5c468ab9528dbefe1f105a', '61a3df94133f4dd58becc820ae29075b');
INSERT INTO `upms_group_role_rel` VALUES ('ff636dbdf36f429293f87c5caad5178a', '5ff92d6643ab46a5b90ad7c2a0fe52d3', 'f97bd669c51e47cdb5447df67a1cdc0f');
INSERT INTO `upms_group_role_rel` VALUES ('ffc2b324e6f341c9bd102ff04b198c0e', '20cabc94e2c844cb8790ae317938be46', '8cc76d55ce4043d3a86b8ef6e541cc8d');

-- ----------------------------
-- Table structure for upms_menu
-- ----------------------------
DROP TABLE IF EXISTS `upms_menu`;
CREATE TABLE `upms_menu` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `operator_id` varchar(32) DEFAULT NULL COMMENT '功能id',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '上级菜单',
  `system_id` varchar(32) DEFAULT NULL COMMENT '所属系统',
  `name` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `code` varchar(20) DEFAULT NULL COMMENT '菜单编号',
  `icon` varchar(30) DEFAULT NULL COMMENT '图标  如fa fa-rmb',
  `level` int(11) DEFAULT NULL COMMENT '层级级别',
  `order_list` int(11) DEFAULT NULL COMMENT '排序',
  `is_parent` smallint(1) DEFAULT NULL COMMENT '是否上级节点',
  `param` varchar(200) DEFAULT NULL COMMENT '菜单链接参数',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '对应cc_department表，机构ID',
  `data_area` varchar(200) DEFAULT NULL COMMENT '数据域',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_data_area` (`data_area`),
  KEY `_parent_id` (`parent_id`),
  KEY `_system_id` (`system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Records of upms_menu
-- ----------------------------
INSERT INTO `upms_menu` VALUES ('0', null, null, '', '根节点', null, null, '0', null, null, null, null, null, null, null);
INSERT INTO `upms_menu` VALUES ('01001f52755346d287da972158d7707e', '8863eb171b23493f8936c3ea7112232a', 'c8efb1ec373a48dfb04203ac1e3ee1cc', '733a121c24e44945bbdfaa707f938662', '活动投放', 'activePut', null, '2', '2', '0', null, null, null, '2018-02-28 10:17:13', '2018-02-28 10:24:49');
INSERT INTO `upms_menu` VALUES ('03fda7fac4934649b624359a49b77397', '06e3cc5dba164ff2a9d26c39c1da769e', '73d0016d060a490fa1733a86f5004ca5', '733a121c24e44945bbdfaa707f938662', '入库管理', 'stockIn', null, '2', '4', '0', null, null, null, '2018-01-05 11:01:35', '2018-01-05 11:04:56');
INSERT INTO `upms_menu` VALUES ('0540b8a62dd444b28efab6fb4ba79579', null, '0', '733a121c24e44945bbdfaa707f938662', '商品库管理', 'storeManage', 'fa fa-shopping-bag', '1', '8', '1', 'goods', null, null, '2017-11-27 14:27:31', '2017-12-06 20:10:02');
INSERT INTO `upms_menu` VALUES ('079cfa3e2a9945959ee5b31d49b341e0', '1ac554af512b404e82838d65f775e50e', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '库存详细', 'inventoryDetail', null, '2', '1', '0', null, null, null, '2017-12-12 16:14:45', '2017-12-12 16:21:27');
INSERT INTO `upms_menu` VALUES ('0f4e2aec0b1a4c748164225d7321c689', '0edc5e67eb884412b4cec55b78b7e307', '79551a222f344bd2a88da2a104446eb5', '733a121c24e44945bbdfaa707f938662', '数据字典', 'dict', null, '2', '1', '0', 'dict', null, null, '2017-11-27 14:50:21', '2017-12-06 20:26:09');
INSERT INTO `upms_menu` VALUES ('10f29614ad6141c49227d949a6f44802', '414eff5c413a466c986bcb4b43be7e0e', '0540b8a62dd444b28efab6fb4ba79579', '733a121c24e44945bbdfaa707f938662', '供应商管理', 'provider', null, '2', '1', '0', 'supplier', null, null, '2017-11-27 14:44:53', '2017-12-06 20:10:21');
INSERT INTO `upms_menu` VALUES ('1168cb5825e64e60aff593c27ab4e108', '73ab5fd90b0640cebf4ce67ee57ce47c', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '我的产品详细', 'productReport', null, '2', '4', '0', null, null, null, '2017-12-19 15:10:29', '2017-12-19 15:32:08');
INSERT INTO `upms_menu` VALUES ('120b42e15e0e469fa01a85db7faf835c', 'd2bb7be5c39542318f9591117887fb74', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '功能管理', 'operation', null, '2', '8', '0', 'operation', null, null, '2017-11-27 14:49:49', '2017-12-06 20:19:21');
INSERT INTO `upms_menu` VALUES ('13015046524046aebb24524034903fbc', '443eac0f3a024f01b7cdca36df660486', 'fb1b77d621c742fd8ce30ea6e5ea77dd', '733a121c24e44945bbdfaa707f938662', '系统日志', 'systemLog', null, '2', '5', '0', 'systemLog', null, null, '2017-11-27 14:41:36', '2017-12-06 20:25:49');
INSERT INTO `upms_menu` VALUES ('13bf5382494b4fafb87a83ca57a4a62c', '22b3abbbcb634d59b1733c2c3583c81a', 'c8efb1ec373a48dfb04203ac1e3ee1cc', '733a121c24e44945bbdfaa707f938662', '活动列表', 'activityList', null, '2', '1', '0', null, null, null, '2018-01-17 10:28:03', '2018-01-17 10:41:20');
INSERT INTO `upms_menu` VALUES ('154da9545add49c3abba2f7740be18fc', '04abeceff3b74cb5be43f59d66ef990c', '9ee3b6de7cd142faab4180f6cbb1c3fc', '733a121c24e44945bbdfaa707f938662', '销售商管理', 'seller', null, '2', '1', '1', 'seller', null, null, '2017-11-27 14:46:22', '2017-12-06 20:14:33');
INSERT INTO `upms_menu` VALUES ('154f22c64a5543b78282af43e0c2779e', 'cf6fd2ad2d3c4b2e856f76f3c99d517c', 'e766842e3eee48b7b0e88edbb9ba5a3b', '733a121c24e44945bbdfaa707f938662', '内容分类', 'category', null, '2', '3', '0', 'category', null, null, '2017-11-27 14:43:01', '2017-12-06 20:25:08');
INSERT INTO `upms_menu` VALUES ('15a38604ab41453f8aa56ee8433e1869', '4a2137fa89af4f469138a15fe8cfdc5f', 'b21db35a12de4a58aed574f4b0baf446', '733a121c24e44945bbdfaa707f938662', '菜单设置', 'wechatMenu', null, '2', '3', '0', 'menu', null, null, '2017-11-27 14:39:46', '2017-12-06 20:22:47');
INSERT INTO `upms_menu` VALUES ('15c1b73b5e214478952d45e248fce412', '42266eb0c3394c3d87961c2c145ec235', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '直营商采购详细', 'purSeller', null, '2', '10', '0', null, null, null, '2017-12-19 15:14:45', '2017-12-20 20:06:13');
INSERT INTO `upms_menu` VALUES ('1898aaaab1f147409c955f5b239977ac', 'c867a3ea8427422ca5a790ea40340fcd', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '用户管理', 'user', null, '2', '5', '0', 'user', null, null, '2017-11-27 14:49:15', '2017-12-06 20:18:49');
INSERT INTO `upms_menu` VALUES ('1a2d6f211e374e37ac0837558bebb58e', '7ae5c501ab7f4c5fa60ac0268ae87b5b', 'd06a9318f63b4a3c8130a0ad3380b6ad', '733a121c24e44945bbdfaa707f938662', '入库管理', 'purchaseIn', null, '2', '3', '0', null, null, null, '2017-11-30 15:36:09', '2017-12-06 19:56:28');
INSERT INTO `upms_menu` VALUES ('1bb899f6d6bb4ce0b7933501f7300555', null, '0', '733a121c24e44945bbdfaa707f938662', '账款管理', 'creditManage', 'fa fa-database', '1', '3', '1', 'arrearages', null, null, '2017-11-30 15:14:34', '2017-12-06 20:01:38');
INSERT INTO `upms_menu` VALUES ('1cec0400d8304002bccffbd68b85bbfb', '0d45dc574e0b47539605f4027c04f498', '0540b8a62dd444b28efab6fb4ba79579', '733a121c24e44945bbdfaa707f938662', '商品分类', 'goodSort', null, '2', '3', '0', 'category', null, null, '2017-11-27 14:45:15', '2017-12-06 20:12:28');
INSERT INTO `upms_menu` VALUES ('1d9d54658ebc433595cfc45b02fcd2f4', '76320ac8f2304937aa1f72251ae1291a', '1e06b3825bf94898a39d5863e3aef154', '733a121c24e44945bbdfaa707f938662', '设置', 'setting', null, '2', '3', '0', 'setting', null, null, '2017-11-27 14:43:36', '2017-12-06 20:23:56');
INSERT INTO `upms_menu` VALUES ('1e06b3825bf94898a39d5863e3aef154', null, '0', '733a121c24e44945bbdfaa707f938662', '模板', 'template', 'fa fa-magic', '1', '20', '1', 'template', null, null, '2017-11-27 14:20:20', '2017-12-06 20:23:25');
INSERT INTO `upms_menu` VALUES ('1ee88f38fd6f43b1b4314e621cc0fb09', '72798d20f06a416986add64d9279dfd8', '0540b8a62dd444b28efab6fb4ba79579', '733a121c24e44945bbdfaa707f938662', '商品属性', 'goodsProp', null, '2', '5', '0', 'goodsAttribute', null, null, '2017-11-27 14:45:34', '2017-12-06 20:12:07');
INSERT INTO `upms_menu` VALUES ('2163dd0e70f24c5891a56e19aa586e70', '8bbbf4a810de4016b651a6a873fa3d34', '73d0016d060a490fa1733a86f5004ca5', '733a121c24e44945bbdfaa707f938662', '第三方订单', 'other_order', null, '2', '5', '0', null, null, null, '2018-01-29 10:30:44', '2018-01-29 11:37:02');
INSERT INTO `upms_menu` VALUES ('249a0e2da5d541878f68dec7f4ba2810', '25f0329645db4a119f32a3a803276147', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '组织机构', 'framework', null, '2', '1', '0', 'department', null, null, '2017-11-27 12:07:00', '2017-12-06 20:17:05');
INSERT INTO `upms_menu` VALUES ('262e179e965f47b48017688c65d2d238', null, '0', '733a121c24e44945bbdfaa707f938662', '附件', 'attachment', 'fa fa-file-image-o', '1', '11', '1', 'attachment', null, null, '2017-11-27 14:16:20', '2017-12-06 20:20:05');
INSERT INTO `upms_menu` VALUES ('26a84e285928407d97e2e77ef1edc911', '003aabbea2bd4e02ad4117e7c3e39477', '262e179e965f47b48017688c65d2d238', '733a121c24e44945bbdfaa707f938662', '上传', 'upload', null, '2', '2', '0', 'upload', null, null, '2017-11-27 14:38:25', '2017-12-06 20:20:17');
INSERT INTO `upms_menu` VALUES ('2781612d03c248008b86bd1dc31460dc', 'df9dd46676414eff9ced2389e1c81591', '262e179e965f47b48017688c65d2d238', '733a121c24e44945bbdfaa707f938662', '所有附件', 'list', null, '2', '1', '0', 'list', null, null, '2017-11-27 14:38:16', '2017-12-06 20:20:11');
INSERT INTO `upms_menu` VALUES ('2c9e79eb9e5f48d785b546dc68083ba6', null, '0', '733a121c24e44945bbdfaa707f938662', '用户权限', 'auth', 'fa fa-cog', '1', '10', '1', 'permission', null, null, '2017-11-27 12:05:00', '2017-12-06 19:44:48');
INSERT INTO `upms_menu` VALUES ('2d61ccea5b3d494aac51039c6573793d', 'e53177614286410cb94d420f508b7e08', 'd6d32c5ac8c84c91b85018714998abc3', '733a121c24e44945bbdfaa707f938662', '客户拜访', 'customVisit', null, '2', '4', '0', null, null, null, '2017-12-06 17:09:20', '2017-12-06 20:08:25');
INSERT INTO `upms_menu` VALUES ('3004351807b840c3a455b0effdf7f18d', 'd09fd3353d5047069ccbf15462b05eea', '85a0792127764549bee48bf47d43e337', '733a121c24e44945bbdfaa707f938662', 'CDN加速', 'cdn', null, '2', '3', '0', 'cdn', null, null, '2017-11-27 14:51:02', '2017-12-06 20:29:05');
INSERT INTO `upms_menu` VALUES ('33e626f6ae6648518ce23d296f76e2d6', '70aeb5947b664441a6c7d3c59c330eb5', 'd6d32c5ac8c84c91b85018714998abc3', '733a121c24e44945bbdfaa707f938662', '价格体系', 'priceSystem', null, '2', '6', '0', 'priceSystem', null, null, '2017-11-27 14:37:56', '2018-01-11 18:42:14');
INSERT INTO `upms_menu` VALUES ('368ebb03e1354dca841cca9bf40c66e9', 'd290624e76eb4ab4a30f45b59bb7375c', '73d0016d060a490fa1733a86f5004ca5', '733a121c24e44945bbdfaa707f938662', '出库管理', 'stockOut', null, '2', '3', '0', 'salesOutstock', null, null, '2017-11-30 15:38:12', '2018-01-05 10:59:29');
INSERT INTO `upms_menu` VALUES ('39fb3317271147869f68b3bac58fdc73', 'f65dcea5d258488abedcf4076e93fe6e', '79551a222f344bd2a88da2a104446eb5', '733a121c24e44945bbdfaa707f938662', '地区', 'area', null, '2', '2', '0', 'area', null, null, '2017-11-27 14:50:32', '2017-12-06 20:26:18');
INSERT INTO `upms_menu` VALUES ('3e9d14fd2867450f8cb9dddd1cce9df6', '80d8e0a4a1fb414b84d76cff94a60ef3', 'b21db35a12de4a58aed574f4b0baf446', '733a121c24e44945bbdfaa707f938662', '微信设置', 'settings', null, '2', '4', '0', 'option', null, null, '2017-11-27 14:39:53', '2017-12-06 20:23:07');
INSERT INTO `upms_menu` VALUES ('40df4c3891554ea2bf24692ea9737ea5', '69b3b61113a64e7e87b1ea9c9ec4e8c3', '1e06b3825bf94898a39d5863e3aef154', '733a121c24e44945bbdfaa707f938662', 'APP菜单', 'appMenu', null, '1', '5', '0', null, null, null, '2017-11-30 17:43:28', '2017-12-06 20:24:25');
INSERT INTO `upms_menu` VALUES ('4291b09fee4b4c08b782af05a8f1872f', 'f965ecfbdefa4a06b40dd812175edaa1', '73d0016d060a490fa1733a86f5004ca5', '733a121c24e44945bbdfaa707f938662', '退货单', 'returnList', null, '2', '2', '0', 'saleRefund', null, null, '2017-11-27 14:35:35', '2018-01-05 10:59:20');
INSERT INTO `upms_menu` VALUES ('4539b90953d84686bfce6af5674925fa', '25e6e25b5c934e13b651880b2800a4aa', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '岗位管理', 'station', null, '2', '4', '0', 'station', null, null, '2017-11-27 14:48:27', '2017-12-06 19:47:40');
INSERT INTO `upms_menu` VALUES ('48f97303113f4ebf999641c40c953bc4', 'a1aa6e2f556442d599ad072dc9d5b739', 'd3c6802e31434b82b8a202cf81429f1e', '733a121c24e44945bbdfaa707f938662', '流程管理', 'flow', null, '2', '1', '0', 'workflow', null, null, '2017-11-27 14:42:07', '2017-12-06 20:09:35');
INSERT INTO `upms_menu` VALUES ('4ee0fd541b6b4a46ae90f79ed08ba42f', '5997b876642e4b04aac787e54f9f86a7', 'd6d32c5ac8c84c91b85018714998abc3', '733a121c24e44945bbdfaa707f938662', '客户类型', 'customType', null, '2', '5', '0', 'type', null, null, '2017-11-27 14:37:47', '2018-01-11 18:41:48');
INSERT INTO `upms_menu` VALUES ('4f5e01bf65264b21a011f540c97dbcaf', 'dbb46cc01d074eef93a87c86e407294a', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '我的客户详细', 'customerDetails', null, '2', '2', '0', null, null, null, '2017-12-12 12:06:06', '2017-12-20 20:05:48');
INSERT INTO `upms_menu` VALUES ('4fe658886cf1475d9fc5f05b43e27b41', 'a2bc28a0d3424d1ca176c236b1450d4b', 'd06a9318f63b4a3c8130a0ad3380b6ad', '733a121c24e44945bbdfaa707f938662', '采购单', 'purchaseList', null, '2', '1', '0', null, null, null, '2017-11-30 15:35:40', '2017-12-06 19:55:07');
INSERT INTO `upms_menu` VALUES ('510486d91e354247bdd42f82b7cca4f0', 'b3f1cb782ad0430da370ae532917b4a0', 'fb1b77d621c742fd8ce30ea6e5ea77dd', '733a121c24e44945bbdfaa707f938662', '统计概要', 'outline', null, '2', '1', '0', 'outline', null, null, '2017-11-27 14:41:00', '2017-12-06 20:25:35');
INSERT INTO `upms_menu` VALUES ('51b14bbd2bf346af859708351982a0a5', '81e61865543a49218e7635916ab626d1', '0540b8a62dd444b28efab6fb4ba79579', '733a121c24e44945bbdfaa707f938662', '商品规格值', 'specificatKey', null, '2', '7', '0', 'specificationValue', null, null, '2017-11-27 14:45:49', '2017-12-06 20:13:37');
INSERT INTO `upms_menu` VALUES ('52a21e0ab08f4080b594324e8b656025', '7abbcd78c6174c3594efbc081ebc2676', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '产品总计', 'productTotal', null, '2', '1', '0', null, null, null, '2018-01-02 11:00:47', '2018-01-02 14:30:08');
INSERT INTO `upms_menu` VALUES ('54466b6121a041cbbbc11f81f79ce710', 'f46010897ec14999b16f1b3cfa7b24a3', '1e06b3825bf94898a39d5863e3aef154', '733a121c24e44945bbdfaa707f938662', '所有模板', 'list', null, '2', '1', '0', 'list', null, null, '2017-11-27 14:43:24', '2017-12-06 20:23:37');
INSERT INTO `upms_menu` VALUES ('552601c215144716aeadc87f3924434e', '4b46bab569db4247b6b3fb960f3300bd', '9ee3b6de7cd142faab4180f6cbb1c3fc', '733a121c24e44945bbdfaa707f938662', '打印模板管理', 'template', null, '2', '3', '0', 'printTemplate', null, null, '2017-11-27 14:46:42', '2017-12-06 20:15:36');
INSERT INTO `upms_menu` VALUES ('570963e96ba14c72be72dd0b9ebe25a6', '082acf269f1c4252a46ef2e603b7a584', 'd6797dce62064eb787293dfa507aaa8f', '733a121c24e44945bbdfaa707f938662', '库存盘点', 'check', null, '2', '2', '0', 'stockTaking', null, null, '2017-11-27 14:36:23', '2017-12-06 20:04:39');
INSERT INTO `upms_menu` VALUES ('6cbcdd78b42b452a9a5e7249f57b8899', '0735946955124217afe00cfd5d2ee9ec', 'd3c6802e31434b82b8a202cf81429f1e', '733a121c24e44945bbdfaa707f938662', '模型管理', 'model', null, '2', '2', '0', 'model', null, null, '2017-11-27 14:42:22', '2017-12-06 20:09:43');
INSERT INTO `upms_menu` VALUES ('6d3c9820b7a44ef4866ae3b25fd2d435', 'fe19e5ec64f345a4a6645b452e68f213', 'fb1b77d621c742fd8ce30ea6e5ea77dd', '733a121c24e44945bbdfaa707f938662', 'SQL分析', 'druid', null, '2', '4', '0', 'druid', null, null, '2017-11-27 14:41:27', '2017-12-06 20:25:42');
INSERT INTO `upms_menu` VALUES ('71c26c331b1248ee84eefea1e23e8374', 'ab402ab0f8af4414bae6b4adb82f774d', 'd6797dce62064eb787293dfa507aaa8f', '733a121c24e44945bbdfaa707f938662', '库存调拨', 'allot', null, '2', '3', '0', 'transferBill', null, null, '2017-11-27 14:36:34', '2017-12-06 20:04:57');
INSERT INTO `upms_menu` VALUES ('73d0016d060a490fa1733a86f5004ca5', null, '0', '733a121c24e44945bbdfaa707f938662', '销售管理', 'sales', 'fa fa-arrow-circle-up', '1', '2', '1', 'order', null, null, '2017-11-27 14:13:37', '2017-12-06 19:59:00');
INSERT INTO `upms_menu` VALUES ('77e9521b50f143cfac012d625fe182bd', 'f81d64be9f384292b1ec0a866298cdb0', '0540b8a62dd444b28efab6fb4ba79579', '733a121c24e44945bbdfaa707f938662', '商品类型', 'producType', null, '2', '4', '0', 'goodsType', null, null, '2017-11-27 14:45:25', '2017-12-06 20:11:33');
INSERT INTO `upms_menu` VALUES ('79551a222f344bd2a88da2a104446eb5', null, '0', '733a121c24e44945bbdfaa707f938662', '基础数据', 'records', 'fa fa-database', '1', '22', '1', 'records', null, null, '2017-11-27 14:28:48', '2017-12-06 20:26:02');
INSERT INTO `upms_menu` VALUES ('7ae4493766c148609f6a55307335e3da', '954c78b9416f4a11be37d4f5f31395a3', '85a0792127764549bee48bf47d43e337', '733a121c24e44945bbdfaa707f938662', '定制化服务', 'seller_option', null, '2', '5', '0', null, null, null, '2017-12-11 20:32:56', '2017-12-11 20:36:25');
INSERT INTO `upms_menu` VALUES ('7b5d3676a42a4654a7ec0068354c484e', '3e427c3320804ef9a4e261f37d2dd7bc', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '分组管理', 'group', null, '2', '3', '0', 'group', null, null, '2017-11-27 14:48:41', '2017-12-06 20:17:45');
INSERT INTO `upms_menu` VALUES ('7c18579fd0f6419d89b3184ed8d5a419', '1ea85e73b4534e758a57d6fd3b56e1af', 'b21db35a12de4a58aed574f4b0baf446', '733a121c24e44945bbdfaa707f938662', '自动回复', 'auto', null, '2', '1', '0', 'auto', null, null, '2017-11-27 14:39:13', '2017-12-06 20:22:08');
INSERT INTO `upms_menu` VALUES ('7e0d0dc5f7bd4e31a70a208c4b37a596', '51f5a89860d242b888f4201085c23db2', 'd6797dce62064eb787293dfa507aaa8f', '733a121c24e44945bbdfaa707f938662', '库存总账', 'ledger', null, '2', '4', '0', 'inventory', null, null, '2017-11-27 14:36:46', '2017-12-06 20:05:17');
INSERT INTO `upms_menu` VALUES ('807153d53eda429cb83431afe57c8c3b', '6546c78bc2c9484d9c7d14b6e3b2e7a9', 'd6797dce62064eb787293dfa507aaa8f', '733a121c24e44945bbdfaa707f938662', '出库明细', 'storeOutDetail', null, '2', '6', '0', 'out', null, null, '2017-11-27 14:41:17', '2017-12-06 20:06:36');
INSERT INTO `upms_menu` VALUES ('82511d470b0c4c9fb9af95ea2f970ad1', '7416d54f6fe840a8b7442cf3cbe43403', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '我管理的直营商详细', 'mSellerDetail', null, '2', '9', '0', null, null, null, '2017-12-19 15:13:57', '2017-12-19 16:51:50');
INSERT INTO `upms_menu` VALUES ('85a0792127764549bee48bf47d43e337', null, '0', '733a121c24e44945bbdfaa707f938662', '系统设置', 'option', 'fa fa-cogs', '1', '23', '1', 'option', null, null, '2017-11-27 14:29:12', '2017-12-06 20:27:52');
INSERT INTO `upms_menu` VALUES ('8e3d2412d51b414f84a1630801711274', '8e38d5b443b64e65b4e9e6c7e3488186', 'e766842e3eee48b7b0e88edbb9ba5a3b', '733a121c24e44945bbdfaa707f938662', '撰写内容', 'edit', null, '2', '2', '0', 'edit', null, null, '2017-11-27 14:42:53', '2017-12-06 20:24:50');
INSERT INTO `upms_menu` VALUES ('921f88b877c043f6a11497b932fe6cdc', '68afacbe07f149a6bf46c9a00d1773df', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '模块管理', 'module', null, '2', '7', '0', 'module', null, null, '2017-11-27 14:49:39', '2017-12-06 20:19:08');
INSERT INTO `upms_menu` VALUES ('9451cf30026540c5973bb2acaf9a3332', 'b908438d772e460497d59ac1cad7308c', '1bb899f6d6bb4ce0b7933501f7300555', '733a121c24e44945bbdfaa707f938662', '应付账款', 'creditOut', null, '2', '2', '0', null, null, null, '2017-11-30 15:15:35', '2017-12-06 20:02:22');
INSERT INTO `upms_menu` VALUES ('9946ea8efccb405cbc858cb1f445019c', 'cf06c7f303c341e8b5724ebf51053386', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '我部门的产品详细', 'departProduct', null, '2', '5', '0', null, null, null, '2017-12-19 15:11:39', '2017-12-19 15:38:03');
INSERT INTO `upms_menu` VALUES ('9b558e1506fb4cbb9e5b24be2452a26e', '8525b3075b7f4670bb83df3304757c1d', '1e06b3825bf94898a39d5863e3aef154', '733a121c24e44945bbdfaa707f938662', '模板安装', 'install', null, '2', '2', '0', 'install', null, null, '2017-11-27 14:43:30', '2017-12-06 20:23:46');
INSERT INTO `upms_menu` VALUES ('9ee3b6de7cd142faab4180f6cbb1c3fc', null, '0', '733a121c24e44945bbdfaa707f938662', '销售商管理', 'sellerManage', 'fa fa-university', '1', '9', '1', 'seller', null, null, '2017-11-27 14:27:45', '2017-12-06 20:14:21');
INSERT INTO `upms_menu` VALUES ('a0de05fb1364462e9707115cfbf3cfb0', '20e464c0df9f446baecc89a77309dadd', 'd06a9318f63b4a3c8130a0ad3380b6ad', '733a121c24e44945bbdfaa707f938662', '退货单', 'purchaseReturn', null, '2', '2', '0', null, null, null, '2017-11-30 15:36:03', '2017-12-06 19:55:55');
INSERT INTO `upms_menu` VALUES ('a0e563ac1faf40a3905c3d1a31f93b4a', 'd33e72e99d92452589e1fb85f33fb76a', '9ee3b6de7cd142faab4180f6cbb1c3fc', '733a121c24e44945bbdfaa707f938662', '产品管理', 'product', null, '2', '2', '0', 'productManage', null, null, '2017-11-27 14:46:32', '2017-12-06 20:14:42');
INSERT INTO `upms_menu` VALUES ('a5ae16d19614452581e90e4eadea6214', 'f9263e42f270422f8015ae58fdf99990', '73d0016d060a490fa1733a86f5004ca5', '733a121c24e44945bbdfaa707f938662', '订货单', 'orderList', null, '2', '1', '0', 'salesOrder', null, null, '2017-11-27 14:35:26', '2017-12-06 19:59:21');
INSERT INTO `upms_menu` VALUES ('a5c3e29a9f5a4e8b81c02d77fed8fceb', '9848f1d345724c219691fdc98c8b0189', 'b21db35a12de4a58aed574f4b0baf446', '733a121c24e44945bbdfaa707f938662', '微信模板消息', 'message', null, '2', '10', '0', null, null, null, '2017-12-07 14:02:38', '2017-12-07 14:18:58');
INSERT INTO `upms_menu` VALUES ('a90cc348b3394a98a3544387a08e85ec', 'b8a19ceaec234a26b41a7d4df4e4630b', '85a0792127764549bee48bf47d43e337', '733a121c24e44945bbdfaa707f938662', '常规', 'list', null, '2', '1', '0', 'list', null, null, '2017-11-27 14:50:50', '2017-12-06 20:28:01');
INSERT INTO `upms_menu` VALUES ('ac4ea21955c6474393b2b60e779dbe1d', '1f3a1271014648a59cc2cecbeaa1f200', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '系统管理', 'system', null, '2', '6', '0', 'system', null, null, '2017-11-27 14:49:30', '2017-12-06 20:18:59');
INSERT INTO `upms_menu` VALUES ('b21db35a12de4a58aed574f4b0baf446', null, '0', '733a121c24e44945bbdfaa707f938662', '微信', 'wechat', 'fa fa-weixin', '1', '19', '1', 'wechat', null, null, '2017-11-27 14:16:44', '2017-12-06 20:20:48');
INSERT INTO `upms_menu` VALUES ('b4de11db1f504a5ba39024ec9123841b', 'df32642d4cba41dcb6dcc1a507c65f03', '85a0792127764549bee48bf47d43e337', '733a121c24e44945bbdfaa707f938662', 'API应用', 'api', null, '2', '4', '0', 'api', null, null, '2017-11-27 14:51:08', '2017-12-06 20:28:57');
INSERT INTO `upms_menu` VALUES ('bce45d86bd284b3ca75243cccd18729d', 'd831dd3e4d684d19b194e27cdb8f2f37', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '角色管理', 'role', null, '2', '2', '0', 'role', null, null, '2017-11-27 14:47:52', '2017-12-06 19:45:33');
INSERT INTO `upms_menu` VALUES ('be682f209098495daf17c8d77ab0c49f', '2332ffac399a4276b41af1bacc4233a5', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '我部门的业务员详细', 'mSalesmanDetail', null, '2', '7', '0', null, null, null, '2017-12-19 15:14:26', '2017-12-19 15:32:46');
INSERT INTO `upms_menu` VALUES ('c305bf12f0ee4cbc8f7f8bffe48a440c', null, '0', '733a121c24e44945bbdfaa707f938662', '报表查询', 'report', 'fa fa-bar-chart', '1', '5', '1', null, null, null, '2017-12-12 12:00:05', '2017-12-12 20:09:48');
INSERT INTO `upms_menu` VALUES ('c333db78e430460eac0f08c99d4fee37', 'aef27506020a4927aea6f23f236db46d', 'd6797dce62064eb787293dfa507aaa8f', '733a121c24e44945bbdfaa707f938662', '入库明细', 'storeInDetail', null, '2', '5', '0', 'in', null, null, '2017-11-27 14:41:11', '2017-12-06 20:06:24');
INSERT INTO `upms_menu` VALUES ('c8efb1ec373a48dfb04203ac1e3ee1cc', '6a579fca916041ef99e6baa634fc0a0e', '0', '733a121c24e44945bbdfaa707f938662', '活动管理', 'activity', 'fa fa-certificate', '1', '9', '1', 'activity', null, null, '2018-01-17 10:24:02', '2018-01-17 10:31:31');
INSERT INTO `upms_menu` VALUES ('cf9275a6a4bc4a9ea984ed7783eb16bd', 'db3c8594bfda4bacb52b98199b567d91', 'd6d32c5ac8c84c91b85018714998abc3', '733a121c24e44945bbdfaa707f938662', '公司客户', 'customerCorp', null, '2', '1', '0', null, null, null, '2018-01-28 17:08:50', '2018-01-28 20:04:34');
INSERT INTO `upms_menu` VALUES ('d06a9318f63b4a3c8130a0ad3380b6ad', null, '0', '733a121c24e44945bbdfaa707f938662', '采购管理', 'procurement', 'fa fa-arrow-circle-down', '1', '1', '1', null, null, null, '2017-11-30 15:24:03', '2017-12-06 19:57:49');
INSERT INTO `upms_menu` VALUES ('d3c6802e31434b82b8a202cf81429f1e', null, '0', '733a121c24e44945bbdfaa707f938662', '流程管理', 'flowManage', 'fa fa-random', '1', '7', '1', 'process', null, null, '2017-11-27 14:18:14', '2017-12-06 20:09:21');
INSERT INTO `upms_menu` VALUES ('d485da328887431895c705da13533fdc', 'aacbf48a40ab438c9a36281227d8bbf3', '0540b8a62dd444b28efab6fb4ba79579', '733a121c24e44945bbdfaa707f938662', '商品信息管理', 'goodsManage', null, '2', '8', '0', 'goods', null, null, '2017-11-27 14:45:59', '2017-12-06 20:13:56');
INSERT INTO `upms_menu` VALUES ('d4d352771cf84fa1bafa1cedcaacc104', 'e2e0e165448a43e8b8db82517ecf031e', 'd6797dce62064eb787293dfa507aaa8f', '733a121c24e44945bbdfaa707f938662', '仓库管理', 'storeManage', null, '2', '1', '0', 'warehouse', null, null, '2017-11-27 14:36:14', '2017-12-06 20:03:58');
INSERT INTO `upms_menu` VALUES ('d6797dce62064eb787293dfa507aaa8f', null, '0', '733a121c24e44945bbdfaa707f938662', '库存管理', 'inventoryManage', 'fa fa-barcode', '1', '4', '1', 'store', null, null, '2017-11-27 14:14:40', '2017-12-06 20:03:25');
INSERT INTO `upms_menu` VALUES ('d6d32c5ac8c84c91b85018714998abc3', '1a9cabad5f4545e39dce92d63187dd65', '0', '733a121c24e44945bbdfaa707f938662', '客户管理', 'customManage', 'fa fa-user', '1', '6', '1', 'customer', null, null, '2017-11-27 14:15:21', '2017-12-06 20:07:10');
INSERT INTO `upms_menu` VALUES ('d7fe30e090124668b11695b17ebd0d32', '6d99e4c6dc664c9497a39a8f2133c07e', '9ee3b6de7cd142faab4180f6cbb1c3fc', '733a121c24e44945bbdfaa707f938662', '组合商品管理', 'goodsJoint', null, '2', '4', '0', 'combination', null, null, '2017-11-27 14:46:50', '2017-12-06 20:18:33');
INSERT INTO `upms_menu` VALUES ('d83e4b1bd6f24b538362624ca66e7673', '2efd481e9cb24977b61136abd0ba4e35', 'd6d32c5ac8c84c91b85018714998abc3', '733a121c24e44945bbdfaa707f938662', '客户仓库', 'customerStore', null, '1', '1', '0', 'list', null, null, '2018-01-11 18:41:00', '2018-01-11 19:25:36');
INSERT INTO `upms_menu` VALUES ('d914c6a6f6e840a9a02668c65de5f956', '0638ae6e8c9c4ba5812e4d493d5f8ba6', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '我的客户类型', 'clientTypeReport', null, '2', '3', '0', null, null, null, '2017-12-19 15:10:04', '2017-12-19 15:31:55');
INSERT INTO `upms_menu` VALUES ('dbfd640be2634ca0813cd27b21508f20', '231f59600eb540daa6eeb42ed6f24c51', '0540b8a62dd444b28efab6fb4ba79579', '733a121c24e44945bbdfaa707f938662', '商品规格', 'specification', null, '2', '6', '0', 'specification', null, null, '2017-11-27 14:45:43', '2017-12-06 20:13:09');
INSERT INTO `upms_menu` VALUES ('dc831c5876be4fdb9c2aab1f492a22c0', 'b9ae4246b09743fca0cec336b0bcd022', 'd6d32c5ac8c84c91b85018714998abc3', '733a121c24e44945bbdfaa707f938662', '基础客户', 'customBasic', null, '2', '2', '0', null, null, null, '2017-11-30 10:45:03', '2018-01-11 18:41:18');
INSERT INTO `upms_menu` VALUES ('dcbfe2093dea47a4a417d2e2f13ffb6f', '94a8f9efc0f44e39ae17be6416f68ce6', 'b21db35a12de4a58aed574f4b0baf446', '733a121c24e44945bbdfaa707f938662', '默认回复', 'default', null, '2', '2', '0', 'default', null, null, '2017-11-27 14:39:35', '2017-12-06 20:22:21');
INSERT INTO `upms_menu` VALUES ('e26e6a487d7f40e48d3fdbf71a9d3b87', 'c1ed085c9afc4f968570d175340b5eaf', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '我管理的直营商', 'manageSeller', null, '2', '8', '0', null, null, null, '2017-12-19 15:12:36', '2017-12-19 15:33:23');
INSERT INTO `upms_menu` VALUES ('e26e96a22a654b4c9a5b006849ce1b9a', '285632ece63e48fa8d46ba795302aa1a', '1bb899f6d6bb4ce0b7933501f7300555', '733a121c24e44945bbdfaa707f938662', '应收账款', 'creditIn', null, '2', '1', '0', null, null, null, '2017-11-30 15:01:29', '2017-12-06 20:02:14');
INSERT INTO `upms_menu` VALUES ('e2bfd66efbe4484a88dcf8ec08fe1b02', '92a3842d4a1a455cb60a3013b0497673', '2c9e79eb9e5f48d785b546dc68083ba6', '733a121c24e44945bbdfaa707f938662', '菜单管理', 'menu', null, '2', '9', '0', 'menu', null, null, '2017-11-27 14:50:00', '2017-12-06 20:19:57');
INSERT INTO `upms_menu` VALUES ('e52a4ce74eb148a3b8485daec03f5411', '409326538b49440fae167d0cb2e82de2', 'e766842e3eee48b7b0e88edbb9ba5a3b', '733a121c24e44945bbdfaa707f938662', '内容列表', 'list', null, '2', '1', '0', 'list', null, null, '2017-11-27 14:42:45', '2017-12-06 20:24:43');
INSERT INTO `upms_menu` VALUES ('e766842e3eee48b7b0e88edbb9ba5a3b', null, '0', '733a121c24e44945bbdfaa707f938662', '内容管理', 'article', 'fa fa-file-text-o', '1', '21', '1', 'article', null, null, '2017-11-27 14:34:41', '2017-12-06 20:24:34');
INSERT INTO `upms_menu` VALUES ('e77b0cb5e1014e90af2ec0966907808c', 'bbe4beaf93b4438faefa57135c50b006', 'c305bf12f0ee4cbc8f7f8bffe48a440c', '733a121c24e44945bbdfaa707f938662', '我部门的业务员', 'departSalesman', null, '2', '6', '0', null, null, null, '2017-12-19 15:11:58', '2017-12-19 15:32:34');
INSERT INTO `upms_menu` VALUES ('e94a54be937d484e890e07f1bea87afc', '25811f52d97247cdbcdc2e229b22077f', '0540b8a62dd444b28efab6fb4ba79579', '733a121c24e44945bbdfaa707f938662', '品牌管理', 'brand', null, '2', '2', '0', 'brand', null, null, '2017-11-27 14:45:04', '2017-12-06 20:10:44');
INSERT INTO `upms_menu` VALUES ('f4b9f2621a1a4fe4b48cd265537953ae', '4065edd1c6a247cc8b27659d80080cd4', '9ee3b6de7cd142faab4180f6cbb1c3fc', '733a121c24e44945bbdfaa707f938662', '销售商模板管理', 'templateManage', null, '2', '5', '0', 'sellerJoinTemplate', null, null, '2017-11-27 14:47:00', '2017-12-06 20:16:17');
INSERT INTO `upms_menu` VALUES ('f513680b215a47a18d0502071709f1e5', null, 'e766842e3eee48b7b0e88edbb9ba5a3b', '733a121c24e44945bbdfaa707f938662', '页面专题', 'feature', null, '2', '4', '0', 'feature', null, null, '2017-11-27 14:43:08', '2017-12-06 20:25:17');
INSERT INTO `upms_menu` VALUES ('f533e89313be4fe3a2c2e2a3ffec4f90', '1a9cabad5f4545e39dce92d63187dd65', 'd6d32c5ac8c84c91b85018714998abc3', '733a121c24e44945bbdfaa707f938662', '客户列表', 'customList', null, '2', '3', '0', 'list', null, null, '2017-11-27 14:37:38', '2018-01-11 18:41:29');
INSERT INTO `upms_menu` VALUES ('f858ec1bb4724b57ace66631dac0d699', '618b85c59bcb476ab80b022f678bb14f', '1e06b3825bf94898a39d5863e3aef154', '733a121c24e44945bbdfaa707f938662', '编辑', 'edit', null, '2', '4', '0', 'edit', null, null, '2017-11-27 14:43:55', '2017-12-06 20:24:05');
INSERT INTO `upms_menu` VALUES ('fa77d03f48784210aa4859dce7cb8f32', '8539771ff5f440349759179cd1e046c1', '85a0792127764549bee48bf47d43e337', '733a121c24e44945bbdfaa707f938662', '通知', 'notifi', null, '2', '2', '0', 'notifi', null, null, '2017-11-27 14:50:55', '2017-12-06 20:29:28');
INSERT INTO `upms_menu` VALUES ('fb1b77d621c742fd8ce30ea6e5ea77dd', null, '0', '733a121c24e44945bbdfaa707f938662', '统计分析', 'stat', 'fa fa-bar-chart', '1', '21', '1', 'stat', null, null, '2017-11-27 14:17:06', '2017-12-06 20:25:25');

-- ----------------------------
-- Table structure for upms_module
-- ----------------------------
DROP TABLE IF EXISTS `upms_module`;
CREATE TABLE `upms_module` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `system_id` varchar(32) NOT NULL COMMENT '所属系统ID',
  `module_name` varchar(30) NOT NULL COMMENT '模块名称',
  `module_code` varchar(22) NOT NULL COMMENT '模块编码',
  `is_parent` smallint(1) DEFAULT NULL COMMENT '是否上级节点',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '上级模块ID',
  `order_list` int(11) DEFAULT NULL COMMENT '排序',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '对应cc_department表，机构ID',
  `data_area` varchar(200) DEFAULT NULL COMMENT '数据域',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_data_area` (`data_area`),
  KEY `_module_code` (`module_code`),
  KEY `_parent_id` (`parent_id`),
  KEY `_system_id` (`system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='功能模块表';

-- ----------------------------
-- Records of upms_module
-- ----------------------------
INSERT INTO `upms_module` VALUES ('0', '', '根节点', 'S0', null, null, null, null, null, null, null);
INSERT INTO `upms_module` VALUES ('005e7e6b48254c378f778cc5257460dc', '032bf3b5dc254458bd48c56a34e9159f', '采购入库管理', 'purchaseInstock', '0', 'c82f49c1f8b04cae9e377373da2a90b6', '3', null, null, '2017-11-30 11:55:27', '2017-11-30 16:06:34');
INSERT INTO `upms_module` VALUES ('01b9a302bcf0422b894d20e519cfda68', '733a121c24e44945bbdfaa707f938662', '入库明细', 'storage_detail', '0', 'd3f0e980f998480d8ccefdfeae924b28', '5', null, null, '2017-11-27 20:26:22', '2017-12-01 10:24:51');
INSERT INTO `upms_module` VALUES ('065cf65f6fb24fb9b20eb0f903b28090', '733a121c24e44945bbdfaa707f938662', '公司客户', 'customerCrop', '0', '2d42f08d052a442a81e858548948712b', '1', null, null, '2018-01-28 17:14:56', null);
INSERT INTO `upms_module` VALUES ('07d20af218af4467937de425e370bbee', '733a121c24e44945bbdfaa707f938662', '模板', 'option', '1', '0', '19', null, null, '2017-11-27 19:52:35', '2017-11-30 16:03:25');
INSERT INTO `upms_module` VALUES ('083f4c73b82348e7a3487a09098fc3d2', '733a121c24e44945bbdfaa707f938662', '模板安装', 'templetInstall', '0', '07d20af218af4467937de425e370bbee', '2', null, null, '2017-11-28 16:10:05', null);
INSERT INTO `upms_module` VALUES ('0946c35507db4e30b8be0877aca645f0', '733a121c24e44945bbdfaa707f938662', '基础数据', 'records', '1', '0', '21', null, null, '2017-11-27 19:50:42', '2017-11-30 16:05:13');
INSERT INTO `upms_module` VALUES ('098129772bd34c4fae3ca9c0e602f4d2', '733a121c24e44945bbdfaa707f938662', '系统管理', 'system_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '6', null, null, '2017-11-10 15:24:20', null);
INSERT INTO `upms_module` VALUES ('09b98e08944d4bcc81984550816f2185', '733a121c24e44945bbdfaa707f938662', '功能管理', 'operation_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '7', null, null, '2017-11-10 15:25:57', '2017-11-10 15:26:11');
INSERT INTO `upms_module` VALUES ('09d24c0204a1464592a801813c72485e', '733a121c24e44945bbdfaa707f938662', '报表查询', 'report', '1', '0', '5', null, null, '2017-12-12 12:00:30', '2017-12-12 12:02:12');
INSERT INTO `upms_module` VALUES ('0c6005912bcb4d4590c9b8383321b13c', '733a121c24e44945bbdfaa707f938662', '通知', 'notification', '0', '7398f5e0af9f4c8797c6e72d9837daf0', '2', null, null, '2017-11-27 20:12:02', '2017-11-27 20:12:22');
INSERT INTO `upms_module` VALUES ('0c7f07e358f3421eb6c3d88cad282a8f', '032bf3b5dc254458bd48c56a34e9159f', 'bi报表', 'bi_report', '0', 'd5f6cbdefd6b40a3bc287135fc277a8d', '7', null, null, '2018-01-31 15:53:02', null);
INSERT INTO `upms_module` VALUES ('1673fc27bd6d4dc6a3d0c1e9c31b9e1f', '733a121c24e44945bbdfaa707f938662', '模型管理', 'model_manage', '0', '85fd038ce5f34c3c8f30355352fb568b', '2', null, null, '2017-11-27 20:29:07', null);
INSERT INTO `upms_module` VALUES ('1983027de3654205b1f82258857fa4b8', '032bf3b5dc254458bd48c56a34e9159f', '销售管理', 'order', '1', '0', '2', null, null, '2017-10-23 17:31:30', '2017-11-30 16:02:06');
INSERT INTO `upms_module` VALUES ('1b5f5d36f33c4ea2ab1b38a0604a549e', '733a121c24e44945bbdfaa707f938662', '基础客户', 'customer_list', '0', '2d42f08d052a442a81e858548948712b', '2', null, null, '2017-11-01 10:21:23', '2018-01-11 19:23:20');
INSERT INTO `upms_module` VALUES ('2088c899d43c40a5970551a5b082ec83', '733a121c24e44945bbdfaa707f938662', '我管理的直营商', 'manageSeller', '0', '09d24c0204a1464592a801813c72485e', '8', null, null, '2017-12-19 15:18:28', '2017-12-19 15:21:19');
INSERT INTO `upms_module` VALUES ('225379b235e448e699621a421694179a', '733a121c24e44945bbdfaa707f938662', '库存盘点', 'stockTaking', '0', 'd3f0e980f998480d8ccefdfeae924b28', '2', null, null, '2017-11-27 20:06:49', '2017-11-27 20:07:44');
INSERT INTO `upms_module` VALUES ('247dd6925526421bb6007e2f908f45e6', '733a121c24e44945bbdfaa707f938662', '数据字典', 'dict', '0', '0946c35507db4e30b8be0877aca645f0', '1', null, null, '2017-11-28 16:11:18', null);
INSERT INTO `upms_module` VALUES ('24b0f1fa3bfc490a850c9b33f76180bc', '733a121c24e44945bbdfaa707f938662', '我的客户详细', 'customerDetails', '0', '09d24c0204a1464592a801813c72485e', '2', null, null, '2017-12-12 14:13:55', '2017-12-19 14:56:57');
INSERT INTO `upms_module` VALUES ('275602bcf164416f95ca581eb0722cfa', '733a121c24e44945bbdfaa707f938662', '供应商管理', 'supplier', '0', '98d20c6c3109488e891392e83fbd78e5', '1', null, null, '2017-11-10 15:30:40', null);
INSERT INTO `upms_module` VALUES ('27a54a8c7ccd43d992d956bd23d3f655', '032bf3b5dc254458bd48c56a34e9159f', '销售退货入库', 'salesInstock', '0', '1983027de3654205b1f82258857fa4b8', '4', null, null, '2018-01-05 10:58:34', null);
INSERT INTO `upms_module` VALUES ('28d97b39e53940e1be546d2dd6801c7e', '733a121c24e44945bbdfaa707f938662', '附件', 'attachment', '1', '0', '11', null, null, '2017-11-27 20:17:03', '2017-11-30 16:03:42');
INSERT INTO `upms_module` VALUES ('2a7818f5b1fb409a9d908f3aa9fcd737', '733a121c24e44945bbdfaa707f938662', '商品信息管理', 'good_info_manage', '0', '98d20c6c3109488e891392e83fbd78e5', '8', null, null, '2017-11-10 17:14:28', '2017-11-28 16:51:26');
INSERT INTO `upms_module` VALUES ('2cbfa15643ac451fb1b6f3ee0cde466b', '733a121c24e44945bbdfaa707f938662', '产品管理', 'productManage', '0', 'a2f29232a0d84751b73ef37e156244ca', '2', null, null, '2017-11-15 11:45:02', null);
INSERT INTO `upms_module` VALUES ('2d42f08d052a442a81e858548948712b', '733a121c24e44945bbdfaa707f938662', '客户管理', 'customer', '1', '0', '6', null, null, '2017-11-01 10:20:33', '2017-11-30 16:02:57');
INSERT INTO `upms_module` VALUES ('343564b495ed44f3a529af2c08b94e6b', '733a121c24e44945bbdfaa707f938662', '账款管理', 'arrearages', '1', '0', '3', null, null, '2017-11-30 15:12:23', null);
INSERT INTO `upms_module` VALUES ('361ab445b97246d5b712dd37edc7a028', '733a121c24e44945bbdfaa707f938662', '销售商管理', 'seller', '0', 'a2f29232a0d84751b73ef37e156244ca', '1', null, null, '2017-11-15 11:43:52', null);
INSERT INTO `upms_module` VALUES ('3a263c58cdb0481db511e0c6d0034412', '733a121c24e44945bbdfaa707f938662', '打印模板管理', 'printTemplate', '0', 'a2f29232a0d84751b73ef37e156244ca', '3', null, null, '2017-11-15 11:46:01', null);
INSERT INTO `upms_module` VALUES ('3be9ab17548d428ba8d15f6b029c657b', '733a121c24e44945bbdfaa707f938662', '客户拜访', 'customer_visit', '0', '2d42f08d052a442a81e858548948712b', '4', null, null, '2017-12-06 16:42:47', '2017-12-06 16:45:54');
INSERT INTO `upms_module` VALUES ('3be9bed11b9e4a8bbaab31323ffc8284', '733a121c24e44945bbdfaa707f938662', '应收账款', 'receivable', '0', '343564b495ed44f3a529af2c08b94e6b', '1', null, null, '2017-11-30 16:17:56', null);
INSERT INTO `upms_module` VALUES ('42060d81147945ccb1207968d96bcf78', '733a121c24e44945bbdfaa707f938662', '品牌管理', 'brand_manage', '0', '98d20c6c3109488e891392e83fbd78e5', '6', null, null, '2017-11-10 17:12:37', null);
INSERT INTO `upms_module` VALUES ('476f020988244e019793dd569b61c097', '733a121c24e44945bbdfaa707f938662', '活动投放', 'activePut', '0', 'cf54634ec9534a61aae51f18cf2019fd', '2', null, null, '2018-02-28 10:20:34', null);
INSERT INTO `upms_module` VALUES ('49197155d74740409250b73c1e7c775a', '733a121c24e44945bbdfaa707f938662', '商品规格值', 'spe_value_manage', '0', '98d20c6c3109488e891392e83fbd78e5', '3', null, null, '2017-11-10 15:53:35', '2017-11-28 16:50:41');
INSERT INTO `upms_module` VALUES ('493abdb340604636b25a414e0a5d0310', '733a121c24e44945bbdfaa707f938662', '撰写内容', 'edit', '0', 'f63e03ef77174ff2b676e343852d0695', '2', null, null, '2017-11-28 16:08:14', '2017-11-30 17:49:25');
INSERT INTO `upms_module` VALUES ('4bd706b15a674e50a93c3d4f440bdc43', '733a121c24e44945bbdfaa707f938662', '微信设置', 'wechat-settings', '0', 'fc9ec5e086f94ea6a45ee102c441d2cb', '4', null, null, '2017-11-27 20:20:11', null);
INSERT INTO `upms_module` VALUES ('4be383b892944577808ef688c4cc556e', '733a121c24e44945bbdfaa707f938662', '我部门的业务员', 'departSalesman', '0', '09d24c0204a1464592a801813c72485e', '6', null, null, '2017-12-19 15:18:09', null);
INSERT INTO `upms_module` VALUES ('4c1b0cc698d443d38ee2cb30e958478d', '032bf3b5dc254458bd48c56a34e9159f', '业务员排行榜', 'user_rank', '0', 'd5f6cbdefd6b40a3bc287135fc277a8d', '1', null, null, '2017-12-21 19:54:12', null);
INSERT INTO `upms_module` VALUES ('4dadebc483ee40ed9d98929a4ca0a1fb', '733a121c24e44945bbdfaa707f938662', '设置', 'option', '0', '07d20af218af4467937de425e370bbee', '3', null, null, '2017-11-28 16:10:16', null);
INSERT INTO `upms_module` VALUES ('4ef02ea9a3124d42afa8e10864ac19fd', '733a121c24e44945bbdfaa707f938662', '组织机构管理', 'department_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '8', null, null, '2017-11-10 15:27:09', null);
INSERT INTO `upms_module` VALUES ('527624cf02be4732b669a4a407d9675e', '733a121c24e44945bbdfaa707f938662', '统计分析', 'statistic_analysis', '1', '0', '21', null, null, '2017-11-27 20:21:03', '2017-11-30 16:02:21');
INSERT INTO `upms_module` VALUES ('532c7eea6bc8419ca2f97cddd818a6cc', '733a121c24e44945bbdfaa707f938662', '流程管理', 'workflow', '0', '85fd038ce5f34c3c8f30355352fb568b', '1', null, null, '2017-11-28 16:06:44', null);
INSERT INTO `upms_module` VALUES ('53712f187f1d4b829341cdc4bcf7adf0', '032bf3b5dc254458bd48c56a34e9159f', '库存详情', 'inventory', '0', 'd5f6cbdefd6b40a3bc287135fc277a8d', '6', null, null, '2018-01-10 09:14:03', null);
INSERT INTO `upms_module` VALUES ('539adff6205843a3af4925dcdabeeb8a', '733a121c24e44945bbdfaa707f938662', '活动申请', 'activityApply', '0', 'cf54634ec9534a61aae51f18cf2019fd', '10', null, null, '2018-01-19 09:30:41', '2018-01-19 15:38:49');
INSERT INTO `upms_module` VALUES ('54bd67af09804c6aa6ea5c8af242a63b', '733a121c24e44945bbdfaa707f938662', '内容分类', 'category', '0', 'f63e03ef77174ff2b676e343852d0695', '3', null, null, '2017-11-28 16:08:29', '2017-11-30 17:49:40');
INSERT INTO `upms_module` VALUES ('5643590d903c4d6fbcafeabfb55ae473', '733a121c24e44945bbdfaa707f938662', '客户列表', 'seller_customer', '0', '2d42f08d052a442a81e858548948712b', '3', null, null, '2017-11-29 10:34:38', '2018-01-11 19:23:31');
INSERT INTO `upms_module` VALUES ('57ee03939e1343e5b5867087efe973e0', '733a121c24e44945bbdfaa707f938662', '出库明细', 'removal_detail', '0', 'd3f0e980f998480d8ccefdfeae924b28', '6', null, null, '2017-11-27 20:26:47', '2017-12-01 10:25:08');
INSERT INTO `upms_module` VALUES ('60dd40330a16436eb97ef8039e08e5b2', '733a121c24e44945bbdfaa707f938662', '用户权限', 'admin', '0', '0', '10', null, null, '2017-10-31 17:12:16', '2017-11-30 16:04:11');
INSERT INTO `upms_module` VALUES ('63c58aff2e264eb48859f1737efa4120', '032bf3b5dc254458bd48c56a34e9159f', '销售订单出库', 'salesoutstock', '0', '1983027de3654205b1f82258857fa4b8', '3', null, null, '2017-11-30 16:10:02', '2018-01-05 10:57:41');
INSERT INTO `upms_module` VALUES ('63f693044d5945d4a7b727deb5f1db5e', '733a121c24e44945bbdfaa707f938662', '常规', '通知', '0', '7398f5e0af9f4c8797c6e72d9837daf0', '1', null, null, '2017-11-27 20:09:17', null);
INSERT INTO `upms_module` VALUES ('677593701e684ab0897348804aaf781c', '733a121c24e44945bbdfaa707f938662', '组合商品管理', 'productComposition', '0', 'a2f29232a0d84751b73ef37e156244ca', '10', null, null, '2017-11-17 10:10:39', null);
INSERT INTO `upms_module` VALUES ('67f28d02b39147c5b6b988c1850f061c', '733a121c24e44945bbdfaa707f938662', '应付账款', 'payables', '0', '343564b495ed44f3a529af2c08b94e6b', '2', null, null, '2017-11-30 14:59:18', '2017-11-30 15:13:45');
INSERT INTO `upms_module` VALUES ('70a85e266d364ca980afca2df27b61c2', '733a121c24e44945bbdfaa707f938662', '用户管理', 'user_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '1', null, null, '2017-11-10 15:13:53', '2017-11-10 15:18:25');
INSERT INTO `upms_module` VALUES ('7398f5e0af9f4c8797c6e72d9837daf0', '733a121c24e44945bbdfaa707f938662', '系统设置', 'option', '1', '0', '22', null, null, '2017-11-27 19:51:23', '2017-11-30 16:05:20');
INSERT INTO `upms_module` VALUES ('76d02b1f780549bd89598a181036c5ed', '733a121c24e44945bbdfaa707f938662', '地区', 'area', '0', '0946c35507db4e30b8be0877aca645f0', '2', null, null, '2017-11-28 16:11:22', '2017-11-28 16:11:51');
INSERT INTO `upms_module` VALUES ('79eb8530cf7842dd8d91af99b3d026d9', '733a121c24e44945bbdfaa707f938662', '菜单管理', 'menu_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '4', null, null, '2017-11-10 15:21:36', null);
INSERT INTO `upms_module` VALUES ('7b15c61d296a49c5b204411a38007039', '733a121c24e44945bbdfaa707f938662', '微信消息模板', 'message', '0', 'fc9ec5e086f94ea6a45ee102c441d2cb', '5', null, null, '2017-12-07 13:59:24', '2017-12-07 14:01:09');
INSERT INTO `upms_module` VALUES ('7cad743abfcb4e55b540e156eca36d8b', '733a121c24e44945bbdfaa707f938662', '商品分类管理', 'category_manage', '0', '98d20c6c3109488e891392e83fbd78e5', '5', null, null, '2017-11-10 17:11:13', '2017-11-10 17:11:54');
INSERT INTO `upms_module` VALUES ('7f085e5ab06442ae8b00ca1f1aa1c2e4', '733a121c24e44945bbdfaa707f938662', '库存总账', 'inventory', '0', 'd3f0e980f998480d8ccefdfeae924b28', '4', null, null, '2017-11-28 16:00:25', '2017-11-30 16:10:49');
INSERT INTO `upms_module` VALUES ('80591f838f3f4895bac6dbdacbcc4768', '032bf3b5dc254458bd48c56a34e9159f', '业务员报表', 'user_report', '0', 'd5f6cbdefd6b40a3bc287135fc277a8d', '2', null, null, '2017-12-21 19:54:30', null);
INSERT INTO `upms_module` VALUES ('821312b533f44f05977c7eb1471175e1', '733a121c24e44945bbdfaa707f938662', '默认回复', 'default-response', '0', 'fc9ec5e086f94ea6a45ee102c441d2cb', '2', null, null, '2017-11-27 20:19:28', null);
INSERT INTO `upms_module` VALUES ('8436b1b93e554fb68638056c3b1fa69c', '733a121c24e44945bbdfaa707f938662', 'SQL分析', 'analyse', '0', '527624cf02be4732b669a4a407d9675e', '4', null, null, '2017-11-27 20:27:05', null);
INSERT INTO `upms_module` VALUES ('85a2b80017c44a46a4dd323fda4172e4', '733a121c24e44945bbdfaa707f938662', '统计概要', 'statistic_summary', '0', '527624cf02be4732b669a4a407d9675e', '1', null, null, '2017-11-27 20:21:56', '2017-11-27 20:22:57');
INSERT INTO `upms_module` VALUES ('85fd038ce5f34c3c8f30355352fb568b', '733a121c24e44945bbdfaa707f938662', '流程管理', 'process', '1', '0', '7', null, null, '2017-11-27 19:56:52', '2017-11-27 20:24:44');
INSERT INTO `upms_module` VALUES ('8f5636a02dc74d5c8ddc4b0d4392658b', '733a121c24e44945bbdfaa707f938662', '页面专题', 'page_project', '0', 'f63e03ef77174ff2b676e343852d0695', '4', null, null, '2017-11-27 20:28:49', '2017-11-27 20:31:10');
INSERT INTO `upms_module` VALUES ('9295c9025e074b7492adca0f1dd0ac2f', '733a121c24e44945bbdfaa707f938662', '我部门的业务员详细', 'mSalesmanDetail', '0', '09d24c0204a1464592a801813c72485e', '7', null, null, '2017-12-19 15:19:55', '2017-12-19 15:34:27');
INSERT INTO `upms_module` VALUES ('92faab8a1d5d438ca46ec24a51c55897', '733a121c24e44945bbdfaa707f938662', '商品类型管理', 'good_type_manage', '0', '98d20c6c3109488e891392e83fbd78e5', '4', null, null, '2017-11-10 16:30:59', '2017-11-10 17:11:44');
INSERT INTO `upms_module` VALUES ('94033f4cca0246d993f4d5b52ae2064f', '032bf3b5dc254458bd48c56a34e9159f', '销售订货单', 'salesOrder', '0', '1983027de3654205b1f82258857fa4b8', '1', null, null, '2017-10-23 17:40:42', '2017-11-24 14:47:43');
INSERT INTO `upms_module` VALUES ('96aaae59d3614a3fb70e71794c91d91c', '733a121c24e44945bbdfaa707f938662', '菜单设置', 'menu-settings', '0', 'fc9ec5e086f94ea6a45ee102c441d2cb', '3', null, null, '2017-11-27 20:19:53', null);
INSERT INTO `upms_module` VALUES ('9762cc9823e049b8ad63a640a2de189d', '733a121c24e44945bbdfaa707f938662', '我管理的直营商详细', 'mSellerDetail', '0', '09d24c0204a1464592a801813c72485e', '9', null, null, '2017-12-19 15:19:11', '2017-12-19 15:22:16');
INSERT INTO `upms_module` VALUES ('97ca779973a34ce8b5f30ee96dbab265', '733a121c24e44945bbdfaa707f938662', '商品属性管理', 'goodAttribute_manage', '0', '98d20c6c3109488e891392e83fbd78e5', '7', null, null, '2017-11-10 17:13:56', null);
INSERT INTO `upms_module` VALUES ('98d20c6c3109488e891392e83fbd78e5', '733a121c24e44945bbdfaa707f938662', '商品库管理', 'goods_manage', '1', '0', '8', null, null, '2017-11-10 15:29:40', '2017-11-30 16:03:10');
INSERT INTO `upms_module` VALUES ('9bbb052f7ed04105905af3a789b15b5f', '733a121c24e44945bbdfaa707f938662', '系统日志', 'system_log', '0', '527624cf02be4732b669a4a407d9675e', '5', null, null, '2017-11-27 20:27:52', null);
INSERT INTO `upms_module` VALUES ('9c30532ccf134223ad166eb49dcb456c', '733a121c24e44945bbdfaa707f938662', '我的产品详细', 'productReport', '0', '09d24c0204a1464592a801813c72485e', '4', null, null, '2017-12-19 14:57:52', null);
INSERT INTO `upms_module` VALUES ('9e76239527e84e86ada6959fd3dcceb5', '733a121c24e44945bbdfaa707f938662', 'APP菜单', 'menu', '0', '07d20af218af4467937de425e370bbee', '5', null, null, '2017-11-30 17:44:05', null);
INSERT INTO `upms_module` VALUES ('9f4c5d0c2eaf4479aaf7138791758407', '032bf3b5dc254458bd48c56a34e9159f', '业务经理报表', 'user_manager_report', '0', 'd5f6cbdefd6b40a3bc287135fc277a8d', '4', null, null, '2017-12-21 19:55:38', null);
INSERT INTO `upms_module` VALUES ('a0c15f5ec7eb4b0f8d3195013f0d9d00', '733a121c24e44945bbdfaa707f938662', '模块管理', 'module_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '9', null, null, '2017-11-10 15:28:36', null);
INSERT INTO `upms_module` VALUES ('a18654f80a944e778d025930ae6b7903', '733a121c24e44945bbdfaa707f938662', '仓库管理', 'warehouse', '0', 'd3f0e980f998480d8ccefdfeae924b28', '1', null, null, '2017-11-23 15:33:10', '2017-11-24 14:45:24');
INSERT INTO `upms_module` VALUES ('a2f29232a0d84751b73ef37e156244ca', '733a121c24e44945bbdfaa707f938662', '销售商管理', 'seller', '0', '0', '9', null, null, '2017-11-15 11:42:02', '2017-11-30 16:04:01');
INSERT INTO `upms_module` VALUES ('ab140402ec514e4599421b7f1d4f9018', '032bf3b5dc254458bd48c56a34e9159f', '销售计划', 'plans', '0', '1983027de3654205b1f82258857fa4b8', '10', null, null, '2018-01-24 21:13:51', null);
INSERT INTO `upms_module` VALUES ('abae8488cb2740c4a0f208e44328f88d', '032bf3b5dc254458bd48c56a34e9159f', '销售退货单', 'salesRefund', '0', '1983027de3654205b1f82258857fa4b8', '2', null, null, '2017-11-14 09:48:15', '2018-01-05 10:57:53');
INSERT INTO `upms_module` VALUES ('aeb407412b5a40bc9eb1165e99234394', '733a121c24e44945bbdfaa707f938662', '上传', 'attachment_upload', '0', '28d97b39e53940e1be546d2dd6801c7e', '2', null, null, '2017-11-27 20:17:41', null);
INSERT INTO `upms_module` VALUES ('b10643764b3b43faaf58093af790760f', '733a121c24e44945bbdfaa707f938662', '自动回复', 'auto-response', '0', 'fc9ec5e086f94ea6a45ee102c441d2cb', '1', null, null, '2017-11-27 20:19:06', null);
INSERT INTO `upms_module` VALUES ('b2c5804056494b6baf4eeb64a23f5120', '733a121c24e44945bbdfaa707f938662', 'API应用', 'api', '0', '7398f5e0af9f4c8797c6e72d9837daf0', '4', null, null, '2017-11-27 20:09:46', '2017-11-30 14:45:18');
INSERT INTO `upms_module` VALUES ('b392bd3880004c4aa1d1acd7e063495a', '733a121c24e44945bbdfaa707f938662', '客户类型', 'customer_type', '0', '2d42f08d052a442a81e858548948712b', '5', null, null, '2017-11-01 10:22:16', '2017-12-06 16:43:00');
INSERT INTO `upms_module` VALUES ('b649adfd9b7f4f6fa138222ecb75889c', '733a121c24e44945bbdfaa707f938662', '所有附件', 'attachment', '0', '28d97b39e53940e1be546d2dd6801c7e', '1', null, null, '2017-11-27 20:17:28', null);
INSERT INTO `upms_module` VALUES ('bac8ec6534a34accac89a0c863e568fe', '733a121c24e44945bbdfaa707f938662', '岗位管理', 'station_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '5', null, null, '2017-11-10 15:22:15', null);
INSERT INTO `upms_module` VALUES ('bc87828363fd4d438bc17b4a2a2eb86d', '733a121c24e44945bbdfaa707f938662', '编辑', 'edit', '0', '07d20af218af4467937de425e370bbee', '4', null, null, '2017-11-28 16:10:25', null);
INSERT INTO `upms_module` VALUES ('bee82d5bdae34d8eb00c94669d587164', '733a121c24e44945bbdfaa707f938662', '产品总计', 'productTotal', '0', '09d24c0204a1464592a801813c72485e', '2', null, null, '2018-01-02 11:01:16', '2018-01-02 14:29:10');
INSERT INTO `upms_module` VALUES ('bf2837b1d79c4be2aa7db9fea7705ec8', '032bf3b5dc254458bd48c56a34e9159f', '采购退货单', 'purchaseRefundOut', '0', 'c82f49c1f8b04cae9e377373da2a90b6', '2', null, null, '2017-11-29 15:33:19', '2017-11-30 16:06:18');
INSERT INTO `upms_module` VALUES ('c82f49c1f8b04cae9e377373da2a90b6', '032bf3b5dc254458bd48c56a34e9159f', '采购管理', 'procurement', '1', '0', '1', null, null, '2017-11-30 16:00:23', '2017-11-30 16:01:08');
INSERT INTO `upms_module` VALUES ('c9a51ebfa468471d9dc4dbb3d86c26a2', '733a121c24e44945bbdfaa707f938662', '定制化服务', 'option_seller', '0', '7398f5e0af9f4c8797c6e72d9837daf0', '5', null, null, '2017-12-11 20:35:54', null);
INSERT INTO `upms_module` VALUES ('cbb8c2bb081d48639ffe8201c569dbb3', '733a121c24e44945bbdfaa707f938662', '库存详细', 'inventoryDetail', '0', '09d24c0204a1464592a801813c72485e', '1', null, null, '2017-12-12 16:19:43', '2017-12-19 14:56:04');
INSERT INTO `upms_module` VALUES ('cc3a1bd4abac4ed58cb68f024083d321', '733a121c24e44945bbdfaa707f938662', '我的客户类型', 'clientTypeReport', '0', '09d24c0204a1464592a801813c72485e', '3', null, null, '2017-12-19 14:57:34', null);
INSERT INTO `upms_module` VALUES ('cc70503f28f849a49d907eb76fa074b7', '733a121c24e44945bbdfaa707f938662', '直营商采购详细', 'purSeller', '0', '09d24c0204a1464592a801813c72485e', '10', null, null, '2017-12-19 15:20:21', '2017-12-20 20:07:23');
INSERT INTO `upms_module` VALUES ('ce505ef74f0e4217b54239fe4082a601', '032bf3b5dc254458bd48c56a34e9159f', '品牌经理报表', 'brand_manager_report', '0', 'd5f6cbdefd6b40a3bc287135fc277a8d', '5', null, null, '2017-12-21 19:56:15', null);
INSERT INTO `upms_module` VALUES ('cf54634ec9534a61aae51f18cf2019fd', '733a121c24e44945bbdfaa707f938662', '活动管理', 'activity', '1', '0', '9', null, null, '2018-01-17 10:24:39', '2018-01-19 15:38:57');
INSERT INTO `upms_module` VALUES ('d04a899d85b6434da559e2aeb3bbb844', '733a121c24e44945bbdfaa707f938662', 'CDN加速', 'cdn', '0', '7398f5e0af9f4c8797c6e72d9837daf0', '3', null, null, '2017-11-27 20:09:32', '2017-11-27 20:12:36');
INSERT INTO `upms_module` VALUES ('d3f0e980f998480d8ccefdfeae924b28', '733a121c24e44945bbdfaa707f938662', '库存管理', 'warehouse', '1', '0', '4', null, null, '2017-11-23 15:32:23', '2017-11-30 16:02:14');
INSERT INTO `upms_module` VALUES ('d5f6cbdefd6b40a3bc287135fc277a8d', '032bf3b5dc254458bd48c56a34e9159f', '前台报表', 'report_app', '1', '0', '23', null, null, '2017-12-21 19:53:40', '2017-12-21 19:57:09');
INSERT INTO `upms_module` VALUES ('d803195c228644b3913d81a292bd952a', '733a121c24e44945bbdfaa707f938662', '活动列表', 'activityList', '0', 'cf54634ec9534a61aae51f18cf2019fd', '1', null, null, '2018-01-17 10:27:33', '2018-01-19 15:38:55');
INSERT INTO `upms_module` VALUES ('d91f54d8489f4bff947d73def74b003a', '733a121c24e44945bbdfaa707f938662', '商品规格', 'specification_manage', '0', '98d20c6c3109488e891392e83fbd78e5', '2', null, null, '2017-11-10 15:52:11', '2017-11-28 16:50:27');
INSERT INTO `upms_module` VALUES ('dd05bc34b9084963bc8c43092ade5ddb', '032bf3b5dc254458bd48c56a34e9159f', '第三方订单管理', 'other_order_manager', '0', '1983027de3654205b1f82258857fa4b8', '6', null, null, '2018-01-29 10:32:37', '2018-01-29 10:34:41');
INSERT INTO `upms_module` VALUES ('e075c21d45d04000975d627ddb2b8d5f', '733a121c24e44945bbdfaa707f938662', '所有模板', 'templet', '0', '07d20af218af4467937de425e370bbee', '1', null, null, '2017-11-28 16:09:52', null);
INSERT INTO `upms_module` VALUES ('e0c711f8d63c49e89c1d5a06226f2f77', '733a121c24e44945bbdfaa707f938662', '分组管理', 'group_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '2', null, null, '2017-11-10 15:19:07', null);
INSERT INTO `upms_module` VALUES ('e117b8f7b1234d29bb40919e701de65d', '733a121c24e44945bbdfaa707f938662', '内容列表', 'list', '0', 'f63e03ef77174ff2b676e343852d0695', '1', null, null, '2017-11-28 16:08:03', '2017-11-30 17:47:55');
INSERT INTO `upms_module` VALUES ('e4acfabae81149aeaceabb1b1bdede25', '733a121c24e44945bbdfaa707f938662', '库存调拨', 'KCDB', '0', 'd3f0e980f998480d8ccefdfeae924b28', '3', null, null, '2017-11-27 20:06:42', '2017-11-28 15:58:34');
INSERT INTO `upms_module` VALUES ('e5ea1d7b84e94e7a9cfb0c4660380a2d', '733a121c24e44945bbdfaa707f938662', '价格体系', 'price_system', '0', '2d42f08d052a442a81e858548948712b', '6', null, null, '2017-11-01 10:24:45', '2017-12-06 16:43:11');
INSERT INTO `upms_module` VALUES ('e61a88cfbf7343a18419d70cd4b346a1', '032bf3b5dc254458bd48c56a34e9159f', '采购订货单', 'purchaseOrder', '0', 'c82f49c1f8b04cae9e377373da2a90b6', '1', null, null, '2017-11-23 11:47:46', '2017-11-30 16:05:52');
INSERT INTO `upms_module` VALUES ('ec7c0214211541d9a8ffb63ee844da37', '733a121c24e44945bbdfaa707f938662', '角色管理', 'role_manage', '0', '60dd40330a16436eb97ef8039e08e5b2', '3', null, null, '2017-11-10 15:20:04', null);
INSERT INTO `upms_module` VALUES ('ece49dfb8a6f47b6a57eae891e9fab2d', '032bf3b5dc254458bd48c56a34e9159f', '业务主管报表', 'user_charge_report', '0', 'd5f6cbdefd6b40a3bc287135fc277a8d', '3', null, null, '2017-12-21 19:55:25', null);
INSERT INTO `upms_module` VALUES ('f32b39382f6c492fa2165d8fe77bc29b', '733a121c24e44945bbdfaa707f938662', '客户仓库', 'customerStore', '0', '2d42f08d052a442a81e858548948712b', '1', null, null, '2018-01-11 19:22:57', null);
INSERT INTO `upms_module` VALUES ('f626cc516d124c8da969c530f7c34424', '733a121c24e44945bbdfaa707f938662', '我部门的产品详细', 'deptProductReport', '0', '09d24c0204a1464592a801813c72485e', '5', null, null, '2017-12-19 15:17:51', null);
INSERT INTO `upms_module` VALUES ('f63e03ef77174ff2b676e343852d0695', '733a121c24e44945bbdfaa707f938662', '内容管理', 'article', '1', '0', '20', null, null, '2017-11-27 19:56:31', '2017-11-30 17:47:41');
INSERT INTO `upms_module` VALUES ('f8c672f5fcea41fcab5318d7a3783272', '733a121c24e44945bbdfaa707f938662', '销售商模板管理', 'sellerJoinTemplate', '0', 'a2f29232a0d84751b73ef37e156244ca', '4', null, null, '2017-11-17 09:23:51', '2017-11-17 15:35:15');
INSERT INTO `upms_module` VALUES ('fc9ec5e086f94ea6a45ee102c441d2cb', '733a121c24e44945bbdfaa707f938662', '微信', 'wechat', '1', '0', '18', null, null, '2017-11-27 20:18:15', '2017-11-30 16:02:39');

-- ----------------------------
-- Table structure for upms_operation
-- ----------------------------
DROP TABLE IF EXISTS `upms_operation`;
CREATE TABLE `upms_operation` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `module_id` varchar(32) NOT NULL COMMENT '所属模块',
  `module_name` varchar(30) NOT NULL COMMENT '模块名称',
  `operation_name` varchar(30) NOT NULL COMMENT '功能名称',
  `operation_code` varchar(30) NOT NULL COMMENT '功能编码',
  `url` varchar(200) NOT NULL COMMENT '功能URL',
  `is_privilege` smallint(1) DEFAULT NULL COMMENT '是否权限验证',
  `is_splite_page` smallint(1) DEFAULT NULL COMMENT '是否分页',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `order_list` int(11) DEFAULT NULL COMMENT '排序',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '对应cc_department表，机构ID',
  `data_area` varchar(200) DEFAULT NULL COMMENT '数据域',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_data_area` (`data_area`),
  KEY `_module_id` (`module_id`),
  KEY `_operation_code` (`operation_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统所有的功能点';

-- ----------------------------
-- Records of upms_operation
-- ----------------------------
INSERT INTO `upms_operation` VALUES ('003aabbea2bd4e02ad4117e7c3e39477', 'aeb407412b5a40bc9eb1165e99234394', '上传', '上传附件', '/admin/attachment/upload', '/admin/attachment/upload', '1', null, null, '2', null, null, '2017-11-28 16:34:09', '2017-11-28 16:37:26');
INSERT INTO `upms_operation` VALUES ('03ad8310e582447883a26c80a600e216', '42060d81147945ccb1207968d96bcf78', '品牌管理', '品牌编辑权限', '/admin/brand/edit', '/admin/brand/edit', '1', null, null, '10', null, null, '2017-11-13 10:29:24', null);
INSERT INTO `upms_operation` VALUES ('04abeceff3b74cb5be43f59d66ef990c', '361ab445b97246d5b712dd37edc7a028', '销售商管理', '销售商管理', '/admin/seller', '/admin/seller', '1', null, null, '10', null, null, '2017-11-15 11:47:15', null);
INSERT INTO `upms_operation` VALUES ('0638ae6e8c9c4ba5812e4d493d5f8ba6', 'cc3a1bd4abac4ed58cb68f024083d321', '我的客户类型', '我的客户类型', 'clientTypeReport', '/admin/report/clientTypeReport', '1', null, null, '801', null, null, '2017-12-19 15:05:20', null);
INSERT INTO `upms_operation` VALUES ('06e3cc5dba164ff2a9d26c39c1da769e', '27a54a8c7ccd43d992d956bd23d3f655', '销售退货入库', '销售退货入库查看', '/admin/salesInstock', '/admin/salesInstock', '1', null, null, '10', null, null, '2017-11-24 14:51:30', '2018-01-05 11:04:16');
INSERT INTO `upms_operation` VALUES ('0735946955124217afe00cfd5d2ee9ec', '1673fc27bd6d4dc6a3d0c1e9c31b9e1f', '模型管理', '模型管理', '/admin/model', '/admin/model', '1', null, null, '2', null, null, '2017-11-28 17:04:44', null);
INSERT INTO `upms_operation` VALUES ('082acf269f1c4252a46ef2e603b7a584', '225379b235e448e699621a421694179a', '库存盘点', '库存盘点查看', '/admin/stockTaking', '/admin/stockTaking', '1', null, null, '1', null, null, '2017-11-28 16:14:35', null);
INSERT INTO `upms_operation` VALUES ('0ae1ef6c450146adbc84977485319dd0', '94033f4cca0246d993f4d5b52ae2064f', '销售订货单', '销售订单：直营商', '/admin/salesOrder/seller', '/admin/salesOrder/seller', '1', null, null, '10', null, null, '2017-12-13 14:27:21', '2017-12-13 15:08:16');
INSERT INTO `upms_operation` VALUES ('0d45dc574e0b47539605f4027c04f498', '7cad743abfcb4e55b540e156eca36d8b', '商品分类管理', '商品分类查看权限', '/admin/category', '/admin/category', '1', null, null, '1', null, null, '2017-11-27 18:57:25', null);
INSERT INTO `upms_operation` VALUES ('0da993e3b7d44e1aaea807fdf6b0cc37', '09b98e08944d4bcc81984550816f2185', '功能管理', '功能编辑权限', '/admin/operation/edit', '/admin/operation/edit', '1', null, null, '10', null, null, '2017-11-13 10:14:47', null);
INSERT INTO `upms_operation` VALUES ('0edc5e67eb884412b4cec55b78b7e307', '247dd6925526421bb6007e2f908f45e6', '数据字典', '数据字典', '/admin/dict', '/admin/dict', '1', null, null, '1', null, null, '2017-11-30 14:40:58', null);
INSERT INTO `upms_operation` VALUES ('124f0a3bfee740558c370942f12970e7', '63c58aff2e264eb48859f1737efa4120', '销售订单出库', '成本价打印', '/admin/salesOutstock/costPrint', '/admin/salesOutstock/costPrint', '1', null, '打印时显示成本价', '10', null, null, '2018-02-06 17:42:08', null);
INSERT INTO `upms_operation` VALUES ('15d0a07f237546e8a78fcf06565c11b1', '79eb8530cf7842dd8d91af99b3d026d9', '菜单管理', '菜单编辑权限', '/admin/menu/edit', '/admin/menu/edit', '1', null, null, '10', null, null, '2017-11-13 10:13:01', null);
INSERT INTO `upms_operation` VALUES ('15d30588128640d1b9e24e3a00938649', '2a7818f5b1fb409a9d908f3aa9fcd737', '商品信息管理', '商品信息编辑权限', '/admin/goods/edit', '/admin/goods/edit', '1', null, null, '10', null, null, '2017-11-13 10:31:27', '2017-11-28 16:52:06');
INSERT INTO `upms_operation` VALUES ('1a9cabad5f4545e39dce92d63187dd65', '5643590d903c4d6fbcafeabfb55ae473', '客户列表', '客户列表', '/admin/sellerCustomer', '/admin/sellerCustomer', '1', null, null, '10', null, null, '2017-11-29 10:38:17', '2017-11-30 10:42:31');
INSERT INTO `upms_operation` VALUES ('1ac554af512b404e82838d65f775e50e', 'cbb8c2bb081d48639ffe8201c569dbb3', '库存详细', '库存详细', '/admin/report/inventoryDetail', '/admin/report/inventoryDetail', '1', null, null, '1', null, null, '2017-12-12 16:21:04', '2018-01-02 14:28:27');
INSERT INTO `upms_operation` VALUES ('1ea85e73b4534e758a57d6fd3b56e1af', 'b10643764b3b43faaf58093af790760f', '自动回复', '自动回复', '/admin/wechat', '/admin/wechat', '1', null, null, '1', null, null, '2017-11-28 16:34:49', null);
INSERT INTO `upms_operation` VALUES ('1f3a1271014648a59cc2cecbeaa1f200', '098129772bd34c4fae3ca9c0e602f4d2', '系统管理', '系统查看权限', '/admin/systems', '/admin/systems', '1', null, null, '1', null, null, '2017-11-13 10:14:01', '2017-11-28 16:25:01');
INSERT INTO `upms_operation` VALUES ('20227b9abf254cab9b0485cac79532ab', 'a18654f80a944e778d025930ae6b7903', '仓库管理', '新增仓库权限', '/admin/warehouse/edit', '/admin/warehouse/edit', '1', null, null, '2', null, null, '2018-01-04 10:49:29', null);
INSERT INTO `upms_operation` VALUES ('20e464c0df9f446baecc89a77309dadd', 'bf2837b1d79c4be2aa7db9fea7705ec8', '采购退货单', '采购退货单', 'purchaseRefundOutstock', '/admin/purchaseRefundOutstock', '1', null, null, '10', null, null, '2017-11-29 15:34:39', '2017-11-30 16:15:16');
INSERT INTO `upms_operation` VALUES ('22b3abbbcb634d59b1733c2c3583c81a', 'd803195c228644b3913d81a292bd952a', '活动列表', '活动列表', '/admin/activity', '/admin/activity', '1', null, null, '1', null, null, '2018-01-17 10:35:52', '2018-01-17 10:41:04');
INSERT INTO `upms_operation` VALUES ('231f59600eb540daa6eeb42ed6f24c51', 'd91f54d8489f4bff947d73def74b003a', '商品规格管理', '商品规格查看权限', '/admin/specification', '/admin/specification', '1', null, null, '2', null, null, '2017-11-13 10:25:44', '2017-11-28 16:47:33');
INSERT INTO `upms_operation` VALUES ('2332ffac399a4276b41af1bacc4233a5', '9295c9025e074b7492adca0f1dd0ac2f', '我管理的业务员详细', '我部门的业务员详细', 'mSalesmanDetail', '/admin/report/mSalesmanDetail', '1', null, null, '10', null, null, '2017-12-19 15:28:44', '2017-12-19 15:34:10');
INSERT INTO `upms_operation` VALUES ('252d24f220aa40b9bcf45bcab01ae190', 'e0c711f8d63c49e89c1d5a06226f2f77', '分组管理', '分组编辑权限', '/admin/group/edit', '/admin/group/edit', '1', null, null, '10', null, null, '2017-11-13 09:54:34', null);
INSERT INTO `upms_operation` VALUES ('25811f52d97247cdbcdc2e229b22077f', '42060d81147945ccb1207968d96bcf78', '品牌管理', '品牌查看权限', '/admin/brand', '/admin/brand', '1', null, null, '10', null, null, '2017-11-13 10:29:38', null);
INSERT INTO `upms_operation` VALUES ('25e6e25b5c934e13b651880b2800a4aa', 'bac8ec6534a34accac89a0c863e568fe', '岗位管理', '岗位查看权限', '/admin/station', '/admin/station', '1', null, null, '10', null, null, '2017-11-13 10:13:38', null);
INSERT INTO `upms_operation` VALUES ('25f0329645db4a119f32a3a803276147', '4ef02ea9a3124d42afa8e10864ac19fd', '组织机构管理', '部门管理', 'department', '/admin/department', '1', null, null, '10', null, null, '2017-11-02 14:09:44', '2017-11-14 18:52:02');
INSERT INTO `upms_operation` VALUES ('285632ece63e48fa8d46ba795302aa1a', '3be9bed11b9e4a8bbaab31323ffc8284', '应收账款', '应收账款', '/admin/receivables', '/admin/receivables', '1', null, null, '7', null, null, '2017-11-30 15:02:33', '2017-11-30 16:26:58');
INSERT INTO `upms_operation` VALUES ('2efd481e9cb24977b61136abd0ba4e35', 'f32b39382f6c492fa2165d8fe77bc29b', '客户仓库', '客户仓库', '/admin/customerStore', '/admin/customerStore', '1', null, null, '1', null, null, '2018-01-11 18:43:22', '2018-01-11 19:24:20');
INSERT INTO `upms_operation` VALUES ('34472fd2028e42a28068c75c316c56a1', '70a85e266d364ca980afca2df27b61c2', '用户管理', '用户编辑权限', 'user:edit', '/admin/user/edit', '1', null, null, '10', null, null, '2017-11-06 14:30:25', '2017-11-10 17:56:16');
INSERT INTO `upms_operation` VALUES ('37ec301f9f1144fb979d57f7308bc5d2', '0c7f07e358f3421eb6c3d88cad282a8f', 'bi报表', 'bi报表权限', '/front/bi', '/front/bi', '1', null, null, '1', null, null, '2018-01-31 15:53:37', null);
INSERT INTO `upms_operation` VALUES ('398c1c06756a43fcaceec63b44bb8c11', '7f085e5ab06442ae8b00ca1f1aa1c2e4', '库存总账', '库存总账编辑', '/admin/inventory/edit', '/admin/inventory/edit', '1', null, null, '2', null, null, '2017-11-28 16:17:53', '2017-12-01 10:29:02');
INSERT INTO `upms_operation` VALUES ('3cf940b1af82409ebd43ed19c943f1d5', '27a54a8c7ccd43d992d956bd23d3f655', '销售退货入库', '销售退货入库审核', '/admin/salesInstock/check', '/admin/salesInstock/check', '1', null, null, '2', null, null, '2017-11-28 16:20:02', '2018-01-05 11:04:26');
INSERT INTO `upms_operation` VALUES ('3e427c3320804ef9a4e261f37d2dd7bc', 'e0c711f8d63c49e89c1d5a06226f2f77', '分组管理', '分组查看权限', '/admin/group', '/admin/group', '1', null, null, '10', null, null, '2017-11-13 09:53:40', '2017-11-13 09:55:05');
INSERT INTO `upms_operation` VALUES ('3ea55beb69434f689ed6216237417337', 'd91f54d8489f4bff947d73def74b003a', '商品规格管理', '商品规格编辑权限', '/admin/specification/edit', '/admin/specification/edit', '1', null, null, '2', null, null, '2017-11-13 10:26:02', '2017-11-28 16:47:49');
INSERT INTO `upms_operation` VALUES ('4065edd1c6a247cc8b27659d80080cd4', 'f8c672f5fcea41fcab5318d7a3783272', '销售商模板管理', '销售商模板管理', '/admin/sellerJoinTemplate', '/admin/sellerJoinTemplate', '1', null, null, '4', null, null, '2017-11-17 09:20:58', '2017-11-28 17:31:27');
INSERT INTO `upms_operation` VALUES ('409326538b49440fae167d0cb2e82de2', 'e117b8f7b1234d29bb40919e701de65d', '公告列表', '内容列表', '/admin/content', '/admin/content?m=article', '1', null, null, '10', null, null, '2017-11-30 17:52:14', '2017-12-01 10:59:27');
INSERT INTO `upms_operation` VALUES ('414eff5c413a466c986bcb4b43be7e0e', '275602bcf164416f95ca581eb0722cfa', '供应商管理', '供应商查看权限', '/admin/supplier', '/admin/supplier', '1', null, null, '1', null, null, '2017-11-28 16:45:40', '2017-11-28 17:07:53');
INSERT INTO `upms_operation` VALUES ('42266eb0c3394c3d87961c2c145ec235', 'cc70503f28f849a49d907eb76fa074b7', '经销商的直营商', '直营商采购详细', 'purSeller', '/admin/report/purSeller', '1', null, null, '10', null, null, '2017-12-19 15:28:09', '2017-12-20 20:06:56');
INSERT INTO `upms_operation` VALUES ('443eac0f3a024f01b7cdca36df660486', '9bbb052f7ed04105905af3a789b15b5f', '系统日志', '系统日志', '/admin/systemLog', '/admin/systemLog', '1', null, null, '5', null, null, '2017-11-28 17:03:18', null);
INSERT INTO `upms_operation` VALUES ('447056ea666c48f19b2a49d077fdd184', '5643590d903c4d6fbcafeabfb55ae473', '客户列表', '批量设置负责人', '/admin/customer/batchSetUser', '/admin/sellerCustomer/batchSetUser', '1', null, null, '3', null, null, '2017-11-01 11:40:55', '2017-11-15 09:50:18');
INSERT INTO `upms_operation` VALUES ('4a2137fa89af4f469138a15fe8cfdc5f', '96aaae59d3614a3fb70e71794c91d91c', '菜单设置', '菜单设置', '/admin/wechat/menu', '/admin/wechat/menu', '1', null, null, '3', null, null, '2017-11-28 16:59:49', null);
INSERT INTO `upms_operation` VALUES ('4b46bab569db4247b6b3fb960f3300bd', '3a263c58cdb0481db511e0c6d0034412', '打印模板管理', '打印模板管理', '/admin/printTemplate', '/admin/printTemplate', '1', null, null, '10', null, null, '2017-11-15 11:48:35', null);
INSERT INTO `upms_operation` VALUES ('51f5a89860d242b888f4201085c23db2', '7f085e5ab06442ae8b00ca1f1aa1c2e4', '库存总账', '库存总账查看', '/admin/inventory', '/admin/inventory', '1', null, null, '1', null, null, '2017-11-28 16:17:01', '2017-12-01 10:28:43');
INSERT INTO `upms_operation` VALUES ('5916c49a1f8241c39a35a5fe2444de60', '94033f4cca0246d993f4d5b52ae2064f', '销售订货单', '新增订单', '/admin/salesOrder/add', '/admin/salesOrder/add', '1', null, null, '3', null, null, '2018-01-10 10:23:42', null);
INSERT INTO `upms_operation` VALUES ('5997b876642e4b04aac787e54f9f86a7', 'b392bd3880004c4aa1d1acd7e063495a', '客户类型', '客户类型查看权限', '/admin/customerType', '/admin/customerType', '1', null, null, '3', null, null, '2017-11-01 11:45:42', '2017-11-15 10:03:32');
INSERT INTO `upms_operation` VALUES ('5c2d196b6a7345f1a5a93de42031126d', 'abae8488cb2740c4a0f208e44328f88d', '销售退货单', '新增退货单', '/admin/salesRefund/add', '/admin/salesRefund/add', '1', null, null, '3', null, null, '2018-01-10 10:24:08', null);
INSERT INTO `upms_operation` VALUES ('5d399af72c6d49c2a1bea0f584ddfce2', 'bac8ec6534a34accac89a0c863e568fe', '岗位管理', '岗位编辑权限', '/admin/station/edit', '/admin/station/edit', '1', null, null, '10', null, null, '2017-11-13 10:13:27', null);
INSERT INTO `upms_operation` VALUES ('618b85c59bcb476ab80b022f678bb14f', 'bc87828363fd4d438bc17b4a2a2eb86d', '编辑', '模板编辑权限', '/admin/template/edit', '/admin/template/edit', '1', null, null, '4', null, null, '2017-11-28 17:28:26', null);
INSERT INTO `upms_operation` VALUES ('63704c5288204d9cbf9970ee9ba0335f', '9f4c5d0c2eaf4479aaf7138791758407', '业务经理报表', '业务经理报表', '/report/userManager', '/report/userManager', '1', null, null, '1', null, null, '2017-12-21 19:59:20', null);
INSERT INTO `upms_operation` VALUES ('637494e5afe34eecafa43f5b1ce08713', 'e4acfabae81149aeaceabb1b1bdede25', '库存调拨', '库存调拨编辑', '/admin/transferBill/edit', '/admin/transferBill/edit', '1', null, null, '2', null, null, '2017-11-28 16:16:27', null);
INSERT INTO `upms_operation` VALUES ('6546c78bc2c9484d9c7d14b6e3b2e7a9', '57ee03939e1343e5b5867087efe973e0', '出库明细', '出库明细', '/admin/inventoryDetail', '/admin/inventoryDetail/out', '1', null, null, '3', null, null, '2017-11-28 17:01:18', '2017-12-07 18:00:47');
INSERT INTO `upms_operation` VALUES ('65843ae6f31640d99de3b35d6edd72c9', 'b392bd3880004c4aa1d1acd7e063495a', '客户类型', '客户类型编辑权限', '/admin/customerType/edit', '/admin/customerType/edit', '1', null, null, '3', null, null, '2017-11-15 10:08:09', null);
INSERT INTO `upms_operation` VALUES ('68afacbe07f149a6bf46c9a00d1773df', 'a0c15f5ec7eb4b0f8d3195013f0d9d00', '模块管理', '模块查看权限', '/admin/module', '/admin/module', '1', null, null, '10', null, null, '2017-11-13 10:15:16', null);
INSERT INTO `upms_operation` VALUES ('69b3b61113a64e7e87b1ea9c9ec4e8c3', '9e76239527e84e86ada6959fd3dcceb5', 'APP菜单', 'APP菜单', '/admin/template/menu', '/admin/template/menu', '1', null, null, '10', null, null, '2017-11-30 17:44:32', null);
INSERT INTO `upms_operation` VALUES ('6d57e91106fe47e19988294a44b1145a', 'a0c15f5ec7eb4b0f8d3195013f0d9d00', '模块管理', '模块编辑权限', '/admin/module/edit', '/admin/module/edit', '1', null, null, '10', null, null, '2017-11-13 10:15:28', null);
INSERT INTO `upms_operation` VALUES ('6d99e4c6dc664c9497a39a8f2133c07e', '677593701e684ab0897348804aaf781c', '组合商品管理', '组合商品查看权限', '/admin/productComposition', '/admin/productComposition', '1', null, null, '10', null, null, '2017-11-17 10:11:20', null);
INSERT INTO `upms_operation` VALUES ('6df528fc390547fc92d9db5482cb4cdb', '60dd40330a16436eb97ef8039e08e5b2', '用户权限', '管理者权限', '/admin/manager', '/admin/manager', '1', null, '能看多数据的都要此权限', '1', null, null, '2017-11-29 18:45:01', '2017-11-29 18:57:50');
INSERT INTO `upms_operation` VALUES ('709722a62ab04ad3840029353996b809', '97ca779973a34ce8b5f30ee96dbab265', '商品属性管理', '商品属性编辑权限', '/admin/goodsAttribute/edit', '/admin/goodsAttribute/edit', '1', null, null, '10', null, null, '2017-11-13 10:30:45', null);
INSERT INTO `upms_operation` VALUES ('70aeb5947b664441a6c7d3c59c330eb5', 'e5ea1d7b84e94e7a9cfb0c4660380a2d', '价格体系', '价格体系查看权限', '/admin/priceSystem', '/admin/priceSystem', '1', null, null, '3', null, null, '2017-11-01 11:58:11', '2017-11-15 10:03:56');
INSERT INTO `upms_operation` VALUES ('72798d20f06a416986add64d9279dfd8', '97ca779973a34ce8b5f30ee96dbab265', '商品属性管理', '商品属性查看权限', '/admin/goodsAttribute', '/admin/goodsAttribute', '1', null, null, '10', null, null, '2017-11-13 10:30:26', null);
INSERT INTO `upms_operation` VALUES ('73ab5fd90b0640cebf4ce67ee57ce47c', '9c30532ccf134223ad166eb49dcb456c', '我的产品详细', '我的产品详细', 'productReport', '/admin/report/productReport', '1', null, null, '802', null, null, '2017-12-19 15:06:00', null);
INSERT INTO `upms_operation` VALUES ('7416d54f6fe840a8b7442cf3cbe43403', '9762cc9823e049b8ad63a640a2de189d', '我管理的直营商详细', '我管理的直营商详细', 'mSellerDetail', '/admin/report/mSellerDetail', '1', null, null, '10', null, null, '2017-12-19 15:27:20', null);
INSERT INTO `upms_operation` VALUES ('74fb57d8c48b4be6b91ec11692318269', '5643590d903c4d6fbcafeabfb55ae473', '客户列表', '客户编辑权限', '/admin/sellerCustomer/edit', '/admin/sellerCustomer/edit', '1', null, null, '3', null, null, '2017-11-01 11:06:23', '2017-12-02 11:28:10');
INSERT INTO `upms_operation` VALUES ('75961ff7cfaa4ae7816af2a1bf4f7812', 'ce505ef74f0e4217b54239fe4082a601', '品牌经理报表', '品牌经理报表', '/report/brandManager', '/report/brandManager', '1', null, null, '1', null, null, '2017-12-21 19:59:38', null);
INSERT INTO `upms_operation` VALUES ('76320ac8f2304937aa1f72251ae1291a', '4dadebc483ee40ed9d98929a4ca0a1fb', '设置', '模板设置', '/admin/template/setting', '/admin/template/setting', '1', null, null, '3', null, null, '2017-11-28 17:06:21', '2017-11-28 17:32:53');
INSERT INTO `upms_operation` VALUES ('77b76b5ac6e044e3bf46cab83023830c', 'ec7c0214211541d9a8ffb63ee844da37', '角色管理', '角色编辑权限', '/admin/role/edit', '/admin/role/edit', '1', null, null, '10', null, null, '2017-11-13 10:12:02', null);
INSERT INTO `upms_operation` VALUES ('79011772fc6b49ac8e7443fae895d8f8', 'e5ea1d7b84e94e7a9cfb0c4660380a2d', '价格体系', '价格体系编辑权限', '/admin/priceSystem/edit', '/admin/priceSystem/edit', '1', null, null, '3', null, null, '2017-11-15 10:06:13', null);
INSERT INTO `upms_operation` VALUES ('7abbcd78c6174c3594efbc081ebc2676', 'bee82d5bdae34d8eb00c94669d587164', '产品总计', '产品总计', '/admin/report/productTotal', '/admin/report/productTotal', '1', null, null, '10', null, null, '2018-01-02 14:27:31', '2018-01-02 14:31:24');
INSERT INTO `upms_operation` VALUES ('7ae5c501ab7f4c5fa60ac0268ae87b5b', '005e7e6b48254c378f778cc5257460dc', '采购入库单', '采购入库单', 'purchaseInstock', '/admin/purchaseInstock', '1', null, null, '10', null, null, '2017-11-30 11:56:18', '2017-12-11 16:22:58');
INSERT INTO `upms_operation` VALUES ('80d8e0a4a1fb414b84d76cff94a60ef3', '4bd706b15a674e50a93c3d4f440bdc43', '微信设置', '微信设置', '/admin/wechat/option', '/admin/wechat/option', '1', null, null, '4', null, null, '2017-11-28 16:35:27', '2017-11-28 16:39:04');
INSERT INTO `upms_operation` VALUES ('81e61865543a49218e7635916ab626d1', '49197155d74740409250b73c1e7c775a', '商品规格值管理', '商品规格值查看权限', '/admin/specificationValue', '/admin/specificationValue', '1', null, null, '10', null, null, '2017-11-13 10:26:42', null);
INSERT INTO `upms_operation` VALUES ('833e100e838746d1b79f632906d2811c', '3be9ab17548d428ba8d15f6b029c657b', '客户拜访', '拜访轨迹', '/admin/customerVisit/trajector', '/admin/customerVisit/trajector', '1', null, null, '10', null, null, '2018-01-29 11:06:23', '2018-01-29 11:07:30');
INSERT INTO `upms_operation` VALUES ('8525b3075b7f4670bb83df3304757c1d', '083f4c73b82348e7a3487a09098fc3d2', '模板安装', '模板安装', '/admin/template/install', '/admin/template/install', '1', null, null, '2', null, null, '2017-11-28 17:06:04', null);
INSERT INTO `upms_operation` VALUES ('8539771ff5f440349759179cd1e046c1', '0c6005912bcb4d4590c9b8383321b13c', '通知', '通知', '/admin/option/notification', '/admin/option/notification', '1', null, null, '2', null, null, '2017-11-30 14:41:59', null);
INSERT INTO `upms_operation` VALUES ('85cfdb1356184b15afd440971d97a4ea', '4ef02ea9a3124d42afa8e10864ac19fd', '组织机构管理', '部门编辑权限', '/admin/department/edit', '/admin/department/edit', '1', null, null, '10', null, null, '2017-11-13 09:52:46', '2017-11-14 18:52:41');
INSERT INTO `upms_operation` VALUES ('8863eb171b23493f8936c3ea7112232a', '476f020988244e019793dd569b61c097', '活动投放', '活动投放', '/admin/activity/put', '/admin/activity/put', '1', null, null, '10', null, null, '2018-02-28 10:23:51', null);
INSERT INTO `upms_operation` VALUES ('8bbbf4a810de4016b651a6a873fa3d34', 'dd05bc34b9084963bc8c43092ade5ddb', '第三方订单关系', '第三方订单权限', '/admin/salesOrder/otherOrder', '/admin/salesOrder/otherOrder', '1', null, null, '1', null, null, '2018-01-29 10:34:02', null);
INSERT INTO `upms_operation` VALUES ('8cc53eca54e64441b90846ad7c282f9c', '098129772bd34c4fae3ca9c0e602f4d2', '系统管理', '系统编辑权限', '/admin/systems/edit', '/admin/systems/edit', '1', null, null, '2', null, null, '2017-11-13 10:14:14', '2017-11-28 16:25:15');
INSERT INTO `upms_operation` VALUES ('8e38d5b443b64e65b4e9e6c7e3488186', '493abdb340604636b25a414e0a5d0310', '新增公告', '撰写内容', '/admin/content/edit', '/admin/content/edit?m=article', '1', null, null, '10', null, null, '2017-11-30 17:52:28', '2017-12-01 10:59:42');
INSERT INTO `upms_operation` VALUES ('92a3842d4a1a455cb60a3013b0497673', '79eb8530cf7842dd8d91af99b3d026d9', '菜单管理', '菜单查看权限', '/admin/menu', '/admin/menu', '1', null, null, '10', null, null, '2017-11-13 10:12:47', null);
INSERT INTO `upms_operation` VALUES ('94a8f9efc0f44e39ae17be6416f68ce6', '821312b533f44f05977c7eb1471175e1', '默认回复', '默认回复', '/admin/wechat/reply_default', '/admin/wechat/reply_default', '1', null, null, '2', null, null, '2017-11-28 16:35:01', '2017-11-28 16:38:23');
INSERT INTO `upms_operation` VALUES ('94b3f0d54c5a44ee938d35e58670ed4f', '60dd40330a16436eb97ef8039e08e5b2', '用户权限', '经销商管理员权限', '/admin/dealer/all', '/admin/dealer/all', '1', null, null, '1', null, null, '2017-11-02 17:49:43', '2017-11-15 11:36:51');
INSERT INTO `upms_operation` VALUES ('954c78b9416f4a11be37d4f5f31395a3', 'c9a51ebfa468471d9dc4dbb3d86c26a2', '定制化服务', '定制化服务', 'seller_option', '/admin/option/seller', '1', null, null, '1', null, null, '2017-12-11 20:34:46', '2017-12-11 20:36:07');
INSERT INTO `upms_operation` VALUES ('95cfd2d63a52447abe9e42542ae104b3', '275602bcf164416f95ca581eb0722cfa', '供应商管理', '供应商编辑权限', '/admin/supplier/edit', '/admin/supplier/edit', '1', null, null, '10', null, null, '2017-11-13 10:24:03', null);
INSERT INTO `upms_operation` VALUES ('97b88233eccb478e99080de880a47dc7', '60dd40330a16436eb97ef8039e08e5b2', '用户权限', '超级管理员权限', 'admin', '/admin/all', '1', null, null, '1', null, null, '2017-10-31 17:02:38', '2017-11-30 10:52:11');
INSERT INTO `upms_operation` VALUES ('9848f1d345724c219691fdc98c8b0189', '7b15c61d296a49c5b204411a38007039', '微信消息模板', '微信消息模板', 'message_template', '/admin/messageTemplate', '1', null, null, '10', null, null, '2017-12-07 14:18:26', null);
INSERT INTO `upms_operation` VALUES ('9918ae7d032445d488a2cc77bebc1eba', 'ece49dfb8a6f47b6a57eae891e9fab2d', '业务主管报表', '业务主管报表', '/report/userCharge', '/report/userCharge', '1', null, null, '1', null, null, '2017-12-21 19:59:04', null);
INSERT INTO `upms_operation` VALUES ('9bdfffab571b4d9185598ee04406b682', 'ab140402ec514e4599421b7f1d4f9018', '销售计划', '销售计划新增', '/admin/plans/add', '/admin/plans/add', '1', null, null, '10', null, null, '2018-01-24 21:17:28', null);
INSERT INTO `upms_operation` VALUES ('9ebe482318f54ec9af6a93036424ace8', '80591f838f3f4895bac6dbdacbcc4768', '业务员报表', '业务员报表', '/report/userReport', '/report/userReport', '1', null, null, '1', null, null, '2017-12-21 19:58:35', null);
INSERT INTO `upms_operation` VALUES ('9fba996b15e4496196dc704316f5eafd', '539adff6205843a3af4925dcdabeeb8a', '活动申请', '活动申请查看', '/admin/activityApply', '/admin/activityApply', '1', null, null, '10', null, null, '2018-01-19 09:32:00', '2018-01-19 15:35:51');
INSERT INTO `upms_operation` VALUES ('a0bf07a254df4628b046ab98e6dae2b1', '539adff6205843a3af4925dcdabeeb8a', '活动申请', '活动申请审核', '/admin/activityApply/check', '/admin/activityApply/check', '1', null, null, '10', null, null, '2018-01-19 09:36:12', '2018-01-19 15:35:48');
INSERT INTO `upms_operation` VALUES ('a1aa6e2f556442d599ad072dc9d5b739', '532c7eea6bc8419ca2f97cddd818a6cc', '流程管理', '流程管理', '/admin/workflow', '/admin/workflow', '1', null, null, '1', null, null, '2017-11-28 17:04:25', null);
INSERT INTO `upms_operation` VALUES ('a2bc28a0d3424d1ca176c236b1450d4b', 'e61a88cfbf7343a18419d70cd4b346a1', '采购订货单', '采购订货单', 'purchaseOrder', '/admin/purchaseOrder', '1', null, null, '10', null, null, '2017-11-23 11:48:41', '2017-11-30 16:13:51');
INSERT INTO `upms_operation` VALUES ('a9b3e9cb0f03434999b924bfb5515dc9', '5643590d903c4d6fbcafeabfb55ae473', '客户列表', '客户导入权限', '/admin/sellerCustomer/upload', '/admin/sellerCustomer/uploading', '1', null, null, '3', null, null, '2017-11-01 11:26:41', '2017-12-02 11:29:34');
INSERT INTO `upms_operation` VALUES ('aacbf48a40ab438c9a36281227d8bbf3', '2a7818f5b1fb409a9d908f3aa9fcd737', '商品信息管理', '商品信息查看权限', '/admin/goods', '/admin/goods', '1', null, null, '10', null, null, '2017-11-13 10:31:38', '2017-11-28 16:52:21');
INSERT INTO `upms_operation` VALUES ('ab402ab0f8af4414bae6b4adb82f774d', 'e4acfabae81149aeaceabb1b1bdede25', '库存调拨', '库存调拨查看', '/admin/transferBill', '/admin/transferBill', '1', null, null, '1', null, null, '2017-11-28 16:16:10', null);
INSERT INTO `upms_operation` VALUES ('aef27506020a4927aea6f23f236db46d', '01b9a302bcf0422b894d20e519cfda68', '入库明细', '入库明细', '/admin/inventoryDetail', '/admin/inventoryDetail/index', '1', null, null, '2', null, null, '2017-11-28 17:00:59', '2017-12-06 21:17:55');
INSERT INTO `upms_operation` VALUES ('b309703799404f969714bfdd541b312f', '5643590d903c4d6fbcafeabfb55ae473', '客户列表', '客户新增', '/admin/sellerCustomer/add', '/admin/sellerCustomer/add', '1', null, null, '3', null, null, '2018-01-10 10:26:01', null);
INSERT INTO `upms_operation` VALUES ('b3f1cb782ad0430da370ae532917b4a0', '85a2b80017c44a46a4dd323fda4172e4', '统计概要', '统计概要', '/admin/stat/outline', '/admin/stat/outline', '1', null, null, '1', null, null, '2017-11-28 17:00:25', null);
INSERT INTO `upms_operation` VALUES ('b7e988bdb40d4133b0d892cb555500e1', '225379b235e448e699621a421694179a', '库存盘点', '库存盘点编辑', '/admin/stockTaking/edit', '/admin/stockTaking/edit', '1', null, null, '2', null, null, '2017-11-28 16:14:52', null);
INSERT INTO `upms_operation` VALUES ('b8a19ceaec234a26b41a7d4df4e4630b', '63f693044d5945d4a7b727deb5f1db5e', '常规', '常规', '/admin/option/web', '/admin/option/web', '1', null, null, '1', null, null, '2017-11-30 14:41:44', null);
INSERT INTO `upms_operation` VALUES ('b908438d772e460497d59ac1cad7308c', '67f28d02b39147c5b6b988c1850f061c', '应付账款', '应付账款', '/admin/payables', '/admin/payables', '1', null, null, '2', null, null, '2017-11-30 16:23:49', '2017-11-30 16:26:07');
INSERT INTO `upms_operation` VALUES ('b9ae4246b09743fca0cec336b0bcd022', '1b5f5d36f33c4ea2ab1b38a0604a549e', '基础客户', '基础客户查看权限', '/admin/customer', '/admin/customer', '1', null, null, '3', null, null, '2017-11-10 18:17:30', '2017-12-02 15:01:44');
INSERT INTO `upms_operation` VALUES ('bbe4beaf93b4438faefa57135c50b006', '4be383b892944577808ef688c4cc556e', '我部门的业务员', '我部门的业务员', 'departSalesman', '/admin/report/departSalesman', '1', null, null, '10', null, null, '2017-12-19 15:26:13', null);
INSERT INTO `upms_operation` VALUES ('bd6170ef3aab473a965f6d0927909ba9', '7cad743abfcb4e55b540e156eca36d8b', '商品分类管理', '商品分类编辑权限', '/admin/category/edit', '/admin/category/edit', '1', null, null, '2', null, null, '2017-11-27 18:57:45', null);
INSERT INTO `upms_operation` VALUES ('bdc249827127456595ae744f6c1e6001', '677593701e684ab0897348804aaf781c', '组合商品管理', '组合商品编辑权限', '/admin/productComposition/edit', '/admin/productComposition/edit', '1', null, null, '10', null, null, '2017-11-17 10:11:50', null);
INSERT INTO `upms_operation` VALUES ('bffb96f7bbd44c62a82e775d727a7157', '539adff6205843a3af4925dcdabeeb8a', '活动申请', '活动申请新增', '/admin/activityApply/add', '/admin/activityApply/add', '1', null, null, '10', null, null, '2018-01-19 09:34:29', '2018-01-19 09:39:54');
INSERT INTO `upms_operation` VALUES ('c1ed085c9afc4f968570d175340b5eaf', '2088c899d43c40a5970551a5b082ec83', '我管理的直营商', '我管理的直营商', 'manageSeller', '/admin/report/manageSeller', '1', null, null, '10', null, null, '2017-12-19 15:26:26', '2017-12-19 15:29:44');
INSERT INTO `upms_operation` VALUES ('c465be903bd544b88394831a94e7675f', '92faab8a1d5d438ca46ec24a51c55897', '商品类型管理', '商品类型编辑权限', '/admin/goodsType/edit', '/admin/goodsType/edit', '1', null, null, '10', null, null, '2017-11-13 10:27:46', null);
INSERT INTO `upms_operation` VALUES ('c867a3ea8427422ca5a790ea40340fcd', '70a85e266d364ca980afca2df27b61c2', '用户管理', '用户查看权限', '/admin/user', '/admin/user', '1', null, null, '2', null, null, '2017-11-27 20:34:09', null);
INSERT INTO `upms_operation` VALUES ('c8dabc119bf54d57965b0649431a4931', '53712f187f1d4b829341cdc4bcf7adf0', '库存详情', '前台库存详情', '/front/inventory', '/front/inventory', '1', null, null, '1', null, null, '2018-01-10 09:15:56', null);
INSERT INTO `upms_operation` VALUES ('ca5a05d984be4552ac3f793f3039e32f', 'abae8488cb2740c4a0f208e44328f88d', '销售退货单', '销售退货单审核', '/admin/salesRefund/check', '/admin/salesRefund/check', '1', null, null, '2', null, null, '2017-12-07 11:53:06', '2018-01-05 11:03:29');
INSERT INTO `upms_operation` VALUES ('ce9bba6dcb4244bc9048df86e1a14ee7', '5643590d903c4d6fbcafeabfb55ae473', '客户列表', '客户审核', '/admin/sellerCustomer/audit', '/admin/sellerCustomer/audit', '1', null, null, '10', null, null, '2017-12-22 10:21:28', null);
INSERT INTO `upms_operation` VALUES ('cf06c7f303c341e8b5724ebf51053386', 'f626cc516d124c8da969c530f7c34424', '我部门的产品详细', '我部门的产品详细', 'departProduct', '/admin/report/departProduct', '1', null, null, '10', null, null, '2017-12-19 15:25:35', '2017-12-19 15:37:32');
INSERT INTO `upms_operation` VALUES ('cf6fd2ad2d3c4b2e856f76f3c99d517c', '54bd67af09804c6aa6ea5c8af242a63b', '公告分类', '内容分类', '/admin/taxonomy', '/admin/taxonomy?m=article&t=category', '1', null, null, '10', null, null, '2017-11-30 17:52:49', '2017-12-01 11:26:41');
INSERT INTO `upms_operation` VALUES ('d079b144a8044b1c83b08cb88664c042', 'ab140402ec514e4599421b7f1d4f9018', '销售计划', '销售计划查看', '/admin/plans', '/admin/plans', '1', null, null, '10', null, null, '2018-01-24 21:16:36', null);
INSERT INTO `upms_operation` VALUES ('d09fd3353d5047069ccbf15462b05eea', 'd04a899d85b6434da559e2aeb3bbb844', 'CDN加速', 'CDN加速', '/admin/option/cdn', '/admin/option/cdn', '1', null, null, '3', null, null, '2017-11-30 14:42:19', null);
INSERT INTO `upms_operation` VALUES ('d290624e76eb4ab4a30f45b59bb7375c', '63c58aff2e264eb48859f1737efa4120', '销售订单出库', '销售订货出库查看', '/admin/salesOutstock', '/admin/salesOutstock', '1', null, null, '10', null, null, '2017-11-24 14:50:32', '2017-11-30 16:30:06');
INSERT INTO `upms_operation` VALUES ('d2bb7be5c39542318f9591117887fb74', '09b98e08944d4bcc81984550816f2185', '功能管理', '功能查看权限', '/admin/operation', '/admin/operation', '1', null, null, '10', null, null, '2017-11-13 10:14:56', null);
INSERT INTO `upms_operation` VALUES ('d33e72e99d92452589e1fb85f33fb76a', '2cbfa15643ac451fb1b6f3ee0cde466b', '产品管理', '产品管理', '/admin/seller/productManage', '/admin/seller/productManage', '1', null, null, '10', null, null, '2017-11-15 11:47:59', null);
INSERT INTO `upms_operation` VALUES ('d3e0c84b0045422e8621e3cc64820b1f', '63c58aff2e264eb48859f1737efa4120', '销售订单出库', '销售订货出库审核', '/admin/salesOutstock/check', '/admin/salesOutstock/check', '1', null, null, '2', null, null, '2017-11-28 16:19:20', '2017-12-07 11:21:22');
INSERT INTO `upms_operation` VALUES ('d831dd3e4d684d19b194e27cdb8f2f37', 'ec7c0214211541d9a8ffb63ee844da37', '角色管理', '角色查看权限', '/admin/role', '/admin/role', '1', null, null, '10', null, null, '2017-11-13 10:12:23', null);
INSERT INTO `upms_operation` VALUES ('d87c03c26c9944ecbd67e1aa09ba402b', '4c1b0cc698d443d38ee2cb30e958478d', '业务员排行榜', '业务员排行榜', '/report/userRank', '/report/userRank', '1', null, null, '1', null, null, '2017-12-21 19:58:03', null);
INSERT INTO `upms_operation` VALUES ('db3c8594bfda4bacb52b98199b567d91', '065cf65f6fb24fb9b20eb0f903b28090', '公司客户', '公司客户列表', '/admin/customer/corp', '/admin/customer/corp', '1', null, null, '10', null, null, '2018-01-28 20:03:07', '2018-01-28 20:07:28');
INSERT INTO `upms_operation` VALUES ('dbb46cc01d074eef93a87c86e407294a', '24b0f1fa3bfc490a850c9b33f76180bc', '我的客户详细', '我的客户详细', 'customerDetails', '/admin/report/customerDetails', '1', null, null, '800', null, null, '2017-12-12 14:15:21', '2017-12-19 15:02:34');
INSERT INTO `upms_operation` VALUES ('df32642d4cba41dcb6dcc1a507c65f03', 'b2c5804056494b6baf4eeb64a23f5120', 'api应用', 'API应用', '/admin/api', '/admin/api', '1', null, null, '4', null, null, '2017-11-30 14:42:33', '2017-11-30 14:45:00');
INSERT INTO `upms_operation` VALUES ('df9dd46676414eff9ced2389e1c81591', 'b649adfd9b7f4f6fa138222ecb75889c', '所有附件', '查看所有附件', '/admin/attachment', '/admin/attachment', '1', null, null, '1', null, null, '2017-11-28 16:33:41', '2017-11-28 16:37:14');
INSERT INTO `upms_operation` VALUES ('e2e0e165448a43e8b8db82517ecf031e', 'a18654f80a944e778d025930ae6b7903', '仓库管理', '仓库管理权限', '/admin/warehouse', '/admin/warehouse', '1', null, null, '10', null, null, '2017-11-23 15:34:29', null);
INSERT INTO `upms_operation` VALUES ('e53177614286410cb94d420f508b7e08', '3be9ab17548d428ba8d15f6b029c657b', '客户拜访', '客户拜访', '/admin/customerVisit', '/admin/customerVisit', '1', null, null, '10', null, null, '2017-12-06 17:11:41', null);
INSERT INTO `upms_operation` VALUES ('e81d6d73181e4315b1913b6767caf2cf', '3be9ab17548d428ba8d15f6b029c657b', '客户拜访', '客户拜访审核', '/admin/customerVisit/audit', '/admin/customerVisit/audit', '1', null, null, '10', null, null, '2017-12-20 11:01:35', null);
INSERT INTO `upms_operation` VALUES ('eba48604a2ee4d7d80d0e14b067e23f0', '3be9ab17548d428ba8d15f6b029c657b', '客户拜访', '客户拜访新增', '/admin/customerVisit/add', '/admin/customerVisit/add', '1', null, null, '3', null, null, '2018-01-10 10:25:25', null);
INSERT INTO `upms_operation` VALUES ('f46010897ec14999b16f1b3cfa7b24a3', 'e075c21d45d04000975d627ddb2b8d5f', '所有模板', '查看所有模板', '/admin/template', '/admin/template', '1', null, null, '1', null, null, '2017-11-28 17:05:48', '2017-11-28 17:32:21');
INSERT INTO `upms_operation` VALUES ('f65dcea5d258488abedcf4076e93fe6e', '76d02b1f780549bd89598a181036c5ed', '地区', '地区', '/admin/area', '/admin/area', '1', null, null, '2', null, null, '2017-11-30 14:41:18', null);
INSERT INTO `upms_operation` VALUES ('f68d48ffde1f461cb79400a8b5d585ee', '63c58aff2e264eb48859f1737efa4120', '销售订单出库', '销售价打印', '/admin/salesOutstock/print', '/admin/salesOutstock/print', '1', null, '打印时显示正常销售价', '10', null, null, '2018-02-06 17:41:24', null);
INSERT INTO `upms_operation` VALUES ('f81d64be9f384292b1ec0a866298cdb0', '92faab8a1d5d438ca46ec24a51c55897', '商品类型管理', '商品类型查看权限', '/admin/goodsType', '/admin/goodsType', '1', null, null, '10', null, null, '2017-11-13 10:27:27', null);
INSERT INTO `upms_operation` VALUES ('f9263e42f270422f8015ae58fdf99990', '94033f4cca0246d993f4d5b52ae2064f', '销售订货单', '销售订货单查看', '/admin/salesOrder', '/admin/salesOrder', '1', null, null, '1', null, null, '2017-11-15 10:41:21', '2017-11-30 16:29:43');
INSERT INTO `upms_operation` VALUES ('f965ecfbdefa4a06b40dd812175edaa1', 'abae8488cb2740c4a0f208e44328f88d', '销售退货单', '销售退货单查看', '/admin/salesRefund', '/admin/salesRefund', '1', null, null, '1', null, null, '2017-11-15 10:45:02', '2018-01-05 11:02:26');
INSERT INTO `upms_operation` VALUES ('fd2e2a9a6d014c73a26529acf46f1a00', '49197155d74740409250b73c1e7c775a', '商品规格值管理', '商品规格值编辑权限', '/admin/specificationValue/edit', '/admin/specificationValue/edit', '1', null, null, '10', null, null, '2017-11-13 10:26:31', null);
INSERT INTO `upms_operation` VALUES ('fdad8af625ea45cba0bbb2543746db58', '5643590d903c4d6fbcafeabfb55ae473', '客户列表', '客户导出权限', '/admin/sellerCustomer/download', '/admin/sellerCustomer/downloading', '1', null, null, '3', null, null, '2017-11-01 11:28:56', '2017-12-02 11:32:06');
INSERT INTO `upms_operation` VALUES ('fe19e5ec64f345a4a6645b452e68f213', '8436b1b93e554fb68638056c3b1fa69c', 'SQL分析', 'SQL分析', '/admin/monitor/sql', '/admin/monitor/sql', '1', null, null, '4', null, null, '2017-11-28 17:02:24', null);
INSERT INTO `upms_operation` VALUES ('ff1ecd728fcb4e10a351bc3712f4939a', '94033f4cca0246d993f4d5b52ae2064f', '销售订货单', '销售订货单审核', '/admin/salesOrder/check', '/admin/salesOrder/check', '1', null, null, '2', null, null, '2017-12-07 11:20:14', '2017-12-07 11:20:39');

-- ----------------------------
-- Table structure for upms_option
-- ----------------------------
DROP TABLE IF EXISTS `upms_option`;
CREATE TABLE `upms_option` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `option_key` varchar(128) DEFAULT NULL COMMENT '配置KEY',
  `option_value` text COMMENT '配置内容',
  `seller_id` varchar(32) DEFAULT NULL COMMENT '销售商ID',
  PRIMARY KEY (`id`),
  KEY `_option_key` (`option_key`)
) ENGINE=InnoDB AUTO_INCREMENT=315 DEFAULT CHARSET=utf8mb4 COMMENT='配置信息表，用来保存网站的所有配置信息。';

-- ----------------------------
-- Records of upms_option
-- ----------------------------
INSERT INTO `upms_option` VALUES ('1', 'web_name', '渠道云平台', null);
INSERT INTO `upms_option` VALUES ('2', 'web_template_id', 'datacenter', null);
INSERT INTO `upms_option` VALUES ('3', 'web_administrator_phone', null, null);
INSERT INTO `upms_option` VALUES ('4', 'web_icp_number', '鄂ICP备12035980号-2', null);
INSERT INTO `upms_option` VALUES ('5', 'web_title', '渠道云平台', null);
INSERT INTO `upms_option` VALUES ('6', 'web_copyright', 'Copyright © 珈研', null);
INSERT INTO `upms_option` VALUES ('7', 'web_domain', 'http://www.juster.com.cn', null);
INSERT INTO `upms_option` VALUES ('8', 'web_administrator_email', null, null);
INSERT INTO `upms_option` VALUES ('9', 'web_administrator_wechat_openid', null, null);
INSERT INTO `upms_option` VALUES ('10', 'autosave', 'web_name,web_title,web_subtitle,web_domain,web_administrator_email,web_administrator_phone,web_administrator_wechat_openid,web_copyright,web_icp_number,mobile_browse_enable', null);
INSERT INTO `upms_option` VALUES ('11', 'ucode', '8907ac96136ce39bc9ffa4baef58a602', null);
INSERT INTO `upms_option` VALUES ('12', 'web_subtitle', null, null);
INSERT INTO `upms_option` VALUES ('13', 'router_content_type', '_static_module_id', null);
INSERT INTO `upms_option` VALUES ('14', 'router_fakestatic_enable', 'true', null);
INSERT INTO `upms_option` VALUES ('15', 'router_fakestatic_suffix', null, null);
INSERT INTO `upms_option` VALUES ('16', 'router_content_prefix', null, null);
INSERT INTO `upms_option` VALUES ('17', 'comment_must_audited', null, null);
INSERT INTO `upms_option` VALUES ('18', 'comment_allow_not_login', 'true', null);
INSERT INTO `upms_option` VALUES ('19', 'comment_default_nickname', null, null);
INSERT INTO `upms_option` VALUES ('20', 'comment_need_captcha', null, null);
INSERT INTO `upms_option` VALUES ('21', 'comment_default_avatar', null, null);
INSERT INTO `upms_option` VALUES ('22', 'web_version', 'V2.0', null);
INSERT INTO `upms_option` VALUES ('23', 'web_administrator_qq', null, null);
INSERT INTO `upms_option` VALUES ('24', 'web_logo', '/attachment/20180422/38c3df7413174bd1bf68c8b68da8923b.png', null);
INSERT INTO `upms_option` VALUES ('25', 'web_administrator_weixin', null, null);
INSERT INTO `upms_option` VALUES ('26', 'wechat_search_article_count', null, null);
INSERT INTO `upms_option` VALUES ('27', 'wechat_search_article_enable', null, null);
INSERT INTO `upms_option` VALUES ('28', 'wechat_dkf_enter_key', null, null);
INSERT INTO `upms_option` VALUES ('29', 'wechat_appsecret', 'd2dd563a24f612ae8b06e2a77bc9990b', null);
INSERT INTO `upms_option` VALUES ('30', 'wechat_dkf_quit_key', null, null);
INSERT INTO `upms_option` VALUES ('31', 'wechat_search_article_prefix', null, null);
INSERT INTO `upms_option` VALUES ('32', 'wechat_token', '9mm', null);
INSERT INTO `upms_option` VALUES ('33', 'wechat_appid', 'wx742b3b05f441ce37', null);
INSERT INTO `upms_option` VALUES ('34', 'notify_author_by_wechat_when_has_comment', 'true', null);
INSERT INTO `upms_option` VALUES ('35', 'notify_author_content_by_sms_when_has_comment', null, null);
INSERT INTO `upms_option` VALUES ('36', 'email_host', null, null);
INSERT INTO `upms_option` VALUES ('37', 'notify_admin_by_email_when_user_registed', 'true', null);
INSERT INTO `upms_option` VALUES ('38', 'sms_app_secret', '0738b4075ce52e596a80dcd149e96045', null);
INSERT INTO `upms_option` VALUES ('39', 'notify_author_content_by_wechat_when_has_comment', null, null);
INSERT INTO `upms_option` VALUES ('40', 'email_usessl', 'true', null);
INSERT INTO `upms_option` VALUES ('41', 'notify_author_content_by_email_when_at', null, null);
INSERT INTO `upms_option` VALUES ('42', 'notify_parent_author_content_by_wechat_when_has_comment', null, null);
INSERT INTO `upms_option` VALUES ('43', 'sms_app_key', '24718371', null);
INSERT INTO `upms_option` VALUES ('44', 'notify_author_content_by_email_when_has_comment', null, null);
INSERT INTO `upms_option` VALUES ('45', 'email_username', null, null);
INSERT INTO `upms_option` VALUES ('46', 'notify_parent_author_content_by_email_when_has_comment', null, null);
INSERT INTO `upms_option` VALUES ('47', 'notify_author_by_email_when_has_comment', null, null);
INSERT INTO `upms_option` VALUES ('48', 'sms_app_provider', 'sms_provider_alidayu', null);
INSERT INTO `upms_option` VALUES ('49', 'sms_host', null, null);
INSERT INTO `upms_option` VALUES ('50', 'notify_parent_author_content_by_sms_when_has_comment', null, null);
INSERT INTO `upms_option` VALUES ('51', 'notify_author_content_by_sms_when_at', null, null);
INSERT INTO `upms_option` VALUES ('52', 'email_password', null, null);
INSERT INTO `upms_option` VALUES ('53', 'notify_admin_content_by_wechat_when_user_registed', null, null);
INSERT INTO `upms_option` VALUES ('54', 'notify_author_by_sms_when_has_comment', 'true', null);
INSERT INTO `upms_option` VALUES ('55', 'notify_admin_by_content_email_when_user_registed', null, null);
INSERT INTO `upms_option` VALUES ('56', 'notify_author_content_by_wechat_when_at', null, null);
INSERT INTO `upms_option` VALUES ('57', 'notify_admin_by_wechat_when_user_registed', 'true', null);
INSERT INTO `upms_option` VALUES ('58', 'notify_admin_by_sms_when_user_registed', 'true', null);
INSERT INTO `upms_option` VALUES ('59', 'notify_admin_content_by_sms_when_user_registed', null, null);
INSERT INTO `upms_option` VALUES ('60', 'seller_store_check', '1', '05a9ad0a516c4c459cb482f83bfbbf33');
INSERT INTO `upms_option` VALUES ('62', 'ucode', 'e39f564117a3aef28f421acf74d85688', '05a9ad0a516c4c459cb482f83bfbbf33');
INSERT INTO `upms_option` VALUES ('63', '2155746c31404594a859228b5f5cbf08_store_check', '1', '2155746c31404594a859228b5f5cbf08');
INSERT INTO `upms_option` VALUES ('64', '659c668df28e4a4e82021073e33e2204_store_check', '1', '659c668df28e4a4e82021073e33e2204');
INSERT INTO `upms_option` VALUES ('65', '9de32533b44c47d2bfa3a19427c6ab3d_store_check', '1', '9de32533b44c47d2bfa3a19427c6ab3d');
INSERT INTO `upms_option` VALUES ('66', 'd6dc5c84b2d54362ac0abdd269482fcc_store_check', '1', 'd6dc5c84b2d54362ac0abdd269482fcc');
INSERT INTO `upms_option` VALUES ('67', '00855c6ce4ea44d59baac194c91f7964_store_check', '1', '00855c6ce4ea44d59baac194c91f7964');
INSERT INTO `upms_option` VALUES ('68', 'c4831a04507f4a57be8e6818c1be2fa9_store_check', '1', 'c4831a04507f4a57be8e6818c1be2fa9');
INSERT INTO `upms_option` VALUES ('69', '9e738f4eec9f45d4ad416c9446dd1f52_store_check', '1', '9e738f4eec9f45d4ad416c9446dd1f52');
INSERT INTO `upms_option` VALUES ('70', '204b890ce1f64472abb43b802304ccfc_store_check', '1', '204b890ce1f64472abb43b802304ccfc');
INSERT INTO `upms_option` VALUES ('71', '68f9e2e4d75f4129935af5ed23e5823a_store_check', '1', '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('72', 'dc709f745b324ea0b2ec9c36507fbfb7_store_check', '1', 'dc709f745b324ea0b2ec9c36507fbfb7');
INSERT INTO `upms_option` VALUES ('73', '96d1e9a3f10c4086b278c25f7d6f4285_store_check', '1', '96d1e9a3f10c4086b278c25f7d6f4285');
INSERT INTO `upms_option` VALUES ('74', '9394b26525984fa0bae0e7063cb81984_store_check', '1', '9394b26525984fa0bae0e7063cb81984');
INSERT INTO `upms_option` VALUES ('75', '09798c1487b0430db5e929e9aa015976_store_check', '1', '09798c1487b0430db5e929e9aa015976');
INSERT INTO `upms_option` VALUES ('76', 'c4f2d408efb04e16b7863de7390f4873_store_check', '1', 'c4f2d408efb04e16b7863de7390f4873');
INSERT INTO `upms_option` VALUES ('77', 'web_file_root_path', '/Users/WT/Desktop/img', null);
INSERT INTO `upms_option` VALUES ('78', 'seller_store_check', '1', '9876ef98c6d043499706cbfdd6595363');
INSERT INTO `upms_option` VALUES ('79', 'comment_need_procedure', '1', '9876ef98c6d043499706cbfdd6595363');
INSERT INTO `upms_option` VALUES ('80', 'seller_store_check_100001', 'true', '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('81', 'comment_need_goods_price_100001', '0', '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('82', 'ucode', 'e7768109d191ae95101135e0aea7d6cf', '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('83', 'comment_need_goods_number_100001', '0', '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('84', 'comment_need_procedure_100001', '0', '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('85', 'web_proc_customer_review_100001', 'true', '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('86', 'web_proc_num_limit_100001', null, '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('87', 'web_proc_price_limit_100001', null, '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('88', 'web_procedure_review_100001', 'true', '68f9e2e4d75f4129935af5ed23e5823a');
INSERT INTO `upms_option` VALUES ('89', 'web_file_server_path', null, null);
INSERT INTO `upms_option` VALUES ('90', 'cdn_enable', null, null);
INSERT INTO `upms_option` VALUES ('91', 'cdn_exclude_files', '/templates/tcloud/css/style.css\n/templates/tcloud/css/unlock.css\n/templates/tcloud/js/comm.js\n/templates/tcloud/js/shopping-cart.js', null);
INSERT INTO `upms_option` VALUES ('92', 'cdn_bucket', 'tcloud', null);
INSERT INTO `upms_option` VALUES ('93', 'cdn_domain', 'http://image.juster.com.cn', null);
INSERT INTO `upms_option` VALUES ('94', 'seller_store_check', 'true', '9ef38573772d441a99254248f8941b37');
INSERT INTO `upms_option` VALUES ('95', 'comment_need_procedure', 'true', '9ef38573772d441a99254248f8941b37');
INSERT INTO `upms_option` VALUES ('96', 'seller_store_check', 'true', '0eb683c4a81542fa918d45811b7f05f2');
INSERT INTO `upms_option` VALUES ('97', 'comment_need_procedure', 'true', '0eb683c4a81542fa918d45811b7f05f2');
INSERT INTO `upms_option` VALUES ('98', 'web_proc_customer_visit_100001', 'true', null);
INSERT INTO `upms_option` VALUES ('99', 'seller_store_check', 'true', 'bc5306f579e74d0aa3032998314d7f1f');
INSERT INTO `upms_option` VALUES ('100', 'comment_need_procedure', 'true', 'bc5306f579e74d0aa3032998314d7f1f');
INSERT INTO `upms_option` VALUES ('101', 'seller_store_check', 'true', '0fd8246b1f6c4f61a9c30ee999520481');
INSERT INTO `upms_option` VALUES ('102', 'comment_need_procedure', 'true', '0fd8246b1f6c4f61a9c30ee999520481');
INSERT INTO `upms_option` VALUES ('103', 'notify_parent_author_by_email_when_has_comment', 'true', null);
INSERT INTO `upms_option` VALUES ('104', 'notify_author_by_email_when_at', 'true', null);
INSERT INTO `upms_option` VALUES ('105', 'notify_author_by_wechat_when_at', 'true', null);
INSERT INTO `upms_option` VALUES ('106', 'notify_parent_author_by_wechat_when_has_comment', 'true', null);
INSERT INTO `upms_option` VALUES ('107', 'notify_parent_author_by_sms_when_has_comment', 'true', null);
INSERT INTO `upms_option` VALUES ('108', 'notify_author_by_sms_when_at', 'true', null);
INSERT INTO `upms_option` VALUES ('109', 'seller_store_check_100012', 'true', null);
INSERT INTO `upms_option` VALUES ('110', 'web_procedure_review_100012', 'true', null);
INSERT INTO `upms_option` VALUES ('111', 'web_proc_customer_review_100012', 'true', null);
INSERT INTO `upms_option` VALUES ('112', 'web_proc_customer_visit_100012', 'true', null);
INSERT INTO `upms_option` VALUES ('113', 'seller_store_check_100013', 'true', null);
INSERT INTO `upms_option` VALUES ('114', 'web_procedure_review_100013', 'true', null);
INSERT INTO `upms_option` VALUES ('115', 'web_proc_customer_review_100013', 'true', null);
INSERT INTO `upms_option` VALUES ('116', 'web_proc_customer_visit_100013', 'true', null);
INSERT INTO `upms_option` VALUES ('117', 'web_procedure_review_edit_100001', 'true', null);
INSERT INTO `upms_option` VALUES ('118', 'web_order_price_edit_100001', 'true', null);
INSERT INTO `upms_option` VALUES ('119', 'seller_store_check_100014', 'true', null);
INSERT INTO `upms_option` VALUES ('120', 'web_procedure_review_100014', 'true', null);
INSERT INTO `upms_option` VALUES ('121', 'web_proc_customer_review_100014', 'true', null);
INSERT INTO `upms_option` VALUES ('122', 'web_proc_customer_visit_100014', 'true', null);
INSERT INTO `upms_option` VALUES ('123', 'seller_store_check_100015', 'true', null);
INSERT INTO `upms_option` VALUES ('124', 'web_procedure_review_100015', 'true', null);
INSERT INTO `upms_option` VALUES ('125', 'web_proc_customer_review_100015', 'true', null);
INSERT INTO `upms_option` VALUES ('126', 'web_proc_customer_visit_100015', 'true', null);
INSERT INTO `upms_option` VALUES ('127', 'seller_store_check_100016', 'true', null);
INSERT INTO `upms_option` VALUES ('128', 'web_procedure_review_100016', 'true', null);
INSERT INTO `upms_option` VALUES ('129', 'web_proc_customer_review_100016', 'true', null);
INSERT INTO `upms_option` VALUES ('130', 'web_proc_customer_visit_100016', 'true', null);
INSERT INTO `upms_option` VALUES ('131', 'seller_store_check_100017', 'true', null);
INSERT INTO `upms_option` VALUES ('132', 'web_procedure_review_100017', 'true', null);
INSERT INTO `upms_option` VALUES ('133', 'web_proc_customer_review_100017', 'true', null);
INSERT INTO `upms_option` VALUES ('134', 'web_proc_customer_visit_100017', 'true', null);
INSERT INTO `upms_option` VALUES ('135', 'seller_store_check_100018', 'true', null);
INSERT INTO `upms_option` VALUES ('136', 'web_procedure_review_100018', 'true', null);
INSERT INTO `upms_option` VALUES ('137', 'web_proc_customer_review_100018', 'true', null);
INSERT INTO `upms_option` VALUES ('138', 'web_proc_customer_visit_100018', 'true', null);
INSERT INTO `upms_option` VALUES ('139', 'seller_store_check_100019', 'true', null);
INSERT INTO `upms_option` VALUES ('140', 'web_procedure_review_100019', 'true', null);
INSERT INTO `upms_option` VALUES ('141', 'web_proc_customer_review_100019', 'true', null);
INSERT INTO `upms_option` VALUES ('142', 'web_proc_customer_visit_100019', 'true', null);
INSERT INTO `upms_option` VALUES ('147', 'seller_store_check_100020', 'true', null);
INSERT INTO `upms_option` VALUES ('148', 'web_procedure_review_100020', 'true', null);
INSERT INTO `upms_option` VALUES ('149', 'web_proc_customer_review_100020', 'true', null);
INSERT INTO `upms_option` VALUES ('150', 'web_proc_customer_visit_100020', 'true', null);
INSERT INTO `upms_option` VALUES ('155', 'seller_store_check_100021', 'true', null);
INSERT INTO `upms_option` VALUES ('156', 'web_procedure_review_100021', 'true', null);
INSERT INTO `upms_option` VALUES ('157', 'web_proc_customer_review_100021', 'true', null);
INSERT INTO `upms_option` VALUES ('158', 'web_proc_customer_visit_100021', 'true', null);
INSERT INTO `upms_option` VALUES ('159', 'seller_store_check_100022', 'true', null);
INSERT INTO `upms_option` VALUES ('160', 'web_procedure_review_100022', 'true', null);
INSERT INTO `upms_option` VALUES ('161', 'web_proc_customer_review_100022', 'true', null);
INSERT INTO `upms_option` VALUES ('162', 'web_proc_customer_visit_100022', 'true', null);
INSERT INTO `upms_option` VALUES ('163', 'seller_store_check_100023', 'true', null);
INSERT INTO `upms_option` VALUES ('164', 'web_procedure_review_100023', 'true', null);
INSERT INTO `upms_option` VALUES ('165', 'web_proc_customer_review_100023', 'true', null);
INSERT INTO `upms_option` VALUES ('166', 'web_proc_customer_visit_100023', 'true', null);
INSERT INTO `upms_option` VALUES ('167', 'seller_store_check_100024', 'true', null);
INSERT INTO `upms_option` VALUES ('168', 'web_procedure_review_100024', 'true', null);
INSERT INTO `upms_option` VALUES ('169', 'web_proc_customer_review_100024', 'true', null);
INSERT INTO `upms_option` VALUES ('170', 'web_proc_customer_visit_100024', 'true', null);
INSERT INTO `upms_option` VALUES ('179', 'seller_store_check_100024', 'true', null);
INSERT INTO `upms_option` VALUES ('180', 'web_procedure_review_100024', 'true', null);
INSERT INTO `upms_option` VALUES ('181', 'web_proc_customer_review_100024', 'true', null);
INSERT INTO `upms_option` VALUES ('182', 'web_proc_customer_visit_100024', 'true', null);
INSERT INTO `upms_option` VALUES ('183', 'seller_store_check_100025', 'true', null);
INSERT INTO `upms_option` VALUES ('184', 'web_procedure_review_100025', 'true', null);
INSERT INTO `upms_option` VALUES ('185', 'web_proc_customer_review_100025', 'true', null);
INSERT INTO `upms_option` VALUES ('186', 'web_proc_customer_visit_100025', 'true', null);
INSERT INTO `upms_option` VALUES ('187', 'seller_store_check_100026', 'true', null);
INSERT INTO `upms_option` VALUES ('188', 'web_procedure_review_100026', 'true', null);
INSERT INTO `upms_option` VALUES ('189', 'web_proc_customer_review_100026', 'true', null);
INSERT INTO `upms_option` VALUES ('190', 'web_proc_customer_visit_100026', 'true', null);
INSERT INTO `upms_option` VALUES ('191', 'seller_store_check_100026', 'true', null);
INSERT INTO `upms_option` VALUES ('192', 'web_procedure_review_100026', 'true', null);
INSERT INTO `upms_option` VALUES ('193', 'web_proc_customer_review_100026', 'true', null);
INSERT INTO `upms_option` VALUES ('194', 'web_proc_customer_visit_100026', 'true', null);
INSERT INTO `upms_option` VALUES ('195', 'seller_store_check_100027', 'true', null);
INSERT INTO `upms_option` VALUES ('196', 'web_procedure_review_100027', 'true', null);
INSERT INTO `upms_option` VALUES ('197', 'web_proc_customer_review_100027', 'true', null);
INSERT INTO `upms_option` VALUES ('198', 'web_proc_customer_visit_100027', 'true', null);
INSERT INTO `upms_option` VALUES ('199', 'seller_store_check_100028', 'true', null);
INSERT INTO `upms_option` VALUES ('200', 'web_procedure_review_100028', 'true', null);
INSERT INTO `upms_option` VALUES ('201', 'web_proc_customer_review_100028', 'true', null);
INSERT INTO `upms_option` VALUES ('202', 'web_proc_customer_visit_100028', 'true', null);
INSERT INTO `upms_option` VALUES ('203', 'seller_store_check_100029', 'true', null);
INSERT INTO `upms_option` VALUES ('204', 'web_procedure_review_100029', 'true', null);
INSERT INTO `upms_option` VALUES ('205', 'web_proc_customer_review_100029', 'true', null);
INSERT INTO `upms_option` VALUES ('206', 'web_proc_customer_visit_100029', 'true', null);
INSERT INTO `upms_option` VALUES ('207', 'seller_store_check_100030', 'true', null);
INSERT INTO `upms_option` VALUES ('208', 'web_procedure_review_100030', 'true', null);
INSERT INTO `upms_option` VALUES ('209', 'web_proc_customer_review_100030', 'true', null);
INSERT INTO `upms_option` VALUES ('210', 'web_proc_customer_visit_100030', 'true', null);
INSERT INTO `upms_option` VALUES ('211', 'seller_store_check_100031', 'true', null);
INSERT INTO `upms_option` VALUES ('212', 'web_procedure_review_100031', 'true', null);
INSERT INTO `upms_option` VALUES ('213', 'web_proc_customer_review_100031', 'true', null);
INSERT INTO `upms_option` VALUES ('214', 'web_proc_customer_visit_100031', 'true', null);
INSERT INTO `upms_option` VALUES ('215', 'seller_store_check_100032', 'true', null);
INSERT INTO `upms_option` VALUES ('216', 'web_procedure_review_100032', 'true', null);
INSERT INTO `upms_option` VALUES ('217', 'web_proc_customer_review_100032', 'true', null);
INSERT INTO `upms_option` VALUES ('218', 'web_proc_customer_visit_100032', 'true', null);
INSERT INTO `upms_option` VALUES ('231', 'seller_store_check_100033', 'true', null);
INSERT INTO `upms_option` VALUES ('232', 'web_procedure_review_100033', 'true', null);
INSERT INTO `upms_option` VALUES ('233', 'web_proc_customer_review_100033', 'true', null);
INSERT INTO `upms_option` VALUES ('234', 'web_proc_customer_visit_100033', 'true', null);
INSERT INTO `upms_option` VALUES ('235', 'seller_store_check_100034', 'true', null);
INSERT INTO `upms_option` VALUES ('236', 'web_procedure_review_100034', 'true', null);
INSERT INTO `upms_option` VALUES ('237', 'web_proc_customer_review_100034', 'true', null);
INSERT INTO `upms_option` VALUES ('238', 'web_proc_customer_visit_100034', 'true', null);
INSERT INTO `upms_option` VALUES ('239', 'seller_store_check_100035', 'true', null);
INSERT INTO `upms_option` VALUES ('240', 'web_procedure_review_100035', 'true', null);
INSERT INTO `upms_option` VALUES ('241', 'web_proc_customer_review_100035', 'true', null);
INSERT INTO `upms_option` VALUES ('242', 'web_proc_customer_visit_100035', 'true', null);
INSERT INTO `upms_option` VALUES ('243', 'web_proc_activity_apply_100001', 'true', null);
INSERT INTO `upms_option` VALUES ('244', 'web_proc_num_limit_100033', null, null);
INSERT INTO `upms_option` VALUES ('245', 'web_proc_price_limit_100033', null, null);
INSERT INTO `upms_option` VALUES ('246', 'web_procedure_review_edit_100033', null, null);
INSERT INTO `upms_option` VALUES ('247', 'web_proc_activity_apply_100033', 'true', null);
INSERT INTO `upms_option` VALUES ('248', 'web_order_price_edit_100033', 'true', null);
INSERT INTO `upms_option` VALUES ('249', 'seller_store_check_XJ0001', 'true', null);
INSERT INTO `upms_option` VALUES ('250', 'web_procedure_review_XJ0001', 'true', null);
INSERT INTO `upms_option` VALUES ('251', 'web_proc_customer_review_XJ0001', 'true', null);
INSERT INTO `upms_option` VALUES ('252', 'web_proc_customer_visit_XJ0001', 'true', null);
INSERT INTO `upms_option` VALUES ('253', 'seller_store_check_200010', 'true', null);
INSERT INTO `upms_option` VALUES ('254', 'web_procedure_review_200010', 'true', null);
INSERT INTO `upms_option` VALUES ('255', 'web_proc_customer_review_200010', null, null);
INSERT INTO `upms_option` VALUES ('256', 'web_proc_customer_visit_200010', 'true', null);
INSERT INTO `upms_option` VALUES ('257', 'seller_store_check_200011', 'true', null);
INSERT INTO `upms_option` VALUES ('258', 'web_procedure_review_200011', 'true', null);
INSERT INTO `upms_option` VALUES ('259', 'web_proc_customer_review_200011', null, null);
INSERT INTO `upms_option` VALUES ('260', 'web_proc_customer_visit_200011', 'true', null);
INSERT INTO `upms_option` VALUES ('261', 'seller_store_check_200012', 'true', null);
INSERT INTO `upms_option` VALUES ('262', 'web_procedure_review_200012', 'true', null);
INSERT INTO `upms_option` VALUES ('263', 'web_proc_customer_review_200012', null, null);
INSERT INTO `upms_option` VALUES ('264', 'web_proc_customer_visit_200012', 'true', null);
INSERT INTO `upms_option` VALUES ('265', 'web_proc_activity_apply_200012', null, null);
INSERT INTO `upms_option` VALUES ('266', 'web_order_price_edit_200012', 'true', null);
INSERT INTO `upms_option` VALUES ('267', 'web_proc_price_limit_200012', null, null);
INSERT INTO `upms_option` VALUES ('268', 'web_proc_num_limit_200012', null, null);
INSERT INTO `upms_option` VALUES ('269', 'web_procedure_review_edit_200012', null, null);
INSERT INTO `upms_option` VALUES ('270', 'web_order_price_edit_200010', 'true', null);
INSERT INTO `upms_option` VALUES ('271', 'web_procedure_review_edit_200010', null, null);
INSERT INTO `upms_option` VALUES ('272', 'web_proc_activity_apply_200010', null, null);
INSERT INTO `upms_option` VALUES ('273', 'web_proc_num_limit_200010', null, null);
INSERT INTO `upms_option` VALUES ('274', 'web_proc_price_limit_200010', null, null);
INSERT INTO `upms_option` VALUES ('275', 'web_order_price_edit_200011', 'true', null);
INSERT INTO `upms_option` VALUES ('276', 'web_procedure_review_edit_200011', null, null);
INSERT INTO `upms_option` VALUES ('277', 'web_proc_activity_apply_200011', null, null);
INSERT INTO `upms_option` VALUES ('278', 'web_proc_num_limit_200011', null, null);
INSERT INTO `upms_option` VALUES ('279', 'web_proc_price_limit_200011', null, null);
INSERT INTO `upms_option` VALUES ('280', 'web_proc_customer_review_100003', null, null);
INSERT INTO `upms_option` VALUES ('281', 'seller_store_check_100003', null, null);
INSERT INTO `upms_option` VALUES ('282', 'web_proc_num_limit_100003', null, null);
INSERT INTO `upms_option` VALUES ('283', 'web_procedure_review_100003', null, null);
INSERT INTO `upms_option` VALUES ('284', 'web_order_price_edit_100003', null, null);
INSERT INTO `upms_option` VALUES ('285', 'web_procedure_review_edit_100003', null, null);
INSERT INTO `upms_option` VALUES ('286', 'web_proc_customer_visit_100003', null, null);
INSERT INTO `upms_option` VALUES ('287', 'web_proc_price_limit_100003', null, null);
INSERT INTO `upms_option` VALUES ('288', 'web_proc_activity_apply_100003', 'true', null);
INSERT INTO `upms_option` VALUES ('289', 'web_order_mix_gift_100001', 'true', null);
INSERT INTO `upms_option` VALUES ('306', 'data_upload_customer_type_5604e47c41b8487487a0181e59eb457e', null, null);
INSERT INTO `upms_option` VALUES ('307', 'data_upload_customer_type_e50477c3522f49ad8fa7f5c0821e560f', null, null);
INSERT INTO `upms_option` VALUES ('308', 'data_upload_customer_type_a8533075ae3147838e017e00928eb41e', null, null);
INSERT INTO `upms_option` VALUES ('309', 'data_upload_customer_type_0aecbfdc6e9943f591950dfd2deec9b9', 'true', null);
INSERT INTO `upms_option` VALUES ('310', 'data_upload_customer_type_a34723ec26754155bd757f7f623d98ad', null, null);
INSERT INTO `upms_option` VALUES ('311', 'data_upload_customer_type_5a4d896c579d43b693ff90f69e2be6fb', null, null);
INSERT INTO `upms_option` VALUES ('312', 'data_upload_customer_type_401a2ae484a6488e86bc333ad3159a68', null, null);
INSERT INTO `upms_option` VALUES ('313', 'data_upload_customer_type_8530e80c974a4aec99be4f7d2a93a812', null, null);
INSERT INTO `upms_option` VALUES ('314', 'mobile_browse_enable', 'true', null);

-- ----------------------------
-- Table structure for upms_role
-- ----------------------------
DROP TABLE IF EXISTS `upms_role`;
CREATE TABLE `upms_role` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_code` varchar(22) NOT NULL COMMENT '角色编号',
  `order_list` int(11) DEFAULT NULL COMMENT '排序',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '对应cc_department表，机构ID',
  `data_area` varchar(200) DEFAULT NULL COMMENT '数据域',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_data_area` (`data_area`),
  KEY `_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of upms_role
-- ----------------------------
INSERT INTO `upms_role` VALUES ('00fe058e31d04df7a34bf440790b9b01', '商超财务主管', '017', '17', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:41', null);
INSERT INTO `upms_role` VALUES ('0183c9fa978d4f11b8ae93d6ae456987', '餐饮主管', '018', '18', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:24', null);
INSERT INTO `upms_role` VALUES ('01e098d6c8c3411f94537840dca36763', '直营商管理员', '003', '3', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:48', null);
INSERT INTO `upms_role` VALUES ('0241b628808649f7bfc901b44c4e6765', '综合主管', '005', '5', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('0243bedc267448568058c04f258bb177', '商超主管', '016', '16', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:33', null);
INSERT INTO `upms_role` VALUES ('033a27b840e74773938305c3747fa3c4', '商超主管', '016', '16', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:46', null);
INSERT INTO `upms_role` VALUES ('05761780e0f649a5bce0301e818d5f7e', '直营商管理员', '003', '3', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:13', null);
INSERT INTO `upms_role` VALUES ('060d3a86c4ad456594c976aa2685ddb9', '商超主管', '016', '16', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:16', null);
INSERT INTO `upms_role` VALUES ('06509f60f21a4f5a9e32d00595984976', '直营商管理员', '003', '3', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_role` VALUES ('06592fe12d00420b9e7d57089ef37b75', '直营经理', '012', '12', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:53', null);
INSERT INTO `upms_role` VALUES ('06f4d233d10249aabc0ff26e394b01d0', '餐饮财务主管', '019', '19', null, '0', '001', '2017-11-29 12:07:27', null);
INSERT INTO `upms_role` VALUES ('0715fa5e446f4d95a7c69df723ed2a18', '商超财务主管', '017', '17', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:10', null);
INSERT INTO `upms_role` VALUES ('0835eb1ac3394613b27017c7acc318fb', '财务主管', '007', '7', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:08', null);
INSERT INTO `upms_role` VALUES ('08463038de5e47ddbb99cdcd8ced3ac2', '商超主管', '016', '16', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:02', null);
INSERT INTO `upms_role` VALUES ('0a27f27188ea422095717a3c8d34cf10', '餐饮主管', '018', '18', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('0b8ad21416094f27b330b6e0bec93cf2', '综合库管', '008', '8', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_role` VALUES ('0bb85bcab7cc4c63a9ea46945385e8fd', '直营商管理员', '003', '3', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_role` VALUES ('0c028f40bf52423f8b87521ab5ccb714', '商超经理', '015', '15', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:05', null);
INSERT INTO `upms_role` VALUES ('0ca27a3897aa408d8a55646ee7a0e531', '商超经理', '015', '15', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:17', null);
INSERT INTO `upms_role` VALUES ('0ce5952eaad4442fa6ea8bdccf720731', '财务主管', '007', '7', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:18', null);
INSERT INTO `upms_role` VALUES ('0dd07bfe085a4c2289ddad53cd81ee41', '餐饮财务主管', '019', '19', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_role` VALUES ('0e32631fecb34e62aeef46bb33eb7d82', '主管', '006', '6', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:58', null);
INSERT INTO `upms_role` VALUES ('0e38045c622f4994ac4f3ae194340f28', '账务人员', '020', '20', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('0e73419717b14c0881d691aaec6b8bdb', '餐饮财务主管', '019', '19', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:10', null);
INSERT INTO `upms_role` VALUES ('0ef8ec75e4f44a579b244099cda7ba3c', '综合主管', '005', '5', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:46:04', null);
INSERT INTO `upms_role` VALUES ('0fa41fa971e849d0af122babe2ab0047', '业务员', '010', '10', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:40', null);
INSERT INTO `upms_role` VALUES ('0ff4d8f68b2445da881a4accc0892610', '综合库管', '008', '8', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:13', null);
INSERT INTO `upms_role` VALUES ('10e53b766baa401181d03b1e9d0f119c', '经销商老总', '004', '4', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:38', null);
INSERT INTO `upms_role` VALUES ('10ff2fcdb6d045719949b66afee0a79c', '直营经理', '012', '12', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:15', null);
INSERT INTO `upms_role` VALUES ('11969b4ea136489cabb368d130613554', '经销商管理员', '002', '2', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:17', null);
INSERT INTO `upms_role` VALUES ('11fcdbe107ba4cea88b116960017af7d', '商超财务主管', '017', '17', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:58', null);
INSERT INTO `upms_role` VALUES ('1239c6d2ada848069b9468dc99299c75', '商超主管', '016', '16', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('145d39b51a4e4e8095a9e05af4e4997e', '直营总监', '011', '11', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:09', null);
INSERT INTO `upms_role` VALUES ('14e7450ea23c4b93baafe10476c12763', '综合主管', '005', '5', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:54', null);
INSERT INTO `upms_role` VALUES ('1527091acefe450595c18640ea9c79c9', '商超财务主管', '017', '17', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:42', null);
INSERT INTO `upms_role` VALUES ('152b901ba01d4267a54812d94eea29ce', '直营商管理员', '003', '3', null, '0', '001', '2017-12-12 15:10:42', null);
INSERT INTO `upms_role` VALUES ('153122622aa44ec192b6e5e59eb41a0c', '直营商管理员', '003', '3', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:45', null);
INSERT INTO `upms_role` VALUES ('15b41df1537d4a79adbfff2f73ec7602', '直营主管', '013', '13', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:34', null);
INSERT INTO `upms_role` VALUES ('165e3ff0f5f6452eb258c646adff1645', '账务人员', '020', '20', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:55', null);
INSERT INTO `upms_role` VALUES ('16844757c6f54715b3f533f94ebe93a1', '商超主管', '016', '16', null, '0', '001', '2017-10-23 15:26:03', '2017-11-29 12:06:17');
INSERT INTO `upms_role` VALUES ('178490f446f446bb842eecba54c9bc5d', '财务主管', '007', '7', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:45', null);
INSERT INTO `upms_role` VALUES ('18a496dfb7094e9fb3e547c62f62d6bf', '餐饮财务主管', '019', '19', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:47', null);
INSERT INTO `upms_role` VALUES ('1a2315839bc94e829dd92a4273622338', '直营财务主管', '014', '14', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:17', null);
INSERT INTO `upms_role` VALUES ('1a81720034a8409ca43111d60ee5b291', '库管', '009', '9', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:14', null);
INSERT INTO `upms_role` VALUES ('1aaa07d2abe9470ea0e960dbd7b21d87', '直营财务主管', '014', '14', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:28', null);
INSERT INTO `upms_role` VALUES ('1b7cc0def0194d85859c5bda1d89564d', '主管', '006', '6', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:56', null);
INSERT INTO `upms_role` VALUES ('1b8fd3c7264e42889a60a33041970ec0', '商超经理', '015', '15', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('1b957e6415004f95a156bd7b6bcbf0a1', '商超主管', '016', '16', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:46', null);
INSERT INTO `upms_role` VALUES ('1c7700039ec34f02aa8c109f05488b0c', '餐饮财务主管', '019', '19', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:20', null);
INSERT INTO `upms_role` VALUES ('1cb844709d294269893b69f442be449e', '财务主管', '007', '7', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:28', null);
INSERT INTO `upms_role` VALUES ('1cd0bf27e99b418ca2b88ee39cde2986', '综合库管', '008', '8', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:14', null);
INSERT INTO `upms_role` VALUES ('1d427e3a978c4567aa4c5b8e1d48d80c', '业务员', '010', '10', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:18', null);
INSERT INTO `upms_role` VALUES ('1e7f6648105a4ebda5f53d20235554ac', '库管', '009', '9', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:38', null);
INSERT INTO `upms_role` VALUES ('1ec84926b4af489e9d416916d537877e', '直营财务主管', '014', '14', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:41', null);
INSERT INTO `upms_role` VALUES ('1f8412e9e67e4035ba89e04e034b434c', '商超财务主管', '017', '17', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:19', null);
INSERT INTO `upms_role` VALUES ('2035e56e7fe74830947ad6bff1a6d3b5', '库管', '009', '9', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:04', null);
INSERT INTO `upms_role` VALUES ('2094c5b5a4ba41d299572105e921f00e', '直营商管理员', '003', '3', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_role` VALUES ('216d62ad953c4868930182bab9d11d8a', '商超主管', '016', '16', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:50', null);
INSERT INTO `upms_role` VALUES ('22a071c93aef4119a00ba8b7a99f4921', '商超经理', '015', '15', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:54', null);
INSERT INTO `upms_role` VALUES ('24100752dae44fbdb196f85022468d3e', '餐饮财务主管', '019', '19', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:29', null);
INSERT INTO `upms_role` VALUES ('24ca32f6d9204251a74732deb9573dd7', '经销商老总', '004', '4', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:17', null);
INSERT INTO `upms_role` VALUES ('256530cfda6140b280be5e7a62d72bd4', '直营总监', '011', '11', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:53', null);
INSERT INTO `upms_role` VALUES ('259196f5ba89464a9a93875d75437fe0', '经销商管理员', '002', '2', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:10', null);
INSERT INTO `upms_role` VALUES ('25b2761626824e2693f6dff1f731c049', '直营商管理员', '003', '3', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:34', null);
INSERT INTO `upms_role` VALUES ('25cd7052207344f9b5223464be17ee32', '餐饮财务主管', '019', '19', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:00', null);
INSERT INTO `upms_role` VALUES ('26095981c4ac4ef18217fdce6f1f001b', '商超财务主管', '017', '17', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:16', null);
INSERT INTO `upms_role` VALUES ('2697546a040146ebbc220556469d5f87', '综合库管', '008', '8', null, '0', '001', '2017-10-23 15:16:13', '2017-11-29 12:46:58');
INSERT INTO `upms_role` VALUES ('26ac8b7c076249949cb3526f5a847424', '经销商老总', '004', '4', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:19', null);
INSERT INTO `upms_role` VALUES ('2730a410cac843049d39cde70cf139b4', '直营财务主管', '014', '14', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:17', null);
INSERT INTO `upms_role` VALUES ('27c5a66e8dae4aafbc8c939aedbdb117', '直营总监', '011', '11', null, '0', '001', '2017-11-29 11:57:09', '2017-11-29 12:47:27');
INSERT INTO `upms_role` VALUES ('27e50a8aa21c4825ba7c684a20258cc2', '财务主管', '007', '7', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:42', null);
INSERT INTO `upms_role` VALUES ('28fc3c688df14d3e91afa3858d843fca', '商超财务主管', '017', '17', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:09', null);
INSERT INTO `upms_role` VALUES ('290c9e30aba54e8baef7f0b87508dccf', '商超经理', '015', '15', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:51', null);
INSERT INTO `upms_role` VALUES ('2a8b000a24eb4ea3962950f77ec4d75a', '商超主管', '016', '16', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:02', null);
INSERT INTO `upms_role` VALUES ('2ad2e6684d314f459b858cf490e952cc', '直营主管', '013', '13', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:55', null);
INSERT INTO `upms_role` VALUES ('2afd81ba2e934b85891670905cf3fdd6', '餐饮主管', '018', '18', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:10', null);
INSERT INTO `upms_role` VALUES ('2b1f17e0121748edb52c1731a3c70529', '综合库管', '008', '8', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:34', null);
INSERT INTO `upms_role` VALUES ('2d853c4152f84e43adcb1b79743a7455', '直营主管', '013', '13', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:38', null);
INSERT INTO `upms_role` VALUES ('2e18647df3db405caa52a74c02e8db40', '经销商老总', '004', '4', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:38', null);
INSERT INTO `upms_role` VALUES ('2e881cc147824245b7c68e29ba2f9999', '商超经理', '015', '15', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:40', null);
INSERT INTO `upms_role` VALUES ('304b4f537e70443dac549579a2fbd196', '财务主管', '007', '7', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:08', null);
INSERT INTO `upms_role` VALUES ('30bf3caec5c44c2dbb4c12c80f342629', '餐饮财务主管', '019', '19', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:50', null);
INSERT INTO `upms_role` VALUES ('30f23717b1c742228faf153f3934272f', '直营商管理员', '003', '3', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:20', null);
INSERT INTO `upms_role` VALUES ('32bc185d3d4749ceaa7bffc34792af92', '库管', '009', '9', null, '0', '001', '2017-11-29 12:04:26', '2017-11-29 12:47:07');
INSERT INTO `upms_role` VALUES ('32cc59f436ff4a349fd60c94690b139f', '商超经理', '015', '15', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:13', null);
INSERT INTO `upms_role` VALUES ('32eff409013f4b7484bda75ba1ff6461', '财务主管', '007', '7', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:20', null);
INSERT INTO `upms_role` VALUES ('33a2ed1613c14194942db2629cfe366c', '直营总监', '011', '11', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:14', null);
INSERT INTO `upms_role` VALUES ('33e74b87391b4864842e7b2c2bea09b8', '餐饮主管', '018', '18', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:23', null);
INSERT INTO `upms_role` VALUES ('3579a03149074b86be57d0e18cb09107', '经销商老总', '004', '4', null, '0', '001', '2017-11-29 11:55:50', null);
INSERT INTO `upms_role` VALUES ('360120976f1346dc8acf2b97f411d861', '综合库管', '008', '8', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:03', null);
INSERT INTO `upms_role` VALUES ('3682da565d87405494b907feee6ed927', '直营总监', '011', '11', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:37', null);
INSERT INTO `upms_role` VALUES ('373143321a274595a8287d36d384f9a9', '经销商老总', '004', '4', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:37', null);
INSERT INTO `upms_role` VALUES ('38035aaf19da44db883c3f9df3451bec', '经销商老总', '004', '4', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_role` VALUES ('3892fe7ace2840fa8be37ed4620bd6b7', '直营商管理员', '003', '3', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:50', null);
INSERT INTO `upms_role` VALUES ('3a99f56bd1d04ec3b769e9f79c11037e', '餐饮财务主管', '019', '19', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_role` VALUES ('3aacdb1b4fc04c08b45c4040422a51fd', '业务员', '010', '10', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('3abf7132896a42f7be3bc5396ba03d4d', '库管', '009', '9', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:12', null);
INSERT INTO `upms_role` VALUES ('3b44935849e64c1381ce999a51779d2b', '餐饮主管', '018', '18', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:59', null);
INSERT INTO `upms_role` VALUES ('3c1b0438dea44eaebe21c707abd48ab9', '直营经理', '012', '12', null, '0', '001', '2017-11-29 11:57:22', '2017-11-29 12:47:43');
INSERT INTO `upms_role` VALUES ('3c528940684548b9a61d9a815be11083', '商超财务主管', '017', '17', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:37', null);
INSERT INTO `upms_role` VALUES ('3cc3e7d44ea04a00994fa2826fe3f3df', '财务主管', '007', '7', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:50', null);
INSERT INTO `upms_role` VALUES ('3eebf99f38674aa999117f8dec8cbe79', '主管', '006', '6', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:11', null);
INSERT INTO `upms_role` VALUES ('3f0ecf0c9156466fb49dd7eb7e1bbc65', '库管', '009', '9', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:26', null);
INSERT INTO `upms_role` VALUES ('3fb97f9a33494ff1b40ab0e8eb7557b1', '直营经理', '012', '12', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('402c603d776d46b59877cce1765d1dcd', '业务员', '010', '10', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:53', null);
INSERT INTO `upms_role` VALUES ('409ab91ac1714729b78cdbb0ee54b00c', '主管', '006', '6', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:09', null);
INSERT INTO `upms_role` VALUES ('4144eca3a49a455e97b58d02ad9ff9c4', '库管', '009', '9', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('4147ccdd48974cfbbb789f7bcca1f32b', '直营商管理员', '003', '3', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:00', null);
INSERT INTO `upms_role` VALUES ('4280c4feb9624a47af7ae943f020d782', '商超财务主管', '017', '17', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:18', null);
INSERT INTO `upms_role` VALUES ('4283a18f317745a9988188971e72a6c9', '直营主管', '013', '13', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:53', null);
INSERT INTO `upms_role` VALUES ('42a3dd42dd614929b6e1a0fe23bb4394', '直营主管', '013', '13', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('42c9b394147048cd9c77285ec57c1980', '直营主管', '013', '13', null, '0', '001', '2017-11-29 11:57:34', '2017-11-29 12:47:51');
INSERT INTO `upms_role` VALUES ('42e6428bdd3c41d6a7809f72cd784aba', '直营商管理员', '003', '3', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_role` VALUES ('44f6b944abb14cf58ceb21d012c48ee7', '业务员', '010', '10', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:08', null);
INSERT INTO `upms_role` VALUES ('461390f29aeb4440a00a47c18773f76e', '综合库管', '008', '8', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:02', null);
INSERT INTO `upms_role` VALUES ('462ff146288c4d4cab13b624f2431421', '商超主管', '016', '16', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:31', null);
INSERT INTO `upms_role` VALUES ('467b835126414013901ed0e70e8e68ae', '直营总监', '011', '11', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:16', null);
INSERT INTO `upms_role` VALUES ('475990543c864fa785df667cd67a3009', '经销商老总', '004', '4', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:33', null);
INSERT INTO `upms_role` VALUES ('48e6face92774dd299f4b7f4620a31b3', '直营经理', '012', '12', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:07', null);
INSERT INTO `upms_role` VALUES ('4944bc0186be4abeb7f1f8295e931bbd', '综合库管', '008', '8', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:21', null);
INSERT INTO `upms_role` VALUES ('4953fff68e124f56864236f7540373d8', '综合主管', '005', '5', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:19', null);
INSERT INTO `upms_role` VALUES ('4973d8ee5bb44b569919237a27f901a9', '直营总监', '011', '11', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:32', null);
INSERT INTO `upms_role` VALUES ('49da3b11de00400996db9119274bf3ba', '经销商老总', '004', '4', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('4aa154ef9ec243d8a60401b389bbac2b', '餐饮主管', '018', '18', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:17', null);
INSERT INTO `upms_role` VALUES ('4b816cf68d5f46b6ad72c859ca8e61e3', '财务主管', '007', '7', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:22', null);
INSERT INTO `upms_role` VALUES ('4b8dbacfe50c49f2a01092d165c191d9', '经销商老总', '004', '4', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:54', null);
INSERT INTO `upms_role` VALUES ('4bc68fbf5e114ffbb9ac333c2651d8ce', '主管', '006', '6', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:23', null);
INSERT INTO `upms_role` VALUES ('4dac6a3538b948bcbbf75b802699878c', '直营经理', '012', '12', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:34', null);
INSERT INTO `upms_role` VALUES ('4db2e49854d14d3ca3ff4fc7c77e6734', '综合库管', '008', '8', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:48', null);
INSERT INTO `upms_role` VALUES ('4dd2badb0ed24951830f7628a0ab2575', '商超财务主管', '017', '17', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:56', null);
INSERT INTO `upms_role` VALUES ('4f5e4cedcc2e431c9b2507d27f7c1904', '直营主管', '013', '13', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:40', null);
INSERT INTO `upms_role` VALUES ('4fc49eccb9e946a789470e21451687bd', '餐饮财务主管', '019', '19', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_role` VALUES ('4fdb0863dcb8437e9fecb999df1f0846', '商超主管', '016', '16', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:35', null);
INSERT INTO `upms_role` VALUES ('4fe89b2b240243098f7eb723e58a7243', '直营经理', '012', '12', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:49', null);
INSERT INTO `upms_role` VALUES ('50c44b196ac44f889e35b7c7a9f0c0bb', '综合库管', '008', '8', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:11', null);
INSERT INTO `upms_role` VALUES ('51025cb27f274d68bbf03bb09c4b3bac', '直营财务主管', '014', '14', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:25', null);
INSERT INTO `upms_role` VALUES ('5145cdc23045411792b2a43c2914d5f9', '经销商管理员', '002', '2', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:18', null);
INSERT INTO `upms_role` VALUES ('51cbcbec8b994b479628f399025d79b7', '餐饮财务主管', '019', '19', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:10', null);
INSERT INTO `upms_role` VALUES ('51cf94a296e04d89973ae4ec60d7f606', '直营主管', '013', '13', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:18', null);
INSERT INTO `upms_role` VALUES ('52374d846eb040b2afe067a0d9495fa7', '商超主管', '016', '16', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:52', null);
INSERT INTO `upms_role` VALUES ('52d1d0b6cdb8493abb7dd7390176812d', '财务主管', '007', '7', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:53', null);
INSERT INTO `upms_role` VALUES ('535b63572a604f9c8970fee97b3a95df', '商超经理', '015', '15', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:07', null);
INSERT INTO `upms_role` VALUES ('5362c33ed0364d1ba3e359930c55f628', '直营商管理员', '003', '3', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:10', null);
INSERT INTO `upms_role` VALUES ('53df8490fc8d4e7794265067d26d02e7', '库管', '009', '9', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:36', null);
INSERT INTO `upms_role` VALUES ('5441f28bb6284e37b4453a8a1212520d', '账务人员', '020', '20', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:53', null);
INSERT INTO `upms_role` VALUES ('567fc86f2eb74173895649cfbe53ca57', '库管', '009', '9', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:33', null);
INSERT INTO `upms_role` VALUES ('56f13d2df0cd402e86660b39caf4b436', '商超财务主管', '017', '17', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('571b71217c074f8a93e3f497b5ececac', '商超主管', '016', '16', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:23', null);
INSERT INTO `upms_role` VALUES ('576537697bbd439884451cae5bdd5225', '直营总监', '011', '11', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:37', null);
INSERT INTO `upms_role` VALUES ('5b80a24a1274424ebef7a613c5c65f2f', '直营经理', '012', '12', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('5ba4ca4cdd9f40f3b744d9b176092fc4', '直营财务主管', '014', '14', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:57', null);
INSERT INTO `upms_role` VALUES ('5c97046e96cb420bb01a52f5e6b1b044', '商超经理', '015', '15', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:16', null);
INSERT INTO `upms_role` VALUES ('5cbc16e61ca54ce1bd40aa7a1a5930f4', '主管', '006', '6', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:20', null);
INSERT INTO `upms_role` VALUES ('5e329fb7c9834d459be4b06b63bd6a07', '商超经理', '015', '15', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('5e639e74f83a4f3d93a89b5aa0726990', '直营总监', '011', '11', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:51', null);
INSERT INTO `upms_role` VALUES ('5f702459e520447d82ada8e69f80aa94', '餐饮主管', '018', '18', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:55', null);
INSERT INTO `upms_role` VALUES ('602c2fe80e464a58b2f1b68d50e29259', '商超财务主管', '017', '17', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:20', null);
INSERT INTO `upms_role` VALUES ('60701edb2a2844fcb4745cd900ff6fd3', '库管', '009', '9', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:38', null);
INSERT INTO `upms_role` VALUES ('609934574d9f43ebb08cba0194257187', '经销商老总', '004', '4', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:52', null);
INSERT INTO `upms_role` VALUES ('619100ceaa5043fb9ef77cbded0532e7', '综合主管', '005', '5', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:21', null);
INSERT INTO `upms_role` VALUES ('61a3df94133f4dd58becc820ae29075b', '库管', '009', '9', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:19', null);
INSERT INTO `upms_role` VALUES ('62663ea1f0e141b5859f13be82c26bb0', '直营总监', '011', '11', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:57', null);
INSERT INTO `upms_role` VALUES ('62b08fb1c9a141d0b698683329f009fc', '餐饮主管', '018', '18', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:57', null);
INSERT INTO `upms_role` VALUES ('63e3cb876c234e278eacf697afc1eb1b', '业务员', '010', '10', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:37', null);
INSERT INTO `upms_role` VALUES ('641ad294977e42eab5ba71b9ba9e79ff', '经销商老总', '004', '4', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:15', null);
INSERT INTO `upms_role` VALUES ('67e87916cc6543d5a904ee560bb69412', '综合主管', '005', '5', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:15', null);
INSERT INTO `upms_role` VALUES ('6803686015954c24b1853b3bda7c38da', '主管', '006', '6', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:17', null);
INSERT INTO `upms_role` VALUES ('691aae58e26f4441871809fb99637982', '直营财务主管', '014', '14', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:53', null);
INSERT INTO `upms_role` VALUES ('6998218d922e413c8d9c0a6cc5680866', '直营经理', '012', '12', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:05', null);
INSERT INTO `upms_role` VALUES ('699f916e7ed4413ba672a7158c790d14', '业务员', '010', '10', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:09', null);
INSERT INTO `upms_role` VALUES ('6a068e45c555466b9dc567fd36b5f33e', '餐饮主管', '018', '18', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:47', null);
INSERT INTO `upms_role` VALUES ('6a1f1f1ba6dc47828bfa08b7aead6ecf', '直营总监', '011', '11', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:27', null);
INSERT INTO `upms_role` VALUES ('6c583c1bad4e4e0ead53a4dced0b3148', '商超经理', '015', '15', null, '0', '001', '2017-10-23 15:26:14', '2017-11-29 12:05:59');
INSERT INTO `upms_role` VALUES ('6d6dc0e562ce4ea690295ec73a78b5c7', '财务主管', '007', '7', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:55', null);
INSERT INTO `upms_role` VALUES ('6d89d19a8a394b6fa402518a0124a2c4', '账务人员', '020', '20', null, '0', '001', '2017-12-14 16:36:05', '2017-12-14 16:37:40');
INSERT INTO `upms_role` VALUES ('6e38f70696ce4478bb5735653415fbb8', '商超主管', '016', '16', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:13', null);
INSERT INTO `upms_role` VALUES ('6e40196e1fa341d0b579ee6e6d6f1f01', '直营经理', '012', '12', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:59', null);
INSERT INTO `upms_role` VALUES ('6e6cfe4a3e7a46e3a1d993f21dd2c568', '直营经理', '012', '12', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:39', null);
INSERT INTO `upms_role` VALUES ('6f677bc191244c3282ba567e67e0fdf7', '直营财务主管', '014', '14', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:40', null);
INSERT INTO `upms_role` VALUES ('6f7a69e35423435ea85b682381ea025f', '综合主管', '005', '5', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:22', null);
INSERT INTO `upms_role` VALUES ('6fc452504c8141d9b377316f45b84754', '库管', '009', '9', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:48', null);
INSERT INTO `upms_role` VALUES ('6fc70a2e94b541a183167944fc1649bc', '主管', '006', '6', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:47', null);
INSERT INTO `upms_role` VALUES ('70eefe63d3504620bb67ec21a8e315d6', '账务人员', '020', '20', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:56', null);
INSERT INTO `upms_role` VALUES ('7269195822334e38b1eff4d32fa150fb', '商超经理', '015', '15', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:26', null);
INSERT INTO `upms_role` VALUES ('72b08285968a477b9625f20e49dbce34', '直营总监', '011', '11', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:35', null);
INSERT INTO `upms_role` VALUES ('7438c782beab44918e62d2939d19d188', '经销商老总', '004', '4', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:15', null);
INSERT INTO `upms_role` VALUES ('7463521d17ba4e88b89269bfae711623', '商超经理', '015', '15', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:14', null);
INSERT INTO `upms_role` VALUES ('76aea37bdc3f4c21b7de17757c759289', '财务主管', '007', '7', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:40', null);
INSERT INTO `upms_role` VALUES ('774f612416d04335932d8346e424421e', '商超主管', '016', '16', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:16', null);
INSERT INTO `upms_role` VALUES ('778844b5b51244ccb0521e691409dbf4', '综合主管', '005', '5', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:53', null);
INSERT INTO `upms_role` VALUES ('7805c88188fe4fe8a4cdeafcb1c01a99', '商超主管', '016', '16', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:36', null);
INSERT INTO `upms_role` VALUES ('782576e913c64a2b8fce058d583407d1', '餐饮财务主管', '019', '19', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:26', null);
INSERT INTO `upms_role` VALUES ('7870ad132aae4c41895fe7296be70edc', '综合库管', '008', '8', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:50', null);
INSERT INTO `upms_role` VALUES ('789841e58d424127b3041a3259d93008', '直营主管', '013', '13', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:25', null);
INSERT INTO `upms_role` VALUES ('78c0c2f30e6f4e409fc5041a2dc200c5', '综合库管', '008', '8', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('79b106b37c364a92ad0eb7011441f90a', '库管', '009', '9', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:53', null);
INSERT INTO `upms_role` VALUES ('7a591574669648438e9536854b98955d', '商超主管', '016', '16', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_role` VALUES ('7b6f6efe96dd4f08bb48d9d50ba71b49', '直营主管', '013', '13', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:39', null);
INSERT INTO `upms_role` VALUES ('7b95d07752f247828c021cf0730e88c9', '财务主管', '007', '7', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:09', null);
INSERT INTO `upms_role` VALUES ('7c1dfe888cbb43c385841c2664de7375', '直营经理', '012', '12', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:05', null);
INSERT INTO `upms_role` VALUES ('7ca2e1151a15406c871520fe49ca017e', '直营主管', '013', '13', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:06', null);
INSERT INTO `upms_role` VALUES ('7ca5050d18a7461488c049fca501074b', '直营总监', '011', '11', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:48', null);
INSERT INTO `upms_role` VALUES ('7f1680aa544a4f4d971f16feae00d9b7', '业务员', '010', '10', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:55', null);
INSERT INTO `upms_role` VALUES ('7f6c92a880934e91b429316a1fe2147b', '商超财务主管', '017', '17', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:46', null);
INSERT INTO `upms_role` VALUES ('808606bb26434d0fb0d0273dd1599e1f', '财务主管', '007', '7', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:16', null);
INSERT INTO `upms_role` VALUES ('812579d14fb54cdc884c4f96fe46ba71', '业务员', '010', '10', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:52', null);
INSERT INTO `upms_role` VALUES ('81ef30f16c7b4043aa69b83d1126319c', '商超财务主管', '017', '17', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('82a9af3bb3b646518cbab089ba881fb7', '直营主管', '013', '13', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:16', null);
INSERT INTO `upms_role` VALUES ('82e28d1d6fce4f37a24be32ff5e3bae3', '主管', '006', '6', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:38', null);
INSERT INTO `upms_role` VALUES ('8533a000b0f84f239a4f371d558afd06', '经销商老总', '004', '4', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:53', null);
INSERT INTO `upms_role` VALUES ('8631aced2f0e4c3fba71ce4aa40b4b93', '主管', '006', '6', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:12', null);
INSERT INTO `upms_role` VALUES ('86464d7f4f994286877c65c06db45e9e', '经销商老总', '004', '4', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:50', null);
INSERT INTO `upms_role` VALUES ('8656911197bf485fa0143dc4a5501cb0', '综合库管', '008', '8', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:47', null);
INSERT INTO `upms_role` VALUES ('867da979936f4cbfbd7e68c770ba2122', '餐饮财务主管', '019', '19', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:44', null);
INSERT INTO `upms_role` VALUES ('886182320ec9401788a71d3c3d7c5db8', '直营商管理员', '003', '3', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:29', null);
INSERT INTO `upms_role` VALUES ('889ba6c9e822410fbc2cb976aa06584f', '商超财务主管', '017', '17', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:36', null);
INSERT INTO `upms_role` VALUES ('889de2553ccb4b8c8cb346e531dc2ba8', '商超经理', '015', '15', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:35', null);
INSERT INTO `upms_role` VALUES ('8903823ec4144916977c033f2ea91abd', '库管', '009', '9', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:37', null);
INSERT INTO `upms_role` VALUES ('8a8d44663fd245aab4166291749f5703', '直营主管', '013', '13', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:51', null);
INSERT INTO `upms_role` VALUES ('8ae926c1a1524c4393472eb58f738d99', '经销商老总', '004', '4', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:13', null);
INSERT INTO `upms_role` VALUES ('8c60188a44c84818be340f6cccf4b013', '直营主管', '013', '13', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:52', null);
INSERT INTO `upms_role` VALUES ('8c8e1d5913b14971822632eded135016', '库管', '009', '9', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:50', null);
INSERT INTO `upms_role` VALUES ('8ca39751359648a7a01a97dfd0ad50a1', '库管', '009', '9', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:19', null);
INSERT INTO `upms_role` VALUES ('8cc76d55ce4043d3a86b8ef6e541cc8d', '综合主管', '005', '5', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:37', null);
INSERT INTO `upms_role` VALUES ('8de4a94d14ff4170a1872630b55b624a', '财务主管', '007', '7', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('8e90da510f084774977ea538e21f59a9', '综合主管', '005', '5', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:34', null);
INSERT INTO `upms_role` VALUES ('8f1303f48c424c85a80d6ecc86609b22', '业务员', '010', '10', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:50', null);
INSERT INTO `upms_role` VALUES ('8f154b87aa784bd38c04069df16c5fff', '经销商老总', '004', '4', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:49', null);
INSERT INTO `upms_role` VALUES ('8ffa3230cefd421da786754e95141706', '餐饮主管', '018', '18', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:20', null);
INSERT INTO `upms_role` VALUES ('90ad2884b3444b679c28f62cb2ac433c', '综合主管', '005', '5', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('916780bd2291401c93fab0cdbb31531f', '直营财务主管', '014', '14', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:36', null);
INSERT INTO `upms_role` VALUES ('924562335ae24a1292cb0a044d1ef40e', '餐饮主管', '018', '18', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:11', null);
INSERT INTO `upms_role` VALUES ('92698e36b4bd4ccca1592312d43c5e71', '综合主管', '005', '5', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:56', null);
INSERT INTO `upms_role` VALUES ('94a2a009dd394b50a16b577d3111f0c9', '直营财务主管', '014', '14', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:08', null);
INSERT INTO `upms_role` VALUES ('9577ad3cce4540ae90855b788b8d758e', '业务员', '010', '10', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('961277a9cc91495aa7d4a57d2cfad986', '账务人员', '020', '20', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:36', null);
INSERT INTO `upms_role` VALUES ('9632962315eb4667ab78b6bf609dfbcc', '餐饮财务主管', '019', '19', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:08', null);
INSERT INTO `upms_role` VALUES ('968c4572ef044931b34e73783946902c', '商超主管', '016', '16', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:10', null);
INSERT INTO `upms_role` VALUES ('96eb75e4f93340558bdaec09d4c1c69c', '账务人员', '020', '20', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:16', null);
INSERT INTO `upms_role` VALUES ('9732e25540d74bfe8c88c7c287361a58', '综合主管', '005', '5', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:16', null);
INSERT INTO `upms_role` VALUES ('984051387afb4cb2890d014110b97931', '账务人员', '020', '20', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:07', null);
INSERT INTO `upms_role` VALUES ('98cf8457fdbf428da796bebf66aa4130', '账务人员', '020', '20', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:17', null);
INSERT INTO `upms_role` VALUES ('98f3f3d2870448fd8d502484b8e8e8a0', '综合库管', '008', '8', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:32', null);
INSERT INTO `upms_role` VALUES ('998aba184fa94776bea8ce10025e77fd', '综合主管', '005', '5', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:41', null);
INSERT INTO `upms_role` VALUES ('99e504aea0984e57835f1b074ec9c11f', '账务人员', '020', '20', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:41', null);
INSERT INTO `upms_role` VALUES ('9a3a1ef1357849b193bd5de2b9142d4c', '直营财务主管', '014', '14', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:08', null);
INSERT INTO `upms_role` VALUES ('9cee575da6fe462097b834c2cacb502a', '直营经理', '012', '12', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:38', null);
INSERT INTO `upms_role` VALUES ('9e7c249ef7be46d2b3e3a0d3af2bc0cf', '直营财务主管', '014', '14', null, '0', '001', '2017-11-29 11:58:18', '2017-11-29 12:48:04');
INSERT INTO `upms_role` VALUES ('9edf1d2fd7ec4a51bd345f4544e0a8eb', '直营经理', '012', '12', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:51', null);
INSERT INTO `upms_role` VALUES ('9ee8cf0c25e142079c8b2542f001269b', '主管', '006', '6', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:55', null);
INSERT INTO `upms_role` VALUES ('9ef8d89ccd0d4ec8a90d49d39bb89ff1', '库管', '009', '9', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:54', null);
INSERT INTO `upms_role` VALUES ('9f42d562bb304657902ceb04a48fafce', '综合库管', '008', '8', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:27', null);
INSERT INTO `upms_role` VALUES ('9fa88e6da6fb44b6b346675d091d16dc', '账务人员', '020', '20', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:35', null);
INSERT INTO `upms_role` VALUES ('9fab63eafe724de58695d4562f5e3db5', '餐饮主管', '018', '18', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:22', null);
INSERT INTO `upms_role` VALUES ('a0b7ab54d08d44e4a8a52a81d6b7537f', '直营主管', '013', '13', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:37', null);
INSERT INTO `upms_role` VALUES ('a155fd98e85a42978df1f4c6549820a1', '直营商管理员', '003', '3', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:32', null);
INSERT INTO `upms_role` VALUES ('a17b46688c5f473d8d31681ad6f1c80e', '直营主管', '013', '13', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:16', null);
INSERT INTO `upms_role` VALUES ('a1bfa2e589144a118aa9a0e80f1e7730', '直营经理', '012', '12', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:37', null);
INSERT INTO `upms_role` VALUES ('a31a397fbc21417e9186e63d1cfddef1', '主管', '006', '6', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('a4109d673b564aa4bc17d124f3703857', '财务主管', '007', '7', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('a47800bdf96840498e1ce72501886206', '业务员', '010', '10', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:41', null);
INSERT INTO `upms_role` VALUES ('a4af67fc28104048930eb98c02aad8f4', '直营商管理员', '003', '3', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:34', null);
INSERT INTO `upms_role` VALUES ('a584ec9a3bdf4842b8b0ed5ed85f34ca', '业务员', '010', '10', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:18', null);
INSERT INTO `upms_role` VALUES ('a62f3926c9a24d70b80e76e09d0f5212', '综合主管', '005', '5', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:43', null);
INSERT INTO `upms_role` VALUES ('a754d112196947689c5e12d85a511397', '账务人员', '020', '20', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:15', null);
INSERT INTO `upms_role` VALUES ('a9d9813da91643dcb341d0742afd48d3', '综合库管', '008', '8', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:36', null);
INSERT INTO `upms_role` VALUES ('aa4e334834bd43a9815a740d82d5e9f6', '直营财务主管', '014', '14', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('aaaacf21913e48949bbb7b4adab2fb2c', '商超财务主管', '017', '17', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:58', null);
INSERT INTO `upms_role` VALUES ('abaca15bc7634155adc82f893a7e1d96', '业务员', '010', '10', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:18', null);
INSERT INTO `upms_role` VALUES ('abb5f994199e4c9a975c8e29dd3b91ce', '餐饮财务主管', '019', '19', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:33', null);
INSERT INTO `upms_role` VALUES ('acf0873cfbba4f6096409554356e1111', '库管', '009', '9', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:52', null);
INSERT INTO `upms_role` VALUES ('ad65fd958eb641e2bb64abb7b91c64fd', '财务主管', '007', '7', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:57', null);
INSERT INTO `upms_role` VALUES ('adc1aaa7b37741e8b636452fb4698f92', '直营财务主管', '014', '14', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:16', null);
INSERT INTO `upms_role` VALUES ('ae4d1db13db44255b4831ea59557e9c0', '综合库管', '008', '8', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:51', null);
INSERT INTO `upms_role` VALUES ('ae4d4d828f484b0a96d855a75cdf20ab', '财务主管', '007', '7', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:16', null);
INSERT INTO `upms_role` VALUES ('af08e09a9e58427fa94146ba080eb4c3', '直营经理', '012', '12', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:55', null);
INSERT INTO `upms_role` VALUES ('af837f257e3248ce98fe3bf053fff020', '综合主管', '005', '5', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:46', null);
INSERT INTO `upms_role` VALUES ('b07498240ab449c8ba65198d0be0405d', '直营总监', '011', '11', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:29', null);
INSERT INTO `upms_role` VALUES ('b0e3a25c9f8d473884174a54cbb4de77', '主管', '006', '6', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:23', null);
INSERT INTO `upms_role` VALUES ('b12b5dcc5f204f5e91fac7e42ac6246b', '商超主管', '016', '16', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:12', null);
INSERT INTO `upms_role` VALUES ('b15452ea99df49efb7cd53d876fc1ab7', '业务员', '010', '10', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:25', null);
INSERT INTO `upms_role` VALUES ('b2378589ade04fd2b372d19371136126', '直营总监', '011', '11', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:49', null);
INSERT INTO `upms_role` VALUES ('b430796ddbce43e3a8882ab83abf2fb8', '餐饮主管', '018', '18', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('b433df6f914544e9b8b2c2ee8a3d8eec', '餐饮财务主管', '019', '19', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:32', null);
INSERT INTO `upms_role` VALUES ('b4660eb58aea41a3aed39cedcbe6cd72', '餐饮财务主管', '019', '19', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:58', null);
INSERT INTO `upms_role` VALUES ('b48deaaae5174b49888495947b955063', '商超财务主管', '017', '17', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:21', null);
INSERT INTO `upms_role` VALUES ('b4c84c66180642f09ea47b5202b7f826', '直营商管理员', '003', '3', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:44', null);
INSERT INTO `upms_role` VALUES ('b60288a6270a4a0da27fc3550e5370ae', '直营财务主管', '014', '14', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:15', null);
INSERT INTO `upms_role` VALUES ('b6e7b0677af044609aacf739703c187d', '业务员', '010', '10', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:57', null);
INSERT INTO `upms_role` VALUES ('b815da5f06954f5cad2b378392677258', '账务人员', '020', '20', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:46:24', null);
INSERT INTO `upms_role` VALUES ('b8cac670da294584945f34d7dc4d0499', '业务员', '010', '10', null, '0', '001', '2017-10-23 15:26:24', '2017-11-29 12:47:19');
INSERT INTO `upms_role` VALUES ('b960025c31f14b73ad09767cc1a3e3b3', '业务员', '010', '10', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:18', null);
INSERT INTO `upms_role` VALUES ('b9aaba2d66c04e6cb0b22d52d2ec58a1', '直营商管理员', '003', '3', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:27', null);
INSERT INTO `upms_role` VALUES ('b9fd52aee87e4e889f5d6e7f53333c1f', '餐饮财务主管', '019', '19', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:51', null);
INSERT INTO `upms_role` VALUES ('bb43769184f14beca4c724beddd9d15c', '商超经理', '015', '15', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:52', null);
INSERT INTO `upms_role` VALUES ('bc22deb2ac2f420781117102ccc5cb7f', '商超经理', '015', '15', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:56', null);
INSERT INTO `upms_role` VALUES ('bc641712dcb7435e9b1403c0a91d23a5', '财务主管', '007', '7', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:52', null);
INSERT INTO `upms_role` VALUES ('bcd1363af12e4ee49c00726ab60d54d3', '主管', '006', '6', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:18', null);
INSERT INTO `upms_role` VALUES ('bed005c70c854317a9c07f36d825eb4c', '主管', '006', '6', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:56', null);
INSERT INTO `upms_role` VALUES ('bf28e38b169e4f5695824e54a7b28726', '库管', '009', '9', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:04', null);
INSERT INTO `upms_role` VALUES ('bf8ab03ed46447a28cafb29b932f4ce1', '直营财务主管', '014', '14', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('bfa3fc137b534b3b81f4fe623d13fced', '账务人员', '020', '20', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:17', null);
INSERT INTO `upms_role` VALUES ('bfa862869cff4317bdbd21edd46e741c', '商超主管', '016', '16', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:36', null);
INSERT INTO `upms_role` VALUES ('bfba279bee714e569dae0527538e3fd3', '商超财务主管', '017', '17', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:52', null);
INSERT INTO `upms_role` VALUES ('bfc0d53238a94c7b92ca17d083e617fc', '餐饮主管', '018', '18', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:17', null);
INSERT INTO `upms_role` VALUES ('bff1c3a9d4ff43b1af04bdae8b92fc32', '经销商管理员', '002', '2', null, '0', '001', '2017-11-01 09:42:42', '2017-11-29 11:54:57');
INSERT INTO `upms_role` VALUES ('c02c8e7e2e90445188d8fd0b7bacaca1', '综合库管', '008', '8', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:52', null);
INSERT INTO `upms_role` VALUES ('c04595e9efef406f8a6ea25a8bbeeea6', '账务人员', '020', '20', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:40', null);
INSERT INTO `upms_role` VALUES ('c116cc01a2e3403c9ab5f9d4a8161895', '直营主管', '013', '13', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:25', null);
INSERT INTO `upms_role` VALUES ('c14e3293bee74c7084f45be0956ef9d1', '主管', '006', '6', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:45', null);
INSERT INTO `upms_role` VALUES ('c1a9aec88f2444f0a69e3ea0c812f074', '直营总监', '011', '11', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:14', null);
INSERT INTO `upms_role` VALUES ('c2110449aeb04426807c8f47be3430d1', '经销商老总', '004', '4', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:36', null);
INSERT INTO `upms_role` VALUES ('c215f51f08734f9ba9165a40b3bcb19c', '餐饮主管', '018', '18', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:42', null);
INSERT INTO `upms_role` VALUES ('c22dce38019a43488da8393980675121', '商超经理', '015', '15', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:39', null);
INSERT INTO `upms_role` VALUES ('c27e7912bfdd4179b17d1b002a44d5ac', '直营商管理员', '003', '3', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:47', null);
INSERT INTO `upms_role` VALUES ('c2d2c077e0264ea29c7e265f148da155', '税务人员', '021', '21', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2018-03-05 15:18:38', null);
INSERT INTO `upms_role` VALUES ('c2d70cbd27d342ce90c88874beabaa98', '经销商管理员', '002', '2', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:30', null);
INSERT INTO `upms_role` VALUES ('c3b0f5e7f99546169ca7ccbc21d1ff45', '餐饮主管', '018', '18', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:38', null);
INSERT INTO `upms_role` VALUES ('c3eb4f903f27421d860eead52b7c518d', '餐饮主管', '018', '18', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:54', null);
INSERT INTO `upms_role` VALUES ('c42c093f483346fc94d64298dba1ce9c', '直营总监', '011', '11', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_role` VALUES ('c5004148d2284b969e94d93fb9911569', '综合主管', '005', '5', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:10', null);
INSERT INTO `upms_role` VALUES ('c5e1f7e2588a4df38e0d6350d64bcede', '账务人员', '020', '20', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:08', null);
INSERT INTO `upms_role` VALUES ('c63e24aa533a4f219fb0376d128c667b', '经销商管理员', '002', '2', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:46:08', null);
INSERT INTO `upms_role` VALUES ('c64bbd9b732b4aef822a799c2f0c64e2', '直营主管', '013', '13', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('c7dec3d37f40481381c9315822eac98e', '商超财务主管', '017', '17', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:25', null);
INSERT INTO `upms_role` VALUES ('c872e8d5394a4cef8958a99ca473a728', '直营财务主管', '014', '14', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '001002001001', '2018-01-03 17:02:55', null);
INSERT INTO `upms_role` VALUES ('c8dd30ea2da84213b76b3cbcbc7e367d', '综合主管', '005', '5', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:57:58', null);
INSERT INTO `upms_role` VALUES ('c942b45b361f429995fbbbfac7255fd9', '系统管理员', '001', '1', null, '0', '001', '2017-10-23 15:12:27', null);
INSERT INTO `upms_role` VALUES ('caa3d909fcea461c9eb3c5f0c6361eeb', '餐饮主管', '018', '18', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:44', null);
INSERT INTO `upms_role` VALUES ('cacd88d3948a452fab3c90d80f287f05', '账务人员', '020', '20', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:24', null);
INSERT INTO `upms_role` VALUES ('cc3606fe5e0e434d83d3d1d4142596cb', '直营财务主管', '014', '14', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:45:56', null);
INSERT INTO `upms_role` VALUES ('cfd2c8152c6e4457a03b9c5f05c4a717', '账务人员', '020', '20', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:51', null);
INSERT INTO `upms_role` VALUES ('d11bd69b51ac4a85998d21d8aaa73b60', '财务主管', '007', '7', null, '0', '001', '2017-10-23 15:27:37', '2017-11-29 12:46:37');
INSERT INTO `upms_role` VALUES ('d16f33d9f8ba4ceda4c3c7c90a185a71', '主管', '006', '6', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('d19e3095ddd54a9288d7d3d885bb6860', '账务人员', '020', '20', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:17', null);
INSERT INTO `upms_role` VALUES ('d2b97b5e171f4e47bd85f5c254e73b4e', '直营经理', '012', '12', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:18', null);
INSERT INTO `upms_role` VALUES ('d4e94833f9514b0e994f03e6398e7bb7', '直营总监', '011', '11', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:04', null);
INSERT INTO `upms_role` VALUES ('d55533c0b08d4a2ca9244eb5652da8a6', '经销商老总', '004', '4', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:05', null);
INSERT INTO `upms_role` VALUES ('d5f2532cc6654573b1615fd81ee6222f', '商超财务主管', '017', '17', null, '0', '001', '2017-11-29 12:06:46', null);
INSERT INTO `upms_role` VALUES ('d6eb88027fe84a1695e89825e62fd270', '直营财务主管', '014', '14', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:40', null);
INSERT INTO `upms_role` VALUES ('d72fe1848f404d939a5ba50e50546f07', '综合库管', '008', '8', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:07', null);
INSERT INTO `upms_role` VALUES ('d78e109415544a498ff4485d734c7238', '餐饮财务主管', '019', '19', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('d821f13e58f34c00b7c35afeee1354fa', '综合主管', '005', '5', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:09', null);
INSERT INTO `upms_role` VALUES ('d8be4deb4865470193ef5278e8150dd3', '直营总监', '011', '11', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('d9ea56b5778b4649a6bc5cb4f5688c63', '直营经理', '012', '12', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:27', null);
INSERT INTO `upms_role` VALUES ('d9f05f50f0354a22b0c56cebf9fb55f7', '商超经理', '015', '15', null, '0cfed11947ee49a7b04a077c4df303ec', '001001001005', '2018-01-19 22:46:17', null);
INSERT INTO `upms_role` VALUES ('da0b719c828f49faba044b1e366eae67', '主管', '006', '6', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:29', null);
INSERT INTO `upms_role` VALUES ('db1b857d27094b418d9f33ef79c02c51', '主管', '006', '6', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:42', null);
INSERT INTO `upms_role` VALUES ('db3db74e582d4108ba5a16b560fe2b3d', '经销商管理员', '002', '2', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:40', null);
INSERT INTO `upms_role` VALUES ('dc083c75a5044a6fb9949d1009df67a2', '餐饮主管', '018', '18', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:55', null);
INSERT INTO `upms_role` VALUES ('dc851bab3f5d4a72991f43075f896d79', '直营经理', '012', '12', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:15', null);
INSERT INTO `upms_role` VALUES ('dcb6a1984b784383b695b10bc9aa64f1', '库管', '009', '9', null, 'b24ce300dc084cccb39236e323e5a22c', '001004', '2018-01-29 11:01:15', null);
INSERT INTO `upms_role` VALUES ('df8ce25532444b3794e08970b20d8ad8', '业务员', '010', '10', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:15', null);
INSERT INTO `upms_role` VALUES ('dffa612351e84fb59a2c199bb92b1a8e', '餐饮财务主管', '019', '19', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:13', null);
INSERT INTO `upms_role` VALUES ('e085d79053694c25a92d07b793cb9747', '账务人员', '020', '20', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:39', null);
INSERT INTO `upms_role` VALUES ('e0cbb06020714de388a8f7efdadabda6', '商超经理', '015', '15', null, '022231caec2a438a8c522d5f538c74f6', '001001007', '2018-01-20 21:12:38', null);
INSERT INTO `upms_role` VALUES ('e1635d338d474316b898abf8cef9f4ab', '餐饮财务主管', '019', '19', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_role` VALUES ('e236ace4b5f64333952aecf35a8d91e6', '综合主管', '005', '5', null, 'c8aa1bec61284aa98373e0c0383ac141', '001004001', '2018-01-29 11:14:15', null);
INSERT INTO `upms_role` VALUES ('e28d8287aa984e54884f0ede7b00dc12', '直营总监', '011', '11', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:03', null);
INSERT INTO `upms_role` VALUES ('e3c2cd4b1b3041c69898ecfeea040ac2', '商超主管', '016', '16', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:48', null);
INSERT INTO `upms_role` VALUES ('e4993b77194e425db3804784b3d748cd', '直营总监', '011', '11', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:12', null);
INSERT INTO `upms_role` VALUES ('e54715e3187c41f0bf5bebb54b29fc0d', '综合主管', '005', '5', null, '0', '001', '2017-11-29 12:03:07', '2017-11-29 12:09:51');
INSERT INTO `upms_role` VALUES ('e584d7c1e0324704a9b6a07f115cd339', '直营财务主管', '014', '14', null, 'c11e5f292b5e42a4a54e556f78aed193', '001003001002', '2018-01-16 17:51:08', null);
INSERT INTO `upms_role` VALUES ('e68dd52fe8114c4e866e62689a84f9d0', '商超财务主管', '017', '17', null, 'e4c967ce5ed241cdb3a7725c42963374', '001002001002', '2018-01-03 17:04:54', null);
INSERT INTO `upms_role` VALUES ('e6b911e5dcd0482d847738905aa3c511', '财务主管', '007', '7', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:36', null);
INSERT INTO `upms_role` VALUES ('e6d9ad65e7ad448e904871465c377022', '餐饮主管', '018', '18', null, '0', '001', '2017-11-29 12:07:14', null);
INSERT INTO `upms_role` VALUES ('e768090f89e64b86b0846903874aa9d9', '直营主管', '013', '13', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:50', null);
INSERT INTO `upms_role` VALUES ('e7ebf6b99f36479394fdf5f1faeeee90', '直营主管', '013', '13', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:06', null);
INSERT INTO `upms_role` VALUES ('e93580a699ec448aa1ac9b76eba9bb0a', '直营主管', '013', '13', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:14', null);
INSERT INTO `upms_role` VALUES ('ea34b6a2059243fa875e51e1c57e3fb4', '账务人员', '020', '20', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:55', null);
INSERT INTO `upms_role` VALUES ('ece2d1ffed4841469d63a59aedbded89', '直营商管理员', '003', '3', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-15 11:54:05', null);
INSERT INTO `upms_role` VALUES ('ef5a1cd8625f4b41888444d1b2388aa2', '主管', '006', '6', null, '0', '001', '2017-11-29 12:03:18', '2017-11-29 12:46:29');
INSERT INTO `upms_role` VALUES ('f275b1f8788043eb9f61fb34470a46aa', '经销商老总', '004', '4', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:05', null);
INSERT INTO `upms_role` VALUES ('f2cf7c1524074b9381788e00c6485e61', '业务员', '010', '10', null, 'f0f793bf4bfc47719cb8176879961603', '001001006', '2017-12-23 22:28:40', null);
INSERT INTO `upms_role` VALUES ('f3bbdc7342794f12b90951755c8f0f9c', '直营经理', '012', '12', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:15', null);
INSERT INTO `upms_role` VALUES ('f3f4f48dcf6a415298af8e61adcba573', '库管', '009', '9', null, 'c8b8aa836e194c95a5942a36b166af3f', '001001002', '2017-12-15 11:54:54', null);
INSERT INTO `upms_role` VALUES ('f412b707f9ab432e8ee90d3d78bf7741', '直营商管理员', '003', '3', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:13:59', null);
INSERT INTO `upms_role` VALUES ('f52491f18bbe409c97e8d3e23cdf6714', '直营经理', '012', '12', null, '55e62aacfa0d459e8a1e75aaba973db4', '001003001', '2018-01-16 17:49:13', null);
INSERT INTO `upms_role` VALUES ('f5ac87f0109543f8a596cba5d7ed7a1b', '综合库管', '008', '8', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '001002', '2018-01-16 16:36:37', null);
INSERT INTO `upms_role` VALUES ('f5d3bfcc92c3465f9bcab876267ff0bc', '直营财务主管', '014', '14', null, '9769e1c4bd2a4d53b4673baafb6f9916', '001001004001', '2018-01-03 10:26:51', null);
INSERT INTO `upms_role` VALUES ('f6e14fb7f410402cb9659fb11940ffba', '综合库管', '008', '8', null, '2b2329fdef784808a7dccd9ff2de60fb', '001003001001', '2018-01-16 17:50:13', null);
INSERT INTO `upms_role` VALUES ('f97bd669c51e47cdb5447df67a1cdc0f', '商超经理', '015', '15', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '001001007002', '2018-01-20 21:46:30', null);
INSERT INTO `upms_role` VALUES ('f9f2f16236c34e5798993116af3b5d73', '主管', '006', '6', null, '63e0f0764b9541ec9d3415f3f2658114', '001002001', '2018-01-03 16:58:00', null);
INSERT INTO `upms_role` VALUES ('fac5151f4eaf4576be4bc5a48a6636bf', '商超经理', '015', '15', null, 'c913f77079824f26985441eb10fe23e3', '001001005', '2017-12-22 19:14:07', null);
INSERT INTO `upms_role` VALUES ('fb67028859974ccfa26a71a4035a13cf', '业务员', '010', '10', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '001001004', '2017-12-20 21:07:36', null);
INSERT INTO `upms_role` VALUES ('fc38a9fcfddf43f8acbf023d219e677b', '餐饮主管', '018', '18', null, 'e4cf1da399f748069d30030ac124f1ae', '001004003', '2018-01-29 11:16:36', null);
INSERT INTO `upms_role` VALUES ('fe4d1450eb754176a131ac2212027c9c', '经销商老总', '004', '4', null, 'e07acca2e03245698ca66cf1575dce19', '001004002', '2018-01-29 11:15:23', null);

-- ----------------------------
-- Table structure for upms_role_operation_rel
-- ----------------------------
DROP TABLE IF EXISTS `upms_role_operation_rel`;
CREATE TABLE `upms_role_operation_rel` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `operation_id` varchar(32) NOT NULL COMMENT '功能ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`),
  KEY `_operation_id` (`operation_id`),
  KEY `_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表与资源关联表';

-- ----------------------------
-- Table structure for upms_station
-- ----------------------------
DROP TABLE IF EXISTS `upms_station`;
CREATE TABLE `upms_station` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `station_name` varchar(30) NOT NULL COMMENT '岗位名称',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '上级岗位ID',
  `is_parent` smallint(1) DEFAULT NULL COMMENT '是否上级节点',
  `order_list` int(11) DEFAULT NULL COMMENT '排序',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '对应cc_department表，机构ID',
  `data_area` varchar(200) DEFAULT NULL COMMENT '数据域',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_data_area` (`data_area`),
  KEY `_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位表';

-- ----------------------------
-- Records of upms_station
-- ----------------------------
INSERT INTO `upms_station` VALUES ('0', 'root', null, '1', null, null, '0', '001', null, null);
INSERT INTO `upms_station` VALUES ('861eb12a60db4a47a826473c68a4c01b', '总监', '0', '0', '1', null, 'e58667e0601b46ed8a2868546954c407', '001001001', '2017-12-18 20:20:09', null);

-- ----------------------------
-- Table structure for upms_station_operation_rel
-- ----------------------------
DROP TABLE IF EXISTS `upms_station_operation_rel`;
CREATE TABLE `upms_station_operation_rel` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `station_id` varchar(32) DEFAULT NULL COMMENT '岗位ID',
  `operation_id` varchar(32) DEFAULT NULL COMMENT '功能ID',
  PRIMARY KEY (`id`),
  KEY `_operation_id` (`operation_id`),
  KEY `_station_id` (`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='岗位表与功能关联表';

-- ----------------------------
-- Records of upms_station_operation_rel
-- ----------------------------

-- ----------------------------
-- Table structure for upms_system_log
-- ----------------------------
DROP TABLE IF EXISTS `upms_system_log`;
CREATE TABLE `upms_system_log` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `start_date` datetime DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `action_start_date` datetime DEFAULT NULL COMMENT 'action开始时间',
  `action_end_date` datetime DEFAULT NULL COMMENT 'action结束时间',
  `action_cost_time` int(11) DEFAULT NULL COMMENT 'action耗时',
  `view_cost_time` int(11) DEFAULT NULL COMMENT '视图耗时',
  `total_cost_time` int(11) DEFAULT NULL COMMENT '总耗时',
  `cause` varchar(30) DEFAULT NULL COMMENT 'cause',
  `cookie` text COMMENT 'cookie',
  `description` text COMMENT '描述',
  `ip` varchar(30) DEFAULT NULL COMMENT 'IP',
  `method` varchar(22) DEFAULT NULL COMMENT '请求方法类型',
  `referer` text COMMENT 'referer',
  `request_path` text COMMENT '请求路径',
  `status` smallint(1) DEFAULT NULL COMMENT '状态',
  `user_agent` varchar(1000) DEFAULT NULL COMMENT 'userAgent',
  `operation_id` varchar(32) DEFAULT NULL COMMENT '功能ID',
  `accept` varchar(200) DEFAULT NULL COMMENT 'accept',
  `accept_encoding` varchar(200) DEFAULT NULL COMMENT 'acceptEncoding',
  `accept_lang` varchar(200) DEFAULT NULL COMMENT 'acceptLang',
  `connection` varchar(200) DEFAULT NULL COMMENT 'connection',
  `host` varchar(200) DEFAULT NULL COMMENT 'host',
  `xrequestedwith` varchar(200) DEFAULT NULL COMMENT 'xrequestedwith',
  `pvids` varchar(32) DEFAULT NULL COMMENT 'pvids',
  `user_id` varchar(32) DEFAULT NULL COMMENT '操作人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_start_date` (`start_date`),
  KEY `create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统操作日志表';

-- ----------------------------
-- Table structure for upms_systems
-- ----------------------------
DROP TABLE IF EXISTS `upms_systems`;
CREATE TABLE `upms_systems` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `name` varchar(30) NOT NULL COMMENT '系统名称',
  `code` varchar(22) NOT NULL COMMENT '系统编号',
  `version` varchar(30) DEFAULT NULL COMMENT '版本号',
  `order_list` int(11) DEFAULT NULL COMMENT '排序',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统表';

-- ----------------------------
-- Records of upms_systems
-- ----------------------------
INSERT INTO `upms_systems` VALUES ('032bf3b5dc254458bd48c56a34e9159f', '订单系统', 'order_System', '1.0', '1', null, '2017-10-23 15:31:05', '2017-10-23 15:33:33');
INSERT INTO `upms_systems` VALUES ('3ce2822d774d4dc594b49ead70692f44', '客户拜访系统', 'visit_System', '1.0', '4', null, '2017-10-23 15:33:12', null);
INSERT INTO `upms_systems` VALUES ('3d463ee4591449999e165f721b2d30f8', '用户系统', 'user_System', '1.0', '2', null, '2017-10-23 15:31:30', '2017-10-23 15:33:25');
INSERT INTO `upms_systems` VALUES ('733a121c24e44945bbdfaa707f938662', '后台管理系统', 'admin_system', '1.0', '7', null, '2017-10-31 17:11:09', '2017-10-31 17:11:25');
INSERT INTO `upms_systems` VALUES ('7d6e2e2ae7364e27bdcd72cdd5c0b429', '调研系统', 'survey_System', '1.0', '6', null, '2017-10-23 17:25:58', '2017-10-23 17:26:03');
INSERT INTO `upms_systems` VALUES ('9a45bd0bf4634c09973accc99ed9f0e1', '售后系统', 'service_System', '1.0', '5', null, '2017-10-23 15:34:53', '2017-10-23 15:35:01');
INSERT INTO `upms_systems` VALUES ('c820c8cce118480fb89bdc0a0f49658e', '终端投入系统', 'activity_System', '1.0', '3', null, '2017-10-23 15:32:23', '2017-10-23 15:33:19');

-- ----------------------------
-- Table structure for upms_user
-- ----------------------------
DROP TABLE IF EXISTS `upms_user`;
CREATE TABLE `upms_user` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `username` varchar(22) NOT NULL COMMENT '用户名',
  `realname` varchar(30) DEFAULT NULL COMMENT '真实名称',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `mobile` varchar(30) DEFAULT NULL COMMENT '手机',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `avatar` varchar(200) DEFAULT NULL COMMENT '用户图像',
  `salt` varchar(200) DEFAULT NULL COMMENT '密钥',
  `status` smallint(1) DEFAULT NULL COMMENT '状态 0停用 1启用',
  `unable_date` datetime DEFAULT NULL COMMENT '账号停用时间',
  `department_id` varchar(32) DEFAULT NULL COMMENT '部门ID',
  `department_name` varchar(30) DEFAULT NULL COMMENT '部门名称',
  `station_id` text COMMENT '岗位ID',
  `station_name` text COMMENT '岗位名称',
  `group_id` varchar(32) DEFAULT NULL COMMENT '用户组ID',
  `group_name` varchar(30) DEFAULT NULL COMMENT '用户组名称',
  `dept_ids` text COMMENT '行级过滤部门ID',
  `dept_names` text COMMENT '行级过滤部门名称',
  `user_ids` text COMMENT '行级过滤部门名称',
  `user_names` text COMMENT '行级过滤用户名称',
  `province` varchar(80) DEFAULT NULL COMMENT '省',
  `city` varchar(80) DEFAULT NULL COMMENT '市',
  `region` varchar(80) DEFAULT NULL COMMENT '业务员负责区域',
  `data_area` varchar(255) DEFAULT NULL COMMENT '数据域',
  `wechat_open_id` varchar(32) DEFAULT NULL COMMENT '微信openid',
  `wechat_userid` varchar(32) DEFAULT NULL COMMENT '微信用户userid',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `_data_area` (`data_area`),
  KEY `_mobile` (`mobile`),
  KEY `_username` (`username`),
  KEY `_wechat_open_id` (`wechat_open_id`),
  KEY `_wechat_userid` (`wechat_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of upms_user
-- ----------------------------
INSERT INTO `upms_user` VALUES ('0', 'admin', '管理员', 'administrator', '18700000000', '8b276c6430bc6cfec325a09dc6713167', null, '66432cd44c4abf25202aca49a5e14436', '1', null, '0', '总部', '', '', 'ae86c63f79894070906d1cd5a0142912', '系统管理员', null, null, null, null, null, null, null, '0010d3b', null, null, null, '2017-12-11 11:04:30');
INSERT INTO `upms_user` VALUES ('005f2018e58e419fb3471b42b4917e42', 'tgadmin', '腾谷管理员', null, '18392938299', '6295243137e46041c0f981506b11e7b5ebb8b510f5a47e5b2fa4a205ba69c97b', null, '3543538e977734a51d8eb2', '1', null, '99e2904e45124b6597697d9eb41b3ed3', '腾谷', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '00100100100200100275a2', null, null, '2017-12-15 14:37:35', null);
INSERT INTO `upms_user` VALUES ('02b537aeaf6a44b8a407c5fed0a1cf01', 'fhl', '房红林（餐饮部经理）', null, '13800800103', 'a4293c3ae9dc5a4601380317bc0a8a7796bd67312c4f94619beab3463977725b', null, '2b8a8d29a39f0aa00c', '1', null, '9dd2c516204b48b1b400fe54cf18743a', '餐饮部', '', '', null, '经理', null, null, null, null, null, null, null, '001001001001001e592', null, null, '2017-12-15 12:00:59', '2017-12-15 12:13:09');
INSERT INTO `upms_user` VALUES ('05e218df692e42c3802fb06372bbe8a4', 'qgbadmin', '启光管理员（白酒）', null, '13800809999', 'a02371e161c89b366d7b5d46f02d9307832eb8a193e879a0ce5e68e0979178d5', null, 'dec218a550c6625', '1', null, 'c8b8aa836e194c95a5942a36b166af3f', '启光商贸（白酒）', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001001002ad13', null, null, '2017-12-15 11:56:23', '2018-02-06 17:32:19');
INSERT INTO `upms_user` VALUES ('0e3e986405644e9fb22d08eb2aabb7c3', 'qdyuser50', '鬼谷子', null, '13128904335', '70267c80e546d113a71ce8cfb1697ce0e14a66fd63f09da2084f15f2c8a1a312', null, '4ef6a29836e39feca69b', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '业务员', null, null, null, null, '', ' ', ' ', '001001001001a39b', null, null, '2017-12-29 15:23:55', null);
INSERT INTO `upms_user` VALUES ('0e5d9e0d79464ff58e90a6ef7a50804f', 'qdyuser51', '女娲', null, '13128904336', '20b25386ab481b1d380e72a32a6082c7ab521a18b31b12f84032c5e387c4ae14', null, '9b7a14f790e3b', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '业务员', null, null, null, null, '湖北省', '武汉市', '洪山区', '001001001001172b', null, null, '2017-12-29 15:23:55', null);
INSERT INTO `upms_user` VALUES ('11111', 'test', '管理员', 'administrator', '18700000001', '8b276c6430bc6cfec325a09dc6713167', '', '66432cd44c4abf25202aca49a5e14436', '1', '2018-03-09 14:36:41', '0', '总部', '', '', 'ae86c63f79894070906d1cd5a0142912', '系统管理员', '', '', '', '', '', '', '', '0010d3b', '', '', '2018-03-09 14:36:59', '2017-12-11 11:04:30');
INSERT INTO `upms_user` VALUES ('1223d8d7f1a24a50afc4bd846859e28e', 'qdyuser45', '貂蝉', null, '13128904330', '257710e6f787d6d680e79d7d299a929d413491e16126efeca49d4ce9be4979f4', null, 'a9589214ec7f300a0c0', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '业务员', null, null, null, null, '湖北省', '武汉市', '江岸区', '001001001001b9eb', null, null, '2017-12-29 15:23:54', null);
INSERT INTO `upms_user` VALUES ('1252028deff7434dbd77cc91bff8dff2', 'wr', '吴锐（财务）', null, '15785515151', 'fdef1a5b0b67ae8820999ec1dd9f84e04127b4df496b896cd094e15325ca237c', null, '6cd981cdb055bc180dd', '1', null, 'e58667e0601b46ed8a2868546954c407', '启光商贸（劲酒）', '', '', null, '财务主管', null, null, null, null, null, null, null, '0010010019d08', null, null, '2017-12-15 19:49:26', '2017-12-27 15:32:28');
INSERT INTO `upms_user` VALUES ('1398151304bc45fb818ee17c482a78d5', 'lqmp', '龙泉总部管理员', null, '13971145685', 'c71529b63a5f0cd7aaf69763a976b8b06adbb49318001669c779b34fd87b10fb', null, '43d68e0dc5bd89fc0eb7', '1', null, '63e0f0764b9541ec9d3415f3f2658114', '广州龙泉', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '0010020010da5', null, null, '2018-01-03 17:08:29', null);
INSERT INTO `upms_user` VALUES ('19f914661f5a4cb3a1edb97f1fe4a188', 'qdyuser47', '诸葛亮', null, '13128904332', '05bb8ef3a6d43716b1e2e973be8c08c845c0dfc130193315ee403621d0a4012c', null, 'cf29b70d5ac4462a6ef', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '业务员', null, null, null, null, null, null, null, '001001001001a742', null, null, '2017-12-29 15:23:55', null);
INSERT INTO `upms_user` VALUES ('1d36208a0e904bff85017921d5e4807d', 'srd2', '宋荣第', null, '13800000001', '4e107cfba40677d3e99469407f29cb05405399f86e6304d0166fbf8dc512bc24', null, '0fa0430ba22a9ba82a', '1', null, 'e07acca2e03245698ca66cf1575dce19', '习酒公司（白酒）', '', '', null, '业务员', null, null, null, null, null, null, null, '001004002f65f', null, null, '2018-01-29 11:52:22', null);
INSERT INTO `upms_user` VALUES ('223b14df0536406abeb43d28a253bee7', 'xyl', '夏育玲', null, '13800800115', 'f03994652e086a67a032f1faf4981f52a414bf6787ee4cfd0e2a7b346f098d94', null, 'ea4f277456ba7c6', '1', null, '9dd2c516204b48b1b400fe54cf18743a', '餐饮部', '', '', null, '账务人员', null, null, null, null, null, null, null, '0010010010010019022', null, null, '2017-12-15 13:03:32', null);
INSERT INTO `upms_user` VALUES ('22ead5d7ef8847cdbcaaf1dbaf8d42c9', 'gjadmin', '国酒管理员', '国酒', '13128904328', 'f4427977854fe2ac1506f01d3dec8a1cd7e8916e288ef648adf9fa28a564e543', null, '9ca541f36cd081fa08', '1', null, '022231caec2a438a8c522d5f538c74f6', '国酒', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001001007eb7c', null, null, '2018-01-20 21:14:34', '2018-03-05 17:56:20');
INSERT INTO `upms_user` VALUES ('23783c5d67e541ad8a0de7e929803727', 'mt', '茅台子部门', '茅台子部门', '13587458544', '5e5d1abf115056e771803221bd42c6ea3bb877522c8534ef27db4c67cf564d20', null, 'c70c67c345599', '1', null, '9f71f8a7a0df4c83b9dd8d5ec2c80494', '茅台1', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '00100100700243c7', null, null, '2018-01-20 21:48:13', null);
INSERT INTO `upms_user` VALUES ('2849e2bc51b44d88a7012ec8aad50878', 'zy', '周义', null, '13800800116', '5089a24a83dfb762bb2d369038bd944eb2aa6bceaa42373fa8ba88577b97145f', null, '8ffc8fb016812163', '1', null, '58b2e2cead864497b101f407de25f61f', '清风', '', '', null, '业务员', null, null, null, null, null, null, null, '0010010010020010010683', null, null, '2017-12-15 13:04:13', null);
INSERT INTO `upms_user` VALUES ('2d4392b2fd9341a7a7fdec204cdb3f56', 'hx', '黄鑫', '协同云平台-黄鑫', '18627771043', '08f8a6a49eec6455959fc7819d339f7f650e7b6bd7008bf33bdd7f9085c71759', 'http://wx.qlogo.cn/mmopen/iaiaoS8zHxSIBwylyWF6ksVbkHvqJicVRKa2xzT6by9a08HqSF2K6wI0bYLCYSiclo5ibRGvTtsLgx2pMibEjiazmWicbQ/132', '445f8022c1fb30cb6a10', '1', null, '2b2329fdef784808a7dccd9ff2de60fb', '银泰创意城', '', '', null, '主管,业务员', null, null, null, null, null, null, null, '0010030010018889', 'oaCaowVe_71PxMHYUIAHvJZ9UEao', null, '2018-01-16 17:54:38', '2018-01-16 19:01:05');
INSERT INTO `upms_user` VALUES ('2f414aad02d04441b5c0c589e5190fc1', 'dlf', '丁利芳', null, '13800800114', 'e6f4306a1e8ec1e992373e2a67e7417ca9a804809e4ce6a0af5bb5e480df23b5', null, '808a79124d85759e43', '1', null, '9dd2c516204b48b1b400fe54cf18743a', '餐饮部', '', '', null, '账务人员', null, null, null, null, null, null, null, '0010010010010013a1c', null, null, '2017-12-15 13:03:11', null);
INSERT INTO `upms_user` VALUES ('2fd2addcf013480e9f8f9c65788b2cf5', 'qtfadmin', '荞泰丰管理员', null, '13929899892', 'a77c3bc6229aebe40cfa9f8bbd9484cdab077ee20b14872f848d86c2a0cd2b5b', null, '293cb8d2586ad08a8', '1', null, '17f5ec7d60e043a1a5e1ab4b10bacb73', '咸宁荞泰丰', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '0010010043bb0', null, null, '2017-12-20 21:08:55', null);
INSERT INTO `upms_user` VALUES ('32282144bcc24e2faa11123a1daecceb', 'ytadmin', '银泰管理员', null, '13292398930', 'cf6810b8bdec0132fed786864b932c815f70d69fbc5e20ce6240715a49120d70', null, '607b54caf9307272dd4', '1', null, '2b2329fdef784808a7dccd9ff2de60fb', '银泰创意城', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '0010030010011eaa', null, null, '2018-01-16 17:52:01', '2018-01-16 17:53:46');
INSERT INTO `upms_user` VALUES ('33fb92029a654731981d0709e27a468c', 'xxx', '嘻嘻嘻', null, '13355667788', '7e6a3d838e14b427e10d1f1903e4847fb55fa4984a1ed851cabd48e99f2bada8', null, '454ac6b15b16709df40b6f', '1', null, '4f3c1d1167254d28b5eda6f4d56050b4', '大冶华劲', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001001003daa7', null, null, '2017-12-29 09:10:17', null);
INSERT INTO `upms_user` VALUES ('38cd642b29f145979e36d7c867e26fd7', 'whp', '吴和平（库管）', null, '15785515152', 'c841d481345dbd85934615e807f9e8911a373091bc2bb27423bca48f8cd2d3d9', null, '5c4e20a7fee1f104a35a66', '1', null, 'e58667e0601b46ed8a2868546954c407', '启光商贸（劲酒）', '', '', null, '综合库管', null, null, null, null, null, null, null, '001001001cbff', null, null, '2017-12-15 19:49:46', '2018-01-19 09:30:52');
INSERT INTO `upms_user` VALUES ('40aef31bb35b42b7b9c86ab22061f5a5', 'dbq', '董荸荠', '荸๑荠', '18627771417', 'e63318c9b012f59099cfa66604cd10ad723adbd77e80f2195aeef0d907bcf9fc', 'http://wx.qlogo.cn/mmopen/XU1yiaCib5IY7OEa7UicFsXc5hUSX0ia4Ijico631viaNwqATI7tgk6bfYJQicX48mX1ibpJo2QX9686PCxgWJyMa915NSr4QlXgVycq/132', 'ae57c11fb8bcd799', '1', null, 'c11e5f292b5e42a4a54e556f78aed193', '新世界百货', '', '', null, '业务员', null, null, null, null, null, null, null, '00100300100251e7', 'oaCaowZ57DIp9TM2YN4x4s_2emyA', null, '2018-01-16 18:19:55', '2018-01-16 18:23:14');
INSERT INTO `upms_user` VALUES ('4134d2e51e5844a1abd4bc18ce343e11', 'lqdhx', '稻花香管理员', null, '13971145210', 'db1bab4eba1d7049aaf6444294f6cb6135125caf354d154bea65b0880992db91', null, 'e285a25e05628c', '1', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '广州龙泉(稻花香)', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001002001001f555', null, null, '2018-01-03 17:17:40', '2018-01-03 17:21:26');
INSERT INTO `upms_user` VALUES ('41ed3adf92fa4fb191d6fd32eb6a2a79', 'ww', '魏伟', null, '13800800110', '3432bf17e908d3d724a9e84acc0c24f9b8dadc20b40613418ddcd156788d6fcd', null, 'd6d9a9079bd61', '1', '2018-01-05 17:25:33', '93236e88e61e4d2180536bcb8c835c36', '汪梦龙组', '', '', null, '业务员', null, null, null, null, null, null, null, '00100100100100100175d4', null, null, '2017-12-15 13:01:18', null);
INSERT INTO `upms_user` VALUES ('42710989e88849359e1d4f250b28825b', 'dbq2', '董荸荠', null, '18627771417', '2889d8f0c81a9485426f4a7805c0a2b0d22a078e2c25a92a21f0b72ddc01543e', null, '6c40807a86ea92', '1', null, '29caf0a60730441d8e30955596ad7b4c', '超付批发', '', '', null, '主管', null, null, null, null, null, null, null, '001003001001001001315e', 'oaCaowZ57DIp9TM2YN4x4s_2emyA', null, '2018-01-16 18:23:36', null);
INSERT INTO `upms_user` VALUES ('4661ce25c89f40d19fd0dc194afafd10', 'sss', '宋宋宋', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `upms_user` VALUES ('471961af978f45958e6b9505f1a7019f', 'gh', '郭晖（直营二部经理）', null, '13800800102', 'd2492f8657567550721cc650ce5b0efadd11e254ae0f8e0894ff74dedb9b61cc', null, '60b7d96f969fc6c3c4', '1', null, '55c01e0e61564eba8001f9d5a9df9412', '直营二部', '', '', null, '直营经理', null, null, null, null, null, null, null, '0010010010032f23', null, null, '2017-12-15 12:00:16', '2017-12-15 12:13:03');
INSERT INTO `upms_user` VALUES ('493f3036f291404eb74bf2e534ef7c6d', 'hhl', '韩惠莉', null, '13800800112', 'a89351f96eed26071d34d87b2eb8c0ac8c1b9d3365dc15e6a000d17badf30546', null, 'd3b79ed3d8104b4093', '1', null, '3105528d84654eef89812f26be23e481', '马幸组', '', '', null, '业务员', null, null, null, null, null, null, null, '001001001001001002ca9c', null, null, '2017-12-15 13:02:14', null);
INSERT INTO `upms_user` VALUES ('4dfafefb27404b96bccd4ea8171f7602', 'qdyuser44', '李白', null, '13128904329', '8b8587a7dc811f241070eca5f147ab230f9c31810a78c8f84fe6c9120f6cd6a0', null, '49950412583dd7', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '业务员', null, null, null, null, null, null, null, '001001001001f7bb', null, null, '2017-12-29 15:23:54', null);
INSERT INTO `upms_user` VALUES ('4e8f2e5ef22c460ca4bf7b04da8e8375', 'qdyuser43', '张飞', null, '13128904328', 'c28bc8d3fc63c8c5be25fafed61e4b55e7a72d705cc9ed4ab00941f6878c89c5', null, '26155fe1109113', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '主管', null, null, null, null, null, null, null, '001001001001763e', null, null, '2017-12-29 15:23:54', null);
INSERT INTO `upms_user` VALUES ('579c6981ba194cc2b272caaf2ea0b715', 'dbl', '董碧龙', '荸°荠', '18502799989', 'a013f254a0d6bec64c229401e5a645703a877584468fa85d10e80ad20d84b3c9', 'http://wx.qlogo.cn/mmopen/iaiaoS8zHxSIDxE4UcpsibUNLiamQheCiat1PibvtvczksaBQsDzChymIjKDRXMQlaTtnxiaUicFUsRFicdABicXN7oDnqFg/0', 'd03a6fd236727f9296e', '1', null, '9dd2c516204b48b1b400fe54cf18743a', '餐饮部', '861eb12a60db4a47a826473c68a4c01b', '总监', null, '综合库', null, null, null, null, null, null, null, '0010010010010017e9e', 'oaCaowRBrFsIEOcwBro16chZ0_V0', null, '2017-12-15 17:32:40', '2017-12-25 00:29:20');
INSERT INTO `upms_user` VALUES ('58f5464b47ea4e18bf7834d30a80dc71', 'ymadmin', '咏梅管理员', null, '18548787878', 'a372ddf2cde1048e4227ecf87e9ee0ddb4b83f5b0aa6b5eb0dec18fe1d970c70', null, '870e5353e0099', '1', null, 'b9fc3766e8514c7ab2248cad10ebf60e', '咏梅', '', '', null, '税务人员,直营商管理员', null, null, null, null, null, null, null, '0010010010020040017940', null, null, '2017-12-15 14:18:31', '2018-03-05 18:19:55');
INSERT INTO `upms_user` VALUES ('5b0dc1dcc94f499f9a76090ea9f4cc41', 'yly', '杨里杨', null, '15207141127', 'ed2e318ef7ab8f6462ae9dcf31c7bfdd11b122b94817cf1a6de97db2fb7ce27b', null, '201444827509c80', '1', null, '9dd2c516204b48b1b400fe54cf18743a', '餐饮部', '', '', null, '业务员', null, null, null, null, null, null, null, '001001001001001f5aa', null, null, '2017-12-19 17:18:56', '2018-01-25 14:11:06');
INSERT INTO `upms_user` VALUES ('5d95c12cf70d47eb9190d93085a8ffc9', 'hmx', '黄敏学', null, '18607147300', 'fac4634e1d29db92e6836efb721c5ffb7281c6e8daae0e975aabcdf6db213e0e', null, '425b9bc69f7a82ad8c26', '1', null, '7aee5b9028c541b1afa600db1364991f', '董细美组', '', '', null, '账务人员,餐饮主管,业务员,库管', null, null, null, null, null, null, null, '001001001001002001846f', null, null, '2017-12-16 17:15:43', '2017-12-16 17:16:43');
INSERT INTO `upms_user` VALUES ('5f8ca4bcbb0a4d9c978058056bc1138e', 'hbbj', '白酒', '白酒', '13986679539', '818bbc12d238c7324f4ec41f0f0de60b6aee532e5dd21528f8a0fb0fcd81e59d', null, '491ba109a721d424521e', '1', null, '4e6c732245c64f5f82f7be22093139c3', '白酒部门', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '0010010050029759', null, null, '2017-12-22 19:49:35', null);
INSERT INTO `upms_user` VALUES ('619cd0083d534e1e88fbc9784010c4a8', 'cxb', '陈雪冰', 'Chen', '15072486010', 'b6e2091f58af8aec2974dc264ff0663d526ea24d5ecd28736bb5a7247e36c0cc', 'http://wx.qlogo.cn/mmopen/iaiaoS8zHxSIBIQ5ZyDJIdBKapCHR7icFsw4WNAzMkp4B8ibcT28Nb6bVxRlYqmLzq98BD0nLlh6s9JUUPIPq3vPMia4lBMfJBJgH/0', '6c8985418710ef7bbd', '1', null, '3105528d84654eef89812f26be23e481', '马幸组', '', '', null, '业务员,雪冰测试账务组,主管', null, null, null, null, '河南省', '郑州市', '中原区', '001001001001001002e3f3', 'oaCaowZxcwScCLuN-l0aYGqEm0_A', null, '2017-12-15 21:36:06', '2018-01-11 17:29:55');
INSERT INTO `upms_user` VALUES ('626e1f78ee9a4cf38fbfd9664e586658', 'yg', '杨广', null, '13800800118', 'cb818185b5e570d6ed98bb80fabaca69729a4eaf996cec403a41c7292e2897d4', null, '0a8958176d8d4cc79', '1', null, 'b9fc3766e8514c7ab2248cad10ebf60e', '咏梅', '', '', null, '经理', null, null, null, null, null, null, null, '001001001002004001fca0', null, null, '2017-12-15 13:05:27', '2018-01-11 10:35:18');
INSERT INTO `upms_user` VALUES ('6b60a5599e1b41858795c37be51956f3', 'cx', '陈霞', null, '13800800105', 'f12af4b637a1a5f58e7eca37548300622aef391b06ce23265987dd4228738e72', null, '838b5711562e5ef', '0', '2018-01-05 12:28:09', 'a6c18cd9848d4b5bb009548dc3b7d408', '陈霞组', '', '', null, '直营主管', null, null, null, null, null, null, null, '00100100100200150d0', null, null, '2017-12-15 12:02:23', '2017-12-15 12:13:21');
INSERT INTO `upms_user` VALUES ('79fc6554835046d881ecb206b84f4e3e', 'lsh', '刘世华', null, '13800800111', 'f56436f7a772c76c713a2402fd26b146a708aea9bd3921df88038edafb3873ae', null, 'c9bbe10c6239f', '1', null, '3105528d84654eef89812f26be23e481', '马幸组', '', '', null, '业务员', null, null, null, null, null, null, null, '001001001001001002665b', null, null, '2017-12-15 13:01:37', null);
INSERT INTO `upms_user` VALUES ('7a1c125dbbeb4dad920841c4e0791de6', 'xjbadmin', '习酒白管理员', null, '13822222222', 'f7f66d6c69cc9f94500c8334ff1b73435a05e5cf218cf153a2b7e548435e81fe', null, 'dfa61482374bcc0', '1', null, 'e07acca2e03245698ca66cf1575dce19', '习酒公司（白酒）', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001004002e03f', null, null, '2018-01-29 11:18:54', null);
INSERT INTO `upms_user` VALUES ('7ace715943794ad3a0bab810575a362a', 'yxy', '袁小友（商超部经理）', null, '13800800104', '5460b01380153ab0e143c9908a259c0a37da12ff0bd78c2a1fbd2fd708ad9b86', null, '4a81b059cd291fa5b6', '1', null, '032df199f7af42edbd6d39ae936f8188', '商超部', '', '', null, '经理', null, null, null, null, null, null, null, '001001001001002744d', null, null, '2017-12-15 12:01:39', '2017-12-15 12:13:15');
INSERT INTO `upms_user` VALUES ('7c86b5cedbe0448197618a19b98622b7', 'lqywx1', '王万', null, '13971145154', 'e9a27b7c147daaabec17954fe6da3086f050f28a71e2b10d3f8e69e8b2521e31', null, '24b58ba52dc68866dacbe', '1', null, '756d01a11ba64d4aa3d31e3f6ff0f190', '广州龙泉(稻花香)', '', '', null, '库管,业务员', null, null, null, null, null, null, null, '001002001001bced', null, null, '2018-01-03 17:42:22', '2018-01-08 18:28:57');
INSERT INTO `upms_user` VALUES ('7d3c156c91e443da83aa1139b8fb2a39', 'swadmin', '税务人员', '税务人员', '15545987776', '513145bd3710f1aa6fe70e133cab89ed9701c777bdc26ebff3e2bdcfd9b4c5a8', null, '5bc936b9dff471', '1', null, 'e58667e0601b46ed8a2868546954c407', '启光商贸（劲酒）', '', '', null, '税务人员', null, null, null, null, null, null, null, '001001001c302', null, null, '2018-03-06 10:45:38', '2018-03-06 11:20:50');
INSERT INTO `upms_user` VALUES ('824e02bc63c540bd95313d7acff1b178', 'xjjadmin', '习酒劲管理员', null, '13811111111', '64eee5bec6aec02ed1930b9826083fa4e917b489f456c2389ac99b95b0362195', null, 'fc934c5f5765e34003', '1', null, 'c8aa1bec61284aa98373e0c0383ac141', '习酒公司（劲酒）', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '00100400147b9', null, null, '2018-01-29 11:18:18', null);
INSERT INTO `upms_user` VALUES ('8281eb212fe14829837521f7373c89e2', 'qdyuser49', '东皇太一', null, '13128904334', '2640f2174f2e6a0f5d11cc576ef14544a1429ed43ad711c7813bd7e6389b27ee', null, '78d834550acc55', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '业务员', null, null, null, null, null, null, null, '001001001001522a', null, null, '2017-12-29 15:23:55', null);
INSERT INTO `upms_user` VALUES ('83a411e154214eb98b9b2de903da11db', 'yj', '杨俊', null, '13800800109', 'd73e82e5854ee99a62e80a6130689c20c3b6ce430f66aba2f4c19ad17f7a51c0', null, '48a79e3b2fa2c9731e87', '1', null, '93236e88e61e4d2180536bcb8c835c36', '汪梦龙组', '', '', null, '业务员', null, null, null, null, null, null, null, '001001001001001001531f', null, null, '2017-12-15 13:00:55', null);
INSERT INTO `upms_user` VALUES ('867797f313c3432cadf14db43eeed2b2', 'srd1', '宋荣第', null, '13800000001', '42fb525a1716625c2aacd1d8f804e14f1da72be244ee51ee400033efc25a6108', null, '8509d708607576b6', '1', null, 'c8aa1bec61284aa98373e0c0383ac141', '习酒公司（劲酒）', '', '', null, '业务员', null, null, null, null, null, null, null, '0010040019443', null, null, '2018-01-29 11:51:16', null);
INSERT INTO `upms_user` VALUES ('8897e1e6dc76460895c19b00a980492b', 'srd', '宋荣第', '胃疼', '18658577202', 'dd7cea98415fefdb1d3082dde81bfae5bf7bd9c37ced0ebbd899ff12d351bca6', 'http://wx.qlogo.cn/mmopen/ajNVdqHZLLBAmdia9nsZumo3t18iaeXTibhKARgffIaPtFk9kuRoXyYqibibMKiavHNMJWVyroFgxsngp5h1ibwCIKTbQ/0', '8bde4e15bd6066b', '1', null, '93236e88e61e4d2180536bcb8c835c36', '汪梦龙组', '', '', null, '主管,业务员', null, null, null, null, null, null, null, '001001001001001001b15d', 'oaCaowdABn9VmOiqhL0Xkm9mJxMw', null, '2017-12-15 20:14:26', '2018-01-19 14:45:44');
INSERT INTO `upms_user` VALUES ('8a117c32a7ab47e6a876d68755445599', 'hx2', '黄鑫', null, '18627771043', 'ed31c559ba360df8e4624f6d9d8e84ca2c4cb2aee9597a7ec9e8e8759365f108', null, '356788e2b0a360', '1', null, 'c11e5f292b5e42a4a54e556f78aed193', '新世界百货', '', '', null, '业务员', null, null, null, null, null, null, null, '001003001002f84a', 'oaCaowVe_71PxMHYUIAHvJZ9UEao', null, '2018-01-16 18:14:33', null);
INSERT INTO `upms_user` VALUES ('8fa466a0c3114f14afce1aab6aa3218a', 'qfadmin', '清风管理员', null, '18392938298', '397a14c8042907e6652d4944dfc6d15ad8e9c14b51b6b56341f69c1119d6f2be', null, '99442eaccf2893a1b9be1c', '1', null, '58b2e2cead864497b101f407de25f61f', '清风', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '001001001002001001c88c', null, null, '2017-12-15 14:36:36', null);
INSERT INTO `upms_user` VALUES ('9470df3490a44fae8ce1e351615d3fb4', 'srd11', '宋荣第', null, '13800000002', '44bf270ef7195eda6c28a987a49332efd4021f736cf01843284a2b35afd62a37', null, '7c8d834b5c3d1a742f', '1', null, 'c8aa1bec61284aa98373e0c0383ac141', '习酒公司（劲酒）', '', '', null, '业务员', null, null, null, null, '北京', '北京市', '东城区', '001004001ffba', null, null, '2018-01-29 17:58:29', null);
INSERT INTO `upms_user` VALUES ('9b7a60b72d064d9d9ab212414a8f58e3', 'gadmin', '古酒', '古酒', '15698758265', '674ddf9074783960273c352c1c701778a35c9004f25faf4d6975043c95616d71', null, '7a3409838e75f5376', '1', null, 'bf41b355b97b44888b3465be8cb46577', '古酒', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '0010010010043b45', null, null, '2018-01-19 10:24:57', '2018-01-24 11:31:14');
INSERT INTO `upms_user` VALUES ('a2bd5d6fdfde4d41a6d7693a19ea8bee', 'gcd', '高超笛', '&nbsp；', '13618662387', '725909dba3feac940ea2a329ade5f0abfe0699b26ed328cba178137f58ce1afa', 'http://wx.qlogo.cn/mmopen/lPpj7fSVYRSV3z4GMib5twXT2w7cg3MDICrY5bteHORKBib67fyWuDiavcFicF5ZTiaTRpUicOA99v5gmh22JOsK9dKB6xxeyrGVF4/0', 'd46287eb9cd57', '1', null, '9dd2c516204b48b1b400fe54cf18743a', '餐饮部', '', '', null, '经理,业务员,主管,财务主管', null, null, null, null, '北京', '北京市', '东城区', '001001001001001110f', null, null, '2017-12-19 17:09:45', '2017-12-19 17:13:15');
INSERT INTO `upms_user` VALUES ('b36522edfec24d1384e6d651e90e956e', 'lqjj', '劲酒管理员', null, '13971145281', '37afe6c1129a23ee1526fd9d4d6e1ccb911db458fe855dc8162749101343f70b', null, '7aa44274ddcfed437b', '1', null, 'e4c967ce5ed241cdb3a7725c42963374', '广州龙泉(劲酒)', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '001002001002f695', null, null, '2018-01-03 17:18:19', null);
INSERT INTO `upms_user` VALUES ('bfb55bfaa6d54c4188d066e9e11c3b34', 'zgadmin', '正光管理员', null, '18548481511', 'a7b98e4d355b01a2704011f2070a2c2ab2bb56c75e5e0c81d625093dcf5bace5', null, '14f3796601f61574cf689', '1', null, 'c13ae60a6af042c789d61004a91b4823', '正光', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '0010010010020040020fba', null, null, '2017-12-16 14:06:37', null);
INSERT INTO `upms_user` VALUES ('caa97c59ae32436aab449480bfd590f1', 'hbadmin', '湖北事业部', '湖北', '15907192915', '49305ccc443c1401cdb0e3a70ed52ec86f1b54c33cd1712fd231a0601e7d1c31', null, '8a109b6cb2b90ac2', '1', null, 'c913f77079824f26985441eb10fe23e3', '湖北事业部', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '0010010051183', null, null, '2017-12-22 19:15:08', null);
INSERT INTO `upms_user` VALUES ('cc6b1bb8b3f24267921ea9ba69d6f036', 'xsjadmin', '新世界管理员', null, '13292398935', '0e21b33361f9a27b12c353187d6d8f2a913d512ddaf27259aadb902c1f0c8cff', null, '47a6837704ce87d635cd', '1', null, 'c11e5f292b5e42a4a54e556f78aed193', '新世界百货', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001003001002fa58', null, null, '2018-01-16 17:52:16', '2018-01-16 17:53:57');
INSERT INTO `upms_user` VALUES ('d0bd75000eed404487dc04df3220afe8', 'lc', '李冲', null, '13800800117', '5fcf08a77c536d09c84a561e1ec68360746a8d69c98074a059621ec385bc5a60', null, '488fbe7a5b47b2beabf5', '1', null, '99e2904e45124b6597697d9eb41b3ed3', '腾谷', '', '', null, '业务员', null, null, null, null, null, null, null, '001001001002001002df12', null, null, '2017-12-15 13:04:59', null);
INSERT INTO `upms_user` VALUES ('d317098089dd41ae9cc94db549a2dad1', 'qdyuser48', '刘备', null, '13128904333', 'f5be1e6cbf4760a9cd46c4f4bd15e3b87e96240500b71d49ea4c0d480435d8e4', null, 'ac48e6b5fd7d8656', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '业务员', null, null, null, null, null, null, null, '0010010010018fc0', null, null, '2017-12-29 15:23:55', null);
INSERT INTO `upms_user` VALUES ('d5372bd408a543ea9457cc0bafcea8a8', 'srd3', '宋荣第', null, '13800000001', '3e2ffccf64066907c54fbd5053a0fcc7cd3f81cff863bf608584f3aaa771c861', null, 'a4e1792b2aa98ae1a01b5', '1', null, 'e4cf1da399f748069d30030ac124f1ae', '习酒公司（红酒）', '', '', null, '业务员', null, null, null, null, null, null, null, '0010040039845', null, null, '2018-01-29 11:53:15', null);
INSERT INTO `upms_user` VALUES ('db932cbd142a419a91ad583cb0b1433f', 'lf', '李非（直营一部经理）', null, '13800800101', '95fe84fa5b90d5cfbdab9b405238a5068800466674ebef8fe8ad035cf466ad7f', null, '3b90029a9bc45c9c4', '1', null, '61e16b3010194d968fed8ee25800b6fa', '直营一部', '', '', null, '主管', null, null, null, null, null, null, null, '00100100100240a3', null, null, '2017-12-15 11:59:48', '2018-03-01 09:20:29');
INSERT INTO `upms_user` VALUES ('dd6dd89c80954525871ce4a1f50f90cc', 'wsadmin', '武商管理员', null, '13292398928', '2f0cb1f74effefb8b5ce35e255b2793d3b754ce3e04fd1381b248f02035af69e', null, 'db91085f16ccd664a', '1', null, '55e62aacfa0d459e8a1e75aaba973db4', '武商贸易集团', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001003001158c', null, null, '2018-01-16 17:51:42', null);
INSERT INTO `upms_user` VALUES ('e4fec9df3f934164b840afa9327722de', 'hbjj', '湖北劲酒', '劲酒', '13985698788', '6af4caedff23a9f450f0ee4a4ddd9c7d10936339d0f155cedc97aa9559a55765', null, 'eb9743a8ed646385d', '1', null, 'b14c9be9844447eaaa39b0c679fb6dd1', '劲酒部门', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '0010010050016481', null, null, '2017-12-22 19:24:39', null);
INSERT INTO `upms_user` VALUES ('e560c65edfac4730bbb09370d7f6001e', 'wml', '汪梦龙', null, '13800800107', 'cc7ac7c27a8690006086e115fdb51f4a2ef98b2d637bb3b4f31d900b12387dd4', null, '9adfa0f34584c2c11', '1', null, '93236e88e61e4d2180536bcb8c835c36', '汪梦龙组', '', '', null, '餐饮主管', null, null, null, null, null, null, null, '001001001001001001290a', null, null, '2017-12-15 12:59:17', null);
INSERT INTO `upms_user` VALUES ('e64418168dff4111a62f4e5ad287c25d', 'byb', 'asdasd', null, '13971146633', '8ee4f375188fb4d31907500250f98a821a10e824c296a88a967e6a4f2c04caf2', null, '9d57bb0210781904', '1', null, 'deaaabdd3cd8464a9592dc0e4d1a27eb', '白云边公司', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001002c4e7', null, null, '2018-01-16 16:29:43', null);
INSERT INTO `upms_user` VALUES ('e9b802a57ae4494ab28336b6d93cb377', 'mx', '马幸', null, '13800800108', '45bbc900a07a2f47d7c8855bdd606bbc78d1a1736c46c95f9a6ac18854d4ee61', null, 'e54cd9948089c5652d7633', '1', null, '3105528d84654eef89812f26be23e481', '马幸组', '', '', null, '餐饮主管', null, null, null, null, null, null, null, '001001001001001002d6dd', null, null, '2017-12-15 12:59:42', null);
INSERT INTO `upms_user` VALUES ('ea89db427267407489395a8b62c9c24e', 'qdyuser46', '李元芳', null, '13128904331', '78673c10e75ae8909645ffb9871872bee9fd6e6249c62c05dc31e6e91245cb0a', null, '3af9db6df161e0fa3', '1', null, 'eb0da9b8cd7c44c888477a4c1947bf44', '总部', null, null, null, '业务员', null, null, null, null, null, null, null, '0010010010015706', null, null, '2017-12-29 15:23:55', null);
INSERT INTO `upms_user` VALUES ('eaf5aecf83f44f63bf18365843a8327c', 'qgadmin', '启光管理员（劲酒）', null, '13800808888', '91f015e5d391b5d6746c5f9ea6fd325d7fb91393e7200c32b59989612a147c35', null, 'ddad523809731f', '1', null, 'e58667e0601b46ed8a2868546954c407', '启光商贸（劲酒）', '', '', null, '经销商管理员,库管', null, null, null, null, '内蒙古自治区', '呼和浩特市', '新城区', '0010010015e5f', null, null, '2017-12-15 11:56:00', '2018-01-05 11:01:14');
INSERT INTO `upms_user` VALUES ('ebda4cece29c419496b06dc840cbe408', 'rah', '任爱华', null, '13800800113', '0c98992dac86e6f61ad6afadc09754eadd7d8961ed315469589345b11a1b282b', null, 'c99bac0a5e431094efa', '1', null, '9dd2c516204b48b1b400fe54cf18743a', '餐饮部', '', '', null, '账务人员', null, null, null, null, null, null, null, '0010010010010017290', null, null, '2017-12-15 13:02:43', null);
INSERT INTO `upms_user` VALUES ('f13005bd3c7a4450bee445b2ce383376', 'xjadmin', '习酒管理员', null, '13459909099', 'c1eba6e3c34122c937e0cb6c52c602756dc527bbc9270ad14cf3467c088a2f75', null, '5ba7d79b5aebf79831', '1', null, 'b24ce300dc084cccb39236e323e5a22c', '习酒公司', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001004c5da', null, null, '2018-01-29 11:07:39', null);
INSERT INTO `upms_user` VALUES ('f3505bc871c543f2892b2722e69db537', 'kadmin', '苦荞', '苦荞', '15907829879', '43d1d2804eba402d08519ed1e2be63e0c0867354bc8248488d7c75ef797f8c6f', null, 'be108cd2954de', '1', null, '37d3bab0d1544505940ce6e02cddf7d7', '苦荞部门', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '0010010050048f0a', null, null, '2017-12-25 09:58:37', null);
INSERT INTO `upms_user` VALUES ('f4609a97aff64881aafa498600029019', 'bj', '白酒', '白酒', '13987896899', 'bc484786e68aaf19d1e0699a797c650a655b6eac3395ca6e1cd8733a87a8bc1d', null, 'd4409aaa461248beb5e289', '1', null, '1e677b1ebfcd40d080a97bbb68dd3b3b', '黄酒部门', '', '', null, '直营商管理员', null, null, null, null, null, null, null, '00100100500390bc', null, null, '2017-12-22 19:54:02', null);
INSERT INTO `upms_user` VALUES ('fc022eaf6c274fd3a3a4a9fbd5a0d460', 'zyx', '朱云翔0', null, '15985698569', 'ad9028d2f36a2c571e049d84c543e9c5b081277c1684778c3b46aca7e2654483', null, 'b9733449dd4e5673', '1', '2018-01-05 12:29:23', 'e97d32559ab14dfcaf3fb57ce2cfd41f', '朱云翔组', '', '', null, '业务员', null, null, null, null, null, null, null, '001001001002004ac68', '', null, '2017-12-15 12:02:49', '2018-01-12 11:00:08');
INSERT INTO `upms_user` VALUES ('fd4d8ed313074548bc6e3a63bf0ef533', 'larry', '龙', '龙之火焰', '18571639301', 'c9613c4fc5d0e81e5d6014627e9cdb402aea2a64456369a12154e9f4ae04baaa', null, '27ae8b19e885b8d8d4', '1', null, 'e58667e0601b46ed8a2868546954c407', '启光商贸（劲酒）', '', '', null, '业务员,主管', null, null, null, null, null, null, null, '0010010013e17', null, null, '2018-01-23 09:18:22', '2018-01-29 18:09:52');
INSERT INTO `upms_user` VALUES ('fe60836f7f7a410b89abbafc8db48893', 'mtadmin', '茅台', '茅台', '13698745824', '5cea33e9bf8c1a8207a03e846e9223db387c3f71d15bb46e4d8681ab69b97fdf', null, '749e1acc07bb92', '1', null, '7b62cbde853e40f285ce17638a5b8391', '茅台', '', '', null, '业务员,主管', null, null, null, null, null, null, null, '001001007001da10', null, null, '2018-01-20 21:17:48', '2018-01-27 17:51:41');
INSERT INTO `upms_user` VALUES ('ff3e7f711d4a4e08a1da2ce12631839c', 'xjhadmin', '习酒红管理员', null, '13833333333', 'd50e630c42706000a39c6872d487c253c291915c6530379c301194a438304985', null, '2142d6bf69cb4c9ea3470d', '1', null, 'e4cf1da399f748069d30030ac124f1ae', '习酒公司（红酒）', '', '', null, '经销商管理员', null, null, null, null, null, null, null, '001004003800d', null, null, '2018-01-29 11:19:24', null);

-- ----------------------------
-- Table structure for upms_user_group_rel
-- ----------------------------
DROP TABLE IF EXISTS `upms_user_group_rel`;
CREATE TABLE `upms_user_group_rel` (
  `id` varchar(32) NOT NULL COMMENT '行号',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `group_id` varchar(32) NOT NULL COMMENT '分组ID',
  PRIMARY KEY (`id`),
  KEY `_group_id` (`group_id`),
  KEY `_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户分组关联表';
