package com.moses.leet.n0080;

/**
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {
    public boolean isNumber(String s){
        s = s.trim();
        if(s.startsWith("+") || s.startsWith("-")){
            s = s.substring(1);
        }
        if(s.length() == 0){
            return false;
        }
        int eTimes = 0;
        int ePos = 0;
        int decTimes = 0;
        int decPos = 0;
        char[] chars = s.toCharArray();

        char zero = '0';
        char nine = '9';
        for(int i=0; i<chars.length; i++){
            if(chars[i] == 'e'){
                eTimes++;
                ePos = i;
                if(eTimes > 1){
                    return false;
                }
                continue;
            }

            if(chars[i] == '.'){
                decTimes++;
                decPos = i;
                if(decTimes > 1){
                    return false;
                }
                if(eTimes == 1 && decPos > ePos){
                    return false;
                }
                continue;
            }

            if(chars[i] == '+' || chars[i] == '-'){
                if(eTimes != 1 || i != ePos+1){
                    return false;
                }
                if(i == chars.length-1){
                    return false;
                }
                continue;
            }

            if(chars[i] < zero || chars[i] > nine){
                return false;
            }
        }
        if(eTimes == 1 && (ePos == chars.length-1 || ePos == 0)){
            return false;
        }
        if(decTimes == 1 && (decPos==0 && chars.length==1 || decPos==0 && ePos==1)){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        assert new ValidNumber().isNumber("4e+")==false;
        assert new ValidNumber().isNumber("0");
        assert new ValidNumber().isNumber(" 0.1 ");
        assert new ValidNumber().isNumber("abc")==false;
        assert new ValidNumber().isNumber("1 a")==false;
        assert new ValidNumber().isNumber("2e10");
        assert new ValidNumber().isNumber(" -90e3   ");
        assert new ValidNumber().isNumber(" 1e")==false;
        assert new ValidNumber().isNumber("e3")==false;
        assert new ValidNumber().isNumber(" 6e-1");
        assert new ValidNumber().isNumber(" 99e2.5")==false;
        assert new ValidNumber().isNumber("53.5e93");
        assert new ValidNumber().isNumber(" --6")==false;
        assert new ValidNumber().isNumber("-+3")==false;
        assert new ValidNumber().isNumber("95a54e53")==false;
        System.out.println("finish");
    }
}
