package com.moses.leet.lcci;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 *
 *
 * 限制：
 *
 *     1 <= n <= 10^5
 *     1 <= m <= 10^6
 */
public class LastNumberInCycleLCOF {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemainingTLE(int n, int m) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        for(int i=0; i<n; i++){
            l.add(i);
        }
        int res = -1;
        int cnt = 0;
        while(!l.isEmpty()){
            cnt++;
            if(m%l.size()==0){
                res = l.pollLast();
                cnt = 0;
            }else if(cnt == m%l.size()){
                res = l.pollFirst();
                cnt = 0;
            }else{
                l.addLast(l.pollFirst());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LastNumberInCycleLCOF().lastRemaining(5,3));
        System.out.println(new LastNumberInCycleLCOF().lastRemaining(70866, 116922));
    }


}
