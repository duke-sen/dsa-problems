package dsa;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] elements = {1, 1, -1};
        int k = 1;
        System.out.println(new SubArraySumEqualsK().subArraySum(elements, k));
    }

    public int subArraySum(int[] nums, int k) {
        int sum = 0, result = 0;

        Map<Integer, Integer> sumsAndFrequencies = new HashMap<>();
        sumsAndFrequencies.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int elementRequired = sum - k;
            if (sumsAndFrequencies.containsKey(elementRequired))
                result += sumsAndFrequencies.get(elementRequired);
            sumsAndFrequencies.put(sum, sumsAndFrequencies.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
