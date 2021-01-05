package com.moses.leet.n0240;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;

public class PalindromeLinkedList {
    //1,2,3,4,5
    //1,2,3,4
    //1
    //1,2
    public boolean isPalindrome(ListNode head) {
        if(head== null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        slow = cur;
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode right = prev, left = head;
        while(right != null){
            if(right.val != left.val){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        //1,2,3,2,1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow.next;
        slow.next = null;
        slow = cur;
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            if(next != null) {
                slow = next;
            }else{
                break;
            }
        }

        ListNode left = head;
        while(left != null){
            if(left.val != slow.val){
                return false;
            }
            left = left.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head;
        head = ListNodeUtil.fromIntegers(1,2,2,1);
        System.out.println(new PalindromeLinkedList().isPalindrome(head));

        head = ListNodeUtil.fromIntegers(1,2,3,3,2,1);
        System.out.println(new PalindromeLinkedList().isPalindrome(head));

    }


    public boolean isPalindromeOld(ListNode head){
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



}
