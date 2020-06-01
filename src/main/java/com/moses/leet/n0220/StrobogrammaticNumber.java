package com.moses.leet.n0220;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * Example 1:
 *
 * Input:  "69"
 * Output: true
 *
 * Example 2:
 *
 * Input:  "88"
 * Output: true
 *
 * Example 3:
 *
 * Input:  "962"
 * Output: false
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length()-1;
        while(l<r){
            char left = num.charAt(l);
            char right = num.charAt(r);
            if(left == right){
                if(left == '0' || left == '1' || left == '8'){

                }else{
                    return false;
                }
            }else{
                if(left == '6' && right == '9' || left=='9' && right=='6'){

                }else{
                    return false;
                }
            }
            l++;
            r--;
        }
        if(l==r){
            char m = num.charAt(l);
            if(m == '0' || m == '1' || m == '8'){

            }else{
                return false;
            }
        }
        return true;
    }
}
