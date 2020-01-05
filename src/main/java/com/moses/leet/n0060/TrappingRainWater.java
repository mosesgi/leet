package com.moses.leet.n0060;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        List<Integer> trap = new ArrayList<>();
        boolean heightMet = false;
        boolean goDown = false;
        for(int i=0; i<height.length; i++){
            if(!heightMet && height[i] == 0){
                continue;
            }
            if(!heightMet && height[i] > 0){
                heightMet = true;
                if(height[i+1] - height[i] >= 0){
                    continue;
                }
            }

            //height met
            if(height[i+1] - height[i] < 0){
                goDown = true;
            } else if(height[i+1] - height[i] >0){
                goDown = false;
            }

        }

    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(height));


    }
}
