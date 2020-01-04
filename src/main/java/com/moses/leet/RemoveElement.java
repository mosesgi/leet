package com.moses.leet;

public class RemoveElement{
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int n = new RemoveElement().removeElement(nums, 3);
        for(int i=0; i<n; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        nums = new int[]{0,1,2,2,3,0,4,2};
        n = new RemoveElement().removeElement(nums, 2);
        for(int i=0; i<n; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}