package com.moses.leet.n0660;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs){
        Arrays.sort(pairs, (o1, o2) ->{return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];});
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                if(pairs[i][1] < pairs[j][0]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }
        int ans = 0;
        for(int x : dp) if(x>ans) ans = x;
        return ans;
    }

    public static void main(String[] args) {
        int[][] pairs;
        pairs = new int[][]{
                {1,2}, {2,3}, {3,4}
        };
        System.out.println(new MaximumLengthOfPairChain().findLongestChain(pairs));
    }


    public int findLongestChainSlow(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) ->{return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];});
        Integer[] dpNull = new Integer[pairs.length+1];
        Integer[][] dp = new Integer[pairs.length+1][pairs.length+1];
        return dfs(pairs, 0, null, dpNull, dp);
    }

    private int dfs(int[][] pairs, int i, Integer prevI, Integer[] dpNull, Integer[][] dp) {
        if(i == pairs.length){
            return 0;
        }
        int[] p = pairs[i];
        if(prevI == null){
            if(dpNull[i] != null){
                return dpNull[i];
            }
            int me = 1+dfs(pairs, i+1, i, dpNull, dp);
            int notMe = dfs(pairs, i+1, null, dpNull, dp);
            int r = Math.max(me, notMe);
            dpNull[i] = r;
            return r;
        }else{
            if(dp[i][prevI]!=null){
                return dp[i][prevI];
            }
            if(p[0] > pairs[prevI][1]){
                int me = 1+dfs(pairs, i+1, i, dpNull, dp);
                int notMe = dfs(pairs, i+1, prevI, dpNull, dp);
                int r = Math.max(me, notMe);
                dp[i][prevI] = r;
                return r;
            }else{
                dp[i][prevI] = dfs(pairs, i+1, prevI, dpNull, dp);
                return dp[i][prevI];
            }
        }
    }


}
