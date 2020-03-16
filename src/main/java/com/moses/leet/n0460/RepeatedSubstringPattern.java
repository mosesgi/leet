package com.moses.leet.n0460;


public class RepeatedSubstringPattern {


    public static void main(String[] args) {
        String s;
        s = "ababba";
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(s));

        s = "abab";
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(s));

        s = "aba";
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(s));

        s = "abcabcabcabc";
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(s));
    }

    public boolean repeatedSubstringPattern(String s) {
        //ababababab
        int len = s.length();
        int curr = len/2;
        while(curr > 0){
            if(len % curr == 0){
                int size = len/curr;
                String sub = s.substring(0, curr);
                boolean allEquals = true;
                for(int i=1; i<size; i++){
                    String tmp = s.substring(curr*i, curr*(i+1));
                    if(!sub.equals(tmp)){
                        allEquals = false;
                        break;
                    }
                }
                if(allEquals){
                    return true;
                }
            }
            curr--;
        }
        return false;
    }


}
