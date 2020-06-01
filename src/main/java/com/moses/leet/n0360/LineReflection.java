package com.moses.leet.n0360;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points symmetrically, in other words, answer whether or not if there exists a line that after reflecting all points over the given line the set of the original points is the same that the reflected ones.
 *
 * Note that there can be repeated points.
 *
 * Follow up:
 * Could you do better than O(n2) ?
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,1],[-1,1]]
 * Output: true
 * Explanation: We can choose the line x = 0.
 *
 * Example 2:
 *
 * Input: points = [[1,1],[-1,-1]]
 * Output: false
 * Explanation: We can't choose a line.
 *
 *
 *
 * Constraints:
 *
 *     n == points.length
 *     1 <= n <= 10^4
 *     -10^8 <= points[i][j] <= 10^8
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        for(int[] p : points){
            map.computeIfAbsent(p[0], z -> new HashSet<>()).add(p[1]);
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
        }

        double m = minX + (maxX-minX)/2d;
        for(int x : map.keySet()){
            for(int y : map.get(x)){
                int opp = (int)(2d*m - x);
                if(!map.containsKey(opp) || !map.get(opp).contains(y)){
                    return false;
                }
            }
        }
        return true;
    }
}
