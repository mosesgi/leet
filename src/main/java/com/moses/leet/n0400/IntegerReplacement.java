package com.moses.leet.n0400;

import java.util.*;

public class IntegerReplacement {
    public int integerReplacement(int n) {
        Map<Long, Integer> dp = new HashMap<>();
        return dfs((long)n, dp);
    }

    public int dfs(long n, Map<Long, Integer> dp){
        if(n == 1){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        int steps;
        if(n%2 == 0){
            steps = 1+dfs(n/2, dp);
        } else {
            steps = 1+Math.min(dfs(n+1, dp), dfs(n-1, dp));
        }
        dp.put(n, steps);
        return steps;
    }

    public int integerReplacementBfs(int n) {
        Queue<Long> q = new LinkedList<>();
        q.offer((long)n);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                long cur = q.poll();
                if(cur == 1){
                    return step;
                }
                if(cur%2 == 0){
                    q.offer(cur/2);
                }else{
                    q.offer(cur+1);
                    q.offer(cur-1);
                }
            }
            step++;
        }
        return -1;
    }

    //StackOverflow. 2147483647
    public int integerReplacementStackOverflow(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n%2 == 0){
            return 1+integerReplacement(n/2);
        } else {
            return 1+Math.min(integerReplacement(n+1), integerReplacement(n-1));
        }
    }

    public int integerReplacementMemoryExceed(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);
        return dfs(n, dp);
    }

    private int dfs(int n, int[] dp){
        if(n == 1){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        if(n%2 == 0){
            dp[n] = 1+dfs(n/2, dp);
        } else {
            dp[n] = 1+Math.min(dfs(n+1, dp), dfs(n-1, dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntegerReplacement().integerReplacement(Integer.MAX_VALUE));
        System.out.println(new IntegerReplacement().integerReplacement(100000000));
        System.out.println(new IntegerReplacement().integerReplacement(8));
        System.out.println(new IntegerReplacement().integerReplacement(7));
    }
}
