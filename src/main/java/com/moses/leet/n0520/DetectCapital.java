package com.moses.leet.n0520;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        boolean startLower= false;
        int upperCnt = 0;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)){
                if(startLower){
                    return false;
                }
                upperCnt++;
            }else{
                startLower = true;
            }
        }
        return upperCnt == 0 || upperCnt == 1 || upperCnt == word.length();
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse("mL"));
        System.out.println(new DetectCapital().detectCapitalUse("USA"));
        System.out.println(new DetectCapital().detectCapitalUse("FlaG"));
        System.out.println(new DetectCapital().detectCapitalUse("leetcode"));
        System.out.println(new DetectCapital().detectCapitalUse("FFFFFFFFFFFFFFFFFFFFf"));
        System.out.println(new DetectCapital().detectCapitalUse("Google"));
    }
}
