package com.moses.leet.n1120;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintInOrder {


    class Foo {
        ReentrantLock lock = new ReentrantLock();
        Condition second = lock.newCondition();
        Condition third = lock.newCondition();

        volatile int flag = 1;

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            printFirst.run();
            flag = 2;
            second.signal();

            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            if(flag != 2) {
                second.await();
            }
            printSecond.run();
            flag = 3;
            third.signal();

            lock.unlock();
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            if(flag != 3) {
                third.await();
            }
            printThird.run();
            lock.unlock();
        }
    }

//    class Foo {
//        AtomicInteger ai = new AtomicInteger(0);
//        boolean firstFinished = false, secondFinished = false;
//        public Foo() {
//
//        }
//
//        public void first(Runnable printFirst) throws InterruptedException {
//            while(true) {
//                if (ai.compareAndSet(0, 10)) {
//                    // printFirst.run() outputs "first". Do not change or remove this line.
//                    printFirst.run();
//                    ai.compareAndSet(10, 1);
//                    break;
//                }
//            }
////            synchronized (this) {
////                firstFinished = true;
////                notifyAll();
////            }
//        }
//
//        public void second(Runnable printSecond) throws InterruptedException {
//            while(true) {
//                if (ai.compareAndSet(1, 10)) {
//                    // printSecond.run() outputs "second". Do not change or remove this line.
//                    printSecond.run();
//                    ai.compareAndSet(10, 2);
//                    break;
//                }
//            }
//
////            synchronized (this){
////                while(!firstFinished){
////                    this.wait();
////                }
////                // printSecond.run() outputs "second". Do not change or remove this line.
////                printSecond.run();
////                secondFinished = true;
////                notifyAll();
////            }
//        }
//
//        public void third(Runnable printThird) throws InterruptedException {
//            while(true) {
//                if (ai.compareAndSet(2, 10)) {
//                    // printThird.run() outputs "third". Do not change or remove this line.
//                    printThird.run();
//                    ai.compareAndSet(10, 3);
//                    break;
//                }
//            }
//
////            synchronized (this){
////                while(!firstFinished && !secondFinished){
////                    this.wait();
////                }
////                // printThird.run() outputs "third". Do not change or remove this line.
////                printThird.run();
////            }
//
//        }
//    }
}
