package com.moses.leet.n0320;

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        return dfs(num, null, null, 0);
    }

    boolean dfs(String num, Integer a, Integer b, int pos){
        int len = num.length();
        int size = len/2;
        if(pos == num.length()){
            return true;
        }
        if(num.charAt(pos) == '0'){
            return false;
        }

        if(a == null){
            for(int i=0; i<size; i++){
                a = Integer.parseInt(num.substring(0, i+1));
                if(dfs(num, a, b, i+1)){
                    return true;
                }
            }
        }else if(b == null){
            for(int i=0; i<size; i++){
                b = Integer.parseInt(num.substring(pos, pos+i+1));
                if(dfs(num, a, b, pos+i+1)){
                    return true;
                }
            }
        }else{
            int cur = a+b;
            String str = cur+"";
            if(num.startsWith(str, pos)){
                if(dfs(num, b, cur, pos+str.length())){
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }





    public boolean isAdditiveNumberOld(String num) {
        if(num.length()<3){
            return false;
        }
        int maxLen = num.length()/2;
        return recursive(num, 0L, 0L, 1, maxLen);
    }

    private boolean recursive(String num, long a, long b, int level, int maxLen) {
        if(level == 1 ){
            if(num.startsWith("0")){
                return recursive(num.substring(1), 0, b, level+1, maxLen);
            }
            for(int i=1; i<=maxLen; i++){
                Long l1 = Long.parseLong(num.substring(0, i));
                if(recursive(num.substring(i), l1, b, level+1, maxLen)){
                    return true;
                }
            }
            return false;
        }
        if(level == 2){
            if(num.startsWith("0")){
                return recursive(num.substring(1), a, 0, level+1, maxLen);
            }
            for(int i=1; i<=maxLen && i<num.length(); i++){
                Long l1 = Long.parseLong(num.substring(0, i));
                if(recursive(num.substring(i), a, l1, level+1, maxLen)){
                    return true;
                }
            }
            return false;
        }
        long curr = a+b;
        String currStr = String.valueOf(curr);
        if(num.startsWith("0")){
            if(a+b == 0){
                if(num.length() == currStr.length()){
                    return true;
                }
                return recursive(num.substring(1), b, curr, level+1, maxLen);
            }
            return false;
        }

        if(num.startsWith(currStr)){
            if(num.length() == currStr.length()){
                return true;
            }
            return recursive(num.substring(currStr.length()), b, curr, level+1, maxLen);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String num;

//        num = "1023";
//        System.out.println(new AdditiveNumber().isAdditiveNumber(num));
//
//        num = "000";
//        System.out.println(new AdditiveNumber().isAdditiveNumber(num));
//
//        num = "112358";
//        System.out.println(new AdditiveNumber().isAdditiveNumber(num));

        num = "199100199";
        System.out.println(new AdditiveNumber().isAdditiveNumber(num));
    }
}
