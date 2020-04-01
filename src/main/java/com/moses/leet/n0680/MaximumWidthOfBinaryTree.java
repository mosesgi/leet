package com.moses.leet.n0680;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        int maxLen = 0;
        for(int key : map.keySet()){
            List<Integer> l = map.get(key);
            maxLen = Math.max(maxLen, l.get(l.size()-1) - l.get(0) + 1);
        }
        return maxLen;
    }

    private void dfs(TreeNode root, int level, int pos) {
        if(map.containsKey(level)){
            map.get(level).add(pos);
        }else{
            List<Integer> l = new ArrayList<>();
            l.add(pos);
            map.put(level, l);
        }
        if(root.left != null){
            dfs(root.left, level+1, pos*2-1);
        }
        if(root.right != null){
            dfs(root.right, level+1, pos*2);
        }
    }


    public int widthOfBinaryTreeLevelTraverse(TreeNode root) {
        int maxLen = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                list.add(q.poll());
            }
            int left = 0, right = list.size()-1;
            while(left < list.size() && list.get(left) == null){
                left++;
            }
            while(right >=0 && list.get(right) == null){
                right--;
            }
            if(left>right){
                break;
            }else{
                maxLen = Math.max(maxLen, right-left+1);
            }
            for(int i=left; i<=right; i++){
                if(list.get(i) == null){
                    q.offer(null);
                    q.offer(null);
                }else{
                    TreeNode n = list.get(i);
                    q.offer(n.left);
                    q.offer(n.right);
                }
            }
        }
        return maxLen;
    }
}
