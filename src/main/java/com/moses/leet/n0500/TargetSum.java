package com.moses.leet.n0500;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        Integer[][] mem = new Integer[nums.length][2003];
        return dfs(nums, 0, 0, S, mem);
    }

    int dfs(int[] nums, int pos, int sum, int S, Integer[][] mem){
        if(pos == nums.length){
            if(S==sum){
                return 1;
            }
            return 0;
        }
        int sPlus = sum + 1000;
        if(mem[pos][sPlus] != null){
            return mem[pos][sPlus];
        }
        int a = dfs(nums, pos+1, sum + nums[pos], S, mem);
        int b = dfs(nums, pos+1, sum - nums[pos], S, mem);
        mem[pos][sPlus] = a + b;
        return mem[pos][sPlus];
    }

    public int findTargetSumWays1(int[] nums, int S) {
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
