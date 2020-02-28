package com.moses.leet.n0340;

import com.moses.leet.pojo.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class HouseRobberIII {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int val = 0;
        if(root.left != null){
            val += (rob(root.left.left) + rob(root.left.right));
        }
        if(root.right != null){
            val += (rob(root.right.left) + rob(root.right.right));
        }
        int rst = Math.max(rob(root.left) + rob(root.right), root.val + val);
        map.put(root, rst);
        return rst;
    }

    public static void main(String[] args) {

    }
}
