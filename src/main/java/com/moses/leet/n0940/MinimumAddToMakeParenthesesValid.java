package com.moses.leet.n0940;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int res = 0;
        int tmp = 0;
        for(char c : S.toCharArray()){
            if(c=='('){
                if(tmp < 0){
                    res += Math.abs(tmp);
                    tmp = 1;
                }else{
                    tmp++;
                }
            }else if(c==')'){
                tmp--;
            }
        }
        res += Math.abs(tmp);
        return res;
    }
}
