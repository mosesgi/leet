package com.moses.leet.n0880;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Constraints:
 *
 *     Both of the given trees will have between 1 and 200 nodes.
 *     Both of the given trees will have values between 0 and 200
 *
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        if(l1.size() != l2.size()){
            return false;
        }

        for(int i=0; i<l1.size(); i++){
            if(l1.get(i) != l2.get(i)){
                return false;
            }
        }
        return true;
    }

    void dfs(TreeNode root, List<Integer> l){
        if(root == null){
            return;
        }
        dfs(root.left, l);
        dfs(root.right, l);
        if(root.left == null && root.right == null){
            l.add(root.val);
        }
    }
}
