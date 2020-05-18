package com.moses.leet.n0380;

import java.util.HashSet;
import java.util.Set;

public class WaterAndJugProblem {

    //https://leetcode.com/problems/water-and-jug-problem/discuss/83715/Math-solution-Java-solution
    //Bézout's identity  数论: 裴蜀定理

    public boolean canMeasureWater(int x, int y, int z) {
        if(z==0 || x == z || y == z || x+y == z){
            return true;
        }
        if(x==0|| y==0 || x==y){
            return false;
        }
        if(y > x) {
            return recursive(x, y, null, z);
        }else {
            return recursive(y, x, null, z);
        }
    }

    // y is bigger
    private boolean recursive(int x, int y, Integer xLeft, int z) {
        int tmp = y;
        if(xLeft != null){
            if(y+xLeft == z){
                return true;
            }
            tmp = tmp - xLeft;
        }
        while(tmp > x){
            if(tmp == z){
                return true;
            }
            tmp = tmp-x;
        }
        if(tmp == x){
            return false;
        }else{
            if(tmp + y == z){
                return true;
            }
            return recursive(x, y, x-tmp, z);
        }
    }

    public static void main(String[] args) {
        System.out.println(new WaterAndJugProblem().canMeasureWater(13,11,1));
        System.out.println(new WaterAndJugProblem().canMeasureWater(1,2,3));
        System.out.println(new WaterAndJugProblem().canMeasureWater(0,2,1));
        System.out.println(new WaterAndJugProblem().canMeasureWater(3,5,4));
        System.out.println(new WaterAndJugProblem().canMeasureWater(2,6,5));
    }
}
