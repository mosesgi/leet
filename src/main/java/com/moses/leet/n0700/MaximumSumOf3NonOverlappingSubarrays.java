package com.moses.leet.n0700;

import java.util.Arrays;

public class MaximumSumOf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for(int i=1; i<len; i++){
            sum[i] = sum[i-1] + nums[i];
        }

        int[] posLeft = new int[len], posRight = new int[len];
        int total = 0;
        //Left side starting from 0
        total = sum[k-1];
        for(int i=k;i<len; i++){
            if(sum[i] - sum[i-k] > total){
                posLeft[i] = i-k+1;
                total = sum[i] - sum[i-k];
            }else{
                posLeft[i] = posLeft[i-1];
            }
        }

        //right side ends on len-1
        posRight[len-k] = len-k;
        total = sum[len-1] - sum[len-k-1];
        for(int i=len-k; i>0; i--){
            if(sum[i+k-1] - sum[i-1] >= total){
                posRight[i] = i;
                total = sum[i+k-1] - sum[i-1];
            }else{
                posRight[i] = posRight[i+1];
            }
        }

        int maxSum = 0;
        int[] ans = new int[3];
        //scan middle. keep window of k, because there must be a maximum sum for the middle when scanning from k to len-2k.
        for(int i=k; i<=len-2*k; i++){
            int left = posLeft[i-1], right = posRight[i+k];
            int tot = sum[i+k-1]-sum[i-1] + sum[left+k-1]-(left==0?0:sum[left-1]) + sum[right+k-1]-sum[right-1];
            if(tot > maxSum){
                maxSum = tot;
                ans[0] = left;
                ans[1] = i;
                ans[2] = right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;
        nums = new int[]{7,13,20,19,19,2,10,1,1,19};        //1,4,7
        k=3;
        System.out.println(Arrays.toString(new MaximumSumOf3NonOverlappingSubarrays().maxSumOfThreeSubarrays(nums, k)));

        nums = new int[]{1,2,1,2,6,7,5,1,4,5,2,3,5,6,2,3,4,6,3,2,8,9,3,2};
        k=3;
        System.out.println(Arrays.toString(new MaximumSumOf3NonOverlappingSubarrays().maxSumOfThreeSubarrays(nums, k)));

        nums = new int[]{1,2,1,2,6,7,5,1};
        k=2;
        System.out.println(Arrays.toString(new MaximumSumOf3NonOverlappingSubarrays().maxSumOfThreeSubarrays(nums, k)));
    }

    //pretty close.... cannot use 2-dimensional array -> Memory limit Exceeded
    public int[] maxSumOfThreeSubarraysOLE(int[] nums, int k) {
        long[][] valueDp = new long[nums.length][nums.length];
        int[][] posDp = new int[nums.length][nums.length];

        for(int i=0; i<=nums.length-k; i++){
            int tmp = 0;
            for(int m=i; m<i+k; m++){
                tmp += nums[m];
            }
            valueDp[i][i+k-1] = tmp;
            posDp[i][i+k-1] = i;
            long tmpMax = tmp;
            int tmpPos = i;
            for(int j= i+k; j<nums.length; j++){
                tmp = tmp+nums[j]-nums[j-k];
                if(tmp > tmpMax){
                    tmpMax = tmp;
                    tmpPos = j-k+1;
                }
                valueDp[i][j] = tmpMax;
                posDp[i][j] = tmpPos;
            }
        }

        int[] rst = new int[3];
        long max = 0;
        for(int i=k; i<=nums.length-2*k; i++){
            for(int j=i+k; j<=nums.length-k; j++){
                if(valueDp[0][i-1] + valueDp[i][j-1] + valueDp[j][nums.length-1] > max){
                    max = valueDp[0][i-1] + valueDp[i][j-1] + valueDp[j][nums.length-1];
                    rst[0] = posDp[0][i-1];
                    rst[1] = posDp[i][j-1];
                    rst[2] = posDp[j][nums.length-1];
                }
            }
        }
        return rst;
    }



}
