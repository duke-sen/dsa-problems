package dsa;

/*
Problem Link : https://leetcode.com/discuss/interview-question/352743/Google-or-Onsite-or-Guaranteed-Binary-Search-Numbers
 */
public class BinarySearchableNumbers {
    public static void main(String[] args) {
        int[] nums1 = {2, 1, 3, 4, 6, 5};
        int[] nums2 = {2, 1, 3, 5, 4, 6};

        System.out.println("Binary searchable elements in nums1: " + countBinarySearchableElements(nums1)); // Output: 3
        System.out.println("Binary searchable elements in nums2: " + countBinarySearchableElements(nums2)); // Output: 6
    }

    private static int countBinarySearchableElements(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isBinarySearchable(nums, i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isBinarySearchable(int[] nums, int index) {
        int target = nums[index];

        // Check if the element is binary searchable
        for (int i = 0; i < nums.length; i++) {
            if (i != index) {
                if ((nums[i] > target && i < index) || (nums[i] < target && i > index)) {
                    return false;
                }
            }
        }

        return true;
    }
}
