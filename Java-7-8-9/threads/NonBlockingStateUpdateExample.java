package com.threads;

import java.util.concurrent.atomic.AtomicReference;

/*
 * When multiple threads try to execute the compareAndSet (or CAS - Compare-And-Swap) operation concurrently, 
 * the behavior depends on the outcome of the operation. 
 * The CAS operation is typically used to atomically update a shared variable's value, and it works as follows:

The thread reads the current value of the shared variable.

The thread performs some computation or updates the value.

The thread attempts to set the new value back into the shared variable using the compareAndSet operation.

If the shared variable's value hasn't changed since the read in step 1, 
the compareAndSet operation succeeds, and the new value is set.

If the shared variable's value has changed between steps 1 and 3 (i.e., another thread has modified it), 
the compareAndSet operation fails, and the thread may need to retry the operation or take some other action.

When multiple threads concurrently call compareAndSet on the same shared variable, the following scenarios can occur:

One Thread Succeeds: One of the threads successfully updates the shared variable using compareAndSet,
 while the others may fail. The successful thread's update becomes the final value of the shared variable.

Contention: If multiple threads attempt to update the shared variable simultaneously,
 some of them may succeed while others fail. This situation is known as contention.

Retry: Threads that fail to update the shared variable in one attempt may need to retry the operation. 
They typically loop and repeat the CAS operation until they succeed. This is known as a spin-lock, and it can lead to
 high contention and performance issues if not carefully managed.

A-B-A Problem: There's also a potential issue known as the A-B-A problem. 
Suppose a thread reads the value "A," another thread changes it to "B," and then
 it gets changed back to "A" by a third thread before the first thread attempts to update it. In this case,
  the CAS operation may incorrectly succeed because it sees "A" as the current value, even though it changed in between.

To mitigate contention and the A-B-A problem, modern CPUs and 
synchronization libraries offer more advanced atomic operations and constructs, like Compare-And-Swap with 
version numbers (also known as CAS with ABA prevention), which provide better mechanisms for handling concurrent updates.

In summary, when multiple threads execute compareAndSet concurrently, some may succeed while 
others may fail. Careful handling and possibly retrying the operation are necessary to ensure that 
the shared variable's value is updated correctly and consistently in a multithreaded environment.
 */

class MyObject {
    private int var1;
    private int var2;

    public MyObject(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public int getVar1() {
        return var1;
    }

    public int getVar2() {
        return var2;
    }

    public void updateState(int newVar1, int newVar2) {
        var1 = newVar1;
        var2 = newVar2;
    }

    @Override
    public String toString() {
        return "MyObject [var1=" + var1 + ", var2=" + var2 + "]";
    }
}

public class NonBlockingStateUpdateExample {
    private static final AtomicReference<MyObject> sharedState = new AtomicReference<>();

    public static void main(String[] args) {
        // Initialize the shared state
        sharedState.set(new MyObject(0, 0));

        // Create multiple threads to update the state
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    MyObject current = sharedState.get();
                    MyObject updated = new MyObject(current.getVar1() + 1, current.getVar2() + 1);
                    
                    // Use CAS to update the shared state atomically
                    while (!sharedState.compareAndSet(current, updated)) {
                        current = sharedState.get();
                        updated = new MyObject(current.getVar1() + 1, current.getVar2() + 1);
                    }
                }
            });
            thread.start();
        }

        // Wait for all threads to finish
        try {
            Thread.sleep(2000); // Adjust as needed
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print the final shared state
        System.out.println("Final State: " + sharedState.get());
    }
}
