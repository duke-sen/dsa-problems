package multithreading.synchronizethreethreads;

public class SynchronizeThreeThreads implements Runnable{

    private static int counter = 0;
    private final int limit;
    private final int threadNumber;

    public SynchronizeThreeThreads(int limit, int threadNumber) {
        this.limit = limit;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (SynchronizeThreeThreads.class) {
                if (counter > limit)
                    return;
                else if (counter % 3 == threadNumber) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " prints: " + counter);
                    counter++;
                    SynchronizeThreeThreads.class.notifyAll();
                } else {
                    try {
                        SynchronizeThreeThreads.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new SynchronizeThreeThreads(28, 0), "Thread-1");
        Thread t2 = new Thread(new SynchronizeThreeThreads(28, 1), "Thread-2");
        Thread t3 = new Thread(new SynchronizeThreeThreads(28, 2), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
