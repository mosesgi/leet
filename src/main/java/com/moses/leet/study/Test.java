package com.moses.leet.study;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class Test {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            int remain = -nums[i];
            int l = i+1, r = nums.length-1;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while(l<r){
                if(nums[l] + nums[r] == remain){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l+1<r && nums[l+1] == nums[l]){
                        l++;
                    }
                    while(r-1 > l && nums[r-1] == nums[r]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(nums[l] + nums[r] < remain){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-1,0};
        new Test().threeSum(nums);
    }
}
