package com.moses.leet.n0080;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits){
        int promotion = 0;
        boolean worst = false;
        for(int i=digits.length-1; i>=0; i--){
            int rst = digits[i] + promotion;
            if(i==digits.length-1) {
                rst += 1;
            }
            if(rst ==10){
                promotion = 1;
                digits[i] = 0;
                if(i==0){
                    worst = true;
                }
            } else {
                promotion = 0;
                digits[i] = rst;
            }
        }

        int[] rst = worst?new int[digits.length+1]:digits;
        if(worst){
            rst[0] = 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(Arrays.toString(new PlusOne().plusOne(nums)));

        nums = new int[]{4,3,2,1};
        System.out.println(Arrays.toString(new PlusOne().plusOne(nums)));

        nums = new int[]{8,9,9};
        System.out.println(Arrays.toString(new PlusOne().plusOne(nums)));

        nums = new int[]{9,9,9,9,9};
        System.out.println(Arrays.toString(new PlusOne().plusOne(nums)));
    }
}
