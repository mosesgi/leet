package com.moses.leet.n0260;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumberIII {
    public int[] singleNumberBit(int[] nums) {
        int all = 0;
        for(int i : nums){
            all ^= i;
        }
        //find a pos with 1
        int div = 1;
        while((all | div) != all){
            div <<= 1;
        }

        int a = 0, b = 0;
        for(int i : nums){
            if( (i|div) == i){
                a ^= i;
            }else{
                b ^= i;
            }
        }
        return new int[]{a, b};
    }

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)){
                set.remove(i);
            }else {
                set.add(i);
            }
        }
        int[] rst = new int[2];
        Iterator<Integer> iter = set.iterator();
        rst[0] = iter.next();
        rst[1] = iter.next();
        return rst;
    }

    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.length() == 0 || s1.equals(s2)){
            return true;
        }
        for(int i=1; i<s1.length(); i++){
            String left1 = s1.substring(0, i);
            String right1 = s1.substring(i, s1.length());
            String left2 = s2.substring(0, i);
            String right2 = s2.substring(i, s2.length());
            if((right1+left1).equals(left2+right2)){
                return true;
            }
            if(isScramble(left1, left2) && isScramble(right1, right2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberIII().isScramble("abc", "cba"));
    }
}
