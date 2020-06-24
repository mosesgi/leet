package com.moses.leet.n1020;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> dels = new HashSet<>();
        for(int i : to_delete){
            dels.add(i);
        }

        TreeNode r = dfs(root, dels);
        if(r != null){
            res.add(r);
        }
        return res;
    }

    TreeNode dfs(TreeNode root, Set<Integer> dels){
        if(root == null){
            return null;
        }
        root.left = dfs(root.left, dels);
        root.right = dfs(root.right, dels);

        if(dels.contains(root.val)){
            if(root.left != null){
                res.add(root.left);
            }
            if(root.right != null){
                res.add(root.right);
            }
            return null;
        }
        return root;
    }



    public List<TreeNode> delNodesNew(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete){
            set.add(i);
        }
        if(root == null){
            return res;
        }
        if(set.contains(root.val)){
            dfs(root, set, true, root);
            root.left = null;
            root.right = null;
        }else{
            res.add(root);
            dfs(root, set, false, root);
        }
        return res;
    }

    void dfs(TreeNode root, Set<Integer> set, boolean parentDeleted, TreeNode parent){
        if(root == null){
            return;
        }
        if(set.contains(root.val)){
            if(parent.left == root){
                parent.left = null;
            }
            if(parent.right == root){
                parent.right = null;
            }
            dfs(root.left, set, true, root);
            dfs(root.right, set, true, root);
            root.left = null;
            root.right = null;
        }else{
            if(parentDeleted){
                res.add(root);
            }
            dfs(root.left, set, false, root);
            dfs(root.right, set, false, root);
        }
    }
}
