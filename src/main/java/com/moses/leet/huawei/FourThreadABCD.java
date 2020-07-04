package com.moses.leet.huawei;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class FourThreadABCD {
    static AtomicInteger status = new AtomicInteger(0);
    static Semaphore sema = new Semaphore(1);
    static CountDownLatch latch;
    static volatile int targetRound;
    static AtomicInteger rounds;
    static int[][] statuses = new int[][]{
            {0, 1}, {1,2}, {2,3}, {3, 0}
    };

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            targetRound = scan.nextInt();
            rounds = new AtomicInteger(1);
            latch = new CountDownLatch(4);

            new Thread(new PrintThread('A')).start();
            new Thread(new PrintThread('B')).start();
            new Thread(new PrintThread('C')).start();
            new Thread(new PrintThread('D')).start();
            latch.await();
        }
    }

    static class PrintThread implements Runnable{
        private char str;
        public PrintThread(char str){
            this.str = str;
        }

        @Override
        public void run() {
            while(true){
                try {
                    sema.acquire();
                    int[] change = statuses[str-'A'];
                    if(status.compareAndSet(change[0], change[1])) {
                        System.out.print(str);
                        if(rounds.get() == targetRound){
                            if(str == 'D'){
                                System.out.println();
                            }
                            latch.countDown();
                            break;
                        }else if(str == 'D'){
                            rounds.incrementAndGet();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    sema.release();
                }
            }
        }
    }

}
