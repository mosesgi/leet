package com.moses.leet.n1200;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class DesignBoundedBlockingQueue {
    class BoundedBlockingQueue {
        BlockingQueue<Integer> q;
        public BoundedBlockingQueue(int capacity) {
            q = new LinkedBlockingDeque<>(capacity);
        }

        public void enqueue(int element) throws InterruptedException {
            q.put(element);
        }

        public int dequeue() throws InterruptedException {
            return q.take();
        }

        public int size() {
            return q.size();
        }
    }
}
