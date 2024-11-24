package com.threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class TimeSpreadExample {
    public static void main(String[] args) {
        AtomicBoolean shouldRun = new AtomicBoolean(true);
        
        Thread taskThread = new Thread(() -> {
            while (shouldRun.get()) {
                // Perform your task here
                System.out.println("Task is running...");
                
                try {
                    Thread.sleep(1000); // Sleep for 1 second (adjust as needed)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        taskThread.start();
        
        // Sleep for 5 seconds (adjust as needed)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // After 5 seconds, stop the task
        shouldRun.set(false);
        
        try {
            taskThread.join(); // Wait for the task thread to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Task stopped.");
    }
}

