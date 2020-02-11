package com.moses.leet.n0200;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
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
