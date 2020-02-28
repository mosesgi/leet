package com.moses.leet.n0340;

public class IncreasingTripletSubsequence {

    //自己死活没想出, 这是唯一解
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for(int i: nums){
            if(i<=min){
                min = i;
            } else if(i <= max){
                max = i;
            } else {
                return true;
            }
        }
        return false;
    }
}
