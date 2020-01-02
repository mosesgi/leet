package com.moses.leet;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

import java.util.Stack;

public class ReverseNodesKGroup {

    public ListNode reverseKGroup(ListNode head, int k){
        ListNode currNode = head;
        int curr = 1;
        Stack<ListNode> stack = new Stack<>();
        ListNode prevEndNode = null;

        while(currNode != null){
            stack.push(currNode);

            if(curr%k == 0){
                ListNode nextNode = currNode.next;
                ListNode firstNode = stack.pop();
                if(curr == k){
                    head = firstNode;
                }
                if(prevEndNode != null){
                    prevEndNode.next = firstNode;
                }
                while(!stack.isEmpty()){
                    firstNode.next = stack.pop();
                    firstNode = firstNode.next;
                }
                firstNode.next = nextNode;
                currNode = firstNode;
                prevEndNode = currNode;
            }

            currNode = currNode.next;
            curr++;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode node = ListNodeUtil.fromIntegers(1, 2, 3, 4, 5);
        PrintUtil.traverseNodes(new ReverseNodesKGroup().reverseKGroup(node, 3));
        PrintUtil.traverseNodes(new ReverseNodesKGroup().reverseKGroup(node, 2));
    }
}
