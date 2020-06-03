package com.moses.leet.n0980;

/**
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 *
 *     For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 *     OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 *
 * That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 *
 * Return the length of a maximum size turbulent subarray of A.
 *
 *
 *
 * Example 1:
 *
 * Input: [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
 *
 * Example 2:
 *
 * Input: [4,8,12,16]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [100]
 * Output: 1
 *
 *
 *
 * Note:
 *
 *     1 <= A.length <= 40000
 *     0 <= A[i] <= 10^9
 *
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if(A.length<2){
            return A.length;
        }
        int max = 1;
        int tmp = 1;
        Integer prev = null;
        for(int i=1; i<A.length; i++){
            int cur = A[i]==A[i-1]?0:A[i]>A[i-1]?1:-1;
            if(cur == 0){
                tmp = 1;
                continue;
            }
            if(prev == null){
                prev = cur;
                tmp = 2;
                max = Math.max(max, tmp);
                continue;
            }
            if(cur == -prev){
                tmp++;
                max = Math.max(max, tmp);
            }else{
                tmp = 2;
            }
            prev = cur;
        }
        return max;
    }
}
