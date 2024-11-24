package com.threads;


/*In this custom thread pool executor:

CustomThreadPoolExecutor takes the pool size and the size of the task queue as parameters. It creates an array of worker threads and initializes them.

execute method is used to submit a Runnable task to the thread pool. It adds the task to the task queue.

shutdown method is used to shut down the thread pool. It sets the shutdown flag and interrupts all worker threads.

WorkerThread is an inner class representing the worker threads. These threads continuously take tasks from the task queue and execute them until the thread pool is shut down.

In the main method, we create an instance of CustomThreadPoolExecutor, submit 20 tasks to it, and then shut down the thread pool when done.

This is a basic implementation of a thread pool executor, and it can be extended and customized further to meet specific requirements, such as handling exceptions, returning results from tasks, and more.




User
implement LinkedBlockingQueue in java
ChatGPT
LinkedBlockingQueue is a thread-safe, bounded blocking queue provided by the Java standard library. You can use it to implement a queue where multiple threads can safely produce and consume elements. Here's a simple implementation of a LinkedBlockingQueue in Java:

java
Copy code
*/

import java.util.LinkedList;
import java.util.Queue;


/*In this custom LinkedBlockingQueue implementation:

We use a Queue (specifically, a LinkedList) to store elements.
The capacity parameter determines the maximum number of elements the queue can hold.
The put method is used by producers to add elements to the queue. If the queue is full, it waits until there's space.
The take method is used by consumers to retrieve elements from the queue. If the queue is empty, it waits until there are elements to consume.
We use synchronized blocks to ensure thread safety. The wait method is called when a condition is not met, and notifyAll is called to wake up waiting threads when conditions change.
The size method returns the current size of the queue.
Here's an example of how to use this custom LinkedBlockingQueue:

java
Copy code*/
public class LinkedBlockingQueueExample {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int element = queue.take();
                    System.out.println("Consumed: " + element);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}







 class LinkedBlockingQueue<E> {
    private final Queue<E> queue;
    private final int capacity;

    public LinkedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(E element) throws InterruptedException {
        while (queue.size() == capacity) {
            // Wait if the queue is full
            wait();
        }
        queue.add(element);
        notifyAll(); // Notify waiting consumers that an element is added
    }

    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()) {
            // Wait if the queue is empty
            wait();
        }
        E element = queue.poll();
        notifyAll(); // Notify waiting producers that an element is removed
        return element;
    }

    public synchronized int size() {
        return queue.size();
    }
}