package com.moses.leet.n1420;

import java.util.ArrayList;
import java.util.List;

public class ReformatTheString {
    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                letters.add(c);
            }else{
                digits.add(c);
            }
        }
        if(Math.abs(letters.size()-digits.size()) > 1){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int lp = 0, dp = 0;
        if(digits.size() > letters.size()){
            sb.append(digits.get(dp++));
        }
        while(lp < letters.size() || dp < digits.size()){
            sb.append(letters.get(lp++));
            if(dp < digits.size()) {
                sb.append(digits.get(dp++));
            }
        }
        return sb.toString();

    }
}
