package com.moses.leet.n0960;

import java.util.Arrays;

/**
 * You are installing a billboard and want it to have the largest height.  The billboard will have two steel supports, one on each side.  Each steel support must be an equal height.
 *
 * You have a collection of rods which can be welded together.  For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
 *
 * Return the largest possible height of your billboard installation.  If you cannot support the billboard, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,6]
 * Output: 6
 * Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
 *
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: 10
 * Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.
 *
 * Example 3:
 *
 * Input: [1,2]
 * Output: 0
 * Explanation: The billboard cannot be supported, so we return 0.
 *
 *
 *
 * Note:
 *
 *     0 <= rods.length <= 20
 *     1 <= rods[i] <= 1000
 *     The sum of rods is at most 5000.
 *
 */
public class TallestBillboard {





//    Map<String, Boolean> mem = new HashMap<>();
    Boolean[] mem1;
    public int tallestBillboardTLE(int[] rods) {
        Arrays.sort(rods);
        int sum = 0;
        for(int i : rods){
            sum+=i;
        }
        int max = sum/2;
        int a = 1<<rods.length;
        boolean[] visited = new boolean[rods.length];
        for(int i=max; i>=0; i--){
            mem1= new Boolean[a];
            if(dfs(rods, 0, visited, i, false)){
                return i;
            }
        }
        return 0;
    }

    boolean dfs(int[] rods, int sum, boolean[] visited, int target, boolean right){
        int key = generateKey(visited);
        if(sum > target){
            return false;
        }
        if(sum==target){
            if(right){
                return true;
            }else{
                return dfs(rods, 0, visited, target, true);
            }
        }
//        if(mem.containsKey(key)){
//            return mem.get(key);
//        }
        if(mem1[key] != null){
            return mem1[key];
        }
        for(int i=rods.length-1; i>=0; i--){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            if(dfs(rods, sum+rods[i], visited, target, right)){
                mem1[key] = true;
                visited[i] = false;
                return true;
            }
            visited[i] = false;
        }
        mem1[key] =  false;
        return false;
    }

    private int generateKey(boolean[] visited) {
        int tmp = 0;
        for(int i=visited.length-1; i>=0; i--){
            if(visited[i]) {
                tmp |= (1 << (visited.length - 1 - i));
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] rods;
//        rods = new int[]{140,138,133,162,145,164,145,166,145,154,158};
//        System.out.println(new TallestBillboard().tallestBillboard(rods));
//
//        rods = new int[]{276,253,247,240,250,251,257,262,256,241,238,246,233};
//        System.out.println(new TallestBillboard().tallestBillboard(rods));
    }
}
