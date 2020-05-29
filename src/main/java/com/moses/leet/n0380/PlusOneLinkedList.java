package com.moses.leet.n0380;

import com.moses.leet.pojo.ListNode;

import java.util.Stack;

/**
 *
 Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.

 Example :

 Input: [1,2,3]
 Output: [1,2,4]
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        int carry = 1;
        while(carry != 0) {
            if(stack.isEmpty()){
                ListNode newHead = new ListNode(carry);
                carry = 0;
                newHead.next = head;
                head = newHead;
            }else {
                ListNode last = stack.pop();
                int tmp = last.val + carry;
                if (tmp == 10) {
                    last.val = 0;
                    carry = 1;
                }else{
                    last.val = tmp;
                    carry = 0;
                }
            }
        }
        return head;
    }
}
