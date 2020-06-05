package com.moses.leet.n1320;

/**
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 *
 *
 *
 * Example 1:
 *
 * Input: a = 2, b = 6, c = 5
 * Output: 3
 * Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 *
 * Example 2:
 *
 * Input: a = 4, b = 2, c = 7
 * Output: 1
 *
 * Example 3:
 *
 * Input: a = 1, b = 2, c = 3
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *     1 <= a <= 10^9
 *     1 <= b <= 10^9
 *     1 <= c <= 10^9
 *
 */
public class MinimumFlipsToMakeAorBequalToC {
    public int minFlips(int a, int b, int c) {
        int steps=0;
        while(a>0 || b>0 || c>0){
            boolean aZero = false, bZero = false, cZero = false;
            if((a|1) != a){
                aZero = true;
            }
            if((b|1) != b){
                bZero = true;
            }
            if((c|1) != c){
                cZero = true;
            }
            a>>>=1;
            b>>>=1;
            c>>>=1;

            if(!cZero){
                if(aZero && bZero){
                    steps++;
                }
            }else{
                if(!aZero && !bZero){
                    steps+=2;
                }else if(!aZero || !bZero){
                    steps++;
                }
            }
        }
        return steps;
    }
}
