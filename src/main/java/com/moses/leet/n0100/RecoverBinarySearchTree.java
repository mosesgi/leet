package com.moses.leet.n0100;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {
    //https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
    public void recoverTree(TreeNode root) {
        //3,2,1
        //1,3,2,4
        List<TreeNode> l = new ArrayList<>();
        inorder(root, l);
        TreeNode first = null, second = null;

        for(int i=0; i<l.size()-1; i++){
            if(l.get(i).val > l.get(i+1).val){
                if(first==null){
                    first = l.get(i);
                    second = l.get(i+1);
                }else{
                    second = l.get(i+1);
                }
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    void inorder(TreeNode root, List<TreeNode> l){
        if(root == null){
            return;
        }
        inorder(root.left, l);
        l.add(root);
        inorder(root.right, l);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        TreeNode curr = root.left;
        curr.right = new TreeNode(2);
        new RecoverBinarySearchTree().recoverTree(root);
        PrintUtil.printTreeNodes(root);

        root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        new RecoverBinarySearchTree().recoverTree(root);
        PrintUtil.printTreeNodes(root);

    }
}
