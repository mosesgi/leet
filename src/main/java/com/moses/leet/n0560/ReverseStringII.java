package com.moses.leet.n0560;

public class ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int gap = 2*k;
        int len = s.length();
        int start = 0;
        while(start<len){
            if(len-start > gap){
                for(int i=start+k-1; i>=start; i--){
                    sb.append(s.charAt(i));
                }
                sb.append(s.substring(start+k, start+gap));
                start = start+gap;
            } else if(len-start < k){
                for(int i=len-1; i>=start; i--){
                    sb.append(s.charAt(i));
                }
                break;
            } else {
                for(int i=start+k-1; i>=start; i--){
                    sb.append(s.charAt(i));
                }
                sb.append(s.substring(start+k));
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s;
        int k;
        s = "abcdefg";
        k = 2;
        System.out.println(new ReverseStringII().reverseStr(s, k));
    }

}
