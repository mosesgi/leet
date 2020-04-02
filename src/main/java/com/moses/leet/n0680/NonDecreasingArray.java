package com.moses.leet.n0680;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<=1){
            return true;
        }
        int pos = 0;
        int originValue = -1;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1] < nums[i]){
                pos = i;
                originValue = nums[i];
                break;
            }
        }
        boolean notPass = false;

        //1st try. change pos to later value !NOT NECESSARY
//        nums[pos] = nums[pos+1];
//        for(int i=0; i<nums.length-1; i++){
//            if(nums[i+1] < nums[i]){
//                notPass = true;
//                break;
//            }
//        }
//        if(!notPass){
//            return true;
//        }

        //2nd try. change pos to prev value
        notPass = false;
        if(pos-1<0){
            nums[pos] = Integer.MIN_VALUE;
        }else {
            nums[pos] = nums[pos - 1];
        }
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1] < nums[i]){
                notPass = true;
                break;
            }
        }
        if(!notPass){
            return true;
        }

        //3rd try. change pos+1 to value of pos.
        notPass = false;
        nums[pos] = originValue;
        nums[pos+1] = originValue;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1] < nums[i]){
                notPass = true;
                break;
            }
        }
        return !notPass;
    }

    public static void main(String[] args) {

    }
}
