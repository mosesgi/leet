package com.moses.leet.n0480;

public class NumberComplement {
    public int findComplement(int num) {
        int rst = 0;
        boolean firstOneFound = false;
        for(int i=31; i>=0; i--){
            int mask = (1<<i);
            if((num | mask) != num){  //it's 0
                if(!firstOneFound){
                    continue;
                }
                rst |= (1<<i);
            }else{
                if(!firstOneFound) {
                    firstOneFound = true;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(5));
        System.out.println(new NumberComplement().findComplement(1));
    }
}
