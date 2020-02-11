package com.moses.leet.n0200;

import java.util.*;

public class BestTimeToBuyAndSellStockIV {
    Set<List<Integer>> rst = new HashSet<>();

    //TLE
    public int maxProfit(int k, int[] prices) {
        List<Integer> list = new ArrayList<>();
        recursive(k, prices, 0, list);

        int max = 0;
        for(List<Integer> l : rst){
            Collections.sort(l);
//            System.out.println(Arrays.toString(l.toArray()));
            int tmpMax = 0;
            int tmpK = k;
            for(int i = l.size()-1; i>=0 && tmpK >0; i--, tmpK--){
                tmpMax += l.get(i);
            }
            if(tmpMax > max){
                max = tmpMax;
            }
        }
        return max;
    }

    private void recursive(int k, int[] prices, int pos, List<Integer> list) {
        if(pos >= prices.length-1){
            rst.add(new ArrayList<>(list));
            return;
        }
        for(int i=pos; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]>prices[i]){
                    list.add(prices[j]-prices[i]);
                    recursive(k, prices, j+1, list);
                    list.remove(list.size()-1);
                }
            }
        }
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
