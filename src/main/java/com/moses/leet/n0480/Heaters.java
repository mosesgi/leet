package com.moses.leet.n0480;

import java.util.Arrays;
import java.util.TreeSet;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> heatSet = new TreeSet<>();
        for(int i: heaters){
            heatSet.add(i);
        }
        int min = 0;
        for(int i=0; i<houses.length; i++){
            int pos = houses[i];
            if(heatSet.contains(pos)){
                continue;
            }
            Integer lower = heatSet.lower(pos);
            Integer higher = heatSet.higher(pos);
            if(lower == null){
                min = Math.max(min, higher - pos);
                continue;
            }
            if(higher == null){
                min = Math.max(min, pos-lower);
                continue;
            }
            int tmp = Math.min(pos-lower, higher-pos);
            min = Math.max(tmp, min);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] houses, heaters;
        houses = new int[]{1,1,1,1,1,1,999,999,999,999,999};
        heaters = new int[]{499,500,501};
        System.out.println(new Heaters().findRadius(houses, heaters));

        houses = new int[]{1,2,3,5,15};
        heaters = new int[]{2,30};
        System.out.println(new Heaters().findRadius(houses, heaters));

        houses = new int[]{1};
        heaters = new int[]{1,2,3,4};
        System.out.println(new Heaters().findRadius(houses, heaters));

        houses = new int[]{1,5};
        heaters = new int[]{10};
        System.out.println(new Heaters().findRadius(houses, heaters));

        houses =new int[]{2,3,4,7,10,11,13,15,17,18,20,23};
        heaters = new int[]{4, 11, 23};
        System.out.println(new Heaters().findRadius(houses, heaters));

        houses = new int[]{1,2,3};
        heaters = new int[]{2};
        System.out.println(new Heaters().findRadius(houses, heaters));

        houses = new int[]{1,2,3,4};
        heaters = new int[]{1,4};
        System.out.println(new Heaters().findRadius(houses, heaters));

    }
}
