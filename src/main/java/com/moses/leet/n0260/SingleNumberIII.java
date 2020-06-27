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


    public static void main(String[] args) {

    }
}
