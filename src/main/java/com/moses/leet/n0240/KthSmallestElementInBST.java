package com.moses.leet.n0240;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInBST {
    Integer res = null;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    void dfs(TreeNode root, int k){
        if(root == null || cnt >= k){
            return;
        }
        dfs(root.left, k);
        cnt++;
        if(cnt == k){
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }


    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            k--;
            if(k==0){
                return node.val;
            }
            if(node.right != null) {
                stack.push(node.right);
                TreeNode c = node.right;
                while(c != null && c.left != null){
                    stack.push(c.left);
                    c = c.left;
                }
            }
        }
        return 0;
    }



}
