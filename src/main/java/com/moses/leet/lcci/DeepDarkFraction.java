package com.moses.leet.lcci;

//https://leetcode-cn.com/problems/deep-dark-fraction/
public class DeepDarkFraction {
    public int[] fraction(int[] cont) {
        if(cont.length==1){
            return new int[]{cont[0], 1};
        }
        int prev0 = 1;
        int prev1 = cont[cont.length-1];
        for(int i=cont.length-2; i>=0; i--){
            prev0 = cont[i] * prev1 + prev0;
            if(i!= 0){
                int tmp = prev0;
                prev0 = prev1;
                prev1 = tmp;
            }
        }

        int p0Mut = prev0>=0?1:-1;
        int p1Mut = prev1>=0?1:-1;

        prev0 = Math.abs(prev0);
        prev1 = Math.abs(prev1);
        int gcd = gcd(prev0, prev1);
        prev0/=gcd;
        prev1/=gcd;
        return new int[]{prev0*p0Mut*p1Mut, prev1};
    }

    int gcd(int p0, int p1){
        int mod = p0%p1;
        if(mod == 0){
            return p1;
        }
        return gcd(p1, mod);
    }

    public static void main(String[] args) {
        System.out.println(new DeepDarkFraction().gcd(6,8));
        System.out.println(new DeepDarkFraction().gcd(9,36));
        System.out.println(new DeepDarkFraction().gcd(18,12));
        System.out.println(new DeepDarkFraction().gcd(124, 36));
    }
}
