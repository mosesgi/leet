package com.moses.leet.n0120;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {

    //O(n) extra space
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        int rows = triangle.size();
        if(rows == 1){
            return triangle.get(0).get(0);
        }
        int[] dp = new int[rows];
        for(int i=0; i<rows; i++){
            dp[i] = triangle.get(rows-1).get(i);
        }
        for(int i= rows-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }

    //DP cache version
    public int minimumTotalDP(List<List<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        int rows = triangle.size();
        if(rows == 1){
            return triangle.get(0).get(0);
        }
        int maxCols = triangle.get(rows-1).size();
        Integer[][] cache = new Integer[rows][maxCols];
        return recursive(triangle, rows, 0, 0, cache);
    }

    private int recursive(List<List<Integer>> triangle, int rows, int currRow, int currPos, Integer[][] cache) {
        if(currRow == rows){
            return 0;
        }
        List<Integer> row = triangle.get(currRow);
        if(currRow == 0){
            return row.get(currPos) + recursive(triangle, rows, currRow+1, 0, cache);
        }
        Integer tmpMin = null;
        if(cache[currRow][currPos] != null){
            return cache[currRow][currPos];
        }
        for(int i=currPos; i<=currPos+1; i++){
            int tmp = recursive(triangle, rows, currRow+1, i, cache) + row.get(i);
            if(tmpMin == null){
                tmpMin = tmp;
            } else {
                tmpMin = tmp<tmpMin?tmp:tmpMin;
            }
        }
        cache[currRow][currPos] = tmpMin;
        return tmpMin;
    }

    public static void main(String[] args) {

    }
}
