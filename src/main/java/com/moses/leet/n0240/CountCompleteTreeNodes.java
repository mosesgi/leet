package com.moses.leet.n0240;

import com.moses.leet.pojo.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root){
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if(leftDepth == rightDepth){
            return (1<<leftDepth) -1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    int leftDepth(TreeNode root){
        int d = 0;
        while(root != null){
            root = root.left;
            d++;
        }
        return d;
    }

    int rightDepth(TreeNode root){
        int d = 0;
        while(root != null){
            root = root.right;
            d++;
        }
        return d;
    }




    public int countNodesOld(TreeNode root){
        if(root == null ){
            return 0;
        }
        int left = countNodesOld(root.left);
        int right = countNodesOld(root.right);
        return left+right+1;
    }


}
