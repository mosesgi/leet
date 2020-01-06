package com.moses.leet.n0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    private int calculateTrap(List<Integer> trap) {
        if(trap.isEmpty()){
            return 0;
        }
        System.out.println(Arrays.toString(trap.toArray()));
        int left = trap.get(0);
        int right = trap.get(trap.size()-1);
        int max = left<right?left:right;

        int trapResult = 0;
        for(int i = 0; i<trap.size(); i++){
            if(i==0 || i== trap.size()-1){
                continue;
            }
            if(max - trap.get(i) > 0) {
                trapResult += (max - trap.get(i));
            }
        }
        return trapResult;
    }


    public int trap(int[] height) {
        boolean heightMet = false;
        int result = 0;
        if(height.length <= 1){
            return 0;
        }

        int currTall = 0;
        while(currTall < height.length-1){
            List<Integer> trap = new ArrayList<>();
            if(!heightMet && height[currTall] == 0){
                currTall++;
                continue;
            }
            if(!heightMet && height[currTall] > 0){
                if(height[currTall+1] - height[currTall] >= 0){
                    currTall++;
                    continue;
                } else {
                    heightMet = true;
                }
            }

            //height met
            int nextTall = currTall;
            int tmpTall = 0;
            for(int j= currTall+1; j<height.length; j++){
                if(height[j] >= height[currTall]){
                    nextTall = j;
                    break;
                }
                if(height[j] > tmpTall){
                    tmpTall = height[j];
                    nextTall = j;
                }
                if(j==height.length-1 && tmpTall == 0){
                    nextTall = height.length - 1;
                }
            }

            for(int j=currTall; j<=nextTall; j++){
                trap.add(height[j]);
            }
            result += calculateTrap(trap);
            currTall = nextTall;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(height));

        height = new int[]{0,2,0};
        System.out.println(new TrappingRainWater().trap(height));

        height = new int[]{0,2,0,0};
        System.out.println(new TrappingRainWater().trap(height));

        height = new int[]{5,2,1,2,1,5};
        System.out.println(new TrappingRainWater().trap(height));

        height = new int[]{5,4,1,2};
        System.out.println(new TrappingRainWater().trap(height));

        height = new int[]{2,1,4,5};
        System.out.println(new TrappingRainWater().trap(height));

        height = new int[]{2,0,2};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
