package com.moses.leet.n0540;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(k!=0) {
                sum = sum % k;
            }
            if(map.containsKey(sum)){
                if(i-map.get(sum) > 1){
                    return true;
                }
            }else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;
        nums = new int[]{0,0};
        k= -1;
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums, k));


        nums = new int[]{18,373,97,499,525,170,133,376,77,279,257,168,319,335,237,36,236,41,360,131,172,279,405,236,296,377,348,411,135,411,273,230,103,274,211,427,101,243,31,485,282,40,28,81,6,318,502,521,140,110,467,248,404,107,108,129,113,113,333,83,242,194,112,446,463,102,145,107,73,47,53,455,301,150,314,13,180,119,234,509,199,503,69,224,228,427,309,497,342,329,518,35,425,343,417,509,85,234,426,334};
        k = 250;
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums, k));

    }

    public boolean checkSubarraySumOn2(int[] nums, int k) {
        for(int i=0; i<nums.length-1; i++){
            int tmp = nums[i];
            for(int j=i+1; j<nums.length; j++){
                tmp+=nums[j];
                if(k==0){
                    if(tmp == 0) {
                        return true;
                    }
                }else if(tmp % k == 0){
                    return true;
                }
            }
        }
        return false;
    }


}
