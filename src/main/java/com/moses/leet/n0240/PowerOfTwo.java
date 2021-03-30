package com.moses.leet.n0240;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n < 0){
            return false;
        }
        int mask = 1;
        for(int i=0; i<32; i++){
            if(n==mask){
                return true;
            } else {
                mask<<=1;
            }
        }
        return false;
    }

    public boolean isPowerOfTwoRecursive(int n) {
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        long x = 2;
        while(x < n/x){
            x*=x;
        }
        if(n%x != 0){
            return false;
        }
        return isPowerOfTwo((int)(n/x));
    }

    //Integer.bitCount(n)==1;
    public boolean isPowerOfTwoStr(int n) {
        if(n < 0){
            return false;
        }
        String s = Integer.toBinaryString(n);
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }
        }
        return cnt==1;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(1));
        System.out.println(new PowerOfTwo().isPowerOfTwo(16));
        System.out.println(new PowerOfTwo().isPowerOfTwo(128));
        System.out.println(new PowerOfTwo().isPowerOfTwo(218));
    }
}
