package com.moses.leet.n0520;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class FindModeInBST {

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        useList(root, list);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : list){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        List<Integer> big = new ArrayList<>();
        for(Integer key : map.keySet()){
            int curr = map.get(key);
            if(curr > max){
                max = curr;
                big.clear();
                big.add(key);
            }else if(curr == max){
                big.add(key);
            }
        }
        int[] rst = new int[big.size()];
        for(int i=0; i<big.size(); i++){
            rst[i] = big.get(i);
        }
        return rst;
    }

    private void useList(TreeNode root, List<Integer> list) {
        if(root== null){
            return;
        }
        list.add(root.val);
        useList(root.left, list);
        useList(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(Arrays.toString(new FindModeInBST().findMode(root)));
    }

}
