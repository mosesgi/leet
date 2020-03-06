package com.moses.leet.n0420;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer i1=nums[0], i2= null, i3=null;
        for(int i=1; i<nums.length; i++){
            int curr = nums[i];
            if(curr > i1){
                i3 = i2;
                i2 = i1;
                i1 = curr;
            }else if(curr < i1){
                if(i2 == null){
                    i2 = curr;
                }else{
                    if(curr>i2){
                        i3 = i2;
                        i2 = curr;
                    }else if(curr < i2){
                        if(i3 == null){
                            i3 = curr;
                        }else{
                            if(curr > i3){
                                i3 = curr;
                            }
                        }
                    }
                }
            }
        }
        if(i3!=null){
            return i3;
        }
        return i1;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,2};
        System.out.println(new ThirdMaximumNumber().thirdMax(nums));
    }
}
