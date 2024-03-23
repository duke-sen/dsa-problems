package multithreading.writethreethreadstolist;

import java.util.ArrayList;
import java.util.List;

public class ThreeThreadsWritingToList implements Runnable{
    private static int counter = 0;
    private final int limit;
    private final int threadNumber;

    private final List<Integer> listToWrite;

    public ThreeThreadsWritingToList(int limit, int threadNumber, List<Integer> listToWrite) {
        this.limit = limit;
        this.threadNumber = threadNumber;
        this.listToWrite = listToWrite;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ThreeThreadsWritingToList.class) {
                if (counter > limit)
                    return;
                else if (counter % 3 == threadNumber) {
                    listToWrite.add(counter);
                    counter++;
                    ThreeThreadsWritingToList.class.notifyAll();
                }
                else {
                    try {
                        ThreeThreadsWritingToList.class.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> listToWriteTo = new ArrayList<>();
        new Thread(new ThreeThreadsWritingToList(20, 0, listToWriteTo)).start();
        new Thread(new ThreeThreadsWritingToList(20, 1, listToWriteTo)).start();
        new Thread(new ThreeThreadsWritingToList(20, 2, listToWriteTo)).start();
        listToWriteTo.forEach(System.out::println);
    }
}
