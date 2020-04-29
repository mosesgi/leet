package com.moses.leet.n0140;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; i++){
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    //Use DP. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
    public int maxProfitDp(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for(int i=1; i<prices.length; i++){
            buy[i] = Math.max(buy[i-1], -prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[prices.length-1];
    }


    public int maxProfitOld(int[] prices) {
        int max = 0;
        if(prices.length < 2){
            return 0;
        }
        int tmp = 0;
        for(int i=1; i<prices.length; i++){
            tmp = tmp + prices[i] - prices[i-1];
            if(tmp > max){
                max = tmp;
            }
            if(tmp < 0){
                tmp = 0;
            }
        }
        return max;
    }

    //slowest O(n^2)
    public int maxProfitSlow(int[] prices) {
        int max = 0;
        if(prices.length < 2){
            return 0;
        }
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]-prices[i] > max){
                    max = prices[j]-prices[i];
                }
            }
        }
        return max;
    }

//    private void recursive(int[] prices, int pos) {
//        for(int i=0; i<prices.length-1; i++){
//            for(int j=i+1; j<prices.length; j++){
//                if(j-i > max){
//                    max = j-1;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));

        prices = new int[]{7,6,4,3,1};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));

        prices = new int[]{9,2,3,6,1,2,3,7};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));

        prices = new int[]{2,3,6,1,2,3,9,7};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));

        prices = new int[]{2,3,6,3,4,3,9,7};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }
}
