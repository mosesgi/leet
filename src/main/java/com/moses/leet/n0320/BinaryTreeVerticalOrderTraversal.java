package com.moses.leet.n0320;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Element> q = new LinkedList<>();
        q.offer(new Element(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Element el = q.poll();
                map.putIfAbsent(el.col, new ArrayList<>());
                map.get(el.col).add(el.node.val);
                if(el.node.left != null){
                    q.offer(new Element(el.node.left, el.col-1));
                }
                if(el.node.right != null){
                    q.offer(new Element(el.node.right, el.col+1));
                }
            }
        }
        for(int key : map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }

    class Element{
        TreeNode node;
        int col;

        public Element(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }
}
