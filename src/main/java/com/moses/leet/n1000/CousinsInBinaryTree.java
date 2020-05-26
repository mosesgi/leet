package com.moses.leet.n1000;

import com.moses.leet.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CousinsInBinaryTree {
    Map<Integer, TreeNode> parent = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        if(x==y){
            return false;
        }
        dfs(root);
        if(!parent.containsKey(x) || !parent.containsKey(y)){
            return false;
        }
        if(parent.get(x) == parent.get(y)){
            return false;
        }
        int xDep = 0, yDep = 0;
        while(parent.containsKey(x)){
            xDep++;
            x = parent.get(x).val;
        }
        while(parent.containsKey(y)){
            yDep++;
            y = parent.get(y).val;
        }
        return xDep==yDep;
    }

    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
