package com.threads;


import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThreadPoolExecutorChatGPT {
    private final int poolSize;
    /**
     * A {@link Queue} that additionally supports operations that wait for
     * the queue to become non-empty when retrieving an element, and wait
     * for space to become available in the queue when storing an element.
     */
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] threads;
    private final AtomicBoolean shutdown = new AtomicBoolean(false);

    public CustomThreadPoolExecutorChatGPT(int poolSize, int taskQueueSize) {
        this.poolSize = poolSize;
        this.taskQueue = new LinkedBlockingQueueExample<>(taskQueueSize);
        this.threads = new Thread[poolSize];

        for (int i = 0; i < poolSize; i++) {
            threads[i] = new WorkerThread();
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        if (shutdown.get()) {
            throw new IllegalStateException("ThreadPool is already shutdown");
        }

        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        shutdown.set(true);
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private class WorkerThread extends Thread {
        public void run() {
            while (!shutdown.get()) {
                try {
                    Runnable task = taskQueue.poll(10, TimeUnit.SECONDS);
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomThreadPoolExecutorChatGPT threadPool = new CustomThreadPoolExecutorChatGPT(4, 10);

        // Submit tasks to the thread pool
        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskId + " is executed by " + Thread.currentThread().getName());
            });
        }

        // Shutdown the thread pool when done
        threadPool.shutdown();
    }
}
