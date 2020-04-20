package com.moses.leet.n0020;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        StringBuilder sb =new StringBuilder();
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            int tmp = target-nums[i];

            while(left < right){
                if(nums[left] + nums[right] == tmp){
                    return target;
                }else if(nums[left] + nums[right] < tmp ){
                    int d = Math.abs(nums[left]+nums[right] - tmp);
                    if(d < diff){
                        diff = d;
                        res = nums[i] + nums[left] + nums[right];
                    }
                    left++;
                }else{
                    int d = Math.abs(nums[left]+nums[right] - tmp);
                    if(d < diff){
                        diff = d;
                        res = nums[i] + nums[left] + nums[right];
                    }
                    right--;
                }
            }
        }
        return res;
    }



    public int threeSumClosestOld(int[] nums, int target){
        int result = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k=j+1;k<nums.length; k++){
                    int tmp = nums[i]+nums[j]+nums[k];
                    if(Math.abs(tmp-target) < diff){
                        diff = Math.abs(tmp-target);
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }

    public int threeSumClosestFast(int[] nums, int target){
        int result = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int l = i+1, r = nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r] == target){
                    return nums[i]+nums[l]+nums[r];
                }
                int tmpResult = nums[i]+nums[l]+nums[r];

                if(tmpResult < target) {
                    if (target - tmpResult < diff) {
                        diff = target - tmpResult;
                        result = tmpResult;
                    }
                    l++;
                } else if(tmpResult > target){
                    if(tmpResult - target < diff){
                        diff = tmpResult-target;
                        result = tmpResult;
                    }
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
    }
}
