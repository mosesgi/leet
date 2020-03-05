package com.moses.leet.n0400;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles.length == 0) return false;
        int ax = Integer.MAX_VALUE;
        int ay = Integer.MAX_VALUE;
        int bx = 0;
        int by = 0;

        Set<String> points = new HashSet<>();
        int totalAreas = 0;
        for(int[] rect : rectangles){
            int area = 0;
            int rax = rect[0];
            int ray = rect[1];
            int rbx = rect[2];
            int rby = rect[3];

            String p1 = rax + "_" + ray;
            String p2 = rax + "_" + rby;
            String p3 = rbx + "_" + ray;
            String p4 = rbx + "_" + rby;
            if(points.contains(p1)){
                points.remove(p1);
            }else {
                points.add(p1);
            }
            if(points.contains(p2)){
                points.remove(p2);
            }else{
                points.add(p2);
            }
            if(points.contains(p3)){
                points.remove(p3);
            }else{
                points.add(p3);
            }
            if(points.contains(p4)){
                points.remove(p4);
            }else{
                points.add(p4);
            }

            ax = Math.min(rax, ax);
            ay = Math.min(ray, ay);
            bx = Math.max(rbx, bx);
            by = Math.max(rby, by);

            area = (rbx-rax) * (rby-ray);
            totalAreas += area;
        }

        if(!points.contains(ax + "_" + ay) || !points.contains(ax +"_"+by) || !points.contains(bx+"_"+ay) || !points.contains(bx+"_"+by) || points.size() != 4){
            return false;
        }

        int finalArea = (bx-ax) * (by-ay);
        return finalArea == totalAreas;
    }

    public static void main(String[] args) {
        int[][] rect;
        rect = new int[][]{{0,0,1,1},{0,1,3,2},{1,0,2,2}};
        System.out.println(new PerfectRectangle().isRectangleCover(rect));
    }

}
