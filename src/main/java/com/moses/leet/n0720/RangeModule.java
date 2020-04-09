package com.moses.leet.n0720;

import java.util.TreeMap;

public class RangeModule {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public RangeModule() {

    }

    public void addRange(int left, int right) {
        Integer low = map.floorKey(left);
        Integer high = map.floorKey(right);
        int nLeft = left, nRight = right;
        if(low !=null && map.get(low) >= left){
            nLeft = low;
        }
        if(high != null && map.get(high) > right){
            nRight = map.get(high);
        }
        map.put(nLeft, nRight);
        map.subMap(nLeft, false, nRight, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if(start == null){
            return false;
        }
        return map.get(start) >= right;
    }

    public void removeRange(int left, int right) {
        Integer low = map.floorKey(left);
        Integer high = map.floorKey(right);
        if(high != null && map.get(high) > right){
            map.put(right, map.get(high));      //cut the high range
        }
        if(low != null && map.get(low) > left){
            map.put(low, left);     //cut the low range
        }
        map.subMap(left, true, right, false).clear();
    }


    public static void main(String[] args) {
        RangeModule r = new RangeModule();
        r.addRange(10,20);
        r.removeRange(14,16);
        System.out.println(r.queryRange(10,14));
        System.out.println(r.queryRange(13,15));
        System.out.println(r.queryRange(16,17));
    }
}
