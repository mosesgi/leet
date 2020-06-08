package com.moses.leet.n1400;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return construct(list, 0, list.size()-1);
    }

    private TreeNode construct(List<Integer> list, int l, int r) {
        if(l>r){
            return null;
        }else if(l==r){
            return new TreeNode(list.get(l));
        }
        int m = l+(r-l)/2;
        TreeNode mid = new TreeNode(list.get(m));
        mid.left = construct(list, l, m-1);
        mid.right = construct(list, m+1, r);
        return mid;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
