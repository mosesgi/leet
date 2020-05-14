package com.moses.leet.n0320;

import java.util.*;

public class MinimumHeightTrees {
    //remove leaves round after round.
    public List<Integer> findMinHeightTreesSolution(int n, int[][] edges) {
        if(n==1){
            return Arrays.asList(0);
        }
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<n; i++){
            map.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int[] edge = edges[i];
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int[] inDegrees = new int[n];
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++){
            inDegrees[i] = map.get(i).size();
            if(inDegrees[i] == 1){
                leaves.add(i);
            }
        }

        int left = n;
        while(left > 2){
            left -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer leaf : leaves){
                int related = map.get(leaf).get(0);
                map.get(related).remove(leaf);
                if(map.get(related).size() == 1){
                    newLeaves.add(related);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0){
            return Arrays.asList(0);
        }
        Set<Integer>[] map = new Set[n];
        for(int[] edge : edges){
            if(map[edge[0]] == null){
                map[edge[0]] = new HashSet<>();
            }
            if(map[edge[1]] == null){
                map[edge[1]] = new HashSet<>();
            }
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            res.add(i);
        }

        while(res.size() > 2){
            List<Integer> ones = new ArrayList<>();
            List<Integer> next = new ArrayList<>();
            for(int i: res){
                if(map[i] != null && map[i].size() == 1){
                    ones.add(i);
                }else{
                    next.add(i);
                }
            }
            for(int i : ones){
                int j = map[i].iterator().next();
                map[j].remove(i);
            }
            res = next;
        }
        return res;
    }

