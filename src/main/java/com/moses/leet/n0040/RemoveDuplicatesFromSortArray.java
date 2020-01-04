package com.moses.leet.n0040;

public class RemoveDuplicatesFromSortArray{
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }


    public int removeDuplicates1(int[] nums){
        int len = nums.length;
        if(len == 0) return len;
        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int n = new RemoveDuplicatesFromSortArray().removeDuplicates(nums);
        for(int i=0; i<n; i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        n= new RemoveDuplicatesFromSortArray().removeDuplicates(nums);
        for(int i=0; i<n; i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}