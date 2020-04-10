package com.moses.leet.n0740;

import com.moses.leet.pojo.ListNode;
import com.moses.leet.utils.ListNodeUtil;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null){
            return new ListNode[k];
        }
        int len = 1;
        ListNode cur = root;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }

        int[] size = new int[k];
        if(k>=len){
            for(int i=0; i<len; i++){
                size[i] = 1;
            }
        }else{
            int remain = len%k;
            int avg = len/k;
            for(int i=0; i<k; i++){
                size[i] = avg;
            }
            for(int i=0; i<remain; i++){
                size[i] = size[i]+1;
            }
        }

        cur = root;
        ListNode prev = null;
        ListNode[] rst = new ListNode[k];
        rst[0] = root;
        int cnt = 0;
        int idx = 0;
        while(cur.next!=null){
            cnt++;
            prev = cur;
            cur = cur.next;
            if(cnt == size[idx]){
                idx++;
                cnt = 0;
                prev.next = null;
                if(idx < rst.length) {
                    rst[idx] = cur;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        ListNode root = null;
        root = ListNodeUtil.fromIntegers(1,2,3,4);
        new SplitLinkedListInParts().splitListToParts(root, 5);

        root = ListNodeUtil.fromIntegers(1,2,3,4,5,6,7,8,9,10);
        new SplitLinkedListInParts().splitListToParts(root, 3);
    }
}
