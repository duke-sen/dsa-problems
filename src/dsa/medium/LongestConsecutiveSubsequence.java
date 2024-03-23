package dsa.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int ele : nums) {
            numbers.add(ele);
        }

        int longestSubsequenceLength = 0;


        for (int i = 0; i < nums.length; i++) {

            if (!numbers.contains(nums[i] - 1)) {
                int currentNum = nums[i];
                int currentSequenceLength = 1;

                while (numbers.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequenceLength++;
                }
                longestSubsequenceLength = Math.max(longestSubsequenceLength, currentSequenceLength);
            }
        }
        return longestSubsequenceLength;
    }
}
