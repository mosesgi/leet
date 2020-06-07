package com.moses.leet.n1240;

import java.util.concurrent.locks.ReentrantLock;

public class TheDiningPhilosophers {
    class DiningPhilosophers {
        private final ReentrantLock[] forks = new ReentrantLock[]{
                new ReentrantLock(),
                new ReentrantLock(),
                new ReentrantLock(),
                new ReentrantLock(),
                new ReentrantLock()
        };

        private ReentrantLock pickBothForks = new ReentrantLock();

        public DiningPhilosophers() {

        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            int left = (philosopher+1)%5;
            int right = philosopher;

            pickBothForks.lock();

            forks[left].lock();
            forks[right].lock();
            pickLeftFork.run();
            pickRightFork.run();

            eat.run();

            putLeftFork.run();
            putRightFork.run();
            forks[left].unlock();
            forks[right].unlock();

            pickBothForks.unlock();
        }
    }
}
