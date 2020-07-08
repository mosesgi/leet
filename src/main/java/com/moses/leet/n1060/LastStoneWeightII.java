package com.moses.leet.n1060;

import java.util.ArrayList;
import java.util.List;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        //换成，分两组石头，使其中一组最接近 allWeight/2. 转换成背包
        int allWeight = 0;
        for(int i: stones){
            allWeight+=i;
        }
        int weight=allWeight/2;

        //dp[i][j] = Math.max(dp[i-1][j-stone] + stone, dp[i-1][j]);
        int[][] dp = new int[stones.length+1][weight+1];
        for(int i=1; i<=stones.length; i++){
            for(int j=1; j<weight+1; j++){
                if(j<stones[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j - stones[i - 1]] + stones[i - 1], dp[i - 1][j]);
                }
            }
        }

        return allWeight - 2*dp[stones.length][weight];
    }


    public static void main(String[] args) {
        int[] stones;
        stones = new int[]{1,2};
        System.out.println(new LastStoneWeightII().lastStoneWeightII(stones));
    }












    int res = Integer.MAX_VALUE;
    public int lastStoneWeightIIMLE(int[] stones) {
        List<Integer> l = new ArrayList<>();
        for(int i : stones){
            l.add(i);
        }

        dfs(l);
        return res;
    }

    void dfs(List<Integer> l){
        if(l.size()==0){
            res = 0;
            return;
        }else if(l.size()==1){
            res = Math.min(res, l.get(0));
            return;
        }
        for(int i=0; i<l.size()-1; i++){
            for(int j=i+1; j<l.size(); j++){
                List<Integer> tmp = new ArrayList<>();
                for(int k=0; k<l.size(); k++){
                    if(k==i || k==j){
                        continue;
                    }
                    tmp.add(l.get(k));
                }
                if(l.get(i) != l.get(j)){
                    tmp.add(Math.abs(l.get(i) - l.get(j)));
                }
                dfs(l);
            }
        }
    }
}
