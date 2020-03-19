package com.moses.leet.n0500;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder origin = new StringBuilder();
        for(char c : S.toCharArray()){
            if(c=='-'){
                continue;
            }
            if(Character.isDigit(c)){
                origin.append(c);
            }else if(Character.isLowerCase(c)){
                origin.append(Character.toUpperCase(c));
            }else{
                origin.append(c);
            }
        }
        if(origin.length() == 0){
            return "";
        }

        int left = origin.length()%K;
        StringBuilder rst = new StringBuilder();
        if(left != 0){
            rst.append(origin.subSequence(0, left));
            rst.append('-');
        }
        while(left < origin.length()){
            rst.append(origin.substring(left, left+K));
            rst.append('-');
            left+=K;
        }
        rst.setLength(rst.length()-1);
        return rst.toString();
    }

    public static void main(String[] args) {
        String S; int K;
        S = "---";
        K = 4;
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting(S, K));

        S = "5F3Z-2e-9-w";
        K = 4;
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting(S, K));

        S = "2-5g-3-J";
        K = 2;
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting(S, K));
    }
}
