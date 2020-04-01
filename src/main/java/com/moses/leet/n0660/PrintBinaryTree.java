package com.moses.leet.n0660;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    int height = 0;
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        getHeight(root, 1);
        int cols = calculateWidth();
        //initialize
        for(int i=0; i<height; i++){
            List<String> l = new ArrayList<>(cols);
            for(int j=0; j<cols; j++){
                l.add("");
            }
            list.add(l);
        }
        populate(root, list, 0, 0, cols-1);

        return list;
    }

    private void populate(TreeNode root, List<List<String>> list, int level, int l, int r) {
        if(root == null){
            return;
        }
        int mid = (l+r)/2;
        list.get(level).set(mid, root.val+"");
        if(l==r){
            return;
        }
        populate(root.left, list, level+1, l, mid-1);
        populate(root.right, list, level+1, mid+1, r);
    }

    private int calculateWidth() {
        int prev = 0;
        for(int i = 1; i<=height; i++){
            prev = prev*2 + 1;
        }
        return prev;
    }

    private void getHeight(TreeNode root, int level) {
        if(root == null){
            return;
        }
        if(level > height){
            height = level;
        }
        getHeight(root.left, level+1);
        getHeight(root.right, level+1);
    }


}
