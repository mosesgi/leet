package com.moses.leet.n0880;

/**
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 *
 * Example 2:
 *
 * Input: 10
 * Output: false
 *
 * Example 3:
 *
 * Input: 16
 * Output: true
 *
 * Example 4:
 *
 * Input: 24
 * Output: false
 *
 * Example 5:
 *
 * Input: 46
 * Output: true
 *
 *
 *
 * Note:
 *
 *     1 <= N <= 10^9
 *
 */
public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        String s = N+"";
        int[] ary = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            ary[i] = s.charAt(i)-'0';
        }
        return permutation(ary, 0);
    }

    private boolean permutation(int[] ary, int start) {
        if(start == ary.length){
            return valid(ary);
        }
        for(int i=start; i<ary.length; i++){
            swap(ary, start, i);
            if(permutation(ary, start+1)){
                return true;
            }
            swap(ary, start, i);
        }
        return false;
    }

    private boolean valid(int[] ary) {
        if(ary[0] == 0){
            return false;
        }
        int s = 0;
        for(int i=0; i<ary.length; i++){
            s = s*10 + ary[i];
        }
        return s>0 && (s&(s-1)) == 0;
    }

    void swap(int[] ary, int x, int y){
        int tmp = ary[x];
        ary[x] = ary[y];
        ary[y] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(10));
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(1));
    }
}
