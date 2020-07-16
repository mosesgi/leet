package com.moses.leet.lcci;

//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
public class NumTimesInArray {
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        for(int i:nums){
            for(int j=1; j<=32; j++){
                cnt[j-1] += i & 1;
                i>>>=1;
            }
        }

        int res = 0;
        for(int i=0; i<cnt.length; i++){
            cnt[i]%=3;
            res |= cnt[i]<<i;
        }
        return res;
    }
}
