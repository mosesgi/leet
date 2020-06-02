package com.moses.leet.n1420;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int res = 0;
        while(sb.length() > 1 && !sb.toString().equals("1")){
            next(sb);
            res++;
        }
        return res;
    }

    void next(StringBuilder s){
        if(s.charAt(s.length()-1) == '1'){
            int i=s.length()-1;
            while(i>=0 && s.charAt(i) != '0'){
                s.setCharAt(i--, '0');
            }
            if(i==-1){
                s.insert(0, '1');
            }else{
                s.setCharAt(i, '1');
            }
        }else{
            s.setLength(s.length()-1);
        }
    }
}
