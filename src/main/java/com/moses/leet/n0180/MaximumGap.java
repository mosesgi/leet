package com.moses.leet.n0180;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int maxGap = 0;
        if(nums.length <=1){
            return maxGap;
        }
        radixSort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1] - nums[i] > maxGap){
                maxGap = nums[i+1] - nums[i];
            }
        }
        return maxGap;
    }


    //桶排序/基数排序. 10个桶, 0-10, 从个位放到最高位  https://www.jianshu.com/p/1fad0269e378
    public void radixSort(int[] nums){
        int len = nums.length;
        int maxDigits = 1;
        for(int num: nums){
            int cnt = 1;
            while(num > 0){
                num = num/10;
                cnt++;
            }
            if(cnt > maxDigits){
                maxDigits = cnt;
            }
        }

        int div = 1;
        for(int i=0; i<maxDigits; i++){
            int[][] buckets = new int[10][len];
            int[] bCnt = new int[10];       //store how many numbers in each bucket

            for(int num : nums){
                int tmp = num/div;
                int pos = tmp%10;
                buckets[pos][bCnt[pos]++] = num;
            }

            int n = 0;
            for(int j=0; j<buckets.length; j++){
                if(bCnt[j] != 0){
                    for(int k=0; k<bCnt[j]; k++){
                        nums[n++] = buckets[j][k];
                    }
                    bCnt[j] = 0;
                }
            }
            div*=10;
        }
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{3,6,9,1};
        System.out.println(new MaximumGap().maximumGap(nums));
        new MaximumGap().radixSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{20,1,60,8,32};
        System.out.println(new MaximumGap().maximumGap(nums));
        new MaximumGap().radixSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{100,3,2,1};
        System.out.println(new MaximumGap().maximumGap(nums));
        new MaximumGap().radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
