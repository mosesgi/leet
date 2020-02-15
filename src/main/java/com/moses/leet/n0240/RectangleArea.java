package com.moses.leet.n0240;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int bottom = Math.max(B, F);
        int right = Math.min(C, G);
        int top = Math.min(H, D);

        int same = 0;
        if(right>left && top>bottom){
            same = (right-left) * (top-bottom);
        }

        int rectA = (C-A) * (D-B);
        int rectB = (G-E) * (H-F);
        return rectA + rectB - same;
    }
}
