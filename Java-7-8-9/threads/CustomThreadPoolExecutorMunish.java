package com.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutorMunish {
	private final BlockingQueue<Runnable> workerQueue;
	private final Thread[] workerThreads;

	public CustomThreadPoolExecutorMunish(int numThreads) {
		workerQueue = new LinkedBlockingQueue<>();
		workerThreads = new Thread[numThreads];
		int i = 0;
		for (Thread t : workerThreads) {
			t = new Worker("Custom Pool Thread " + ++i);
			t.start();

		}
	}

	public void addTask(Runnable r) {
		try {
			workerQueue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	class Worker extends Thread {
		public Worker(String name) {
			super(name);
		}

		public void run() {
			while (true) {
				try {
					workerQueue.take().run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		CustomThreadPoolExecutorMunish threadPoolExecutor = new CustomThreadPoolExecutorMunish(10);
		threadPoolExecutor.addTask(() -> System.out.println("First print task"));
		threadPoolExecutor.addTask(() -> System.out.println("Second print task"));
		threadPoolExecutor.addTask(() -> System.out.println("Third print task"));
	}

}

