package com.moses.leet.multithread;

import java.util.concurrent.Semaphore;

//线程1先打印1，2，3，4，5，线程2打印6，7，8，9，10，线程3打印11，12，13，14，15。
// 接着再由线程1打印16，17，18，19，20，以此类推，直到打印到75
public class PrintFives {
    static volatile int curr = 1;
    static Semaphore s1 = new Semaphore(1);
    static Semaphore s2 = new Semaphore(0);
    static Semaphore s3 = new Semaphore(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while(true){
                try {
                    s1.acquire();
                    if(curr > 75){
                        return;
                    }
                    for(int i=0; i<5; i++){
                        System.out.print(curr + ",");
                        curr++;
                    }
                }catch (Exception e){

                }finally {
                    s2.release();
                }
            }
        });

        Thread t2 = new Thread(()->{
            while(true){
                try {
                    s2.acquire();
                    if(curr > 75){
                        return;
                    }
                    for(int i=0; i<5; i++){
                        System.out.print(curr + ",");
                        curr++;
                    }
                }catch (Exception e){

                }finally {
                    s3.release();
                }
            }
        });

        Thread t3 = new Thread(()->{
            while(true){
                try {
                    s3.acquire();
                    if(curr > 75){
                        return;
                    }
                    for(int i=0; i<5; i++){
                        System.out.print(curr + ",");
                        curr++;
                    }
                }catch (Exception e){

                }finally {
                    s1.release();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
