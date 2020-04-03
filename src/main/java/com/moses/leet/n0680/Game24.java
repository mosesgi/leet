package com.moses.leet.n0680;

import java.util.*;

public class Game24 {
    public boolean judgePoint24(int[] nums) {
        for(int i=1; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();
            set.addAll(Arrays.asList(1,2,3));
            Set<Double> aL = calculateTwo(nums[0], nums[i]);
            set.remove(i);
            Integer[] o = set.toArray(new Integer[0]);
            Set<Double> bL = calculateTwo(nums[o[0]], nums[o[1]]);

            for(Double a : aL){
                for(Double b : bL){
                    Set<Double> rst = calculateTwo(a, b);
                    for(Double j : rst){
                        if(Math.abs(24-j)<0.001){
                            return true;
                        }
                    }
                }
            }
        }

        for(int i=0; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();
            set.addAll(Arrays.asList(0,1,2,3));
            set.remove(i);
            Set<Double> l3 = new HashSet<>();
            Integer[] the3 = set.toArray(new Integer[0]);
            for(int j=0; j<the3.length; j++){
                Set<Integer> set3 = new HashSet<>();
                set3.addAll(Arrays.asList(0,1,2));
                set3.remove(j);
                Integer[] the2 = set3.toArray(new Integer[0]);
                Set<Double> l2 = calculateTwo(nums[the3[the2[0]]], nums[the3[the2[1]]]);
                for(Double li2 : l2){
                    l3.addAll(calculateTwo(li2, nums[the3[j]]));
                }
            }
            for(Double li3 : l3){
                Set<Double> rst = calculateTwo(li3, nums[i]);
                for(Double k : rst){
                    if(Math.abs(24-k)<0.001){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Set<Double> calculateTwo(double a, double b){
        Set<Double> list = new HashSet<>();
        list.add(a+b);
        list.add(a-b);
        list.add(b-a);
        list.add(a*b);
        if(b!=0) {
            list.add(a / b);
        }
        if(a!=0) {
            list.add(b / a);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums;
        double a = 8d/3;
        double b = 3-a;
        System.out.println( 8/b);

        nums = new int[]{3,3,8,8};
        System.out.println(new Game24().judgePoint24(nums));

        nums = new int[]{1,3,4,6};
        System.out.println(new Game24().judgePoint24(nums));

        nums = new int[]{4,1,8,7};
        System.out.println(new Game24().judgePoint24(nums));

        nums = new int[]{1,2,1,2};
        System.out.println(new Game24().judgePoint24(nums));
    }

}
