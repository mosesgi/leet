package com.moses.leet.n0140;


public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        int[] firstBuy = new int[n];
        int[] firstSell = new int[n];
        int[] secondBuy = new int[n];
        int[] secondSell = new int[n];
        firstBuy[0] = -prices[0];
        secondBuy[0] = -prices[0];
        firstSell[0] = 0;
        for(int i=1; i<prices.length; i++){
            firstBuy[i] = Math.max(firstBuy[i-1], -prices[i]);
            firstSell[i] = Math.max(firstSell[i-1], firstBuy[i-1] + prices[i]);
            secondBuy[i] = Math.max(secondBuy[i-1], firstSell[i-1] - prices[i]);
            secondSell[i] = Math.max(secondSell[i-1], secondBuy[i-1] + prices[i]);
        }
        return secondSell[n-1];
    }

    public int maxProfitOld(int[] prices) {
        int max = 0;
        if(prices.length<2){
            return max;
        }

        return first(prices, 0);
    }

    private int first(int[] prices, int currPos) {
        int max = 0;
        int first = 0;
        for(int i=currPos+1; i<prices.length; i++){
            int second = 0;
            if(first + prices[i]-prices[i-1] > 0){
                first += (prices[i] - prices[i-1]);
                second = second(prices, i+1);
            } else {
                first = 0;
                second = 0;
            }
            if(first + second > max){
                max = first+second;
            }
        }
        return max;
    }

    private int second(int[] prices, int startPos){
        int max = 0;
        int second = 0;
        for(int i=startPos+1; i<prices.length; i++){
            if(second + prices[i] - prices[i-1] > 0){
                second += (prices[i] - prices[i-1]);
            } else {
                second = 0;
            }
            if(second > max){
                max = second;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));       //13

        prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));       //6

        prices = new int[]{1,2,3,4,5};
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));       //4
    }
}
