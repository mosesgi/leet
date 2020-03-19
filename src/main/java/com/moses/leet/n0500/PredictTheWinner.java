package com.moses.leet.n0500;

import java.util.LinkedList;

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        return dfs(nums, 0, 0, left, right, true);
    }

    private boolean dfs(int[] nums, int score1, int score2, int left, int right, boolean p1Side) {
        if(left ==right){
            if(p1Side){
                return score1-score2>=0;
            }else{
                return score2-score1>0;
            }
        }
        int tmpS1 = score1, tmpS2 = score2;
        if(p1Side){
            tmpS1 += nums[left];
        }else{
            tmpS2 += nums[left];
        }
        boolean l = dfs(nums, tmpS1, tmpS2, left+1, right, !p1Side);
        if(!l){
            return true;
        }

        tmpS1 = score1; tmpS2 = score2;
        if(p1Side){
            tmpS1 += nums[right];
        }else{
            tmpS2 += nums[right];
        }
        boolean r = dfs(nums, tmpS1, tmpS2, left, right-1, !p1Side);
        if(!r){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 5, 3,5,6,7,2,10,15,20,1,17, 7};
        System.out.println(new PredictTheWinner().PredictTheWinner(nums));

        nums = new int[]{1,5,2};
        System.out.println(new PredictTheWinner().PredictTheWinner(nums));

        nums = new int[]{1, 5, 233, 7};
        System.out.println(new PredictTheWinner().PredictTheWinner(nums));
    }
}
