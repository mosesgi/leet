package com.moses.leet.n0960;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 *
 * Recall that A is a mountain array if and only if:
 *
 *     A.length >= 3
 *     There exists some i with 0 < i < A.length - 1 such that:
 *         A[0] < A[1] < ... A[i-1] < A[i]
 *         A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: [2,1]
 * Output: false
 *
 * Example 2:
 *
 * Input: [3,5,5]
 * Output: false
 *
 * Example 3:
 *
 * Input: [0,3,2,1]
 * Output: true
 *
 *
 *
 * Note:
 *
 *     0 <= A.length <= 10000
 *     0 <= A[i] <= 10000
 *
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if(A.length<3){
            return false;
        }
        int cur = 0;
        boolean increase = false;
        while(cur+1<A.length){
            if(A[cur]== A[cur+1]){
                return false;
            }else if(A[cur+1]> A[cur]){
                increase = true;
                cur++;
            }else{
                break;
            }
        }
        if(!increase){
            return false;
        }

        boolean decrease = false;
        while(cur+1<A.length){
            if(A[cur] == A[cur+1]){
                return false;
            }else if(A[cur] > A[cur+1]){
                decrease = true;
                cur++;
            }else{
                return false;
            }
        }
        return decrease;
    }
}
