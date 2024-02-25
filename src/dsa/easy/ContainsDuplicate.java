package dsa.easy;

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }

    public void quickSort(int[] nums, int startIdx, int highIdx) {
        if (startIdx < highIdx) {
            int partitionIdx = partition(nums, startIdx, highIdx);
            quickSort(nums, startIdx, partitionIdx - 1);
            quickSort(nums, partitionIdx + 1, highIdx);
        }
    }

    public int partition(int[] nums, int startIdx, int highIdx) {
        int partitionKey = nums[highIdx];
        int smallEleIdx = startIdx;

        for (int i = startIdx; i < highIdx; i++) {
            if (nums[i] <= partitionKey) {
                swap(nums, smallEleIdx, i);
                smallEleIdx++;
            }
        }
        swap(nums, smallEleIdx, highIdx);
        return smallEleIdx;
    }

    private void swap(int[] nums, int idxOne, int idxTwo) {
        int temp = nums[idxOne];
        nums[idxOne] = nums[idxTwo];
        nums[idxTwo] = temp;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2, -1, 0, 98, -45, 65, 7, 5};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }
}
