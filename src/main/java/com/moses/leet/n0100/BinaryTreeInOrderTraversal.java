package com.moses.leet.n0100;

import com.moses.leet.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode t = stack.pop();
            res.add(t.val);
            cur = t.right;
        }
        return res;
    }



    //Morris Traversal, without recursive. O(n)
    //1. 初始化当前节点 cur 为 root 节点.
    //2. 如果 cur 没有左孩子，则输出当前节点并将其右孩子作为当前节点,即 cur = cur->right。
    //3. 如果 cur 有左孩子，在当前节点 cur 的左子树中找到当前节点 cur 在中序遍历下的前驱节点。
    //      a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
    //      b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
    //4. 重复以上2、3直到当前节点为空。
    //
    //链接：https://www.jianshu.com/p/d2059062efac
    public List<Integer> morrisTraversal(TreeNode root){
        List<Integer> rst = new ArrayList<>();
        if(root == null){
            return rst;
        }
        TreeNode curr = root;
        TreeNode curr1 = null;
        while(curr != null){
            curr1 = curr.left;
            if(curr1 != null){
                while(curr1.right != null && curr1.right != curr){
                    curr1 = curr1.right;
                }
                if(curr1.right == null){
                    curr1.right = curr;
                    curr = curr.left;
                    continue;
                } else {
                    curr1.right = null;
                }
            }
            rst.add(curr.val);
            curr = curr.right;
        }

        return rst;
    }


    //Simple recursive
    public List<Integer> inorderTraversalOld(TreeNode root) {
        List<Integer> rst = new ArrayList<>();

        recursive(root, rst);
        return rst;
    }

    private void recursive(TreeNode root, List<Integer> rst) {
        if(root == null){
            return;
        }
        recursive(root.left,rst);
        rst.add(root.val);
        recursive(root.right, rst);
    }

    public static void main(String[] args) {

    }
}
