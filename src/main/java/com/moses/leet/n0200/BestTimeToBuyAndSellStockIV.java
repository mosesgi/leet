package com.moses.leet.n0200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BestTimeToBuyAndSellStockIV {


    public int maxProfit(int k, int[] prices) {
        recursive(k, prices, 0);
        return 0;
    }

    private List<Integer> recursive(int k, int[] prices, int pos) {
        if(pos == prices.length){
            return new ArrayList<>();
        }
        List<Integer> rst = new ArrayList<>();
        for(int i=pos; i<prices.length-1; i++){
            for(int j=pos+1; j<prices.length; j++){
                rst = recursive(k, prices, j+1);
                if(prices[j]>prices[i]){
                    rst.add(prices[j]-prices[i]);
                    if(i==0){
                        System.out.println(Arrays.toString(rst.toArray()));
                    }
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int k; int[] prices;

        k = 2;
        prices = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(k, prices));

        k = 2;
        prices = new int[]{2,4,1};
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(k, prices));

        k = 2;
        prices = new int[]{3,2,6,5,0,3};
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(k, prices));
    }
}
