package com.moses.leet.n0680;

import java.util.*;

public class CutOffTreesForGolfEvent {
    int[][] directions = new int[][]{
            {-1,0}, {1,0}, {0,-1}, {0,1}
    };
    public int cutOffTree(List<List<Integer>> forest) {
        List<Point> list = new ArrayList<>();
        for(int i=0; i<forest.size(); i++){
            List<Integer> l = forest.get(i);
            for(int j = 0; j<l.size(); j++){
                if(l.get(j) == 0 || l.get(j) == 1){
                    continue;
                }
                list.add(new Point(i, j));
            }
        }

        Collections.sort(list, (o1, o2)-> forest.get(o1.i).get(o1.j) - forest.get(o2.i).get(o2.j));

        int steps = 0;
        Point prev = new Point(0,0);
        for(int i=0; i<list.size(); i++){
            Point p = list.get(i);
            int step = calSteps(prev, p, forest);
            if(step == -1){
                return -1;
            }
            steps+=step;
            prev = p;
        }
        return steps;
    }

    private int calSteps(Point prev, Point target, List<List<Integer>> forest) {
        if(prev.i == target.i && prev.j==target.j){
            return 0;
        }
        Queue<Point> q = new LinkedList<>();
        q.offer(prev);
        Set<Point> visited = new HashSet<>();
        visited.add(prev);
        int step = 0;
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            for(int i=0; i<size;i++) {
                Point cur = q.poll();

                for (int[] dir : directions) {
                    int x = cur.i + dir[0];
                    int y = cur.j + dir[1];
                    Point next = new Point(x,y);
                    if (x >= 0 && x < forest.size() && y >= 0 && y < forest.get(x).size()
                            && !visited.contains(next) && forest.get(x).get(y) != 0) {
                        if(next.i == target.i && next.j == target.j){
                            return step;
                        }
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }

        }
        return -1;
    }

    class Point{
        int i;
        int j;
        public Point(int i, int j){
            this.i = i;
            this.j = j;
        }

        public int hashCode(){
            return i*31+j*31;
        }

        public boolean equals(Object p){
            Point p1 = (Point)p;
            return this.i == p1.i && this.j == p1.j;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> forest;
        forest = new ArrayList<>();
        forest.add(Arrays.asList(69438,55243,0,43779,5241,93591,73380));
        forest.add(Arrays.asList(847,49990,53242,21837,89404,63929,48214));
        forest.add(Arrays.asList(90332,49751,0,3088,16374,70121,25385));
        forest.add(Arrays.asList(14694,4338,87873,86281,5204,84169,5024));
        forest.add(Arrays.asList(31711,47313,1885,28332,11646,42583,31460));
        forest.add(Arrays.asList(59845,94855,29286,53221,9803,41305,60749));
        forest.add(Arrays.asList(95077,50343,27947,92852,0,0,19731));
        forest.add(Arrays.asList(86158,63553,56822,90251,0,23826,17478));
        forest.add(Arrays.asList(60387,23279,78048,78835,5310,99720,0));
        forest.add(Arrays.asList(74799,48845,60658,29773,96129,90443,14391));
        forest.add(Arrays.asList(65448,63358,78089,93914,7931,68804,72633));
        forest.add(Arrays.asList(93431,90868,55280,30860,59354,62083,47669));
        forest.add(Arrays.asList(81064,93220,22386,22341,95485,20696,13436));
        forest.add(Arrays.asList(50083,0,89399,43882,0,13593,27847));
        forest.add(Arrays.asList(0,12256,33652,69301,73395,93440,0));
        forest.add(Arrays.asList(42818,87197,81249,33936,7027,5744,64710));
        forest.add(Arrays.asList(35843,0,99746,52442,17494,49407,63016));
        forest.add(Arrays.asList(86042,44524,0,0,26787,97651,28572));
        forest.add(Arrays.asList(54183,83466,96754,89861,84143,13413,72921));
        forest.add(Arrays.asList(89405,52305,39907,27366,14603,0,14104));
        forest.add(Arrays.asList(70909,61104,70236,30365,0,30944,98378));
        forest.add(Arrays.asList(20124,87188,6515,98319,78146,99325,88919));
        forest.add(Arrays.asList(89669,0,64218,85795,2449,48939,12869));
        forest.add(Arrays.asList(93539,28909,90973,77642,0,72170,98359));
        forest.add(Arrays.asList(88628,16422,80512,0,38651,50854,55768));
        forest.add(Arrays.asList(13639,2889,74835,80416,26051,78859,25721));
        forest.add(Arrays.asList(90182,23154,16586,0,27459,3272,84893));
        forest.add(Arrays.asList(2480,33654,87321,93272,93079,0,38394));
        forest.add(Arrays.asList(34676,72427,95024,12240,72012,0,57763));
        forest.add(Arrays.asList(97957,56,83817,45472,0,24087,90245));
        forest.add(Arrays.asList(32056,0,92049,21380,4980,38458,3490));
        forest.add(Arrays.asList(21509,76628,0,90430,10113,76264,45840));
        forest.add(Arrays.asList(97192,58807,74165,65921,45726,47265,56084));
        forest.add(Arrays.asList(16276,27751,37985,47944,54895,80706,2372));
        forest.add(Arrays.asList(28438,53073,0,67255,38416,63354,69262));
        forest.add(Arrays.asList(23926,75497,91347,58436,73946,39565,10841));
        forest.add(Arrays.asList(34372,69647,44093,62680,32424,69858,68719));
        forest.add(Arrays.asList(24425,4014,94871,1031,99852,88692,31503));
        forest.add(Arrays.asList(24475,12295,33326,37771,37883,74568,25163));
        forest.add(Arrays.asList(0,18411,88185,60924,29028,69789,0));
        forest.add(Arrays.asList(34697,75631,7636,16190,60178,39082,7052));
        forest.add(Arrays.asList(24876,9570,53630,98605,22331,79320,88317));
        forest.add(Arrays.asList(27204,89103,15221,91346,35428,94251,62745));
        forest.add(Arrays.asList(26636,28759,12998,58412,38113,14678,0));
        forest.add(Arrays.asList(80871,79706,45325,3861,12504,0,4872));
        forest.add(Arrays.asList(79662,15626,995,80546,64775,0,68820));
        forest.add(Arrays.asList(25160,82123,81706,21494,92958,33594,5243));
        System.out.println(new CutOffTreesForGolfEvent().cutOffTree(forest));


        forest = new ArrayList<>();
        forest.add(Arrays.asList(1,2,3));
        forest.add(Arrays.asList(0,0,0));
        forest.add(Arrays.asList(7,6,5));
        System.out.println(new CutOffTreesForGolfEvent().cutOffTree(forest));

        forest = new ArrayList<>();
        forest.add(Arrays.asList(1,2,3));
        forest.add(Arrays.asList(0,0,4));
        forest.add(Arrays.asList(7,6,5));
        System.out.println(new CutOffTreesForGolfEvent().cutOffTree(forest));
    }
}
