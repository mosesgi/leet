package com.moses.leet.n1040;

import java.util.Arrays;

/**
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
 *
 * Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 *
 *  
 *
 * Example 1:
 *
 * Input: [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 *
 * Input: [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 *
 * Input: [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 *  
 *
 * Note:
 *
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 */
public class LongestArithmeticSequence {

    //Dp solution...
    public int longestArithSeqLength(int[] A) {
        int[][] dp = new int[A.length][20001];

        int ans = 0;
        for(int i=1; i<A.length; i++){
            for(int j=0; j<i; j++){
                int diff = A[i] - A[j];
                if(diff < 0){
                    diff = 10000-diff;
                }
                dp[i][diff] = dp[j][diff] + 1;
                ans = Math.max(ans, dp[i][diff]);
            }
        }
        return ans+1;
    }


    public int longestArithSeqLengthMine(int[] A) {
        return backtrack(A, 0, null,null);
    }

    int backtrack(int[] A, int start, Integer prev1Pos, Integer prev2Pos){
        if(start >= A.length){
            return 0;
        }

        int max = 0;
        if(prev1Pos == null){
            for(int i=start; i<A.length-1; i++){
                for(int j=i+1; j<A.length; j++){
                    max = Math.max(max, 2+backtrack(A, j+1, j, i));
                }
            }
        }else{
            for(int i=start; i<A.length; i++){
                if(A[i] - A[prev1Pos] == A[prev1Pos] - A[prev2Pos]){
                    max = 1+backtrack(A, i+1, i, prev1Pos);
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A;
        A = new int[]{44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28};
        System.out.println(new LongestArithmeticSequence().longestArithSeqLength(A));
    }
}
