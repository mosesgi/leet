package com.moses.leet.n0540;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");

        int a1 = Integer.parseInt(as[0]);
        int b1 = Integer.parseInt(bs[0]);

        int a2 = Integer.parseInt(as[1].substring(0, as[1].length()-1));
        int b2 = Integer.parseInt(bs[1].substring(0, bs[1].length()-1));

        int r1 = a1*b1 + a2*b2*(-1);
        int r2 = a1*b2 + a2*b1;
        return r1 + "+" + r2 + "i";
    }
}
