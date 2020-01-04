package com.moses.leet.n0040;

public class CountAndSay {

    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String prev = countAndSay(n-1);
        StringBuilder str = new StringBuilder();
        int currCount = 0;
        for(int i=0; i<prev.length(); i++){
            if(i==0){
                currCount++;
                if(i==prev.length()-1){
                    str.append(currCount).append(prev.charAt(i));
                }
                continue;
            }
            if(prev.charAt(i-1) != prev.charAt(i)){
                str.append(currCount).append(prev.charAt(i-1));
                currCount = 0;
            }
            currCount++;
            if(i==prev.length()-1){
                str.append(currCount).append(prev.charAt(i));
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));
        System.out.println(new CountAndSay().countAndSay(3));
        System.out.println(new CountAndSay().countAndSay(4));
        System.out.println(new CountAndSay().countAndSay(5));
        System.out.println(new CountAndSay().countAndSay(6));
    }
}
