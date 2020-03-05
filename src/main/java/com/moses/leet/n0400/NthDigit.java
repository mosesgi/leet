package com.moses.leet.n0400;

public class NthDigit {
    public int findNthDigit(int n) {
        if(n<=9) return n;
        int digPerNum = 1;
        int startNum = 1;

        long nextLevel = 9L*digPerNum*startNum;
        while(n > nextLevel){
            n-= nextLevel;
            startNum *= 10;
            digPerNum++;
            nextLevel = 9L*digPerNum*startNum;
        }

        int div = n/digPerNum;
        int remain = n%digPerNum;
        if(remain == 0){
            int curr = startNum+div-1;
            String str = String.valueOf(curr);
            return Integer.parseInt(str.substring(str.length()-1));
        }
        int next = startNum + div;
        return Integer.parseInt(String.valueOf(String.valueOf(next).charAt(remain-1)));
    }

    public static void main(String[] args) {
        // 9: 9 * 1, 99: 90 * 2, 999: 900*3,
        //3212, -9, - 90*2, -900*3 = 323
        //323  from 1000,    323/4 = 80 %=3,    1079,   1080  8
        System.out.println(new NthDigit().findNthDigit(1000000000));
        System.out.println(new NthDigit().findNthDigit(11));
        System.out.println(new NthDigit().findNthDigit(3212));
    }
}
