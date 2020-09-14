package com.moses.leet.n1120;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {

    class ZeroEvenOdd {
        private int n;
        AtomicInteger ai = new AtomicInteger(1);
        Semaphore zero = new Semaphore(1);
        Semaphore even = new Semaphore(0);
        Semaphore odd = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(int i=0; i<n; i++){
                zero.acquire();
                printNumber.accept(0);
                if(ai.get() % 2 == 1) {
                    odd.release();
                }else{
                    even.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i=2; i<=n; i+=2){
                even.acquire();
                printNumber.accept(ai.getAndIncrement());
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i=1; i<=n; i+=2){
                odd.acquire();
                printNumber.accept(ai.getAndIncrement());
                zero.release();
            }
        }
    }

    public static void main(String[] args) {
        PrintZeroEvenOdd pzeo = new PrintZeroEvenOdd();
        ZeroEvenOdd zeo = pzeo.new ZeroEvenOdd(2);
        Thread t1 = new Thread(() -> {
            try {
                zeo.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeo.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeo.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

//    class ZeroEvenOdd {
//        private int n;
//        volatile int x=1;
//        volatile boolean zeroPrinted = false;
//
//        public ZeroEvenOdd(int n) {
//            this.n = n;
//        }
//
//        // printNumber.accept(x) outputs "x", where x is an integer.
//        public void zero(IntConsumer printNumber) throws InterruptedException {
//            while(x<=n){
//                synchronized (this){
//                    if(zeroPrinted){
//                        this.wait();
//                    }else {
//                        printNumber.accept(0);
//                        zeroPrinted = true;
//                        this.notifyAll();
//                    }
//                }
//            }
//        }
//
//        public void even(IntConsumer printNumber) throws InterruptedException {
//            while(x<=n){
//                synchronized (this){
//                    if(!zeroPrinted || x%2==1){
//                        this.wait();
//                    }else {
//                        printNumber.accept(x++);
//                        zeroPrinted = false;
//                        this.notifyAll();
//                    }
//                }
//            }
//        }
//
//        public void odd(IntConsumer printNumber) throws InterruptedException {
//            while(x<=n){
//                synchronized (this){
//                    if(!zeroPrinted || x%2==0){
//                        this.wait();
//                    }else{
//                        printNumber.accept(x++);
//                        zeroPrinted = false;
//                        this.notifyAll();
//                    }
//                }
//            }
//        }
//    }
}
