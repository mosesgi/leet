package com.moses.leet.n0640;

public class SolveTheEquation {
    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        String left = strs[0];
        String right = strs[1];
        int[] l = combine(left);
        int[] r = combine(right);
        int xFac = l[0] - r[0];
        int num = r[1] - l[1];
        if(xFac == 0 && num == 0){
            return "Infinite solutions";
        }else if(xFac == 0 && num != 0){
            return "No solution";
        }else{
            num = num/xFac;
            return "x="+num;
        }
    }

    private int[] combine(String str) {
        int xFac = 0;
        int num = 0;
        int begin = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c=='+' || c== '-' || c=='=' || i == str.length()-1){
                int end = i;
                if(i==str.length()-1){
                    end = i+1;
                }
                if(begin==end){
                    continue;
                }
                String prev = str.substring(begin, end);
                if(prev.contains("x")){
                    String factor = prev.substring(0, prev.length()-1);
                    if(factor.length() == 0 || factor.equals("+")){
                        xFac += 1;
                    }else if(factor.equals("-")){
                        xFac -= 1;
                    }else {
                        xFac += Integer.parseInt(factor);
                    }
                }else{
                    num += Integer.parseInt(prev);
                }
                begin = end;
            }
        }
        return new int[]{xFac, num};
    }

    public static void main(String[] args) {
        String e;
        e = "-x=-1";
        System.out.println(new SolveTheEquation().solveEquation(e));

        e = "x+5-3+x=6+x-2";
        System.out.println(new SolveTheEquation().solveEquation(e));

        e = "x=x";
        System.out.println(new SolveTheEquation().solveEquation(e));

        e = "2x=x";
        System.out.println(new SolveTheEquation().solveEquation(e));

        e = "2x+3x-6x=x+2";
        System.out.println(new SolveTheEquation().solveEquation(e));

        e = "x=x+2";
        System.out.println(new SolveTheEquation().solveEquation(e));
    }
}
