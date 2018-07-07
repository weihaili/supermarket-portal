package com.cn.supermarket.json;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonStringToObjectTest {

	private static String jsonStr = "{\"status\":200,\"msg\":\"OK\",\"data\":{\"itemList\":[{\"id\":\"1039296\",\"title\":\"合约惠<em stype=\\\"color:red\\\">机</em>测试<em stype=\\\"color:red\\\">手机</em>（请勿下单）\",\"sell_point\":\"\",\"price\":269900,\"image\":\"http://image.taotao.com/jd/7f4e1eaf8f06492aaaf7a717f20344c7.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/7f4e1eaf8f06492aaaf7a717f20344c7.jpg\"]},{\"id\":\"143771131488369\",\"title\":\"121\",\"sell_point\":\"121\",\"price\":120,\"image\":\"http://localhost:9000/images/20150724/1437711287962003.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://localhost:9000/images/20150724/1437711287962003.jpg\"]},{\"id\":\"1458729469\",\"title\":\"海尔（Haier）HM-M209<em stype=\\\"color:red\\\">手机</em> 老人机 老人<em stype=\\\"color:red\\\">手机</em> 老年<em stype=\\\"color:red\\\">手机</em> 直板<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"下单即送100京豆！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/02203e7779704ffe87ffabd451105869.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/02203e7779704ffe87ffabd451105869.jpg\"]},{\"id\":\"1458729470\",\"title\":\"海尔（Haier）HM-M209<em stype=\\\"color:red\\\">手机</em> 老人机 老人<em stype=\\\"color:red\\\">手机</em> 老年<em stype=\\\"color:red\\\">手机</em> 直板<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"下单即送100京豆！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/5c5bb93dbe3f486eb209735770b830ba.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/5c5bb93dbe3f486eb209735770b830ba.jpg\"]},{\"id\":\"1460827382\",\"title\":\"海尔（Haier）HM-M209<em stype=\\\"color:red\\\">手机</em> 老人机 老人<em stype=\\\"color:red\\\">手机</em> 老年<em stype=\\\"color:red\\\">手机</em> 直板<em stype=\\\"color:red\\\">手机</em> 白色\",\"sell_point\":\"下单即送100京豆！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/80a9080245fd4281a4d40ace8ee0baf5.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/80a9080245fd4281a4d40ace8ee0baf5.jpg\"]},{\"id\":\"1390218722\",\"title\":\"金国威（SanCup）D600荣耀 老人<em stype=\\\"color:red\\\">手机</em>移动/联通2G<em stype=\\\"color:red\\\">手写手机</em> 双卡双待 幻影金\",\"sell_point\":\"魔音手机 触屏直板老人机 手机 老人手机大字体 大按键 大音量 超长待机 老年手机男女\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/c2f6762deaed4cbda7e126c99ea536a2.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/c2f6762deaed4cbda7e126c99ea536a2.jpg\"]},{\"id\":\"1390218723\",\"title\":\"金国威（SanCup）D600荣耀 老人<em stype=\\\"color:red\\\">手机</em>移动/联通2G<em stype=\\\"color:red\\\">手写手机</em> 双卡双待 钢琴黑\",\"sell_point\":\"魔音手机 触屏直板老人机 手机 老人手机大字体 大按键 大音量 超长待机 老年手机男女\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/e2dc3218b74349cabeb4c0715776c9ed.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/e2dc3218b74349cabeb4c0715776c9ed.jpg\"]},{\"id\":\"1390218724\",\"title\":\"金国威（SanCup）D600荣耀 老人<em stype=\\\"color:red\\\">手机</em>移动/联通2G<em stype=\\\"color:red\\\">手写手机</em> 双卡双待 褐咖啡\",\"sell_point\":\"魔音手机 触屏直板老人机 手机 老人手机大字体 大按键 大音量 超长待机 老年手机男女\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/b6adca68a9df41f8aa44ca12fc79e5ac.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/b6adca68a9df41f8aa44ca12fc79e5ac.jpg\"]},{\"id\":\"1312760511\",\"title\":\"心迪(XIND) 399D 迷你<em stype=\\\"color:red\\\">手机</em> 移动/联通2G 双卡双待 黑色\",\"sell_point\":\"超长待机 直板按键迷你小手机 小汽车外观 儿童学生手机 女性学生手机女 老人手机 备用手机\",\"price\":11800,\"image\":\"http://image.taotao.com/jd/27ee0ee6f62c43ae9aa11f9fd6e8b9a9.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/27ee0ee6f62c43ae9aa11f9fd6e8b9a9.jpg\"]},{\"id\":\"1312760512\",\"title\":\"心迪(XIND) 399D 迷你<em stype=\\\"color:red\\\">手机</em> 移动/联通2G 双卡双待 金色\",\"sell_point\":\"超长待机 直板按键迷你小手机 小汽车外观 儿童学生手机 女性学生手机女 老人手机 备用手机\",\"price\":11800,\"image\":\"http://image.taotao.com/jd/390722767ca64c86b6abeaebe267c8ee.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/390722767ca64c86b6abeaebe267c8ee.jpg\"]},{\"id\":\"1312760513\",\"title\":\"心迪(XIND) 399D 迷你<em stype=\\\"color:red\\\">手机</em> 移动/联通2G 双卡双待 玫瑰金\",\"sell_point\":\"超长待机 直板按键迷你小手机 小汽车外观 儿童学生手机 女性学生手机女 老人手机 备用手机\",\"price\":11800,\"image\":\"http://image.taotao.com/jd/14ac46168f93426796222c8688327e11.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/14ac46168f93426796222c8688327e11.jpg\"]},{\"id\":\"1460869943\",\"title\":\"威铂 (v-hope) E106 迷你 电信2G商务<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"迷你卡片手机 超长待机 直板按键迷你手机 儿童学生手机 商务手机 9个亲情号 老人手机\",\"price\":29900,\"image\":\"http://image.taotao.com/jd/1590783d39d5477aadad28af256fbd12.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/1590783d39d5477aadad28af256fbd12.jpg\"]},{\"id\":\"1460869944\",\"title\":\"威铂 (v-hope) E106 迷你 电信2G商务<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"迷你卡片手机 超长待机 直板按键迷你手机 儿童学生手机 商务手机 9个亲情号 老人手机\",\"price\":29900,\"image\":\"http://image.taotao.com/jd/67bb2532f3ec4251a40f99b7a0b80d23.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/67bb2532f3ec4251a40f99b7a0b80d23.jpg\"]},{\"id\":\"1460869945\",\"title\":\"威铂 (v-hope) E106 迷你 电信2G商务<em stype=\\\"color:red\\\">手机</em> 咖啡色\",\"sell_point\":\"迷你卡片手机 超长待机 直板按键迷你手机 儿童学生手机 商务手机 9个亲情号 老人手机\",\"price\":29900,\"image\":\"http://image.taotao.com/jd/1634d47f5190449084352cfc21349b9a.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/1634d47f5190449084352cfc21349b9a.jpg\"]},{\"id\":\"1286299689\",\"title\":\"唐为 TW99A 移动联通2G<em stype=\\\"color:red\\\">手机</em> 老人<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"\",\"price\":16800,\"image\":\"http://image.taotao.com/jd/ee6235fffa0241c6a777f798f7d99ffa.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/ee6235fffa0241c6a777f798f7d99ffa.jpg\"]},{\"id\":\"1287389822\",\"title\":\"唐为 TW95V 移动联通2G<em stype=\\\"color:red\\\">手机</em> 双卡 老人<em stype=\\\"color:red\\\">手机</em> 白色\",\"sell_point\":\"\",\"price\":16800,\"image\":\"http://image.taotao.com/jd/cb27fb7f5bcb4505a2df3e6a45e77381.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/cb27fb7f5bcb4505a2df3e6a45e77381.jpg\"]},{\"id\":\"1314086223\",\"title\":\"大显(DaXian) GS2000 移动/联通2G(GSM) 老人<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"好礼闹元宵！手机更实惠！\",\"price\":9900,\"image\":\"http://image.taotao.com/jd/6d54938d293b48afa8ee09cbd3460cf8.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/6d54938d293b48afa8ee09cbd3460cf8.jpg\"]},{\"id\":\"1310105093\",\"title\":\"大显DX886 移动/联通2G翻盖<em stype=\\\"color:red\\\">手</em>写老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 红色\",\"sell_point\":\"手写翻盖手机 老年人专用手机大字体大按键大音量老年手机老人机女全按键盘手机男\",\"price\":26800,\"image\":\"http://image.taotao.com/jd/57781fca903a4e6eac0bffe30ac3cb0b.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/57781fca903a4e6eac0bffe30ac3cb0b.jpg\"]},{\"id\":\"1310105094\",\"title\":\"大显DX886 移动/联通2G翻盖<em stype=\\\"color:red\\\">手</em>写老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 黑色\",\"sell_point\":\"手写翻盖手机 老年人专用手机大字体大按键大音量老年手机老人机女全按键盘手机男\",\"price\":26800,\"image\":\"http://image.taotao.com/jd/b4f55320a8e74bf394cb6bbc03b89378.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/b4f55320a8e74bf394cb6bbc03b89378.jpg\"]},{\"id\":\"1310105095\",\"title\":\"大显DX886 移动/联通2G翻盖<em stype=\\\"color:red\\\">手</em>写老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 白色\",\"sell_point\":\"手写翻盖手机 老年人专用手机大字体大按键大音量老年手机老人机女全按键盘手机男\",\"price\":26800,\"image\":\"http://image.taotao.com/jd/851f5d76994a42b79c7538988f9ec2ce.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/851f5d76994a42b79c7538988f9ec2ce.jpg\"]},{\"id\":\"1366558173\",\"title\":\"奥乐 (AOLE) DIO3 移动/联通2G翻盖老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 黑色\",\"sell_point\":\"京东配送！货到付款！包邮！翻盖手机老人手机翻盖男老年手机女老年机老人机正品老年人专用手机\",\"price\":16800,\"image\":\"http://image.taotao.com/jd/042ccfa641b84a509f7e918c9c7e095f.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/042ccfa641b84a509f7e918c9c7e095f.jpg\"]},{\"id\":\"1366558174\",\"title\":\"奥乐 (AOLE) DIO3 移动/联通2G翻盖老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 金色\",\"sell_point\":\"京东配送！货到付款！包邮！翻盖手机老人手机翻盖男老年手机女老年机老人机正品老年人专用手机\",\"price\":16800,\"image\":\"http://image.taotao.com/jd/d9ad2dc655d84c28ad26803d60baa56d.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/d9ad2dc655d84c28ad26803d60baa56d.jpg\"]},{\"id\":\"1366558175\",\"title\":\"奥乐 (AOLE) DIO3 移动/联通2G翻盖老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 咖啡色\",\"sell_point\":\"京东配送！货到付款！包邮！翻盖手机老人手机翻盖男老年手机女老年机老人机正品老年人专用手机\",\"price\":16800,\"image\":\"http://image.taotao.com/jd/956daca9326d46cd86ae439c3f3dc389.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/956daca9326d46cd86ae439c3f3dc389.jpg\"]},{\"id\":\"1419349246\",\"title\":\"心迪(XIND) Z1 CC 老人机移动/联通2G 双卡双待 香槟金\",\"sell_point\":\"老人手机 超长待机 迷你手机 学生直板手机 老人备用机 家长放心儿童手机备用老人机手机男女\",\"price\":12900,\"image\":\"http://image.taotao.com/jd/ef0d0f2859564011b377d9138311c70c.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/ef0d0f2859564011b377d9138311c70c.jpg\"]},{\"id\":\"1419349247\",\"title\":\"心迪(XIND) Z1 CC 老人机移动/联通2G 双卡双待 白色\",\"sell_point\":\"老人手机 超长待机 迷你手机 学生直板手机 老人备用机 家长放心儿童手机备用老人机手机男女\",\"price\":12900,\"image\":\"http://image.taotao.com/jd/5c086db3987a4122927c925a939c5f11.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/5c086db3987a4122927c925a939c5f11.jpg\"]},{\"id\":\"1419349248\",\"title\":\"心迪(XIND) Z1 CC 老人机移动/联通2G 双卡双待 黑色\",\"sell_point\":\"老人手机 超长待机 迷你手机 学生直板手机 老人备用机 家长放心儿童手机备用老人机手机男女\",\"price\":12900,\"image\":\"http://image.taotao.com/jd/69f165aaa5894baf895a4ae9cb0df4d8.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/69f165aaa5894baf895a4ae9cb0df4d8.jpg\"]},{\"id\":\"1295231303\",\"title\":\"百合 C16 CDMA电信 迷你小<em stype=\\\"color:red\\\">手机</em> 老年人<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"老年人学生备用手机！超大音量！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/1f2bcef987cf4796b359354f2f2da83d.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/1f2bcef987cf4796b359354f2f2da83d.jpg\"]},{\"id\":\"1295231304\",\"title\":\"百合 C16 CDMA电信 迷你小<em stype=\\\"color:red\\\">手机</em> 老年人<em stype=\\\"color:red\\\">手机</em> 蓝色\",\"sell_point\":\"老年人学生备用手机！超大音量！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/fd79b2af81464dd3a940ae4cc39786b5.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/fd79b2af81464dd3a940ae4cc39786b5.jpg\"]},{\"id\":\"1295231305\",\"title\":\"百合 C16 CDMA电信 迷你小<em stype=\\\"color:red\\\">手机</em> 老年人<em stype=\\\"color:red\\\">手机</em> 粉色\",\"sell_point\":\"老年人学生备用手机！超大音量！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/a5bef5558b8c48369e2943c68bcced2e.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/a5bef5558b8c48369e2943c68bcced2e.jpg\"]},{\"id\":\"1295231306\",\"title\":\"百合 C16 CDMA电信 迷你小<em stype=\\\"color:red\\\">手机</em> 老年人<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"老年人学生备用手机！超大音量！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/675bf5435c5040528a3924677aa754d8.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/675bf5435c5040528a3924677aa754d8.jpg\"]},{\"id\":\"1295231307\",\"title\":\"百合 C16 CDMA电信 迷你小<em stype=\\\"color:red\\\">手机</em> 老年人<em stype=\\\"color:red\\\">手机</em> 绿色\",\"sell_point\":\"老年人学生备用手机！超大音量！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/0318528c46954d7a8385184d0a8e1797.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/0318528c46954d7a8385184d0a8e1797.jpg\"]},{\"id\":\"1305344543\",\"title\":\"百合 C16 CDMA电信 迷你小<em stype=\\\"color:red\\\">手机</em> 老年人<em stype=\\\"color:red\\\">手机</em> 白色\",\"sell_point\":\"老年人学生备用手机！超大音量！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/9561b94ee27c4c2a9f0c329b2846cb95.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/9561b94ee27c4c2a9f0c329b2846cb95.jpg\"]},{\"id\":\"1317646738\",\"title\":\"立丰（lephone) 小四 T708 移动4G<em stype=\\\"color:red\\\">手机</em> 典雅黑\",\"sell_point\":\"5.0大屏超薄款 男女款式潮流手机 移动4G网络手机\",\"price\":79600,\"image\":\"http://image.taotao.com/jd/16506c7b34ef42fda6ba15fd03021cf3.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/16506c7b34ef42fda6ba15fd03021cf3.jpg\"]},{\"id\":\"1379572184\",\"title\":\"百合 C16 CDMA电信 迷你小<em stype=\\\"color:red\\\">手机</em> 老年人<em stype=\\\"color:red\\\">手机</em> 金色\",\"sell_point\":\"老年人学生备用手机！超大音量！\",\"price\":19900,\"image\":\"http://image.taotao.com/jd/56cc1560d322445a929a1c218931d063.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/56cc1560d322445a929a1c218931d063.jpg\"]},{\"id\":\"1271749251\",\"title\":\"尼凯恩 N3 联通3G<em stype=\\\"color:red\\\">手机</em> 双卡双待\",\"sell_point\":\"\",\"price\":59900,\"image\":\"http://image.taotao.com/jd/800b4e97c1a0403aa1c93aab528de2b7.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/800b4e97c1a0403aa1c93aab528de2b7.jpg\"]},{\"id\":\"1289157639\",\"title\":\"唐为 TW98X 双卡单通 音乐<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"\",\"price\":18800,\"image\":\"http://image.taotao.com/jd/014c29f6cea347cf9d85dd0f6f0ea1fb.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/014c29f6cea347cf9d85dd0f6f0ea1fb.jpg\"]},{\"id\":\"1366834793\",\"title\":\"首信(CAPITEL) S798 移动/联通2G老人<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"\",\"price\":6900,\"image\":\"http://image.taotao.com/jd/f245af2db71449bbafdb49d34b41e00d.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/f245af2db71449bbafdb49d34b41e00d.jpg\"]},{\"id\":\"1423889955\",\"title\":\"友信达U62 移动/联通2G 直板<em stype=\\\"color:red\\\">手机</em> 白\",\"sell_point\":\"\",\"price\":10900,\"image\":\"http://image.taotao.com/jd/8bb26942ef8a43ee9bd1fce3c252d5dc.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/8bb26942ef8a43ee9bd1fce3c252d5dc.jpg\"]},{\"id\":\"1423889956\",\"title\":\"友信达U62 移动/联通2G 直板<em stype=\\\"color:red\\\">手机</em> 黑\",\"sell_point\":\"\",\"price\":10900,\"image\":\"http://image.taotao.com/jd/b0610ad846174533a95925d374749580.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/b0610ad846174533a95925d374749580.jpg\"]},{\"id\":\"1449254853\",\"title\":\"大显(DaXian) K1 移动/联通2G老人<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"\",\"price\":9900,\"image\":\"http://image.taotao.com/jd/46bdbbf295dc47a9ba4e62a600274840.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/46bdbbf295dc47a9ba4e62a600274840.jpg\"]},{\"id\":\"1449254854\",\"title\":\"大显(DaXian) K1 移动/联通2G老人<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"\",\"price\":9900,\"image\":\"http://image.taotao.com/jd/aa40982883104491acbf0575e9896e45.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/aa40982883104491acbf0575e9896e45.jpg\"]},{\"id\":\"1463824238\",\"title\":\"酷显(KUXIAN)K6移动/联通翻盖老人<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"\",\"price\":13700,\"image\":\"http://image.taotao.com/jd/4b82a2c8c2a048beac25b4c3d47f6fe2.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/4b82a2c8c2a048beac25b4c3d47f6fe2.jpg\"]},{\"id\":\"1463824239\",\"title\":\"酷显(KUXIAN)K6移动/联通翻盖老人<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"\",\"price\":13700,\"image\":\"http://image.taotao.com/jd/5263fa026ece407fb7fca0470d30bcb2.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/5263fa026ece407fb7fca0470d30bcb2.jpg\"]},{\"id\":\"1341489212\",\"title\":\"东信欧蓓（OBOOY） EA508 移动/联通2G老人<em stype=\\\"color:red\\\">手机</em> 白色\",\"sell_point\":\"春节献礼双电送座充晒单送手机 大按键大字体大声音直板完美老人手机 货到付款老人手机专用手机\",\"price\":39800,\"image\":\"http://image.taotao.com/jd/364b1163191d4bf2b3666fa9ce2b7d1c.png\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/364b1163191d4bf2b3666fa9ce2b7d1c.png\"]},{\"id\":\"1341489213\",\"title\":\"东信欧蓓（OBOOY） EA508 移动/联通2G老人<em stype=\\\"color:red\\\">手机</em> 铁灰色\",\"sell_point\":\"春节献礼双电送座充晒单送手机 大按键大字体大声音直板完美老人手机 货到付款老人手机专用手机\",\"price\":39800,\"image\":\"http://image.taotao.com/jd/e5c6ad3a18c4466285b1909d8ae262ff.png\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/e5c6ad3a18c4466285b1909d8ae262ff.png\"]},{\"id\":\"1366682934\",\"title\":\"福中福(F-FOOK) F555 电信版2G老人<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"电信版手机 CDMA手机超长待机老人机老年人专用手机男 女大字体大按键大音量键盘直板手机\",\"price\":12800,\"image\":\"http://image.taotao.com/jd/bb3a4870090645778c6b21e6fd080b76.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/bb3a4870090645778c6b21e6fd080b76.jpg\"]},{\"id\":\"1366682935\",\"title\":\"福中福(F-FOOK) F555 电信版2G老人<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"电信版手机 CDMA手机超长待机老人机老年人专用手机男 女大字体大按键大音量键盘直板手机\",\"price\":12800,\"image\":\"http://image.taotao.com/jd/f8846e32803d430d925a3048a026e533.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/f8846e32803d430d925a3048a026e533.jpg\"]},{\"id\":\"1367510347\",\"title\":\"大显（DaXian） GST6000 移动/联通2G直板老人<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"经典手机 移动联通老人手机  大声音大字体大屏幕老人手机男 女 触屏老人手机 支持货到付款\",\"price\":16800,\"image\":\"http://image.taotao.com/jd/902aadc8ae654bc2a1480b48c8113290.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/902aadc8ae654bc2a1480b48c8113290.jpg\"]},{\"id\":\"1367510348\",\"title\":\"大显（DaXian） GST6000 移动/联通2G直板老人<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"经典手机 移动联通老人手机  大声音大字体大屏幕老人手机男 女 触屏老人手机 支持货到付款\",\"price\":16800,\"image\":\"http://image.taotao.com/jd/cde04bf10593428995c364404a026889.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/cde04bf10593428995c364404a026889.jpg\"]},{\"id\":\"1369123151\",\"title\":\"友信达U636 移动/联通2G女性<em stype=\\\"color:red\\\">手机</em> 学生<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"<a href=\\\"http://mall.jd.com/view_search-207900-0-99-1-24-1.html\\\">超长待机 直板按键 儿童学生手��� 女性老人手机</a> 备用手机\",\"price\":13900,\"image\":\"http://image.taotao.com/jd/8375f136b1b7417eb71fc22af14def22.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/8375f136b1b7417eb71fc22af14def22.jpg\"]},{\"id\":\"1382441341\",\"title\":\"金国威（SanCup）D900小龙马 移动/联通2G老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 黑色\",\"sell_point\":\"屏幕保终身 老人手机 大字体 大按键 大音量 老人手机男女 老人机 手机 按键手机货到付款\",\"price\":9900,\"image\":\"http://image.taotao.com/jd/a79fe71997d248bf8266b7f50aba70ed.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/a79fe71997d248bf8266b7f50aba70ed.jpg\"]},{\"id\":\"1382441342\",\"title\":\"金国威（SanCup）D900小龙马 移动/联通2G老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 咖啡色\",\"sell_point\":\"屏幕保终身 老人手机 大字体 大按键 大音量 老人手机男女 老人机 手机 按键手机货到付款\",\"price\":9900,\"image\":\"http://image.taotao.com/jd/bcadca6b931241849d7fd529a327f5df.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/bcadca6b931241849d7fd529a327f5df.jpg\"]},{\"id\":\"1382441343\",\"title\":\"金国威（SanCup）D900小龙马 移动/联通2G老人<em stype=\\\"color:red\\\">手机</em> 双卡双待 金色\",\"sell_point\":\"屏幕保终身 老人手机 大字体 大按键 大音量 老人手机男女 老人机 手机 按键手机货到付款\",\"price\":9900,\"image\":\"http://image.taotao.com/jd/f2c80f63a2d144a08e6eab1c6e4d3527.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/f2c80f63a2d144a08e6eab1c6e4d3527.jpg\"]},{\"id\":\"1393265451\",\"title\":\"友信达U636 移动/联通2G女性<em stype=\\\"color:red\\\">手机</em> 学生<em stype=\\\"color:red\\\">手机</em> 白\",\"sell_point\":\"<a href=\\\"http://mall.jd.com/view_search-207900-0-99-1-24-1.html\\\">超长待机 直板按键 儿童学生手机 女性老人手机</a> 备用手机\",\"price\":13900,\"image\":\"http://image.taotao.com/jd/450e12b55b444c01ab92f9c2eedd2b5f.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/450e12b55b444c01ab92f9c2eedd2b5f.jpg\"]},{\"id\":\"1417460429\",\"title\":\"友信达Q100 迷你<em stype=\\\"color:red\\\">手机</em> 移动联通2G 金\",\"sell_point\":\"万能遥控器手机  蓝牙拨号  直板键盘 学生手机 儿童手机 蓝牙手机 货到付款 质保一年\",\"price\":16900,\"image\":\"http://image.taotao.com/jd/896692a43f7344ed8217ec19834d8589.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/896692a43f7344ed8217ec19834d8589.jpg\"]},{\"id\":\"1417460430\",\"title\":\"友信达Q100 迷你<em stype=\\\"color:red\\\">手机</em> 移动联通2G 黑\",\"sell_point\":\"万能遥控器手机  蓝牙拨号  直板键盘 学生手机 儿童手机 蓝牙手机 货到付款 质保一年\",\"price\":16900,\"image\":\"http://image.taotao.com/jd/ec71973d5b4e4c7dbee468ff75d76c16.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/ec71973d5b4e4c7dbee468ff75d76c16.jpg\"]},{\"id\":\"1447753884\",\"title\":\"比酷（Coobe） A560小精灵 电信2G老人<em stype=\\\"color:red\\\">���机</em> 心醉红\",\"sell_point\":\"电信版手机 CDMA手机 超长待机老人机老年人专用手机男 女大字体大按键大音量键盘直板手机\",\"price\":13900,\"image\":\"http://image.taotao.com/jd/dc7bb80a47ec4325ba1b0798fce9cfb8.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/dc7bb80a47ec4325ba1b0798fce9cfb8.jpg\"]},{\"id\":\"1248359276\",\"title\":\"大显(DaXian) JL555 电信2G老人<em stype=\\\"color:red\\\">手机</em> 红色\",\"sell_point\":\"【京东直发】电信老人手机 一键拨号 手电筒 音乐收音机\",\"price\":13600,\"image\":\"http://image.taotao.com/jd/b1be952ac8344e7096421c02b2b00822.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/b1be952ac8344e7096421c02b2b00822.jpg\"]},{\"id\":\"1248359277\",\"title\":\"大显(DaXian) JL555 电信2G老人<em stype=\\\"color:red\\\">手机</em> 白色\",\"sell_point\":\"【京东直发】电信老人手机 一键拨号 手电筒 音乐收音机\",\"price\":13600,\"image\":\"http://image.taotao.com/jd/9b64bf48a967471583098192cc129935.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/9b64bf48a967471583098192cc129935.jpg\"]},{\"id\":\"1248359278\",\"title\":\"大显(DaXian) JL555 电信2G老人<em stype=\\\"color:red\\\">手机</em> 黑色\",\"sell_point\":\"【京东直发】电信老人手机 一键拨号 手电筒 音乐收音机\",\"price\":13600,\"image\":\"http://image.taotao.com/jd/2ab0bb55cfd4499cb59c3c4396689c47.jpg\",\"category_name\":\"手机\",\"item_desc\":null,\"images\":[\"http://image.taotao.com/jd/2ab0bb55cfd4499cb59c3c4396689c47.jpg\"]}],\"recordCount\":2707,\"pageCount\":45,\"currentPage\":1}}";

	public static void main(String[] args) {
		TestKklResult toPojo = TestKklResult.formatToPojo(jsonStr, TestSearchResult.class);
		System.out.println(toPojo.getStatus());
		TestSearchResult result = (TestSearchResult) toPojo.getData();
		System.out.println(result.getCurrentPage());
		System.out.println(result.getPageCount());
		System.out.println(result.getRecordCount());
	}
}
//@JsonIgnoreProperties(ignoreUnknown = true) 
class TestItem{
private String id;
	
