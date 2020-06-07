package com.moses.leet.lcci;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a binary tree in which each node contains an integer value (which might be positive or negative). Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * Example:
 * Given the following tree and  sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * Output:
 *
 * 3
 * Explanation: Paths that have sum 22 are: [5,4,11,2], [5,8,4,5], [4,11,7]
 *
 * Note:
 *
 *     node number <= 10000
 *
 */
public class PathsWithSumLCCI {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum, 0, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, int curSum, List<Integer> l) {
        if(root == null){
            return;
        }
        l.add(root.val);
        curSum += root.val;

        if(curSum == sum){
            res++;
        }
        int tmp = curSum;
        for(int i=0; i<l.size()-1; i++){
            tmp -= l.get(i);
            if(tmp == sum){
                res++;
            }
        }

        dfs(root.left, sum, curSum, l);
        dfs(root.right, sum, curSum, l);

        l.remove(l.size()-1);
    }

}
