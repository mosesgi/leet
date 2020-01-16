package com.moses.leet.n0100;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * https://blog.csdn.net/yutianzuijin/article/details/52072427  中文解释都搞不明白...
 * https://www.cnblogs.com/felixfang/p/3676193.html
 */
public class LargestRectangleInHistogram {
    //O(n^2)
    public int largestRectangleArea(int[] heights){
        int largest = 0;
        for(int i=0; i<heights.length; i++){
            int lowest = Integer.MAX_VALUE;
            for(int j= i; j<heights.length; j++){
                lowest = heights[j]<lowest?heights[j]:lowest;
                int tmpSize = (j-i+1)*lowest;
                if(tmpSize > largest){
                    largest = tmpSize;
                }
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));

        heights = new int[]{5,2,1,3,4,6,10};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));

    }
}
