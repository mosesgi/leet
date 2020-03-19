package com.moses.leet.n0500;

import java.util.Arrays;

public class ConstructRectangle {

    public int[] constructRectangleSimpler(int area) {
        double len = Math.sqrt(area);
        int w = (int)len;
        while(area%w!=0){
            w--;
        }
        return new int[]{area/w, w};
    }

    public int[] constructRectangle(int area) {
        double len = Math.sqrt(area);
        int base = (int)len;
        if(base * base == area){
            return new int[]{base, base};
        }
        for(int l = base+1; l<=area; l++){
            if(area%l==0){
                return new int[]{l, area/l};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(4)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(8)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(24)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(68)));
    }
}
