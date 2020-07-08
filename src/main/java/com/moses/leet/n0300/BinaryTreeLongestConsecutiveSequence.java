package com.moses.leet.n0300;

import com.moses.leet.pojo.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * Example 1:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 *
 * Output: 3
 *
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 *
 * Example 2:
 *
 * Input:
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 * Output: 2
 *
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 *
 */
public class BinaryTreeLongestConsecutiveSequence {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root);
        return res;
    }

    int dfs(TreeNode root){
        int left = 0, right = 0;
        if(root.left != null){
            int l = dfs(root.left);
            if(root.val == root.left.val -1){
                left = l;
            }
        }
        if(root.right != null){
            int r = dfs(root.right);
            if(root.val == root.right.val - 1){
                right = r;
            }
        }
        int cur = Math.max(left+1, right+1);
        res = Math.max(cur, res);
        return cur;
    }
}
