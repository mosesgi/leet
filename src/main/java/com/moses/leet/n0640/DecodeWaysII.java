package com.moses.leet.n0640;

public class DecodeWaysII {
    int NUM = 1000000007;
    public int numDecodings(String s) {
        long prev = 1;
        long curr = 1;
        char f = s.charAt(0);
        if(f == '*'){
            curr = 9;
        }else if(f == '0'){
            return 0;
        }
        for(int i=1; i<s.length(); i++){
            long tmp = curr;
            char cChar = s.charAt(i);
            char pChar = s.charAt(i-1);
            if(Character.isDigit(pChar) && Character.isDigit(cChar)){
                int comb = (pChar-'0') * 10 + (cChar-'0');
                if(comb == 0){
                    return 0;
                }else if(comb < 10){

                }else if(comb > 26){
                    if(cChar == '0'){
                        return 0;
                    }
                    curr = curr;
                }else if(comb == 10 || comb == 20){
                    curr = prev;
                }else{
                    curr = prev + curr;
                }
            }else if(pChar == '*' && cChar == '*'){
                curr = curr*9 + prev*15;    // 11 ~ 19, 21 ~ 26
            }else if(pChar == '*'){  //cChar != '*'
                if(cChar == '0'){
                    curr = prev*2;
                }else if(cChar <= '6'){
                    curr = curr + prev * 2;
                }else{
                    curr = curr + prev;
                }
            }else{  //pChar != '*' && cChar == '*'
                if(pChar == '0'){
                    curr = curr*9;
                }else if(pChar == '1'){
                    curr = curr*9 + prev * 9;
                }else if(pChar == '2'){
                    curr = curr*9 + prev * 6;
                }else{
                    curr = curr*9;
                }
            }
            curr %= NUM;
            prev = tmp;
        }
        return (int)curr;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWaysII().numDecodings("**********1111111111"));     //133236775
        System.out.println(new DecodeWaysII().numDecodings("1*72*"));     //285
        System.out.println(new DecodeWaysII().numDecodings("904"));     //1
        System.out.println(new DecodeWaysII().numDecodings("104"));     //1
        System.out.println(new DecodeWaysII().numDecodings("*10*1"));   //99
        System.out.println(new DecodeWaysII().numDecodings("*0**0"));   //36
    }
}
