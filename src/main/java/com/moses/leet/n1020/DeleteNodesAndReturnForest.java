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
}
