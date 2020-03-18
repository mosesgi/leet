package com.moses.leet.n0480;

import java.util.Arrays;

public class MatchsticksToSquare {

    //1,1,1,2,2,2,3,4,4,4,4
    public boolean makesquare(int[] nums) {
        if(nums.length<4){
            return false;
        }
        int total = 0;
        for(int i : nums){
            total+=i;
        }
        if(total%4 != 0){
            return false;
        }
        int length = total/4;

        Arrays.sort(nums);
        if(nums[nums.length-1] > length){
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return dfs(nums, length, length, 0, used, 1);
    }

    private boolean dfs(int[] nums, int length, int remain, int cnt, boolean[] used, int level){
        if(remain == 0){
            cnt++;
            if(cnt == 4 && allUsed(used)){
                return true;
            }
            remain = length;
            level = 1;
        }
        for(int k=0; k<nums.length; k++){
            if(used[k]){
                continue;
            }
            if(nums[k] <= remain){
                break;
            }else{
                return false;
            }
        }
        for(int j= nums.length-1; j>=0; j--){
            if(used[j]){
                continue;
            }
            if(nums[j] <= remain) {
                used[j] = true;
                if(dfs(nums, length, remain-nums[j], cnt, used, level+1)){
                    return true;
                }else{
                    if(level == 1){
                        return false;
                    }
                }
                used[j] = false;
            }
        }
        return false;
    }

    private boolean allUsed(boolean[] used){
        for(int i=0; i<used.length; i++){
            if(!used[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{5,5,5,5,16,4,4,4,4,4,3,3,3,3,4};
        System.out.println(new MatchsticksToSquare().makesquare(nums));

        nums = new int[]{5,5,5,5,4,4,4,4,3,3,3,3};
        System.out.println(new MatchsticksToSquare().makesquare(nums));
        nums = new int[]{1,1,2,2,2};
        System.out.println(new MatchsticksToSquare().makesquare(nums));
        nums = new int[]{3,3,3,3,4};
        System.out.println(new MatchsticksToSquare().makesquare(nums));
        nums = new int[]{1,1,1,2,2,2,3,4,4,4,4};
        System.out.println(new MatchsticksToSquare().makesquare(nums));

    }
}
