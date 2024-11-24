package com.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        // Create an ArrayBlockingQueue with a capacity of 3
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // Producer thread to add elements to the queue
        Thread producer = new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("Produced: 1");
                queue.put(2);
                System.out.println("Produced: 2");
                queue.put(3);
                System.out.println("Produced: 3");
                // Attempt to add one more element (blocking)
                queue.put(4);
                System.out.println("Produced: 4"); // This line won't be reached until a consumer removes an element
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread to remove elements from the queue
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000); // Sleep for 2 seconds to simulate processing time
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(2000);
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(2000);
                System.out.println("Consumed: " + queue.take());
                Thread.sleep(2000);
                System.out.println("Consumed: " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
