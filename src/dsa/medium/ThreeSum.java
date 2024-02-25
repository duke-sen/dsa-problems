package dsa.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> elements = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates -- what if 2 elements are same?
            if (i == 0 || (nums[i - 1] != nums[i])) {
                int complementRequired = -nums[i];
                int lowPtr = i + 1, highPtr = nums.length - 1;

                while (lowPtr < highPtr) {
                    int currentSum = nums[lowPtr] + nums[highPtr];

                    if (currentSum == complementRequired) {
                        elements.add(List.of(nums[i], nums[lowPtr], nums[highPtr]));

                        // Skip duplicates, given a i, and a match found of j and k, skip all same j
                        while (lowPtr < highPtr && nums[lowPtr] == nums[lowPtr + 1])
                            lowPtr++;

                        // Skip duplicates, given a i, and a match found of j and k, skip all same k
                        while (lowPtr < highPtr && nums[highPtr] == nums[highPtr - 1])
                            highPtr--;
                        lowPtr++;
                        highPtr--;
                    }
                    else if (currentSum < complementRequired)
                        lowPtr++;
                    else highPtr--;
                }
            }
        }
        return elements;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
