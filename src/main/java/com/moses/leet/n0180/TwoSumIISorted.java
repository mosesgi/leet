package com.moses.leet.n0180;

public class TwoSumIISorted {
    // beat 54.97%
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; int right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            } else if(sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{0,0};
    }

    // beat 10%
    public int[] twoSum10per(int[] numbers, int target) {
        int first = 0;
        int second = 0;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] + numbers[numbers.length-1] < target){
                continue;
            }
            for(int j = i+1; j<numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    return new int[]{i+1, j+1};
                } else if(numbers[i] + numbers[j] > target){
                    break;
                }
            }
        }
        return new int[]{0,0};
    }
}
