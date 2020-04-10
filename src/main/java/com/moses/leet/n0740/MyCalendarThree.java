package com.moses.leet.n0740;

import java.util.TreeMap;

//Based on Solution - counting boundaries, failed to figure it out myself.
public class MyCalendarThree {
    TreeMap<Integer, Integer> cnts;
    public MyCalendarThree() {
        cnts = new TreeMap<>();
    }

    public int book(int start, int end) {
        cnts.put(start, cnts.getOrDefault(start, 0) + 1);
        cnts.put(end, cnts.getOrDefault(end, 0) - 1);
        int max = 0, cnt = 0;
        for(Integer key: cnts.keySet()){
            cnt += cnts.get(key);
            if(cnt > max){
                max = cnt;
            }
        }
        return max;
    }
}
