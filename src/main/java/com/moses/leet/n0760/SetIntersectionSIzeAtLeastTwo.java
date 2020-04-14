package com.moses.leet.n0760;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SetIntersectionSIzeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
//        for(int[] a : intervals){
//            System.out.print(Arrays.toString(a) + ",");
//        }
//        System.out.println();
        TreeSet<Integer> set = new TreeSet<>();
        for(int[] ints : intervals){
            Set<Integer> sub = set.subSet(ints[0], true, ints[1], true);
            if(sub.size()>=2){
                continue;
            }else if(sub.size()==1){
                if(set.contains(ints[1])){
                    set.add(ints[1]-1);
                }else {
                    set.add(ints[1]);
                }
            }else{
                set.add(ints[1]);
                set.add(ints[1]-1);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[][] intervals;
        intervals = new int[][]{{0,9},{0,2},{2,7},{8,10},{6,7},{3,7},{1,9},{0,9},{3,9},{3,9}};
        System.out.println(new SetIntersectionSIzeAtLeastTwo().intersectionSizeTwo(intervals));
    }
}
