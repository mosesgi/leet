package com.moses.leet.n0040;

public class DivideIntegers{
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean isNeg = false;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0){
            isNeg = true;
        }
        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = -divisor;
        }

        if(dividend > divisor){
            return 0;
        }

        int originDivisor = divisor;
        int result = 0;
        while(dividend <= divisor){
            int tmpResult = 1;
            while(dividend - divisor < divisor){
                divisor += divisor;
                tmpResult += tmpResult;
            }
            dividend -= divisor;
            divisor = originDivisor;
            result += tmpResult;
        }
        return isNeg?-result:result;
    }



    public int divide2(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        int mult = 1;
        if(dividend<0 && divisor>0 || dividend>0 && divisor < 0){
            mult = -1;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        return mult * rec(a, b, b);
    }

    //17/3   3+3; 6+6;
    int rec(long dividend, long divisor, long originDivisor){
        if(dividend < divisor){
            return 0;
        }
        int res = 1;
        while(divisor + divisor < dividend){
            divisor += divisor;
            res+=res;
        }
        return res + rec(dividend-divisor, originDivisor, originDivisor);
    }


    //with long. still not very good
    public int divide1(int dividend, int divisor) {
        boolean isNeg = dividend<0 && divisor>0 || dividend>0 && divisor<0;
        long a = dividend;
        long b = divisor;
        if(a < 0){
            a = -a;
        }
        if(b < 0){
            b = -b;
        }

        long tmp = b;
        long cnt = 1;
        //3+3(2), 6+6 (4), 12+12 (8)
        while(tmp < a){
            tmp += tmp;
            cnt += cnt;
        }
        while(tmp > a){
            tmp -=b;
            cnt -=1;
        }
        cnt = isNeg? -cnt:cnt;
        if(cnt > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(cnt < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)cnt;
        }
    }

    public static void main(String[] args) {
        System.out.println(new DivideIntegers().divide(-2147483648, -1));
        System.out.println(new DivideIntegers().divide(-1, 1));
        System.out.println(new DivideIntegers().divide(10, 3));
        System.out.println(new DivideIntegers().divide(10, 2));
        System.out.println(new DivideIntegers().divide(7, -3));
    }


    public int divideOldLTE(int dividend, int divisor) {
        int quotient = 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(divisor==1) return dividend;
        if(divisor==-1) return -dividend;
        boolean isDividendPos = true, isDivisorPos = true;
        isDividendPos = dividend<0?false:true;
        isDivisorPos = divisor<0?false:true;
        dividend = dividend>0?-dividend:dividend;
        divisor = divisor>0?-divisor:divisor;
        int remain = dividend;
        while(remain <= divisor){
            quotient++;
            remain -=divisor;
        }
        if(isDividendPos != isDivisorPos){
            quotient = -quotient;
        }
        return quotient;
    }


}