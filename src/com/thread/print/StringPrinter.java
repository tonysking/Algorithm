package com.thread.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程按顺序打印ABC
 */
public class StringPrinter {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;

    private static final int PRINT_COUNT = 3;
    private static int stateCount = 0;


    private static class Printer implements Runnable {

        private ReentrantLock lock;
        private Condition curCondition;
        private Condition nextCondition;

        private int state;
        private String val;

        Printer(ReentrantLock lock,
                Condition curCondition, Condition nextCondition,
                int state, String val) {
            this.lock = lock;
            this.curCondition = curCondition;
            this.nextCondition = nextCondition;
            this.state = state;
            this.val = val;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while (stateCount % 3 != state) {
                        curCondition.await();
                    }
                    System.out.print(val);
                    stateCount++;
                    nextCondition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    public static void testPrinter() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread printA = new Thread(new Printer(lock, conditionA, conditionB, A,"A"));
        Thread printB = new Thread(new Printer(lock, conditionB, conditionC, B,"B"));
        Thread printC = new Thread(new Printer(lock, conditionC, conditionA, C,"C"));

        printA.start();
        printB.start();
        printC.start();
    }

    public static void main(String[] args) throws InterruptedException {
        testPrinter();
    }
}
