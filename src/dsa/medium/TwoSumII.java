package dsa.medium;

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int lowPtr = 0, highPtr = numbers.length - 1;

        while (lowPtr < highPtr) {
            int sum = numbers[lowPtr] + numbers[highPtr];
            if (sum == target)
                return new int[]{lowPtr + 1, highPtr + 1};
            else if (sum < target)
                lowPtr++;
            else highPtr--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumII().twoSum(new int[]{-1, 0}, -1)));
    }
}
