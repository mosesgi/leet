package com.moses.leet.n1120;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//1115 https://leetcode-cn.com/problems/print-foobar-alternately/

public class PrintFoobarAlternately {
    class FooBar {
        private int n;

        ReentrantLock lock = new ReentrantLock();
        Condition foo = lock.newCondition();
        Condition bar = lock.newCondition();
        volatile int flag = 1;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                if(flag == 2){
                    foo.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 2;
                bar.signal();

                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                if(flag == 1){
                    bar.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 1;
                foo.signal();

                lock.unlock();
            }
        }
    }
}
