package dsa.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, 0, target,
                new LinkedList<>(), result);
        Arrays.sort(candidates);
        return result;
    }

    private void helper(int[] nums, int idx, int currentSum,
                        int target, List<Integer> ele,
                        List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(new ArrayList<>(ele));
            return;
        }
        else if (idx == nums.length || currentSum > target) {
            return;
        }

        ele.add(nums[idx]);
        currentSum += nums[idx];
        helper(nums, idx, currentSum, target, ele, result);

        int elementToBeRemoved = ele.remove(ele.size() - 1);
        currentSum -= elementToBeRemoved;
        helper(nums, idx + 1, currentSum, target, ele, result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort the candidates array
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) { // Base case: if target becomes 0, add combination to result
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            combination.add(candidates[i]); // Include current candidate
            helper(candidates, i, target - candidates[i], combination, result); // Recur with remaining target
            combination.remove(combination.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new CombinationSum().combinationSum(new int[]{5, 2, 3}, 8)
        );
    }
}
