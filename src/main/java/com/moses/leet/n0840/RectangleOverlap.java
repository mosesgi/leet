package com.moses.leet.n0840;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]){
            return false;
        }
        if(rec1[1] >= rec2[3] || rec2[1] >= rec1[3]){
            return false;
        }
        return true;
    }
}