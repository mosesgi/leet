package com.moses.leet.n0560;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        int rows = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> l : wall){
            int prev = 0;
            int idx = 0;
            int size = l.size();
            for(int i : l){
                if(idx == size-1){
                    continue;
                }
                int cur = prev + i;
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                prev = cur;
                idx++;
            }
        }

        int max = 0;
        for(int key : map.keySet()){
            max = Math.max(max, map.get(key));
        }
        return rows - max;
    }

    /**
     * {{1,2,2,1},
     * {3,1,2},
     * {1,3,2},
     * {2,4},
     * {3,1,2},
     * {1,3,1,1}}
     *
     * 1,3,5,6
     * 3,4,6
     * 1,4,6
     * 2,6
     * 3,4,6
     * 1,4,5,6
     * @param args
     */
    public static void main(String[] args) {

    }
}
