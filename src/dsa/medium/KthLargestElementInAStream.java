package dsa.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    private Queue<Integer> kLargestElements;
    private int k;
    public KthLargestElementInAStream(int k, int[] nums) {
        kLargestElements = new PriorityQueue<>(k);
        this.k = k;

        for (int ele : nums) {
            add(ele);
        }
    }

    public int add(int val) {
        if (kLargestElements.size() < k) {
            kLargestElements.offer(val);
        }
        else if (val > kLargestElements.peek()) {
            kLargestElements.poll();
            kLargestElements.offer(val);
        }
        return kLargestElements.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream largestElementInAStream
                = new KthLargestElementInAStream(5, new int[]{43, 23, 32, 22, -2, -95, 100});
        System.out.println(largestElementInAStream.add(50));
    }
}
