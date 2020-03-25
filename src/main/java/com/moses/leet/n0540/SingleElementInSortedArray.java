package com.moses.leet.n0540;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        //3,3,5,7,7,11,11
        int left = 0; int right = nums.length-1;
        while(left < right){
            int half = (right-left)/2;
            int mid = half + left;
            if(half == 1){
                if(nums[mid] == nums[mid-1]){
                    return nums[mid+1];
                }else{
                    return nums[mid-1];
                }
            }
            if(half%2 == 0){
                if(nums[mid] == nums[mid-1]){
                    right = mid;
                }else{
                    left = mid;
                }
            }else{
                if(nums[mid] == nums[mid-1]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[19999];
        int idx = 0;
        for(int i=1; i<=10000; i++){
            if(i == 4325){
                nums[idx++] = i;
            }else{
                nums[idx++] = i;
                nums[idx++] = i;
            }
        }
        System.out.println(new SingleElementInSortedArray().singleNonDuplicate(nums));

        nums = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(new SingleElementInSortedArray().singleNonDuplicate(nums));

        nums = new int[]{3,3,7,7,10,11,11};
        System.out.println(new SingleElementInSortedArray().singleNonDuplicate(nums));

    }
}
