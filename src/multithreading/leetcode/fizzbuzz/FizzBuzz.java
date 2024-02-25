package multithreading.leetcode.fizzbuzz;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private int currentCounter = 1;
    private final Object lock = new Object();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (lock) {
            while (currentCounter <= n) {
                if (currentCounter % 3 == 0 && currentCounter % 5 != 0) {
                    printFizz.run();
                    currentCounter++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }

            }

            /*while (!(currentCounter % 3 == 0 && currentCounter % 5 != 0)) {
                lock.wait();
            }

            printFizz.run();
            currentCounter++;
            lock.notifyAll();*/
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (lock) {
            while (currentCounter <= n) {
                if (currentCounter % 3 != 0 && currentCounter % 5 == 0) {
                    printBuzz.run();
                    currentCounter++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
            /*while (!(currentCounter % 3 != 0 && currentCounter % 5 == 0)) {
                lock.wait();
            }
            printBuzz.run();
            currentCounter++;
            lock.notifyAll();*/
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (lock) {
            while (currentCounter <= n) {
                if (currentCounter % 3 == 0 && currentCounter % 5 == 0) {
                    printFizzBuzz.run();
                    currentCounter++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }


            /*while (!(currentCounter % 3 == 0 && currentCounter % 5 == 0)) {
                lock.wait();
            }
            printFizzBuzz.run();
            currentCounter++;
            lock.notifyAll();*/
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while (currentCounter <= n) {
                if (currentCounter % 3 != 0 && currentCounter % 5 != 0) {
                    printNumber.accept(currentCounter);
                    currentCounter++;
                    lock.notifyAll();
                }
                else {
                    lock.wait();
                }
            }
            /*while (!(currentCounter % 3 != 0 && currentCounter % 5 != 0)) {
                lock.wait();
            }
            printNumber.accept(currentCounter);
            currentCounter++;
            lock.notifyAll();*/
        }
    }


    public static void main(String[] args) {
        Runnable fizzRunnable = () -> System.out.println("fizz");
        Runnable buzzRunnable = () -> System.out.println("buzz");
        Runnable fizzBuzzRunnable = () -> System.out.println("fizzbuzz");

        IntConsumer printNumber = System.out::println;
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread fizzThread = new Thread(() -> {
            try {
                fizzBuzz.fizz(fizzBuzzRunnable);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                fizzBuzz.buzz(buzzRunnable);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(fizzBuzzRunnable);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        Thread printNumberThread = new Thread(() -> {
            try {
                fizzBuzz.number(printNumber);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        printNumberThread.start();
    }
}
