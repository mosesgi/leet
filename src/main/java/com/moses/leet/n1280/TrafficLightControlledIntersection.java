package com.moses.leet.n1280;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class TrafficLightControlledIntersection {
    class TrafficLight {
        Semaphore sm;
        volatile int green = 1;
        public TrafficLight() {
            sm = new Semaphore(1);
        }

        public void carArrived(
                int carId,           // ID of the car
                int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
                int direction,       // Direction of the car
                Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
                Runnable crossCar    // Use crossCar.run() to make car cross the intersection
        ) {
            try{
                sm.acquire();
                if(green == roadId){
                    crossCar.run();
                }else{
                    turnGreen.run();
                    green = roadId;
                    crossCar.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                sm.release();
            }
        }
    }

}
