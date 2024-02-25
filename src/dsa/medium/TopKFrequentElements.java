package dsa.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementsAndPairs = new HashMap<>();
        int[] result = new int[k];

        for (int i = 0 ; i < nums.length ; i++) {
            elementsAndPairs.put(nums[i], elementsAndPairs.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        queue.addAll(elementsAndPairs.entrySet());

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 10, 9, 9, 9, 9, 3, 3, 3, 1, 1, 1, 1, 1, 1, 4, 2, 10, 7, 3, -1};
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums, 3)));
    }
}
