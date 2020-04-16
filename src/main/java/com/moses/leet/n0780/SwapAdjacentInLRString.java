package com.moses.leet.n0780;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        //RXRLRLRXRL -> RRLRLRRXXL RRLRLRXRXL
        //XXRLRLRRLR

        StringBuilder s = new StringBuilder();
        for(char c : start.toCharArray()){
            if(c != 'X'){
                s.append(c);
            }
        }
        StringBuilder e = new StringBuilder();
        for(char c : end.toCharArray()){
            if(c != 'X'){
                e.append(c);
            }
        }
        if(!s.toString().equals(e.toString())){
            return false;
        }

        //check L, pos in end should always <= in start
        int p1 = 0, p2 = 0;
        while(p1 < start.length() && p2 < end.length()){
            while(p1 < start.length() && start.charAt(p1) != 'L'){
                p1++;
            }
            while(p2 < end.length() && end.charAt(p2) != 'L'){
                p2++;
            }
            if(p2 >p1){
                return false;
            }
            p1++;
            p2++;
        }

        //Check R, pos in end should always >= in start
        p1 = 0; p2 = 0;
        while(p1 < start.length() && p2 < end.length()){
            while(p1 < start.length() && start.charAt(p1) != 'R'){
                p1++;
            }
            while(p2 < end.length() && end.charAt(p2) != 'R'){
                p2++;
            }
            if(p2 <p1){
                return false;
            }
            p1++;
            p2++;
        }

        return true;
    }

    public static void main(String[] args) {
        String start, end;
        start = "X";
        end = "L";
        System.out.println(new SwapAdjacentInLRString().canTransform(start,end));

        start = "RXXLRXRXL";
        end = "XRLXXRRLX";
        System.out.println(new SwapAdjacentInLRString().canTransform(start,end));

        start = "XXXXXLXXXLXXXX";
        end = "XXLXXXXXXXXLXX";
        System.out.println(new SwapAdjacentInLRString().canTransform(start,end));
    }
}
