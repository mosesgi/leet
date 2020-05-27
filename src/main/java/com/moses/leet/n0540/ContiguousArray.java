package com.moses.leet.n0540;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        //1,0,0,  0, 1,1,1,1,1,0,1,1,0,0 = 14
        //1,0,-1,-2,-1,0,1,2,3,2,3,4,3,2
        int[] cnt = new int[nums.length];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i]==0?-1:1;
            cnt[i] = sum;
        }
        // System.out.println(Arrays.toString(cnt));
        Map<Integer, Integer> map =new HashMap<>();
        int res = 0;
        for(int i=0; i<cnt.length; i++){
            if(cnt[i] == 0){
                res = Math.max(res, i+1);
            }else{
                if(!map.containsKey(cnt[i])){
                    map.put(cnt[i], i);
                }else{
                    res = Math.max(res, i-map.get(cnt[i]));
                }
            }
        }
        return res;
    }


}
