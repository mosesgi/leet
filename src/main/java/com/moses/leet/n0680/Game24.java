package com.moses.leet.n0680;

import java.util.*;

public class Game24 {
    public boolean judgePoint24Official(int[] nums) {
        List<Double> numbers = new ArrayList<Double>();
        for (int num : nums) {
            numbers.add((double) num);
        }
        return solve(numbers);
    }

    /**
     * @description 回溯法，从数组中选出两个数，把运算结果加到数组中
     */
    private boolean solve(List<Double> numbers) {
        if (numbers.size() == 1) {//数组中只剩下一个数的时候判断结果
            return Math.abs(numbers.get(0) - 24) < 1e-6;//看是否与24相等
        }
        //从numbers中取出两个数，把结果放入数组中
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j) {//取不同的两个数
                    //如果回溯的话，还要恢复现场，把数插回原位置，所以不如直接生成一个新数组
                    List<Double> nums = new ArrayList<Double>();
                    for (int k = 0; k < numbers.size(); k++) {
                        if (k != i && k != j) {//把剩下的数加入到新数组
                            nums.add(numbers.get(k));
                        }
                    }
                    Set<Double> doubles = calculate(numbers.get(i), numbers.get(j));//获取两个数运算的结果集
                    for (Double aDouble : doubles) {
                        nums.add(aDouble);//把两个数运算的结果，分别加入到新数组中
                        if (solve(nums)) {//找到一个结果，立即返回
                            return true;
                        }
                        nums.remove(nums.size() - 1);//恢复现场
                    }
                }
            }
        }
        return false;//如果没有找到结果，返回false
    }

    /**
     * @description 返回两个数计算得到的结果集
     */
    private Set<Double> calculate(double a, double b) {
        Set<Double> res = new HashSet<Double>();
        res.add(a - b);
        res.add(b - a);
        res.add(a + b);
        res.add(a * b);
        if (a != 0) {
            res.add(b / a);
        }
        if (b != 0) {
            res.add(a / b);
        }
        return res;
    }



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