    public static void main(String[] args) {
        int n;
        int[][] edges;

//        n = 7;
//        edges = new int[][]{{0,1},{1,2},{1,3},{2,4},{3,5},{4,6}};
//        System.out.println(Arrays.toString(new MinimumHeightTrees().findMinHeightTrees(n, edges).toArray()));
//
//        n=4;
//        edges = new int[][]{
//                {1,0},{1,2}, {1,3}
//        };
//        System.out.println(Arrays.toString(new MinimumHeightTrees().findMinHeightTrees(n, edges).toArray()));

        n=6;
        edges = new int[][]{
                {0,3},{1,3}, {2,3},{4,3},{5,4}
        };
        System.out.println(Arrays.toString(new MinimumHeightTrees().findMinHeightTrees(n, edges).toArray()));

        n=6;
        edges = new int[][]{
                {0,1},{0,2},{0,3},{3,4},{4,5}
        };
        System.out.println(Arrays.toString(new MinimumHeightTrees().findMinHeightTrees(n, edges).toArray()));

        n=2020;     //0,1
        edges = new int[][]{{0,1},{1,2},{2,3},{3,4},{1,5},{3,6},{2,7},{0,8},{2,9},{1,10},{8,11},{9,12},{8,13},{1,14},{12,15},{3,16},{3,17},{4,18},{11,19},{7,20},{11,21},{13,22},{2,23},{13,24},{18,25},{3,26},{16,27},{2,28},{21,29},{28,30},{25,31},{19,32},{18,33},{3,34},{11,35},{21,36},{17,37},{31,38},{7,39},{3,40},{2,41},{3,42},{5,43},{34,44},{16,45},{30,46},{23,47},{16,48},{17,49},{23,50},{12,51},{35,52},{0,53},{13,54},{46,55},{35,56},{13,57},{34,58},{51,59},{58,60},{15,61},{58,62},{50,63},{9,64},{25,65},{12,66},{40,67},{31,68},{2,69},{19,70},{65,71},{71,72},{54,73},{73,74},{33,75},{74,76},{43,77},{5,78},{61,79},{34,80},{45,81},{9,82},{81,83},{60,84},{78,85},{21,86},{59,87},{1,88},{26,89},{63,90},{77,91},{80,92},{49,93},{77,94},{87,95},{1,96},{7,97},{58,98},{48,99},{83,100},{24,101},{58,102},{76,103},{67,104},{96,105},{26,106},{34,107},{15,108},{36,109},{82,110},{105,111},{34,112},{30,113},{99,114},{12,115},{21,116},{24,117},{56,118},{41,119},{34,120},{2,121},{57,122},{6,123},{4,124},{71,125},{27,126},{80,127},{57,128},{3,129},{76,130},{67,131},{47,132},{11,133},{28,134},{32,135},{22,136},{40,137},{53,138},{51,139},{63,140},{123,141},{116,142},{2,143},{69,144},{6,145},{74,146},{60,147},{3,148},{88,149},{14,150},{80,151},{130,152},{83,153},{43,154},{47,155},{42,156},{8,157},{45,158},{121,159},{27,160},{68,161},{38,162},{126,163},{161,164},{144,165},{151,166},{143,167},{65,168},{7,169},{115,170},{47,171},{23,172},{26,173},{99,174},{41,175},{158,176},{35,177},{41,178},{36,179},{87,180},{139,181},{181,182},{143,183},{102,184},{10,185},{37,186},{23,187},{137,188},{4,189},{148,190},{32,191},{167,192},{94,193},{22,194},{151,195},{146,196},{143,197},{141,198},{188,199},{26,200},{6,201},{52,202},{4,203},{167,204},{139,205},{153,206},{98,207},{17,208},{85,209},{88,210},{142,211},{143,212},{46,213},{50,214},{6,215},{1,216},{124,217},{89,218},{75,219},{135,220},{27,221},{158,222},{147,223},{87,224},{40,225},{66,226},{78,227},{38,228},{149,229},{167,230},{154,231},{92,232},{204,233},{153,234},{43,235},{127,236},{151,237},{199,238},{40,239},{35,240},{22,241},{198,242},{158,243},{64,244},{87,245},{53,246},{69,247},{247,248},{111,249},{154,250},{232,251},{166,252},{232,253},{122,254},{215,255},{96,256},{235,257},{196,258},{42,259},{201,260},{105,261},{184,262},{168,263},{36,264},{147,265},{239,266},{146,267},{11,268},{236,269},{121,270},{176,271},{119,272},{32,273},{156,274},{270,275},{226,276},{68,277},{190,278},{144,279},{21,280},{261,281},{113,282},{234,283},{51,284},{127,285},{169,286},{4,287},{117,288},{2,289},{62,290},{143,291},{131,292},{177,293},{161,294},{251,295},{221,296},{123,297},{164,298},{69,299},{75,300},{137,301},{99,302},{4,303},{66,304},{247,305},{262,306},{97,307},{301,308},{159,309},{128,310},{88,311},{23,312},{31,313},{79,314},{162,315},{315,316},{212,317},{176,318},{274,319},{266,320},{124,321},{128,322},{301,323},{28,324},{124,325},{8,326},{15,327},{292,328},{184,329},{83,330},{163,331},{294,332},{137,333},{238,334},{157,335},{119,336},{145,337},{95,338},{215,339},{188,340},{219,341},{155,342},{325,343},{320,344},{80,345},{99,346},{276,347},{188,348},{204,349},{343,350},{42,351},{308,352},{344,353},{74,354},{345,355},{40,356},{2,357},{51,358},{230,359},{348,360},{197,361},{145,362},{195,363},{122,364},{31,365},{40,366},{331,367},{171,368},{281,369},{124,370},{368,371},{329,372},{37,373},{225,374},{49,375},{300,376},{247,377},{253,378},{158,379},{123,380},{25,381},{314,382},{283,383},{38,384},{78,385},{38,386},{214,387},{42,388},{16,389},{78,390},{300,391},{137,392},{200,393},{145,394},{123,395},{221,396},{174,397},{59,398},{170,399},{16,400},{39,401},{301,402},{215,403},{223,404},{215,405},{159,406},{119,407},{231,408},{347,409},{332,410},{379,411},{356,412},{169,413},{59,414},{316,415},{85,416},{349,417},{384,418},{268,419},{372,420},{250,421},{180,422},{358,423},{392,424},{364,425},{123,426},{20,427},{101,428},{108,429},{258,430},{120,431},{221,432},{359,433},{73,434},{396,435},{117,436},{47,437},{401,438},{310,439},{398,440},{89,441},{359,442},{190,443},{367,444},{102,445},{241,446},{49,447},{372,448},{238,449},{20,450},{441,451},{20,452},{356,453},{366,454},{35,455},{76,456},{155,457},{84,458},{26,459},{196,460},{293,461},{219,462},{370,463},{371,464},{303,465},{265,466},{238,467},{445,468},{433,469},{291,470},{266,471},{109,472},{161,473},{308,474},{325,475},{315,476},{19,477},{202,478},{466,479},{119,480},{111,481},{335,482},{324,483},{436,484},{217,485},{5,486},{56,487},{458,488},{48,489},{101,490},{151,491},{199,492},{64,493},{12,494},{29,495},{312,496},{394,497},{31,498},{401,499},{157,500},{454,501},{456,502},{90,503},{191,504},{125,505},{497,506},{117,507},{226,508},{497,509},{206,510},{465,511},{132,512},{380,513},{255,514},{6,515},{422,516},{43,517},{471,518},{185,519},{317,520},{153,521},{326,522},{482,523},{282,524},{36,525},{461,526},{247,527},{32,528},{125,529},{220,530},{342,531},{358,532},{422,533},{148,534},{137,535},{464,536},{256,537},{275,538},{45,539},{471,540},{331,541},{516,542},{56,543},{347,544},{330,545},{176,546},{63,547},{347,548},{458,549},{382,550},{181,551},{361,552},{136,553},{301,554},{504,555},{1,556},{311,557},{369,558},{424,559},{78,560},{163,561},{131,562},{413,563},{24,564},{141,565},{299,566},{78,567},{116,568},{370,569},{180,570},{381,571},{121,572},{7,573},{298,574},{51,575},{228,576},{21,577},{355,578},{270,579},{315,580},{262,581},{496,582},{318,583},{347,584},{0,585},{557,586},{564,587},{572,588},{443,589},{536,590},{180,591},{198,592},{540,593},{243,594},{488,595},{163,596},{368,597},{445,598},{43,599},{281,600},{524,601},{254,602},{71,603},{509,604},{34,605},{66,606},{83,607},{385,608},{93,609},{13,610},{254,611},{322,612},{229,613},{19,614},{127,615},{127,616},{316,617},{248,618},{23,619},{527,620},{556,621},{494,622},{367,623},{317,624},{316,625},{528,626},{245,627},{491,628},{305,629},{585,630},{372,631},{232,632},{550,633},{35,634},{304,635},{236,636},{27,637},{579,638},{17,639},{454,640},{214,641},{376,642},{485,643},{268,644},{197,645},{66,646},{110,647},{239,648},{96,649},{246,650},{609,651},{358,652},{106,653},{644,654},{530,655},{54,656},{107,657},{363,658},{339,659},{372,660},{348,661},{595,662},{544,663},{615,664},{317,665},{301,666},{180,667},{164,668},{426,669},{85,670},{519,671},{296,672},{289,673},{151,674},{131,675},{545,676},{455,677},{431,678},{263,679},{497,680},{573,681},{377,682},{158,683},{12,684},{628,685},{108,686},{205,687},{470,688},{170,689},{111,690},{57,691},{310,692},{430,693},{645,694},{673,695},{209,696},{481,697},{98,698},{433,699},{698,700},{418,701},{398,702},{121,703},{26,704},{193,705},{185,706},{201,707},{545,708},{81,709},{586,710},{682,711},{521,712},{87,713},{135,714},{253,715},{343,716},{343,717},{646,718},{114,719},{528,720},{309,721},{14,722},{566,723},{512,724},{391,725},{404,726},{100,727},{107,728},{679,729},{686,730},{615,731},{254,732},{120,733},{321,734},{518,735},{657,736},{438,737},{427,738},{284,739},{579,740},{464,741},{68,742},{586,743},{346,744},{442,745},{626,746},{210,747},{125,748},{181,749},{643,750},{103,751},{280,752},{555,753},{439,754},{75,755},{400,756},{167,757},{22,758},{570,759},{664,760},{433,761},{539,762},{576,763},{412,764},{524,765},{756,766},{693,767},{128,768},{619,769},{766,770},{204,771},{269,772},{14,773},{20,774},{762,775},{56,776},{168,777},{365,778},{554,779},{536,780},{485,781},{611,782},{721,783},{99,784},{628,785},{763,786},{241,787},{132,788},{44,789},{459,790},{397,791},{548,792},{693,793},{703,794},{595,795},{660,796},{70,797},{499,798},{240,799},{571,800},{360,801},{578,802},{398,803},{53,804},{246,805},{220,806},{272,807},{384,808},{325,809},{257,810},{800,811},{238,812},{44,813},{720,814},{300,815},{340,816},{687,817},{606,818},{511,819},{562,820},{272,821},{542,822},{165,823},{116,824},{458,825},{476,826},{124,827},{685,828},{16,829},{476,830},{364,831},{343,832},{583,833},{29,834},{797,835},{164,836},{627,837},{29,838},{263,839},{37,840},{208,841},{324,842},{682,843},{300,844},{630,845},{403,846},{194,847},{543,848},{291,849},{793,850},{377,851},{84,852},{700,853},{363,854},{650,855},{499,856},{13,857},{546,858},{802,859},{73,860},{258,861},{2,862},{161,863},{135,864},{148,865},{840,866},{271,867},{587,868},{286,869},{670,870},{561,871},{363,872},{827,873},{379,874},{491,875},{638,876},{544,877},{450,878},{739,879},{569,880},{44,881},{553,882},{172,883},{487,884},{50,885},{390,886},{863,887},{78,888},{847,889},{872,890},{313,891},{575,892},{451,893},{555,894},{165,895},{128,896},{839,897},{626,898},{189,899},{852,900},{370,901},{844,902},{130,903},{7,904},{510,905},{40,906},{633,907},{4,908},{51,909},{347,910},{27,911},{806,912},{645,913},{736,914},{101,915},{407,916},{558,917},{500,918},{483,919},{872,920},{683,921},{832,922},{474,923},{710,924},{60,925},{875,926},{254,927},{405,928},{385,929},{160,930},{829,931},{392,932},{874,933},{315,934},{818,935},{668,936},{51,937},{502,938},{680,939},{390,940},{259,941},{721,942},{822,943},{360,944},{498,945},{441,946},{231,947},{544,948},{602,949},{915,950},{887,951},{366,952},{616,953},{494,954},{542,955},{659,956},{286,957},{675,958},{617,959},{27,960},{663,961},{229,962},{759,963},{67,964},{650,965},{739,966},{157,967},{39,968},{850,969},{842,970},{568,971},{664,972},{854,973},{372,974},{956,975},{854,976},{568,977},{769,978},{347,979},{286,980},{586,981},{113,982},{939,983},{643,984},{976,985},{447,986},{779,987},{799,988},{239,989},{945,990},{777,991},{772,992},{662,993},{475,994},{592,995},{857,996},{809,997},{50,998},{639,999},{651,1000},{866,1001},{508,1002},{884,1003},{646,1004},{978,1005},{832,1006},{633,1007},{161,1008},{123,1009},{146,1010},{372,1011},{49,1012},{72,1013},{534,1014},{625,1015},{27,1016},{754,1017},{374,1018},{290,1019},{348,1020},{799,1021},{565,1022},{664,1023},{287,1024},{671,1025},{883,1026},{595,1027},{549,1028},{771,1029},{478,1030},{179,1031},{237,1032},{358,1033},{499,1034},{707,1035},{735,1036},{717,1037},{530,1038},{866,1039},{399,1040},{448,1041},{563,1042},{965,1043},{277,1044},{998,1045},{181,1046},{116,1047},{275,1048},{45,1049},{599,1050},{702,1051},{535,1052},{956,1053},{400,1054},{429,1055},{1045,1056},{75,1057},{109,1058},{650,1059},{1013,1060},{409,1061},{730,1062},{1026,1063},{760,1064},{956,1065},{830,1066},{535,1067},{1057,1068},{161,1069},{50,1070},{555,1071},{692,1072},{1015,1073},{585,1074},{160,1075},{117,1076},{69,1077},{90,1078},{811,1079},{270,1080},{795,1081},{227,1082},{524,1083},{740,1084},{269,1085},{276,1086},{818,1087},{741,1088},{1064,1089},{348,1090},{105,1091},{120,1092},{1002,1093},{759,1094},{557,1095},{192,1096},{1043,1097},{808,1098},{733,1099},{770,1100},{170,1101},{574,1102},{722,1103},{98,1104},{838,1105},{421,1106},{601,1107},{871,1108},{89,1109},{365,1110},{979,1111},{1040,1112},{180,1113},{1073,1114},{1084,1115},{931,1116},{787,1117},{377,1118},{887,1119},{72,1120},{632,1121},{617,1122},{23,1123},{1049,1124},{563,1125},{615,1126},{533,1127},{714,1128},{388,1129},{52,1130},{539,1131},{388,1132},{237,1133},{782,1134},{1034,1135},{816,1136},{320,1137},{1003,1138},{420,1139},{665,1140},{804,1141},{117,1142},{205,1143},{30,1144},{395,1145},{498,1146},{593,1147},{331,1148},{762,1149},{870,1150},{393,1151},{1108,1152},{6,1153},{748,1154},{6,1155},{1109,1156},{1034,1157},{930,1158},{674,1159},{241,1160},{596,1161},{276,1162},{717,1163},{1033,1164},{1063,1165},{71,1166},{340,1167},{527,1168},{707,1169},{668,1170},{732,1171},{256,1172},{535,1173},{942,1174},{1134,1175},{404,1176},{844,1177},{911,1178},{449,1179},{22,1180},{771,1181},{261,1182},{1143,1183},{156,1184},{124,1185},{847,1186},{111,1187},{73,1188},{1059,1189},{546,1190},{1022,1191},{745,1192},{795,1193},{848,1194},{634,1195},{582,1196},{1012,1197},{185,1198},{36,1199},{165,1200},{656,1201},{259,1202},{185,1203},{477,1204},{115,1205},{1183,1206},{121,1207},{276,1208},{333,1209},{56,1210},{801,1211},{91,1212},{437,1213},{844,1214},{701,1215},{885,1216},{600,1217},{108,1218},{230,1219},{967,1220},{283,1221},{489,1222},{273,1223},{687,1224},{846,1225},{831,1226},{443,1227},{939,1228},{197,1229},{448,1230},{616,1231},{1158,1232},{877,1233},{374,1234},{465,1235},{22,1236},{474,1237},{1220,1238},{560,1239},{197,1240},{162,1241},{231,1242},{1153,1243},{73,1244},{806,1245},{163,1246},{751,1247},{402,1248},{918,1249},{743,1250},{840,1251},{832,1252},{1194,1253},{394,1254},{642,1255},{343,1256},{911,1257},{730,1258},{11,1259},{448,1260},{674,1261},{1149,1262},{866,1263},{261,1264},{295,1265},{1140,1266},{279,1267},{1148,1268},{502,1269},{465,1270},{787,1271},{1120,1272},{738,1273},{1229,1274},{791,1275},{714,1276},{491,1277},{501,1278},{1174,1279},{1064,1280},{1265,1281},{300,1282},{100,1283},{976,1284},{910,1285},{1253,1286},{444,1287},{1100,1288},{965,1289},{6,1290},{373,1291},{989,1292},{790,1293},{174,1294},{179,1295},{694,1296},{696,1297},{847,1298},{17,1299},{779,1300},{696,1301},{158,1302},{1274,1303},{443,1304},{1026,1305},{1269,1306},{1129,1307},{504,1308},{475,1309},{1287,1310},{786,1311},{1290,1312},{281,1313},{1287,1314},{794,1315},{863,1316},{894,1317},{50,1318},{1131,1319},{690,1320},{580,1321},{990,1322},{77,1323},{85,1324},{9,1325},{1075,1326},{605,1327},{574,1328},{605,1329},{606,1330},{1162,1331},{1103,1332},{879,1333},{1005,1334},{280,1335},{554,1336},{188,1337},{700,1338},{1207,1339},{576,1340},{99,1341},{1132,1342},{116,1343},{204,1344},{242,1345},{386,1346},{59,1347},{1257,1348},{493,1349},{542,1350},{1275,1351},{773,1352},{1183,1353},{1182,1354},{529,1355},{786,1356},{896,1357},{325,1358},{1001,1359},{1200,1360},{693,1361},{918,1362},{375,1363},{140,1364},{862,1365},{331,1366},{454,1367},{55,1368},{258,1369},{219,1370},{831,1371},{118,1372},{362,1373},{958,1374},{301,1375},{1027,1376},{266,1377},{123,1378},{1103,1379},{994,1380},{1289,1381},{1267,1382},{145,1383},{1226,1384},{476,1385},{543,1386},{367,1387},{939,1388},{587,1389},{448,1390},{1078,1391},{256,1392},{1094,1393},{888,1394},{650,1395},{121,1396},{329,1397},{893,1398},{269,1399},{1297,1400},{680,1401},{1064,1402},{927,1403},{430,1404},{426,1405},{780,1406},{702,1407},{834,1408},{724,1409},{910,1410},{622,1411},{1257,1412},{694,1413},{1210,1414},{1290,1415},{453,1416},{27,1417},{705,1418},{1008,1419},{1107,1420},{429,1421},{194,1422},{794,1423},{915,1424},{535,1425},{1115,1426},{1329,1427},{400,1428},{138,1429},{425,1430},{339,1431},{481,1432},{1283,1433},{508,1434},{372,1435},{120,1436},{1029,1437},{1181,1438},{891,1439},{1374,1440},{393,1441},{755,1442},{880,1443},{648,1444},{347,1445},{521,1446},{138,1447},{1176,1448},{551,1449},{865,1450},{1018,1451},{1352,1452},{59,1453},{1146,1454},{851,1455},{1148,1456},{370,1457},{481,1458},{636,1459},{899,1460},{782,1461},{1072,1462},{115,1463},{1005,1464},{1217,1465},{1228,1466},{1170,1467},{432,1468},{264,1469},{1401,1470},{93,1471},{298,1472},{1336,1473},{1436,1474},{665,1475},{1173,1476},{314,1477},{154,1478},{1333,1479},{562,1480},{932,1481},{92,1482},{775,1483},{472,1484},{315,1485},{642,1486},{46,1487},{1120,1488},{471,1489},{1133,1490},{258,1491},{384,1492},{414,1493},{1229,1494},{1213,1495},{1433,1496},{354,1497},{598,1498},{1383,1499},{934,1500},{201,1501},{982,1502},{693,1503},{154,1504},{541,1505},{1013,1506},{1346,1507},{305,1508},{253,1509},{997,1510},{1490,1511},{4,1512},{1505,1513},{1424,1514},{827,1515},{484,1516},{1064,1517},{324,1518},{999,1519},{1298,1520},{1191,1521},{62,1522},{1461,1523},{433,1524},{1174,1525},{369,1526},{1101,1527},{983,1528},{1500,1529},{357,1530},{616,1531},{1405,1532},{1146,1533},{1401,1534},{79,1535},{291,1536},{90,1537},{776,1538},{1500,1539},{13,1540},{1453,1541},{976,1542},{739,1543},{820,1544},{690,1545},{1091,1546},{1379,1547},{252,1548},{1284,1549},{1414,1550},{168,1551},{439,1552},{682,1553},{1400,1554},{191,1555},{451,1556},{217,1557},{640,1558},{381,1559},{718,1560},{324,1561},{1326,1562},{1485,1563},{1355,1564},{801,1565},{1487,1566},{1001,1567},{184,1568},{316,1569},{87,1570},{419,1571},{459,1572},{929,1573},{400,1574},{1534,1575},{1142,1576},{152,1577},{307,1578},{426,1579},{1376,1580},{1032,1581},{701,1582},{238,1583},{1537,1584},{45,1585},{79,1586},{1487,1587},{1178,1588},{850,1589},{986,1590},{1244,1591},{607,1592},{1365,1593},{1547,1594},{724,1595},{322,1596},{880,1597},{628,1598},{1529,1599},{398,1600},{1145,1601},{1491,1602},{1432,1603},{1368,1604},{711,1605},{220,1606},{865,1607},{1093,1608},{1407,1609},{1554,1610},{1366,1611},{408,1612},{1558,1613},{711,1614},{566,1615},{1335,1616},{1610,1617},{766,1618},{155,1619},{1314,1620},{470,1621},{1201,1622},{1622,1623},{1368,1624},{2,1625},{266,1626},{1119,1627},{936,1628},{104,1629},{670,1630},{1149,1631},{792,1632},{1055,1633},{580,1634},{26,1635},{1308,1636},{1041,1637},{892,1638},{1620,1639},{997,1640},{1075,1641},{639,1642},{77,1643},{1596,1644},{1466,1645},{986,1646},{77,1647},{1466,1648},{1279,1649},{67,1650},{1559,1651},{551,1652},{529,1653},{1632,1654},{1004,1655},{269,1656},{813,1657},{950,1658},{133,1659},{1551,1660},{1425,1661},{315,1662},{43,1663},{714,1664},{718,1665},{838,1666},{1426,1667},{295,1668},{1248,1669},{1414,1670},{983,1671},{794,1672},{1533,1673},{671,1674},{1367,1675},{588,1676},{605,1677},{287,1678},{1483,1679},{17,1680},{411,1681},{634,1682},{751,1683},{1369,1684},{1591,1685},{811,1686},{1506,1687},{121,1688},{537,1689},{1513,1690},{462,1691},{836,1692},{1017,1693},{729,1694},{1435,1695},{1625,1696},{659,1697},{498,1698},{793,1699},{253,1700},{850,1701},{120,1702},{1434,1703},{906,1704},{41,1705},{1559,1706},{360,1707},{211,1708},{531,1709},{506,1710},{119,1711},{733,1712},{895,1713},{769,1714},{1527,1715},{1356,1716},{1564,1717},{624,1718},{1671,1719},{1056,1720},{1362,1721},{325,1722},{908,1723},{527,1724},{11,1725},{346,1726},{588,1727},{888,1728},{1554,1729},{199,1730},{1575,1731},{1233,1732},{1265,1733},{1674,1734},{279,1735},{798,1736},{1735,1737},{307,1738},{1226,1739},{359,1740},{1247,1741},{1671,1742},{737,1743},{4,1744},{1402,1745},{1493,1746},{550,1747},{487,1748},{1559,1749},{322,1750},{496,1751},{743,1752},{753,1753},{1634,1754},{1453,1755},{72,1756},{1248,1757},{138,1758},{542,1759},{572,1760},{1148,1761},{822,1762},{12,1763},{245,1764},{1549,1765},{1629,1766},{1439,1767},{164,1768},{1049,1769},{1202,1770},{146,1771},{1598,1772},{229,1773},{541,1774},{742,1775},{1081,1776},{1299,1777},{71,1778},{590,1779},{876,1780},{1504,1781},{467,1782},{1659,1783},{873,1784},{335,1785},{706,1786},{1104,1787},{231,1788},{357,1789},{1240,1790},{49,1791},{56,1792},{799,1793},{743,1794},{614,1795},{539,1796},{685,1797},{889,1798},{724,1799},{1127,1800},{1112,1801},{1621,1802},{1455,1803},{778,1804},{138,1805},{1630,1806},{16,1807},{641,1808},{171,1809},{636,1810},{1035,1811},{173,1812},{95,1813},{1690,1814},{887,1815},{522,1816},{907,1817},{294,1818},{750,1819},{1508,1820},{1214,1821},{792,1822},{907,1823},{928,1824},{792,1825},{1219,1826},{1109,1827},{757,1828},{208,1829},{241,1830},{698,1831},{996,1832},{744,1833},{513,1834},{1530,1835},{1113,1836},{750,1837},{1290,1838},{207,1839},{1487,1840},{839,1841},{140,1842},{861,1843},{1264,1844},{1757,1845},{1135,1846},{1776,1847},{1335,1848},{1237,1849},{1578,1850},{605,1851},{1851,1852},{1026,1853},{345,1854},{993,1855},{873,1856},{1311,1857},{1249,1858},{66,1859},{477,1860},{1183,1861},{1247,1862},{1638,1863},{366,1864},{380,1865},{214,1866},{1778,1867},{788,1868},{1861,1869},{802,1870},{1698,1871},{584,1872},{283,1873},{816,1874},{298,1875},{379,1876},{1210,1877},{5,1878},{1000,1879},{251,1880},{413,1881},{806,1882},{488,1883},{1727,1884},{1018,1885},{1717,1886},{1809,1887},{1190,1888},{786,1889},{505,1890},{1282,1891},{1044,1892},{670,1893},{533,1894},{1566,1895},{1457,1896},{1413,1897},{1226,1898},{431,1899},{511,1900},{926,1901},{368,1902},{699,1903},{447,1904},{887,1905},{1139,1906},{1571,1907},{1183,1908},{1622,1909},{1847,1910},{1004,1911},{1627,1912},{1341,1913},{1261,1914},{1734,1915},{482,1916},{564,1917},{1458,1918},{521,1919},{1004,1920},{921,1921},{1090,1922},{1731,1923},{506,1924},{969,1925},{1221,1926},{257,1927},{746,1928},{1066,1929},{365,1930},{124,1931},{1266,1932},{1132,1933},{322,1934},{1553,1935},{1912,1936},{1326,1937},{26,1938},{653,1939},{1000,1940},{815,1941},{232,1942},{440,1943},{410,1944},{707,1945},{238,1946},{1599,1947},{1666,1948},{1303,1949},{234,1950},{606,1951},{1230,1952},{1774,1953},{413,1954},{820,1955},{1224,1956},{1341,1957},{893,1958},{1457,1959},{45,1960},{1701,1961},{1392,1962},{1746,1963},{473,1964},{852,1965},{65,1966},{274,1967},{376,1968},{1408,1969},{99,1970},{239,1971},{338,1972},{373,1973},{720,1974},{1030,1975},{1485,1976},{1260,1977},{1385,1978},{521,1979},{1069,1980},{524,1981},{1571,1982},{166,1983},{993,1984},{931,1985},{701,1986},{254,1987},{647,1988},{1162,1989},{1001,1990},{1338,1991},{1380,1992},{246,1993},{17,1994},{39,1995},{732,1996},{53,1997},{53,1998},{1056,1999},{978,2000},{844,2001},{300,2002},{418,2003},{1081,2004},{1260,2005},{1029,2006},{1146,2007},{1054,2008},{1258,2009},{387,2010},{1808,2011},{1225,2012},{115,2013},{414,2014},{1890,2015},{1303,2016},{44,2017},{990,2018},{339,2019}};
        System.out.println(Arrays.toString(new MinimumHeightTrees().findMinHeightTrees(n, edges).toArray()));

    }


