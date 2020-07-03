package com.moses.leet.n0280;

public class UglyNumber {
    public boolean isUgly(int num){
        if(num<1){
            return false;
        }
        if(num == 1 || num == 2 || num == 3|| num == 5){
            return true;
        }
        if(num%2==0) {
            return isUgly(num / 2);
        } else if(num%3==0){
            return isUgly(num/3);
        } else if(num%5 == 0){
            return isUgly(num/5);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(17));
        System.out.println(new UglyNumber().isUgly(6));
        System.out.println(new UglyNumber().isUgly(15));
        System.out.println(new UglyNumber().isUgly(8));
        System.out.println(new UglyNumber().isUgly(32));
        System.out.println(new UglyNumber().isUgly(41));
        System.out.println(new UglyNumber().isUgly(14));
    }
}
