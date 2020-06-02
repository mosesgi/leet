package com.moses.leet.n0200;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode cur = q.poll();
                if(i==0){
                    res.add(cur.val);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
            }
        }
        return res;
    }



    public List<Integer> rightSideViewDfs(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs(root, 0, l);
        return l;
    }

    void dfs(TreeNode node, int level, List<Integer> l){
        if(node == null){
            return;
        }
        if(l.size() <= level){
            l.add(node.val);
        }else{
            l.set(level, node.val);
        }
        dfs(node.left, level+1, l);
        dfs(node.right, level+1, l);
    }


    public List<Integer> rightSideViewOld(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        TreeNode prev = null;
        while(!q.isEmpty()){
            TreeNode currNode = q.poll();

            if(currNode == null){
                if(prev == null){
                    break;
                }
                q.offer(null);
                prev = null;
                continue;
            }

            if(prev == null){
                rst.add(currNode.val);
            }

            if(currNode.right != null){
                q.offer(currNode.right);
            }
            if(currNode.left != null){
                q.offer(currNode.left);
            }
            prev = currNode;
        }
        return rst;
    }


}
