package dsa;

import java.util.Arrays;

/**
 *Problem Link : https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int probableColumn = calculateProbableRow(matrix, target);

        if (probableColumn < matrix.length)
            return Arrays.binarySearch(matrix[probableColumn], target) >= 0;
        else return false;
    }

    private int calculateProbableRow(int[][] matrix, int target) {
        int ROW_COUNT = matrix.length;
        int COL_COUNT = matrix[0].length;

        int low = 0;
        int high = ROW_COUNT - 1;

        while (low < high) {
            int mid = low + (int)(Math.ceil(high - low)/2.0);
            if (matrix[mid][COL_COUNT - 1] < target) {
                low = mid + 1;
            }
            else if (matrix[mid][COL_COUNT - 1] >= target) {
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int [][] matrix = {{1, 3, 5, 7, 9}};
        int target = 3;
        System.out.println(search2DMatrix.searchMatrix(matrix, target));
    }

}

