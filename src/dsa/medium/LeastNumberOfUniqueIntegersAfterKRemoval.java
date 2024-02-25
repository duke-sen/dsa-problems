package dsa.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeastNumberOfUniqueIntegersAfterKRemoval {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> elementsAndFreq = new HashMap<>();

        for(int ele : arr) {
            elementsAndFreq.put(ele, elementsAndFreq.getOrDefault(ele, 0) + 1);
        }
        int totalCount = elementsAndFreq.size();

        // Process the value set, we dont need to care about the keys
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(elementsAndFreq.values());

        // Remove elements till we have enough k
        while (!minHeap.isEmpty() && k != 0) {
            int currentElement = minHeap.poll();
            if (currentElement <= k) {
                totalCount--;
                k -= currentElement;
            }
            else return totalCount;
        }
        return totalCount;
    }

    public static void main(String[] args) {
        // int[] arr = {4,3,1,1,3,3,2};
        int[] arr = {4, 4, 4, 5, 5, 5, 5, 5, 3, 2, 2, 1, 1, 9};
        System.out.println(new LeastNumberOfUniqueIntegersAfterKRemoval().findLeastNumOfUniqueInts(arr, 6));
    }
}
