package com.moses.leet.multithread;

import java.util.concurrent.Semaphore;

// 多线程打印奇偶数
public class PrintEvenOdd {
    static volatile int curr = 1;
    static Semaphore so = new Semaphore(1);
    static Semaphore se = new Semaphore(0);
    static int limit = 30;

    public static void main(String[] args) {
        Thread odd = new Thread(()->{
            while(true) {
                try {
                    so.acquire();
                    if (curr > limit) {
                        return;
                    }
                    System.out.print(curr + ",");
                    curr++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    se.release();
                }
            }
        });

        Thread even = new Thread(() -> {
            while(true) {
                try {
                    se.acquire();
                    if (curr > limit) {
                        return;
                    }
                    System.out.print(curr+ ",");
                    curr++;
                } catch (Exception e) {

                } finally {
                    so.release();
                }
            }
        });
        odd.start();
        even.start();
    }
}
