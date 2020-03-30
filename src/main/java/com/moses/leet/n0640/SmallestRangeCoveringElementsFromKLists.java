package com.moses.leet.n0640;

import java.util.*;

public class SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int tmpMax = Integer.MIN_VALUE;
        for(int i=0; i<nums.size(); i++){
            List<Integer> row = nums.get(i);
            pq.offer(new Element(i, 0, row.get(0)));
            tmpMax = Math.max(tmpMax, row.get(0));
        }

        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        int range = Integer.MAX_VALUE;
        while(!pq.isEmpty() && pq.size() == nums.size()){
            Element e = pq.poll();
            if(tmpMax - e.val < range){
                range = tmpMax - e.val;
                left = e.val;
                right = tmpMax;
            }
            if(e.col < nums.get(e.row).size()-1){
                tmpMax = Math.max(tmpMax, nums.get(e.row).get(e.col+1));
                pq.offer(new Element(e.row, e.col+1, nums.get(e.row).get(e.col+1)));
            }
        }
        return new int[]{left, right};
    }

    class Element implements Comparable<Element>{
        int row;
        int col;
        int val;

        public Element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int compareTo(Element o){
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(4,10,15,24,26));
        list.add(Arrays.asList(0,9,12,20));
        list.add(Arrays.asList(5,18,22,30));
        System.out.println(Arrays.toString(new SmallestRangeCoveringElementsFromKLists().smallestRange(list)));
    }
}