    //WRONG!!!!! from leaf do DFS, find middle one(s)
    //n = 7;
    //        edges = new int[][]{{0,1},{1,2},{1,3},{2,4},{3,5},{4,6}};
    //expected: 1, 2. Output: 2
    public List<Integer> findMinHeightTreesWrong(int n, int[][] edges) {
        if(n==1){
            return Arrays.asList(0);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int[] edge = edges[i];
            if(map.containsKey(edge[0])){
                map.get(edge[0]).add(edge[1]);
            }else {
                List<Integer> l = new ArrayList<>();
                l.add(edge[1]);
                map.put(edge[0], l);
            }
            if(map.containsKey(edge[1])){
                map.get(edge[1]).add(edge[0]);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(edge[0]);
                map.put(edge[1], l);
            }
        }

        Set<Integer> keys = map.keySet();
        int leaf = 0;
        for(Integer key : keys){
            if(map.get(key).size() == 1){
                leaf = key;
                break;
            }
        }

        //Find longest path.
        Set<Integer> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> longList = new ArrayList<>();
        dfs(leaf, map, visited, list, longList);

        if(longList.size()%2 == 1){
            return Arrays.asList(longList.get(longList.size()/2));
        }else {
            return Arrays.asList(longList.get(longList.size()/2-1), longList.get(longList.size()/2));
        }
    }

