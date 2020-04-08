package com.moses.leet.n0720;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] ary = str.toCharArray();
        for(int i=0; i<ary.length; i++){
            if(ary[i]>='A' && ary[i] <='Z'){
                ary[i] = (char)(ary[i]+32);
            }
        }
        return new String(ary);
    }

    public static void main(String[] args) {
        System.out.println('A'+0);
        System.out.println('a'+0);
        System.out.println('Z'+0);
        System.out.println('z'+0);
    }
}
