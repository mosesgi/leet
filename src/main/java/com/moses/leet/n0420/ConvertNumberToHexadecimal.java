package com.moses.leet.n0420;

public class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        if(num==0){
            return "0";
        }
        StringBuilder hex = new StringBuilder();

        int[] factors = new int[]{1,2,4,8};
        String[] hexes = new String[]{"a","b","c","d","e","f"};
        int tmp = 0;
        int currPos = 0;
        while(num != 0){
            int currBin = (num|1) == num? 1 : 0;
            tmp += currBin * factors[currPos];
            currPos++;
            if(currPos == 4){
                currPos = 0;
                String h = tmp<10?tmp+"":hexes[tmp-10];
                hex.insert(0, h);
                tmp = 0;
            }
            num>>>=1;
        }
        if(tmp != 0){
            String h = tmp<10?tmp+"":hexes[tmp-10];
            hex.insert(0, h);
        }
        return hex.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConvertNumberToHexadecimal().toHex(26));
        System.out.println(new ConvertNumberToHexadecimal().toHex(-1));
        System.out.println(new ConvertNumberToHexadecimal().toHex(16));
    }
}
