package com.moses.leet.n0140;


public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
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
