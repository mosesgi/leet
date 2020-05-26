package com.moses.leet.n1120;

public class PrintInOrder {
    class Foo {
        boolean firstFinished = false, secondFinished = false;
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (this) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                firstFinished = true;
                notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (this){
                while(!firstFinished){
                    this.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                secondFinished = true;
                notifyAll();
            }


        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (this){
                while(!firstFinished && !secondFinished){
                    this.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            }

        }
    }
}
