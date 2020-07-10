package com.moses.leet.n0880;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 *
 *     n >= 3
 *     X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 *
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
 *
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 *
 * Example 2:
 *
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 *
 *
 *
 * Note:
 *
 *     3 <= A.length <= 1000
 *     1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 *     (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 *
 */
public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int i : A){
            set.add(i);
        }
        int max = 0;
        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                int next = A[j] + A[i];
                int prev = A[j];
                int len = 2;
                while(set.contains(next)){
                    len++;
                    int tmp = next;
                    next += prev;
                    prev = tmp;
                }
                max = Math.max(max, len);
            }
        }
        return max<3?0:max;
    }


    public int lenLongestFibSubseqDp(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int[][] dp = new int[A.length][A.length];
        for(int j=0; j<A.length; j++){
            map.put(A[j], j);
            for(int i=0; i<j; i++){
                dp[i][j] = Math.max(dp[i][j], 2);
                int h = A[j]-A[i];
                if(h >= A[i]){
                    continue;
                }
                if(!map.containsKey(h)){
                    continue;
                }
                int pos = map.get(h);
                dp[i][j] = Math.max(dp[i][j], dp[pos][i]+1);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
