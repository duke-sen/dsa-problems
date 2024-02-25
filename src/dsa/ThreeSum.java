package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Problem Link : https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int currentEle = nums[i];
                int leftPtr = i + 1;
                int rightPtr = nums.length - 1;
                int complementRequired = -currentEle;

                while (leftPtr < rightPtr) {
                    int sumOfPtr = nums[leftPtr] + nums[rightPtr];
                    if (sumOfPtr < complementRequired)
                        leftPtr++;
                    else if (sumOfPtr > complementRequired)
                        rightPtr--;
                    else {
                        while (leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr + 1])
                            leftPtr++;
                        while (leftPtr < rightPtr && nums[rightPtr - 1] == nums[rightPtr])
                            rightPtr--;
                        result.add(List.of(nums[i], nums[leftPtr], nums[rightPtr]));
                        leftPtr++;
                        rightPtr--;
                    }
                }
            }
        }
        return result;
    }
}
