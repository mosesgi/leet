package com.moses.leet.n1000;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Element> l = new ArrayList<>();
        dfs(root, 0, 0, l);

        Collections.sort(l, (o1, o2) -> {
            if(o1.pos != o2.pos){
                return o1.pos - o2.pos;
            }else if(o1.level != o2.level){
                return o1.level - o2.level;
            }else{
                return o1.val - o2.val;
            }
        });
        List<Integer> list = new ArrayList<>();
        Integer pos = null;
        for(Element e : l){
            if(pos == null){
                pos = e.pos;
                list.add(e.val);
            }else if(e.pos == pos){
                list.add(e.val);
            }else{
                res.add(list);
                list = new ArrayList<>();
                list.add(e.val);
                pos = e.pos;
            }
        }
        res.add(list);
        return res;
    }

    void dfs(TreeNode root, int level, int pos, List<Element> l){
        if(root == null){
            return;
        }
        dfs(root.left, level+1, pos-1, l);
        dfs(root.right, level+1, pos+1, l);
        l.add(new Element(level, pos, root.val));
    }


    class Element{
        int level;
        int pos;
        int val;

        public Element(int level, int pos, int val){
            this.level = level;
            this.pos = pos;
            this.val = val;
        }
    }
}
