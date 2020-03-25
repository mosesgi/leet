package com.moses.leet.n0560;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySumFastON(int[] nums, int k) {
        int cnt = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i : nums){
            sum+=i;
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

    //O(N^2)
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            int tmp = 0;
            for(int j=i; j<nums.length; j++){
                tmp+=nums[j];
                if(tmp == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int subarraySumWrong(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        int left = 0, right = 0;
        int cnt = 0;
        int tmp = 0;
        while(left <=right && right <nums.length){
            while(right < nums.length && tmp <= k){
                tmp += nums[right];
                if(tmp == k){
                    cnt++;
                }
                right++;
            }
            while(left < nums.length && left < right && tmp >=k){
                tmp -= nums[left];
                left++;
                if(left != right && tmp == k){
                    cnt++;
                }
            }
        }
        while(left < nums.length && left < right){
            tmp -=nums[left];
            left++;
            if(left != right && tmp == k){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;

        nums = new int[]{28,54,7,-70,22,65,-6};
        k = 100;
        System.out.println(new SubarraySumEqualsK().subarraySumWrong(nums, k));

        nums = new int[]{-1,-1,1};
        k = 0;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));

        nums = new int[]{1,2,3};
        k = 0;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));

        nums = new int[]{1};
        k = 0;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));

        nums = new int[]{2,1,4,5,6,1,3,2,2,3,4,5,6,1,2};
        k = 9;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));
    }
}
