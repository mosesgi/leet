package com.moses.leet.n0520;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            while(q.peek() != null){
                TreeNode cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                max = Math.max(max, cur.val);
            }
            rst.add(max);
            if(q.size() == 1){      //only null left
                break;
            }
            q.offer(q.poll());
        }

        return rst;
    }
}
