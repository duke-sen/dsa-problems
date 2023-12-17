package multithreading.leetcode.printinorder;

public class Foo {
    public final Object lock = new Object();
    public final static String FIRST_STATE = "FIRST";
    public final static String SECOND_STATE = "SECOND";
    public final static String THIRD_STATE = "THIRD";
    public static String currentState = FIRST_STATE;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (lock) {
            while (!currentState.equals(FIRST_STATE)) {
                lock.wait();
            }
            printFirst.run();
            currentState = SECOND_STATE;
            lock.notifyAll();

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        // printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!currentState.equals(SECOND_STATE)) {
                lock.wait();
            }
            printSecond.run();
            currentState = THIRD_STATE;
            lock.notifyAll();
        }

        // printSecond.run() outputs "second". Do not change or remove this line.
        // printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!currentState.equals(THIRD_STATE)) {
                lock.wait();
            }
            printThird.run();
            currentState = FIRST_STATE;
            lock.notifyAll();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        // printThird.run();
    }
}
