package com.moses.leet.n0600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for(int i=0; i<list1.length; i++){
            if(map1.containsKey(list1[i])){
                continue;
            }
            map1.put(list1[i], i);
        }

        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<list2.length; i++){
            if(map1.containsKey(list2[i])){
                int tmp = i + map1.get(list2[i]);
                if(tmp < min){
                    list.clear();
                    min = tmp;
                    list.add(list2[i]);
                }else if(tmp == min){
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
