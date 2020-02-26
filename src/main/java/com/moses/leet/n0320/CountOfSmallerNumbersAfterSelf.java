package com.moses.leet.n0320;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {

    //https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76576/My-simple-AC-Java-Binary-Search-code
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> l = new ArrayList<>();
        List<Integer> sort = new ArrayList<>();

        outer: for(int i=nums.length-1; i>=0; i--){
            if(sort.size()==0){
                sort.add(nums[i]);
                l.add(0);
                continue;
            } else if(sort.size() == 1){
                int pos = sort.get(0) < nums[i]?1:0;
                l.add(0, pos);
                sort.add(pos, nums[i]);
                continue;
            }
            int left = 0;
            int right = sort.size()-1;
            Integer pos = null;
            while(left <= right){
                if(left+1 == right){
                    if(nums[i] <= sort.get(left)){
                        pos = left;
                    } else if(nums[i] > sort.get(right)){
                        pos = right+1;
                    } else if(nums[i] == sort.get(right)){
                        while(right >=0 && sort.get(right) == nums[i]){
                            right--;
                        }
                        pos = right+1;
                    } else {
                        pos = right;
                    }
                    l.add(0, pos);
                    sort.add(pos, nums[i]);
                    continue outer;
                } else if(left == right){
                    if(nums[i] <= sort.get(left)){
                        pos = left;
                    } else if(nums[i] > sort.get(left)){
                        pos = right+1;
                    } else if(nums[i] == sort.get(left)){
                        while(left >=0 && sort.get(left) == nums[i]){
                            left--;
                        }
                        pos = left+1;
                    } else {
                        pos = right;
                    }
                    l.add(0, pos);
                    sort.add(pos, nums[i]);
                    continue outer;
                }
                int mid = left + (right-left)/2;
                if(sort.get(mid) == nums[i]){
                    while(mid>=0 && sort.get(mid) == nums[i]){
                        mid--;
                    }
                    pos = mid+1;
                    break;
                } else if(sort.get(mid) < nums[i]){
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if(pos == null){
                pos = right+1;
            }
            l.add(0, pos);
            sort.add(pos, nums[i]);
        }
        return l;
    }


    public List<Integer> countSmallerSlow(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<nums.length; i++){

            int cnt = 0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] < nums[i]){
                    cnt++;
                }
            }
            l.add(cnt);
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{5,2,6,1};
        System.out.println(Arrays.toString(new CountOfSmallerNumbersAfterSelf().countSmaller(nums).toArray()));

        nums = new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(Arrays.toString(new CountOfSmallerNumbersAfterSelf().countSmallerSlow(nums).toArray()));

    }
}
