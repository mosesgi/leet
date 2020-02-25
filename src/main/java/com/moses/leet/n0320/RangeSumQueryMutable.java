package com.moses.leet.n0320;

//segment tree: https://leetcode.com/problems/range-sum-query-mutable/solution/
public class RangeSumQueryMutable {
    class NumArray {
        int[][] dp;
        int colSize;
        int rowSize;
        public NumArray(int[] nums) {
            if(nums.length == 0){
                dp = new int[0][0];
                return;
            }
            rowSize = (int)Math.sqrt((double)nums.length);
            if(nums.length % rowSize == 0){
                colSize = nums.length/ rowSize;
            }else {
                colSize = nums.length/ rowSize;
                rowSize++;
            }
            dp = new int[rowSize][colSize];
            int dpInd = 0;
            int rowInd = 0;
            int prevSum = 0;
            for(int i=0; i<nums.length; i++){
                dp[dpInd][rowInd] = nums[i] + prevSum;
                prevSum = dp[dpInd][rowInd];
                if(rowInd == colSize -1){
                    rowInd = 0;
                    dpInd++;
                    prevSum = 0;
                } else {
                    rowInd++;
                }
            }
        }

        public void update(int i, int val) {
            int ind = i/ colSize;
            int rowInd = i% colSize;
            int prev = 0;
            if(rowInd != 0){
                prev = dp[ind][rowInd-1];
            }
            int diff = dp[ind][rowInd] - (prev+val);
            dp[ind][rowInd] = prev + val;
            prev = dp[ind][rowInd];
            for(int j = rowInd+1; j< colSize; j++){
                dp[ind][j] = dp[ind][j] - diff;
            }
        }

        public int sumRange(int i, int j) {
            int startInd = i/ colSize;
            int startRowInd = i% colSize;
            int endInd = j/ colSize;
            int endRowInd = j% colSize;
            if(startInd == endInd){
                if(startRowInd == 0){
                    return dp[startInd][endRowInd];
                }else{
                    return dp[startInd][endRowInd] - dp[startInd][startRowInd-1];
                }
            }else {
                int firstAry = startRowInd == 0? dp[startInd][colSize -1] : dp[startInd][colSize -1] - dp[startInd][startRowInd-1];
                int tmpStart = startInd+1;
                while(tmpStart<endInd){
                    firstAry += dp[tmpStart][colSize -1];
                    tmpStart++;
                }
                firstAry += dp[endInd][endRowInd];
                return firstAry;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums;
        RangeSumQueryMutable m = new RangeSumQueryMutable();
        nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        NumArray n = m.new NumArray(nums);
        System.out.println(n.sumRange(0,9));
        System.out.println(n.sumRange(4,8));
        n.update(5, 5);  //6 -> 5
        System.out.println(n.sumRange(0,9));
        System.out.println(n.sumRange(4,8));

    }
}
