package com.moses.leet.n0960;

import com.moses.leet.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteNessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty() && q.peek() != null){
            TreeNode cur = q.poll();
            q.offer(cur.left);
            q.offer(cur.right);
        }
        while(!q.isEmpty() && q.peek() == null){
            q.poll();
        }
        return q.isEmpty();
    }


    public boolean isCompleteTree1(TreeNode root) {
        int h = height(root);
        Queue<TreeNode> q = new LinkedList<>();
        int height = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean nullMet = false;
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(cur == null){
                    nullMet = true;
                    if(height != h-1){
                        return false;
                    }
                }else{
                    if(nullMet){
                        return false;
                    }
                    if(height == h-1 && (cur.left != null || cur.right != null)){
                        return false;
                    }
                    if(height < h-1){
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                }
            }
            height++;
        }
        return true;
    }

    private int height(TreeNode root) {
        int h = 0;
        while(root != null){
            root = root.left;
            h++;
        }
        return h;
    }
}
