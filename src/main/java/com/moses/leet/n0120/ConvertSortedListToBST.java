package com.moses.leet.n0120;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.pojo.TreeNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while(head!= null){
            list.add(head.val);
            head = head.next;
        }

        return recursive(list, 0, list.size()-1);
    }

    private TreeNode recursive(List<Integer> list, int start, int end) {
        if(end<start){
            return null;
        }else if(end == start){
            return new TreeNode(list.get(start));
        }
        int middle = start + (end-start)/2;
        TreeNode node = new TreeNode(list.get(middle));
        node.left = recursive(list, start, middle-1);
        node.right = recursive(list, middle+1, end);
        return node;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.fromIntegers(-10, -3, 0, 5, 9);
        TreeNode node = new ConvertSortedListToBST().sortedListToBST(head);
        PrintUtil.printTreeNodes(node);
    }
}
