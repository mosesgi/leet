package com.moses.leet.n0080;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    int rst = 0;


    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        if(n<=3){
            return n;
        }

        for(int i=4; i<=n; i++){
            cache.put(i, cache.get(i-1) + cache.get(i-2));
        }
        return cache.get(n);
    }

    //also slow
    private int recursiveDp(int n) {
        if(n==1 || n==2 || n==3){
            return n;
        }
        return recursiveDp(n-1) + recursiveDp(n-2);
    }


    //too slow
    private void recursive(int left){
        if(left==0 || left==1){
            rst++;
            return;
        }
        for(int i=1; i<=2; i++){
            recursive(left-i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2));
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println(new ClimbingStairs().climbStairs(44));
    }
}
