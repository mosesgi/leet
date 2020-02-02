package com.moses.leet.n0160;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        recursive(root, list);
        return list;
    }

    private void recursive(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        recursive(node.left, list);
        recursive(node.right, list);
        list.add(node.val);
    }


}
