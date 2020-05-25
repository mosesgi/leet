package com.moses.leet.n0520;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class CoinChange2 {

    public int change(int amount, int[] coins){
        //    0,1,2,3,4,5
        //1 - 1,1,1,1,1,1
        //2 - 1,1,2,2,3,3
        //5 - 1,1,2,2,3,4
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i=1; i<=coins.length; i++){
            dp[i][0] = 1;
            for(int j = 1; j<=amount; j++){
                if(j >= coins[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }


    //Iterative DP, bottom-up
    public int change1(int amount, int[] coins){
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i=1; i<=coins.length; i++){     //零钱在外层是组合; 如果amount在外则是排列了.
            dp[i][0] = 1;
            for(int j=1; j<=amount; j++){
                //not using i-th coin
                //using i-th coin, need to know all combinations made amount j-coins[i]. ( i is i-1 in code)
                dp[i][j] = dp[i-1][j] + (coins[i-1]<=j?dp[i][j-coins[i-1]]:0);
            }
        }
        return dp[coins.length][amount];
    }

    //6; 1,2,5
    //5, 1
    //2,2,2
    //2,2,1,1
    //2,1,1,1,1
    //1,1,1,1,1,1
    //top-down
    public int changeRecursiveSlow(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }
        if(coins.length==0){
            return 0;
        }
        TreeSet<Integer> coinSet = new TreeSet<>(Collections.reverseOrder());
        for(int i : coins){
            coinSet.add(i);
        }
        int[] cs = new int[coinSet.size()];
        int idx = 0;
        for(int i : coinSet){
            cs[idx++] = i;
        }
        Integer[][] dp = new Integer[amount+1][cs.length];
        return recursive(amount, cs, 0, dp);
    }

    private int recursive(int amount, int[] cs, int curPos, Integer[][] dp) {
        if(amount == 0){
            return 1;
        }
        if(dp[amount][curPos] != null){
            return dp[amount][curPos];
        }
        int ways = 0;
        for(int i=curPos; i<cs.length; i++){
            if(cs[i] <= amount){
                ways += recursive(amount-cs[i], cs, i, dp);
            }
        }
        dp[amount][curPos] = ways;
        return ways;
    }

    public static void main(String[] args) {
        int amount;
        int[] coins;
        amount = 500;
        coins = new int[]{3,5,7,8,9,10,11};
        System.out.println(new CoinChange2().change(amount, coins));

        amount = 6;
        coins = new int[]{1,2,5};
        System.out.println(new CoinChange2().change(amount, coins));

        amount = 5;
        coins = new int[]{1,2,5};
        System.out.println(new CoinChange2().change(amount, coins));

        amount = 3;
        coins = new int[]{2};
        System.out.println(new CoinChange2().change(amount, coins));

        amount = 10;
        coins = new int[]{10};
        System.out.println(new CoinChange2().change(amount, coins));
    }
}
