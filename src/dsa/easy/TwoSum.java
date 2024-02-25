package dsa.easy;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elementAndIndices = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (elementAndIndices.containsKey(compliment))
                return new int[]{i, elementAndIndices.get(compliment)};
            elementAndIndices.put(nums[i], i);
        }
        return new int[]{};
    }
}
