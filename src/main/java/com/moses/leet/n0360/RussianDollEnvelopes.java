package com.moses.leet.n0360;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        //2,3; 4,8; 5,4; 6,4; 6,7
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int[] dp = new int[envelopes.length];
        int res = 0;
        for(int i=0; i<envelopes.length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public int maxEnvelopesOld(int[][] envelopes) {
        //2,3; 4,8; 5,4; 6,4; 6,7
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int[] cache = new int[envelopes.length];
        Arrays.fill(cache, -1);
        int max = 0;
        for(int i=0; i<envelopes.length; i++){
            int tmp = dfs(envelopes, i, cache);
            if(tmp > max){
                max = tmp;
            }
        }
        return max;
    }

    private int dfs(int[][] envelopes, int currPos, int[] cache){
        if(currPos == envelopes.length-1){
            return 1;
        }
        if(cache[currPos] != -1){
            return cache[currPos];
        }
        int[] curr = envelopes[currPos];
        int max = 1;
        for(int i=currPos + 1; i<envelopes.length; i++){
            int[] next = envelopes[i];
            if(next[0] > curr[0] && next[1] > curr[1]){
                int tmp = dfs(envelopes, i, cache) + 1;
                if(tmp > max){
                    max = tmp;
                }
            }
        }
        cache[currPos] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] envelopes;
        envelopes = new int[][]{
                {10,8},{1,12},{6,15},{2,18}
        };
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));

        envelopes = new int[][]{
                {5,4},{6,4},{6,7},{2,3},{4,8}
        };
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));
    }
}
