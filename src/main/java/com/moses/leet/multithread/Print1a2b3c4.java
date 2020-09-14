package com.moses.leet.multithread;

import java.util.concurrent.Semaphore;

//a = [1,2,3,4]; b = [‘a’,‘b’,‘c’];交替打印1a2b3c4
public class Print1a2b3c4 {
    static int[] a = new int[]{1,2,3,4};
    static char[] b = new char[]{'a','b','c'};
    static int aPos = 0;
    static int bPos = 0;
    static int times = 300;
    static volatile int curr = 1;
    static Semaphore sa = new Semaphore(1);
    static Semaphore sb = new Semaphore(0);

    public static void main(String[] args) {
        Thread ta = new Thread(() -> {
            while(true) {
                try {
                    sa.acquire();
                    if (curr > times) {
                        return;
                    }
                    System.out.print(a[aPos % a.length]);
                    aPos++;
                    curr++;
                } catch (Exception e) {

                } finally {
                    sb.release();
                }
            }
        });

        Thread tb = new Thread(() -> {
            while(true) {
                try {
                    sb.acquire();
                    if (curr > times) {
                        return;
                    }
                    System.out.print(b[bPos % b.length]);
                    bPos++;
                    curr++;
                } catch (Exception e) {

                } finally {
                    sa.release();
                }
            }
        });

        ta.start();
        tb.start();
    }
}
