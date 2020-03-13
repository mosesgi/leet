package com.moses.leet.n0460;

import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, (o1, o2)->{return o1[1] - o2[1];});
        int prevEnd = points[0][1];
        int cnt = 1;
        for(int i=1; i<points.length; i++){
            if(points[i][0] <= prevEnd){
                continue;
            }
            cnt++;
            prevEnd = points[i][1];
        }
        return cnt;
    }

    //Two Maps. Still slow because O(NLogN) is sufficient!
    public int findMinArrowShotsTwoMaps(int[][] points) {
        TreeMap<Integer, Set<Integer>> startMap = new TreeMap<>();
        TreeMap<Integer, Set<Integer>> endMap = new TreeMap<>();
        for(int i=0; i<points.length; i++){
            int[] p = points[i];
            Set<Integer> set = startMap.getOrDefault(p[0], new HashSet<>());
            set.add(i);
            startMap.put(p[0], set);

            set = endMap.getOrDefault(p[1], new HashSet<>());
            set.add(i);
            endMap.put(p[1], set);
        }

        int cnt = 0;
        while(!endMap.isEmpty()){
            Map.Entry<Integer, Set<Integer>> endEntry = endMap.pollFirstEntry();
            int endX = endEntry.getKey();
            Set<Integer> toDelete = endEntry.getValue();

            while(!startMap.isEmpty() && startMap.firstKey()<=endX){
                Map.Entry<Integer, Set<Integer>> startEntry = startMap.pollFirstEntry();
                Set<Integer> indexes = startEntry.getValue();
                for(int index:indexes){
                    int[] p = points[index];
                    Set<Integer> endSet = endMap.get(p[1]);
                    if(endSet!= null){
                        endSet.remove(index);
                        if(endSet.isEmpty()){
                            endMap.remove(p[1]);
                        }
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] points;
        points = new int[][]{
                {10,16},{2,8},{1,6},{7,12}
        };
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
    }


    public int findMinArrowShotsFirstSlow(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        LinkedList<int[]> list = new LinkedList<>(Arrays.asList(points));
        int cnt = 0;
        while(!list.isEmpty()){
            int[] curr = list.pollFirst();
            int right = curr[1];

            Iterator<int[]> iter = list.iterator();
            while(iter.hasNext()){
                int[] in = iter.next();
                if(in[0] <= right && in[1] >=right){
                    iter.remove();
                }
            }
            cnt++;
        }
        return cnt;

    }
}
