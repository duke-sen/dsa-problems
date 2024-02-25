package dsa.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new LinkedList<>(), result);
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> ele,
                        List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(ele));
            return;
        }
        ele.add(nums[idx]);
        helper(nums, idx + 1, ele, result);
        ele.remove(ele.size() - 1);
        helper(nums, idx + 1, ele, result);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
}
