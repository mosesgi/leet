package com.moses.leet.n0220;

import java.util.*;

public class TheSkylineProblem {

    //https://www.youtube.com/watch?v=GSBLe8cKu0s
    class Point implements Comparable<Point>{
        int x;
        int y;
        boolean isStart;

        Point(int x, int y, boolean isStart){
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Point o) {
            //same x
            //if both start, higher first
            //if both end, lower first
            //if one start, one end, start first
            if(this.x != o.x){
                return this.x - o.x;
            } else {
                if (this.isStart && o.isStart) {
                    return o.y - this.y;
                } else if (!this.isStart && !o.isStart) {
                    return this.y - o.y;
                } else if (this.isStart && !o.isStart) {
                    return -o.y;
                } else {
                    return o.y;
                }
            }
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Point> l = new ArrayList<>();
        for(int[] b : buildings){
            Point left = new Point(b[0], b[2], true);
            l.add(left);
            Point right = new Point(b[1], b[2], false);
            l.add(right);
        }

        Collections.sort(l);

        List<List<Integer>> list = new ArrayList<>();

        TreeMap<Integer, Integer> maxHeights = new TreeMap<>();
        maxHeights.put(0, 1);
        int prevMaxH = 0;
        for(Point p : l){
            if(p.isStart){
                //start of building. add to MaxHeap. If max height changes, means this point is a key point.
                if(maxHeights.containsKey(p.y)){
                    maxHeights.put(p.y, maxHeights.get(p.y)+1);
                } else {
                    maxHeights.put(p.y, 1);
                }
                int currMaxH = maxHeights.lastKey();
                if(currMaxH > prevMaxH){
                    list.add(Arrays.asList(p.x, p.y));
                    prevMaxH = currMaxH;
                }
            } else {
                //end of building. Reduce from MaxHeap. If max height changes, means this point is a key point
                //but height is currentMaxHeight
                if(maxHeights.get(p.y)==1){
                    maxHeights.remove(p.y);
                }else{
                    maxHeights.put(p.y, maxHeights.get(p.y) -1);
                }
                int currMaxH = maxHeights.lastKey();
                if(currMaxH < prevMaxH){
                    list.add(Arrays.asList(p.x, currMaxH));
                    prevMaxH = currMaxH;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }


}
