package com.thread.pattern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  生产者消费者模式
 *  共享一把锁：类似ArrayBlockingQueue
 */
public class ProducerAndConsumer {
    private static ReentrantLock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();
    private static Queue<Integer> queue = new LinkedList<>();
    private static int max = 8;
    private static class Producer implements Runnable {

        final ReentrantLock lock;
        private Queue<Integer> queue;

        Producer(ReentrantLock lock, Queue<Integer> queue) {
            this.lock = lock;
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == max) {
                        System.out.println("生产者" + Thread.currentThread().getName() + "等待, 队列已满");
                        notFull.await();
                    }
                    int newValue = new Random().nextInt(100);
                    System.out.println("生产者" + Thread.currentThread().getName() + "生产数据：" + newValue);
                    queue.offer(newValue);
                    notEmpty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class Consumer implements Runnable {

        final ReentrantLock lock;
        private Queue<Integer> queue;

        Consumer(ReentrantLock lock, Queue<Integer> queue) {
            this.lock = lock;
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        System.out.println("消费者" + Thread.currentThread().getName() + "等待, 队列已空");
                        notEmpty.await();
                    }
                    Integer takeValue = queue.poll();
                    System.out.println("消费者" + Thread.currentThread().getName() + "消费数据：" + takeValue);
                    notFull.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Producer(lock, queue));

        }

        for (int i = 0; i < 6; i++) {
            executorService.execute(new Consumer(lock, queue));
        }
    }
}
