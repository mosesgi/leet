package com.moses.leet.n0340;

public class PowerOfThree {
    public boolean isPowerOfThree1(int n){
        return n > 0 && (1162261467 % n == 0);      //maximum power in integer : 1162261467
    }


    //11ms
    public boolean isPowerOfThree(int n) {
        if(n==3){
            return true;
        }
        if(n>0 && n%3==0){
            return isPowerOfThree(n/3);
        }
        return false;
    }

    //13ms
    public boolean isPowerOfThreeMyown(int n) {
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        long tmp = 3;
        while(tmp <= n){
            if(tmp == n){
                return true;
            }
            tmp*=tmp;
        }
        while(tmp >=n){
            if(tmp == n){
                return true;
            }
            tmp/=3;
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(27));
        System.out.println(new PowerOfThree().isPowerOfThree(0));
        System.out.println(new PowerOfThree().isPowerOfThree(9));
        System.out.println(new PowerOfThree().isPowerOfThree(45));
        System.out.println(new PowerOfThree().isPowerOfThree(2147483647));
    }
}
