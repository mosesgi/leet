package com.moses.leet.n0520;

import com.moses.leet.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            boolean hasNextLevel = false;
            TreeNode levelFirst = q.peek();
            while(q.peek() != null) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.offer(curr.left);
                    hasNextLevel = true;
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                    hasNextLevel = true;
                }
            }
            if(!hasNextLevel){
                return levelFirst.val;
            }
            q.offer(q.poll());      //null
        }
        return 0;
    }
}
