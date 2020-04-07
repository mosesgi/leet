package com.moses.leet.n0700;

import com.moses.leet.pojo.TreeNode;

public class LongestUnivaluePath {
    int len = 1;
    public int longestUnivaluePath(TreeNode root) {
        recur(root);
        return len-1;
    }

    private int recur(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = recur(root.left);
        int right = recur(root.right);
        int cur = 1;
        if(root.left == null && root.right==null ){
            return 1;
        }else if(root.left == null){
            if(root.right.val == root.val){
                cur = right+1;
            }
        }else if(root.right == null){
            if(root.left.val == root.val){
                cur = left+1;
            }
        }else{
            if(root.left.val == root.val && root.right.val == root.val) {
                int tmp = left+right+1;
                if(tmp > len){
                    len = tmp;
                }
                cur = Math.max(left, right) + 1;
            }else if(root.left.val == root.val){
                cur = left+1;
            }else if(root.right.val == root.val){
                cur = right+1;
            }
        }
        if(cur > len){
            len = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }
}
