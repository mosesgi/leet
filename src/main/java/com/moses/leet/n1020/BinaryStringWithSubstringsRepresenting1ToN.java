package com.moses.leet.n1020;

public class BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String S, int N) {
        for(int i=1; i<=N; i++){
            if (!S.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new BinaryStringWithSubstringsRepresenting1ToN().queryString("", 50);
    }
}
