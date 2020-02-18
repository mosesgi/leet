package com.moses.leet.n0240;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head){
        if(head == null){
            return true;
        }
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        if(size == 1){
            return true;
        }
        boolean isOdd = size%2 == 1;
        int half = size/2;
        ListNode prev = null;
        curr = head;
        ListNode firstHalfEnd = null;
        ListNode secondHalfStart = null;
        int k = 0;
        while(curr != null){
            ListNode tmp = curr;
            curr = curr.next;
            k++;

            if(prev == null){
                prev = tmp;
                prev.next = null;
                if(k == half){
                    firstHalfEnd = tmp;
                    secondHalfStart = curr;
                    break;
                }
            } else {
                if(k<=half) {
                    tmp.next = prev;
                    prev = tmp;
                    if(k==half){
                        firstHalfEnd = tmp;
                        secondHalfStart = curr;
                        break;
                    }
                }
            }
        }
        if(isOdd){
            secondHalfStart = secondHalfStart.next;
        }

        while(firstHalfEnd != null){
            if(firstHalfEnd.val != secondHalfStart.val){
                return false;
            }
            firstHalfEnd = firstHalfEnd.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head;
        head = ListNodeUtil.fromIntegers(1, 2,1);
        System.out.println(new PalindromeLinkedList().isPalindrome(head));

        head = ListNodeUtil.fromIntegers(1,2,3,3,2,1);
        System.out.println(new PalindromeLinkedList().isPalindrome(head));

    }
}
