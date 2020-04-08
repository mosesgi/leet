package com.moses.leet.n0700;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        boolean is1 = (n|1)==n;
        while(n!=0){
            n>>>=1;
            if(is1){
                if((n|1) == n){
                    return false;
                }
            }else{
                if((n|1) != n){
                    return false;
                }
            }
            is1 = !is1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(5));
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(7));
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(11));
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(10));
    }
}
