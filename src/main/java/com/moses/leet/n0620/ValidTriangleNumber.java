package com.moses.leet.n0620;

import java.util.Arrays;

public class ValidTriangleNumber {
    //O(N^2)
    public int triangleNumber(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(nums[i] == 0){
                continue;
            }
            int k = i+2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while(k<nums.length && nums[k]< nums[i]+nums[j]){
                    k++;
                }
                cnt += k-j-1;
            }
        }
        return cnt;
    }

    //1,1,1,1,2,3,3,4,4,4,5,5,6
    // c < a+b && c > b-a && c > a-b
    // O(N^2LogN)
    public int triangleNumberON2LogN(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];

                int min = b-a;
                int max = a+b;
                int minIdx = j+1;
                for(int k = minIdx; k<nums.length; k++){
                    if(nums[k] > min){
                        minIdx = k;
                        break;
                    }
                }

                int maxIdx = Arrays.binarySearch(nums, max);
                if(maxIdx < 0){
                    maxIdx = -maxIdx-2;
                }else{
                    for(int k = maxIdx; k>=0; k--){
                        if(nums[k] < nums[maxIdx]){
                            maxIdx = k;
                            break;
                        }
                    }
                }
                if(maxIdx == nums.length){
                    maxIdx = nums.length-1;
                }
                if (maxIdx >= minIdx) {
                    cnt+= (maxIdx - minIdx+1);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{14,67,0,81,92,53,64,6,12,51,51,51,28,50,80,42,96,76,5,71,84,18,75,37,42,41,76,87,19,37,64,73,9,87,27,67,40,43,21,15,86,26,76,4,8,67,28,7,53,47,91,71,58,22,0,31,20,45,98,62,23,12,6,37,78,6,37,67,71,98,82,31,96,14,95,27,21,50,4,25,33,24,23,68,59,65,72,80,35,36,30,15,7,76,84,0,79,54,5,95};
        System.out.println(new ValidTriangleNumber().triangleNumber(nums));

        nums = new int[]{1,1,3,4};        //0
        System.out.println(new ValidTriangleNumber().triangleNumber(nums));

        nums = new int[]{1,1,2,3,3,4,5};        //10
        System.out.println(new ValidTriangleNumber().triangleNumber(nums));

        nums = new int[]{1,1,1,1,2,3,3,4,4,4,5,5,6};        //98
        System.out.println(new ValidTriangleNumber().triangleNumber(nums));

        nums = new int[]{2,2,3,4};      //3
        System.out.println(new ValidTriangleNumber().triangleNumber(nums));
    }

    public int triangleNumberON3(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length-2; i++){
            int a = nums[i];
            for(int j=i+1; j<nums.length-1; j++){
                int b = nums[j];
                for(int k=j+1; k<nums.length; k++){
                    int c = nums[k];
                    if(a+b > c && a+c > b && b+c > a){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }



}
