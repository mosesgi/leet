package com.moses.leet.n0520;

import com.moses.leet.pojo.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    int level = 0;
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);
        return map.get(level);
    }

    void dfs(TreeNode root, int l, Map<Integer, Integer> map){
        if(root == null){
            return;
        }
        if(!map.containsKey(l)){
            map.put(l, root.val);
        }
        level = Math.max(level, l);
        dfs(root.left, l+1, map);
        dfs(root.right, l+1, map);
    }


    public int findBottomLeftValue1(TreeNode root) {
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
