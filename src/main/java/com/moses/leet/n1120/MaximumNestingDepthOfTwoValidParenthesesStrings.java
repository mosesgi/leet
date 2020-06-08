package com.moses.leet.n1120;

import java.util.Arrays;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        boolean s1Start = false;
        boolean s2Start = false;
        int s1Level = 0;
        int s2Level = 0;

        int[] res = new int[seq.length()];
        for(int i=0; i<seq.length(); i++){
            char c = seq.charAt(i);
            if(c=='('){
                if(!s1Start){
                    res[i] = 0;
                    s1Level++;
                    s1Start = true;
                }else if(!s2Start){
                    res[i] = 1;
                    s2Level++;
                    s2Start = true;
                }else{
                    if(s1Level<= s2Level){
                        res[i] = 0;
                        s1Level++;
                    }else{
                        res[i] = 1;
                        s2Level++;
                    }
                }
            }else if(c==')'){
                if(s1Start && s2Start){
                    if(s1Level >= s2Level){
                        res[i] = 0;
                        s1Level--;
                        if(s1Level==0) {
                            s1Start = false;
                        }
                    }else{
                        res[i] = 1;
                        s2Level--;
                        if(s2Level==0) {
                            s2Start = false;
                        }
                    }
                }else if(s1Start){
                    res[i] = 0;
                    s1Level--;
                    if(s1Level==0) {
                        s1Start = false;
                    }
                }else {
                    res[i] = 1;
                    s2Level--;
                    if(s2Level==0) {
                        s2Start = false;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "((()))";
        System.out.println(Arrays.toString(new MaximumNestingDepthOfTwoValidParenthesesStrings().maxDepthAfterSplit(s)));
    }
}
