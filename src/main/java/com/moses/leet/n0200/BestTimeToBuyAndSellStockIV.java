package com.moses.leet.n0200;

import java.util.*;

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        if(k> prices.length/2){
            //infinite
            int result = 0;
            for(int i=1; i<prices.length; i++){
                if(prices[i] > prices[i-1]){
                    result += prices[i]-prices[i-1];
                }
            }
            return result;
        }
        int[][] buy = new int[prices.length][k+1];
        int[][] sell = new int[prices.length][k+1];
        for(int i=0; i<=k; i++){
            buy[0][i] = -prices[0];
        }
        int max = 0;
        for(int m=1; m<=k; m++){
            for(int i=1; i<prices.length; i++){
                buy[i][m] = Math.max(sell[i-1][m-1]-prices[i], buy[i-1][m]);
                sell[i][m] = Math.max(buy[i-1][m]+prices[i], sell[i-1][m]);
                max = Math.max(max, sell[i][m]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int k; int[] prices;

        k=2;
        prices= new int[]{3,3,5,0,0,3,1,4};
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(k, prices));

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

    //TLE
    Set<List<Integer>> rst = new HashSet<>();
    public int maxProfitTLE(int k, int[] prices) {
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


}
