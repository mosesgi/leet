package com.moses.leet.n1120;

import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {
    class ZeroEvenOdd {
        private int n;
        volatile int x=1;
        volatile boolean zeroPrinted = false;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while(x<=n){
                synchronized (this){
                    if(zeroPrinted){
                        this.wait();
                    }else {
                        printNumber.accept(0);
                        zeroPrinted = true;
                        this.notifyAll();
                    }
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while(x<=n){
                synchronized (this){
                    if(!zeroPrinted || x%2==1){
                        this.wait();
                    }else {
                        printNumber.accept(x++);
                        zeroPrinted = false;
                        this.notifyAll();
                    }
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while(x<=n){
                synchronized (this){
                    if(!zeroPrinted || x%2==0){
                        this.wait();
                    }else{
                        printNumber.accept(x++);
                        zeroPrinted = false;
                        this.notifyAll();
                    }
                }
            }
        }
    }
}
