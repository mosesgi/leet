package com.moses.leet.n0500;

public class MagicalString {

    //1 22 11 2 1 22 1 22 11 2 11 22 1  2 11, 2, 1,22,11,
    //1 2  2 1  1 2  1 2  2  1 2  2  1, 1, 2, 1, 1, 2, 2
    public int magicalString(int n) {
        StringBuilder magic = new StringBuilder("1221121221221121122");
        int slow = 0;
        int fast = 0;
        if(n<magic.length()){
            return count1(magic, n);
        }
        slow = 12;
        fast = 18;
        while(magic.length()< n){
            char prev = magic.charAt(fast);
            if(magic.charAt(slow) == '1'){
                if(prev == '1'){
                    magic.append("2");
                }else{
                    magic.append("1");
                }
                slow++;
                fast++;
            }else if(magic.charAt(slow) == '2'){
                if(prev == '1'){
                    magic.append("22");
                }else{
                    magic.append("11");
                }
                slow++;
                fast+=2;
            }
        }
        return count1(magic, n);
    }

    private int count1(StringBuilder magic, int n) {
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(magic.charAt(i) == '1'){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new MagicalString().magicalString(10000));  //16
        System.out.println(new MagicalString().magicalString(31));  //16
        System.out.println(new MagicalString().magicalString(55));  //28
        System.out.println(new MagicalString().magicalString(6));
    }
}
