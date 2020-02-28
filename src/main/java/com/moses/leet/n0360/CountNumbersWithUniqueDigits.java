package com.moses.leet.n0360;

import java.util.HashSet;
import java.util.Set;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n){
        // 1: 10
        // 2: 9*9
        // 3: 8*F(2)
        // 4: 7*F(3)
        int[] dp = new int[n+1];
        int sum = 1;
        if(n==0){
            return sum;
        }
        dp[1] = 9;
        sum+= dp[1];
        if(n==1){
            return sum;
        }
        dp[2] = 81;
        sum+= dp[2];
        if(n==2){
            return sum;
        }
        for(int i=3; i<=n; i++){
            dp[i] = (10-i+1) * dp[i-1];
            sum+= dp[i];
        }
        return sum;
    }

    public int countNumbersWithUniqueDigitsRecursive(int n) {
        if(n>10){
            n=10;
        } else if(n==0){
            return 1;
        } else if(n==1){
            return 10;
        }
        boolean[] used = new boolean[10];
        int a = 0;
        if(n > 1){
            a += countNumbersWithUniqueDigits(n-1);
        }
        for(int i=1; i<10; i++) {
            used[i] = true;
            a += recursive(used, 1, n);
            used[i] = false;
        }
        return a;
    }

    private int recursive(boolean[] used, int currLevel, int n){
        if(currLevel == n){
            return 1;
        }
        int tmp = 0;
        for(int i=0; i<10; i++){
            if(!used[i]){
                used[i] = true;
                tmp += recursive(used, currLevel+1, n);
                used[i] = false;
            }
        }
        return tmp;
    }

    public int countNumbersWithUniqueDigitsClumsy(int n) {
        int max = 10;
        for(int i=1; i<n; i++){
            max*=10;
        }

        int cnt = 0;
        outer: for(int i=0; i<max; i++){
            String s = String.valueOf(i);
            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()){
                if(set.contains(c)){
                    continue outer;
                }
                set.add(c);
            }
            cnt++;

        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(4));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(9));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(10));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(11));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(12));
    }
}
