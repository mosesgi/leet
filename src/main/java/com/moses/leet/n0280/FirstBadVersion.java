package com.moses.leet.n0280;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l<r){
            int m = l+(r-l)/2;
            if(isBadVersion(m)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return r;
    }

    boolean isBadVersion(int version){
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }
}
