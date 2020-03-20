package com.moses.leet.n0500;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        Map<String, Integer> dp = new HashMap<>();
        return dfs(nums, S, 0, dp);
    }

    private int dfs(int[] nums, int s, int idx, Map<String, Integer> dp) {
        if(idx == nums.length ){
            if(s == 0){
                return 1;
            }else{
                return 0;
            }
        }

        String key = s+"_"+idx;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        int pos = dfs(nums, s+nums[idx], idx+1, dp);
        int neg = dfs(nums, s-nums[idx], idx+1, dp);
        dp.put(key, pos+neg);
        return pos+neg;
    }

    public int findTargetSumWaysWithoutDP(int[] nums, int S) {
        return dfs(nums, S, 0);
    }

    private int dfs(int[] nums, int s, int idx) {
        if(idx == nums.length ){
            if(s == 0){
                return 1;
            }else{
                return 0;
            }
        }
        int pos = dfs(nums, s+nums[idx], idx+1);
        int neg = dfs(nums, s-nums[idx], idx+1);
        return pos+neg;
    }


    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{27,22,39,22,40,32,44,45,46,8,8,21,27,8,11,29,16,15,41,0};
        System.out.println(new TargetSum().findTargetSumWays(nums, 10));

        nums = new int[]{1,1,1,1,1};
        System.out.println(new TargetSum().findTargetSumWays(nums, 3));
    }
}
