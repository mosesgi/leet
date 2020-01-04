package com.moses.leet.n0020;

import com.moses.leet.pojo.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode resultCurr = null;
        int carry = 0;
        int index = 0;
        do{
            int a1 = curr1==null?0:curr1.val;
            int a2 = curr2==null?0:curr2.val;

            int r = a1 + a2 + carry;
            carry = r/10;
            r = r - carry*10;
            if(index == 0){
                result = new ListNode(r);
                resultCurr = result;
            } else {
                resultCurr.next = new ListNode(r);
                resultCurr = resultCurr.next;
            }
            curr1 = curr1==null?null:curr1.next;
            curr2 = curr2==null?null:curr2.next;
            index++;
        } while(curr1 != null || curr2 != null || carry > 0);

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        ListNode curr1 = l1;
        curr1.next = new ListNode(3);
        curr1 = l1.next;
        curr1.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        ListNode curr2 = l2;
        l2.next = new ListNode(2);
        curr2 = l2.next;
        curr2.next = new ListNode(8);

        ListNode l3 = new AddTwoNumbers().addTwoNumbers(l1, l2);

        while(l3 != null){
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }
}

