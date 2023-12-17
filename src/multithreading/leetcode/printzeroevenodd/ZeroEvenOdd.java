package multithreading.leetcode.printzeroevenodd;

import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/print-zero-even-odd/description/
 */
public class ZeroEvenOdd {
    private int n;
    private boolean toPrintZero = true;
    private boolean toPrintOdd = true;
    private static final Object lock = new Object();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!toPrintZero) {
                    lock.wait();
                }
                printNumber.accept(0);
                toPrintZero = false;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (lock) {
                while (toPrintZero || toPrintOdd) {
                    lock.wait();
                }
                printNumber.accept(i);
                toPrintZero = true;
                toPrintOdd = true;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (lock) {
                while (toPrintZero || !toPrintOdd) {
                    lock.wait();
                }
                printNumber.accept(i);
                toPrintZero = true;
                toPrintOdd = false;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntConsumer consumer = System.out::print;
        Integer count = 10;

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(count);

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(consumer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(consumer);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(consumer);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        zeroThread.start();;
        evenThread.start();
        oddThread.start();
    }
}
