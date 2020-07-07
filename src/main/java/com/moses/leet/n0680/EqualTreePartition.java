package com.moses.leet.n0680;

import com.moses.leet.pojo.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have
 * the equal sum of values after removing exactly one edge on the original tree.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   10 10
 *     /  \
 *    2   3
 *
 * Output: True
 * Explanation:
 *     5
 *    /
 *   10
 *
 * Sum: 15
 *
 *    10
 *   /  \
 *  2    3
 *
 * Sum: 15
 *
 * Example 2:
 *
 * Input:
 *     1
 *    / \
 *   2  10
 *     /  \
 *    2   20
 *
 * Output: False
 * Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
 *
 * Note:
 *
 *     The range of tree node value is in the range of [-100000, 100000].
 *     1 <= n <= 10000
 *
 */
public class EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Set<TreeNode>> map = new HashMap<>();
        int total = dfs(root, map, true);
        if(total %2 != 0){
            return false;
        }
        return map.containsKey(total/2) && !map.get(total/2).isEmpty();
    }

    int dfs(TreeNode root, Map<Integer, Set<TreeNode>> map, boolean isRoot){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left, map, false);
        int right = dfs(root.right, map, false);
        if(!isRoot){
            map.computeIfAbsent(root.val + left+right, z-> new HashSet<>()).add(root);
        }
        return left+right+root.val;
    }

}
