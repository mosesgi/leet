package com.moses.leet.n0120;

import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBTreeFromInAndPostOrderTraversal {
    Map<Integer, Integer> inPosMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length || inorder.length == 0){
            return null;
        }
        if(inorder.length == 1){
            return new TreeNode(inorder[0]);
        }

        for(int i=0; i<inorder.length; i++){
            inPosMap.put(inorder[i], i);
        }

        return recursive(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode recursive(int[] inorder, int inBegin, int inEnd, int[] postorder, int poBegin, int poEnd) {
        if(poEnd-poBegin < 0){
            return null;
        }

        TreeNode root = new TreeNode(postorder[poEnd]);
        int inPos = inPosMap.get(postorder[poEnd]);
        int rightLen = inEnd - inPos;

        root.right = recursive(inorder, inPos+1, inEnd, postorder, poEnd - rightLen, poEnd-1);
        root.left = recursive(inorder, inBegin, inPos-1, postorder, poBegin, poEnd-rightLen-1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        PrintUtil.printTreeNodes(new ConstructBTreeFromInAndPostOrderTraversal().buildTree(inorder, postorder));


        inorder = new int[]{1,2,16,6,5,4,9,3,8,15,20,12,10,13,7,11};
        postorder = new int[]{1,16,2,4,5,6,9,8,15,12,13,10,11,7,20,3};
        PrintUtil.printTreeNodes(new ConstructBTreeFromInAndPostOrderTraversal().buildTree(inorder, postorder));
    }

}
