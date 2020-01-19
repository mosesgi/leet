package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBTreeFromPreAndInOrderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            return null;
        }
        if(preorder.length == 0){
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int inOrderPos = -1;
        for(int i=0; i<inorder.length; i++){        //cache the position in Map will reduce time significantly.
            if(inorder[i] == preorder[0]){
                inOrderPos = i;
                break;
            }
        }
        int leftLen = inOrderPos;
        recursive(root, preorder, inorder, 1, leftLen, 0, inOrderPos-1, true);
        recursive(root, preorder, inorder, leftLen+1, preorder.length-1, inOrderPos+1, inorder.length-1, false);
        return root;
    }

    private void recursive(TreeNode root, int[] preOrder, int[] inOrder, int preBegin, int preEnd, int inBegin, int inEnd, boolean isLeft){
        if(inEnd >= inBegin){
            TreeNode currNode = new TreeNode(preOrder[preBegin]);
            if(isLeft){
                root.left = currNode;
            } else {
                root.right = currNode;
            }
            int inOrderPos = -1;
            for(int i=inBegin; i<=inEnd; i++){
                if(inOrder[i] == preOrder[preBegin]){
                    inOrderPos = i;
                    break;
                }
            }
            int leftLen = inOrderPos-inBegin;
            recursive(currNode, preOrder, inOrder, preBegin+1, preBegin + leftLen, inBegin, inOrderPos-1, true);
            recursive(currNode, preOrder, inOrder, preBegin+leftLen+1, preEnd, inOrderPos+1, inEnd, false);
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        PrintUtil.printTreeNodes(new ConstructBTreeFromPreAndInOrderTraversal().buildTree(pre, in));


        pre = new int[]{3,9,6,2,1,5,4,20,15,8,7,10,12,13,11};
        in = new int[]{1,2,6,5,4,9,3,8,15,20,12,10,13,7,11};
        PrintUtil.printTreeNodes(new ConstructBTreeFromPreAndInOrderTraversal().buildTree(pre, in));

    }
}
