package com.moses.leet.n0800;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if(A.equals(B)){
            return true;
        }
        StringBuilder sb = new StringBuilder(A);
        for(int i=0; i<sb.length(); i++){
            char lead = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(lead);
            if(sb.toString().equals(B)){
                return true;
            }
        }
        return false;
    }
}
