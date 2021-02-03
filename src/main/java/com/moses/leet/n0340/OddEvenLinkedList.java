package com.moses.leet.n0340;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;
import com.moses.leet.utils.PrintUtil;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        int idx = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);

        ListNode cur = dummy;
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        while(cur.next != null){
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
            idx++;
            if(idx%2==0){
                even.next = cur;
                even = even.next;
            } else {
                odd.next = cur;
                odd = odd.next;
            }
        }
        odd.next = evenDummy.next;
        return oddDummy.next;
    }


    public ListNode oddEvenList1(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = null;
        ListNode evenStart = null;

        ListNode curr = head;

        int count = 1;
        while(curr != null){
            if(count == 1){
                curr = curr.next;
                count++;
                continue;
            }
            if(count == 2){
                evenStart = curr;
                even = curr;
                curr = curr.next;
                count++;
                continue;
            }
            if(count % 2 == 1){
                odd.next = curr;
                odd = curr;
            } else if(count % 2 == 0){
                even.next = curr;
                even = curr;
            }

            curr = curr.next;
            count++;
        }

        odd.next = evenStart;
        if(even != null) {
            even.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head;
        head = ListNodeUtil.fromIntegers(1,2);
        PrintUtil.traverseNodes(new OddEvenLinkedList().oddEvenList(head));

        head = ListNodeUtil.fromIntegers(1,2,3,4,5);
        PrintUtil.traverseNodes(new OddEvenLinkedList().oddEvenList(head));

        head = ListNodeUtil.fromIntegers(2,1,3,5,6,4,7);
        PrintUtil.traverseNodes(new OddEvenLinkedList().oddEvenList(head));
    }
}
