package com.moses.leet.n0460;

import com.moses.leet.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();
        while(l1!= null){
            list1.add(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            list2.add(l2);
            l2 = l2.next;
        }

        int max = Math.max(list1.size(), list2.size());
        List<Integer> rst = new ArrayList<>();
        int cur1 = list1.size()-1;
        int cur2 = list2.size()-1;
        int carry = 0;
        while(cur1>=0 && cur2>=0){
            int tmp = list1.get(cur1).val + list2.get(cur2).val + carry;
            carry = tmp/10;
            rst.add(0, tmp%10);
            cur1--;cur2--;
        }
        while(cur1 >= 0){
            int tmp = list1.get(cur1).val + carry;
            carry = tmp/10;
            rst.add(0, tmp%10);
            cur1--;
        }
        while(cur2 >=0){
            int tmp = list2.get(cur2).val + carry;
            carry = tmp/10;
            rst.add(0, tmp%10);
            cur2--;
        }
        if(carry != 0){
            rst.add(0, carry);
        }

        ListNode head = new ListNode(rst.get(0));
        ListNode curr = head;
        for(int i=1; i<rst.size(); i++){
            curr.next = new ListNode(rst.get(i));
            curr = curr.next;
        }
        return head;
    }
}