	private String title;
	
	private String sell_point;
	
	private long price;
	
	private String image;
	
	private String category_name;
	
	private String item_desc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSell_point() {
		return sell_point;
	}

	public void setSell_point(String sell_point) {
		this.sell_point = sell_point;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	
	public String[] getImages() {
		if (image!=null && !StringUtils.isBlank(image)) {
			String[] images = image.split(",");
			return images;
		}
		return null;
	}
	
}
class TestSearchResult{
private List<TestItem> itemList;
	
	private long recordCount;
	
	private long pageCount;
	
	private long currentPage;

	public List<TestItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<TestItem> itemList) {
		this.itemList = itemList;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	
}

class TestKklResult {
	/**
	 * network transmit
	 */
	private static final long serialVersionUID = -5927924481595404184L;

	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	// 响应业务状态
	private Integer status;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;

	public static TestKklResult build(Integer status, String msg, Object data) {
		return new TestKklResult(status, msg, data);
	}

	public static TestKklResult ok(Object data) {
		return new TestKklResult(data);
	}

	public static TestKklResult repeat(Object data) {
		return build(000, "data repeat", data);
	}

	public static TestKklResult ok() {
		return new TestKklResult(null);
	}

	public static TestKklResult repeat() {
		return repeat(null);
	}

	public TestKklResult() {

	}

	public static TestKklResult build(Integer status, String msg) {
		return new TestKklResult(status, msg, null);
	}

	public TestKklResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public TestKklResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	// public Boolean isOK() {
	// return this.status == 200;
	// }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 将json结果集转化为KklResult对象
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            KklResult中的object类型
	 * @return
	 */
	public static TestKklResult formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, TestKklResult.class);
			}
			MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 * 
	 * @param json
	 * @return
	 */
	public static TestKklResult format(String json) {
		try {
			return MAPPER.readValue(json, TestKklResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 * 
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            集合中的类型
	 * @return
	 */
	public static TestKklResult formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

}