package com.moses.leet.n0900;

import com.moses.leet.pojo.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, 0, pre.length-1, post, 0, post.length-1);
    }

    TreeNode construct(int[] pre, int preL, int preR, int[] post, int postL, int postR){
        if(preL > preR){
            return null;
        }else if(preL == preR){
            return new TreeNode(pre[preL]);
        }
        TreeNode root = new TreeNode(pre[preL]);
        int leftChild = pre[preL+1];
        int rightChild = post[postR-1];
        if(leftChild == rightChild){
            root.left = construct(pre, preL+1, preR, post, postL, postR-1);
        }else{
            int postPos = findPos(leftChild, post, postL, postR);
            int len = postPos - postL +1;
            root.left = construct(pre, preL+1, preL+len, post, postL, postL+len-1);
            root.right = construct(pre, preL+len+1, preR, post, postL+len, postR);
        }
        return root;
    }

    int findPos(int target, int[] ary, int l, int r){
        for(int i=l; i<=r; i++){
            if(ary[i] == target){
                return i;
            }
        }
        return -1;
    }
}
