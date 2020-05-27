package com.moses.leet.n0860;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();
        for(char c : S.toCharArray()){
            if(c=='#'){
                if(s1.length() > 0){
                    s1.setLength(s1.length()-1);
                }
            }else{
                s1.append(c);
            }
        }

        for(char c : T.toCharArray()){
            if(c=='#'){
                if(t1.length() > 0){
                    t1.setLength(t1.length()-1);
                }
            }else{
                t1.append(c);
            }
        }

        return s1.toString().equals(t1.toString());
    }
}
