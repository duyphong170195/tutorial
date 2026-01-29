package threads;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class TimeoutDeadlockAvoidance {
    private final ReentrantLock lockA = new ReentrantLock();
    private final ReentrantLock lockB = new ReentrantLock();

    public void task1() {
        try {
            if (lockA.tryLock(500, TimeUnit.MILLISECONDS)) {
                System.out.println("Task1 acquired lockA");
                Thread.sleep(100); // Giả lập xử lý

                if (lockB.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Task1 acquired lockB");
                        System.out.println("Task1 is working...");
                    } finally {
                        lockB.unlock();
                    }
                } else {
                    System.out.println("Task1 could not acquire lockB, avoiding deadlock");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (lockA.isHeldByCurrentThread()) {
                lockA.unlock();
            }
        }
    }

    public void task2() {
        try {
            if (lockB.tryLock(500, TimeUnit.MILLISECONDS)) {
                System.out.println("Task2 acquired lockB");
                Thread.sleep(100); // Giả lập xử lý

                if (lockA.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Task2 acquired lockA");
                        System.out.println("Task2 is working...");
                    } finally {
                        lockA.unlock();
                    }
                } else {
                    System.out.println("Task2 could not acquire lockA, avoiding deadlock");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (lockB.isHeldByCurrentThread()) {
                lockB.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeoutDeadlockAvoidance example = new TimeoutDeadlockAvoidance();

        Thread t1 = new Thread(example::task1);
        Thread t2 = new Thread(example::task2);

        t1.start();
        t2.start();
    }
}
