package com.moses.leet.n0980;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
 *
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)
 *
 * Return the number of moves required to make every node have exactly one coin.
 *
 */

/**
 * 从后序遍历的第一个叶子节点开始，假设自己有x个金币，剩余x-1个金币都还给父节点，x-1可能为负数、0、正数
 * x-1 < 0说明不够金币，需要从父节点获得，因此子节点有|x-1|个入方向的操作，次数加上|x-1|
 * x-1 == 0说明刚好，无需与父节点有金币的交换，次数加0
 * x-1 > 0 说明有多余的金币，需要交给父节点，因此子节点有x-1个出方向的操作，次数加上|x-1|
 */
public class DistributeCoinsInBinaryTree {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfsMine(root);
        return res;
    }

    int dfsMine(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dfsMine(root.left);
        int r = dfsMine(root.right);
        int diff = l+r+root.val - 1;
        res += Math.abs(diff);
        return diff;
    }

    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Math.abs(dfs(root.left));
        int r = Math.abs(dfs(root.right));
        int tmp  =l+r + root.val - 1;
        res+=tmp;
        return tmp;
    }
}
