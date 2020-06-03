package com.moses.leet.n0880;

/**
 * Find the smallest prime palindrome greater than or equal to N.
 *
 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
 *
 * For example, 2,3,5,7,11 and 13 are primes.
 *
 * Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.
 *
 * For example, 12321 is a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: 6
 * Output: 7
 *
 * Example 2:
 *
 * Input: 8
 * Output: 11
 *
 * Example 3:
 *
 * Input: 13
 * Output: 101
 *
 *
 *
 * Note:
 *
 *     1 <= N <= 10^8
 *     The answer is guaranteed to exist and be less than 2 * 10^8.
 *
 */
public class PrimePalindrome {
    public int primePalindrome(int N) {
        while(true){
            String n = N+"";
            if(n.equals(new StringBuilder(n).reverse().toString()) && isPrime(N)){
                return N;
            }
            N++;
            if(N>=10000000 && N<=100000000){     //不存在长度为8的回文素数，10_000_000~99_999_999之间只有一个素数，10_000_019
                N = 100000001;
            }
        }
    }

    boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        int s = (int)Math.sqrt(n);
        for(int i = 2; i<=s; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
