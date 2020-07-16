package com.moses.leet.n0340;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int j : coins){
                if(i>=j && dp[i-j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-j]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i : coins){
            if(i<=amount){
                dp[i] = 1;
            }
        }
        for(int i=1; i<=amount; i++){
            for(int j:coins){
                if(j<i && dp[j] != Integer.MAX_VALUE && dp[i-j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j]+dp[i-j]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public int coinChangeOld(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(coins.length == 0){
            return -1;
        }
        Integer[] cache = new Integer[amount+1];
        Integer min = recursive(coins, amount, cache);
        if(min == null){
            min = -1;
        }
        return min;
    }

    private Integer recursive(int[] coins, int leftAmt, Integer[] cache) {
        if(leftAmt == 0){
            return 0;
        }
        if(cache[leftAmt] != null){
            return cache[leftAmt];
        }
        Integer min = null;
        for(int i=coins.length-1; i>=0; i--){
            if(leftAmt >= coins[i]){
                Integer tmp = recursive(coins, leftAmt-coins[i], cache);
                if(tmp == -1){
                    continue;
                }
                if(min == null || tmp + 1 < min){
                    min = tmp + 1;
                }
            }
        }
        cache[leftAmt] = min==null?-1:min;
        return min==null?-1:min;
    }


    public static void main(String[] args) {
        int[] coins; int amount;
        coins = new int[]{186,419,83,408};
        amount = 6249;
        System.out.println(new CoinChange().coinChange(coins, amount));

        coins = new int[]{1,2,5};
        amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));

        coins = new int[]{2};
        amount = 3;
        System.out.println(new CoinChange().coinChange(coins, amount));

        coins = new int[]{1,4,5};
        amount = 28;
        System.out.println(new CoinChange().coinChange(coins, amount));

        coins = new int[]{1,2,5};
        amount = 100;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }
}
