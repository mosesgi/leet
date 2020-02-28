package com.moses.leet.n0360;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerOfFour {
//    public boolean isPowerOfFourCheat(int num){
//        Set<Integer> set = new HashSet<>(Arrays.asList(1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864, 268435456, 1073741824));
//        return set.contains(num);
//    }

    public boolean isPowerOfFourNotFromMe(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }

    public boolean isPowerOfFour(int num) {
        if(num<=0){
            return false;
        }
        while(num > 1){
            if(num%4 == 0){
                num/=4;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(16));
        System.out.println(new PowerOfFour().isPowerOfFour(5));

        for(long i=1; i<Integer.MAX_VALUE; i*=4){
            System.out.print(i + ", ");
        }
    }
}
