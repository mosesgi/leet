package com.moses.leet.n0660;

import java.util.*;

public class SplitArrayIntoConsecutiveSubsequences {
    //1236789
    //123345
    //1233344455666
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i=0; i<nums.length; ){
            if(map.get(nums[i]) == 0){
                i++;
                continue;
            }
            int size = 1;
            int curr = nums[i];
            int cnt = map.get(curr);
            map.put(curr, map.get(curr)-1);
            if(cnt == 1){
                i++;
            }
            while(map.containsKey(curr+1) && map.get(curr+1)>=cnt){
                size++;
                curr++;
                cnt = map.get(curr);
                map.put(curr, map.get(curr)-1);
                if(cnt == 1){
                    i++;
                }
            }
            if(size < 3){
                return false;
            }
        }
        return true;
    }

    public boolean isPossibleONLogN(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while(!map.isEmpty()){
            int start = map.firstKey();
            int size = 1;
            int cnt = map.get(start);
            if(cnt == 1){
                map.remove(start);
            }else{
                map.put(start, cnt-1);
            }
            while(map.containsKey(start+1) && map.get(start+1)>=cnt){
                size++;
                start++;
                cnt = map.get(start);
                if(cnt == 1){
                    map.remove(start);
                }else{
                    map.put(start, cnt-1);
                }
            }
            if(size<3){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,2,3,4,4,5};
        System.out.println(new SplitArrayIntoConsecutiveSubsequences().isPossible(nums));

        nums = new int[]{1,2,3,3,4,5};
        System.out.println(new SplitArrayIntoConsecutiveSubsequences().isPossible(nums));
    }
}
