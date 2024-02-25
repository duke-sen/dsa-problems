package dsa.medium;

import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArray = new int[nums.length];
        int[] suffixArray = new int[nums.length];

        prefixArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefixArray[i] = prefixArray[i - 1] * nums[i - 1];
        }

        suffixArray[suffixArray.length - 1] = 1;
        for (int i = suffixArray.length - 2; i >= 0 ; i--) {
            suffixArray[i] = suffixArray[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i] * suffixArray[i];
        }

        return prefixArray;
    }

    public static void main(String[] args) {
        int[] ele = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptItself().productExceptSelf(ele)));
    }
}
