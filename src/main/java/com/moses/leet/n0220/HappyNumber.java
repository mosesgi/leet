package com.moses.leet.n0220;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        while(true){
            if(set.contains(n)){
                return n==1;
            }
            set.add(n);
            int tmp = 0;
            while(n>0){
                int p = n%10;
                tmp += p*p;
                n = n/10;
            }
            n = tmp;
        }
    }

    public boolean isHappyOld(int n){
        Set<Integer> rst = new HashSet<>();

        while(true) {
            List<Integer> list = new ArrayList<>();
            while (n > 0) {
                int k = n % 10;
                list.add(k);
                n = n / 10;
            }

            int sum = 0;
            for (Integer i : list) {
                sum += i * i;
            }
            if(sum == 1){
                return true;
            }
            if (rst.contains(sum)) {
                return false;
            }
            rst.add(sum);
            n=sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
        System.out.println(new HappyNumber().isHappy(100));
        System.out.println(new HappyNumber().isHappy(333));
    }
}
