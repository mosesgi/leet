package com.moses.leet.n0680;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class MaximumWidthOfBinaryTree {
    int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        dfs(root, 1, 1, firstMap);
        return max;
    }

    void dfs(TreeNode root, int level, int pos, Map<Integer, Integer> map){
        if(root == null){
            return;
        }
        if(!map.containsKey(level)){
            map.put(level, pos);
        }else{
            max = Math.max(max, pos - map.get(level)+1);
        }
        dfs(root.left, level+1, pos*2-1, map);
        dfs(root.right, level+1, pos*2, map);
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
