package com.moses.leet.n0140;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length < 2){
            return max;
        }
        for(int i=1; i<prices.length; i++){
            if(prices[i] - prices[i-1]>0){
                max += (prices[i] - prices[i-1]);
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
