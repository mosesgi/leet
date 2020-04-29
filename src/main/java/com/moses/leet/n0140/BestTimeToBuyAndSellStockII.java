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

    public int maxProfitDp(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for(int i=1; i<prices.length; i++){
            buy[i] = Math.max(buy[i-1], sell[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[prices.length-1];
    }

    public static void main(String[] args) {

    }
}
