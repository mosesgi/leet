package com.moses.leet.n0660;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len];
        int sum = 0;
        Integer dup = null;
        for(int i : nums){
            sum+=i;
            cnt[i-1]++;
            if(cnt[i-1] == 2){
                dup = i;
            }
        }
        int origin = len * (len+1)/2;
        int miss = origin-(sum-dup);
        return new int[]{dup, miss};
    }
}
