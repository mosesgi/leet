package com.moses.leet.n0980;

import java.util.HashMap;
import java.util.Map;

/**
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 *
 * Return the element repeated N times.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [2,1,2,5,3,2]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 *
 *
 *
 * Note:
 *
 *     4 <= A.length <= 10000
 *     0 <= A[i] < 10000
 *     A.length is even
 *
 */
public class N_RepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        int n = A.length/2;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for(int k : map.keySet()){
            if(map.get(k) == n){
                return k;
            }
        }
        return -1;
    }
}
