package multithreading.printevenodd;

public class Test {
    public static final Integer MAX_COUNT = 10;
    public static Integer currentCount = 1;
    public final Object lock = new Object();

    public static void main(String[] args) {
        Test test = new Test();
        Thread evenThread = new Thread(() -> test.printEvenOdd(true));
        Thread oddThread = new Thread(() -> test.printEvenOdd(false));

        evenThread.start();
        oddThread.start();
    }

    public void printEvenOdd(boolean isEven) {
        while (currentCount <= MAX_COUNT) {
            synchronized (lock) {
                if ((currentCount % 2 == 0 && !isEven) || (currentCount % 2 != 0 && isEven)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(currentCount);
                currentCount++;
                lock.notify();
            }
        }
    }
}
