package com.moses.leet.n0940;

import java.util.*;

/**
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.
 *
 * If there isn't any rectangle, return 0.
 *  Note:
 *
 *     1 <= points.length <= 500
 *     0 <= points[i][0] <= 40000
 *     0 <= points[i][1] <= 40000
 *     All points are distinct.
 *
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();
        for(int[] p : points){
            int x = p[0], y = p[1];
            rows.computeIfAbsent(x, z-> new ArrayList<>()).add(y);
        }

        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> visited = new HashMap<>();
        for(int x : rows.keySet()){
            List<Integer> col = rows.get(x);
            Collections.sort(col);
            for(int i=0; i<col.size(); i++){
                for(int j=i+1; j<col.size(); j++){
                    int y1 = col.get(i), y2 = col.get(j);
                    int code = 40001*y1 + y2;
                    if(visited.containsKey(code)){
                        ans = Math.min(ans, (x-visited.get(code) * (y2-y1)));
                    }
                    visited.put(code, x);
                }
            }
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }
}
