package com.moses.leet.n0400;

import java.util.HashMap;
import java.util.Map;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int countRemain = 0;
        for(int i=0; i<data.length; i++){
            CheckResult r = checkInt(data[i]);
            if(!r.isValid){
                return false;
            }
            if(countRemain == 0){
                if(r.type == Type.SUBSEQUENT){
                    return false;
                }
                if(r.type == Type.LEAD){
                    countRemain = r.leadOnes-1;
                }
            } else {
                if (r.type != Type.SUBSEQUENT) {
                    return false;
                }
                countRemain--;
            }
        }
        return countRemain == 0;
    }

    private CheckResult checkInt(int d){
        d>>=3;
        int oneCnt = 0;
        boolean[] ones = new boolean[5];
        for(int i=0; i<5; i++) {
            if( (d|1) == d){
                ones[4-i] = true;
            }
            d>>=1;
        }
        if(!ones[0]){
            return new CheckResult(true, Type.SINGLE);
        }
        if(!ones[1]){
            return new CheckResult(true, Type.SUBSEQUENT);
        }
        if(!ones[2]){
            return new CheckResult(true, 2);
        }
        if(!ones[3]){
            return new CheckResult(true, 3);
        }
        if(!ones[4]){
            return new CheckResult(true, 4);
        }
        return new CheckResult(false, null);
    }

    class CheckResult{
        boolean isValid;
        Type type;
        int leadOnes;

        CheckResult(boolean isValid, Type type){
            this.isValid = isValid;
            this.type = type;
        }

        CheckResult(boolean isValid, int leadOnes){
            this.isValid = isValid;
            this.type = Type.LEAD;
            this.leadOnes = leadOnes;
        }
    }

    enum Type{
        SINGLE, LEAD, SUBSEQUENT
    }

    public static void main(String[] args) {
        int[] data;
        data = new int[]{237};
        System.out.println(new UTF8Validation().validUtf8(data));

        data = new int[]{197,130,1};
        System.out.println(new UTF8Validation().validUtf8(data));

        data = new int[]{235,140,4};
        System.out.println(new UTF8Validation().validUtf8(data));
    }
}
