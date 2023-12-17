package multithreading.leetcode.printfoobar;

public class PrintFooBarAlternatively {
    private int n;
    private final Object lock = new Object();
    private static boolean isFoo = true;

    public PrintFooBarAlternatively(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!isFoo) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isFoo = false;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (isFoo) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isFoo = true;
                lock.notify();
            }

        }
    }

    public static void main(String[] args) {
        Runnable foo = () -> System.out.println("foo");
        Runnable bar = () -> System.out.println("bar");

        PrintFooBarAlternatively printFooBarAlternatively = new PrintFooBarAlternatively(3);

        Thread thFoo = new Thread(() -> {
            try {
                printFooBarAlternatively.foo(foo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thBar = new Thread(() -> {
            try {
                printFooBarAlternatively.bar(bar);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thFoo.start();
        thBar.start();
    }
}
