package com.moses.leet.n0740;

import java.util.TreeMap;

public class MyCalendarI {
    class MyCalendar {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer floor = map.floorKey(start);
            if(floor != null && map.get(floor) > start){
                return false;
            }
            Integer ceil = map.lowerKey(end);
            if(ceil != null && map.get(ceil) > start){
                return false;
            }
            map.put(start, end);
            return true;
        }
    }
}
