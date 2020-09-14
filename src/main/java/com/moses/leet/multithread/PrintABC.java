package com.moses.leet.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//代码实现控制三个线程打印出ABCABC…ABC(10次)

public class PrintABC {
    static ReentrantLock lock = new ReentrantLock();
    static Condition ca = lock.newCondition();
    static Condition cb = lock.newCondition();
    static Condition cc = lock.newCondition();
    static volatile int curr=1;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(){
            public void run(){
                while(true) {
                    lock.lock();
                    if(curr%3!=1){
                        try {
                            ca.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(curr > 30){
                        cb.signal();
                        lock.unlock();
                        return;
                    }
                    System.out.print("A");
                    curr++;
                    cb.signal();
                    lock.unlock();
                }
            }
        };

        Thread b = new Thread(){
            public void run(){
                while(true) {
                    lock.lock();
                    if(curr%3!=2){
                        try {
                            cb.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(curr > 30){
                        cc.signal();
                        lock.unlock();
                        return;
                    }
                    System.out.print("B");
                    curr++;
                    cc.signal();
                    lock.unlock();
                }
            }
        };

        Thread c = new Thread(){
            public void run(){
                while(true) {
                    lock.lock();
                    if(curr%3!=0){
                        try {
                            cc.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(curr > 30){
                        ca.signal();
                        lock.unlock();
                        return;
                    }
                    System.out.print("C");
                    curr++;
                    ca.signal();
                    lock.unlock();
                }
            }
        };
        a.start();
        b.start();
        c.start();
    }
}
