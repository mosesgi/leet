package com.moses.leet.n1200;

public class MaximumSubarraySumWithOneDeletion {
    public int maximumSum(int[] arr) {
        int[] notDelete = new int[arr.length];
        int[] deleteOne = new int[arr.length];

        notDelete[0] = arr[0];
        deleteOne[0] = 0;
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            notDelete[i] = Math.max(arr[i], notDelete[i-1] + arr[i]);

            deleteOne[i] = Math.max(deleteOne[i-1] + arr[i], notDelete[i-1]);

            max = Math.max(max, Math.max(notDelete[i], deleteOne[i]));
        }
        return max;
    }
}
