package com.moses.leet.n1020;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6]
 * Output: 110
 * Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
 * Example 2:
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation:  Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
 * Example 3:
 * Input: root = [2,3,9,10,7,8,6,5,4,11,1]
 * Output: 1025
 * Example 4:
 * Input: root = [1,1]
 * Output: 1
 *
 * Constraints:
 *
 * Each tree has at most 50000 nodes and at least 2 nodes.
 * Each node's value is between [1, 10000].
 *
 */
public class MaximumProductOfSplittedBinaryTree {

    public int maxProduct(TreeNode root) {
        List<Long> subs = new ArrayList<>();
        long sum = dfs(root.left, subs) + dfs(root.right, subs) + root.val;

        long res = 0;
        long diff = Long.MAX_VALUE;
        long target = sum/2;
        for(long i : subs){
            if(Math.abs(i-target) < diff){
                diff = Math.abs(i-target);
                res = i;
            }
        }
        return (int)(res*(sum-res)%1000000007);
    }

    long dfs(TreeNode root, List<Long> subs){
        if(root == null){
            return 0;
        }
        long left = dfs(root.left, subs);
        long right = dfs(root.right, subs);
        long res = left+right+root.val;
        subs.add(res);
        return res;
    }
}
