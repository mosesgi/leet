package com.moses.leet.n1340;

public class RemovePalindromicSubsequences {
    //abbaaaaabbbaabbba
    public int removePalindromeSub(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(new StringBuilder(s).reverse().toString().equals(s)){
            return 1;
        }
        return 2;
    }
}
