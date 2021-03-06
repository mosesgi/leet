package com.moses.leet.n0020;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i>=1 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int l=j+1, r= nums.length-1;
                while(l<r){
                    int tmp = nums[i]+nums[j]+nums[l]+nums[r];
                    if(tmp == target){
                        List<Integer> lis = Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                        result.add(lis);
                        l++;
                        r--;
                        while(l<r && nums[l] == nums[l-1]){
                            l++;
                        }
                        while(r>l && nums[r] == nums[r+1]){
                            r--;
                        }
                    } else if(tmp < target){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSumOld(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                int l=j+1, r= nums.length-1;
                while(l<r){
                    int tmp = nums[i]+nums[j]+nums[l]+nums[r];
                    if(tmp == target){
                        List<Integer> lis = Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                        if(!result.contains(lis)){
                            result.add(lis);
                        }
                        l++;
                        r--;
                    } else if(tmp < target){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,0,-4,2,2,2,-2,-2};
        List<List<Integer>> list = new FourSum().fourSum(nums, 0);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray(new Integer[]{})));
        }

        System.out.println();

        nums = new int[]{-3,-2,-1,0,0,1,2,3};
        list = new FourSum().fourSum(nums, -1);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray(new Integer[]{})));
        }
        System.out.println();

        nums = new int[]{-1,0,1,2,-1,-4};
        list = new FourSum().fourSum(nums, -1);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray(new Integer[]{})));
        }
        System.out.println();

        nums = new int[]{1,0,-1,0,-2,2};
        list = new FourSum().fourSum(nums, 0);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray(new Integer[]{})));
        }
        System.out.println();

        nums = new int[]{0,0,0,0};
        list = new FourSum().fourSum(nums, 0);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray(new Integer[]{})));
        }
    }
}
