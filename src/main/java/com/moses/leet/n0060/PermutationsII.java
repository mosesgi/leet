package com.moses.leet.n0060;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class PermutationsII {
    //1,1,2
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        back(nums, used, new ArrayList<>(), res);
        return res;
    }

    // 1 (0) -> 1,1,2;  1,2,1
    // 1 (1) -> continue
    // 2 (2) -> 2,1(0),1(1)

    void back(int[] nums, boolean[] used, List<Integer> l, List<List<Integer>> res){
        if(l.size() == nums.length){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i] || (i>0 && !used[i-1] && nums[i] == nums[i-1])){
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
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUniqueOld(int[] nums) {
        List<Integer> row = new ArrayList<>();
        recursive(nums, row);
        return list;
    }

    private void recursive(int[] nums, List<Integer> row){
        if(nums.length == 0 && !set.contains(row)){
            list.add(new ArrayList<>(row));
            set.add(new ArrayList<>(row));
            return;
        }
        for(int i=0; i<nums.length; i++){
            int k= 0;
            int[] tmpNum = new int[nums.length-1];
            for(int j=0; j<nums.length; j++){
                if(i==j){
                    continue;
                }
                tmpNum[k++] = nums[j];
            }
            row.add(nums[i]);
            recursive(tmpNum, row);
            row.remove(row.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> list = new PermutationsII().permuteUnique(nums);
        for(List l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();


    }

}
