package dsa.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumGreatnessOfAnArray {
    public int maximizeGreatness(int[] nums) {
        Queue<Integer> queueOne = new PriorityQueue<>();
        Queue<Integer> queueTwo = new PriorityQueue<>();
        int count = 0;

        for (int ele : nums) {
            queueOne.add(ele);
            queueTwo.add(ele);
        }

        while (!queueTwo.isEmpty()) {
            Integer currentElementFromQueueOne = queueOne.peek();
            Integer currentElementFromQueueTwo = queueTwo.peek();

            if (currentElementFromQueueTwo <= currentElementFromQueueOne) {
                queueTwo.remove();
            }
            else {
                queueTwo.remove();
                queueOne.remove();
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 1, 3, 1};
        System.out.println(new MaximumGreatnessOfAnArray().maximizeGreatness(nums));
    }
}
