package com.moses.leet.n0260;

import com.moses.leet.pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * Example :
 *
 * Input:  root = [5,1,5,5,5,null,5]
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 * Output: 4
 *
 */
public class CountUnivalueSubtrees {
    int res= 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return res;
    }

    private long dfs(TreeNode root) {
        if(root.left == null && root.right == null){
            res++;
            return root.val;
        }else if(root.left == null && root.right != null){
            long r = dfs(root.right);
            if(r == Long.MAX_VALUE || root.val != r){
                return Long.MAX_VALUE;
            }else{
                res++;
                return root.val;
            }
        }else if(root.left != null && root.right == null){
            long l = dfs(root.left);
            if(l == Long.MAX_VALUE || root.val != l){
                return Long.MAX_VALUE;
            }else{
                res++;
                return root.val;
            }
        }else{
            long l = dfs(root.left);
            long r = dfs(root.right);
            if(l== Long.MAX_VALUE || r == Long.MAX_VALUE || root.val != l || root.val != r){
                return Long.MAX_VALUE;
            }else{
                res++;
                return root.val;
            }
        }
    }
}