    public void dfs(Integer curr, Map<Integer, List<Integer>> map, Set<Integer> visited, List<Integer> currList, List<Integer> longList){
        visited.add(curr);
        currList.add(curr);
        if(currList.size() > longList.size()){
            longList.clear();
            longList.addAll(currList);
        }
        List<Integer> l = map.get(curr);
        for(Integer i : l){
            if(visited.contains(i)){
                continue;
            }
            dfs(i, map, visited, currList, longList);
        }
        currList.remove(currList.size()-1);
    }






    //my own way, TLE
    public List<Integer> findMinHeightTreesTLE(int n, int[][] edges) {
        if(n==1){
            return Arrays.asList(0);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int[] edge = edges[i];
            if(map.containsKey(edge[0])){
                map.get(edge[0]).add(edge[1]);
            }else {
                List<Integer> l = new ArrayList<>();
                l.add(edge[1]);
                map.put(edge[0], l);
            }
            if(map.containsKey(edge[1])){
                map.get(edge[1]).add(edge[0]);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(edge[0]);
                map.put(edge[1], l);
            }
        }

        List<Integer> rst = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            q.offer(i);
            visited.add(i);
            q.offer(-1);
            int height = 0;
            while(!q.isEmpty()){
                Integer curr = q.poll();
                if(curr == -1){
                    height++;
                    if(height>minHeight){
                        break;
                    }
                    if(q.isEmpty()){
                        break;
                    }
                    q.offer(-1);
                    continue;
                }
                List<Integer> nexts = map.get(curr);
                boolean added = false;
                for(Integer j : nexts){
                    if(visited.contains(j)){
                        continue;
                    }
                    added = true;
                    q.offer(j);
                    visited.add(j);
                }
            }
            if(height<minHeight){
                minHeight = height;
                rst.clear();
                rst.add(i);
            }else if(height == minHeight){
                rst.add(i);
            }
        }
        return rst;
    }


}
