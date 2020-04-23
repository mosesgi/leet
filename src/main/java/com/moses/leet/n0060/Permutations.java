package com.moses.leet.n0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        back(nums, used, new ArrayList<>(), res);
        return res;
    }

    void back(int[] nums, boolean[] used, List<Integer> l, List<List<Integer>> res){
        if(l.size() == nums.length){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]){
                continue;
            }
            l.add(nums[i]);
            used[i] = true;
            back(nums, used, l, res);
            used[i] = false;
            l.remove(l.size() -1);
        }
    }


    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permuteOld(int[] nums) {
        List<Integer> row = new ArrayList<>();
        permuteRecursive(nums, row);
        return list;
    }

    private void permuteRecursive(int[] nums, List<Integer> row){

        if(nums.length == 0){
            list.add(new ArrayList<>(row));
            return;
        }
        for(int i=0; i<nums.length; i++){
            int[] tmpNum = new int[nums.length-1];
            int k = 0;
            for(int j=0; j<nums.length; j++){
                if(j==i){
                    continue;
                }
                tmpNum[k++] = nums[j];
            }
            row.add(nums[i]);
            permuteRecursive(tmpNum, row);
            row.remove(row.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> list = new Permutations().permute(nums);
        for(List l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();
    }
}
