package com.moses.leet.n0020;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height){
        int max = 0;
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int twoHeight = Math.min(height[i], height[j]);
                if((j-i) * twoHeight > max){
                    max = (j-i) * twoHeight;
                }
            }
        }
        return max;
    }


    public int maxAreaN(int[] height){
        int max = 0;
        int left = 0; int right = height.length-1;
        while(left<right){
            max = Math.max( max, Math.min(height[left], height[right]) * (right-left));
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(cwmw.maxAreaN(a));

        a = new int[]{1,1};
        System.out.println(cwmw.maxAreaN(a));
    }
}
