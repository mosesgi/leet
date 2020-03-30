package com.moses.leet.n0640;

import java.util.*;

public class ShoppingOffers {
//    Map<String, Integer> dp = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        String key = Arrays.toString(needs.toArray());
//        if(dp.containsKey(key)){
//            return dp.get(key);
//        }
        int min = Integer.MAX_VALUE;
        for(List<Integer> spe : special){
            boolean allBig = true;
            List<Integer> newNeeds = new ArrayList<>();
            for(int i=0; i<needs.size(); i++){
                if(needs.get(i) < spe.get(i)){
                    allBig = false;
                    break;
                }else{
                    newNeeds.add(needs.get(i) - spe.get(i));
                }
            }
            if(allBig){
                min = Math.min(min, spe.get(spe.size()-1) + shoppingOffers(price, special, newNeeds));
            }
        }
        int withoutSpecial = 0;
        for(int i=0; i<needs.size(); i++){
            withoutSpecial += price.get(i) * needs.get(i);
        }
        min = Math.min(min, withoutSpecial);
//        dp.put(key, min);
        return min;
    }
}
