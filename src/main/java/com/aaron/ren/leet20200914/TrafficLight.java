package com.aaron.ren.leet20200914;

import java.util.concurrent.Semaphore;

class TrafficLight {

    private Semaphore semaphore;
    public TrafficLight() {
        semaphore=new Semaphore(1);
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) throws InterruptedException {
        semaphore.acquire();
        turnGreen.run();
        crossCar.run();
        semaphore.release();

    }
}