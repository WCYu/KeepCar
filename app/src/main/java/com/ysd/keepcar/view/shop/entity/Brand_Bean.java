package com.ysd.keepcar.view.shop.entity;

import java.util.List;

//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//
public class Brand_Bean {


    /**
     * code : 200
     * msg : 查询成功
     * data : [{"initKey":"A","key":null,"value":null,"price":null,"brandList":[{"key":"219","k":"A","value":"一汽-大众奥迪","logo":"/upload/static/carbrand/1.png"},{"key":"228","k":"A","value":"进口奥迪","logo":"/upload/static/carbrand/1.png"},{"key":"255","k":"A","value":"进口Audi Sport","logo":"/upload/static/carbrand/1.png"},{"key":"40000","k":"A","value":"一汽-大众奥迪新能源","logo":"/upload/static/carbrand/1.png"},{"key":"40002","k":"A","value":"进口奥迪新能源","logo":"/upload/static/carbrand/1.png"},{"key":"259","k":"A","value":"进口阿斯顿·马丁","logo":"/upload/static/carbrand/2.png"},{"key":"271","k":"A","value":"进口阿尔法·罗密欧","logo":"/upload/static/carbrand/3.png"},{"key":"277","k":"A","value":"进口AC Schnitzer","logo":"/upload/static/carbrand/4.png"},{"key":"282","k":"A","value":"进口Artega","logo":"/upload/static/carbrand/5.png"},{"key":"284","k":"A","value":"奥克斯","logo":"/upload/static/carbrand/6.png"},{"key":"33848","k":"A","value":"进口阿尔特","logo":"/upload/static/carbrand/33690.png"},{"key":"33875","k":"A","value":"进口ALPINA","logo":"/upload/static/carbrand/33702.png"}]},{"initKey":"B","key":null,"value":null,"price":null,"brandList":[{"key":"287","k":"B","value":"东风本田","logo":"/upload/static/carbrand/7.png"},{"key":"296","k":"B","value":"广汽本田","logo":"/upload/static/carbrand/7.png"},{"key":"306","k":"B","value":"进口本田","logo":"/upload/static/carbrand/7.png"},{"key":"320","k":"B","value":"上汽通用别克","logo":"/upload/static/carbrand/8.png"},{"key":"337","k":"B","value":"进口别克","logo":"/upload/static/carbrand/8.png"},{"key":"341","k":"B","value":"北京奔驰","logo":"/upload/static/carbrand/9.png"},{"key":"347","k":"B","value":"福建奔驰","logo":"/upload/static/carbrand/9.png"},{"key":"352","k":"B","value":"进口奔驰","logo":"/upload/static/carbrand/9.png"},{"key":"383","k":"B","value":"进口梅赛德斯-AMG","logo":"/upload/static/carbrand/9.png"},{"key":"402","k":"B","value":"进口梅赛德斯-迈巴赫","logo":"/upload/static/carbrand/9.png"},{"key":"40013","k":"B","value":"进口奔驰新能源","logo":"/upload/static/carbrand/9.png"},{"key":"404","k":"B","value":"华晨宝马","logo":"/upload/static/carbrand/10.png"},{"key":"409","k":"B","value":"进口宝马","logo":"/upload/static/carbrand/10.png"},{"key":"433","k":"B","value":"进口宝马M","logo":"/upload/static/carbrand/10.png"},{"key":"40015","k":"B","value":"华晨宝马新能源","logo":"/upload/static/carbrand/10.png"},{"key":"40020","k":"B","value":"进口宝马新能源","logo":"/upload/static/carbrand/10.png"},{"key":"442","k":"B","value":"比亚迪","logo":"/upload/static/carbrand/11.png"},{"key":"40024","k":"B","value":"比亚迪新能源","logo":"/upload/static/carbrand/11.png"},{"key":"468","k":"B","value":"上汽通用五菱","logo":"/upload/static/carbrand/12.png"},{"key":"476","k":"B","value":"东风标致","logo":"/upload/static/carbrand/13.png"},{"key":"489","k":"B","value":"广州标致","logo":"/upload/static/carbrand/13.png"},{"key":"491","k":"B","value":"进口标致","logo":"/upload/static/carbrand/13.png"},{"key":"515","k":"B","value":"北汽幻速","logo":"/upload/static/carbrand/14.png"},{"key":"523","k":"B","value":"进口保时捷","logo":"/upload/static/carbrand/15.png"},{"key":"40031","k":"B","value":"进口保时捷新能源","logo":"/upload/static/carbrand/15.png"},{"key":"531","k":"B","value":"北汽绅宝","logo":"/upload/static/carbrand/16.png"},{"key":"544","k":"B","value":"一汽奔腾","logo":"/upload/static/carbrand/17.png"},{"key":"550","k":"B","value":"北京汽车","logo":"/upload/static/carbrand/18.png"},{"key":"558","k":"B","value":"北汽威旺","logo":"/upload/static/carbrand/19.png"},{"key":"566","k":"B","value":"北汽制造","logo":"/upload/static/carbrand/20.png"},{"key":"581","k":"B","value":"进口宾利","logo":"/upload/static/carbrand/21.png"},{"key":"589","k":"B","value":"进口布加迪","logo":"/upload/static/carbrand/22.png"},{"key":"592","k":"B","value":"进口巴博斯","logo":"/upload/static/carbrand/23.png"},{"key":"600","k":"B","value":"宝沃汽车","logo":"/upload/static/carbrand/24.png"},{"key":"605","k":"B","value":"北汽新能源","logo":"/upload/static/carbrand/25.png"},{"key":"611","k":"B","value":"进口保斐利","logo":"/upload/static/carbrand/26.png"},{"key":"613","k":"B","value":"宝龙","logo":"/upload/static/carbrand/27.png"},{"key":"33850","k":"B","value":"比速汽车","logo":"/upload/static/carbrand/33691.png"},{"key":"33853","k":"B","value":"道达","logo":"/upload/static/carbrand/33692.png"},{"key":"40172","k":"B","value":"北汽瑞丽","logo":"/upload/static/carbrand/39989.png"}]},{"initKey":"C","key":null,"value":null,"price":null,"brandList":[{"key":"619","k":"C","value":"长安乘用车","logo":"/upload/static/carbrand/28.png"},{"key":"40035","k":"C","value":"长安新能源","logo":"/upload/static/carbrand/28.png"},{"key":"645","k":"C","value":"长安汽车","logo":"/upload/static/carbrand/29.png"},{"key":"664","k":"C","value":"长城汽车","logo":"/upload/static/carbrand/30.png"},{"key":"40040","k":"C","value":"长城新能源","logo":"/upload/static/carbrand/30.png"},{"key":"687","k":"C","value":"昌河汽车","logo":"/upload/static/carbrand/31.png"},{"key":"40041","k":"C","value":"昌河新能源","logo":"/upload/static/carbrand/31.png"},{"key":"710","k":"C","value":"成功汽车","logo":"/upload/static/carbrand/34.png"},{"key":"716","k":"C","value":"长久汽车","logo":"/upload/static/carbrand/35.png"},{"key":"638","k":"C","value":"长安轻型车","logo":"/upload/static/carbrand/39990.png"},{"key":"700","k":"C","value":"长安跨越","logo":"/upload/static/carbrand/39991.png"},{"key":"40176","k":"C","value":"长江汽车","logo":"/upload/static/carbrand/39992.png"}]},{"initKey":"Q","key":null,"value":null,"price":null,"brandList":[{"key":"708","k":"Q","value":"长城华冠","logo":"/upload/static/carbrand/33.png"},{"key":"1893","k":"Q","value":"东风悦达起亚","logo":"/upload/static/carbrand/149.png"},{"key":"1914","k":"Q","value":"进口起亚","logo":"/upload/static/carbrand/149.png"},{"key":"1933","k":"Q","value":"奇瑞汽车","logo":"/upload/static/carbrand/150.png"},{"key":"40117","k":"Q","value":"奇瑞新能源","logo":"/upload/static/carbrand/150.png"},{"key":"1966","k":"Q","value":"东风启辰","logo":"/upload/static/carbrand/151.png"},{"key":"40123","k":"Q","value":"启辰新能源","logo":"/upload/static/carbrand/151.png"},{"key":"1975","k":"Q","value":"庆铃汽车","logo":"/upload/static/carbrand/152.png"},{"key":"1982","k":"Q","value":"进口乔治·巴顿","logo":"/upload/static/carbrand/153.png"},{"key":"41217","k":"Q","value":"奇点汽车","logo":"/upload/static/carbrand/41212.png"}]},{"initKey":"D","key":null,"value":null,"price":null,"brandList":[{"key":"718","k":"D","value":"上汽大众","logo":"/upload/static/carbrand/36.png"},{"key":"739","k":"D","value":"一汽-大众","logo":"/upload/static/carbrand/36.png"},{"key":"750","k":"D","value":"进口大众","logo":"/upload/static/carbrand/36.png"},{"key":"780","k":"D","value":"东风风行","logo":"/upload/static/carbrand/37.png"},{"key":"792","k":"D","value":"东风风神","logo":"/upload/static/carbrand/38.png"},{"key":"40045","k":"D","value":"东风风神新能源","logo":"/upload/static/carbrand/38.png"},{"key":"803","k":"D","value":"东南汽车","logo":"/upload/static/carbrand/39.png"},{"key":"814","k":"D","value":"东风风光","logo":"/upload/static/carbrand/40.png"},{"key":"819","k":"D","value":"东南道奇","logo":"/upload/static/carbrand/41.png"},{"key":"821","k":"D","value":"进口道奇","logo":"/upload/static/carbrand/41.png"},{"key":"833","k":"D","value":"长安标致雪铁龙","logo":"/upload/static/carbrand/42.png"},{"key":"838","k":"D","value":"进口DS","logo":"/upload/static/carbrand/42.png"},{"key":"842","k":"D","value":"东风小康","logo":"/upload/static/carbrand/43.png"},{"key":"882","k":"D","value":"东风风度","logo":"/upload/static/carbrand/46.png"},{"key":"860","k":"D","value":"郑州日产","logo":"/upload/static/carbrand/47.png"},{"key":"867","k":"D","value":"东风御风","logo":"/upload/static/carbrand/47.png"},{"key":"884","k":"D","value":"东风汽车","logo":"/upload/static/carbrand/47.png"},{"key":"889","k":"D","value":"东风校车系列","logo":"/upload/static/carbrand/47.png"},{"key":"891","k":"D","value":"进口大宇","logo":"/upload/static/carbrand/49.png"},{"key":"899","k":"D","value":"大迪","logo":"/upload/static/carbrand/50.png"},{"key":"33855","k":"D","value":"东风风诺","logo":"/upload/static/carbrand/33693.png"}]},{"initKey":"F","key":null,"value":null,"price":null,"brandList":[{"key":"908","k":"F","value":"广汽丰田","logo":"/upload/static/carbrand/51.png"},{"key":"917","k":"F","value":"一汽丰田","logo":"/upload/static/carbrand/51.png"},{"key":"931","k":"F","value":"进口丰田","logo":"/upload/static/carbrand/51.png"},{"key":"960","k":"F","value":"长安福特","logo":"/upload/static/carbrand/52.png"},{"key":"974","k":"F","value":"江铃福特","logo":"/upload/static/carbrand/52.png"},{"key":"977","k":"F","value":"进口福特","logo":"/upload/static/carbrand/52.png"},{"key":"997","k":"F","value":"福田汽车","logo":"/upload/static/carbrand/53.png"},{"key":"1030","k":"F","value":"欧辉","logo":"/upload/static/carbrand/53.png"},{"key":"40051","k":"F","value":"福田商用车","logo":"/upload/static/carbrand/53.png"},{"key":"1034","k":"F","value":"进口法拉利","logo":"/upload/static/carbrand/54.png"},{"key":"1048","k":"F","value":"广汽菲克菲亚特","logo":"/upload/static/carbrand/55.png"},{"key":"1051","k":"F","value":"南京菲亚特","logo":"/upload/static/carbrand/55.png"},{"key":"1056","k":"F","value":"进口菲亚特","logo":"/upload/static/carbrand/55.png"},{"key":"1073","k":"F","value":"进口海酷","logo":"/upload/static/carbrand/55.png"},{"key":"1075","k":"F","value":"福迪","logo":"/upload/static/carbrand/56.png"},{"key":"1088","k":"F","value":"福汽启腾","logo":"/upload/static/carbrand/57.png"},{"key":"40054","k":"F","value":"福汽启腾新能源","logo":"/upload/static/carbrand/57.png"},{"key":"1091","k":"F","value":"飞驰商务车","logo":"/upload/static/carbrand/58.png"},{"key":"1094","k":"F","value":"进口Faralli Mazzanti","logo":"/upload/static/carbrand/59.png"},{"key":"1096","k":"F","value":"进口菲斯克","logo":"/upload/static/carbrand/60.png"},{"key":"1098","k":"F","value":"华翔富奇","logo":"/upload/static/carbrand/61.png"},{"key":"1103","k":"F","value":"福达","logo":"/upload/static/carbrand/62.png"},{"key":"40179","k":"F","value":"进口Faraday Future","logo":"/upload/static/carbrand/39993.png"}]},{"initKey":"G","key":null,"value":null,"price":null,"brandList":[{"key":"1105","k":"G","value":"广汽传祺","logo":"/upload/static/carbrand/63.png"},{"key":"40056","k":"G","value":"广汽传祺新能源","logo":"/upload/static/carbrand/63.png"},{"key":"1115","k":"G","value":"观致汽车","logo":"/upload/static/carbrand/64.png"},{"key":"1121","k":"G","value":"广汽吉奥","logo":"/upload/static/carbrand/65.png"},{"key":"1149","k":"G","value":"进口GMC","logo":"/upload/static/carbrand/66.png"},{"key":"1157","k":"G","value":"进口光冈","logo":"/upload/static/carbrand/68.png"},{"key":"1161","k":"G","value":"进口GTA","logo":"/upload/static/carbrand/69.png"},{"key":"1163","k":"G","value":"广汽日野","logo":"/upload/static/carbrand/70.png"}]},{"initKey":"H","key":null,"value":null,"price":null,"brandList":[{"key":"1167","k":"H","value":"长城汽车","logo":"/upload/static/carbrand/71.png"},{"key":"1179","k":"H","value":"一汽海马","logo":"/upload/static/carbrand/72.png"},{"key":"1193","k":"H","value":"郑州海马","logo":"/upload/static/carbrand/72.png"},{"key":"40064","k":"H","value":"海马新能源","logo":"/upload/static/carbrand/72.png"},{"key":"1197","k":"H","value":"一汽红旗","logo":"/upload/static/carbrand/73.png"},{"key":"1206","k":"H","value":"华泰汽车","logo":"/upload/static/carbrand/74.png"},{"key":"1273","k":"H","value":"华泰新能源","logo":"/upload/static/carbrand/74.png"},{"key":"1214","k":"H","value":"进口悍马","logo":"/upload/static/carbrand/75.png"},{"key":"1222","k":"H","value":"曙光汽车","logo":"/upload/static/carbrand/76.png"},{"key":"1242","k":"H","value":"哈飞汽车","logo":"/upload/static/carbrand/77.png"},{"key":"1262","k":"H","value":"郑州海马商用车","logo":"/upload/static/carbrand/78.png"},{"key":"1271","k":"H","value":"华晨华颂","logo":"/upload/static/carbrand/79.png"},{"key":"1276","k":"H","value":"海格汽车","logo":"/upload/static/carbrand/81.png"},{"key":"1282","k":"H","value":"上海汇众","logo":"/upload/static/carbrand/82.png"},{"key":"1285","k":"H","value":"华普","logo":"/upload/static/carbrand/83.png"},{"key":"1297","k":"H","value":"恒天汽车","logo":"/upload/static/carbrand/84.png"},{"key":"1301","k":"H","value":"富桑黑豹","logo":"/upload/static/carbrand/85.png"},{"key":"1305","k":"H","value":"汉江","logo":"/upload/static/carbrand/86.png"},{"key":"1307","k":"H","value":"航天圆通","logo":"/upload/static/carbrand/87.png"},{"key":"1309","k":"H","value":"华阳","logo":"/upload/static/carbrand/88.png"},{"key":"33857","k":"H","value":"汉腾","logo":"/upload/static/carbrand/33694.png"},{"key":"33860","k":"H","value":"明君华凯","logo":"/upload/static/carbrand/33695.png"}]},{"initKey":"J","key":null,"value":null,"price":null,"brandList":[{"key":"1311","k":"J","value":"吉利汽车","logo":"/upload/static/carbrand/89.png"},{"key":"40075","k":"J","value":"吉利新能源","logo":"/upload/static/carbrand/89.png"},{"key":"1347","k":"J","value":"江淮乘用车","logo":"/upload/static/carbrand/90.png"},{"key":"1375","k":"J","value":"江淮安驰","logo":"/upload/static/carbrand/90.png"},{"key":"40076","k":"J","value":"江淮新能源","logo":"/upload/static/carbrand/90.png"},{"key":"1384","k":"J","value":"北京吉普","logo":"/upload/static/carbrand/91.png"},{"key":"1386","k":"J","value":"北京吉普切诺基","logo":"/upload/static/carbrand/91.png"},{"key":"1389","k":"J","value":"广汽菲克Jeep","logo":"/upload/static/carbrand/91.png"},{"key":"1392","k":"J","value":"进口Jeep","logo":"/upload/static/carbrand/91.png"},{"key":"1401","k":"J","value":"进口捷豹","logo":"/upload/static/carbrand/92.png"},{"key":"33776","k":"J","value":"奇瑞捷豹路虎","logo":"/upload/static/carbrand/92.png"},{"key":"1413","k":"J","value":"江铃汽车","logo":"/upload/static/carbrand/93.png"},{"key":"1464","k":"J","value":"江铃轻汽","logo":"/upload/static/carbrand/93.png"},{"key":"40082","k":"J","value":"江铃旅居车","logo":"/upload/static/carbrand/93.png"},{"key":"40092","k":"J","value":"江铃新能源","logo":"/upload/static/carbrand/93.png"},{"key":"1427","k":"J","value":"华晨金杯","logo":"/upload/static/carbrand/94.png"},{"key":"1436","k":"J","value":"华晨鑫源金杯","logo":"/upload/static/carbrand/94.png"},{"key":"1446","k":"J","value":"绵阳金杯","logo":"/upload/static/carbrand/94.png"},{"key":"1454","k":"J","value":"厦门金龙","logo":"/upload/static/carbrand/95.png"},{"key":"1459","k":"J","value":"九龙","logo":"/upload/static/carbrand/96.png"},{"key":"1468","k":"J","value":"金旅客车","logo":"/upload/static/carbrand/98.png"},{"key":"1472","k":"J","value":"江南","logo":"/upload/static/carbrand/99.png"},{"key":"1477","k":"J","value":"金程","logo":"/upload/static/carbrand/100.png"},{"key":"1483","k":"J","value":"吉林江北","logo":"/upload/static/carbrand/101.png"},{"key":"40181","k":"J","value":"吉威新能源","logo":"/upload/static/carbrand/39994.png"},{"key":"40185","k":"J","value":"众泰汽车","logo":"/upload/static/carbrand/39995.png"}]},{"initKey":"K","key":null,"value":null,"price":null,"brandList":[{"key":"1485","k":"K","value":"上汽通用凯迪拉克","logo":"/upload/static/carbrand/102.png"},{"key":"1490","k":"K","value":"进口凯迪拉克","logo":"/upload/static/carbrand/102.png"},{"key":"40100","k":"K","value":"进口上汽通用凯迪拉克新能源","logo":"/upload/static/carbrand/102.png"},{"key":"1506","k":"K","value":"开瑞","logo":"/upload/static/carbrand/103.png"},{"key":"1518","k":"K","value":"北京克莱斯勒","logo":"/upload/static/carbrand/104.png"},{"key":"1521","k":"K","value":"东南汽车","logo":"/upload/static/carbrand/104.png"},{"key":"1523","k":"K","value":"进口克莱斯勒","logo":"/upload/static/carbrand/104.png"},{"key":"1536","k":"K","value":"凯翼","logo":"/upload/static/carbrand/105.png"},{"key":"1541","k":"K","value":"卡威汽车","logo":"/upload/static/carbrand/106.png"},{"key":"1545","k":"K","value":"进口科尼赛克","logo":"/upload/static/carbrand/107.png"},{"key":"1548","k":"K","value":"科瑞斯的","logo":"/upload/static/carbrand/108.png"},{"key":"1552","k":"K","value":"康迪全球鹰","logo":"/upload/static/carbrand/109.png"},{"key":"1555","k":"K","value":"进口卡尔森","logo":"/upload/static/carbrand/110.png"},{"key":"1559","k":"K","value":"KTM","logo":"/upload/static/carbrand/111.png"},{"key":"2552","k":"K","value":"浙江卡尔森","logo":"/upload/static/carbrand/213.png"}]},{"initKey":"L","key":null,"value":null,"price":null,"brandList":[{"key":"1561","k":"L","value":"陆风汽车","logo":"/upload/static/carbrand/112.png"},{"key":"1570","k":"L","value":"长安铃木","logo":"/upload/static/carbrand/113.png"},{"key":"1581","k":"L","value":"昌河铃木","logo":"/upload/static/carbrand/113.png"},{"key":"1590","k":"L","value":"西安奥拓","logo":"/upload/static/carbrand/113.png"},{"key":"1592","k":"L","value":"进口铃木","logo":"/upload/static/carbrand/113.png"},{"key":"1600","k":"L","value":"奇瑞捷豹路虎","logo":"/upload/static/carbrand/114.png"},{"key":"1603","k":"L","value":"进口路虎","logo":"/upload/static/carbrand/114.png"},{"key":"1611","k":"L","value":"进口雷克萨斯","logo":"/upload/static/carbrand/115.png"},{"key":"1625","k":"L","value":"进口雷克萨斯F","logo":"/upload/static/carbrand/115.png"},{"key":"1628","k":"L","value":"猎豹皮卡","logo":"/upload/static/carbrand/116.png"},{"key":"1638","k":"L","value":"猎豹汽车","logo":"/upload/static/carbrand/116.png"},{"key":"1651","k":"L","value":"东风雷诺","logo":"/upload/static/carbrand/117.png"},{"key":"1653","k":"L","value":"进口雷诺","logo":"/upload/static/carbrand/117.png"},{"key":"1666","k":"L","value":"进口林肯汽车","logo":"/upload/static/carbrand/118.png"},{"key":"1678","k":"L","value":"进口兰博基尼","logo":"/upload/static/carbrand/119.png"},{"key":"1684","k":"L","value":"力帆","logo":"/upload/static/carbrand/120.png"},{"key":"40107","k":"L","value":"力帆新能源","logo":"/upload/static/carbrand/120.png"},{"key":"1701","k":"L","value":"进口劳斯莱斯","logo":"/upload/static/carbrand/121.png"},{"key":"1708","k":"L","value":"莲花","logo":"/upload/static/carbrand/122.png"},{"key":"1718","k":"L","value":"进口莲花(进口)","logo":"/upload/static/carbrand/122.png"},{"key":"1721","k":"L","value":"蓝海房车","logo":"/upload/static/carbrand/123.png"},{"key":"1724","k":"L","value":"进口路特斯","logo":"/upload/static/carbrand/124.png"},{"key":"1729","k":"L","value":"广汽理念","logo":"/upload/static/carbrand/125.png"},{"key":"1731","k":"L","value":"雷丁电动汽车","logo":"/upload/static/carbrand/126.png"},{"key":"1736","k":"L","value":"陆地方舟","logo":"/upload/static/carbrand/127.png"},{"key":"1741","k":"L","value":"领志","logo":"/upload/static/carbrand/128.png"},{"key":"1743","k":"L","value":"朗世","logo":"/upload/static/carbrand/129.png"},{"key":"1745","k":"L","value":"进口罗孚","logo":"/upload/static/carbrand/130.png"},{"key":"33862","k":"L","value":"LeSEE","logo":"/upload/static/carbrand/33696.png"},{"key":"40187","k":"L","value":"领克汽车","logo":"/upload/static/carbrand/39996.png"},{"key":"40189","k":"L","value":"进口罗伦士","logo":"/upload/static/carbrand/39997.png"}]},{"initKey":"M","key":null,"value":null,"price":null,"brandList":[{"key":"1748","k":"M","value":"长安马自达","logo":"/upload/static/carbrand/131.png"},{"key":"1757","k":"M","value":"一汽马自达","logo":"/upload/static/carbrand/131.png"},{"key":"1767","k":"M","value":"进口马自达","logo":"/upload/static/carbrand/131.png"},{"key":"1783","k":"M","value":"上汽名爵","logo":"/upload/static/carbrand/132.png"},{"key":"1793","k":"M","value":"进口玛莎拉蒂","logo":"/upload/static/carbrand/133.png"},{"key":"1802","k":"M","value":"进口MINI","logo":"/upload/static/carbrand/134.png"},{"key":"1811","k":"M","value":"进口MINI JCW","logo":"/upload/static/carbrand/134.png"},{"key":"1817","k":"M","value":"进口迈凯伦","logo":"/upload/static/carbrand/135.png"},{"key":"1825","k":"M","value":"进口迈巴赫","logo":"/upload/static/carbrand/136.png"},{"key":"1830","k":"M","value":"进口摩根","logo":"/upload/static/carbrand/137.png"},{"key":"1838","k":"M","value":"美亚","logo":"/upload/static/carbrand/138.png"}]},{"initKey":"N","key":null,"value":null,"price":null,"brandList":[{"key":"1845","k":"N","value":"东风裕隆","logo":"/upload/static/carbrand/139.png"},{"key":"1852","k":"N","value":"进口Noble","logo":"/upload/static/carbrand/140.png"}]},{"initKey":"O","key":null,"value":null,"price":null,"brandList":[{"key":"1854","k":"O","value":"进口讴歌","logo":"/upload/static/carbrand/141.png"},{"key":"33801","k":"O","value":"广汽讴歌","logo":"/upload/static/carbrand/141.png"},{"key":"1864","k":"O","value":"一汽欧朗","logo":"/upload/static/carbrand/142.png"},{"key":"1867","k":"O","value":"进口欧宝","logo":"/upload/static/carbrand/143.png"},{"key":"1880","k":"O","value":"欧联","logo":"/upload/static/carbrand/144.png"}]},{"initKey":"P","key":null,"value":null,"price":null,"brandList":[{"key":"1882","k":"P","value":"进口帕加尼","logo":"/upload/static/carbrand/145.png"},{"key":"1885","k":"P","value":"进口皮特比尔特","logo":"/upload/static/carbrand/146.png"},{"key":"1887","k":"P","value":"进口PGO","logo":"/upload/static/carbrand/147.png"},{"key":"1891","k":"P","value":"进口旁蒂克","logo":"/upload/static/carbrand/148.png"}]},{"initKey":"R","key":null,"value":null,"price":null,"brandList":[{"key":"1984","k":"R","value":"东风日产","logo":"/upload/static/carbrand/154.png"},{"key":"1998","k":"R","value":"郑州日产","logo":"/upload/static/carbrand/154.png"},{"key":"2006","k":"R","value":"进口日产","logo":"/upload/static/carbrand/154.png"},{"key":"2026","k":"R","value":"上汽荣威","logo":"/upload/static/carbrand/155.png"},{"key":"40128","k":"R","value":"上汽新能源","logo":"/upload/static/carbrand/155.png"},{"key":"2036","k":"R","value":"奇瑞汽车","logo":"/upload/static/carbrand/156.png"}]},{"initKey":"S","key":null,"value":null,"price":null,"brandList":[{"key":"2044","k":"S","value":"上汽大众斯柯达","logo":"/upload/static/carbrand/157.png"},{"key":"2053","k":"S","value":"进口斯柯达","logo":"/upload/static/carbrand/157.png"},{"key":"2061","k":"S","value":"北京吉普","logo":"/upload/static/carbrand/158.png"},{"key":"2064","k":"S","value":"东南三菱","logo":"/upload/static/carbrand/158.png"},{"key":"2071","k":"S","value":"广汽三菱","logo":"/upload/static/carbrand/158.png"},{"key":"2075","k":"S","value":"进口三菱","logo":"/upload/static/carbrand/158.png"},{"key":"2087","k":"S","value":"进口斯巴鲁","logo":"/upload/static/carbrand/159.png"},{"key":"2097","k":"S","value":"上汽大通","logo":"/upload/static/carbrand/160.png"},{"key":"40132","k":"S","value":"上汽大通新能源","logo":"/upload/static/carbrand/160.png"},{"key":"2102","k":"S","value":"进口双龙","logo":"/upload/static/carbrand/161.png"},{"key":"2113","k":"S","value":"进口smart","logo":"/upload/static/carbrand/162.png"},{"key":"40133","k":"S","value":"进口smart新能源","logo":"/upload/static/carbrand/162.png"},{"key":"2119","k":"S","value":"进口山姆","logo":"/upload/static/carbrand/163.png"},{"key":"2123","k":"S","value":"进口STARTECH","logo":"/upload/static/carbrand/164.png"},{"key":"2128","k":"S","value":"进口赛麟","logo":"/upload/static/carbrand/165.png"},{"key":"2135","k":"S","value":"进口世爵","logo":"/upload/static/carbrand/166.png"},{"key":"2137","k":"S","value":"双环","logo":"/upload/static/carbrand/167.png"},{"key":"2142","k":"S","value":"进口萨博","logo":"/upload/static/carbrand/168.png"},{"key":"2146","k":"S","value":"通家","logo":"/upload/static/carbrand/169.png"},{"key":"2150","k":"S","value":"广东三星","logo":"/upload/static/carbrand/170.png"},{"key":"2152","k":"S","value":"上喆汽车","logo":"/upload/static/carbrand/171.png"},{"key":"2154","k":"S","value":"顺旅汽车","logo":"/upload/static/carbrand/172.png"},{"key":"33864","k":"S","value":"SWM斯威汽车","logo":"/upload/static/carbrand/33697.png"}]},{"initKey":"T","key":null,"value":null,"price":null,"brandList":[{"key":"2156","k":"T","value":"进口特斯拉","logo":"/upload/static/carbrand/173.png"},{"key":"2160","k":"T","value":"进口泰卡特","logo":"/upload/static/carbrand/174.png"},{"key":"2166","k":"T","value":"腾势汽车","logo":"/upload/static/carbrand/175.png"},{"key":"2168","k":"T","value":"天马汽车","logo":"/upload/static/carbrand/176.png"},{"key":"2176","k":"T","value":"通田","logo":"/upload/static/carbrand/177.png"},{"key":"2178","k":"T","value":"塔菲克","logo":"/upload/static/carbrand/178.png"}]},{"initKey":"W","key":null,"value":null,"price":null,"brandList":[{"key":"2180","k":"W","value":"上汽通用五菱","logo":"/upload/static/carbrand/179.png"},{"key":"2196","k":"W","value":"长安沃尔沃","logo":"/upload/static/carbrand/180.png"},{"key":"2199","k":"W","value":"沃尔沃亚太","logo":"/upload/static/carbrand/180.png"},{"key":"2203","k":"W","value":"进口沃尔沃","logo":"/upload/static/carbrand/180.png"},{"key":"40138","k":"W","value":"沃尔沃亚太新能源","logo":"/upload/static/carbrand/180.png"},{"key":"40140","k":"W","value":"进口沃尔沃新能源","logo":"/upload/static/carbrand/180.png"},{"key":"2220","k":"W","value":"江西五十铃","logo":"/upload/static/carbrand/181.png"},{"key":"2224","k":"W","value":"进口五十铃","logo":"/upload/static/carbrand/181.png"},{"key":"2228","k":"W","value":"潍柴英致","logo":"/upload/static/carbrand/182.png"},{"key":"2232","k":"W","value":"威麟","logo":"/upload/static/carbrand/183.png"},{"key":"2237","k":"W","value":"进口威兹曼","logo":"/upload/static/carbrand/184.png"},{"key":"2240","k":"W","value":"潍柴欧睿","logo":"/upload/static/carbrand/185.png"},{"key":"2242","k":"W","value":"上海万丰","logo":"/upload/static/carbrand/186.png"},{"key":"33866","k":"W","value":"长城汽车","logo":"/upload/static/carbrand/33698.png"},{"key":"33869","k":"W","value":"蔚来汽车","logo":"/upload/static/carbrand/33699.png"}]},{"initKey":"X","key":null,"value":null,"price":null,"brandList":[{"key":"2247","k":"X","value":"北京现代","logo":"/upload/static/carbrand/187.png"},{"key":"2268","k":"X","value":"四川现代","logo":"/upload/static/carbrand/187.png"},{"key":"2271","k":"X","value":"进口Genesis","logo":"/upload/static/carbrand/187.png"},{"key":"2273","k":"X","value":"进口现代","logo":"/upload/static/carbrand/187.png"},{"key":"40142","k":"X","value":"北京现代新能源","logo":"/upload/static/carbrand/187.png"},{"key":"2294","k":"X","value":"上汽通用雪佛兰","logo":"/upload/static/carbrand/188.png"},{"key":"2313","k":"X","value":"进口雪佛兰","logo":"/upload/static/carbrand/188.png"},{"key":"2326","k":"X","value":"东风雪铁龙","logo":"/upload/static/carbrand/189.png"},{"key":"2341","k":"X","value":"进口雪铁龙","logo":"/upload/static/carbrand/189.png"},{"key":"2348","k":"X","value":"星客特","logo":"/upload/static/carbrand/190.png"},{"key":"2359","k":"X","value":"新凯汽车","logo":"/upload/static/carbrand/191.png"},{"key":"2369","k":"X","value":"进口西雅特","logo":"/upload/static/carbrand/192.png"},{"key":"2373","k":"X","value":"南汽新雅途","logo":"/upload/static/carbrand/193.png"},{"key":"2378","k":"X","value":"大地","logo":"/upload/static/carbrand/194.png"},{"key":"33871","k":"X","value":"小鹏汽车","logo":"/upload/static/carbrand/33700.png"},{"key":"40193","k":"X","value":"星驰汽车","logo":"/upload/static/carbrand/39998.png"}]},{"initKey":"Y","key":null,"value":null,"price":null,"brandList":[{"key":"2381","k":"Y","value":"东风英菲尼迪","logo":"/upload/static/carbrand/195.png"},{"key":"2384","k":"Y","value":"进口英菲尼迪","logo":"/upload/static/carbrand/195.png"},{"key":"2403","k":"Y","value":"天津一汽","logo":"/upload/static/carbrand/196.png"},{"key":"2420","k":"Y","value":"一汽华利","logo":"/upload/static/carbrand/196.png"},{"key":"2422","k":"Y","value":"一汽吉林","logo":"/upload/static/carbrand/196.png"},{"key":"2438","k":"Y","value":"一汽轻型汽车","logo":"/upload/static/carbrand/196.png"},{"key":"2440","k":"Y","value":"一汽通用","logo":"/upload/static/carbrand/196.png"},{"key":"40148","k":"Y","value":"天津一汽新能源","logo":"/upload/static/carbrand/196.png"},{"key":"2442","k":"Y","value":"野马汽车","logo":"/upload/static/carbrand/197.png"},{"key":"40151","k":"Y","value":"野马新能源","logo":"/upload/static/carbrand/197.png"},{"key":"2448","k":"Y","value":"南京依维柯","logo":"/upload/static/carbrand/198.png"},{"key":"2459","k":"Y","value":"永源汽车","logo":"/upload/static/carbrand/199.png"},{"key":"2465","k":"Y","value":"宇通","logo":"/upload/static/carbrand/200.png"},{"key":"2472","k":"Y","value":"御捷","logo":"/upload/static/carbrand/201.png"},{"key":"2475","k":"Y","value":"游侠汽车","logo":"/upload/static/carbrand/202.png"},{"key":"2477","k":"Y","value":"广州云豹","logo":"/upload/static/carbrand/203.png"},{"key":"2479","k":"Y","value":"扬州亚星客车","logo":"/upload/static/carbrand/204.png"},{"key":"2481","k":"Y","value":"贵州云雀","logo":"/upload/static/carbrand/205.png"},{"key":"2483","k":"Y","value":"上汽仪征","logo":"/upload/static/carbrand/206.png"},{"key":"2485","k":"Y","value":"友谊","logo":"/upload/static/carbrand/207.png"},{"key":"33873","k":"Y","value":"江铃驭胜","logo":"/upload/static/carbrand/33701.png"},{"key":"40197","k":"Y","value":"云度新能源","logo":"/upload/static/carbrand/39999.png"}]},{"initKey":"Z","key":null,"value":null,"price":null,"brandList":[{"key":"2487","k":"Z","value":"众泰汽车","logo":"/upload/static/carbrand/208.png"},{"key":"40159","k":"Z","value":"众泰新能源","logo":"/upload/static/carbrand/208.png"},{"key":"2506","k":"Z","value":"华晨中华","logo":"/upload/static/carbrand/209.png"},{"key":"40160","k":"Z","value":"华晨新能源","logo":"/upload/static/carbrand/209.png"},{"key":"2524","k":"Z","value":"知豆","logo":"/upload/static/carbrand/210.png"},{"key":"1154","k":"Z","value":"广汽中兴","logo":"/upload/static/carbrand/211.png"},{"key":"2528","k":"Z","value":"中兴汽车","logo":"/upload/static/carbrand/211.png"},{"key":"2544","k":"Z","value":"中欧房车","logo":"/upload/static/carbrand/212.png"},{"key":"2555","k":"Z","value":"重汽王牌","logo":"/upload/static/carbrand/214.png"},{"key":"2557","k":"Z","value":"华晨宝马","logo":"/upload/static/carbrand/215.png"},{"key":"2559","k":"Z","value":"中通客车","logo":"/upload/static/carbrand/216.png"},{"key":"2561","k":"Z","value":"中顺","logo":"/upload/static/carbrand/217.png"},{"key":"2566","k":"Z","value":"中客华北","logo":"/upload/static/carbrand/218.png"}]}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * initKey : A
         * key : null
         * value : null
         * price : null
         * brandList : [{"key":"219","k":"A","value":"一汽-大众奥迪","logo":"/upload/static/carbrand/1.png"},{"key":"228","k":"A","value":"进口奥迪","logo":"/upload/static/carbrand/1.png"},{"key":"255","k":"A","value":"进口Audi Sport","logo":"/upload/static/carbrand/1.png"},{"key":"40000","k":"A","value":"一汽-大众奥迪新能源","logo":"/upload/static/carbrand/1.png"},{"key":"40002","k":"A","value":"进口奥迪新能源","logo":"/upload/static/carbrand/1.png"},{"key":"259","k":"A","value":"进口阿斯顿·马丁","logo":"/upload/static/carbrand/2.png"},{"key":"271","k":"A","value":"进口阿尔法·罗密欧","logo":"/upload/static/carbrand/3.png"},{"key":"277","k":"A","value":"进口AC Schnitzer","logo":"/upload/static/carbrand/4.png"},{"key":"282","k":"A","value":"进口Artega","logo":"/upload/static/carbrand/5.png"},{"key":"284","k":"A","value":"奥克斯","logo":"/upload/static/carbrand/6.png"},{"key":"33848","k":"A","value":"进口阿尔特","logo":"/upload/static/carbrand/33690.png"},{"key":"33875","k":"A","value":"进口ALPINA","logo":"/upload/static/carbrand/33702.png"}]
         */

        private String initKey;
        private Object key;
        private Object value;
        private Object price;
        private List<BrandListBean> brandList;

        public String getInitKey() {
            return initKey;
        }

        public void setInitKey(String initKey) {
            this.initKey = initKey;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public List<BrandListBean> getBrandList() {
            return brandList;
        }

        public void setBrandList(List<BrandListBean> brandList) {
            this.brandList = brandList;
        }

        public static class BrandListBean {
            /**
             * key : 219
             * k : A
             * value : 一汽-大众奥迪
             * logo : /upload/static/carbrand/1.png
             */

            private String key;
            private String k;
            private String value;
            private String logo;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getK() {
                return k;
            }

            public void setK(String k) {
                this.k = k;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }
        }
    }
}
