package com.moses.leet.n1020;

import com.moses.leet.pojo.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        //[8,5,1,7,10,12]
        return construct(preorder, 0, preorder.length-1);
    }

    TreeNode construct(int[] ary, int start, int end){
        if(start > end){
            return null;
        }
        if(start == end){
            return new TreeNode(ary[start]);
        }
        TreeNode root = new TreeNode(ary[start]);
        int mid = end+1;
        for(int i=start+1; i<=end; i++){
            if(ary[i] > ary[start]){
                mid = i;
                break;
            }
        }
        root.left = construct(ary, start+1, mid-1);
        root.right = construct(ary, mid, end);
        return root;
    }
}
