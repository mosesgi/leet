package com.moses.leet.n1200;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {
    class FizzBuzz {
        private int n;
        private volatile int val;

        public FizzBuzz(int n) {
            this.n = n;
            val = 1;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while(val <= n){
                synchronized (this){
                    if(val <=n && val%3==0 && val%5!=0){
                        printFizz.run();
                        val++;
                    }
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while(val <= n){
                synchronized (this){
                    if(val <=n && val%3!=0 && val%5==0){
                        printBuzz.run();
                        val++;
                    }
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while(val <=n ) {
                synchronized (this) {
                    if (val <=n && val % 3 == 0 && val % 5 == 0) {
                        printFizzBuzz.run();
                        val++;
                    }
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while(val <= n){
                synchronized (this){
                    if(val <=n && val%3!=0 && val%5!=0) {
                        printNumber.accept(val);
                        val++;
                    }
                }
            }
        }
    }
}
