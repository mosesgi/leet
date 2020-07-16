package com.moses.leet.lcci;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
public class ContinuousSequenceWithSumOfTarget {
    public int[][] findContinuousSequence(int target) {
        int max = target/2;
        int i=1, j=1;
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while(i <= max){
            if(sum < target){
                sum += j;
                j++;
            }else if(sum > target){
                sum -= i;
                i++;
            }else{
                int[] r = new int[j-i];
                for(int k=i; k<j; k++){
                    r[k-i] = k;
                }
                list.add(r);
                sum += j;
                j++;
            }
        }
        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        System.out.println(new ContinuousSequenceWithSumOfTarget().findContinuousSequence(9));
    }
}
