package com.moses.leet.n0240;

import com.moses.leet.pojo.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class LowestCommonAncestorOfBinaryTree {
    //  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65236/JavaPython-iterative-solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!(parent.containsKey(p) && parent.containsKey(q))){
            TreeNode cur = queue.poll();
            if(cur.left != null){
                parent.put(cur.left, cur);
                queue.offer(cur.left);
            }
            if(cur.right != null){
                parent.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode tmp = p;
        while(tmp != null){
            ancestors.add(tmp);
            tmp = parent.get(tmp);
        }

        while(!ancestors.contains(q)){
            q = parent.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, root, root.left));




        root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode rst = new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(rst == null? "null" : rst.val);

        rst = new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
        System.out.println(rst == null? "null" : rst.val);
    }


    public TreeNode lowestCommonAncestorOld(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pQueue = new LinkedList<>();
        Deque<TreeNode> qQueue = new LinkedList<>();
        TreeNode curr = root;

        dfs(curr, pQueue, p);
        dfs(curr, qQueue, q);

        TreeNode tmp = null;
        while(!pQueue.isEmpty() && !qQueue.isEmpty()){
            TreeNode pCur = pQueue.pollFirst();
            if(pCur == qQueue.pollFirst()){
                tmp = pCur;
            }
        }
        return tmp;
    }

    private boolean dfs(TreeNode curr, Deque<TreeNode> pQueue, TreeNode p) {
        if(curr == null){
            return false;
        }
        pQueue.offerLast(curr);
        if(curr.val == p.val){
            return true;
        }
        if(dfs(curr.left, pQueue, p)){
            return true;
        }
        if(dfs(curr.right, pQueue, p)){
            return true;
        }
        pQueue.pollLast();
        return false;
    }


}
